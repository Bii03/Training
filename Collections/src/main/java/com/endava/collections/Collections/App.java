package com.endava.collections.Collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;


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
        
        
        //Using the additional methods introduced by listIterator
        ListIterator<String> listIterator = a.listIterator();
        System.out.println(listIterator.nextIndex());
        listIterator.next();
        listIterator.add("blueberry");
        //After the addition, the cursor jumps after the recently introduced element
        System.out.println(listIterator.nextIndex());
        String oldValue = listIterator.next();
        System.out.println(oldValue);
        //It still returns orange, even though one could say that it should return blueberry
        System.out.println(listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.nextIndex());
        listIterator.set("strawberry");
       
        System.out.println(a);
        
        
        
        //The elements of a TreeSet should implement Comparable; the elements of a HashSet should override hashCode()
        //In this case, they behave the same since both of them depend on equals and hashCode overridden by String
        Set<String> treeSet = new TreeSet<>(); 
        treeSet.add("Clara"); 
        treeSet.add("Gene"); 
        treeSet.add("Bernadine"); 
        treeSet.add("Elizabeth"); 
        treeSet.add("Gene"); 
        System.out.println("Tree Set: "+treeSet);
        
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Clara");
        hashSet.add("Gene");
        hashSet.add("Bernadine");
        hashSet.add("Elizabeth");
        hashSet.add("Gene");
        System.out.println("HashSet: "+hashSet);
        
        
    }
}
