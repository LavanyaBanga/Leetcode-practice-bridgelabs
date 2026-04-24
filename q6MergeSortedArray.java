import java.util.*;

public class q6MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      // last element in nums1 (valid part)
        int j = n - 1;      // last element in nums2
        int k = m + n - 1;  // last position of nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for nums1
        System.out.print("Enter m (number of elements in nums1): ");
        int m = sc.nextInt();

        System.out.print("Enter elements of nums1: ");
        int[] nums1 = new int[m + 100]; // extra space for merge
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input for nums2
        System.out.print("Enter n (number of elements in nums2): ");
        int n = sc.nextInt();

        System.out.print("Enter elements of nums2: ");
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        merge(nums1, m, nums2, n);

        // Output result
        System.out.print("Merged array: ");
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}