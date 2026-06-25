/*
Euclidean Distance - Understanding that distance from origin is sqrt(x^2 + y^2), 
and that squared distance preserves ordering

Squared Euclidean Distance: The code uses (x^2 + y^2\) instead of (sqrt{x^{2}+y^{2}}). Since it from origin 0,0
and we are avoiding sqrt for   

Since the actual distance uses a square root, and square root preserves ordering, we can instead compare using squared distance:

[
d^2 = x^2 + y^2
]

This avoids unnecessary computation and is sufficient for sorting.

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
