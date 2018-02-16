package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by cechoi on 2/15/18.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i){
        return tweets.get(i);
    }

    public void delete (Tweet tweet){
        tweets.remove(tweet);
    }

    public void addTweet(Tweet tweet){
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }else{
            tweets.add(tweet);
        }
    }

    public ArrayList getTweets(){
        Collections.sort(this.tweets);
        return this.tweets;
    }

    public int getCount(){
        return tweets.size();
    }


}
