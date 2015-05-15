public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(nums==null || nums.length==0) return list;
        
        Arrays.sort(nums);
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        for(int i=0; i<=nums.length; i++){
            combinations(nums,0, i, item, list);
        }
        return list;
    }
    
    public void combinations(int[] nums, int start, int size, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> list){
        if(item.size()==size){
            if(!list.contains(item)){
                list.add(new ArrayList<Integer>(item));
                return;
            }
        }
        
        for(int i=start; i<nums.length; i++){
            item.add(nums[i]);
            combinations(nums, i+1,size, item, list);
            item.remove(item.size()-1);
        }
    }
}
