package main.java;

import java.util.*;

/**
 * Created by rickb on 2-5-2017.
 */
public class Feed {
    private  String title;
    private  String link;
    private  String description;
    private  String atom_link;
    private  String language;
    private  String copyright;
    private  String lastBuildDate;
    private  String ttl;
    private  String atom_logo;
    final List<NieuwsResponse> entries = new ArrayList<NieuwsResponse>();

    public Feed(String title, String link, String description, String language, String copyright, String lastBuildDate)
    {
        this.title = title;
        this.link = link;
        this.description = description;
        this.atom_link = atom_link;
        this.language = language;
        this.copyright = copyright;
        this.lastBuildDate = lastBuildDate;
        this.ttl = ttl;
        this.atom_logo = atom_logo;
    }

    public List<NieuwsResponse> getEntries() {
        return entries;
    }

    public String getAtom_logo() {
        return atom_logo;
    }

    public String getLink() {
        return link;
    }

    public String getTtl() {
        return ttl;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public String getAtom_link() {
        return atom_link;
    }

    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "Feed{title:" +
                title + ", description:" +
                description +", link:" +
                link +", atom_link" +
                atom_link+", language:" +
                language + ", lastBuildDate" +
                lastBuildDate + ", ttl" +
                ttl + ", atom_logo" +
                atom_logo + "}";
    }

    public String enteriesToString()
    {
        String response = "{\n    \"feed\":[\n";
        for (int i =0; i < entries.size(); i++)
        {
            response += "       {\n          \"title\":\"" + entries.get(i).getTitle()+
                      "\",\n          \"description\":\"" + entries.get(i).getDescription() +
                      "\",\n          \"picture\":\"" + entries.get(i).getEnclosure() +
                      "\",\n          \"pubDate\":\"" + entries.get(i).getPubDate();
                    if(i != entries.size()-1) {
                        response +="\"\n       },\n";
                    }
                    else
                    {
                        response +="\"\n       }\n";
                    }
        }
        response += "   ]\n}";
        return response;
    }

}
