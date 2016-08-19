package com.msky.mvptest.Model.Bean;

/**
 * Created by AIRY on 18/8/2016.
 */

public class Person {
    private String name;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public Person(){

    }
    public Person(String name, String sex,int id){

        this.name=name;
        this.sex=sex;
        this.id=id;

    }



}
