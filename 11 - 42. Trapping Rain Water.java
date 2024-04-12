class Solution {
    public int trap(int[] height) {
        // Check if the input array is empty
        if (height.length == 0) return 0;

        // Initialize pointers for the left and right ends of the array
        int left = 0, right = height.length - 1;
        // Initialize variables to track the maximum height on the left and right sides
        int leftMax = 0, rightMax = 0;
        // Initialize variable to store the total trapped water
        int result = 0;

        // Iterate until the left and right pointers meet
        while (left < right) {
            // If the height at the left pointer is less than the height at the right pointer
            if (height[left] < height[right]) {
                // Update leftMax if the current height is greater than or equal to leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Add the difference between leftMax and current height to the result
                    result += leftMax - height[left];
                }
                // Move the left pointer to the right
                left++;
            } else { // If the height at the right pointer is greater than or equal to the height at the left pointer
                // Update rightMax if the current height is greater than or equal to rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Add the difference between rightMax and current height to the result
                    result += rightMax - height[right];
                }
                // Move the right pointer to the left
                right--;
            }
        }

        // Return the total trapped water
        return result;
    }
}
