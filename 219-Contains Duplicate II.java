public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0) return false;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i],list);
            }
            else{
                ArrayList<Integer> itemList = map.get(nums[i]);
                for(Integer index:itemList){
                    if(Math.abs(i-index)>0 && Math.abs(i-index)<=k)
                        return true;
                }
                map.get(nums[i]).add(i);
            }
        }
        return false;
    }
}
