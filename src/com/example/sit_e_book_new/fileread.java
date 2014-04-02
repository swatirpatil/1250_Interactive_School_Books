package com.example.sit_e_book_new;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class fileread extends Activity
{
	Button btnvedio;
	public static String p;
	public void onCreate(Bundle icicle)
	{
		super.onCreate(icicle);
		setContentView(R.layout.fileread);
		btnvedio = (Button) findViewById(R.id.btnvedio);
		TextView txtContents =(TextView)findViewById(R.id.txtContent);
		Toast.makeText(fileread.this,""+p,Toast.LENGTH_LONG).show();
		try 
	    {
			File sdcard = Environment.getExternalStorageDirectory();
	        File readfile = new File("sdcard/Notes/",""+p);	
	        try 
	        {
	            BufferedReader br = new BufferedReader(new FileReader(readfile));
	            String test;
	            while (true) 
	            {
	                test = br.readLine();
	                txtContents.append(test);
	        	    if (test == null)
	                break;
	            }
	        }
	        catch (Exception e) 
		    {
		    	Toast.makeText(this, "Hi in Open"+e.toString(), Toast.LENGTH_SHORT).show();
		    }
	    }
	    catch (Exception e) 
	    {
	    	Toast.makeText(this, "Hi in Open"+e.toString(), Toast.LENGTH_SHORT).show();
	    }
	}
	public void move(View v)
	{
		Intent i = new Intent(fileread.this,demovedio.class);
		startActivity(i);	
		
	}
	public void show(View v)
	{	
		Intent i = new Intent(fileread.this,showimage.class);
		startActivity(i);
	}
}
