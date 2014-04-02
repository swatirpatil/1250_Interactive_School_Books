package com.example.sit_e_book_new;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class showimage extends Activity 
{
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		
		Intent in = new Intent();
		in.setAction(android.content.Intent.ACTION_VIEW);
		File f = new File("/storage/sdcard0/android.jpg");
		in.setDataAndType(Uri.fromFile(f), "image/*");
		startActivity(in);
		
		
	}

}
