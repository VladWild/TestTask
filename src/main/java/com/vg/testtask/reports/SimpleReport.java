package com.vg.testtask.reports;

import com.vg.testtask.data.processing.InfoMethod;

import java.util.List;

public class SimpleReport implements Report {
    private static final String LINE = "-------------------------------------------------------------------------------------------------------------------------------------------------\n";
    private static final String HEAD = "| #  | Имя метода       | Количество вызовов | Минимальное время (мс) | Максимальное время (мс) | Среднее время (мс) | ID самого долгого вызова |\n";
    private static final String FORMAT_INFO = "| %-2d | %-16s | %-18d | %-22d | %-23d | %-18.3f | %-24d |\n";

    private StringBuilder report = new StringBuilder();
    private int i = 1;

    private void printInfoMethod(InfoMethod infoMethod){
        report.append(String.format(FORMAT_INFO, i++,
                infoMethod.getNameMethod(),
                infoMethod.getCountCall(),
                infoMethod.getMinTime(),
                infoMethod.getMaxTime(),
                infoMethod.getMeanTime(),
                infoMethod.getIdMaxTime()));
    }

    @Override
    public String getReport(List<InfoMethod> infoMethods) {
        report.append(LINE);
        report.append(HEAD);
        report.append(LINE);
        infoMethods.forEach(this::printInfoMethod);
        report.append(LINE);
        return report.toString();
    }
}


