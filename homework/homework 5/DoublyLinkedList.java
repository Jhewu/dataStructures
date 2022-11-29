/**
* A DoublyLinkedList class, holding a list of DNodes
* A DNode stores a GameScore element
*/

public class DoublyLinkedList {
	//Instance Variables
	private DNode header;		//The header sentinel DNode
	private DNode trailer;		//The trailer sentinel DNode
	private int size;			//The number of nodes in the list

	//Constructs an initially empty list
	//Creates and links the sentinel nodes to each other
	public DoublyLinkedList() {
		header = new DNode(null, null, null);		//create header
		trailer = new DNode(null, header, null);	//trailer is preceded by header
		header.setNext(trailer);					//header is followed by trailer
		size = 0;
	}

	//ACCESS METHODS

	//Returns the size, number of nodes in the list
	public int size() {
		return size;
	}

	//Returns true if the list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	//Returns (but doesn't remove) the first element
	//That's the element stored at the node after the header
	public GameScore first() {
		return header.getNext().getElement();

	}

	//Returns (but doesn't remove) the last element
	//That's the element stored at the node before the trailer
	public GameScore last() {
		return trailer.getPrev().getElement(); 

	}

	//UPDATE METHODS

	//Adds the newScore element to the front of the list
	public void addFirst(GameScore newScore) {
		addBetween(newScore,header,header.getNext());  

	}

	//Adds the newScore element to the end of the list
	public void addLast(GameScore newScore) {
		addBetween(newScore,trailer.getPrev(),trailer);
	}

	//Removes and returns the first element of the list
	public GameScore removeFirst() {
		if(isEmpty()){ 
			return null; // if not, it will remove the trailer -> important
		}

		return remove(header.getNext()); 
	}


	//Removes and returns the last element of the list
	public GameScore removeLast() {
		if(isEmpty()){ 
			return null; 
		}
		return remove(trailer.getPrev()); 
	
	}


	/**
	 * Displays the list contents
	 */
	public void display() {
		DNode current = header.getNext();		//Start with the node after header, potential first node
		//Walk down the list until you reach the trailer node
		while (current.getElement() != null) {      			// for each node,
			System.out.print(current + " ");  					// display it using the DNode.toString() method
			current = current.getNext();						//Fetch the next node in the list
		}
		System.out.println("");
	}

	// --- Homework 5 starts here ---

	/**
	 * Checks to see if a given GameScore is contained in the linked list
	 * @param target - A GameScore object to be searched for
	 * @return - the DNode containing the target GameScore if found, null otherwise
	 */
	public DNode find ( GameScore target ){
		if (isEmpty()){ return null;} // why search if empty 
		DNode current = header; 
		while (current.getNext() != null){ // when current's next element is not null (end of list), break
				if (current.getElement() == target){ // we are doing a simple linear search although it's possible to make it more complicated
					return current; // return current (DNode) if target is equal
				}
				else{ 
					current = current.getNext(); // update current with the next value
				}
		}
		return null; // return null when we can't find target
	} 
	/**
	 * Adds a new GameScore object into the linked list
	 * The list is sorted in decreasing order by score, this method creates a DNode with the given GameScore and then inserts it in the appropriate spot in the already-sorted list
	 * @param newScore - A GameScore object to be added to the list
	 */
	public void add ( GameScore newScore ){ 
		if ( isEmpty() ){ addFirst(newScore); } // if it's empty then just add new 
		else if ( size == 1 ){ // if there's already one element on the list 
			if ( newScore.getScore() > header.getNext().getElement().getScore() ){ // compare the score we are adding to the first element of the list (header.getNext())
				addFirst(newScore); // if the score is higher than the head score then add it first 
			}
			else { 
				addLast(newScore); // if the score is lower than the head score then add it last
			}
		}
		else { // if there are more than 2 scores already

			DNode previous = header.getNext(); // the first element, remember header does not hold value 
			DNode current = previous.getNext(); // now compare the rest 

			while ( current != null ){ // while current has not reached the end of the list   
				if ( newScore.getScore() > header.getNext().getElement().getScore()){ // if the first element of the list (header.getNext()) is lower than the newScore (decreasing order), then add it before the first element
					addFirst(newScore); 
					break; 	
				} 
				else if ( newScore.getScore() < trailer.getPrev().getElement().getScore() ){ // if the last element of the list (trailer.getPrev()) is higher than the newScore (decreasing order), then add it to the end 
					addLast(newScore); 
					break; 
				}
				// now onto the actual comparison (in the middle)
				else if ( newScore.getScore() > current.getElement().getScore()){ // if newScore is greater than the current element we are scanning then: 
					addBetween(newScore,previous,current);
					break; 
				}
				else { // if current is still higher than newScore, then update to next interation 
					previous = previous.getNext();
					current = current.getNext(); 
				}
			}
		}

	}
	/**
	 * Deletes a given GameScore entry from the linked list
	 * @param gameScore - A GameScore object to be searched for and deleted
	 * @return the DNode containing the target GameScore if search and deletion was   successful, null otherwise.
	 */

