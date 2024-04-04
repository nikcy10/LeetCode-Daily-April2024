class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int openBrackets = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openBrackets++;
            } else if (s.charAt(i) == ')') {
                openBrackets--;
            }
            result = Math.max(result, openBrackets);
        }
        return result;
    }
}
