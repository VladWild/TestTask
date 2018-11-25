package com.vg.testtask.readers;

import com.vg.testtask.data.reader.DataLine;
import com.vg.testtask.data.reader.DataCall;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleReader implements Reader {
    private static final String FORMAT_DATE = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2},\\d{3}";
    private static final String FORMAT_ENTRY = "entry with \\([a-z,A-Z]+:[0-9]+";
    private static final String FORMAT_EXIT = "exit with \\([a-z,A-Z]+:[0-9]+";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss,SSS";

    private static final String OPEN_BRACKET = "(";
    private static final String COLON = ":";

    private static final int SIZE_LIST = 2900;

    private Pattern pDate = Pattern.compile(FORMAT_DATE);
    private Pattern pEntry = Pattern.compile(FORMAT_ENTRY);
    private Pattern pExit = Pattern.compile(FORMAT_EXIT);
    private DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    private Map<String, List<DataCall>> data = new HashMap<>();
    private String path;

    public SimpleReader(String path) {
        this.path = path;
    }

    private boolean isTimeFind(Matcher mDate){
        return mDate.find();
    }

    private boolean isEntryFind(Matcher mEntry){
        return mEntry.find();
    }

    private boolean isExitFind(Matcher mExit){
        return mExit.find();
    }

    private DataLine readData(String time, String substring) throws ParseException {
        Date date = dateFormat.parse(time);
        String nameMethod = substring.substring(substring.indexOf(OPEN_BRACKET) + 1, substring.indexOf(COLON));
        int id = Integer.valueOf(substring.substring(substring.indexOf(COLON) + 1));

        return new DataLine(date, nameMethod, id);
    }

    private void saveDataEntry(DataLine dataLine) {
        if (data.containsKey(dataLine.getNameMethod())) {
            List<DataCall> dataCalls = data.get(dataLine.getNameMethod());
            dataCalls.add(new DataCall(dataLine.getDate(), dataLine.getId()));
        } else {
            List<DataCall> list = new ArrayList<>(SIZE_LIST);
            list.add(new DataCall(dataLine.getDate(), dataLine.getId()));
            data.put(dataLine.getNameMethod(), list);
        }
    }

    private void saveDataExit(DataLine dataLine) {
        if (data.containsKey(dataLine.getNameMethod())){
            List<DataCall> dataCalls = data.get(dataLine.getNameMethod());
            dataCalls.forEach(dataSave -> {
                if (dataSave.getId() == dataLine.getId()){
                    dataSave.setDateEnd(dataLine.getDate());
                }
            });
        }
    }

    private void controller(String line) throws ParseException {
        Matcher mDate = pDate.matcher(line);
        if (isTimeFind(mDate)) {

            Matcher mEntry = pEntry.matcher(line);
            if (isEntryFind(mEntry)){
                DataLine dataLine = readData(mDate.group(), mEntry.group());
                saveDataEntry(dataLine);
            }

            Matcher mExit = pExit.matcher(line);
            if (isExitFind(mExit)){
                DataLine dataLine = readData(mDate.group(), mExit.group());
                saveDataExit(dataLine);
            }
        }
    }

    @Override
    public Map<String, List<DataCall>> getData() throws IOException, ParseException {
        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while (Objects.nonNull(line = br.readLine())){
                controller(line);
            }
        }

        return data;
    }
}
