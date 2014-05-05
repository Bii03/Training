package com.endava.flow_control;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlowControlTest {

	private final static Logger LOGGER = Logger.getLogger(FlowControlTest.class.getName());
	private final static int SIZE = 3;
	private static Vector<String> vector = new Vector<>(SIZE);
	
	
	public static void writeList() { 
		   PrintWriter out = null;
		    try { 
			out = new PrintWriter(new FileWriter("OutFile.txt")); 
			for (int i = 0; i < SIZE; i++) 
			       out.println("Value at: " + i + " = " + vector.elementAt(i)); 
//		    }catch(FileNotFoundException | IOException e){ // compiler error -> they shouldn't be related to each other
//		    	LOGGER.log(Level.SEVERE, e.getMessage());
			}catch (ArrayIndexOutOfBoundsException  | IOException e) {
		    	LOGGER.log(Level.SEVERE, e.getMessage());
		    } catch (Exception e) {
		 	// do something else. If you want to do logger.error, add another | to 	// the catch above
		    } finally { 
			if (out != null)    { out.close(); }
		    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * First example
		 */

		// one: for (int i = 0; i < 3; i++) {
		// System.out.println("Pass " + i + ": ");
		//
		// }
		//
		// for (int j = 0; j < 100; j++) {
		// if (j == 10) {
		// break one; // compiler error -> missing label
		// }
		// System.out.println(j + " ");
		// }

		/*
		 * Second example
		 */

//		outer: for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				if (j > i) {
//					System.out.println();
//					continue outer;
//				}
//				System.out.print(" " + (i * j));
//			}
//		}
		
		vector.add("lala");
		vector.add("aaa");
		writeList();

	}

}
