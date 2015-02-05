package usearch.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class MediaManager {
	public static MediaPlayer mediaPlayer;
	
	/**
	 * 播放声音
	 * @param context
	 * @param paramInt raw下的声音文件id
	 */
	public static void playSound(Context context,int paramInt)
	  {
	    if (mediaPlayer != null)
	    {
	      if (mediaPlayer.isPlaying())
	    	  	mediaPlayer.stop();
	      		mediaPlayer.reset();
	      		mediaPlayer.release();
	      		mediaPlayer = null;
	      		Log.d("PinYin", "MediaPlayer is released.");
	      
	    }
	    try
	    {
	       mediaPlayer = MediaPlayer.create(context, paramInt);
	      if (mediaPlayer != null)
	      {
	        mediaPlayer.setAudioStreamType(3);
	        mediaPlayer.setLooping(false);
	        mediaPlayer.start();
	      }
	      else
	      {
	        Log.e("PinYin", "Error Sound:" + paramInt);
	      }
	    }
	    catch (Exception localException)
	    {
	      Log.e("PinYin", localException.getMessage());
	    }
	  }
	
	
	public static void releaseSounds(){
		if (mediaPlayer != null){
	      if (mediaPlayer.isPlaying())
	    	  	mediaPlayer.stop();
	      		mediaPlayer.reset();
	      		mediaPlayer.release();
	      		mediaPlayer = null;
	      		Log.d("PinYin", "MediaPlayer is released.");
	    }
	}
}
