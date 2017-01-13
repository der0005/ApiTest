package com.daniel.resource.database;

import java.util.HashMap;
import java.util.Map;

import com.daniel.resource.bundle.*;

//------------------------------------------------------------------------
//Detta �r endast f�r testning, endast en anv�ndare kan anv�nda "databasen"
//
//Om SQL anv�nds s� skapas kontakten med SQL h�r. 
//S� att endast en instans med databasen �r etablerad.
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
