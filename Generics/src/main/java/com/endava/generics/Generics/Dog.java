package com.endava.generics.Generics;

import java.util.ArrayList;

public class  Dog <T> {
	
	private T child;
	
	
	/**
	 * This is not ok since type erasure will automatically consider T as object
	 */
	public Dog(){
		
		child = new T();
		
		
	}
	
	
	/**
	 * To solve the previous problem, one can use reflection.
	 * For instance, one could give Bichon.class as a parameter
	 * @param childType
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Dog(Class<T> childType) throws InstantiationException, IllegalAccessException{
		child = childType.newInstance();
	}
	
	public void bark(){
		
	}
}
