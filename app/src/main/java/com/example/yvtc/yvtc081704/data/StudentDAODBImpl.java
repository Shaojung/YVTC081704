package com.example.yvtc.yvtc081704.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by yvtc on 2017/8/23.
 */

public class StudentDAODBImpl implements StudentDAO {

    MyHelper helper;
    public StudentDAODBImpl(Context context)
    {
        helper = new MyHelper(context);
    }

    @Override
    public void add(Student s) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", s.name);
        cv.put("tel", s.tel);
        db.insert("phone", null, cv);
        db.close();
    }

    @Override
    public Student[] getAllStudents() {
        ArrayList<Student> mylist = new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();
        // Cursor c = db.rawQuery("Select * from phone", null);
        Cursor c = db.query("phone", new String[] {"id", "name", "tel"}, null, null , null, null, "id desc");

        while (c.moveToNext())
        {
            mylist.add(new Student(c.getInt(0), c.getString(1), c.getString(2)));
        }
        c.close();
        db.close();
        return mylist.toArray(new Student[0]);
    }

    @Override
    public Student getOneStudent(int ID) {
        SQLiteDatabase db = helper.getWritableDatabase();
        // Cursor c = db.rawQuery("Select * from phone", null);

        Cursor c = db.query("phone", new String[] {"id", "name", "tel"}, "id=?", new String[] {String.valueOf(ID)} , null, null, null);
        if (c.moveToNext())
        {
            return new Student(ID, c.getString(1), c.getString(2));
        }
        else
        {
            return null;
        }

    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void delete(Student s) {

    }
}
