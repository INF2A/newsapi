package main.java;

import java.util.*;

/**
 * Created by rickb on 2-5-2017.
 */

/**
 * this class is used to create the entire feed in json format
 */
public class Feed {

    final List<NieuwsResponse> entries = new ArrayList<NieuwsResponse>();

    public Feed()
    {

    }

    /**
     *
     * @return returns the entries array, containing all newsResponse objects
     */

    public List<NieuwsResponse> getEntries() {
        return entries;
    }

    /**
     * add a new news response object to the entries list
     * @param message news response
     */

    public void setEntries(NieuwsResponse message){
        entries.add(message);
    }

    /**
     * convert all entries to one json string
     * @return json string with all entry data
     */

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
