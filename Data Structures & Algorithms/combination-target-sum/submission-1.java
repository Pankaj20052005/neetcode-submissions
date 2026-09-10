class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }


    public void backtrack(int[] nums, int remaining, int startIdx, List<Integer> path, List<List<Integer>> result){

        if(remaining == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIdx; i < nums.length; i++){
            if(nums[i] > remaining){
                continue;
            }

            path.add(nums[i]);

            backtrack(nums, remaining - nums[i], i , path, result);
            path.remove(path.size() - 1);
        }
    }
}
