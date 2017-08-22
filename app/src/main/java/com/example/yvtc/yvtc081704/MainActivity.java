package com.example.yvtc.yvtc081704;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yvtc.yvtc081704.data.*;

import com.example.yvtc.yvtc081704.data.StudentDAOMemoryImpl;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String data[];
    ArrayAdapter adapter;
    Student[] students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        students = dao.getAllStudents();
        for (Student s : students)
        {
            Log.d("DAO", s.toString());
        }
        data = new String[students.length];
        int i;
        for (i=0;i<students.length;i++)
        {
            data[i] = students[i].name;
        }
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int ID = students[position].ID;
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("ID", ID);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
