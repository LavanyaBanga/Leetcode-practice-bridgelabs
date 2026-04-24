import java.util.*;

class q1MajorityElement {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        int[] rotated = new int[n];

        for(int i = 0; i < n; i++){
            rotated[(i + k) % n] = nums[i];
        }

        for(int i = 0; i < n; i++){
            nums[i] = rotated[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        
        rotate(nums, k);

        System.out.print("Rotated array: ");
        for(int num : nums){
            System.out.print(num + " ");
        }

        sc.close();
    }
}