package com.example.sit_e_book_new;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity 
{

	Button btnEng;
	Button btnMar;
	DbAdapter dbAdpt;
	
	/*@Override
	protected void onDestroy() 
	{ // TODO Auto-generated method stub
		super.onDestroy();
		dbAdpt.recInsert(null,null,null,null,null,null,4);	
	}*/
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnEng=(Button)findViewById(R.id.btnEng);
		btnMar=(Button)findViewById(R.id.btnMar);
		
		/*dbAdpt = new DbAdapter(this);
		 try
			{
	    	  dbAdpt.recInsert("1", "English", "1 st", "English", "index", "eng_index.txt", 1);
	    	  dbAdpt.recInsert("2", "English", "1 st", "English", "1", "eng_chp1.txt", 1);
	    	  dbAdpt.recInsert("3", "English", "1 st", "English", "2", "eng_chp2.txt", 1);
	    	  dbAdpt.recInsert("4", "English", "1 st", "English", "3", "eng_chp3.txt", 1);
	    	  dbAdpt.recInsert("5", "English", "1 st", "English", "4", "eng_chp4.txt", 1);
	    	  dbAdpt.recInsert("6", "English", "1 st", "English", "5", "eng_chp5.txt", 1);
	    	  dbAdpt.recInsert("7", "English", "1 st", "English", "6", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("8", "मराठी", "१ ली", "मराठी", "१", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("9", "मराठी", "१ ली", "मराठी", "२", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("8", "मराठी", "१ ली", "मराठी", "३", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("9", "मराठी", "१ ली", "मराठी", "४", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("8", "मराठी", "१ ली", "मराठी", "५", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("9", "मराठी", "१ ली", "मराठी", "६", "eng_chp6.txt", 1);
	          Toast.makeText(this, "List Load Successfully !!!", Toast.LENGTH_LONG).show(); 
			}
			catch(Exception ex)
			{
				Toast.makeText(this, "Record not Saved  : " + ex.getMessage(), Toast.LENGTH_LONG).show();
			}*/
	}
	/*public void onBackPressed() 
	{
		// TODO Auto-generated method stub
		super.onBackPressed();
		dbAdpt.recInsert(null,null,null,null,null,null,4);
		Toast.makeText(MainActivity.this, "Table has been droped", Toast.LENGTH_LONG).show();
	}*/
	public void mar(View v)
	{
			Intent i = new Intent(MainActivity.this,Marstd.class);
			startActivity(i);		
	}
	public void eng(View v)
	{
			Intent i = new Intent(MainActivity.this,Std.class);
			startActivity(i);
	}
}
