package main.java;

/**
 * Created by basva on 2-5-2017.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;


@Path("/")
public class NieuwsAPI {
    private Channels channels = new Channels();
    private ArrayList<Channel> channs;
    private String defaultUrl = "http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk";

    /*
        Default news API
     */
    @Path("/news")
    @GET
    @Produces("application/json")
    public String News() {
        return new RSSFeedParser("http://feeds.bbci.co.uk/news/rss.xml").entrieData();
    }

    /*
        select one of the predefined news api's
     */
    @Path("/news/{channel}")
    @GET
    @Produces("application/json")
    public String News(@PathParam("channel") String channel) {
        channs = channels.getChannelList();
        for (int i = 0; i < channs.size(); i++) {
            if (channs.get(i).getName().equals(channel)) {
                String url = channs.get(i).getUrl();
                System.out.println(url);
                return new RSSFeedParser(url).entrieData();
            }
        }
        return new RSSFeedParser("http://feeds.washingtonpost.com/rss/world").entrieData();
    }

    @Path("/news/{channel}/{voorkeur}")
    @GET
    @Produces("application/json")
    public String News(@PathParam("channel") String channel, @PathParam("voorkeur") String voorkeur) {
        channs = channels.getChannelList();
        String url;
        System.out.println("channel in url: " + channel);
        System.out.println("channel list size " + channs.size());

        for (int i = 0; i < channs.size(); i++) {

            if (channs.get(i).getName().equals(channel)) {
                System.out.println("voorkeur in url" + voorkeur);
                System.out.println("voorkeur gevonden" + channs.get(i).getVoorkeurURL(voorkeur));
                url = channs.get(i).getVoorkeurURL(voorkeur);
                return new RSSFeedParser(url).entrieData();
            } else if (i == channs.size() && !channs.get(i).getName().equals(channel)) {
                System.out.println("else, name not found");
                return new RSSFeedParser(defaultUrl).entrieData();
            }
        }
        return new RSSFeedParser(defaultUrl).entrieData();
    }
}