# NetflixLastResumeService
This is a Spring Boot application that provides an API to track and manage users' watch history on a streaming platform. The application uses MongoDB to store user watch history and provides RESTful APIs to retrieve and update watch records.

Features

Get Last 6 Watched Shows: Retrieve the most recent 6 shows or movies a user has watched.

Update Watch History: Update the user's watch history when they watch a new show.

API Endpoints

1. Get Last 6 Watched Shows

GET /watch-history/{userId}

Description: Fetches the last 6 shows/movies watched by a user.

2. Update Watch History

POST /watch-history/

{
  "userId": "userId_33d0db580212",
  "watchedShowList": [
    {
      "showId": "showId_18aaccd46a5b",
      "showName": "showName_79d6a39b22d0",
      "timestamp": 1743513671487
    }
  ]
}

Description: Updates the user's watch history with a new show. We can pass list of shows as well which can contain same show with different time stamp. show id is unique

3.  Add user

POST user/addUser

{
  "userId": "userId_f226d9918664",
  "userName": "userName_425a1feafebf"
}

Description : Adds new user with empty list of shows


Installation & Setup

1. Prerequisites

Java 11+

Maven

MongoDB (Running locally or via Docker)

2. Clone the Repository

git clone git@github.com:lakshyasinghal2000/NetflixLastResumeService.git

3. Update application.properties

spring.application.name=OTT-show-resume-service
spring.data.mongodb.uri=mongodb://localhost:27017/netflixDB
spring.data.mongodb.database=netflixDB
server.port=8080
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false


