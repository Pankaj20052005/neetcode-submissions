class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        // Find maximum pile size for upper bound
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int ans = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                ans = mid;         // Record valid speed
                right = mid - 1;   // Try to find a smaller speed
            } else {
                left = mid + 1;    // Speed too slow, increase speed
            }
        }
        
        return ans;
    }
    
    private boolean canEatAll(int[] piles, int h, int k) {
        long hoursNeeded = 0;
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / k)
            hoursNeeded += (pile + k - 1) / k;
        }
        return hoursNeeded <= h;
    }
}