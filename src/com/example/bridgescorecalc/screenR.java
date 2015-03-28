package com.example.bridgescorecalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class screenR extends Activity{
	char BidminorSuit;
	int score=0;
	int penality=0;
	int underTricks=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screenf);
		Intent in =getIntent();
		String BidNoS=in.getStringExtra("BidNo");
		int BidNoI=Integer.parseInt(BidNoS);
		String TArget=in.getStringExtra("Target");
		int TargetI=Integer.parseInt(TArget);
	//	target=Integer.parseInt(BidNo)+6;
		String BidSuit=in.getStringExtra("bidst");
		String BidSuitNT="NT";
		String BidSuitC="C";
		String BidSuitD="D";
		//String BidSuitH="H";
		//String BidSuitS="S";
		
		
		if(BidSuit.contains(BidSuitC)||BidSuit.contains(BidSuitD))
		{
			 BidminorSuit='y';
		}
		else
		{
			 BidminorSuit='n';
		}
		
		//String st74=String.valueOf(target);
		
		String DoubledS=in.getStringExtra("Doubleds");
		int DoubledsI=Integer.parseInt(DoubledS);
		
		String VulrableS=in.getStringExtra("Vulrable");
		int VulrableI=Integer.parseInt(VulrableS);
		
		String DclarerS=in.getStringExtra("Dclarer");
		int DclarerI=Integer.parseInt(DclarerS);
		String TricksW=in.getStringExtra("Tricksw");
		int TricksWI=Integer.parseInt(TricksW);
		//contract
		if(TricksWI>=TargetI)
		{
			if(BidSuit.contains(BidSuitNT))
			{
				score+=(40 + (BidNoI-1)*30)*DoubledsI;
			
			}
			else
			{
				if(BidminorSuit=='y')
				{
					score+=(BidNoI*20)*DoubledsI;
				}
				else 
				{
					score+=(BidNoI*30)*DoubledsI;
				}
			}
			
			// making the game
			if(score>100)
			{
				if(VulrableI==1)
				{
					score+=500;
				}
				else
				{
					score+=300;
				}
					
			}
			else
			{
				if(DclarerI==1)
				{
					//part score
					score+=50;
				
			         if(DoubledsI>1)
			            {
				      score+=25*DoubledsI;
			            }
			    }
		    }
		}
		
		//slam bonus
		
		if(TargetI==12 && TricksWI>=12)
		{
			if(VulrableI==1)
			{
				score+=750;
			}
			else
			{
				score+=500;
			}
		}
		else if(TargetI==13 && TricksWI>=13)
		{
			if(VulrableI==1)
			{
				score+=1500;
			}
			else
			{
				score+=1000;
			}
		}
		
		//over tricks
		
		if(TricksWI>TargetI)
		{
			if(DoubledsI==1)
			{
				if(BidminorSuit=='y')
				{
					score+=(TricksWI-TargetI)*20;
				}
				else
				{
					score+=(TricksWI-TargetI)*30;
				}
			}
			else
				if(VulrableI==1)
				{
					score+=(TricksWI-TargetI)*100*DoubledsI;
				}
				else
			    {
				score+=(TricksWI-TargetI)*50*DoubledsI;
			    }
		}
		
		//under tricks
		if(TricksWI<TargetI)
		{
			if(DoubledsI==1)
			{
				if(TargetI-TricksWI==1)
				{
				      if(VulrableI==1)
				       {
				         	penality+=(TargetI-TricksWI)*100;
				       }
				      else
				      {
				    	  penality+=(TargetI-TricksWI)*50;  
				      }
				}
				else if(TargetI-TricksWI>1)
				{
					 if(VulrableI==1)
				       {
				         	penality+=(TargetI-TricksWI)*100;
				       }
				      else
				      {
				    	  penality+=(TargetI-TricksWI)*50;  
				      }
				}
			}
			else
			{
				underTricks=TargetI-TricksWI;
		if(underTricks==1)
			{
				//first under trick
				if(VulrableI==1)
				{
					penality+=100*DoubledsI;
				}
				else
				{
					penality+=50*DoubledsI;
				}
			}
		// 2 down
		else
			{
				
				if(VulrableI==1)
				{
					penality+=(200+300*(underTricks-1))*(DoubledsI/2);
				}
				else
				{
					penality+=(100+200*(underTricks-1))*(DoubledsI/2);
				}
			}
				// 2nd and 3rd trick
				
				
			}
			score-=penality;
		}
		
		String ScoreS=String.valueOf(score);
		
		//DisplayToast(ScoreS);
		TextView ftxt1=(TextView)findViewById(R.id.textView4);
		ftxt1.setText(ScoreS);
	}


public void edit(View v)
{
	AlertDialog.Builder build=new AlertDialog.Builder(screenR.this);
	build.setMessage("your score has been updated in server!!!");
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
public void ex(final View v)
{
	AlertDialog.Builder build2=new AlertDialog.Builder(screenR.this);
	build2.setMessage("continue with...");
	build2.setCancelable(true);
	build2.setPositiveButton("New Board!!!", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Intent in=new Intent(v.getContext(), detailsentry.class);
			startActivity(in);
		}
	});
	build2.setNegativeButton("New Table!!!", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Intent in=new Intent(v.getContext(), table.class);
			startActivity(in);
		}
	});
	AlertDialog alert2=build2.create();
	alert2.show();
	
}

	/*private void DisplayToast(String st75) {
		// TODO Auto-generated method stub
		Toast.makeText(this,st75 , Toast.LENGTH_LONG).show();
		
	}*/

}
