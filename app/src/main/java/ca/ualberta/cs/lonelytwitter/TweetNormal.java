package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cechoi on 1/18/18.
 */

public class TweetNormal extends Tweet {

    public TweetNormal(String text){
        super(text);
    }

    public TweetNormal(String text, Date date) {

        super(text,date);

    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

}
