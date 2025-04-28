class Solution {
    public long countSubarrays(int[] nums, long k) {
        long total = 0;
        long windowSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while (windowSum * (right - left + 1) >= k) {
                windowSum -= nums[left];
                left++;
            }

            total += (right - left + 1);
        }

        return total;
    }
}
