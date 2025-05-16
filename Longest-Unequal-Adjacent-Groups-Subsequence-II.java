class Solution {
    public boolean hamCheck(String w1, String w2){
        int diff = 0;
        int n = w1.length();
        for (int i = 0; i < n; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        if (n == 1) {
            res.add(words[0]);
            return res;
        }

        int []dp = new int[n];
        int []prevIdx = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIdx, -1);
        int maxSubsLen = -1;
        int maxIdx = -1;

        for (int i = 1 ; i<n ;i++){
            for (int j = 0; j<i ; j++){
                if (groups[i] == groups[j]) continue;
                if (words[i].length() != words[j].length()) continue;
                if (!hamCheck(words[i], words[j])) continue;

                if (dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                    prevIdx[i] = j;
                }
            }
            if (maxSubsLen < dp[i]){
                maxSubsLen = dp[i];
                maxIdx = i;
            }
        }

        while (maxIdx != -1){
            res.add(words[maxIdx]);
            maxIdx = prevIdx[maxIdx];
        }

        Collections.reverse(res);
        return res;
        
    }
}