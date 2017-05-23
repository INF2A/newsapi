package main.java;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickb on 2-5-2017.
 */

/**
 * this class will store all individual news messages
 */
public class NieuwsResponse {
    private  String title;
    private  String link;
    private  String description;
    private  String pubDate;
    private  String guid;
    private  String enclosure ;
    private  String dc_creator;
    private  String dc_rights;
    private  String atom_link;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getAtom_link() {
        return atom_link;
    }

    public String getLink() {
        return link;
    }

    public void setAtom_link(String atom_link) {
        this.atom_link = atom_link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDc_creator() {
        return dc_creator;
    }

    public String getDc_rights() {
        return dc_rights;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public String getGuid() {
        return guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setDc_creator(String dc_creator) {
        this.dc_creator = dc_creator;
    }

    public void setDc_rights(String dc_rights) {
        this.dc_rights = dc_rights;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

}
