class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the next position of a valid element
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the value to remove
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move it to the front
                k++; // Increment the count of valid elements
            }
        }
        
        return k; // Return the number of elements not equal to val
    }
}