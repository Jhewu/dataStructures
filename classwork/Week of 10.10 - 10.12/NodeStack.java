/**
  * An alternative implementation of a generic stack ADT using a SinglyLinkedList node.
  * Stack: a collection of objects that are inserted
  * and removed according to the last-in first-out principle.
  */

  public class NodeStack<E>{
    protected SNode<E> top;	  // reference to the head/top node
    protected int size;		    // number of elements in the stack
    
    public NodeStack() {	// constructs an empty stack
      top = null;
      size = 0;
    }
  
    public int size() { return size; }
  
    public boolean isEmpty() {
      return size == 0;
    }
  
     public void push(E elem) {
      SNode<E> newNode = new SNode<E>(elem, top);	// create and link-in a new node
      top = newNode;
      size++;
    }
   
    public E peek() {
      if (isEmpty()) 
            return null;
      return top.getElement();
    }
  
     public E pop() {
      if (isEmpty()) 
            return null;
      E temp = top.getElement();
      top = top.getNext();	// link-out the former top node
      size--;
      return temp;
    }
  }