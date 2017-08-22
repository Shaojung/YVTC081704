package com.example.yvtc.yvtc081704.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by yvtc on 2017/8/22.
 */

public class StudentDAOFileImpl implements StudentDAO {
    public static ArrayList<Student> mylist = new ArrayList();
    File dataFile;
    public StudentDAOFileImpl(Context context)
    {
        // 讀取檔案，放到 mylist
        dataFile = new File(context.getFilesDir() + File.separator + "data.json");
        if (dataFile.exists())
        {
            try {
                FileReader fr = new FileReader(dataFile);
                BufferedReader br = new BufferedReader(fr);
                String str = br.readLine();
                Gson gson = new Gson();
                Log.d("JSON", str);
                Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
                mylist = gson.fromJson(str, listType);
                br.close();
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void saveFile()
    {
        try {
            FileWriter fw = new FileWriter(dataFile);
            BufferedWriter bw = new BufferedWriter(fw);
            Gson gson = new Gson();
            String json = gson.toJson(mylist);
            bw.write(json);
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(Student s) {
        // mylist 新增一筆資料，然後存檔
        mylist.add(s);
        saveFile();
    }

    @Override
    public Student[] getAllStudents() {
        // 回傳 mylist
        return mylist.toArray(new Student[0]);
    }

    @Override
    public Student getOneStudent(int ID) {
        // 回傳一筆資料
        for (Student s : mylist)
        {
            if (s.ID == ID)
            {
                return s;
            }
        }
        return null;
    }

    @Override
    public void update(Student s) {
        // 更新 mylist 然後存檔.
        for (Student t : mylist)
        {
            if (t.ID == s.ID)
            {
                t.name = s.name;
                t.tel = s.tel;
            }
        }
        saveFile();
    }

    @Override
    public void delete(Student s) {
        //  刪除 mylist 當中一筆資料，然後存檔.
        int i;
        for (i=0;i<mylist.size();i++)
        {
            if (mylist.get(i).ID == s.ID)
            {
                mylist.remove(i);
                saveFile();
                return;
            }
        }
    }
}
