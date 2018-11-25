package com.vg.testtask.data.reader;

import lombok.ToString;

import java.util.Date;

@ToString
public class DataSave {
    private Date dateBegin;
    private Date dateEnd;
    private int id;

    public DataSave(Date dateBegin, int id) {
        this.dateBegin = dateBegin;
        this.id = id;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }
}
