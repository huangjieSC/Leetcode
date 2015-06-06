public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return -1;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
        public int compare(Integer val1, Integer val2) {
            return val1 - val2;
        }
    });
        
        for(int i=0; i<k; i++)
            minHeap.add(nums[i]);
        
        for(int i=k; i<nums.length; i++){
            if(nums[i]>minHeap.peek()){
                int top = minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        
        return minHeap.poll();
    }
}
