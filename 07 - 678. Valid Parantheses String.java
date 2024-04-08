class Solution {
    public boolean checkValidString(String s) {
        // Initialize variables to track the minimum and maximum possible counts of '(' characters
        int minLeftCount = 0, maxLeftCount = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If the character is '(', increment both minLeftCount and maxLeftCount
                minLeftCount++;
                maxLeftCount++;
            } else if (c == ')') {
                // If the character is ')', handle it accordingly
                minLeftCount = Math.max(minLeftCount - 1, 0); // Decrease minLeftCount if greater than 0
                maxLeftCount--; // Always decrease maxLeftCount
                // Check if there are more ')' than '(' and '*' encountered so far
                if (maxLeftCount < 0) return false; // Invalid string
            } else { // '*' wildcard character
                // Treat '*' as ')' (decrease minLeftCount if greater than 0)
                minLeftCount = Math.max(minLeftCount - 1, 0);
                // Treat '*' as '(' (increase maxLeftCount)
                maxLeftCount++;
            }
        }

        // Check if all '(' can be matched with ')'
        return minLeftCount == 0;
    }
}


        return minLeftCount == 0;
    }
}