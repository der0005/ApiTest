package com.daniel.resource.bundle;

public class InfoRoute {
	private int id;
	private String name;
	private String length;
	private String duration;
	private String info;
	
	public InfoRoute(){
		
	}
	
	public InfoRoute(int id, String name, String length, String duration, String info){
		this.id = id;
		this.name = name;
		this.length = length;
		this.duration = duration;
		this.setInfo(info);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
