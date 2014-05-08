package colections.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private List<Item> queue = new ArrayList<>();

	private Random randomGenerator = new Random();

	public RandomizedQueue() {
		// TODO Auto-generated constructor stub
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int size() {
		return queue.size();
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException(
					"You are not allowed to enqueue null items");
		}

		queue.add(item);
	}

	public Item dequeue() {
		if (this.isEmpty()) {
			throw new NoSuchElementException(
					"You are not allowed to dequeue. The queue is empty.");
		}

		return this.queue.remove(randomGenerator.nextInt(this.queue.size()));

	}

	public Item sample() {
		if (this.isEmpty()) {
			throw new NoSuchElementException(
					"You are not allowed to sample. The queue is empty.");
		}

		return this.queue.get(randomGenerator.nextInt(this.queue.size()));
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item> {

		private int cursor;
		int[] cursorPositions = new int[queue.size()];

		public RandomizedQueueIterator() {
			// TODO Auto-generated constructor stub
			
			for (int i = cursorPositions.length - 1; i > 0; i--) {
				cursorPositions[i] = i;
			}

			shuffleArray(cursorPositions);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor < queue.size();
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return queue.get(cursorPositions[cursor++]);
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		void shuffleArray(int[] arrayToShuffle) {

			for (int i = arrayToShuffle.length - 1; i > 0; i--) {
				
				int index = randomGenerator.nextInt(i + 1);

				int a = arrayToShuffle[index];
				arrayToShuffle[index] = arrayToShuffle[i];
				arrayToShuffle[i] = a;
			}
		}

	}

}
