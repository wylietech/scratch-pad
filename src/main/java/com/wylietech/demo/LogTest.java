package com.wylietech.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class LogTest {

    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void test() {

        logger.debug("Stuff happened");
        logger.debug("Fred said to {} that I should {}", "j", "k");

    }
}
