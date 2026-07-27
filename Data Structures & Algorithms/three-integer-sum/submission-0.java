class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for(int target = 0; target < nums.length -2; target++){
            if(target > 0 && nums[target] == nums[target - 1]){
                continue;
            }

            int left = target +1;
            int right = nums.length -1;

            while(left<right){
                int sum = nums[target]+nums[left]+nums[right] ;

                if(sum == 0){
                    list.add(Arrays.asList(nums[target],nums[left],nums[right]));
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }

                else if(sum < 0){
                    left++;
                }

                else{
                    right--;
                }

                
            }
        }

        return list;
    }
}
