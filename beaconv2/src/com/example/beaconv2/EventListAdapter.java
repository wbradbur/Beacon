package com.example.beaconv2;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListAdapter {
	
	ListView eventViews;
	
	ArrayAdapter<String> adapter;
	
	Event[] events;
	
	Context ctx;
	
	EventListAdapter(Context context, Event[] eventList, ListView eventView, AndroidMap map)
	{
		eventViews = eventView;
		ctx = context;
		
		updateList(eventList, map);
	}
	
	public void updateList(Event[] eventList, AndroidMap map)
	{
		String[] temp = new String[eventList.length];
		for(int i = 0; i < eventList.length; i++)
		{
			temp[i] = eventList[i].getName() + " " + Float.toString(eventList[i].getDistance(map.getLocation())) + "mi"
					+"\nTime Left: " + eventList[i].getEndTime().toMinutes()/1000 +" min";
		}
		adapter=new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, temp);
		eventViews.setAdapter(adapter);
	}
}