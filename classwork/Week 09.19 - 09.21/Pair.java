public class Pair<A, B> {	//A and B are formal type parameters
	A first;
	B second;

    // two generic data type 
    // single Capitalized letters 
	
	public Pair(A a, B b) {
		first = a;
		second = b;
	}
	
	public A getFirst() { return first; }
	
	public B getSecond() { return second; }
	
	public void setFirst(A newFirst) {
		first = newFirst;
	}
	
	public void setSecond(B newSecond) {
		second = newSecond;
	}
	
	public static void main(String[] args) {
		Pair<String, Double> gameScore1 = new Pair<String, Double>("Mary", 90.6);
		//String, Double are actual type parameters
		
		double score1 = gameScore1.getSecond();
		gameScore1.setSecond(97.7689);
		System.out.println("The score in a double: " + score1);
		
		Pair<String, Integer> student1;
		student1 = new Pair<>("John", 87);		//using type inference
		int grade1 = student1.getSecond();
		System.out.println("The grade is an integer: " + grade1);
		
		//GENERICS & ARRAYS
		Pair<String, Double>[] scores;
		//scores = new Pair<String, Double>[20]; //Incorrect!
		scores = new Pair[25];					 //Correct, warning until elements are assigned
		scores[0] = new Pair<>("Alex", 27.90);
		scores[1] = gameScore1;
	}
}