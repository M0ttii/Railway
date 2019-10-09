# Railway
######Java standalone API for realtime data transfer between WebServer and Spigot-/Proxyserver using SocketIO

## How does it work?
The main idea behind this project is to simplify the communication between a WebServer (For example a webpanel) and a proxy/spigotserver. It provides several functions which can be used to work with realtime data transfer using SocketIO.

## Implementation
First you have to add the dependency to your project.
```xml
<dependency>
    	<groupId>com.github.com</groupId>
    	<artifactId>Railway</artifactId>
    	<version>1.0</version>
</dependency>
```
Now we are able to use Railway. To show how it works, i will show you an example. To execute code as soon as data has been sent by the webserver, you simply have to add an annotation to your function.
```java
@Railway("playerPunishment") //<- Socket Channel
public void execute(RailwayEvent event){
	//code
}
```
The socket channel has to be provided in brackets. The RailwayEvent parameter also is necessary. With the RailwayEvent you are able to get the data provided by the socket. For example a playername, a message, a punishment reason... You know what i mean huh?
It works like the following:
```java
@Railway("playerPunishment") //<- Socket Channel
public void execute(RailwayEvent event) throws JSONException{
	String playername = event.getData().getString("playername");
}
```
