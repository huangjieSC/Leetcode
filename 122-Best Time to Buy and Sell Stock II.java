public class Solution {
    /**
     * http://www.cnblogs.com/springfor/p/3877065.html
     * 先找到递减的局部最低点，再找到递增的局部最高点，算一次加和，然后再这么找？ 这样就能保证买卖不会在同一天
     * */
     
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1)
            return 0;
        
        int i = 0;
        int total = 0;
        int buy,sell;
        
        while(i < len - 1){
            
            //寻找递减区间的最后一个值（局部最小点）
            while(i+1 < len && prices[i+1] < prices[i])
                i++;
            //局部最小点作为买入点
            buy = i;
            
            //找下一个点(卖出点至少为下一个点）
            i++;
            //不满足。。继续往下找递增区间的最后一个值（局部最高点）
            while(i<len && prices[i] >= prices[i-1])
                i++;
            //设置卖出点
            sell = i-1;
            //计算总和
            total += prices[sell] - prices[buy];
        }
        
        return total;
    }
}
