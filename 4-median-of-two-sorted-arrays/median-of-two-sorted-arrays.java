
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int h = m;

        while (l <= h) {

            int cuto = (l + h) / 2;
            int cute = (m + n + 1) / 2 - cuto;

            int left1 = (cuto == 0) ? Integer.MIN_VALUE : nums1[cuto - 1];
            int right1 = (cuto == m) ? Integer.MAX_VALUE : nums1[cuto];

            int left2 = (cute == 0) ? Integer.MIN_VALUE : nums2[cute - 1];
            int right2 = (cute == n) ? Integer.MAX_VALUE : nums2[cute];

            if (left1 <= right2 && left2 <= right1) {

                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2)
                            + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }

            } else if (left1 > right2) {
                h = cuto - 1;
            } else {
                l = cuto + 1;
            }
        }

        return 0.0;
    }
}

