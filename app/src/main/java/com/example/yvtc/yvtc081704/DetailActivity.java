package com.example.yvtc.yvtc081704;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yvtc.yvtc081704.data.Student;
import com.example.yvtc.yvtc081704.data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        Intent it = getIntent();
        int ID = it.getIntExtra("ID", 0);
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        Student s = dao.getOneStudent(ID);
        tv1.setText(String.valueOf(s.ID));
        tv2.setText(s.name);
        tv3.setText(s.tel);
    }
}
