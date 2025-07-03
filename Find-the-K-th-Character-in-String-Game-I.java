class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb=new StringBuilder("a");
        while(sb.length()<k){
            int len=sb.length();
            for(int i=0;i<len;i++){
                char c=sb.charAt(i);
                sb.append((c=='z')?'a':(char)(c+1));
            }
        }
        return sb.charAt(k-1);
    }
}