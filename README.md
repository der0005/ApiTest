## Information
This project is a test.

The API is based on RESTFul using Jersey framework.

A simple database is used for test purposes which limits the number of users. 
The database is not thread safe. 

When the server is initiated data are included in the database.
RouteService.java (route test data)
UserService.java (user test data)

Below is the preset user information.

|user| username  | password  | clearance  |
|---|---|---|---|
|1| admin	| admin | admin |
|2| user	| user | user |

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

*a username and password with clearance "admin" 
needs to added.
	
## Data types
The API sends and receives Json objects according to the structure bellow.  
The exception is the GET method used to get "all routes". This method returns 
a list of Json objects with the two lists, “places” and “listPoss” removed.
Also the GET methood that checks if the users has "admin" clearance, returns 
a String (true/false).

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
