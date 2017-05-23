package main.java;
import java.util.*;

/**
 * Created by rickb on 8-5-2017.
 */

/**
 * class used to store Channel information such as the name, corresponding url's and preferences
 */

public class Channel {
    private String name;
    private String url;
    private HashMap<String,String> preferences;

    /**
     *
     * @param name name of the channel
     * @param url default url of the channel
     */

    public Channel(String name, String url)
    {
        this.name = name;//set the name
        this.url = url;//set the url
        preferences = new HashMap<String,String>();//create a new HashMap
    }

    /**
     * gets the name of the channel
     * @return returns the name of the channel, as a string
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets the base url of the channel
     * @return returns the base url of the channel, as a string
     */
    public String getUrl()
    {
        return url;
    }

    /**
     *
     * @param enteredPreference enter the news preference you want to show on the feed
     * @return returns the preference url
     */
    public String getPreferenceURL(String enteredPreference)
    {
        //check if the entered preference exists
        if(preferences.containsKey(enteredPreference))
        {
            //preference was found, return the preference url
            return preferences.get(enteredPreference);
        }
        else
        {
            //entered preference was not in the list, so return null
            return null;
        }
    }

    /**
     * add a preference to the preferences list, with a preference name and the corresponding url
     * @param preference name of the preference
     * @param url url of the preference
     */
    public void addPreference(String preference,String url)
    {
        preferences.put(preference,url);//put the preference in the preferences hashmap.
    }

}
