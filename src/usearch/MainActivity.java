package usearch;

import java.util.Locale;

import usearch.R;
import usearch.utils.LocalUtil;
import usearch.utils.PreferencesUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements OnClickListener {
	public static String TAB_TAG_MAP = "map";
	public static String TAB_TAG_RADAR = "radar";
	public static String TAB_TAG_HOME = "home";
	public static String TAB_TAG_SEARCH = "search";
	public static String TAB_TAG_SETTING = "setting";
	public static TabHost mTabHost;
	static final int COLOR1 = Color.parseColor("#787878");
	static final int COLOR2 = Color.parseColor("#ffffff");
	ImageView mBut1, mBut2, mBut3, mBut4, mBut5;
//	TextView mCateText1, mCateText2, mCateText3, mCateText4, mCateText5;

	Intent mapIntent, radarIntent, searchIntent, homeIntent,
			settingIntent;

	int mCurTabId = R.id.channel3;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_image);
		boolean isEnglish = PreferencesUtils.getBoolean(this, "english", true);
		if(isEnglish) LocalUtil.setDefaultLocalEN(this);
		else LocalUtil.setDefaultLocalCN(this);
		prepareIntent();
		setupIntent();
		prepareView();
	}

	private void prepareView() {
		mBut1 = (ImageView) findViewById(R.id.main_tab_map);
		mBut2 = (ImageView) findViewById(R.id.main_tab_radar);
		mBut3 = (ImageView) findViewById(R.id.main_tab_home);
		mBut4 = (ImageView) findViewById(R.id.main_tab_search);
		mBut5 = (ImageView) findViewById(R.id.main_tab_setting);
		findViewById(R.id.channel1).setOnClickListener(this);
		findViewById(R.id.channel2).setOnClickListener(this);
		findViewById(R.id.channel3).setOnClickListener(this);
		findViewById(R.id.channel4).setOnClickListener(this);
		findViewById(R.id.channel5).setOnClickListener(this);
//		mCateText1 = (TextView) findViewById(R.id.textView1);
//		mCateText2 = (TextView) findViewById(R.id.textView2);
//		mCateText3 = (TextView) findViewById(R.id.textView3);
//		mCateText4 = (TextView) findViewById(R.id.textView4);
//		mCateText5 = (TextView) findViewById(R.id.textView5);
		initTabTag();
	}

	private void prepareIntent() {
		mapIntent = new Intent(this, MapActivity.class);
		radarIntent = new Intent(this, RadarActivity.class);
		homeIntent = new Intent(this, HomeActivity.class);
		searchIntent = new Intent(this, SearchActivity.class);
		settingIntent = new Intent(this, SettingActivity.class);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			mBut1.performClick();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private void setupIntent() {
		mTabHost = getTabHost();
		mTabHost.addTab(buildTabSpec(TAB_TAG_MAP, R.string.main_navigation_map,
				R.drawable.bottom_map, mapIntent));
		mTabHost.addTab(buildTabSpec(TAB_TAG_RADAR,R.string.main_navigation_radar, 
				R.drawable.bottom_radar, radarIntent));
		mTabHost.addTab(buildTabSpec(TAB_TAG_HOME, R.string.main_navigation_home,
				R.drawable.bottom_home, homeIntent));
		mTabHost.addTab(buildTabSpec(TAB_TAG_SEARCH,R.string.main_navigation_search, 
				R.drawable.bottom_search, searchIntent));
		mTabHost.addTab(buildTabSpec(TAB_TAG_SETTING, R.string.main_navigation_setting,
				R.drawable.bottom_setting, settingIntent));
	}

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return mTabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),
						getResources().getDrawable(resIcon))
				.setContent(content);
	}

	private  void initTabTag() {
		mTabHost.setCurrentTabByTag(TAB_TAG_HOME);
		mBut3.setImageResource(R.drawable.bottom_home_d);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (mCurTabId == v.getId()) {
			return;
		}
		mBut1.setImageResource(R.drawable.bottom_map);
		mBut2.setImageResource(R.drawable.bottom_radar);
		mBut3.setImageResource(R.drawable.bottom_home);
		mBut4.setImageResource(R.drawable.bottom_search);
		mBut5.setImageResource(R.drawable.bottom_setting);
//		mCateText1.setTextColor(COLOR1);
//		mCateText2.setTextColor(COLOR1);
//		mCateText3.setTextColor(COLOR1);
//		mCateText4.setTextColor(COLOR1);
//		mCateText5.setTextColor(COLOR1);
		int checkedId = v.getId();
		final boolean o;
		if (mCurTabId < checkedId)
			o = true;
		else
			o = false;
		switch (checkedId) {
		case R.id.channel1:
			mTabHost.setCurrentTabByTag(TAB_TAG_MAP);
			mBut1.setImageResource(R.drawable.bottom_map_d);
//			mCateText1.setTextColor(COLOR2);
			break;
		case R.id.channel2:
			mTabHost.setCurrentTabByTag(TAB_TAG_RADAR);
			mBut2.setImageResource(R.drawable.bottom_radar_d);
//			mCateText2.setTextColor(COLOR2);
			break;
		case R.id.channel3:
			mTabHost.setCurrentTabByTag(TAB_TAG_HOME);
			mBut3.setImageResource(R.drawable.bottom_home_d);
//			mCateText3.setTextColor(COLOR2);
			break;
		case R.id.channel4:
			mTabHost.setCurrentTabByTag(TAB_TAG_SEARCH);
			mBut4.setImageResource(R.drawable.bottom_search_d);
//			mCateText4.setTextColor(COLOR2);
			break;
		case R.id.channel5:
			mTabHost.setCurrentTabByTag(TAB_TAG_SETTING);
			mBut5.setImageResource(R.drawable.bottom_setting_d);
//			mCateText5.setTextColor(COLOR2);
			break;
		default:
			break;
		}

		mCurTabId = checkedId;
//		Log.i("o", o+"");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 1, 0, "exit");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == 1){
			dialog();
		}
		return super.onOptionsItemSelected(item);
	}

	private void dialog() {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		builder.setMessage("确定要退出吗？");
		builder.setTitle("提示");
		builder.setPositiveButton("确认", 
				new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
		builder.setNegativeButton("取消", 
				new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		builder.show();
	}

}
