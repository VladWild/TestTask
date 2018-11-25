package com.vg.testtask.reports;

import com.vg.testtask.data.processing.InfoMethod;

import java.util.List;

public interface Report {
    String getReport(List<InfoMethod> infoMethods);
}
