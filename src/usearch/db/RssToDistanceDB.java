package usearch.db;

import java.util.ArrayList;
import java.util.List;

import usearch.entity.RssToDistance;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RssToDistanceDB {
		final static String NAME = "rssitodistance";
		
		private static void initRssToDistanceDB(SQLiteDatabase db,RssToDistance rTD){
			if(null != db && null != rTD){
				ContentValues cv = new ContentValues();
				cv.put("rssiStart", rTD.getRssiStart());
				cv.put("rssiEnd", rTD.getRssiEnd());
				cv.put("distanceStart", rTD.getDistanceStart());
				cv.put("distanceEnd", rTD.getDistanceEnd());
				cv.put("charset", rTD.getCharset());
				db.insert(NAME, null, cv);
			}
		}
		private static void initRssToDistanceDB(SQLiteDatabase db,List<RssToDistance> rTDs){
			if(null != db && null != rTDs){
				for(RssToDistance rTD : rTDs)
				 initRssToDistanceDB(db, rTD);
			}
		}
		
		
		public static String[] rssiToDistance(SQLiteDatabase db , String charset, float rssi){
			String distance[] = new String[2];
			String selection = "charset = ? and "+rssi+" > rssiStart "+" and "+rssi+" <= rssiEnd";
			String[] selectionArgs = new String[]{charset};
			if(null != db && null != charset && !"".equals(charset)){
				Cursor c = db.query(NAME, null, selection, selectionArgs, null, null, null);
				if(c.moveToFirst()){
					String distanceS = c.getString(c.getColumnIndex("distanceStart"));
					String distanceE = c.getString(c.getColumnIndex("distanceEnd"));
					distance[0] = distanceS;
					
					distance[1] = distanceE;
					
					
				}else{
					distance[0] = "NAN";
					distance[1] = "NAN";
				}
			}
			return distance;
		}
		
		public static void initRssAndDistance(SQLiteDatabase db){
			List<RssToDistance> list = new ArrayList<RssToDistance>();
			   RssToDistance rTDA1 = new RssToDistance();
			   rTDA1.setCharset("A");
			   rTDA1.setRssiStart(0);
			   rTDA1.setRssiEnd(50);
			   rTDA1.setDistanceStart("2.87");
			   rTDA1.setDistanceEnd("3.04");
			   
			   RssToDistance rTDA2 = new RssToDistance();
			   rTDA2.setCharset("A");
			   rTDA2.setRssiStart(50);
			   rTDA2.setRssiEnd(100);
			   rTDA2.setDistanceStart("2.27");
			   rTDA2.setDistanceEnd("2.89");
			   
			   RssToDistance rTDA3 = new RssToDistance();
			   rTDA3.setCharset("A");
			   rTDA3.setRssiStart(100);
			   rTDA3.setRssiEnd(150);
			   rTDA3.setDistanceStart("1.35");
			   rTDA3.setDistanceEnd("2.27");
			   
			   RssToDistance rTDA4 = new RssToDistance();
			   rTDA4.setCharset("A");
			   rTDA4.setRssiStart(150);
			   rTDA4.setRssiEnd(200);
			   rTDA4.setDistanceStart("0.85");
			   rTDA4.setDistanceEnd("1.35");
			   
			   RssToDistance rTDA5 = new RssToDistance();
			   rTDA5.setCharset("A");
			   rTDA5.setRssiStart(200);
			   rTDA5.setRssiEnd(250);
			   rTDA5.setDistanceStart("0");
			   rTDA5.setDistanceEnd("0.85");
			   
			   list.add(rTDA1);
			   list.add(rTDA2);
			   list.add(rTDA3);
			   list.add(rTDA4);
			   list.add(rTDA5);
			   
			   RssToDistance rTDB1 = new RssToDistance();
			   rTDB1.setCharset("B");
			   rTDB1.setRssiStart(0);
			   rTDB1.setRssiEnd(50);
			   rTDB1.setDistanceStart("2.84");
			   rTDB1.setDistanceEnd("3.11");
			   
			   RssToDistance rTDB2 = new RssToDistance();
			   rTDB2.setCharset("B");
			   rTDB2.setRssiStart(50);
			   rTDB2.setRssiEnd(100);
			   rTDB2.setDistanceStart("2.51");
			   rTDB2.setDistanceEnd("2.84");
			   
			   RssToDistance rTDB3 = new RssToDistance();
			   rTDB3.setCharset("B");
			   rTDB3.setRssiStart(100);
			   rTDB3.setRssiEnd(150);
			   rTDB3.setDistanceStart("1.42");
			   rTDB3.setDistanceEnd("2.51");
			   
			   RssToDistance rTDB4 = new RssToDistance();
			   rTDB4.setCharset("B");
			   rTDB4.setRssiStart(150);
			   rTDB4.setRssiEnd(200);
			   rTDB4.setDistanceStart("0.68");
			   rTDB4.setDistanceEnd("1.42");
			   
			   RssToDistance rTDB5 = new RssToDistance();
			   rTDB5.setCharset("B");
			   rTDB5.setRssiStart(200);
			   rTDB5.setRssiEnd(250);
			   rTDB5.setDistanceStart("0");
			   rTDB5.setDistanceEnd("0.68");
			   
			   list.add(rTDB1);
			   list.add(rTDB2);
			   list.add(rTDB3);
			   list.add(rTDB4);
			   list.add(rTDB5);
			   
			   RssToDistance rTDC1 = new RssToDistance();
			   rTDC1.setCharset("C");
			   rTDC1.setRssiStart(0);
			   rTDC1.setRssiEnd(50);
			   rTDC1.setDistanceStart("2.97");
			   rTDC1.setDistanceEnd("3.05");
			   
			   RssToDistance rTDC2 = new RssToDistance();
			   rTDC2.setCharset("C");
			   rTDC2.setRssiStart(50);
			   rTDC2.setRssiEnd(100);
			   rTDC2.setDistanceStart("2.66");
			   rTDC2.setDistanceEnd("2.97");
			   
			   RssToDistance rTDC3 = new RssToDistance();
			   rTDC3.setCharset("C");
			   rTDC3.setRssiStart(100);
			   rTDC3.setRssiEnd(150);
			   rTDC3.setDistanceStart("1.24");
			   rTDC3.setDistanceEnd("2.66");
			   
			   RssToDistance rTDC4 = new RssToDistance();
			   rTDC4.setCharset("C");
			   rTDC4.setRssiStart(150);
			   rTDC4.setRssiEnd(200);
			   rTDC4.setDistanceStart("0.75");
			   rTDC4.setDistanceEnd("1.24");
			   
			   RssToDistance rTDC5 = new RssToDistance();
			   rTDC5.setCharset("C");
			   rTDC5.setRssiStart(200);
			   rTDC5.setRssiEnd(250);
			   rTDC5.setDistanceStart("0");
			   rTDC5.setDistanceEnd("0.75");
			   
			   list.add(rTDC1);
			   list.add(rTDC2);
			   list.add(rTDC3);
			   list.add(rTDC4);
			   list.add(rTDC5);
			   
			   RssToDistance rTDD1 = new RssToDistance();
			   rTDD1.setCharset("D");
			   rTDD1.setRssiStart(0);
			   rTDD1.setRssiEnd(50);
			   rTDD1.setDistanceStart("2.93");
			   rTDD1.setDistanceEnd("3.02");
			   
			   RssToDistance rTDD2 = new RssToDistance();
			   rTDD2.setCharset("D");
			   rTDD2.setRssiStart(50);
			   rTDD2.setRssiEnd(100);
			   rTDD2.setDistanceStart("2.42");
			   rTDD2.setDistanceEnd("2.93");
			   
			   RssToDistance rTDD3 = new RssToDistance();
			   rTDD3.setCharset("D");
			   rTDD3.setRssiStart(100);
			   rTDD3.setRssiEnd(150);
			   rTDD3.setDistanceStart("1.13");
			   rTDD3.setDistanceEnd("2.42");
			   
			   RssToDistance rTDD4 = new RssToDistance();
			   rTDD4.setCharset("D");
			   rTDD4.setRssiStart(150);
			   rTDD4.setRssiEnd(200);
			   rTDD4.setDistanceStart("0.66");
			   rTDD4.setDistanceEnd("1.13");
			   
			   RssToDistance rTDD5 = new RssToDistance();
			   rTDD5.setCharset("D");
			   rTDD5.setRssiStart(200);
			   rTDD5.setRssiEnd(250);
			   rTDD5.setDistanceStart("0");
			   rTDD5.setDistanceEnd("0.66");
			   
			   list.add(rTDD1);
			   list.add(rTDD2);
			   list.add(rTDD3);
			   list.add(rTDD4);
			   list.add(rTDD5);
			   
			   RssToDistance rTDE1 = new RssToDistance();
			   rTDE1.setCharset("E");
			   rTDE1.setRssiStart(0);
			   rTDE1.setRssiEnd(50);
			   rTDE1.setDistanceStart("2.81");
			   rTDE1.setDistanceEnd("3.08");
			   
			   RssToDistance rTDE2 = new RssToDistance();
			   rTDE2.setCharset("E");
			   rTDE2.setRssiStart(50);
			   rTDE2.setRssiEnd(100);
			   rTDE2.setDistanceStart("2.35");
			   rTDE2.setDistanceEnd("2.81");
			   
			   RssToDistance rTDE3 = new RssToDistance();
			   rTDE3.setCharset("E");
			   rTDE3.setRssiStart(100);
			   rTDE3.setRssiEnd(150);
			   rTDE3.setDistanceStart("1.40");
			   rTDE3.setDistanceEnd("2.35");
			   
			   RssToDistance rTDE4 = new RssToDistance();
			   rTDE4.setCharset("E");
			   rTDE4.setRssiStart(150);
			   rTDE4.setRssiEnd(200);
			   rTDE4.setDistanceStart("1");
			   rTDE4.setDistanceEnd("2");
			   
			   RssToDistance rTDE5 = new RssToDistance();
			   rTDE5.setCharset("E");
			   rTDE5.setRssiStart(200);
			   rTDE5.setRssiEnd(250);
			   rTDE5.setDistanceStart("0");
			   rTDE5.setDistanceEnd("1");
			   
			   list.add(rTDE1);
			   list.add(rTDE2);
			   list.add(rTDE3);
			   list.add(rTDE4);
			   list.add(rTDE5);
			   
			   RssToDistance rTDF1 = new RssToDistance();
			   rTDF1.setCharset("F");
			   rTDF1.setRssiStart(0);
			   rTDF1.setRssiEnd(50);
			   rTDF1.setDistanceStart("10");
			   rTDF1.setDistanceEnd("米之外");
			   
			   RssToDistance rTDF2 = new RssToDistance();
			   rTDF2.setCharset("F");
			   rTDF2.setRssiStart(50);
			   rTDF2.setRssiEnd(100);
			   rTDF2.setDistanceStart("5");
			   rTDF2.setDistanceEnd("7");
			   
			   RssToDistance rTDF3 = new RssToDistance();
			   rTDF3.setCharset("F");
			   rTDF3.setRssiStart(100);
			   rTDF3.setRssiEnd(150);
			   rTDF3.setDistanceStart("3");
			   rTDF3.setDistanceEnd("5");
			   
			   RssToDistance rTDF4 = new RssToDistance();
			   rTDF4.setCharset("F");
			   rTDF4.setRssiStart(150);
			   rTDF4.setRssiEnd(200);
			   rTDF4.setDistanceStart("2");
			   rTDF4.setDistanceEnd("3");
			   
			   RssToDistance rTDF5 = new RssToDistance();
			   rTDF5.setCharset("F");
			   rTDF5.setRssiStart(200);
			   rTDF5.setRssiEnd(250);
			   rTDF5.setDistanceStart("0");
			   rTDF5.setDistanceEnd("2");
			   
			   list.add(rTDF1);
			   list.add(rTDF2);
			   list.add(rTDF3);
			   list.add(rTDF4);
			   list.add(rTDF5);
			   
			   RssToDistance rTDCV1 = new RssToDistance();
			   rTDCV1.setCharset("Cv");
			   rTDCV1.setRssiStart(0);
			   rTDCV1.setRssiEnd(50);
			   rTDCV1.setDistanceStart("10");
			   rTDCV1.setDistanceEnd("米之外");
			   
			   RssToDistance rTDCV2 = new RssToDistance();
			   rTDCV2.setCharset("Cv");
			   rTDCV2.setRssiStart(50);
			   rTDCV2.setRssiEnd(100);
			   rTDCV2.setDistanceStart("5");
			   rTDCV2.setDistanceEnd("7");
			   
			   RssToDistance rTDCV3 = new RssToDistance();
			   rTDCV3.setCharset("Cv");
			   rTDCV3.setRssiStart(100);
			   rTDCV3.setRssiEnd(150);
			   rTDCV3.setDistanceStart("3");
			   rTDCV3.setDistanceEnd("5");
			   
			   RssToDistance rTDCV4 = new RssToDistance();
			   rTDCV4.setCharset("Cv");
			   rTDCV4.setRssiStart(150);
			   rTDCV4.setRssiEnd(200);
			   rTDCV4.setDistanceStart("2");
			   rTDCV4.setDistanceEnd("3");
			   
			   RssToDistance rTDCV5 = new RssToDistance();
			   rTDCV5.setCharset("Cv");
			   rTDCV5.setRssiStart(200);
			   rTDCV5.setRssiEnd(250);
			   rTDCV5.setDistanceStart("0");
			   rTDCV5.setDistanceEnd("2");
			   
			   list.add(rTDCV1);
			   list.add(rTDCV2);
			   list.add(rTDCV3);
			   list.add(rTDCV4);
			   list.add(rTDCV5);
			   
			   RssToDistance rTDLib1 = new RssToDistance();
			   rTDLib1.setCharset("Lib");
			   rTDLib1.setRssiStart(0);
			   rTDLib1.setRssiEnd(50);
			   rTDLib1.setDistanceStart("5");
			   rTDLib1.setDistanceEnd("10");
			   
			   RssToDistance rTDLib2 = new RssToDistance();
			   rTDLib2.setCharset("Lib");
			   rTDLib2.setRssiStart(50);
			   rTDLib2.setRssiEnd(100);
			   rTDLib2.setDistanceStart("3");
			   rTDLib2.setDistanceEnd("5");
			   
			   RssToDistance rTDLib3 = new RssToDistance();
			   rTDLib3.setCharset("Lib");
			   rTDLib3.setRssiStart(100);
			   rTDLib3.setRssiEnd(150);
			   rTDLib3.setDistanceStart("2");
			   rTDLib3.setDistanceEnd("3");
			   
			   RssToDistance rTDLib4 = new RssToDistance();
			   rTDLib4.setCharset("Lib");
			   rTDLib4.setRssiStart(150);
			   rTDLib4.setRssiEnd(200);
			   rTDLib4.setDistanceStart("1");
			   rTDLib4.setDistanceEnd("2");
			   
			   RssToDistance rTDLib5 = new RssToDistance();
			   rTDLib5.setCharset("Lib");
			   rTDLib5.setRssiStart(200);
			   rTDLib5.setRssiEnd(250);
			   rTDLib5.setDistanceStart("0");
			   rTDLib5.setDistanceEnd("1");
			   
			   list.add(rTDLib1);
			   list.add(rTDLib2);
			   list.add(rTDLib3);
			   list.add(rTDLib4);
			   list.add(rTDLib5);
			   
			   initRssToDistanceDB(db, list);
		}
		
}
