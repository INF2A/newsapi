package main.java;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

/**
 * Created by rickb on 2-5-2017.
 */
public class RSSFeedParser {
    static final String ITEM = "item";
    static final String TITLE = "title";
    static final String LINK = "link";
    static final String DESCRIPTION ="description";
    static final String ATOM_LINK = "atom:link";
    static final String LANGUAGE = "language";
    static final String COPYRIGHT = "copyright";
    static final String LAST_BUILD_DATE ="lastBuildDate";
    static final String TTL = "ttl";
    static final String ATOM_LOGO = "atom:logo";
    static final String PUB_DATE = "pubDate";
    static final String GUID = "guid";
    static final String CATEGORY = "category";
    static final String ENCLOSURE = "enclosure";
    static final String DC_CREATOR = "dc:creator";
    static final String DC_RIGHTS = "dc:rights";
    static  final String PICTURE = "thumbnail";
    static  final String CONTENT_PICTURE = "content";

    private URL url;
    static final String BASE_URL = "";
    Feed feed;

    public RSSFeedParser(String feedUrl) {
        try {
            this.url = new URL(BASE_URL + feedUrl);
            feed=readFeed();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Feed readFeed() {
        Feed feed = null;
        try {
            boolean isFeedHeader = true;
            // Set header values intial to the empty string

            String title = "";
            String link = "";
            String description = "";
            String pubDate = "";
            String guid = "";
            String enclosure = "";
            String categories = "";
            String dc_creator = "";
            String dc_rights = "";
            String atom_link = "";
            String language = "";
            String copyright = "";


            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = read();

            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                //Attribute a = (Attribute) eventReader.next();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();
                    switch (localPart) {
                        case ITEM:
                            if (isFeedHeader) {
                                isFeedHeader = false;
                                feed = new Feed(title, link, description, language, copyright, pubDate);
                            }
                            event = eventReader.nextEvent();
                            break;
                        case TITLE:
                            title = removeQuotes(getCharacterData(event, eventReader)).trim();
                            break;
                        case DESCRIPTION:
                            description = removeQuotes(getCharacterData(event, eventReader)).trim();
                            break;
                        case LINK:
                            link = getCharacterData(event, eventReader);
                            break;
                        case GUID:
                            guid = getCharacterData(event, eventReader);
                            break;
                        case PUB_DATE:
                            pubDate = getCharacterData(event, eventReader);
                            break;
                        case PICTURE: case CONTENT_PICTURE:case ENCLOSURE:
                            Iterator<Attribute> attribue = event.asStartElement().getAttributes();
                            while(attribue.hasNext()){
                                Attribute myAttribute = attribue.next();
                                if(myAttribute.getName().toString().equals("url")){
                                    enclosure = myAttribute.getValue();
                                    if(enclosure.isEmpty())
                                    {
                                        enclosure = "http://navigatenorth.nl/wp-content/uploads/2015/12/news.jpg";
                                    }
                                }
                            }
                            break;
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                        NieuwsResponse message = new NieuwsResponse();
                        if(enclosure.isEmpty())
                        {
                            enclosure = "http://navigatenorth.nl/wp-content/uploads/2015/12/news.jpg";
                        }
                        message.setDescription(description);
                        message.setGuid(guid);
                        message.setLink(link);
                        message.setTitle(title);
                        message.setEnclosure(enclosure);
                        message.setPubDate(pubDate);
                        feed.getEntries().add(message);
                        event = eventReader.nextEvent();
                        continue;
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private InputStream read() {
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String removeQuotes(String toRemove)
    {
        return toRemove.replace("\"", "'");
    }
    public String entrieData()
    {
        return feed.enteriesToString();
    }

}
