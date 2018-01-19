package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cechoi on 1/18/18.
 */

public abstract class Tweet implements Tweetable{

    private String text;
    private Date date;
    private ArrayList<Mood> moods;

    public Tweet(String text) {
        this.text = text;
        this.date = new Date();
        this.moods = new ArrayList<Mood>();
    }

    public Tweet(String text, Date date) {
        this.text = text;
        this.date = date;
        this.moods = new ArrayList<Mood>();
    }

    public Date getDate() {
        return this.date;
    }
   public void setDate(Date date) {
        this.date = date;
   }


   public void addMood (Mood m) {
        this.moods.add(m);
   }

   public String getText() {
       return this.text;
   }

   public void setText(String text)  throws TweetTooLongException{
        if (text.length() > 140){
            throw new TweetTooLongException();
        }else {
            this.text = text;
        }
   }

   public abstract Boolean isImportant();

}
