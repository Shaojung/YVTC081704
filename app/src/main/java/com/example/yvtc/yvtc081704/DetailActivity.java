package com.example.yvtc.yvtc081704;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yvtc.yvtc081704.data.Student;
import com.example.yvtc.yvtc081704.data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = getIntent();
        int ID = it.getIntExtra("ID", 0);
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        Student s = dao.getOneStudent(ID);

    }
}
