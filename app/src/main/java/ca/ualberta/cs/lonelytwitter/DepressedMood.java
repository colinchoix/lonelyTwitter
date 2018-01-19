package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cechoi on 1/18/18.
 */

public class DepressedMood extends Mood {

    public DepressedMood() {
        super();
    }

    public DepressedMood(Date date) {
        super(date);
    }


    @Override
    public String setMood(){
        return "Depressed";
    }

}
