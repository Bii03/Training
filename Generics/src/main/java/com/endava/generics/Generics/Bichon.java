package com.endava.generics.Generics;

import java.util.List;

public class Bichon extends Dog{
	
	
	/**
	 * The compiler doesn't know the type that extends the Dog class, thus 
	 * it won't allow one to add a Dog object because it is not sure whether
	 * dog is instanceof the type given to the list
	 * @param dogs
	 * @param dog
	 */
	public void addDogs(List<? extends Dog> dogs, Dog dog){
		dogs.add(dog);
	}
	
	
	/**
	 * This time, the compiler is ok with adding a Dog object since Dog is instanceof of
	 * all the classes that are super for the Dog class
	 * @param animals
	 * @param dog
	 */
	public void addAnimals(List<? super Dog> animals, Dog dog){
		animals.add(dog);
	}

}
