package com.example.sit_e_book_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class mainn extends Activity 
{
	DbAdapter dbAdpt;
	ListView lst;
	public static String[] fn;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainn);
		
		String[] msg = dbAdpt.recDisp("select srno from stud;");
		ArrayAdapter<String> adpt = new ArrayAdapter<String>(mainn.this, R.layout.name_list , msg);
		lst = (ListView) findViewById(R.id.lst1);
		lst.setAdapter(adpt);
	    lst.setOnItemClickListener(new AdapterView.OnItemClickListener()
			{
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
				{
					TextView TV =(TextView) arg1;
					String[] db = TV.getText().toString().split("~");
					
					Toast.makeText(mainn.this, " \n Sr_no :"+db[0]
													+"\n Language :"+db[1]
													+"\n  Standard:"+db[2]
													+"\n Subject :"+db[3]
													+"\n Chapter :"+db[4]
													+"\n File Name :"+db[5]
													, Toast.LENGTH_LONG).show();				
					Toast.makeText(mainn.this, ""+fn, Toast.LENGTH_LONG).show();
					Intent i = new Intent(mainn.this,showw.class);
					startActivity(i);	
				}
			});
	}
	
	
}
