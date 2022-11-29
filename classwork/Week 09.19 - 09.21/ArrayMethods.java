/** 
 * A class with the insertion sort and binary search methods for arrays.
 */

public class ArrayMethods {

	//Insertion-sort of an array of characters into increasing order
	public static void insertionSort(char[] data) {
		int n = data.length;

		
		for (int i = 1; i < n; i++) {			//begin with the second character
			char current = data[i];				//time to insert current=data[i]
			int j = i;							//find the correct index for current
			while (j>0 && data[j-1] > current) { //thus, data[j] must go after current
				data[j] = data[j-1];			//move data[j-1] to the right
				j--;							//and consider the next previous character
			}
			data[j] = current;					//this is the proper place for current
		}
	}

	//Searching for an element in an array using binary search
	public static int binarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		int mid = -1;

		while (low <= high) {				//controls our search space
			mid = (low+high)/2;				//the median candidate

			if (target == array[mid]) {
				return mid;					//found target
			}
			else if (target > array[mid]) {
				low = mid+1;				//target must be on right half
			}
			else {
				high = mid-1;				//target must be on left half
			}
		}
		return mid;							//Target not found, now low>high
	}

	public static void main(String[] args) {
		int[] array = {11, 16, 21, 39, 45, 54, 62};
		System.out.println(binarySearch(array,30));
	}

}