package com.example.beaconv2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ToggleButton;

public class Splash extends ActionBarActivity {

	/*@TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_real);
		if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB)
		{
			getActionBar().hide();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent inte = new Intent(this, Events.class);
		startActivity(inte);
	}*/
	
	private static AndroidMap map;

	private static int maxEvents = 20;

	ListView eventViews;

	private static Event[] events = new Event[maxEvents];
	private static boolean isCreated = false;
	private static int eventsSize = 1;
	
	@SuppressLint("NewApi") @TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        
		map = new AndroidMap(this);
		if(!isCreated)
        {
        	Location loc = new Location(map.getLocation());
        	long time = System.currentTimeMillis();
        	loc.setLatitude(36.99117);
        	loc.setLongitude(-122.051138);
        	events[0] = new Event("Rugby Game", "Simba is better than Fedor", time + 80 * 60 * 1000000,loc);
        	isCreated = true;
        }
		
		if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB)
		{
			getActionBar().hide();
		}
		
        Intent intent = getIntent();
        if(intent.hasExtra("nameOfEvent"))
        {
        		String nameOfEvent=intent.getStringExtra("nameOfEvent");
        		events[eventsSize] = new Event(nameOfEvent,intent.getStringExtra("description"), intent.getLongExtra("endTime", 0), map.getLocation());
        		eventsSize++;
        }
		eventViews = (ListView) this.findViewById(R.id.eventList);
		Event[] eventsArray = new Event[eventsSize];
		for(int i = 0; i < eventsSize; i++)
		{
			eventsArray[i] = events[i];
		}
		
		final ToggleButton repost = (ToggleButton) findViewById(R.id.repost);
		
		
		final Event[] finalEventsArray = eventsArray;
		final EventListAdapter adapter = new EventListAdapter(this, eventsArray, eventViews, map);

		 final Activity ctx = this;
			eventViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			  @Override
			  public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3){

			    String temp = (String)eventViews.getItemAtPosition(position);
			    for(Event e : finalEventsArray)
			    {
			    	if(e.getName().equals(temp.substring(0, e.getName().length())))
			    	{
			    		if(repost.isChecked() && e.getLocation().distanceTo(map.getLocation()) <= .5)
			    		{
			    			e.repost();
			    			arg1.setBackgroundColor(0x6600FF00);
			    		}
			    		else if(repost.isChecked())
			    		{
			    			Notification rebuildError = new NotificationCompat.Builder(ctx).setContentTitle("Unable to Repost")
			    			.setContentText("You Must Be Within 0.5 Miles to Repost an Event").build();
			    			NotificationManager mNot = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
			    			mNot.notify(9498079, rebuildError);
			    			arg1.setBackgroundColor(0x66FF0000);
			    		}
			    		else
			    		{
			    			map.pointOnMap(e, ctx);
			    		}
			    	}
			    		
			    }
			  }
			});
    }
    
    public void goCreate(View v){
    	Intent i = new Intent(this, Create.class);
    	startActivity(i); 
    }
}
