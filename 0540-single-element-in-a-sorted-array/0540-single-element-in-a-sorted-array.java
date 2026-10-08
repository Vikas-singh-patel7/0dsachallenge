class Solution {
    public int singleNonDuplicate(int[] nums) {

        // Edge cases
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int start = 1;
        int end = nums.length - 2;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Single element found
            if (nums[mid] != nums[mid - 1] &&
                nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // mid is odd
            if (mid % 2 == 1) {

                if (nums[mid - 1] == nums[mid]) {
                    // Correct pair, single element is on right
                    start = mid + 1;
                } else {
                    // Single element is on left
                    end = mid - 1;
                }

            } else { // mid is even

                if (nums[mid] == nums[mid + 1]) {
                    // Correct pair, single element is on right
                    start = mid + 2;
                } else {
                    // Single element is on left
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}