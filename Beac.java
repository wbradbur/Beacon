package com.example.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Beac extends ActionBarActivity {

	private boolean isRemClicked = false;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        EditText userName = (EditText) this.findViewById(R.id.Username);
	        EditText passWord = (EditText) this.findViewById(R.id.PW);
	        
	        String[] testUsers = new String[50];
	        
	        
	        
	        CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);
	        rememberMe.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					isRemClicked = !isRemClicked;
					
				} });
	        
	        Button b_newUser = (Button) findViewById(R.id.newUser);
	        b_newUser.setOnClickListener
	        (
	        		new OnClickListener()
	        		{
	        			@Override
	        			public void onClick(View arg0)
	        			{
	        				//TODO go to new user page
	        			}
	        		}
	        );
	        
	        Button b_Login = (Button) findViewById(R.id.login);
	        b_Login.setOnClickListener
	        (
	        		new OnClickListener()
	        		{
	        			@Override
	        			public void onClick(View arg)
	        			{
	        				//TODO check login
	        				
	        				//TODO login
	        			}
	        		}
	        );
	         
	        
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.beac, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }

}
