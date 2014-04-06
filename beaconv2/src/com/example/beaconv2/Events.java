package com.example.beaconv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Events extends ActionBarActivity {
	
	private static AndroidMap map;

	int numEvents = 20;

	ListView eventViews;

	Event[] events = new Event[20];
	private int eventsSize = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
		map = new AndroidMap(this);

		events[0] = new Event("event1", 3, map.getLocation());
		eventsSize++;
        
        Intent intent = getIntent();
        if(intent.hasExtra("nameOfEvent")){
        		String nameOfEvent=intent.getStringExtra("nameOfEvent");
        		events[eventsSize] = new Event(nameOfEvent, 3, map.getLocation());
        		eventsSize++;
        }
		eventViews = (ListView) this.findViewById(R.id.eventList);
		Event[] eventsArray = new Event[eventsSize];
		for(int i = 0; i < eventsSize; i++)
		{
			eventsArray[i] = events[i];
		}
		final Event[] finalEventsArray = eventsArray;
		final EventListAdapter adapter = new EventListAdapter(this, eventsArray, eventViews);

		 final Activity ctx = this;
			eventViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			  @Override
			  public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

			    String temp = (String)eventViews.getItemAtPosition(position);
			    for(Event e : finalEventsArray)
			    {
			    	if(e.getName() == temp)
			    		map.pointOnMap(e, ctx);
			    }
			  }
			});
    }
    
    public void goCreate(View v){
    	Intent i = new Intent(this, Create.class);
    	startActivity(i); 
    }

 

}
