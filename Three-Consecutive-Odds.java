class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int z = 0; 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                z++;
                if (z == 3) {
                    return true;
                }
            } else {
                z = 0; 
            }
        }
        return false;
    }
}
