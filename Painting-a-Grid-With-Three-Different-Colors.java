class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> patterns = new ArrayList<>();
        generatePatterns(new int[m], 0, patterns);

        Map<Integer, List<Integer>> transitions = new HashMap<>();

        int size = patterns.size();
        for (int i = 0; i < size; i++) {
            transitions.put(i, new ArrayList<>());
            for (int j = 0; j < size; j++) {
                if (isCompatible(patterns.get(i), patterns.get(j))) {
                    transitions.get(i).add(j);
                }
            }
        }

        long[] dp = new long[size];
        Arrays.fill(dp, 1); 

        for (int col = 1; col < n; col++) {
            long[] newDp = new long[size];
            for (int i = 0; i < size; i++) {
                for (int prev : transitions.get(i)) {
                    newDp[i] = (newDp[i] + dp[prev]) % MOD;
                }
            }
            dp = newDp;
        }

        long result = 0;
        for (long val : dp) {
            result = (result + val) % MOD;
        }
        return (int) result;
    }

    private void generatePatterns(int[] current, int index, List<int[]> patterns) {
        if (index == current.length) {
            patterns.add(Arrays.copyOf(current, current.length));
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (index == 0 || current[index - 1] != color) {
                current[index] = color;
                generatePatterns(current, index + 1, patterns);
            }
        }
    }

    private boolean isCompatible(int[] row1, int[] row2) {
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == row2[i]) return false;
        }
        return true;
    }
}
