class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Initialize a variable to keep track of total time
        int time = 0;

        for(int i=0; i<tickets.length; i++) {
            // If the current index is less than or equal to k
            if(i <= k) 
                Add minimum time of tickets[i] and tickets[k]
                time += Math.min(tickets[i], tickets[k]);
            // If the current index is greater than k
            else 
                // Add minimum time of tickets[i] and tickets[k] - 1
                time += Math.min(tickets[i], tickets[k] - 1);
        }

        // Return the total time required
        return time;
    }
}
