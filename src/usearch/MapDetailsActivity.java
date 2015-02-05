package usearch;

import java.util.ArrayList;
import java.util.List;

import usearch.R;
import usearch.adapter.ViewPagerAdapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class MapDetailsActivity extends Activity {
	ViewPager pager;
	ViewPagerAdapter adapter;
	TextView recordText;
	String charset;
	ImageView backImage;
	ArrayList<View> views  = new ArrayList<View>();
	int[] partA = {R.drawable.a0,R.drawable.a1};
	int[] partB = {R.drawable.b0,R.drawable.b1,R.drawable.b2,R.drawable.b3};
	int[] partC = {R.drawable.c0,R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4};
	int[] partD = {R.drawable.d0,R.drawable.d1,R.drawable.d2};
	
	int[] partE = {R.drawable.e0,R.drawable.e1,R.drawable.e2};
	
	int[] partF = {R.drawable.f0,R.drawable.f1};
	
	int[] partCv = {R.drawable.cv0,R.drawable.cv1,R.drawable.cv2};
	
	int[] partLib = {R.drawable.lib0,R.drawable.lib1,R.drawable.lib2};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_map_details);
		init();
	}
	private void init() {
		charset = getIntent().getStringExtra("charset");
		prepareData();
		pager = (ViewPager) this.findViewById(R.id.viewpager);
		recordText = (TextView) this.findViewById(R.id.text_describe);
		if(views.size() > 0)
		 recordText.setText("1/"+views.size());
		backImage = (ImageView) this.findViewById(R.id.back);
		backImage.setOnClickListener(backListener);
		adapter= new ViewPagerAdapter(views);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(pageChangeListener);
	}
	
	OnClickListener backListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			MapDetailsActivity.this.finish();
		}
	};
	OnPageChangeListener pageChangeListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			int position=arg0;
			recordText.setText(++position+"/"+views.size());
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}
	};
	private void prepareData() {
		if("A".equals(charset)){
			fillData(partA);
		}else if("B".equals(charset)){
			fillData(partB);
		}else if("C".equals(charset)){
			fillData(partC);
		}else if("D".equals(charset)){
			fillData(partD);
		}else if("E".equals(charset)){
			fillData(partE);
		}else if("F".equals(charset)){
			fillData(partF);
		}else if("Cv".equals(charset)){
			fillData(partCv);
		}else if("Lib".equals(charset)){
			fillData(partLib);
		}
	}
	private void fillData(int[] ps) {
		for(int i=0;i < ps.length ; i++)
		{
			ImageView iv=new ImageView(this);
			LayoutParams ltp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
			iv.setScaleType(ScaleType.CENTER_CROP);
			iv.setLayoutParams(ltp);
			iv.setImageResource(ps[i]);
			views.add(iv);
        }
		
	}
		
}