	public DNode delete ( GameScore target ){ 
		DNode previous = header.getNext(); // first element of the list 
		DNode current = header.getNext(); // second element of the list

		while ( current != null ){ // while current has not reached the end of the list 
			if ( target.getScore() == header.getNext().getElement().getScore()){ // if the first element of the list is equal to target then remove first and return the head 
				removeFirst(); 
				return header.getNext(); 
				} 
			else if ( target.getScore() == trailer.getPrev().getElement().getScore()){ // if the last element is equal to target then remove last and return the tail 
				removeLast(); 
				return trailer.getPrev(); 
			}
			// now the actual comparison (in the middle)
			else if ( target.getScore() == current.getElement().getScore()){ // if target is equal the current, then:
				remove(current); // remove current
				return current; 
			}
			else{ // if current is still not equal to target, then update to next interation 
				previous = previous.getNext();
				current = current.getNext(); 
			}
		}
		return null; // if we can't find it, return null
	}

	// --- Homework 5 ends here ---

	//---------------------  OUR PRIVATE HELPER METHODS  --------------------

	//Adds the newScore in between the given nodes
	private void addBetween(GameScore newScore, DNode prevNode, DNode nextNode) {
		DNode newNode = new DNode(newScore, prevNode, nextNode);	//Create and link the new node
		//Update the given nodes to link to the new node
		prevNode.setNext(newNode);
		nextNode.setPrev(newNode);
		size++;
	}

	//Removes the given node from the list and returns its element
	private GameScore remove(DNode xNode) {
		//Get the nodes on either side of xNode
		DNode prevNode = xNode.getPrev();
		DNode nextNode = xNode.getNext();
		//Link prevNode and nextNode to each other, essentially removing xNode from the list
		prevNode.setNext(nextNode);
		nextNode.setPrev(prevNode);
		size--;
		return xNode.getElement();
	}

	//-------------------------------------------------------------------------

	// --- main method starts here ---

	public static void main(String[] args){
		DoublyLinkedList dLinkedList = new DoublyLinkedList(); // create an object of DoublyLinkedList class

		System.out.println("Now testing find()");

		// create objects from the GameScore class to add to dLinkedList 

		GameScore gs1 = new GameScore("Harvey", 61); 
		GameScore gs2 = new GameScore("Justin", 86); 
		GameScore gs3 = new GameScore("Timothy", 97); 

			// testing find() method 
		dLinkedList.addFirst(gs1);
		dLinkedList.addLast(gs2);
		dLinkedList.addLast(gs3); // adding GameScores to test find() 

		GameScore qs2 = gs2; // these are the GameScore we are trying to find
		GameScore qs3 = gs3;
		System.out.println("we found" + dLinkedList.find(qs2));
		System.out.println("we found" + dLinkedList.find(qs3));

		dLinkedList.display(); 
			// end of testing find() method 

			// testing add() method 
		DoublyLinkedList dLink = new DoublyLinkedList(); // create an object of DoublyLinkedList class to test add(), because they are sorted

		System.out.println(" ");
		System.out.println("Now testing add()"); 

		// create new objects from GameScore to add 
		GameScore gscore1 = new GameScore("Harvey", 61); 
		GameScore gscore2 = new GameScore("Justin", 86); 
		GameScore gscore3 = new GameScore("Timothy", 97); 
		GameScore gscore4 = new GameScore("Alex", 92); 
		GameScore gscore5 = new GameScore("Lili", 89); 
		GameScore gscore6 = new GameScore("Jun", 1);

		dLink.add(gscore1); 
		dLink.add(gscore2); 
		dLink.add(gscore3);
		dLink.add(gscore4); 
		dLink.add(gscore5); 
		dLink.add(gscore6); // add the GameScore to the list 

		dLink.display(); // display to see if it worked 
			// end of testing add() method

			// testing delete() method
		System.out.println("We deleted" + dLink.delete(gscore6)); 
		System.out.println("We deleted" + dLink.delete(gscore5)); 
		dLink.display();

	}

}
