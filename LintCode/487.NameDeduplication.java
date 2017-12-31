public class Solution {
    /*
     * @param : a string array
     * @return: a string array
     */
    public List<String> nameDeduplication(String[] names) {
        // write your code here
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < names.length; i ++){
            String str = names[i].toLowerCase();
            if(!map.containsKey(str)){
                map.put(str, 1);
                result.add(str);
            }
        }
        return result;
    }
}