package com.vg.testtask.services;

import com.vg.testtask.data.reader.DataSave;
import com.vg.testtask.printers.Printer;
import com.vg.testtask.processing.DataProcessing;
import com.vg.testtask.readers.Reader;
import com.vg.testtask.reports.Report;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public class ServiceInfoLog {
    private Reader reader;
    private DataProcessing dp;
    private Report report;
    private Printer printer;

    private static final Logger logger = Logger.getLogger(ServiceInfoLog.class);

    public ServiceInfoLog(Reader reader, DataProcessing dp, Report report, Printer printer) {
        this.reader = reader;
        this.dp = dp;
        this.report = report;
        this.printer = printer;
    }

    public void execute() throws IOException, ParseException {
        logger.info("Получение данных из log файла");
        Map<String, List<DataSave>> data = reader.getData();

        logger.info("Обработка полученных данных");


    }
}
