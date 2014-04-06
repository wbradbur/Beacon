package com.example.beacon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class login extends ActionBarActivity {
	private boolean isRemClicked = false;
		
	
		
	 @Override
	    protected void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.loginscreen);
	        
	        EditText passWord = (EditText) this.findViewById(R.id.PW);
	        EditText userName = (EditText) this.findViewById(R.id.Username);
	        String[] testUsers = new String[50];



	        CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);
	        rememberMe.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					isRemClicked = !isRemClicked;

				} });

	        Button b_newUser = (Button) findViewById(R.id.newUser);
	        

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
	 
	 public void openReg(View view){
		Intent intent = new Intent(this, Register.class); 
	    startActivity(intent);

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
