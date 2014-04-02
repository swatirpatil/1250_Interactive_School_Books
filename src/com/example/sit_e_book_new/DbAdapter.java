package com.example.sit_e_book_new;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DbAdapter extends SQLiteOpenHelper 
{
	public static String s;
	public static Context ctx; 
	public SQLiteDatabase db;
	public String sql ="";
	
	public DbAdapter(Context context) 
	{
		//super(context, database name, factory, version);
		super(context, "myDB.db", null, 1);
		ctx = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase dbx) 
	{
		
		dbx.execSQL("create table stud(  srno text," +
										"slang text," +
										"sstd text," +
										"ssub text," +
										"schap text," +
										"spth text );");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		Log.w("Update : ","Upgardating database !!!");
		db.execSQL("drop table contacts");
		onCreate(db);
	}	
	
	public void recInsert(String sr,String lang,String std,String suj,String chpt,String pah,int flg)
	{
		db = this.getWritableDatabase();
		try
		{
			
			if(flg == 1)
			{
				sql = "insert into stud values('" + sr + "'," +
												"'" + lang + "'," +
												"'" + std + "'," +
												"'" + suj + "'," +
												"'" + chpt + "'," +
												"'" + pah + "');";	
			}
			/*if(flg == 2)
			{
				sql = "update stud set fat = '" + cfat + "',snf ='" + csnf + "',qty='" + cqty + "' where cust_id= '" + cid + "';";
				//Toast.makeText(ctx, sql, Toast.LENGTH_LONG).show();
			}*/
			if(flg == 3)
			{
				sql = "delete from stud;";
				//Toast.makeText(ctx, sql, Toast.LENGTH_LONG).show();
			}
			if(flg == 4)
			{
				sql = "delete from stud ;";
				//Toast.makeText(ctx, sql, Toast.LENGTH_LONG).show();
			}
			if(flg == 5)
			{
				sql = "select spth from stud where srno= '" + sr + "';";
				//Toast.makeText(ctx, sql, Toast.LENGTH_LONG).show();
			}
			//recDisp(sql);
			db.execSQL(sql);			
		}
		catch(Exception ex)
		{
			Toast.makeText(ctx, "Ex : " + ex.getMessage(), Toast.LENGTH_LONG).show();
		}
		db.close();
}

	public String [] recDisp(String fieldnm)
	{
		String msg="";
		int i=0;
		db = this.getReadableDatabase();
		Cursor rs = db.rawQuery(fieldnm, null);
		//Toast.makeText(ctx, "select "+fieldnm+" from stud;", 5000).show();
		String[] rec = new String[rs.getCount()];

		if(rs.moveToFirst())
		{
		
			while(rs.isAfterLast() == false)
			{
				
				msg=rs.getString(0);
				rec[i]=new String(msg);
				i++;
				rs.moveToNext();
			
			}
		}
	//	mainn.fn=msg.toString().split("-");
		rs.close();
		db.close();
		return rec;
	}
	
}
