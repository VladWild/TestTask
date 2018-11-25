package com.vg.testtask.readers;

import com.vg.testtask.data.reader.DataSave;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface Reader {
    Map<String, List<DataSave>> getData() throws IOException, ParseException;
}
