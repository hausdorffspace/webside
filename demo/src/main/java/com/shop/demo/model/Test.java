package com.shop.demo.model;

import java.util.List;

public class Test {
    private String name;
    private String lastName;
    private List<Integer> list;


    public Test(String name, String lastName, List<Integer> list) {
        this.name = name;
        this.lastName = lastName;
        this.list = list;
    }


    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
