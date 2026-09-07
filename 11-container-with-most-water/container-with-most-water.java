class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int max = 0;

        while (l < r) {
            int hl = h[l];
            int hr = h[r];
            int area = (r - l) * (hl < hr ? hl : hr);

            if (area > max)
                max = area;

            if (hl < hr)
                l++;
            else
                r--;
        }

        return max;
    }
}