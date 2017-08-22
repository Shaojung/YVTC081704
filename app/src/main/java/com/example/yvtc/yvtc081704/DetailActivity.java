package com.example.yvtc.yvtc081704;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yvtc.yvtc081704.data.Student;
import com.example.yvtc.yvtc081704.data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        Intent it = getIntent();
        ID = it.getIntExtra("ID", 0);
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        Student s = dao.getOneStudent(ID);
        tv1.setText(String.valueOf(s.ID));
        tv2.setText(s.name);
        tv3.setText(s.tel);
    }
    public void clickEdit(View v)
    {
        Intent it = new Intent(DetailActivity.this, EditActivity.class);
        it.putExtra("ID", ID);
        startActivity(it);
    }
}
