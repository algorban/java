package org.gorbano.logsender.appender;


import org.apache.log4j.Logger;

/**
 * Created by Oleksandr_Gorban on 7/23/2017.
 */
public class Application {
    private static final Logger logger = Logger.getLogger(Application.class);
    public static void main(String[] args) {
        logger.info("This is info message");
        logger.debug("This is debug message");
        logger.error("This is error message");
    }

}
