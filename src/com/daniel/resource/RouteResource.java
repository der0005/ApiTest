package com.daniel.resource;

import javax.ws.rs.PathParam;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.daniel.resource.bundle.InfoRoute;
import com.daniel.resource.bundle.Route;
import com.daniel.resource.database.RouteService;
import com.daniel.resource.database.UserService;


@Path("/route")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RouteResource {
	
	RouteService routeService = new RouteService();
	UserService userService = new UserService();
	
	//--------------------------------------------------------
	// returns all routes.
	//--------------------------------------------------------
	@GET @Path("/info")
	public ArrayList<InfoRoute> getAllRoute(){
		return routeService.getInfoAllRouts();
	}
	
	//--------------------------------------------------------
	// returns a specific route according to id.
	//--------------------------------------------------------
	@GET @Path("/info/{id}")
	public Route getSpecificRoute(@PathParam("id") int id){		
		return routeService.getSpecificRouteData(id);
	}
	
	//--------------------------------------------------------
	// saves a route
	//--------------------------------------------------------
	@POST @Path("/{username}/{password}")
    public Route addNewRoute(@PathParam("id") int id, @PathParam("username") String username,@PathParam("password") String password, Route route) {
		if(userService.isUserAdmin(username, password)){
			return routeService.addRoute(route);
		}else{	
			route.setId(-1);
			return route;
		}
		      
    }
	
	//--------------------------------------------------------
	// update a route
	//--------------------------------------------------------
	@PUT @Path("/{id}/{username}/{password}")
    public Route updateRoute(@PathParam("id") int id, @PathParam("username") String username,@PathParam("password") String password, Route route) {
		if(userService.isUserAdmin(username, password)){
			route.setId(id);
			return routeService.updateRoute(route);
			
		}else{
			route.setId(-1);
			return route;
		}
		   
    }
	
	//--------------------------------------------------------
	// delete a route
	//--------------------------------------------------------
	
	@DELETE @Path("/{id}/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteRoute(@PathParam("id") int id, @PathParam("username") String username,@PathParam("password") String password){	
		
		if(userService.isUserAdmin(username, password)){
			routeService.deleteRoute(id);
		}
	}
	
	

}
