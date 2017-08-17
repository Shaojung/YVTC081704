package com.example.yvtc.yvtc081704;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yvtc.yvtc081704.data.*;

import com.example.yvtc.yvtc081704.data.StudentDAOMemoryImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        Student stu1 = new Student(1, "Bob", "123123");
        Student stu2 = new Student(2, "Jack", "345345");
        dao.add(stu1);
        dao.add(stu2);

        Student[] students = dao.getAllStudents();
        for (Student s : students)
        {
            Log.d("DAO", s.toString());
        }
    }
}
