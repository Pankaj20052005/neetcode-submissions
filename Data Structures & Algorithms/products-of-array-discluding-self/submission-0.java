class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int[] prefixProductStart = new int[n];
        int[] prefixProductEnd = new int[n];
        int[] res = new int[n];

        prefixProductStart[0] = nums[0];
        for(int i = 1; i< n; i++){
            prefixProductStart[i] = prefixProductStart[i-1] * nums[i];
        }

        prefixProductEnd[n-1] = nums[n-1];
        for(int i = n-2; i>=0 ; i--){
            prefixProductEnd[i] = prefixProductEnd[i+1] * nums[i];
        }

        res[0] = prefixProductEnd[1];
        res[n-1] = prefixProductStart[n-2];

        for(int i = 1; i< n-1; i++){
            res[i] = prefixProductStart[i-1] * prefixProductEnd[i+1];
        }

        return res;
    }
}  
