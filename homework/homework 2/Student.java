import java.util.Scanner; // import Scanner because we need to use it 

public class Student{

    private String name; 
    private int grade; // Instance variables belongs outside, 0hhhhh I remember from python 

    public Student(String name, int grade){ // constructor name should be the same as the class 
        this.name = name; // we use this. instead of self 
        this.grade = grade;
    }

    public static void main(String[] args) { // This is the main function where I am running everything 
        // -----
        // This is the first part 

        Student student1 = new Student("Vanny Phai", 98); // create student Vanny 

        System.out.println("The student name is " + student1.getName()); // testing getName()

        System.out.println(student1.getName() + "'s grade is "+ student1.getGrade() + " out of 100"); // texting getGrade

        student1.setName("Jun Yi He Wu"); // setting new name
        System.out.println("The new student name is " + student1.getName() + " out of 100"); // system print the new name 

        student1.setGrade(1); // setting new grade 
        System.out.println(student1.name + "'s grade is " + student1.getGrade());// system print the new grade 

        // ----- 
        // This is the second part 

        Student[] studentArray = new Student[5]; // create an array of objects, using the class Student 

        Student.fillArray(studentArray); // call method and pass studentArray to it 
        // Since there is no object, we call the class 
        // For me to call a method like this (activate it), I need to incorporate static in the method 

        // testing if the array can carry out commands 

        System.out.println("The student name is " + studentArray[4].getName()); // testing the last element of the array and getting its name 

        System.out.println(studentArray[0].getName() + "'s grade is " + studentArray[0].getGrade()); // testing the first index of the array and getting their grade 
       
    }

    public String getName(){ // method to get name 
        return this.name;
    }
    public int getGrade(){ // the method to get grade 
        return this.grade; // no void if return 

    }
    public void setName(String newName){ // new name is just a parameter 
        this.name = newName;

    }
    public void setGrade(int newGrade){
        this.grade = newGrade; 
    }
    public static void fillArray(Student[] aList){
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            System.out.print("Please print out the student's name: ");
            String name = in.next();

            System.out.print("Please print out the student's grade: ");
            int grade = in.nextInt();

            Student studentA = new Student(name, grade); 

            aList[i] = studentA;

        }

        in.close(); // closing the scanner, resource leak 
    }

}








