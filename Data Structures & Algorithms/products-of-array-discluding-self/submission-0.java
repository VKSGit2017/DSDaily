//Time Complexity - O(n)
//Space Complexity - O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rightProd = new int[n];
        int[] leftProd = new int[n];
        int[] result = new int[n];

        rightProd[0] = 1;
        leftProd[n-1] = 1;
        for(int i =1; i<n; i++){
            rightProd[i] = nums[i-1] * rightProd[i-1];
        }

        for(int i =n-2; i>=0; i--){
            leftProd[i] = nums[i+1] * leftProd[i+1];
        }

        for(int i = 0; i<n;i++){
            result[i] = leftProd[i] * rightProd[i];
        }
        return result;
    }
}  
