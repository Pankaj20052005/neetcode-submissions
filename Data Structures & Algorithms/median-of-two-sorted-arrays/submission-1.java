class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length ;
        int n =  nums2.length;
        int total = m + n;

        int p1 = 0;
        int p2 = 0;

        int prev = 0;
        int curr = 0;

        for(int count = 0; count <= total/2; count++){

            prev = curr;

            if(p1 < m && (p2 >= n || nums1[p1] <= nums2[p2])){
                curr = nums1[p1];
                p1++;
            }
            else{
                curr = nums2[p2];
                p2++;
            }
        }

        if(total%2 != 0){
            return curr;
        }

        return (curr + prev )/ 2.0;
    }
}
