# CinemalyticsJavaSDK

Required framework - Java 7, Maven

This project is an official SDK for Cinemalytics APIs avilable at https://developers.cinemalytics.com

Bollywood movies database showcase is available at https://www.cinemalytics.com

For any query/feedback, please mail at api@cinemalytics.com

Code available to browse at https://zGrepCode.com


# SDK Documentation
This SDK is divided into various **Repositories**; for example to access available APIs in **Movie** endpoint, you will need to get **MovieRepository** instance.

### Sample usage: 
```java
Cinemalytics cm = new Cinemalytics("your_token");
MovieRepository mr = cm.GetMovieRepositoryInstance();
Movie movie = mr.GetMovieById("movie_id");
```
