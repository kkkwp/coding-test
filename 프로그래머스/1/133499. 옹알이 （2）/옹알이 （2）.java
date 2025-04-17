class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String b : babbling) {
            boolean isValid = true;
            for (String word : words) {
                if (b.contains(word + word)) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) continue;
            
            for (String word : words)
                b = b.replace(word, " ");
            
            if (b.replace(" ", "").length() == 0) 
                answer++;      
        }
        return answer;
    }
}