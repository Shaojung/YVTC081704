package com.example.yvtc.yvtc081704;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yvtc.yvtc081704.data.Student;
import com.example.yvtc.yvtc081704.data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {
    TextView tv1;
    EditText edName, edTel;
    int ID;
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv1 = (TextView) findViewById(R.id.textView);
        edName = (EditText) findViewById(R.id.edName);
        edTel = (EditText) findViewById(R.id.edTel);
        Intent it = getIntent();
        ID = it.getIntExtra("ID", 0);
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        s = dao.getOneStudent(ID);
        tv1.setText(String.valueOf(s.ID));
        edName.setText(s.name);
        edTel.setText(s.tel);
    }
    public void clickUpdate(View v)
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        s.name = edName.getText().toString();
        s.tel = edTel.getText().toString();
        dao.update(s);
        finish();
    }
    public void clickDelete(View v)
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.delete(s);
        finish();
    }
}
