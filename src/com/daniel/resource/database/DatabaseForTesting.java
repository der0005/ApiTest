package com.daniel.resource.database;

import java.util.HashMap;
import java.util.Map;

import com.daniel.resource.bundle.*;

//------------------------------------------------------------------------
//Detta är endast för testning, endast en användare kan använda "databasen"
//
//Om SQL används så skapas kontakten med SQL här. 
//Så att endast en instans med databasen är etablerad.
//------------------------------------------------------------------------

public class DatabaseForTesting {
	
	private static Map<Integer, User> users = new HashMap<>();
	private static Map<Integer, Route> routes = new HashMap<>();

	public static Map<Integer, User> getUsers(){
		return users;
	}
	
	public static Map<Integer, Route> getRoutes(){
		return routes;
	}
		
}
