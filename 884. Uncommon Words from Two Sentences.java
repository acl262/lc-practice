class Solution {
    public String[] uncommonFromSentences(String A, String B) {
    
        List<String> res = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        String [] str1 = A.split(" ");
        
        String [] str2 = B.split(" ");
        
        for(String str: str1) {
            
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
         for(String sr: str2) {
            
            map.put(sr, map.getOrDefault(sr, 0) + 1);
        }
        
        Set<String> keys = map.keySet();
        
        for(String key: keys) {
            
            if( map.get(key) == 1) {
                
                res.add(new String(key));
            }
        }
        
        String [] ret = new String [res.size()];
        
        ret = res.toArray(ret);

        return ret;

        
        
    }
}