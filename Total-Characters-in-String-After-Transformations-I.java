class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1000000007;
        int n = s.length();
        int[] count = new int[26];
        for(int i = 0 ; i < n ;i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < t ; i++){
            int z = count['z'-'a'];
            for(int j = 24 ; j >=0 ; j--){
                count[j + 1] = count[j];
            }
            count[0] = z;
            count[1] = (count[1] + z) % MOD;
        }
        int res = 0;
        for(int x : count){
          res= (res + x) % MOD;
        }
        return res;
        
    }
}