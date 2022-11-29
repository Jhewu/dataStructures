/**
* Implementation of a generic queue ADT using a fixed-length array.
* Queue: a collection of objects that are inserted
* and removed according to the first-in first-out (FIFO) principle.
*/

public class ArrayQueue<E> {
	//Instance Variables
	public static final int CAPACITY = 1000;		//default capacity/length of the array
	private int size = 0;		//current number of elements
	private int front = 0;		//index of the front element
	private E[] data;			//generic array used for storage

	//CONSTRUCTORS
	public ArrayQueue() {
		this(CAPACITY);			//Constructs queue with default capacity
	}

	public ArrayQueue(int cap) {	//constructs queue with given capacity
		data = (E[]) new Object[cap];	//safe cast; compiler may give warning
	}

	//QUEUE METHODS
	/** Tests whether the queue is empty */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the number of elements in the queue */
	public int size() {
		return size;
	}

	/** Inserts an element at the rear of the queue */
	public void enqueue(E e) {
		if (size < data.length) {		//Only add if the array is not full
			int rearIndex = (front+size)%data.length;	//Use modular arithmetic
			data[rearIndex] = e;
			size++;
		}
	}

	/** Returns, but does not remove, the first element of the queue 
	Returns null of the queue is empty */
	public E first() {
		if (isEmpty())
			return null;
		return data[front];
	}

	/** Removes and returns the first element of the queue
	Returns null if the queue is empty */
	public E dequeue() {
		if (isEmpty()) return null;
		E answer = data[front];
		data[front] = null;		//de-reference if an object (optional)
		front = (front+1)%data.length;
		size--;
		return answer;
	}
	
	/**
	* Returns a string representation of the stack contents
	*/
	public String toString() {
		String s;
		s = "[";
		if (size() > 0) s+= data[0];
		if (size() > 1)
			for (int i = 1; i <= size()-1; i++) {
	       		s += ", " + data[i];
			}
		return s + "]";
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<>(10);
		System.out.println(queue.isEmpty());
		queue.enqueue(99);
		queue.enqueue(19);
		System.out.println(queue);
		
	}

}