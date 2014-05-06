package com.endava.generics.Generics;

public class ErasureExample {
	
	
	/**
	 * The compiler reduces all to Object, due to type erasure
	 * @param dog
	 */
	public static <T> void barking(T dog){
		dog.bark();
	}
}
