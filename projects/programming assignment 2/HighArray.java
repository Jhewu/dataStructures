
/** 
 * A class that allows access and manipulation of an array of numbers, providing 
 * a high-level interface for common array operations.
 * Filename: HighArray.java (adapted from Robert Lafore's Data Structures text)
 */

public class HighArray {

	private long[] a;        // private instance variable for array a
	private int nElems;      // private instance variable for number of data items

	/**
	 * Construct a new array of longs along with 
	 * an integer variable to track the number of elements in use
	 * @param max
	 *		specifies the size of the array
	 */
	public HighArray(int max) {  // constructor
		a = new long[max];        	// create the array
		nElems = 0;               	// no items yet
	}

	/**
	 * Finds the given value in the array
	 * @param searchKey
	 * 		the value to be searched for
	 * @return
	 *		true if searchKey is found, false otherwise
	 */
	public boolean find(long searchKey) {
		int j;
		for(j=0; j<nElems; j++) {           // for each element,
			if(a[j] == searchKey)           	// found item?
				return true;                       // exit loop before end
		}
		// gone to end of for loop
		return false;                   // yes, can't find it
	}  // end find()

	/**
	 * Inserts a new value into array a
	 * @param value
	 *		the value to be inserted
	 */
	public void insert(long value) {   // put element into array
		a[nElems] = value;             // add element to the end of the array
		nElems++;                      // increment size
	}

	/**
	 * Deletes the specified value
	 * @param value 
	 * 		The value to be deleted
	 * @return 
	 * 		true if search and deletion was successful, false otherwise
	 */
	public boolean delete(long value) { 
		int j;
		for(j=0; j<nElems; j++) {       // look for it
			if( value == a[j] ) {
				for(int k=j; k<nElems; k++) { // move higher ones down
					a[k] = a[k+1];
				}
				nElems--;                   // decrement size
				return true;				//exit entire function
			} //end if
		} //end for j
		return false; // can't find it if we made it this far
	} //end delete()

	/**
	 * Displays array contents
	 */
	public void display() {
		for(int j=0; j<nElems; j++) {      // for each element,
			System.out.print(a[j] + " ");  // display it
		}
		System.out.println("");
	}

	public long getMax(){ // ASK TA ABOUT LONG 
		if(nElems == 0){
			return -1; // return -1 if the array is empty 
			// using nElems because Max = sets the maximum array 
		}
		else{  
			long max = a[0]; // have to add (int) "type casting" for it to work 
			for(int j = 1; j<nElems; j++){
				if (max < a[j]){
					max = a[j]; 
				}
			}
			return max; 

		}
	}
	public long removeMax(){ // code getMax() and delete() from scratch 

		// --- this is getMax() ---
		if(nElems == 0){
			return -1; // return -1 if the array is empty 
			// using nElems because Max = sets the maximum array 
		}
		else{  
			long max = a[0]; // have to add (int) "type casting" for it to work 
			for(int j = 1; j<nElems; j++){
				if (max < a[j]){
					max = a[j]; 
				}
			}

			// --- this is delete() --- 

			int j; 
			for(j=0; j<nElems; j++) {
				if( max == a[j] ) {
					for(int k=j; k<nElems; k++) { // move higher ones down
						a[k] = a[k+1];
					}
					nElems--;                   // decrement size
				}

			}
			return max; 

		}
		
	}
	public void reverse(){ // reverses the content of the array "a" contents in place 

		for(int j=0;j<nElems/2;j++){
			long temp = a[j];
			a[j] = a[nElems-j-1];
			a[nElems-j-1] = temp;
			}
		}
	public boolean allDistinct(){
		for(int j=0; j<nElems;j++){
			for(int i=1; i<nElems; i++){
				if(a[j] != a[i]){
					return true;
				}
			}
		}
		return false; 
	}
	
		
}

		

	

       

  // end class HighArray




/**
 * This HighArrayTest class has only a main function.
 * It's purpose is only to test the HighArray class.
 */
class HighArrayTest {

	public static void main(String[] args) {

		int maxSize = 100;            // array size
		HighArray arr;                // declare a variable of type HighArray
		arr = new HighArray(maxSize); // create the new HighArray object and assign it to arr

		arr.insert(77);               // insert 10 items
		arr.insert(35);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		//arr.display();          	// display items

		//int searchKey = 35;         // value to search for
		//if( arr.find(searchKey) )	//search for item
			//System.out.println("Found " + searchKey);
		//else
			//System.out.println("Can't find " + searchKey);

		//arr.delete(00);               // delete 3 items
		//arr.delete(55);
		//arr.delete(99);

		arr.display();                // display items again

		// --- my work starts here ---


			// Part A
		System.out.println(arr.getMax());	// get Max int value of the list 

			// Part B
		System.out.println(arr.removeMax());	// testing remove Max 
		arr.display();                // testing to see if the max number has been deleted 

			// Part C
		arr.reverse(); // testing the reverse() function 
		arr. display(); 

			// Part D 
		System.out.println(arr.allDistinct()); // testing allDistinct 

			// Part E 
		




	}  // end main()
	
}  // end class HighArrayTest