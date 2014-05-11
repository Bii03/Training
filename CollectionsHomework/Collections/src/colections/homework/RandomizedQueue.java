package colections.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] queue;

	private int queueCapacity;

	private int currentQueueSize;

	private Random randomGenerator;

	public RandomizedQueue() {
//capacitatea initiala poti sa o pui ceva mai mare
		queueCapacity = 1;
		queue = (Item[]) new Object[queueCapacity];
		randomGenerator = new Random();
	}

	public boolean isEmpty() {
		return currentQueueSize == 0;
	}

	public int size() {
		return currentQueueSize;
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException(
					"You are not allowed to enqueue null items");
		}

		if (currentQueueSize + 1 > queueCapacity) {
			increaseQueueCapacity();
		}

		queue[currentQueueSize++] = item;
	}

// aici e un mic bug pentru ca elementul sters nu este acelasi cu elementul returnat.
	public Item dequeue() {
		if (this.isEmpty()) {
			throw new NoSuchElementException(
					"You are not allowed to dequeue. The queue is empty.");
		}

		int indexFromWhereToDequeue = randomGenerator.nextInt(currentQueueSize);
		Item itemToDequeue = queue[indexFromWhereToDequeue];
		queue[indexFromWhereToDequeue] = queue[--currentQueueSize];
		queue[currentQueueSize] = null;

		if (currentQueueSize < queueCapacity / 4) {
			decreaseQueueCapacity();
		}

		return itemToDequeue;

	}
	
// colectia nu pune la dispozitie metoda asta, deci asta inseamna ca metoda trebuie sa fie....?
	public void increaseQueueCapacity() {
		queueCapacity *= 2;
		Item[] resizedQueue = (Item[]) new Object[queueCapacity];
		int offsetIndex = 0;
		
		for (Item i : queue) {
			resizedQueue[offsetIndex++] = i;
		}
		queue = resizedQueue;
	}

// colectia nu pune la dispozitie metoda asta, deci asta inseamna ca metoda trebuie sa fie....?
	public void decreaseQueueCapacity() {
		queueCapacity /= 2;
		Item[] resizedQueue = (Item[]) new Object[queueCapacity];
		int offsetIndex = 0;
		
		for (Item i : queue) {
			resizedQueue[offsetIndex++] = i;
		}
		queue = resizedQueue;

	}

	public Item sample() {
		if (this.isEmpty()) {
			throw new NoSuchElementException(
					"You are not allowed to sample. The queue is empty.");
		}

		return queue[randomGenerator.nextInt(currentQueueSize)];
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item> {

		private int offsetIndex;
		private int iteratedItemsCount; // unde initializezi proprietatea asta? e mai clar
						//cand stii de la ce valoare pleci


		public RandomizedQueueIterator() {
			// TODO Auto-generated constructor stub
			offsetIndex = randomGenerator.nextInt(currentQueueSize);
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return iteratedItemsCount < currentQueueSize;
		}

//cazul asta cu mai mult de 1 return e ok pentru ca nu ai logica multa dar
//in general metoda trebuie sa aiba cat mai putine return-uri (daca poti pune doar unul ar fi super).
//metodele cu multe return-uri sunt obositoare la citire/intelegere. 

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			iteratedItemsCount++;
			
			if(offsetIndex < currentQueueSize){
				return queue[offsetIndex++];
			}
			
			offsetIndex = 0;
			return queue[offsetIndex++];
					
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}



	}

}
