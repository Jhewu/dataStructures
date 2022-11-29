import java.util.*;

public class HelloPrinter{
   public static void main(String[] args) { // main function 
      printCount0(); // this is the first part

      int n = 5; // declaring the int n 
      printCount1(n); // this is the second part 
      // defining int n and then passsing to method 

      printCount2(n);// this is the third part 

      printCountWhile(n); // this is the While function 
   }

   // methods down here -----

   public static void printCount0(){ // this is the first part 
      for (int i = 0 ; i < 10; i++)
         System.out.print(i + " ");
   } 

   public static void printCount1(int n){ // this is the second part 
      System.out.println(" ");
      for (int i = 0 ; i < 10; i++){
         int f = i + n; // Just adding i + n and adding it to the variable 
         System.out.print(f + " ");

      }
   } 
   public static void printCount2(int n){ // this is the third part 
      System.out.println(" "); // adding line 
      int f;
      for (int i = 0 ; i < 10; i++){
         if (i % 2 == 0){ // if divisible by 2 
            f = i/2+n;
         }
         else if (i % 3 == 0){ // if divisible by 3
            f = 0; 
         }
         else{ // any other numbers 
            f = i;
         }

         System.out.print(f + " ");

      }
   }

   public static void printCountWhile(int n){ // this is the While part 
      System.out.println(" ");
      int f;
      int i = 0; // setting i 
      while(i < 10){ // adding the limit right 
         if (i % 2 == 0){
            f = i/2+n;
         }
         else if (i % 3 == 0){
            f = 0; 
         }
         else{
            f = i;
         }

         System.out.print(f + " ");

         i++; // adding i 

      }
   }

}