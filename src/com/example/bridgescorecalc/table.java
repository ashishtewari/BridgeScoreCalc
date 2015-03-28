package com.example.bridgescorecalc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class table extends Activity {
	int request_code=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tableentry);
	}
	
	
	public void click1(View v)
	{
		
		Intent myIntent = new Intent(v.getContext(), detailsentry.class);
        startActivity(myIntent);
		
		
	}
		
		
	}
	
	


	

	


