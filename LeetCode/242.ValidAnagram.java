//My solution: couldn't pass all test cases.
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int j = 0; j < t.length(); j++){
            map2.put(t.charAt(j), map2.getOrDefault(t.charAt(j), 0) + 1);
        }
        for(char key: map1.keySet()){
            if(map1.get(key) != map2.get(key)){
                return false;
            }
        }
        return true;
    }
}

//Solution2: Use Sort
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

//Solution3: Use counter
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for(int count: counter){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
