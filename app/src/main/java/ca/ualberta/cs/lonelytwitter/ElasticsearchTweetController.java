package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by romansky on 10/20/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    // TODO we need a function which adds tweets to elastic search
    public static class AddTweetsTask extends AsyncTask<NormalTweet, Void, Void> {

        @Override
        protected Void doInBackground(NormalTweet... tweets) {// runs  when we call execute
            verifySettings();// make sure that client is set. if not client is created

            for (NormalTweet tweet : tweets) {//for each normal tweet in tweets
                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();// build based on tweet, index is testing(each team will have their own)

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);//what Driod client returns, this tweet will be sent to elastic search
                    if (result.isSucceeded()) {
                        tweet.setId(result.getId());
                    }else{
                        Log.i("Error","Hello");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the tweets");
                }

            }
            return null;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>> {
        @Override
        protected ArrayList<NormalTweet> doInBackground(String... search_parameters) {
            verifySettings();

            ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

                // TODO Build the query
            Search search = new Search.Builder(search_parameters[0]).addIndex("testing").addType("tweet").build();

            try {
               // TODO get the results of the query
                //search result here vs document result above
                SearchResult result = client.execute(search);
                if(result.isSucceeded()){
                    List<NormalTweet> foundTweets = result.getSourceAsObjectList(NormalTweet.class);//cross out means out dated method
                    tweets.addAll(foundTweets);
                }else{
                    Log.i("Error","Search query failed to find anything");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return tweets;
        }
    }




    public static void verifySettings() {
        if (client == null) {
            //uri of elastic search. normally we don't put a string here but use some configuration
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}