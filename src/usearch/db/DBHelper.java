package usearch.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	final static String NAME = "usearch.db";
	final static int VERSION = 1;
	static DBHelper instance;
	
	private DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	
	public static DBHelper getInstance(Context context){
		if(null == instance){
			instance = new DBHelper(context, NAME, null, VERSION);
		}
		return instance;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(createArea());
		db.execSQL(createRssiToDistance());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(newVersion > oldVersion){
		}
	}
	
	private String createArea(){
		return new StringBuffer()
				.append("create table if not exists area ( ")
				.append(" _id integer primary key autoincrement not null , ")
				.append(" charset varchar not null , ")
				.append(" place  varchar, ")
				.append(" rssi varchar )")
				.toString();
	}
	
	private String createRssiToDistance(){
		return new StringBuffer()
				.append("create table if not exists rssitodistance ( ")
				.append(" _id integer  primary key autoincrement not null , ")
				.append(" charset varchar not null , ")
				.append(" place  varchar, ")
				.append(" rssiStart varchar, ")
				.append(" rssiEnd varchar, ")
				.append(" distanceStart varchar, ")
				.append(" distanceEnd varchar )")
				.toString();
	}
	
}
