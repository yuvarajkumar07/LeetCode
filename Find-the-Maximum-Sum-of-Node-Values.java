class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        int minGain = Integer.MAX_VALUE;
        int flipCount = 0;

        for (int num : nums) {
            int flipped = num ^ k;
            if (flipped > num) {
                total += flipped;
                flipCount++;
                minGain = Math.min(minGain, flipped - num);
            } else {
                total += num;
                minGain = Math.min(minGain, num - flipped);
            }
        }

        if (flipCount % 2 == 0) {
            return total;
        }

        return total - minGain;
    }
}
