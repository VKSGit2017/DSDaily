//Time Complexity - O(nlogm), n i sthe length of input array piles, m is the maximum no of bananas in pile
//Space Complexity - O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int res = end;

        while(start<=end){
            int mid = start + (end-start)/2;
            long totalTime = 0;
            for(int p:piles){
                totalTime += Math.ceil((double) p/mid);
            }
            if(totalTime <= h){
                res = mid;
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }
        return res;
    }
}
