public class No4_寻找两个有序数组的中位数 {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int index1 = 0, index2 = 0;
        int middle = 0, history = 0;
        while ((index1 < nums1.length || index2 < nums2.length) && (index1 + index2) <= length / 2) {
            history = middle;
            if (index1 >= nums1.length) {
                middle = nums2[index2++];
            } else if (index2 >= nums2.length) {
                middle = nums1[index1++];
            } else {
                if (nums1[index1] > nums2[index2]) {
                    middle = nums2[index2++];
                } else {
                    middle = nums1[index1++];
                }
            }
            System.out.println("index1 = " + index1 + ", index2 = " + index2 + ", middle = " + middle + ", history = " + history);
        }
        if (length % 2 == 0) {
            return (middle + history) * 1.0 / 2;
        }
        return middle;
    }
}
