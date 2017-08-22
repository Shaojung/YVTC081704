package com.example.yvtc.yvtc081704.data;

import java.util.ArrayList;

/**
 * Created by yvtc on 2017/8/22.
 */

public class StudentDAOFileImpl implements StudentDAO {
    public static ArrayList<Student> mylist = new ArrayList();
    public StudentDAOFileImpl()
    {
        // 讀取檔案，放到 mylist
    }

    @Override
    public void add(Student s) {
        // mylist 新增一筆資料，然後存檔
    }

    @Override
    public Student[] getAllStudents() {
        // 回傳 mylist
        return new Student[0];
    }

    @Override
    public Student getOneStudent(int ID) {
        // 回傳一筆資料
        return null;
    }

    @Override
    public void update(Student s) {
        // 更新 mylist 然後存檔.
    }

    @Override
    public void delete(Student s) {
        //  刪除 mylist 當中一筆資料，然後存檔.
    }
}
