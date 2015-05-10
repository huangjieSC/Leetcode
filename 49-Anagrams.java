public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
        if(strs==null || strs.length==0) return list;
        
        HashMap<String,List<String>> map = new HashMap<String, List<String>>();
        for(String s:strs){
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String newS = String.valueOf(chArray);
            if(map.containsKey(newS)){
                map.get(newS).add(s);
            }
            else{
                List<String> item = new ArrayList<String>();
                item.add(s);
                map.put(newS,item);
            }
        }
        
        Set<String> keySet = map.keySet();
        for(String s: keySet){
            if(map.get(s).size()>1)
                list.addAll(map.get(s));
        }
        return list;
    }
}
