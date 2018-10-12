class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        Set<String> SBs = new TreeSet<>();
        
        int res =0;
        
        String [] table = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        Map<Character, Integer> match = new HashMap<>();
        
        for(int i = 0; i < alphabet.length; i++) {
            
            match.put(alphabet[i], i );
            
        }
        String y = "";
        
        int count = 0;
        
        for(String word : words) {
            
            y = "";
            
            for(int i= 0; i < word.length(); i++) {
              // String x = x+ table[match.get(word.charAt(i))];
                y = y+ table[match.get(word.charAt(i))];
                
            }
            
            System.out.println("y= " + y);
            
            count = 0;
            
            for(String sb: SBs) {
                if (sb.equals(y)) {
                 System.out.println("break " );
                break;
                
            }
                
            else {
                count++;
            }
                               
        }
            
        if(count == SBs.size()) {
                SBs.add(y);
            }
            
        }
        
        return SBs.size();
        
    }
}
