package com.example.bridgescorecalc;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;





import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

	public class detailsentry extends Activity {
		int target=0;
		int doubled=1;
		int flagv=1;
		int flagd=1;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.details);
		/*	EditText ttxt1=(EditText)findViewById(R.id.editText1);
			String bidNo=ttxt1.getText().toString();
			target=Integer.parseInt(bidNo)+6;
			String st74=String.valueOf(target);*/
			RadioGroup rdg=(RadioGroup)findViewById(R.id.radioGroup0);
			rdg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						
						public void onCheckedChanged(RadioGroup group, int checkedId) {
							// TODO Auto-generated method stub
							
							RadioButton rbt0=(RadioButton)findViewById(R.id.radio0);
							 RadioButton rbt1=(RadioButton)findViewById(R.id.radio1);
							 RadioButton rbt2=(RadioButton)findViewById(R.id.radio2);
							
							if(rbt0.isChecked())
							{
								doubled=1;
							}
							else if(rbt1.isChecked())
							{
								doubled=2;
							}
							else if(rbt2.isChecked())
							{
								doubled=4;
							}
							
							
							
						}
						
					});
			RadioGroup rdg1=(RadioGroup)findViewById(R.id.radioGroup1);
			rdg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						
						public void onCheckedChanged(RadioGroup group, int checkedId) {
							// TODO Auto-generated method stub
							
							RadioButton rbt3=(RadioButton)findViewById(R.id.radio3);
							 RadioButton rbt4=(RadioButton)findViewById(R.id.radio4);
							 
							
							if(rbt3.isChecked())
							{
								flagv=1;
							}
							else if(rbt4.isChecked())
							{
								flagv=0;
							}
							
							
							
						}
						
					});
			RadioGroup rdg2=(RadioGroup)findViewById(R.id.radioGroup2);
			rdg2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						
						public void onCheckedChanged(RadioGroup group, int checkedId) {
							// TODO Auto-generated method stub
							
							RadioButton rbt5=(RadioButton)findViewById(R.id.radio5);
							 RadioButton rbt6=(RadioButton)findViewById(R.id.radio6);
							 
							
							if(rbt5.isChecked())
							{
								flagd=1;
							}
							else if(rbt6.isChecked())
							{
								flagd=0;
							}
							
							
							
						}
						
					});
		}
		public void click2(View v)
		{
			String bidNo1="1";String bidNo2="2";String bidNo3="3";String bidNo4="4";String bidNo5="5";String bidNo6="6";String bidNo7="7";
			String bidSuitC="C";String bidSuitD="D";String bidSuitH="H";String bidSuitS="S";String bidSuitNT="NT";
			String tricksw1="1";String tricksw2="2";String tricksw3="3";String tricksw4="4";String tricksw5="5";String tricksw6="6";String tricksw7="7";String tricksw8="8";String tricksw9="9";
			EditText ttxt1=(EditText)findViewById(R.id.editText1);
			Intent i=new Intent(v.getContext(), screenR.class);
			String bidNo=ttxt1.getText().toString();
			if(bidNo.contains(bidNo1)||bidNo.contains(bidNo2)||bidNo.contains(bidNo3)||bidNo.contains(bidNo4)||bidNo.contains(bidNo5)||bidNo.contains(bidNo6)||bidNo.contains(bidNo7))
			{
				i.putExtra("BidNo",bidNo);
				int target=Integer.parseInt(bidNo)+6;
				String targets=String.valueOf(target);
				i.putExtra("Target",targets);
				EditText ttxt2=(EditText)findViewById(R.id.editText2);
				String bidSuit=ttxt2.getText().toString();
				i.putExtra("bidst", bidSuit);
				if(bidSuit.contains(bidSuitC)||bidSuit.contains(bidSuitD)||bidSuit.contains(bidSuitH)||bidSuit.contains(bidSuitS)||bidSuit.contains(bidSuitNT))
				{
				String doubleds=String.valueOf(doubled);
				i.putExtra("Doubleds", doubleds);
				
				String vulrable=String.valueOf(flagv);
				i.putExtra("Vulrable", vulrable);
				
				String dclarer=String.valueOf(flagd);
				i.putExtra("Dclarer",dclarer);
				EditText ttxt3=(EditText)findViewById(R.id.editText3);
				String tricksw=ttxt3.getText().toString();
				if(tricksw.contains(tricksw1)||tricksw.contains(tricksw2)||tricksw.contains(tricksw3)||tricksw.contains(tricksw4)||tricksw.contains(tricksw5)||tricksw.contains(tricksw6)||tricksw.contains(tricksw7)||tricksw.contains(tricksw8)||tricksw.contains(tricksw9))
				{
					i.putExtra("Tricksw", tricksw);
					startActivity(i);
				}
				else
				{
					AlertDialog.Builder build=new AlertDialog.Builder(detailsentry.this);
					build.setMessage("invalid!!!valid tricks won are [1-13] ");
					build.setCancelable(true);
					build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					AlertDialog alert=build.create();
					alert.show();
				}
				}
				else
				{
					AlertDialog.Builder build=new AlertDialog.Builder(detailsentry.this);
					build.setMessage("invalid!!!valid suits are C/S/D/H/NT ");
					build.setCancelable(true);
					build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					AlertDialog alert=build.create();
					alert.show();
				}
			}
			else
			{
				AlertDialog.Builder build=new AlertDialog.Builder(detailsentry.this);
				build.setMessage("invalid!!!valid bid no can be [1-7] ");
				build.setCancelable(true);
				build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
				AlertDialog alert=build.create();
				alert.show();
			}
		
		}

	}



