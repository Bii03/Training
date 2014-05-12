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

		queueCapacity = 10;
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

	public Item dequeue() {
		if (this.isEmpty()) {
			throw new NoSuchElementException(
					"You are not allowed to dequeue. The queue is empty.");
		}

		int indexFromWhereToDequeue = randomGenerator.nextInt(currentQueueSize);
		Item itemToDequeue = queue[indexFromWhereToDequeue];
		queue[indexFromWhereToDequeue] = queue[currentQueueSize-1];
		queue[--currentQueueSize] = null;

		if (currentQueueSize < queueCapacity / 4) {
			decreaseQueueCapacity();
		}

		return itemToDequeue;

	}
	

	private void increaseQueueCapacity() {
		queueCapacity *= 2;
		Item[] resizedQueue = (Item[]) new Object[queueCapacity];
		int offsetIndex = 0;
		
		for (Item i : queue) {
			resizedQueue[offsetIndex++] = i;
		}
		queue = resizedQueue;
	}


	private void decreaseQueueCapacity() {
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
		private int iteratedItemsCount; 


		public RandomizedQueueIterator() {
			// TODO Auto-generated constructor stub
			offsetIndex = randomGenerator.nextInt(currentQueueSize);
			iteratedItemsCount = 0;
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return iteratedItemsCount < currentQueueSize;
		}



		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			iteratedItemsCount++;
			
			if(offsetIndex >= currentQueueSize){
				offsetIndex = 0;
			}

			return queue[offsetIndex++];
					
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}



	}

}
