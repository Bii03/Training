package com.endava.collections.Collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
        Collection<String> collection = new ArrayList<>();
        collection.add(new String("a"));
        collection.add(new String("b"));
        String strObject1 = new String("abc");
        collection.add(strObject1);
        String strObject2 = "lala";
        collection.add(strObject2);
 
        //Using the conversion constructor-all collections can take the elements from another one, regardless of its implementation
        List<String> listCollection1 = new ArrayList<>(collection);
        System.out.println("listCollection1 contains all the elements from collection: "+listCollection1.containsAll(collection));
        
        List<String> listCollection2 = new ArrayList<>();
        listCollection2.add(new String("a"));
        listCollection2.add(new String("b"));
        listCollection2.add(strObject1);
        listCollection2.add(strObject2);
        
        //This is true because containsAll uses equals, which, in case of String, compares the values, not the references
        System.out.println("listCollection2 contains all the elements from collection: "+listCollection2.containsAll(collection));
        
        
        //Retain all - removes from listCollection2 all of its elements that are not contained in listCollection3
        List<String> listCollection3 = new ArrayList<>();
        listCollection3.add(new String("a"));
        listCollection3.add(new String("b"));
        listCollection3.add(strObject1);
        listCollection2.retainAll(listCollection3);
        System.out.println("After retain all wrt to listCollection3, listCollection2 is now: "+ listCollection2);
        
        
        //Safely removing elements using the iterator
        Iterator<String> iteratorForList2 = listCollection2.iterator();
        while(iteratorForList2.hasNext()){
        	String stringToRemove = iteratorForList2.next();
        	if(stringToRemove.equals(strObject1))
        		iteratorForList2.remove();
        }
        System.out.println("After removing an element from listCollection2 by using the iterator: "+ listCollection2);
        
        
        //Trying to remove elements using for-each => not gonna work
        try{
        	for(String strElement: listCollection3){
            	if(strElement.equals(strObject1)){
            		listCollection3.remove(strElement);
            	}
            }
        }catch(RuntimeException e){
        	System.out.println("One cannot remove an element from a collection when using foreach");
        }
        
        
        
        //This is true because b is empty => there is nothing in b that is not in a
        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        a.add("apple");
        a.add("orange");
        System.out.println("Contains all between an empty list and a non-empty list: "+ a.containsAll(b));
    }
}
