package com.wylietech.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

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

        get("/hello", (req, res) -> "Hello World");

        get( "/goodbye", (r,q) -> {
            return "fluff";
        });

    }


}
