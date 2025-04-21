class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefixSum = 0;
        long minSum = 0;
        long maxSum = 0;

        for (int diff : differences) {
            prefixSum += diff;
            minSum = Math.min(minSum, prefixSum);
            maxSum = Math.max(maxSum, prefixSum);
        }

        long minStart = lower - minSum;
        long maxStart = upper - maxSum;

        long count = maxStart - minStart + 1;
        return (int) Math.max(0, count);
    }
}
