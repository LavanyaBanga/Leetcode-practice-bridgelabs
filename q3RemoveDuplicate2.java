import java.util.*;

public class q3RemoveDuplicate2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // size input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // array input (sorted hona chahiye)
        System.out.println("Enter sorted elements:");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        q3RemoveDuplicate2 obj = new q3RemoveDuplicate2();
        int k = obj.removeDuplicates(nums);

        // output
        System.out.println("New length: " + k);
        System.out.print("Array after removing duplicates: ");
        for(int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int k = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[k-2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}