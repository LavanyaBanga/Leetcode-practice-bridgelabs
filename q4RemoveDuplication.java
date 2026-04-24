import java.util.*;

public class q4RemoveDuplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // size input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // sorted array input
        System.out.println("Enter sorted elements:");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        q4RemoveDuplication obj = new q4RemoveDuplication();
        int k = obj.removeDuplicates(nums);

        // output
        System.out.println("New length: " + k);
        System.out.print("Array after removing duplicates: ");
        for(int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}