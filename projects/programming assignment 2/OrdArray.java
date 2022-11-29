/** 
* A class that allows access and manipulation of an ordered array of numbers, 
* providing a high-level interface for common array operations.
* Filename: OrdArray.java (adapted from Robert Lafore's Data Structures text)
* @author William Tarimo 
*/
public class OrdArray {

	private long[] a;		// private instance variable for array a
	private int nElems;		// private instance variable for number of data items
	
	/**
	 * Construct a new array of longs along with 
	 * an integer variable to track the number of elements in use
	 * @param max // java do comment,special type 
	 *		specifies the size of the array
	 */
	public OrdArray(int max) {          // constructor
		a = new long[max];             // create array
		nElems = 0;
	}

	/**
	 * Accessor method for nElems
	 * @return 
	 *		returns the number of array elements in use
	 */ 
	public int size() {
		return nElems; 
	}

	/**
	 * Finds the given value in the array
	 * @param searchKey
	 * 		the value to be searched for
	 * @return
	 *		the index where the searchKey is found, 
	 *		or the value of nElems if not found
	 */
	public int find(long searchKey) { // modify: so that it uses binary search instead of linear search 
		if(nElems == 0){ // if the array is "empty" then return -1
			return -1;

		}
		int low = 0; // index low (of the first number in OrdArray)
		int high = nElems-1; // index high (of the last number in OrdArray)

		while(low <= high){ // while low is less than or equal to high, keep running

			int mid = low + (high - low)/2; // the distance between high and low divided by two, and plus low (in case that it's on th upper halves)

			if(a[mid] == searchKey){ // if mid is equal to the searchKey return mid, and the function will break 
				return mid; 
			}

			if (a[mid] < searchKey){ // if mid less than searchKey then 
				low = mid + 1; // eliminate the low half section 
				
			}
			else{
				high = mid - 1; // elminate the high half section 
			}

		} 
		return -1; // if we can't find the number, aka 

	}
		
	/**
	 * Inserts a new value into array a[]
	 * (Assumes the array is long enough to handle all items that will be inserted.)
	 * @param value
	 *		the value to be inserted
	 */
	public void insert(long value) { // put element into array
		if(nElems == 0){  // if array empty then, insert value and increase nElems++ 
			a[0] = value; 
			nElems++; 
	
		}
		else{ 
			int low = 0; 
			int high = nElems-1; 
			int index = 0; 
			int mid = 0; 
	
			while(low <= high){
	
				mid = (low + high)/2; 
				index = mid;

				if(a[mid] == value){
					break; // if a[mid] is value, then break and read outside of the whiule loop 
				}
				else if(a[mid] < value){
					low = mid+1; 
				}
				else{
					high = mid-1; 
	
				}
				
			}
			if(a[mid] < value){ // when it breaks, determine whether a[mid] is lower than value, because when we run the binary search on the while loop, we don't know whether it should be placed on the right or on the left 
				index = mid + 1; 
	
			}
			for(int k=nElems; k>index; k--){
				a[k] = a[k-1]; // now move all the numbers back in order 
			}
			a[index] = value;                  // insert the value
			nElems++;             
		
		}
	}  // end insert()
	
	/**
	 * Deletes the specified value
	 * @param value 
	 * 		The value to be deleted
	 * @return 
	 * 		true if search and deletion was successful, false otherwise
	 */
	public boolean delete(long value) {
		// this will be very similar to find()

		if(nElems == 0){ // if the array is "empty" then return false 
		return false;
		}

		int low = 0; 
		int high = nElems-1; 
		int mid = 0; // initialize it to 0 by default 

		while(low <= high){ // while low is less than or equal to high, keep running, same conditions as find() 

			mid = low + (high - low)/2; // the distance between high and low divided by two, and plus low (in case that it's on th upper halves)

			if (a[mid] == value){ // if mid equals the value, then 
				for(int k=mid; k<nElems;) { // move bigger ones down
					a[k] = a[k+1]; // to "delete" it
					k++; 
					nElems--; // and then decrement size
					return true; // return True to break the loop  
				}
			}
			if (a[mid] < value){ // if mid less than value then 
				low = mid + 1; // eliminate the low half section 
				
				}
				else{
					high = mid - 1; // elminate the high half section 
				}
	
			} 
			return false; // if we can't find the number,aka 			            
	}  // end delete()

	public void sort(){ 

/*  Specifically, when considering a particular value in the array, your version should not waste time swapping it into each intermediary position that it gets compared to.  Rather, your version should set aside, shift all larger values to its “right” over by one spot, then place directly into its final/correct slot in the array.
 */

		for(int i = 1; i<nElems; i++){ // insertionSort() Algorithm
				int index = i; // index to keep track of the index
				long lowest = a[i]; // using lowest to keep track of the value 
				for(int k = i+1; k < nElems; k++){
					if(a[k] < a[i]){ // k = i+1 
						lowest = a[k]; // set a[k] to lowest
						index = k; // keep track of the index 
					}
				}
				a[index] = a[i];
				a[i] = lowest; 
				// now switch the two values
		}

	}

	public void merge(long[] b){ 
		for(int i = 0; i < b.length; i++){ 
			insert(b[i]); // calling insert and then using loop to insert all b[i] 
		}
	
	}

	/**
	 * Displays array contents
	 */
	public void display() {            // displays array contents
		for(int j=0; j<nElems; j++)       // for each element,
		System.out.print(a[j] + " ");  // display it
		System.out.println("");
	}
	//-----------------------------------------------------------
}  // end class OrdArray

/**
 * This OrderedArrayTest class has only a main function.
 * It's purpose is only to test the OrderderedArray class.
 */
class OrderedArrayTest {

	public static void main(String[] args) {
		int maxSize = 100;             // array size
		OrdArray arr;                  // reference to array
		arr = new OrdArray(maxSize);   // create the array

		arr.insert(77);                // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display();

		arr.insert(-1); 
		arr.insert(100000);
		arr.display();

		// --- Programming assignments starts here 

			// part E: find() -> modify with binary search 
		System.out.println(arr.find(11)); // the index is working 
		System.out.println(arr.find(8)); // now with a fake number, this is working, maybe have someone to explain how this works

			// Part F: insert() and deleted() -> modify with binary search
		// delete()
		arr.display();
		System.out.println(arr.delete(77)); 
		arr.display(); // display the array to see if the number is deleted 

		// insert() 
		arr.insert(44);
		arr.display(); 

			// Part H 
		// Give the run-time of each method in both HighArray and OrdArray
			// the run time of HighArray is "n", whereas the run time for OrdArray is logN 

		// Why could/would binary search not work in the HighArray class, but work in the OrdArray class. 
			// it would not work, because HighArray does not sort the elements within its array 

		// If OrdArray can be searched in O(log n) time, while HighArray needs Θ(n) time, does this mean it is always better to use OrdArray?  Explain.
			// it's not always optimal to use OrdArray, because when we consider really small list, HighArray works better as OrdArray has to keep "logging" (binary search) on a small list, which could had simply done by running linearly 
		
		//  The find() method now uses a binary search, which, as mentioned above, has a run time of Θ(log n), rather than a linear search, which has a run time of Θ(n).  If we have now modified the delete() and insert() functions to use binary search as well, do their worst-case run-times also improve to O(log n)?  Explain.
			// The worst case scenario in this case would be when array is really big, which in this case will improve the run time to log n instead of n, so it's true. 

			// Final Challenge 
		// testing merge() 

		long [] b = {1001,1002,1004}; // created an ordered again

		arr.merge(b); 
		arr.display(); // testing merge

	}  // end main()
	
}  // end class OrderedApp