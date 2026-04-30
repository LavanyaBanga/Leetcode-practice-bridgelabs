import java.util.*;

public class TopK {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        TopK obj = new TopK();
        int[] nums = {1,1,1,2,2,3};
        int[] ans = obj.topKFrequent(nums, 2);

        for (int x : ans) System.out.print(x + " ");
    }
} 
