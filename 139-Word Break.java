public class Solution {
    /**
     * 首先我们要存储的历史信息res[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示，我们需要一个长度为n的布尔数组来存储信息。然后假设我们现在拥有res[0,...,i-1]的结果，我们来获得res[i]的表达式。思路是对于每个以i为结尾的子串，看看他是不是在字典里面以及他之前的元素对应的res[j]是不是true，如果都成立，那么res[i]为true，写成式子是
     * 假设总共有n个字符串，并且字典是用HashSet来维护，那么总共需要n次迭代，每次迭代需要一个取子串的O(i)操作，然后检测i个子串，而检测是constant操作。所以总的时间复杂度是O(n^2)（i的累加仍然是n^2量级），而空间复杂度则是字符串的数量，即O(n)。代码如下：
     * */
public boolean wordBreak(String s, Set<String> dict) {
    if(s==null || s.length()==0)
        return true;
        
    if(dict.size()==0)
        return false;
        
    boolean[] res = new boolean[s.length()+1];
    res[0] = true;
    
    for(int i=0;i<s.length();i++) //pay attention to the conditions
    {
        StringBuilder str = new StringBuilder(s.substring(0,i+1)); // (0,i+1), not (0,i)
        for(int j=0;j<=i;j++) // pay attention to the conditions
        {
            if(res[j] && dict.contains(str.toString().substring(j,i+1)))
            {
                res[i+1] = true; // i+1, not i
                break;
            }
        }
    }
    
    return res[s.length()];
}
}
