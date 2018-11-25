package com.vg.testtask.readers;

import com.vg.testtask.data.reader.DataCall;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface Reader {
    Map<String, List<DataCall>> getData() throws IOException, ParseException;
}
