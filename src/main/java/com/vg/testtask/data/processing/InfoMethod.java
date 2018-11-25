package com.vg.testtask.data.processing;

import lombok.ToString;

@ToString
public class InfoMethod {
    private String nameMethod;
    private int countCall;
    private long minTime;
    private long maxTime;
    private double meanTime;
    private int idMaxTime;

    public String getNameMethod() {
        return nameMethod;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
    }

    public int getCountCall() {
        return countCall;
    }

    public void setCountCall(int countCall) {
        this.countCall = countCall;
    }

    public long getMinTime() {
        return minTime;
    }

    public void setMinTime(long minTime) {
        this.minTime = minTime;
    }

    public long getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(long maxTime) {
        this.maxTime = maxTime;
    }

    public double getMeanTime() {
        return meanTime;
    }

    public void setMeanTime(double meanTime) {
        this.meanTime = meanTime;
    }

    public int getIdMaxTime() {
        return idMaxTime;
    }

    public void setIdMaxTime(int idMaxTime) {
        this.idMaxTime = idMaxTime;
    }
}
