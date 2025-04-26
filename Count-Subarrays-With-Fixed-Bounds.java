class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int lastMin = -1, lastMax = -1, lastInvalid = -1;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (num < minK || num > maxK) {
                lastInvalid = i;
            }

            if (num == minK) {
                lastMin = i;
            }

            if (num == maxK) {
                lastMax = i;
            }

            int validStart = Math.min(lastMin, lastMax);
            if (validStart > lastInvalid) {
                count += validStart - lastInvalid;
            }
        }

        return count;
    }
}
