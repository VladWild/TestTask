package com.vg.testtask.data.reader;

import java.util.Date;

public class DataLine {
    private Date date;
    private String nameMethod;
    private int id;

    public DataLine(Date date, String nameMethod, int id) {
        this.date = date;
        this.nameMethod = nameMethod;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getNameMethod() {
        return nameMethod;
    }

    public int getId() {
        return id;
    }
}
