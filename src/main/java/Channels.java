package main.java;

import java.util.*;

/**
 * Created by rickb on 9-5-2017.
 */

/**
 * this class is used to store all channels and channel urls
 */
public class Channels {
    private ArrayList<Channel> channelList;

    /**
     * constructor of the Channels class, creates a new ArrayList, and calls the fillList method.
     */
    public Channels()
    {
        channelList = new ArrayList<>();
        fillList();
    }

    /**
     * create all channels, preferences and add them to the channels list
     */
    private void fillList()
    {
        Channel bbc = new Channel("bbc","http://feeds.bbci.co.uk/news/rss.xml");
        bbc.addPreference("world", "http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
        bbc.addPreference("business","http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");
        bbc.addPreference("politics","http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");
        bbc.addPreference("health","http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");
        bbc.addPreference("education","http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");
        bbc.addPreference("science","http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");
        bbc.addPreference("technology","http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");
        bbc.addPreference("entertainment","http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");
        Channel cnn = new Channel("cnn", "http://rss.cnn.com/rss/edition.rss");
        cnn.addPreference("world","http://rss.cnn.com/rss/edition_world.rss");
        cnn.addPreference("business","http://rss.cnn.com/rss/money_news_international.rss");
        cnn.addPreference("politics","http://rss.cnn.com/rss/cnn_allpolitics.rss");
        cnn.addPreference("health","http://rss.cnn.com/rss/cnn_health.rss");
        cnn.addPreference("latest","http://rss.cnn.com/rss/cnn_latest.rss");
        cnn.addPreference("entertainment","http://rss.cnn.com/rss/edition_entertainment.rss");
        cnn.addPreference("sport","http://rss.cnn.com/rss/edition_sport.rss");
        Channel newYorkTimes = new Channel("nyt", "http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml");
        newYorkTimes.addPreference("world","http://rss.nytimes.com/services/xml/rss/nyt/World.xml");
        newYorkTimes.addPreference("business","http://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
        newYorkTimes.addPreference("technology","http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
        newYorkTimes.addPreference("sport","http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml");
        newYorkTimes.addPreference("science","http://rss.nytimes.com/services/xml/rss/nyt/Science.xml");
        newYorkTimes.addPreference("health","http://rss.nytimes.com/services/xml/rss/nyt/Health.xml");
        Channel nu = new Channel("nu","http://www.nu.nl/rss/Algemeen");
        nu.addPreference("business","http://www.nu.nl/rss/Economie");
        nu.addPreference("sport","http://www.nu.nl/rss/Sport");
        nu.addPreference("science","http://www.nu.nl/rss/Wetenschap");
        nu.addPreference("health","http://www.nu.nl/rss/Gezondheid");
        nu.addPreference("world","http://www.nu.nl/rss/Algemeen");
        Channel volkskrant = new Channel("vlk","http://www.volkskrant.nl/nieuws/rss.xml");
        volkskrant.addPreference("world","http://www.volkskrant.nl/buitenland/rss.xml");
        volkskrant.addPreference("business","http://www.volkskrant.nl/economie/rss.xml");
        volkskrant.addPreference("sport","http://www.volkskrant.nl/sport/rss.xml");
        volkskrant.addPreference("technology","http://www.volkskrant.nl/tech/rss.xml");
        volkskrant.addPreference("science","http://www.volkskrant.nl/wetenschap/rss.xml");
        volkskrant.addPreference("politics","http://www.volkskrant.nl/politiek/rss.xml");
        Channel ad = new Channel("ad","http://www.ad.nl/nieuws/rss.xml");
        ad.addPreference("world","http://www.ad.nl/buitenland/rss.xml");
        ad.addPreference("politics","http://www.ad.nl/politiek/rss.xml");
        ad.addPreference("business","http://www.ad.nl/economie/rss.xml");
        ad.addPreference("health","http://www.ad.nl/gezond/rss.xml");
        ad.addPreference("science","http://www.ad.nl/wetenschap/rss.xml");
        ad.addPreference("technology","http://www.ad.nl/digitaal/rss.xml");
        ad.addPreference("sport","http://www.ad.nl/sport/rss.xml");
        Channel reformatorischDagblad = new Channel("rd","http://www.rd.nl/laatste-nieuws-7.4514?ot=rd.rss.ot");
        reformatorischDagblad.addPreference("politics","http://www.rd.nl/politiek-7.4518?ot=rd.rss.ot");
        reformatorischDagblad.addPreference("church","http://www.rd.nl/kerk-religie-7.4512?ot=rd.rss.ot");
        reformatorischDagblad.addPreference("business","http://www.rd.nl/economie-7.4511?ot=rd.rss.ot");
        reformatorischDagblad.addPreference("books","http://www.rd.nl/boeken-7.4509?ot=rd.rss.ot");
        reformatorischDagblad.addPreference("royalities","http://www.rd.nl/koninklijk-huis-7.4513?ot=rd.rss.ot");
        reformatorischDagblad.addPreference("world","http://www.rd.nl/buitenland-7.4510?ot=rd.rss.ot");
        Channel dagelijksWoord = new Channel("dgw","http://feed.dagelijkswoord.nl/rss2/hsv");

        channelList.add(bbc);
        channelList.add(cnn);
        channelList.add(newYorkTimes);
        channelList.add(nu);
        channelList.add(volkskrant);
        channelList.add(ad);
        channelList.add(reformatorischDagblad);
        channelList.add(dagelijksWoord);

    }

    /**
     *
     * @return returns a arraylist with all channels
     */
    public ArrayList<Channel> getChannelList()
    {
        return channelList;
    }
}
