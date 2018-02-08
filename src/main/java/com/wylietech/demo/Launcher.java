package com.wylietech.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {

    private static Logger logger = LoggerFactory.getLogger("LAUNCHER");

    /**
     * Entry point
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        logger.info("Hello World");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting Down");
            System.out.println("Shutting Down");
            System.out.flush();
        }));

        LogTest.test();
        logger.info("Waiting for shutdown");

        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException ex) {

        }
    }


}
