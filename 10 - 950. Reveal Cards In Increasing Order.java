public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Step 1: Sort the deck in increasing order
        Arrays.sort(deck);

        // Step 2: Initialize a deque to keep track of indices
        Deque<Integer> indices = new LinkedList<>();

        // Step 3: Add indices from 0 to deck.length-1 to the deque
        for (int i = 0; i < deck.length; i++) {
            indices.addLast(i);
        }

        // Step 4: Initialize the answer array to store the result
        int[] answer = new int[deck.length];

        // Step 5: Simulate the revealing process
        for (int card : deck) {
            // Step 5a: Retrieve the index of the next card to be revealed
            int idx = indices.pollFirst();

            // Step 5b: Assign the current card to the answer array at the retrieved index
            answer[idx] = card;

            // Step 5c: Check if the deque is not empty before reinserting the index
            if (!indices.isEmpty()) {
                // Step 5d: Remove and reinsert the index to simulate the revealing process
                indices.addLast(indices.pollFirst());
            }
        }

        // Step 6: Return the answer array
        return answer;
    }
}
