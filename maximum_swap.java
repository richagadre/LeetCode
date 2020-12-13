class Solution {
    /*
    
    Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
    
    2736 -> 7236
    
    2763
    
    7236
    
    9973 -> 9973

    
    5478 -> 7458
    
    101 -> 110
    
    432 -> 432
    
    */
    public int maximumSwap(int num) {
        
        char[] nums = Integer.toString(num).toCharArray();
        
        
        int max_index = nums.length - 1;
        
        int swap_index = nums.length - 1;
        
        int new_max = nums.length - 1;
        
        int max = 0;
        
        boolean swap = false;
        
        for(int i = nums.length - 1; i >= 0; i--) {
            
            if(nums[i] > max) {
                new_max = i;
                max = nums[i];
            } else if(nums[i] < max){
                max_index = new_max;
                swap_index = i;
               swap = true;
            
                
            }
            
                     
        }
        
        if(swap){
            char temp = nums[max_index]; 
            nums[max_index] = nums[swap_index];
            nums[swap_index] = temp;
        }
        
        
        return Integer.parseInt(new String(nums));
        
        
    }
}
