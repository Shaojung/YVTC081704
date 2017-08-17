package com.example.yvtc.yvtc081704.data;

/**
 * Created by yvtc on 2017/8/17.
 */

public class Student {
    public int ID;
    public String name;
    public String tel;
    public Student(int ID, String name, String tel)
    {
        this.ID = ID;
        this.name = name;
        this.tel = tel;
    }
    public String toString()
    {
        return ID + "," + name + "," + tel;
    }
}
