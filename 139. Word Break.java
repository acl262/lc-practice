class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s == null || s.length() <1 || wordDict == null || wordDict.size() <1) return false;
        
        int length = s.length();
        boolean [] match = new boolean[length+1];
        match [0] = true;
        for(int i =1; i < length+1; i++) {
            for(int j  = 0; j <i; j ++) {
                
                if( match[j] && wordDict.contains(s.substring(j,i))) {
                    
                    match[i] = true;
                    break;
                    
                }
          
            }
        }
        
    return match[length];

    }
}
