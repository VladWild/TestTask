package com.vg.testtask.processing;

import com.vg.testtask.data.processing.InfoMethod;
import com.vg.testtask.data.reader.DataCall;

import java.util.List;
import java.util.Map;

public interface DataProcessing {
    List<InfoMethod> getInfoMethods(Map<String, List<DataCall>> data);
}
