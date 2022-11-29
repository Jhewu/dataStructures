public void insert(long value) { // put element into array

    if(nElems == 0){ 
        a[0] = value; 
        nElems++; 

    }
    else{ 
        int low = 0; 
        int high = nElems-1; 
        int index; 
        int mid; 

        while(low <= high){

            mid = (low + high)/2; 

            if(a[mid] = value){
                index = mid; 
                break; 
            }
            else if(a[mid] < value){
                low = mid+1; 
            }
            else{
                high = mid-1; 

            }
            
        }
        if(a[mid] <= value){
            index = mid + 1; 

        }
        else{ 
            index = mid - 1; 
        }
        for(int k=nElems; k>index; k--){
            a[k] = a[k-1];
        }
        a[index] = value;                  // insert the value
        nElems++;             
    
    








    }

}