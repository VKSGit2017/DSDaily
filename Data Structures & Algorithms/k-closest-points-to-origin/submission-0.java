/*
Euclidean Distance - Understanding that distance from origin is sqrt(x^2 + y^2), and that squared distance preserves ordering
Time Complexity - O(n.logk), n is points array and k is closest point given value
Space complexity - O(k)


*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a,b) -> Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0] + a[1]*a[1])
        );
        for(int[] point: points){
            maxHeap.offer(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i =0;
        while(!maxHeap.isEmpty()){
            res[i++]= maxHeap.poll();
        }
        return res;

    }
}
