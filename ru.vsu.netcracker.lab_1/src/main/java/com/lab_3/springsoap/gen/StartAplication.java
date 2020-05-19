package com.lab_3.springsoap.gen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class StartAplication {
    public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        SpringApplication.run(StartAplication.class, args);
        logger.info("App was started");
    }
}