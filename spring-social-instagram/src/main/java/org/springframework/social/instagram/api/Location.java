package org.springframework.social.instagram.api;

public class Location {
	
	private long id;
	private String name;
	private double latitude;
	private double longitude;
	
	public Location(long id, String name, double latitude, double longitude) {
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}
