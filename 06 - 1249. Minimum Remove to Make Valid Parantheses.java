class Solution {
    public String minRemoveToMakeValid(String s) {
        // Convert the input string to a character array for easier manipulation
        char[] ch = s.toCharArray();
        
        // Count variable to keep track of unmatched opening parentheses
        int count = 0;
        
        // Iterate through the string from left to right
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                // Increment count for each opening parenthesis found
                count++;
            } else if (ch[i] == ')') {
                if (count > 0) {
                    // If there are unmatched opening parentheses, decrement count
                    count--;
                } else {
                    // Mark this closing parenthesis for removal by setting it to 0
                    ch[i] = 0;
                }
            }
        }
        
        // Reset count for the second pass from right to left
        count = 0;
        
        // Iterate through the string from right to left
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == ')') {
                // Increment count for each closing parenthesis found
                count++;
            } else if (ch[i] == '(') {
                if (count > 0) {
                    // If there are unmatched closing parentheses, decrement count
                    count--;
                } else {
                    // Mark this opening parenthesis for removal by setting it to 0
                    ch[i] = 0;
                }
            }
        }
        
        // Build the result string without the marked characters (0's)
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (c != 0) {
                sb.append(c);
            }
        }
        
        // Return the final result as a string
        return sb.toString();
    }
}
