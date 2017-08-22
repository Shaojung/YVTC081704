package com.example.yvtc.yvtc081704.data;

/**
 * Created by yvtc on 2017/8/17.
 */

public interface StudentDAO {
    public void add(Student s);
    public Student[] getAllStudents();
    public Student getOneStudent(int ID);
    public void update(Student s);
    public void delete(Student s);
}
