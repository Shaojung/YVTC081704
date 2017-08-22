package com.example.yvtc.yvtc081704;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.yvtc.yvtc081704.data.Student;
import com.example.yvtc.yvtc081704.data.StudentDAOFileImpl;
import com.example.yvtc.yvtc081704.data.StudentDAOMemoryImpl;

public class AddActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
    }
    public void clickAdd(View v)
    {
        StudentDAOFileImpl dao = new StudentDAOFileImpl(AddActivity.this);
        dao.add(new Student(Integer.valueOf(ed1.getText().toString()), ed2.getText().toString(), ed3.getText().toString()));
        finish();
    }
}
