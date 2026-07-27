public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLen = 0;
        int maxFreq = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {

            int rightCharIndex = s.charAt(right) - 'A';
            count[rightCharIndex]++;
            
            maxFreq = Math.max(maxFreq, count[rightCharIndex]);
            
            if ((right - left + 1) - maxFreq > k) {
                int leftCharIndex = s.charAt(left) - 'A';
                count[leftCharIndex]--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}