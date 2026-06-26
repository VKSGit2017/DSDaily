//Time Complexity - O(m), m length of s2
//Space complexity - O(1), int array is of 26 size which is constant so O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i =0; i< n; i++){
            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;
        }

        for(int j = n; j<m; j++){
            if(Arrays.equals(s1Freq, s2Freq)) return true;

            s2Freq[s2.charAt(j)-'a']++;

            s2Freq[s2.charAt(j-n)-'a']--;
        }
        return Arrays.equals(s1Freq, s2Freq);
    }
}
