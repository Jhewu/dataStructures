
//Generic class
public class Portfolio<T> {
	T[] data;		//instance variable - generic array
	
	public Portfolio(int capacity) {
		//data = new T[capacity];				//illegal, compiler error
		data = (T[]) new Object[capacity];	//legal
	}
	
	public T get(int index) {
		return data[index]; 
	}
	
	public void set(int index, T element) {
		data[index] = element;
	}
	
	public static void main(String[] args) {
		Portfolio<String> records = new Portfolio<String>(25);
		records.set(0, "William");
		String firstName = records.get(0);
		System.out.println(firstName);
		
		String[] data = new String[20];
		GenericMethodDemo.reverse(data);
	}
}

//A generic method within a non-generic class
class GenericMethodDemo {
	public static <T> void reverse(T[] data) {
		int low = 0, high = data.length - 1;
		while (low < high) {			//swap data[low] with data[high]
			T temp = data[low];
			data[low++] = data[high];	//post-increment low
			data[high--] = temp;		//post-decrement high
		}
	}
}