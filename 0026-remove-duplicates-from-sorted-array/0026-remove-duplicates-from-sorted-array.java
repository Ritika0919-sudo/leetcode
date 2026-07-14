class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: An empty array has 0 unique elements
        if (nums.length == 0) {
            return 0;
        }
        
        // 'j' tracks the index of the last placed unique element
        int j = 0;
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If we find a value different from the last unique element
            if (nums[i] != nums[j]) {
                j++;           // Move to the next slot
                nums[j] = nums[i]; // Update it with the new unique value
            }
        }
        
        // The number of unique elements is the index 'j' + 1
        return j + 1;
    }
}
