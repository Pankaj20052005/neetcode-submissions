class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int windowSize = s1.length();

        for(int i = 0; i< windowSize; i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Count, s2Count)){
            return true;
        }

        for(int right = windowSize; right < s2.length(); right++){
            s2Count[s2.charAt(right) - 'a']++;

            int left = right - windowSize;

            s2Count[s2.charAt(left) - 'a']--;

            if(Arrays.equals(s1Count, s2Count)){
                return true;
            }
        }

        return false;
    }
}
