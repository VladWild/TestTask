package com.vg.testtask;

import com.vg.testtask.services.ServiceInfoLog;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.ParseException;

public class TestTask {
    private static final Logger logger = Logger.getLogger(TestTask.class);

    private void run(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("context.xml");
        ServiceInfoLog serviceInfoLog = (ServiceInfoLog) ac.getBean("serviceInfoLog");

        try {
            serviceInfoLog.execute();
        } catch (IOException e) {
            logger.error("Ошибка чтения данных: " + e.toString());
        } catch (ParseException e) {
            logger.error("Ошибка парсинга времени: " + e.toString());
        }
    }

    public static void main(String[] args) {
        TestTask testTask = new TestTask();
        testTask.run();
    }
}



