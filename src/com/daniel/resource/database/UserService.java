package com.daniel.resource.database;

import java.util.ArrayList;
import java.util.Map;

import com.daniel.resource.bundle.User;

public class UserService {
	
	private static Map<Integer, User> users = DatabaseForTesting.getUsers();
	
	public UserService() {
		
		//------------------------------------------------------------------------
		// lägger till användare för testning
		//------------------------------------------------------------------------
		
		User user1 = new User(1,"admin","admin","admin");
		User user2 = new User(2,"user","user","user");
		users.put(user1.getId(),user1);
		users.put(user2.getId(),user2);
	}

	public boolean isUserAdmin(String name, String password){
		ArrayList<User> arrayListUser = new ArrayList<User>(users.values());
		boolean temp = false; 
		for(int i=0 ; i<arrayListUser.size();i++){
			if (arrayListUser.get(i).getUserName().equals(name) && 
				arrayListUser.get(i).getPassword().equals(password) && 
				arrayListUser.get(i).getClearance().equals("admin")){
				
				temp=true;			
			}
		}
		return temp;
	}
	
	public ArrayList<User> getAllUser(){
		return new ArrayList<User>(users.values());
	}
	
	public User addUser(User userTemp){
		ArrayList<User> arrayListUser = new ArrayList<User>(users.values());
		int temp=0;
		if(arrayListUser.size()!=0){
			temp=arrayListUser.get(0).getId();
			for(int i=1; i<arrayListUser.size();i++){
				if(temp<=arrayListUser.get(i).getId()){
					temp++;
				}
			}				
		};
	
		temp++;
		userTemp.setId(temp);	
		users.put(temp, userTemp);
		return userTemp;
	}
	
	public User updateUser(User userTemp){
		ArrayList<User> arrayListUser = new ArrayList<User>(users.values());
		boolean temp=false;
		for(int i=0; i<arrayListUser.size();i++){
			if(arrayListUser.get(i).getId() == userTemp.getId()){
				temp=true;				
			}
		}
		
		if(temp){
			users.put(userTemp.getId(), userTemp);
			return userTemp;
		}else{			
			userTemp.setId(-1);
			return userTemp;
		}
	
	}
	
	public void deleteUser(int id){
		ArrayList<User> arrayListUser = new ArrayList<User>(users.values());
		boolean temp=false;
		for(int i=0; i<arrayListUser.size();i++){
			if(arrayListUser.get(i).getId() == id){
				temp=true;
			}
		}
		if(temp){
			users.remove(id);			
		}
	
	}

}