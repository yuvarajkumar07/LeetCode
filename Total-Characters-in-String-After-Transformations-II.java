class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] mat = new int[26][26];

        for (int i = 0; i < 26; i++) {
            int len = nums.get(i);
            for (int j = 1; j <= len; j++) {
                int next = (i + j) % 26;
                mat[i][next] = (mat[i][next] + 1) % MOD;
            }
        }

        int[][] expMat = matrixPower(mat, t);

        long[] freq = new long[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        long result = 0;
        for (int i = 0; i < 26; i++) {
            long count = 0;
            for (int j = 0; j < 26; j++) {
                count = (count + freq[j] * expMat[j][i]) % MOD;
            }
            result = (result + count) % MOD;
        }

        return (int) result;
    }

    private int[][] matrixPower(int[][] mat, int exp) {
        int size = mat.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) result[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, mat);
            }
            mat = multiply(mat, mat);
            exp >>= 1;
        }
        return result;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    res[i][j] = (int) ((res[i][j] + 1L * a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        return res;
    }
}
