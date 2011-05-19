package org.springframework.social.instagram.api;

import java.util.List;


public interface LocationOperations {
	
	/**
	 * Get information about a location.
	 * @param locationId	Location ID
	 * @return	Location information
	 */
	Location getLocation(long locationId);
	
	/**
	 * Get recent media based on location
	 * @param locationId	Location ID
	 * @return	A list of media
	 */
	PagedMediaList getRecentMedia(long locationId);
	
	/**
	 * Get recent media based on location
	 * @param locationId	Location ID
	 * @param maxId			Will return media after this ID
	 * @param minId			Will return media before this ID
	 * @param minTimeStamp	Will return media after this UNIX time stamp
	 * @param maxTimeStamp	Will return media before this UNIX time stamp
	 * @return	A list of media
	 */
	PagedMediaList getRecentMedia(long locationId, long maxId, long minId, long minTimeStamp, long maxTimeStamp);
	
	/**
	 * Search for a location by geographic coordinate using default distance of 1000 meters.
	 * @param latitude	Latitude of the center search coordinate
	 * @param longitude	Longitude of the center search coordinate
	 * @return	A list of locations
	 */
	List<Location> search(double latitude, double longitude);
	
	/**
	 * Search for a location by geographic coordinate and distance.
	 * @param latitude	Latitude of the center search coordinate
	 * @param longitude	Longitude of the center search coordinate
	 * @param distance	Distance, in meters, from center (max distance is 5000 meters)
	 * @return	A list of locations
	 */
	List<Location> search(double latitude, double longitude, int distance);
	
	/**
	 * Search for a location by a FourSquare venue ID
	 * @param String FourSquare venue ID
	 * @return	A list of locations
	 */
	List<Location> search(long foursquareId);
	
	public static final String LOCATIONS_ENDPOINT = "locations/";
	
}
