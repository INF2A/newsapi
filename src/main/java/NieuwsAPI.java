package main.java;

/**
 * Created by basva on 2-5-2017.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;


/**
 *
 */

@Path("/")
public class NieuwsAPI {
    private Channels channels = new Channels();
    private ArrayList<Channel> channs;
    private String defaultUrl = "http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk";

    /**
     *
     * @returna string in json format with of the default news feed.
     *
     */

    @Path("/news")
    @GET
    @Produces("application/json")
    public String News() {
        return new RSSFeedParser("http://feeds.bbci.co.uk/news/rss.xml").entrieData();
    }

    /**
     *
     * @param channel select one of the predefined news api channels
     * @return return a string in json format with a chosen news page feed (if it exists)
     */
    /*

     */
    @Path("/news/{channel}")
    @GET
    @Produces("application/json")
    public String News(@PathParam("channel") String channel) {
        channs = channels.getChannelList();//fill the arraylist channs with channels
        for (int i = 0; i < channs.size(); i++) {//loop through the channs array
            //search for the name. if the channel param matches one of the names in the channs arraylist, get that url and return a new feed with the right url
            if (channs.get(i).getName().equals(channel)) {
                //name was found, set the url string to the url associated with the given name.
                String url = channs.get(i).getUrl();
                //return a new feed, with the url that was just set.
                return new RSSFeedParser(url).entrieData();
            }
        }
        //no name was found, return a default feed.
        return new RSSFeedParser("http://feeds.washingtonpost.com/rss/world").entrieData();
    }

    /**
     *
     * @param channel select one of the predefined news api channels
     * @return return a string in json format with the with a chosen news page feed (if it exists), with preferences
     */
    @Path("/news/{channel}/{preference}")
    @GET
    @Produces("application/json")
    public String News(@PathParam("channel") String channel, @PathParam("preference") String preference) {
        channs = channels.getChannelList();//fill the channs array with chanels form the channels object.
        String url;
        //search for the channel name
        for (int i = 0; i < channs.size(); i++) {
            //check if the param channel is equal to one of the names in the arraylist
            if (channs.get(i).getName().equals(channel)) {
                //name is equal, get the preference url and return the right feed
                url = channs.get(i).getPreferenceURL(preference);//set the url to the preference url
                return new RSSFeedParser(url).entrieData();//return the feed with the preference
            } else if (i == channs.size() && !channs.get(i).getName().equals(channel)) {
                //name was not in the list, return a default feed
                return new RSSFeedParser(defaultUrl).entrieData();
            }
        }
        //return default feed
        return new RSSFeedParser(defaultUrl).entrieData();
    }
}