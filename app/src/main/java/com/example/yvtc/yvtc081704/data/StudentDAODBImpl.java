package com.example.yvtc.yvtc081704.data;

import android.content.Context;

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

    }

    @Override
    public Student[] getAllStudents() {
        return new Student[0];
    }

    @Override
    public Student getOneStudent(int ID) {
        return null;
    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void delete(Student s) {

    }
}
