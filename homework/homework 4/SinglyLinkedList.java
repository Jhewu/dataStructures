/**
* A Singly Linked Class
* Storing a list of SNode nodes with integer elements
*/

// Homework #4 
// -> add 3 more methods to SinglyLinkedList 

public class SinglyLinkedList {
	private SNode head;		//The head node of the list
	private SNode tail;		//The tail node of the list
	int size;				//The number of nodes in the list

	//Constructor method
	public SinglyLinkedList() {
		 head = null;		//head and tail are null in an empty list
		 tail = null;
		 size = 0;
	}

	// ----- ACCESS METHODS -----
	//Returns the number of nodes in the list
	public int size() {
		return size;
	}

	//Returns true of the list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	//Returns the first element in the list, null if empty
	public GameScore first() { // changed int return to GameScore
		if (isEmpty()) return null;
		return head.getElement();
	}

	//Returns the last element in the list, null if empty
	public GameScore last() { // changed int return to GameScore
		if (isEmpty()) return null;
		return tail.getElement();
	}

	//Adds a new element to the front of the list
	public void addFirst(GameScore e) { // changed int parameter to GameScore
		SNode newNode = new SNode(e, head);
		head = newNode;
		if (isEmpty()) { tail = head; }	//Special case
		size++;
	}

	//Add a new element to the end of the list
	public void addLast(GameScore e) { // changed int parameter to GameScore
		SNode newNode = new SNode(e, null);
		if (isEmpty()) { head = newNode; }	//Special case
		else {
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
	}

	//Removes and returns the first element of the list
		//Returns null if list is empty
	public GameScore removeFirst() {
		if (isEmpty()) { return null; }
		SNode temp = head;
		head = head.getNext();
		size--;
		if (isEmpty()) { tail = null; }
		temp.setNext(null);		//Optional
		return temp.getElement();
	}

	//Prints the elements of the list
	public void display() {
		SNode current = head;
		while (current != null) {      // for each SNode,
			System.out.print(current + " ");  // display it		}
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public boolean equals(SinglyLinkedList other) {
		if (other == null) return false;
		if (size != other.size()) return false;
		SNode current = head;
		SNode otherCurrent = other.head;
		while (current != null) {
			if (current.getElement() != otherCurrent.getElement())
				return false;
			//If elements were objects then we would use the equals method instead of !=
			//if (!current.getElement().equals(otherCurrent.getElement()))
			current = current.getNext();
			otherCurrent = otherCurrent.getNext();
		}
		return true;
	}
	
	//Removes and returns the last element in the list
	public GameScore removeLast() {
		if (isEmpty()) return null;
		if (size == 1) return removeFirst();
		
		SNode current = head;
		SNode ahead = head.getNext();
		while (ahead.getNext() != null) {
			current = current.getNext();
			ahead = ahead.getNext();
		}
		current.setNext(null);
		tail = current;
		size--;
		return ahead.getElement();
	}

	// ----- Homework 4 (starts here) -----
	/**
	 * Checks to see if a given GameScore is contained in the linked list
	 * @param target - A GameScore object to be searched for
	 * @return - the SNode containing the target GameScore if found, null otherwise
	 	*/
	public GameScore find ( GameScore target ){ 
		if ( isEmpty() ){ return null;} // if it's empty, why search? 
		SNode current = head; // creating an instance object and assigning it as head
		while ( current.getNext() != null ){ // when current next is not null (end of list)
			if (current.getElement().equals(target)){ // if the object in current is equal to the object in target
				return current.getElement(); // return current element if target is equal
				}
			else{ 
				current = current.getNext(); // update current with the next value
				}
			}
		return null; // return null when we can't find target
		} 
	/**
	 * Adds a new GameScore object into the linked list
	 * The list is sorted in decreasing order by score, this method creates an SNode with the given
	 * GameScore and then inserts it in the appropriate spot in the already-sorted list
	 * @param newScore - A GameScore object to be added to the list
	 */
	public void add( GameScore newScore ){ 
		if ( isEmpty() ){ // if it's empty then just add new 
			addFirst( newScore );
		}
		else if ( size == 1 ){ // if there's already an element in the list, compare this element with newScore
			if ( newScore.getScore() > head.getElement().getScore() ){ 
				addFirst(newScore); // if the score is higher than the head score then add it first 
			}
			else{ 
				addLast(newScore); // if the score is lower than the head score then add it last
			}
		}
		else { // if there are more than 2 scores in the list 

			SNode previous = head; 
			SNode current = head.getNext(); // now compare the rest 

			while ( current != null ){ // while current is not mid (reached the end of the list)
				if ( newScore.getScore() > head.getElement().getScore() ){ // if the first element of the list (head) is lower than the newScore (decreasing order), then add it before the head 
					addFirst(newScore); 
					break; 	
				} 
				else if(newScore.getScore() < tail.getElement().getScore()){ // if the last element of the list (tail) is higher than the newScore (decreasing order), then add it to the end 
					addLast(newScore); 
					break; 
				}
				else if (newScore.getScore() > current.getElement().getScore()){ // if newScore is greater than the current, then
					SNode newNode = new SNode(newScore, current); // create newNode that contains newScore and which points to current
					previous.setNext(newNode); // connect the previous to the newNode 
					size++; // increase the size 
					break;
				}
				else{ // if current is higher than newScore, then update to next interation 
					previous = previous.getNext();
					current = current.getNext(); 
				}
			}
		}
	}
	/**
	* Deletes a given GameScore entry from the linked list
	* @param gameScore - A GameScore object to be searched for and deleted
	* @return the SNode containing the target GameScore if search and deletion was   successful, null otherwise.
		*/
	public SNode remove ( GameScore gameScore ){ 
		// the code here will be really similar to add() 
		SNode previous = head; 
		SNode current = head.getNext(); 
		while ( current != null ){ // while the current has not reached the end of the list 
			if ( gameScore.equals( head.getElement() ) ){ // if the head is equal to gameScore then remove first and return the head 
				removeFirst();
				return head; 
				} 
			else if ( gameScore.equals( tail.getElement() ) ){ // if the tail is equal to gameScore then remove last and return the tail 
				removeLast(); 
				return tail; 
			}
			else if ( gameScore.equals( current.getElement() ) ){ // if gameScore is equal the current node, then 
				previous.setNext(current.getNext()); // cut out current 
				size--; // increase the size 
				return current; 
			}
			else{ // if current is higher than newScore, then update to next interation 
				previous = previous.getNext();
				current = current.getNext(); 
			}
		}
		return null;
	}
	// --- Homework 4 ends here ---
	
	public static void main(String[] args) {

		// --- Homework 4 testing (starts here) ---

			// testing find() 
		System.out.println("Now testing find() ");

		SinglyLinkedList nodeList = new SinglyLinkedList(); // create an object of SinglyLinkedList named nodeList 

		// now create objects of the GameScore class to enter to nodeList 
		GameScore gs1 = new GameScore("Harvey", 61); 
		GameScore gs2 = new GameScore("Justin", 86); 
		GameScore gs3 = new GameScore("Timothy", 97); 
		GameScore gs4 = new GameScore("Alex", 92); 
		GameScore gs5 = new GameScore("Lili", 89); 
		GameScore gs6 = new GameScore("Jun", 1);

		// now add these values to nodeList (or linked them together)

		nodeList.addFirst(gs1); 
		nodeList.addLast(gs2);
		nodeList.addLast(gs3);
		nodeList.addLast(gs4);
		nodeList.addLast(gs5);

		nodeList.display(); // display the list (see if it works)
		GameScore qs1 = gs1; // making qs1 = qs2, so that I could test it on the find method 
		GameScore qs2 = gs2; 

		System.out.println(nodeList.find(qs1)); // testing the find() method 
		System.out.println(nodeList.find(qs2)); 
			// end of testing find() 

			// testing add() 
		// I think for the method addLast or addFirst, those should be private, because if not, it could mess up with the orders of our sorted single linked list 

		SinglyLinkedList nList = new SinglyLinkedList(); // create an object of SinglyLinkedList named nList to test add()

		System.out.println(" "); 
		System.out.println("Now testing add()"); 

		nList.add(gs1);
		nList.add(gs2);
		nList.add(gs3);
		nList.add(gs4);
		nList.add(gs5); // adding the values 
		nList.add(gs6);

		nList.display(); // display the value to check if it worked 
			// end of testing add() 

			// testing remove() 

		System.out.println(" "); 
		System.out.println("Now testing remove()");

		System.out.println(nList.remove(gs6));
		System.out.println(nList.remove(gs5)); // testing remove method and printing the return value 

		nList.display();
	}
}
