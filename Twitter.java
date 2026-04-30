import java.util.*;

public class Twitter {

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    private int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int user : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.get(user);
            if (tweets != null) {
                for (int[] t : tweets) {
                    pq.add(t);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 10;

        while (!pq.isEmpty() && count-- > 0) {
            res.add(pq.poll()[1]);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);

        System.out.println(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}