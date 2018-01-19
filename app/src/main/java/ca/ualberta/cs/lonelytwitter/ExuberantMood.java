package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by cechoi on 1/18/18.
 */

public class ExuberantMood extends Mood {


    public ExuberantMood() {
        super();
    }

    public ExuberantMood(Date date) {
        super(date);
    }

    @Override
    public String setMood(){
        return "Exuberant";
    }

}
