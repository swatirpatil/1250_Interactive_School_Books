package com.example.sit_e_book_new;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class demovedio extends Activity
{
	VideoView v;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vedio);
		v = (VideoView)  findViewById(R.id.vv) ;
		v.setVideoPath("/storage/sdcard0/Movies/hosanna.mp4");
		v.setMediaController(new MediaController (this));
		v.start();
		v.requestFocus();
	}

}
