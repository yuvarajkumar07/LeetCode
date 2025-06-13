class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int price : prices){
            if(price < min){
                min= price;

            }
            int ans = price - min;

            if(ans > max){
                max = ans;
            }

        }
        return max;
    }
}