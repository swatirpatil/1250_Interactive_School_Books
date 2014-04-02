package com.example.sit_e_book_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class Marstd extends Activity
{
	Spinner spn;
	ListView lst;
	DbAdapter dbAdpt;
	String val;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stdmar);
		spn=(Spinner)findViewById(R.id.spinner1);
		lst=(ListView)findViewById(R.id.lststd);
		dbAdpt = new DbAdapter(this);
		 try
			{
	    	  dbAdpt.recInsert("2", "मराठी", "१ ली", "मराठी", "१", "mar_chp2.txt", 1);
	    	  dbAdpt.recInsert("3", "मराठी", "१ ली", "मराठी", "२", "eng_chp1.txt", 1);
	    	  dbAdpt.recInsert("4", "मराठी", "२ ली", "मराठी", "३", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("5", "मराठी", "२ ली", "मराठी", "४", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("6", "मराठी", "३ ली", "मराठी", "५", "eng_chp6.txt", 1);
	    	  dbAdpt.recInsert("7", "मराठी", "३ ली", "मराठी", "६", "eng_chp6.txt", 1);
	          Toast.makeText(this, "List Load Successfully !!!", Toast.LENGTH_LONG).show(); 
			}
			catch(Exception ex)
			{
				Toast.makeText(this, "Record not Saved  : " + ex.getMessage(), Toast.LENGTH_LONG).show();
			}
		 lst.setOnItemClickListener(new AdapterView.OnItemClickListener()
		 {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
			{
				// TODO Auto-generated method stub
				String[] db;
				String[] x;
				Toast.makeText(Marstd.this, "Selected", Toast.LENGTH_LONG).show();
				TextView TV =(TextView) arg1;
				db = TV.getText().toString().split("~");
				Toast.makeText(Marstd.this, ""+db[0], Toast.LENGTH_LONG).show();
				x =  dbAdpt.recDisp("select spth from stud where schap='"+db[0]+"';");
				Toast.makeText(Marstd.this, "....."+x[0], Toast.LENGTH_LONG).show();
				fileread.p=x[0];
				//Value Pass to other intent
				Intent i = new Intent(Marstd.this,fileread.class);
				startActivity(i);
			}
		 });
	}
	public void go(View v)
	{
		val=(spn.getSelectedItem().toString());
		Toast.makeText(Marstd.this, ""+val, Toast.LENGTH_LONG).show();
		dbAdpt = new DbAdapter(Marstd.this);
		String[] msg =  dbAdpt.recDisp("select schap from stud where sstd='"+val+"';");
		//Toast.makeText(Std.this, "success", Toast.LENGTH_LONG).show();
		ArrayAdapter<String> adpt = new ArrayAdapter<String>(Marstd.this, R.layout.name_list , msg);			
		lst.setAdapter(adpt);
	}
	@Override
	public void onBackPressed()
	{
		// TODO Auto-generated method stub
		super.onBackPressed();
		 dbAdpt.recInsert(null,null,null,null,null, null, 3);	
	}
	
}