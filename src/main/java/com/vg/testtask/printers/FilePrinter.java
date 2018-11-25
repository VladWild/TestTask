package com.vg.testtask.printers;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FilePrinter implements Printer {
    private static final String PATH_FILE = "src\\main\\resources\\output";

    private final static Logger logger = Logger.getLogger(FilePrinter.class);

    @Override
    public void print(String text) throws IOException {
        logger.info("Output text in file");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(PATH_FILE), StandardCharsets.UTF_8))) {
            writer.write(text.toCharArray());
        }
    }
}

