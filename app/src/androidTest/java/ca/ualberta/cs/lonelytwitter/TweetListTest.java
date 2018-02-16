package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cechoi on 2/15/18.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddList(){
        //assertTrue(Boolean.FALSE);//expecting true but we assert false so this test case will fail
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding normal tweet");

        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));

    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding normal tweet");

        tweets.add(tweet);

        Tweet returnTweet = tweets.getTweet(0);

        assertEquals(returnTweet.getDate(),tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding normal tweet");

        tweets.add(tweet);

        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding normal tweet");

        tweets.add(tweet);
        tweets.add(tweet);

        assertTrue(tweets.getCount()==2);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding normal tweet");
        
        tweets.addTweet(tweet);

    }

    public void testAddTweetE(){
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding normal tweet");
        tweets.addTweet(tweet);
        tweets.addTweet(tweet);

    }

    public void testgetTweet(){
        TweetList tweets = new TweetList();

        Date date = new Date();
        Tweet tweet = new NormalTweet("adding normal tweet1", date);
        tweets.addTweet(tweet);
        date = new Date(1997);
        tweet = new NormalTweet("adding normal tweet3", date);
        tweets.addTweet(tweet);
        date = new Date(2000);
        tweet = new NormalTweet("adding normal tweet2", date);
        tweets.addTweet(tweet);

        ArrayList<Tweet> sortList = tweets.getTweets();

        assertTrue((sortList.get(2).getMessage().equalsIgnoreCase("adding normal tweet1")&&sortList.get(0).getMessage().equalsIgnoreCase("adding normal tweet3") ));



    }

}
