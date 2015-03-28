package com.example.bridgescorecalc;






import android.os.Bundle;
import android.view.View;
import android.app.Activity;

import android.content.Intent;


public class MainActivity extends Activity {
  int request_code=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	public void btnclk(View v)
	{
		Intent i = new Intent(this, table.class);
		startActivityForResult(i, request_code);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==request_code && resultCode==RESULT_OK)
		{
			if(data.getDataString().equalsIgnoreCase("close"))
				MainActivity.this.finish();
		}
	}
	
}
		