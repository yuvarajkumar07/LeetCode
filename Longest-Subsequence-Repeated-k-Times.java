class Solution {
    String res = "";
    List<Character> list = new ArrayList<>();
    
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c = 'a'; c <= 'z'; c++)
            if (count[c - 'a'] >= k) list.add(c); 
        dfs(s, "", k);
        return res;
    }
    
    private void dfs(String s, String sub, int k) {
        if (sub.length() > 1 && !isSub(s, sub, k)) return;
        if (sub.length() > res.length()) res = sub;
        for (int i = list.size() - 1; i >= 0; i--) {
            String next = sub + list.get(i);
            dfs(s, next, k);
        }
    }
    
    private boolean isSub(String s, String sub, int k) {
        int j = 0;
        int repeat = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < (k - repeat - 1) * sub.length()) return false;
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
                j %= sub.length();
                if (j == 0) {
                    repeat++;
                    if (repeat == k) return true;
                }
            }
        }
        return false;
    }
}