package org.springframework.social.instagram.api.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.instagram.api.Location;
import org.springframework.social.instagram.api.LocationOperations;
import org.springframework.social.instagram.api.PagedMediaList;

/**
 * Implementation of {@link LocationOperations}, providing a binding to Instagram's location-oriented REST resources.
 */
public class LocationTemplate extends AbstractInstagramOperations implements LocationOperations {

	public LocationTemplate(InstagramTemplate instagram, boolean isAuthorizedForUser) {
		super(instagram, isAuthorizedForUser);
	}
	
	public Location getLocation(long locationId) {
		return get(buildUri(LOCATIONS_ENDPOINT + Long.toString(locationId) +"/"), LocationContainer.class).getObject();
	}

	public PagedMediaList getRecentMedia(long locationId) {
		return getRecentMedia(locationId, 0, 0, 0, 0);
	}
	
	public PagedMediaList getRecentMedia(long locationId, long maxId, long minId, long minTimeStamp, long maxTimeStamp) {
		Map<String,String> params = new HashMap<String,String>();
		if(maxId > 0) params.put("max_id", Long.toString(maxId));
		if(minId > 0) params.put("min_id", Long.toString(minId));
		if(minTimeStamp > 0) params.put("min_timestamp", Long.toString(minTimeStamp));
		if(maxTimeStamp > 0) params.put("max_timestamp", Long.toString(maxTimeStamp));
		return get(buildUri(LOCATIONS_ENDPOINT + Long.toString(locationId) + "/media/recent/", params), PagedMediaList.class);
	}

	public List<Location> search(double latitude, double longitude) {
		return search(latitude, longitude, 0);
	}

	public List<Location> search(double latitude, double longitude, int distance) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("lat", Double.toString(latitude));
		params.put("lng", Double.toString(longitude));
		if(distance > 0) params.put("distance", Integer.toString(distance));
		return get(buildUri(LOCATIONS_ENDPOINT + "search/", params), LocationList.class).getList();
	}

	public List<Location> search(long foursquareId) {
		return get(buildUri(LOCATIONS_ENDPOINT + "search/", Collections.singletonMap("foursquare_id", Long.toString(foursquareId))), LocationList.class).getList();
	}	
	
}
