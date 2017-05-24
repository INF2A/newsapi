# News api
This api is made for project Cluster & SmartMirror, it is designed to run on a raspberry pi in a docker container. the application uses a tomcat server in order to work, the default port is 8080. make sure to setup a tomcat server if you havent already.
this is a RESTfull api which will return news items in JSON format including the title, discription, publication date and a link to a image. 

# Setup tomcat server

https://www.jetbrains.com/help/idea/2017.1/creating-and-running-your-first-web-application.html

# Examples

do the following to make a api call when the application is running

<b>connect to the application(should start when you run the application):</b><br>
{ip_cluster}:{port_api}/<br>
http://localhost:8080/<br>

<b>to get the default news feed</b><br> 
{ip_cluster}:{poort_api}/news <br>
http://localhost:8080/news<br>

<b>to get the news feed of a specific news channel</b><br>
{ip_cluster}:{port_api}/news/{channel} <br>
http://localhost:8080/news/bbc<br>

<b>to get the news feed of a specific channel and preferenced category</b><br>
{ip_cluster}:{port_api}/news/{channel}/{preference} <br>
http://localhost:8080/news/bbc/world<br>

JSON feed example: 
<br>
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

more information about the cluster: https://github.com/INF2A/RPI-docker-cluster

# SmartMirror

more information about the SmartMirror: https://github.com/INF2A/Smart-mirror
