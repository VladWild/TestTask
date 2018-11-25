package com.vg.testtask.processing;

import com.vg.testtask.data.processing.InfoMethod;
import com.vg.testtask.data.reader.DataCall;
import com.vg.testtask.processing.comparators.DateCompare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleDataProcessing implements DataProcessing {
    private DateCompare dateCompare;

    private List<InfoMethod> dataMethods = new ArrayList<>();

    public SimpleDataProcessing(DateCompare dateCompare){
        this.dateCompare = dateCompare;
    }

    private DataCall getMinDataCall(List<DataCall> calls){
        return calls.stream().min(dateCompare).get();
    }

    private DataCall getMaxDataCall(List<DataCall> calls){
        return calls.stream().max(dateCompare).get();
    }

    private long getTimeWork(DataCall dataCall){
        return dataCall.getDateEnd().getTime() -
                dataCall.getDateBegin().getTime();
    }

    private double getMeanTimeWork(List<DataCall> calls){
        return calls.stream().mapToDouble(call ->
                call.getDateEnd().getTime() - call.getDateBegin().getTime())
                .sum() / calls.size();
    }

    private void saveDataMethod(String name, List<DataCall> calls){
        InfoMethod infoMethod = new InfoMethod();

        infoMethod.setNameMethod(name);
        infoMethod.setCountCall(calls.size());
        infoMethod.setMinTime(getTimeWork(getMinDataCall(calls)));

        DataCall dataCallMax =  getMaxDataCall(calls);
        infoMethod.setMaxTime(getTimeWork(dataCallMax));
        infoMethod.setIdMaxTime(dataCallMax.getId());

        infoMethod.setMeanTime(getMeanTimeWork(calls));

        dataMethods.add(infoMethod);
    }

    @Override
    public List<InfoMethod> getInfoMethods(Map<String, List<DataCall>> data) {
        data.forEach(this::saveDataMethod);
        return dataMethods;
    }
}


