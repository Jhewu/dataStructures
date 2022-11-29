/**
* A Node class for Singly Linked List
* Storing positive integer elements
*/

public class SNode {
	private GameScore element;	//The integer element stored at the node
	private SNode next;		//Reference/Pointer to the next node

	//Constructor
	public SNode(GameScore e, SNode n) {
		element = e;
		next = n;
	}

	public GameScore getElement() {
		return element;
	}

	public SNode getNext() {
		return next;
	}

	public void setElement(GameScore newElement) {
		element = newElement;
	}

	public void setNext(SNode newNext) {
		next = newNext;
	}

	//Returns the string representation of the SNode
	public String toString() {
		return "(" + element + ")";	
	}

	public static void main(String[] args) { // modified it to fit with GameScore class 

		// GameScore var 
		GameScore gs1 = new GameScore("Harvey", 61); 
		GameScore gs2 = new GameScore("Justin", 86); 
		GameScore gs3 = new GameScore("Timothy", 97); 
		GameScore gs4 = new GameScore("Alex", 92); 
		GameScore gs5 = new GameScore("Lili", 89); 

		// SNode var 
		SNode n1 = new SNode(gs1, null);
		SNode n2 = new SNode(gs2, n1);
		SNode n3 = new SNode(gs3, n2);
		System.out.println(n3.toString());

	}
}