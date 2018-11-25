package com.vg.testtask.printers;

import org.apache.log4j.Logger;

public class ConsolePrinter implements Printer{
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
