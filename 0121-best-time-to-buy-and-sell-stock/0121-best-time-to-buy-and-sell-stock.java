class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int maxprofit= 0;
        
        for(int i :prices)
        {
            if(i<buy)
            {
                buy= i;
            }
            int profit = i-buy;
            if(profit >maxprofit)
            {
                maxprofit= profit;
            }
        }
        return maxprofit;
    }
}


