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

import com.daniel.resource.bundle.User;
import com.daniel.resource.database.UserService;


@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	UserService userService = new UserService();
	
	//--------------------------------------------------------
	// returns all info of users
	//--------------------------------------------------------
	@GET @Path("/test/{username}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public String testUsers(@PathParam("username") String username,@PathParam("password") String password) {	
		if(userService.isUserAdmin(username, password)){
			return "true";
		}else{	
			return "false";
		}
		
		
		
	}
	
	//--------------------------------------------------------
	// returns all info of users
	//--------------------------------------------------------
	@GET @Path("/{username}/{password}")
	public ArrayList<User> getUsers(@PathParam("username") String username,@PathParam("password") String password) {	
		if(userService.isUserAdmin(username, password)){
			return userService.getAllUser();
		}else{	
			return null;
		}
		
		
		
	}
	
	//--------------------------------------------------------
	// add user
	//--------------------------------------------------------
	@POST @Path("/{username}/{password}")
    public User addUser(@PathParam("username") String username,@PathParam("password") String password, User user) {
		if(userService.isUserAdmin(username, password)){
			return userService.addUser(user);
		}else{	
			return null;
		}
		      
    }
	
	//--------------------------------------------------------
	// update user
	//--------------------------------------------------------
	@PUT @Path("/{id}/{username}/{password}")
    public User updateUser(@PathParam("id") int id, @PathParam("username") String username,@PathParam("password") String password, User user) {
		user.setId(id);
		if(userService.isUserAdmin(username, password)){
			return userService.updateUser(user);
		}else{	
			return null;
		}
		   
    }
	
	//--------------------------------------------------------
	// delete user
	//--------------------------------------------------------
	
	@DELETE @Path("/{id}/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") int id, @PathParam("username") String username,@PathParam("password") String password) {
		if(userService.isUserAdmin(username, password)){
			userService.deleteUser(id);
		}
		   
    }
	
	

}