public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if(n==0){
            list.add(0); 
            return list;
        }
        
        List<Integer> preList = grayCode(n-1);
        list.addAll(preList);
        for(int i=preList.size()-1; i>=0; i--){
            int val = preList.get(i);
            val += 1<<n-1;
            list.add(val);
        }
        return list;
    }
}
