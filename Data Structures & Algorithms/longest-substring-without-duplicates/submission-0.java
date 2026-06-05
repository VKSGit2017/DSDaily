//Time Complexity - O(n) , n is string length
//Space Complexity - O(m), m is total no of unique characters in the string
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> unique = new HashSet<>();
        int low = 0, result = 0;

        for(int high= 0; high< s.length(); high++){
            while(unique.contains(s.charAt(high))){
                unique.remove(s.charAt(low));
                low++;
            }
            unique.add(s.charAt(high));
            result = Math.max(result, high-low+1);
        }
        return result;
    }
}
