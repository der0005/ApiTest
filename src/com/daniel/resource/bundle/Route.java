package com.daniel.resource.bundle;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Route {
	private int id;
	
	private ArrayList<Place> places = new ArrayList<Place>();
	private ArrayList<LatLng>  listPoss = new ArrayList<LatLng>();
	
	private String name;
	private String info;
	private String length;
	private String duration;
	
	public Route(){
		
	}
	
	public Route(int id, ArrayList<Place> places, ArrayList<LatLng> listPoss, String name, String info, String length, String duration){
		this.id = id;
		this.places = places;
		this.listPoss = listPoss;
		this.name = name;
		this.info = info;
		this.length = length;
		this.duration = duration;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Place> getPlaces() {
		return places;
	}

	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}

	public ArrayList<LatLng> getListPoss() {
		return listPoss;
	}

	public void setListPoss(ArrayList<LatLng> listPoss) {
		this.listPoss = listPoss;
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
}
