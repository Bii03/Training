package com.endava.generics.Generics;

import org.slf4j.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Logger logger = LoggerFactory.getLogger(App.class); 
    	logger.trace("Trace message");
    	logger.debug("Debug message");
    	logger.info("Info message");
    	logger.warn("Warn message");
    	logger.error("Error message");
    }
}
