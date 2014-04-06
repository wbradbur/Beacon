package com.example.beaconv2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Create extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
		if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB)
		{
			getActionBar().hide();
		}
	
	}
	
	public void goEvents(View v)
	{
		TextView eName = (TextView) findViewById(R.id.eventName);
		String eNameString = eName.getText().toString();
		TextView eDesc = (TextView) findViewById(R.id.description);
		String eDescString = eDesc.getText().toString();
		TextView eTime = (TextView) findViewById(R.id.timeLeft);
		int minutes = Integer.parseInt(eTime.getText().toString());
		if(minutes > 120)
		{
			eTime.setBackgroundColor(Color.RED);
			return;
		}
		long timeLeft = minutes * 60 * 1000000;
    	Intent i = new Intent(this, Events.class);
    	i.putExtra("nameOfEvent", eNameString);
    	i.putExtra("description", eDescString);
    	i.putExtra("endTime", System.currentTimeMillis() + timeLeft);
    	startActivity(i); 
    }


}
