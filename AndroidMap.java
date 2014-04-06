package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

public class AndroidMap 
{
	private LocationManager locManage;
	private LocationListener locListen;
	private String locHandler;
	private Location currentLoc;
	public AndroidMap(Activity context)
	{
		locManage = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		locHandler = LocationManager.NETWORK_PROVIDER;
		
		locListen = new LocationListener()
		{

			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				currentLoc = location;
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
		};
		locManage.requestLocationUpdates(locHandler, 0, 0, locListen);
	}

	public Location getLocation()
	{
		return currentLoc;
	}
	
	public void pointOnMap(Event e, Activity context)
	{
		pointOnMap(e.getLocation(), e.getName(), context);
	}

	public void pointOnMap(Location location, String description, Activity context)
	{
		Intent goToMap = new Intent(Intent.ACTION_VIEW,
				Uri.parse("geo:0,0?=" + location.getLatitude()+"," +location.getLongitude() 
				+ "(" + description + ")"));
		context.startActivity(goToMap);
	}
}
