
class Solution {
    public int missingNumber(int[] nums) {
        int a = nums.length;
        int sum = (a * (a + 1)) / 2;
        int s2 = 0;

        for (int i = 0; i < a; i++) {
            s2 += nums[i];
        }

        return sum - s2;
    }
}
