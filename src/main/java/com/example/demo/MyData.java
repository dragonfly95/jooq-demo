package com.example.demo;

import java.util.List;

public class MyData {

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }


    @Override
    public String toString() {
        return "MyData{" +
                "list=" + list +
                '}';
    }

    public int sum(int i, int i1) {
        return i + i1;
    }
}
