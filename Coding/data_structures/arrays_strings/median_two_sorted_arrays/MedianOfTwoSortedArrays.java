package median_two_sorted_arrays;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] res = new int[totalLength];

        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length == 0) {
            res = nums2;
        } else if (nums2.length == 0) {
            res = nums1;
        }

        int i = 0; // first

        int j = 0; // second

        int index = 0; // res

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[index] = nums1[i];
                i++;
            } else {
                res[index] = nums2[j];
                j++;
            }

            index++;
        }

        while (i < nums1.length) {
            res[index] = nums1[i++];
            index++;
        }

        while (j < nums2.length) {
            res[index] = nums2[j++];
            index++;
        }

        if (res.length % 2 != 0) {
            return res[res.length / 2];
        } else {
            int mid = res.length / 2;
            return ((double) (res[mid] + res[mid - 1])) / 2;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { 3, 4 };

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
