package com.example.beaconv2;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListAdapter {
	
	ListView eventViews;
	
	ArrayAdapter<String> adapter;
	
	Event[] events;
	
	Context ctx;
	
	EventListAdapter(Context context, Event[] eventList, ListView eventView)
	{
		eventViews = eventView;
		ctx = context;
		String[] temp = new String[eventList.length];
		for(int i = 0; i < eventList.length; i++)
		{
			temp[i] = eventList[i].getName();
		}
		updateList(temp);
	}
	
	public void updateList(String[] stringList)
	{
		adapter=new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, stringList);
		eventViews.setAdapter(adapter);
	}
}