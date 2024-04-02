class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(" ");
        if(lastIndex == -1) return s.length();
        return s.length() - lastIndex - 1;
    }
}