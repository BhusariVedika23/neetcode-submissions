class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 =  nums2.length;
        int i = 0;
        int j = 0;
        int median1 = 0;
        int median2 = 0;
        for(int a = 0; a < (length1 + length2)/2 + 1; a++){
            median2 = median1;
            if(i < length1 && j < length2){
                if(nums1[i] > nums2[j]){
                    median1 = nums2[j];
                    j++;
                } else {
                    median1 = nums1[i];
                    i++;
                }
            } else if(i < length1){
                median1 = nums1[i];
                i++;
            }else{
                median1 = nums2[j];
                j++;
            }
        }
        if((length1 + length2) % 2 == 1){
            return (double) median1;
        } else {
            return (median1 + median2) / 2.0;
        }
    }
}
