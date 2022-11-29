public class MyArray{

    public int findMax(int[] nums){ // return max int value in the given array (nums)
        if (nums.length == 0){ // this is not necessary, but just in case the array the user gives to the method is not empty 
            return -1;
        }
        else{ // if array not empty then 
            int max = nums[0]; // declare the max variable
            for(int i = 1; i < nums.length; i++){  // for every i starting at 1 (because we already assigned num[0]) until the length 
                if (nums[i] > max){ // if the num inde is greater than the max assigned the index value to the max 
                    max = nums[i];
                }
            }
            return max; // print the max after all the indexes has ran and the biggest value is retained 
        }

    }
    public int findMin(int[] nums){ // return min int value in the given array (nums)
        if (nums.length == 0){
            return -1; 
        }
        else{ 
            int min = nums[0]; // declare the min value, which I am going to use later 
            for(int i = 1; i < nums.length; i++){
                if (nums[i] < min){
                    min = nums[i]; // similar to the max method but instead we are only switching the greater and less than signs 
                }
            }
            return min; 
        }
    }
    public int total(int[] nums){
        if(nums.length == 0){
            return -1;
        }
        else{
            int total = nums[0]; // declare variable total and assign it as num[0], the first value 
            for(int i = 1; i < nums.length; i++){
                total = total + nums[i]; // add the index's number to the toal through all iterations, similar to python 
            }
            return total; 
        }
    }   
    public float average(int[] nums){ // computer average values of the array 
        if(nums.length == 0){
            return -1; 
        }
        else{ 
            float total = total(nums); // declare total, notice that I use float here, because there will be decimals 
            float avrg = total/nums.length; // total divided by the nums's array length 
            return avrg; 
        }
    }
    public String findOldestPerson(String[] names, int [] ages){
        if(names.length == 0 || ages.length == 0){ // if the array name or the array age is zero then return error 
            return "one or both of the arrays are empty";
        }
        
        else if(names.length == ages.length){
            String oldest = names[0]; // set the first person as the oldest 
            int oldAge = ages[0]; // set the age of the first person 
            // we won't need to return this case, but we need it to run the method
            for(int i = 1; i < names.length; i++){ // in this scenario using which parameter does not matter as they both have the same indexes 
                if(oldAge < ages[i]){ // if the previous age is smaller than the index's age then 
                    oldAge = ages[i]; // assign the age 
                    oldest = names[i]; // assign the name to this variable, this will have the same index as the variable oldAge 
                }
            }
            return oldest; 
        }
        else{
            return "the two arrays length do not match"; // also coded this in case that the two arrays lengths do not match, because if not it will mess up the method 
        }
    }
}

// Your test application should print out the following:
//         	The maximum value in the array is xxx
//         	The minimum value in the array is yyy
//         	The total sum of values in the array is zzz
//         	The average value is aaa
//         	The oldest person is bbb

