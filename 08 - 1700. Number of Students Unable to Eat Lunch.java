class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // Count circle and square sandwich preferences
        int circleSandwich = 0;
        int squareSandwich = 0;
        for(int choice: students){   
            if(choice==0){ circleSandwich++; } // Circle sandwich preference
            else { squareSandwich++; } // Square sandwich preference
        }

        // Serve sandwiches according to preferences
        for(int sandwich: sandwiches){
            if(sandwich==0 && circleSandwich==0){ return squareSandwich; } // Serve square sandwiches
            if(sandwich==1 && squareSandwich==0){ return circleSandwich; } // Serve circle sandwiches
            if(sandwich==0){ circleSandwich--; } // Decrement circle sandwich count
            else { squareSandwich--; } // Decrement square sandwich count
        }
        return 0; // All students served
    }
}
