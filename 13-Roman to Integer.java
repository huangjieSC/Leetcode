public class Solution {
    public int romanToInt(String s) {
        if (s.length()==0) return 0;

        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);

        int n = s.length();
        int sum = m.get(s.charAt(n-1));
        for (int i=n-2; i>=0; i--) {
            if (m.get(s.charAt(i)) >= m.get(s.charAt(i+1)))
                sum += m.get(s.charAt(i));
            else
                sum -= m.get(s.charAt(i));
        }
        return sum;
    }
}
