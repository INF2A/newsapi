package main.java;

import java.util.*;

/**
 * Created by rickb on 9-5-2017.
 */
public class Channels {
    private ArrayList<Channel> channelList;

    public Channels()
    {
        channelList = new ArrayList<>();
        fillList();
    }
    private void fillList()
    {
        Channel bbc = new Channel("bbc","http://feeds.bbci.co.uk/news/rss.xml");
        bbc.addVoorkeur("world", "http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
        bbc.addVoorkeur("business","http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");
        bbc.addVoorkeur("politics","http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");
        bbc.addVoorkeur("health","http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");
        bbc.addVoorkeur("education","http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");
        bbc.addVoorkeur("science","http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");
        bbc.addVoorkeur("technology","http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");
        bbc.addVoorkeur("entertainment","http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");
        Channel cnn = new Channel("cnn", "http://rss.cnn.com/rss/edition.rss");
        cnn.addVoorkeur("world","http://rss.cnn.com/rss/edition_world.rss");
        cnn.addVoorkeur("business","http://rss.cnn.com/rss/money_news_international.rss");
        cnn.addVoorkeur("politics","http://rss.cnn.com/rss/cnn_allpolitics.rss");
        cnn.addVoorkeur("health","http://rss.cnn.com/rss/cnn_health.rss");
        cnn.addVoorkeur("latest","http://rss.cnn.com/rss/cnn_latest.rss");
        cnn.addVoorkeur("entertainment","http://rss.cnn.com/rss/edition_entertainment.rss");
        cnn.addVoorkeur("sport","http://rss.cnn.com/rss/edition_sport.rss");
        Channel newYorkTimes = new Channel("nyt", "http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml");
        newYorkTimes.addVoorkeur("world","http://rss.nytimes.com/services/xml/rss/nyt/World.xml");
        newYorkTimes.addVoorkeur("business","http://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
        newYorkTimes.addVoorkeur("technology","http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
        newYorkTimes.addVoorkeur("sport","http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml");
        newYorkTimes.addVoorkeur("science","http://rss.nytimes.com/services/xml/rss/nyt/Science.xml");
        newYorkTimes.addVoorkeur("health","http://rss.nytimes.com/services/xml/rss/nyt/Health.xml");
        Channel nu = new Channel("nu","http://www.nu.nl/rss/Algemeen");
        nu.addVoorkeur("business","http://www.nu.nl/rss/Economie");
        nu.addVoorkeur("sport","http://www.nu.nl/rss/Sport");
        nu.addVoorkeur("science","http://www.nu.nl/rss/Wetenschap");
        nu.addVoorkeur("health","http://www.nu.nl/rss/Gezondheid");
        nu.addVoorkeur("world","http://www.nu.nl/rss/Algemeen");
        Channel volkskrant = new Channel("vlk","http://www.volkskrant.nl/nieuws/rss.xml");
        volkskrant.addVoorkeur("world","http://www.volkskrant.nl/buitenland/rss.xml");
        volkskrant.addVoorkeur("business","http://www.volkskrant.nl/economie/rss.xml");
        volkskrant.addVoorkeur("sport","http://www.volkskrant.nl/sport/rss.xml");
        volkskrant.addVoorkeur("technology","http://www.volkskrant.nl/tech/rss.xml");
        volkskrant.addVoorkeur("science","http://www.volkskrant.nl/wetenschap/rss.xml");
        volkskrant.addVoorkeur("politics","http://www.volkskrant.nl/politiek/rss.xml");
        Channel ad = new Channel("ad","http://www.ad.nl/nieuws/rss.xml");
        ad.addVoorkeur("world","http://www.ad.nl/buitenland/rss.xml");
        ad.addVoorkeur("politics","http://www.ad.nl/politiek/rss.xml");
        ad.addVoorkeur("business","http://www.ad.nl/economie/rss.xml");
        ad.addVoorkeur("health","http://www.ad.nl/gezond/rss.xml");
        ad.addVoorkeur("science","http://www.ad.nl/wetenschap/rss.xml");
        ad.addVoorkeur("technology","http://www.ad.nl/digitaal/rss.xml");
        ad.addVoorkeur("sport","http://www.ad.nl/sport/rss.xml");
        Channel reformatorischDagblad = new Channel("rd","http://www.rd.nl/laatste-nieuws-7.4514?ot=rd.rss.ot");
        reformatorischDagblad.addVoorkeur("politics","http://www.rd.nl/politiek-7.4518?ot=rd.rss.ot");
        reformatorischDagblad.addVoorkeur("church","http://www.rd.nl/kerk-religie-7.4512?ot=rd.rss.ot");
        reformatorischDagblad.addVoorkeur("business","http://www.rd.nl/economie-7.4511?ot=rd.rss.ot");
        reformatorischDagblad.addVoorkeur("books","http://www.rd.nl/boeken-7.4509?ot=rd.rss.ot");
        reformatorischDagblad.addVoorkeur("royalities","http://www.rd.nl/koninklijk-huis-7.4513?ot=rd.rss.ot");
        reformatorischDagblad.addVoorkeur("world","http://www.rd.nl/buitenland-7.4510?ot=rd.rss.ot");
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

    public ArrayList<Channel> getChannelList()
    {
        return channelList;
    }
}
