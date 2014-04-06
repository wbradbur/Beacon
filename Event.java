public class Event {
	private String name;
	
	
	private long endTime;
	
	private Location location;
	
	Event(String inName, long inTime, Location inLocation)
	{
		name = inName;
		endTime = inTime;
		location = inLocation;
	}
	
	public String getName()
	{
		return name;
	}
	
	public long getEndTime()
	{
		return endTime;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public float getDistance(Location inLocation)
	{
		return location.distanceTo(inLocation);
	}
}
