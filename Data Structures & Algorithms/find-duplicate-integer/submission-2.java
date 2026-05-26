//Time complexity - O(N)
//Space complexity - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        for(int ele : nums){
            int index = Math.abs(ele)-1;
            if(nums[index] < 0){
                return Math.abs(ele);
            }
            nums[index] *= -1;
        }
        return -1;
    }
}
