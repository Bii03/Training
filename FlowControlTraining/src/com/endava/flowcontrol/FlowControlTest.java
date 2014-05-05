package com.endava.flowcontrol;

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
		
		
		/*
		 * Third example
		 */
//		vector.add("lala");
//		vector.add("aaa");
//		writeList();
		
		
		
		/*
		 * Fourth example
		 */
//		System.out.println(FinallyDemo.method1());
//		FinallyDemo.method2();
		
		
		
		/*
		 * Fifth example
		 */
		
		int a[] = new int[2];
	      try{
	         System.out.println("Access element three :" + a[3]);
	      }catch(ArrayIndexOutOfBoundsException e){
	         System.out.println("Exception thrown  :" + e);
	         throw new RuntimeException("New exception");
	      }
	      finally{
	         a[0] = 6;
	         System.out.println("First element value: " +a[0]);
	         System.out.println("The finally statement is executed");
	      }

	}

}
