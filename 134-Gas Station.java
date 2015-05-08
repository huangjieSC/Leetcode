public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || gas.length==0) return -1;
        if(cost == null || cost.length==0) return -1;
        if(gas.length!=cost.length) return -1;
        int len = gas.length;
        
        int leftHere = 0;
        int index = 0;
        int totalCost = 0;
        
        for(int i=0; i<len; i++){
            leftHere += gas[i]-cost[i];
            totalCost += gas[i]-cost[i];
            if(leftHere<0){ 
                index = i+1; 
                leftHere = 0;
            }
        }
        
        if(totalCost<0) return -1;
        return index;
    }
}
