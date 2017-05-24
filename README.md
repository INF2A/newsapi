# news api
This api is made for project Cluster & SmartMirror, it is designed to run on a raspberry pi in a docker container. the application uses a tomcat server in order to work, the default port is 8080. make sure to setup a tomcat server if you havent already.
this is a RESTfull api which will return news items in JSON format including the title, discription, publication date and a link to a image. 

# setup tomcat server

# Examples

do the following to make a api call when the application is running

connect to the application:
{ip_cluster}:{port_api}/
http://localhost:8080/

to get the default news feed 
{ip_cluster}:{poort_api}/news 
http://localhost:8080/news

to get the news feed of a specific news channel
{ip_cluster}:{port_api}/news/{channel} 
http://localhost:8080/news/bbc

to get the news feed of a specific channel and preferenced category
{ip_cluster}:{port_api}/news/{channel}/{preference} 
http://localhost:8080/news/bbc/world

JSON feed example:
<code>
{
    "feed":[
       {
          "title":"France Chooses a Leader, and Takes a Step Into the Unknown",
          "description":"In a deeply divided country, some ask whether either Emmanuel Macron or Marine Le Pen will have enough authority to actually govern.",
          "picture":"https://static01.nyt.com/images/2017/05/07/world/jp-france/jp-france-moth.jpg",
          "pubDate":"Sat, 06 May 2017 16:27:05 GMT"
       },
       {
          "title":"Why Macron Won: Luck, Skill and France",
          "description":"Emmanuel Macron",
          "picture":"https://static01.nyt.com/images/2017/05/08/world/08analysis-8/08analysis-8-moth.jpg",
          "pubDate":"Sun, 07 May 2017 22:25:22 GMT"
       }
   ]
}
</code>


# Cluster

# SmartMirror
