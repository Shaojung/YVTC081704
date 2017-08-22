package com.example.yvtc.yvtc081704.data;

import java.util.ArrayList;

/**
 * Created by yvtc on 2017/8/17.
 */

public class StudentDAOMemoryImpl implements StudentDAO {
    public static ArrayList<Student> mylist = new ArrayList();
    public StudentDAOMemoryImpl()
    {
    }

    @Override
    public void add(Student s) {
        mylist.add(s);
    }

    @Override
    public Student[] getAllStudents() {
        return mylist.toArray(new Student[0]);
    }

    @Override
    public Student getOneStudent(int ID) {
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
        for (Student t : mylist)
        {
            if (t.ID == s.ID)
            {
                t.name = s.name;
                t.tel = s.tel;
            }
        }
    }
}
