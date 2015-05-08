// brute force solution O(n)
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        for(int i=1; i< nums.length-1; i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
        }
        
        return nums[0]>nums[nums.length-1]?0:nums.length-1;
    }
}

// 二分来做。

首先我们找到中间节点mid，如果大于两边返回当前index就可以了，
如果左边的节点比mid大，那么我们可以继续在左半区间查找，这里面一定存在一个peak，为什么这么说呢？
假设此时的区间范围为[0, mid - 1]， 因为num[mid - 1]一定大于num[mid]了，
如果num[mid - 2] <= num[mid - 1]，那么num[mid - 1]就是一个peak。
如果num[mid - 2] > num[mid - 1]，那么我们就继续在[0, mid - 2]区间查找，
因为num[-1]为负无穷，所以最终我们绝对能在左半区间找到一个peak。同理右半区间一样。

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == n - 1 || nums[mid] >= nums[mid + 1]))             {
                    return mid;
            }else if(mid > 0 && nums[mid-1] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
