public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int profitHere=0;
        int minPriceIndex=0;
        int maxProfit=0;
        
        for(int i=1; i<prices.length; i++){
            profitHere = prices[i]-prices[minPriceIndex];
            if(profitHere>maxProfit)
                maxProfit=profitHere;
            if(prices[i] < prices[minPriceIndex])
                minPriceIndex = i;
        }
        
        return maxProfit;
    }
}
