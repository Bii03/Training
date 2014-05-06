package com.endava.generics.Generics;

import java.util.ArrayList;

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
    	logger.info("Info message");
    	
    	//Not compiling
    	ArrayList<Dog> dogs = new ArrayList<Bichon>();
    	
    	//the class itself is also taken into consideration
    	ArrayList<? super Bichon> bichons = new ArrayList<Bichon>();
    	ArrayList<? extends Dog> doggies = new ArrayList<Dog>();

    	
    	

    }
}
