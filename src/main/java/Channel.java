package main.java;
import java.util.*;

/**
 * Created by rickb on 8-5-2017.
 */
public class Channel {
    private String name;
    private String url;
    private HashMap<String,String> voorkeuren;

    public Channel(String name, String url)
    {
        this.name = name;
        this.url = url;
        voorkeuren = new HashMap<String,String>();
    }

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return url;
    }

    public String getVoorkeurURL(String enteredVoorkeur)
    {
        if(voorkeuren.containsKey(enteredVoorkeur))
        {
            return voorkeuren.get(enteredVoorkeur);
        }
        else
        {
            return null;
        }
    }

    public void addVoorkeur(String voorkeur,String url)
    {
        voorkeuren.put(voorkeur,url);
    }

}
