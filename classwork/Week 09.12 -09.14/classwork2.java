public class Classwork2{ 
    // int nums[] = {8,2,30,5,1,4,88,9,10,31}; // variable declaration 

    public static void main(String[] args) {
        int nums[] = {8,2,30,5,1,4,88,9,10,31}; // variable declaration 

        findMax(nums);

    }

    public static int findMax(int[] nums){ // this is the method the biggest number 
        int max; // int max = nums[0]; 
        for(int i = 1; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        return max; 

        // for(int num:nums){
        //     if(num>max){
        //         max = num; 
        //     }
        // if (nums.length == 0){
        //     return -1;
        // }
        }

    


}