package ca.ualberta.cs.lonelytwitter;

import android.view.ViewDebug;

import java.util.Date;

/**
 * Created by cechoi on 1/18/18.
 */

public class TweetImportant extends Tweet {

    public TweetImportant(String text){
        super(text);
    }

    public TweetImportant(String text,Date date){
        super(text,date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

}
