package usearch.utils;

import java.util.Locale;

import android.content.Context;
import android.content.res.Configuration;

public class LocalUtil {
		
	public static void setDefaultLocalEN(Context context){
		Locale.setDefault(Locale.ENGLISH); 
		Configuration config = context.getResources().getConfiguration();        
		config.locale = Locale.ENGLISH;       
		context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
	}
	
	public static void setDefaultLocalCN(Context context){
		Locale.setDefault(Locale.CHINA); 
		Configuration config = context.getResources().getConfiguration();        
		config.locale = Locale.CHINA;       
		context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
	}
}
