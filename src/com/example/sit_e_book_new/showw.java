package com.example.sit_e_book_new;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.service.wallpaper.WallpaperService.Engine;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;


public class showw extends Activity 
{
	Button btnStd1 ;
	EditText txtCnt ;
	mainn mn;
	
	
	protected void onCreate(Bundle savedInstanceState) 
	{
				super.onCreate(savedInstanceState);
			    setContentView(R.layout.showw);    
			    
			    //btnStd1 = (Button) findViewById(R.id.btnStd1);
			    txtCnt=(EditText) findViewById(R.id.txtChp1Cnt);
			    try 
			    {
			    	File readfile = new File("/sdcard/Notes/", ""+mn.fn);
					
			        try 
			        {
			            BufferedReader br = new BufferedReader(new FileReader(readfile));
			            String test;
			            while (true) 
			            {
			                test = br.readLine();
			                txtCnt.append(test);
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
}
