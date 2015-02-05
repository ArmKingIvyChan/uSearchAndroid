package usearch;

import java.util.Locale;

import usearch.R;
import usearch.utils.PreferencesUtils;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SettingActivity extends Activity implements OnClickListener {
	TextView languageText;
	SeekBar voiceBar;
	AudioManager am;
	boolean isEnglish;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		init();
	}
	private void init() {
		isEnglish = PreferencesUtils.getBoolean(this, "english", true);
		voiceBar = (SeekBar) this.findViewById(R.id.seekbar);
		voiceBar.setOnSeekBarChangeListener(voiceSeek);
		languageText = (TextView) this.findViewById(R.id.language);
		String lan = isEnglish ? "English" : "中文";
		languageText.setText(""+lan);
		languageText.setOnClickListener(this);
		am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int mVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC); //获取当前音乐音量
        voiceBar.setMax(am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)); //SEEKBAR设置为音量的最大阶数
        voiceBar.setProgress(mVolume); //设置seekbar为当前音量进度
	}
	
	OnSeekBarChangeListener voiceSeek = new OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			
		}
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0); //拖动seekbar时改变音量
		}
	};
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.language:
				changeLanguage();
				break;
			default:
				break;
			}
		}
	private void changeLanguage() {
		Resources resource = getResources();   
		Configuration config = resource.getConfiguration(); 
		if(isEnglish){
			config.locale = Locale.CHINA;
			PreferencesUtils.putBoolean(this, "english", false);
		}else{
			config.locale = Locale.ENGLISH;
			PreferencesUtils.putBoolean(this, "english", true);
		}
		getBaseContext().getResources().updateConfiguration(config, null); 
		
		//重启应用后才会有效果
		showDialogToRestartApp();
	}
		
	private void showDialogToRestartApp() {
		new AlertDialog.Builder(this)
		.setTitle("\t info")
		.setMessage("sure to restart app?")
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				restartApp();
			}
		})
		.setNegativeButton("Cancel", null)
		.create().show();
	}
	private void restartApp(){
		Intent intent = new Intent();   
		intent.setClass(this, MainActivity.class);   
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);   
		this.startActivity(intent);
	}
}
