package serializablecircularlist;

import java.io.Serializable;

/**
 * In order to be able to serialize the elements of the list, Node should also 
 * implement Serializable since the list object refers to objects that are not serializable,
 * namely objects of type Node.
 * 
 * JVM follows all the references recursively
 * 
 * @author btesila
 *
 * @param <T>
 */

public class CircularList<T> implements Serializable{
	
	private Node head;
	
	public CircularList() {
		// TODO Auto-generated constructor stub
		this.head = null;
	}
	
	public void add(T element){
		Node nodeToBeAdded = new Node(element);
		
		if(head == null){
			head = nodeToBeAdded;
			head.setNext(head);
		}
		else{
			Node lastNode = head.getNext();
			head.setNext(nodeToBeAdded);
			nodeToBeAdded.setNext(lastNode);
		}
		
	}
	
	

	
	
	public void printList() {

        if (this.head == null)
            return;

        Node currentNode = this.head;

        while (currentNode.getNext() != this.head) {
        	currentNode = currentNode.getNext();
        	 System.out.println(currentNode);
           
        }

    }
	
	

	
	private class Node implements Serializable{
		
		private T value;
		
		private Node next;


		public Node(T value) {
			super();
			this.value = value;
			this.next = null;
		}
		
		

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Node "+value;
		}

	}
	
	
	
}
