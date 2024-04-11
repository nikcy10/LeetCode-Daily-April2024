class Solution {
    public String removeKdigits(String num, int k) {
        // Initialize a stack to store digits
        Stack<Character> stack = new Stack<>();
        // Initialize a StringBuilder to construct the result
        StringBuilder sb = new StringBuilder();

        // Iterate through each digit in the input number
        for (char digit : num.toCharArray()) {
            // While there are remaining removals (k > 0) and the stack is not empty,
            // and the current digit is less than the digit at the top of the stack,
            // pop elements from the stack and decrement k
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            // Push the current digit onto the stack
            stack.push(digit);
        }

        // Handle remaining removals if k > 0
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Construct the result by popping elements from the stack and inserting them at the beginning of the StringBuilder
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        // Remove leading zeros from the result
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Return the result, or "0" if the result is empty
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
