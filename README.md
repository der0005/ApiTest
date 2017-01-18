## Information
This is a test project that involves creating an Restful API that handles hiking trails.

The API is based on:
* jersey 1.19.1 (JAX-RS 1.9.2)

A simple database is used for test purposes which limits the number of users. 
The database is not thread safe. 

When the server is initiated, information is included in the database from:
* RouteService.java (route test data)
* UserService.java (user test data)

Below are the preset user information.

|user| username  | password  | clearance  |
|---|---|---|---|
|1| admin	| admin | admin |
|2| user	| user | user |

## Prerequisites
* IDE (Eclipse 4.6)
* JDK 1.8
* Tomcat 8.5

## Install and run the project
I included a apitest.war file, that includes the Jersey library (JAX-RS). This can be deployed on any Java EE web container.

### On local Tomcat server
1. Add the apitest.war file to the “tomcat/webapps” folder. 
2. Start server by running startup.bat, located in tomcat/bin.

When the server starts, the folders are created under “tomcat/webapps/apitest”. If the server is local, the API can be reached by “http://localhost:8080/testapi/”. Please check the “Connector port =8080” in “Tomcat\conf\server.xml”.

#### If no deployment are initiated.
* Log onto the server http://localhost:8080 and deploy manually. Check for username and password in “Tomcat\conf\tomcat-users.xml”
* Make sure the Tomcat folder has read and write privileges.

#### If server dont start
* Make sure the environment variable CATALINA_HOME exists, that contains the pathname to the directory in which Tomcat has been installed.
* Make sure the environment variable CLASSPATH exists, that contains the pathname to jsp-api.jar, located in the tomcat/lib.

### Important remark

The “TestWebpage” that was created to interact with this API, can’t do the requests if Tomcat (with apitest) is used on the same computer (the same-origin policy). To test the API, the Postman Chrome App can be used. 

https://www.getpostman.com/docs/introduction

### In Eclipse:
Import the “apitest.war” file. Deploy the API to an installed local server.

## Interaction with the API
The webpage in the repositories WebPageTest, can be used to interact with this API.

If same-origin policy, there are options (buttons) on the main page, to bypass login either as “user” or “admin”. In that case test route information is defined from file.

If the same-origin policy is NOT an issue, make sure to set the correct path (rootURL) in “settings.js” (the pathname to the directory in which testapi is placed).


## Methods
|Method  (route)| 	URL: 	|					Action:	|
|---|---|---|
|GET			|/api/route/info					|Retrieve all routes (basic information) |
|GET 			|/api/route/info/3 				|Retrieve route with id == 3 (all information)|
|POST			|/api/route/{username}/{password}		|Add a new route*|
|PUT 			|/api/route/3/{username}/{password}		|Update route with id == 3*|
|DELETE 			|/api/route/3/{username}/{password}		|Delete route with id == 3*|

|Method (user) 		|URL 						|Action:
|---|---|---||
|GET			|/api/user/test/{username}/{password}		|Check if user has admin clearance.|		
|GET			|/api/user/{username}/{password}			|Retrieve all users*|
|POST			|/api/user/{username}/{password}			|Add a new user*|
|PUT 			|/api/user/{id}/{username}/{password}		|Update user with id == 3*|
|DELETE 			|/api/user/{id}/{username}/{password}		|Delete user with id == 3*|

*username and password, with admin clearance.
	
## Data types
The data type is Json according to the structure bellow. 
The exception is the GET method that checks if the user has "admin" clearance. It returns 
a String ("true"/"false").

Route (basic information):
```json
[
	{
	  "id": 1,
	  "name": "Skogstur2",
	  "info": "fin tur",
	  "length": "10.8 km",
	  "duration": "2.4 timmar"
	}
]
```
Route:
```json
{
  "id": 1,
  "places": [
    {
      "routeId": 2,
      "position": {
        "latitude": 55.5464,
        "longitude": 20
      },
      "name": "Sten",
      "info": "stor sten"
    },
    {
      "routeId": 2,
      "position": {
        "latitude": 55.5324,
        "longitude": 20.01
      },
      "name": "Bro",
      "info": "fin bro"
    }
  ],
  "listPoss": [
    {
      "latitude": 55.5464,
      "longitude": 20.01
    },
    {
      "latitude": 55.5464,
      "longitude": 20.02
    },
    {
      "latitude": 55.5464,
      "longitude": 20.03
    },
    {
      "latitude": 55.5464,
      "longitude": 20.04
    },
    {
      "latitude": 55.5464,
      "longitude": 20.05
    }
  ],
  "name": "Skogstur2",
  "info": "fin tur",
  "length": "10.8 km",
  "duration": "2.4 timmar"
}
```
User:
```json
[
  {
    "id": 1,
    "userName": "admin",
    "password": "admin",
    "clearance": "admin"
  },
  {
    "id": 2,
    "userName": "user",
    "password": "user",
    "clearance": "user"
  }
  ]
  ```
