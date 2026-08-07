class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int  min = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right - left) / 2;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] < min){
                    min = nums[i];
                }
            }
            left++;
            right--;
        }

        return min;
    }
}
