package com.daniel.resource.bundle;

public class Place {
	private int routeId;
	private LatLng position;
	private String name;
	private String info;
	
	public Place(){
		
	}
	
	public Place(int routeId, LatLng position,String name, String info){
		this.routeId=routeId;
		this.position = position;
		this.name = name;
		this.info = info;
	}

	public LatLng getPosition() {
		return position;
	}

	public void setPosition(LatLng position) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

}
