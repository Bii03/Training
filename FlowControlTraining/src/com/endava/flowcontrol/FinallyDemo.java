package com.endava.flowcontrol;

public class FinallyDemo {

	public static int method1() {
        try {
            return 2;
        } finally {
            System.out.println("Executing finally block in method1()");
        }
    }

    public static void method2() {
        try {
            throw new RuntimeException("Unchecked error");
        } finally {
            System.out.println("Executing finally block in method2()");
        }
    }
    
    static int method3(){
    	try {
            return 1;
        } finally {
            return 2;
        }

    }
}
