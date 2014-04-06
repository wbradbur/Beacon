package com.example.beaconv2;

public class EventTime 
{
	private long magnitude;
	public EventTime(long amount, TimeType type)
	{
		magnitude = amount;
	}
	
	public static EventTime timeTil(EventTime oTime)
	{
		long amount = oTime.magnitude;
		long delta = amount - System.currentTimeMillis();
		return new EventTime(delta, TimeType.MILLIS);
	}
	
	public long toMillis()
	{
		return magnitude;
	}
	
	public int toSeconds()
	{
		return (int) (magnitude / 1000000);
	}
	
	public int toMinutes()
	{
		return toSeconds() / 60;
	}
	
	public int toHours()
	{
		return toMinutes() / 60;
	}
	
	private static long toMillis(long amount, TimeType type)
	{
		if(type == TimeType.HOURS)
		{
			return toMillis(amount * 60, TimeType.MINUTES);
		}
		else if(type == TimeType.MINUTES)
		{
			return toMillis(amount * 60, TimeType.SECONDS);
		}
		else if(type == TimeType.SECONDS)
		{
			return amount * 1000000;
		}
		return amount;
	}
}
