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
public class Std extends Activity 
{
	Spinner spn;
	ListView lst;
	DbAdapter dbAdpt;
	String val;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.std_int);
		spn=(Spinner)findViewById(R.id.spinner1);
		lst=(ListView)findViewById(R.id.lststd);
		dbAdpt = new DbAdapter(this);
		 try
			{
	    	  dbAdpt.recInsert("2", "English", "1 st", "English", "1", "eng_chp1.txt", 1);
	    	  dbAdpt.recInsert("3", "English", "1 st", "English", "2", "eng_chp2.txt", 1);
	    	  dbAdpt.recInsert("4", "English", "2 nd", "English", "3", "eng_chp3.txt", 1);
	    	  dbAdpt.recInsert("5", "English", "2 nd", "English", "4", "eng_chp4.txt", 1);
	    	  dbAdpt.recInsert("6", "English", "3 rd", "English", "5", "eng_chp5.txt", 1);
	    	  dbAdpt.recInsert("7", "English", "3 rd", "English", "6", "eng_chp6.txt", 1);
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
				Toast.makeText(Std.this, "Selected", Toast.LENGTH_LONG).show();
				TextView TV =(TextView) arg1;
				db = TV.getText().toString().split("~");
				Toast.makeText(Std.this, ""+db[0], Toast.LENGTH_LONG).show();
				x =  dbAdpt.recDisp("select spth from stud where schap='"+db[0]+"';");
				Toast.makeText(Std.this, "....."+x[0], Toast.LENGTH_LONG).show();
				fileread.p=x[0];
				//Value Pass to other intent
				Intent i = new Intent(Std.this,fileread.class);
				startActivity(i);
			}
		 });
	}
	
	public void go(View v)
	{
		val=(spn.getSelectedItem().toString());
		Toast.makeText(Std.this, ""+val, Toast.LENGTH_LONG).show();
		dbAdpt = new DbAdapter(Std.this);
		String[] msg =  dbAdpt.recDisp("select schap from stud where sstd='"+val+"';");
		//Toast.makeText(Std.this, "success", Toast.LENGTH_LONG).show();
		ArrayAdapter<String> adpt = new ArrayAdapter<String>(Std.this, R.layout.name_list , msg);
		lst=(ListView)findViewById(R.id.lststd);
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
