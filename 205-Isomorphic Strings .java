public class Solution {
    /**
     * given "foo", "app"; returns true we can map f -> a and o->p
given "bar", "foo"; returns false we can't map both 'a' and 'r' to 'o'
given "ab", "ca"; returns true we can map 'a' -> 'b' and 'c' -> 'a'

最直接的方法就是见两个HashMap维护住字符的对应关系，O(n)
     * */
     
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        
		HashMap<Character,Character> map1=new HashMap<Character, Character>();
		HashMap<Character,Character> map2=new HashMap<Character, Character>();
		
		for(int i=0;i<s.length();i++){
			char c1=s.charAt(i);
			char c2=t.charAt(i);
			if(map1.containsKey(c1)){
				if(map1.get(c1)!=c2) return false;
			}
			if(map2.containsKey(c2)){
				if(map2.get(c2)!=c1) return false;
			}
			
			map1.put(c1, c2);
			map2.put(c2, c1);
		}
		return true;
    }
}
