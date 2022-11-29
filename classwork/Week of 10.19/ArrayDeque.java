/**
* Implementation of a generic deque ADT using a fixed-length array.
* Deque is a double-ended queue: a queue structure that allows insertions and deletions
* at front and rear ends.
*/

public class ArrayDeque<E> {
	//Instance Variables
	public static final int CAPACITY = 1000;		//default capacity/length of the array
	private int size = 0;		//current number of elements
	private int front = 0;		//index of the front element
	private E[] data;			//generic array used for storage

	//CONSTRUCTORS
	public ArrayDeque() {
		this(CAPACITY);			//Constructs queue with default capacity
	}

	public ArrayDeque(int cap) {	//constructs queue with given capacity
		data = (E[]) new Object[cap];	//safe cast; compiler may give warning
	}

	//QUEUE METHODS

	/** Tests whether the deque is empty */
	public boolean isEmpty() {
		return size==0;
	}

	/** Returns the number of elements in the queue */
	public int size() {
		return size;
	}

	/** Inserts an element at the rear of the deque */
	public void addLast(E e) {
		if (size < data.length) {	//Only add if the array is not full
			data[(front+size)%data.length] = e;
			size++;
		}
	}


	public void addFirst(E e) throws IllegalStateException {
		if (size == data.length)
			throw new IllegalStateException("Deque is Full");
		int index = (front-1+data.length);
		data[index%data.length] = e;
		size++;
	}

	/** Returns, but does not remove, the first element of the deque 
	Returns null of the deque is empty */
	public E first() {
		if (isEmpty())
			return null;
		return data[front];
	}

	/** Returns, but does not remove, the last element of the deque 
	Returns null of the deque is empty */
	public E last() {
		if (isEmpty())
			return null;
		int lastIndex = (front+size-1)%data.length;
		return data[lastIndex];
	}

	/** Removes and returns the first element of the deque
	Returns null if the deque is empty */
	public E removeFirst() {
		if (isEmpty())
			return null;
		E temp = data[front];
		data[front] = null;
		front = (front+1)%data.length;	//Update front
		size--;
		return temp;
	}

	/** Removes and returns the last element of the deque
	Returns null if the deque is empty */
	public E removeLast() {
		if (isEmpty())
			return null;
		int lastIndex = (front+size-1)%data.length;
		E temp = data[lastIndex];
		data[lastIndex] = null;
		size--;
		return temp;
	}
}