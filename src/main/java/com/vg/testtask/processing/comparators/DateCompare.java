package com.vg.testtask.processing.comparators;

import com.vg.testtask.data.reader.DataCall;

import java.util.Comparator;

public class DateCompare implements Comparator<DataCall> {
    @Override
    public int compare(DataCall o1, DataCall o2) {
        long timeWorkO1 = o1.getDateEnd().getTime() - o1.getDateBegin().getTime();
        long timeWorkO2 = o2.getDateEnd().getTime() - o2.getDateBegin().getTime();
        return (int) (timeWorkO1 - timeWorkO2);
    }
}
