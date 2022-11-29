public class MyArrayTest{ // this is the MyArrayTest class
    public static void main(String[] args) { // main function here 
        int[] testNums = {5, 10, 11, 54, 60, 12, 4, 8, 1, 20};

        int[] testAges = {30, 25, 50, 12, 6, 10, 55, 36, 21, 31};
        String[] testNames = {"James", "Tom", "Jessica", "Jones", "Betty", "Ted", "Jane", "Bruce", "Clark", "Daniel"};

        MyArray testArray = new MyArray(); // creating an array object 

        // I'm using println --> to check at the terminal
        // testing .findMax
        System.out.println("The maximum value in the array is " + testArray.findMax(testNums)); 

        // testing .findMin 
        System.out.println("The minimum value in the array is " + testArray.findMin(testNums));

        // testing .total 
        System.out.println("The total sum of values in the array is " + testArray.total(testNums));

        // testing .average 
        System.out.println("The average value is " + testArray.average(testNums));

        // testing .findOldestPerson
        System.out.println("The oldest person is " + testArray.findOldestPerson(testNames, testAges));
    }
}

// Your test application should print out the following:
//         	The maximum value in the array is xxx
//         	The minimum value in the array is yyy
//         	The total sum of values in the array is zzz
//         	The average value is aaa
//         	The oldest person is bbb