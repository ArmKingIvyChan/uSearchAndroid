package usearch.db;

import java.util.ArrayList;
import java.util.List;

import usearch.entity.AreaPart;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class AreaDB {
	final static String TABLE = "area";
	
	/**
	 * 向area表中插入一条记录
	 * @param db
	 * @param ap AreaPart实体
	 */
	public static void insert(SQLiteDatabase db ,AreaPart ap){
		if(null != db && null != ap){
			ContentValues cv = new ContentValues();
			cv.put("charset", ap.getCharset());
			cv.put("place", ap.getInfo());
			cv.put("rssi", ap.getRssi());
			db.insert(TABLE, null, cv);
		}
	}
	/**
	 * 向Area表中插入一条记录
	 * @param db
	 * @param charset
	 * @param place
	 */
	public static void insert(SQLiteDatabase db , String charset , String place,long rssi){
		if(null != db && null != charset && null != place){
			ContentValues cv = new ContentValues();
			cv.put("charset", charset);
			cv.put("place", place);
			cv.put("rssi", rssi);
			db.insert(TABLE, null, cv);
		}
	}
	/**
	 * 查询Area表中所有的记录,按_id排序
	 * @param db
	 * @return
	 */
	public static List<AreaPart> query(SQLiteDatabase db){
		List<AreaPart> areas = new ArrayList<AreaPart>();
		if(null != db){
			Cursor c = db.query(TABLE, null, null, null, null, null, "_id");
			if(c.moveToFirst()){
				do{
					AreaPart ap = new AreaPart();
					ap.setCharset(c.getString(c.getColumnIndex("charset")));
					ap.setInfo(c.getString(c.getColumnIndex("place")));
					ap.setRssi(c.getFloat(c.getColumnIndex("rssi")));
					areas.add(ap);
				}while(c.moveToNext());
			}
		}
		return areas;
	}
}
