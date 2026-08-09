class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);

        // for(int i =1; i<= nums.length; i++){
        //     if(nums[i] == nums[i-1]){
        //         return nums[i];
        //     }
        // }

        // return -1;


        int slow = nums[0]; 
        int fast = nums[nums[0]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
