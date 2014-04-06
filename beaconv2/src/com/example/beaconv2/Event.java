package com.example.beaconv2;

import android.location.Location;

public class Event {
	private String name;
	
	
	private EventTime endTime;
	
	private Location location;
	
	private String description;
	
	Event(String inName, String inDescription, long inTime, Location inLocation)
	{
		name = inName;
		endTime = new EventTime(inTime, TimeType.MILLIS);
		location = inLocation;
		description = inDescription;
	}
	
	public String getName()
	{
		return name;
	}
	
	public EventTime getEndTime()
	{
		return endTime;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public void repost()
	{
		if(EventTime.timeTil(endTime).toMinutes() < 30)
			endTime = new EventTime(System.currentTimeMillis() + 30 * 60 * 1000000, TimeType.MILLIS);
	}
	
	public float getDistance(Location inLocation)
	{
		int dist = (int) (location.distanceTo(inLocation) * 100);
		float mi = (float) ((int)(.000621 * dist) / 100.0f);
		return mi;
		 
	}
}

