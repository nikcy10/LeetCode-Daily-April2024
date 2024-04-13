import java.util.*;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Check if the matrix is null or empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // Array to store heights of columns
        int maxArea = 0; // Variable to store the maximum area of a rectangle

        for (char[] row : matrix) {
            // Calculate heights of columns in the current row
            for (int i = 0; i < cols; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0; // Increment height if '1', else reset to 0
            }

            Stack<Integer> stack = new Stack<>(); // Stack to store indices of increasing heights
            for (int i = 0; i < heights.length; i++) {
                // Process heights to find maximal rectangles
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()]; // Height of the popped element
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1; // Width of the rectangle
                    maxArea = Math.max(maxArea, h * w); // Update maxArea if a larger rectangle is found
                }
                stack.push(i); // Push the current index onto the stack
            }
        }

        return maxArea; // Return the maximum area of a rectangle
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int result = solver.maximalRectangle(matrix);
        System.out.println("Maximum rectangle area: " + result);
    }
}
