package Heaps.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    class Tweet {
        int userId;
        int tweetId;
        int rank;

        Tweet(int u, int t, int r) {
            userId = u;
            tweetId = t;
            rank = r;
        }
    }

    public int ranks;

    public Map<Integer,List<Tweet>> tweets;
    Map<Integer, Set<Integer>> userFollowers;

    public Twitter() {
        tweets = new HashMap<>();
        userFollowers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId, ranks++);
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(tweet);

    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> tempQueue = new PriorityQueue<>((a, b) -> b.rank - a.rank);
        List<Integer> result = new ArrayList<>();
        for (int followerId : userFollowers.getOrDefault(userId,new HashSet<>())) {
            tempQueue.addAll(tweets.getOrDefault(followerId, new ArrayList<>()));
        }
        tempQueue.addAll(tweets.getOrDefault(userId,new ArrayList<>()));

        while (!tempQueue.isEmpty()) {
            Tweet tweet = tempQueue.poll();
            result.add(tweet.tweetId);

        }
        return result;

    }

    public void follow(int followerId, int followeeId) {
        if(!userFollowers.containsKey(followerId)){
            userFollowers.put(followerId,new HashSet<>());
        }
        userFollowers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userFollowers.getOrDefault(followerId,new HashSet<>()).remove(followeeId);

    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        List<Integer> param_2 = obj.getNewsFeed(1);
        obj.follow(1, 2);
        obj.postTweet(2, 6);
        List<Integer> param_3 = obj.getNewsFeed(1);
        obj.unfollow(1, 2);
        List<Integer> param_4 = obj.getNewsFeed(1);
        for (int i : param_2) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : param_3) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : param_4) {
            System.out.print(i + " ");
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

}
