package usearch;

import java.util.ArrayList;
import java.util.List;

import usearch.R;
import usearch.entity.AreaPart;
import usearch.views.MyListView;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MapActivity extends Activity implements OnPageChangeListener {
	private MyListView partList;
	private View headView;
	ViewPager viewPager;
	LinearLayout pointGroup;
	private List<View> views;
	private ImageView[] imageViews;
	private List<AreaPart> parts = new ArrayList<AreaPart>();
	int[] pics = { R.drawable.bannerad, R.drawable.bannerad02,
			R.drawable.bannerad03 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		init();
	}
	private void init() {
		prepareData();
		headView = (View) getLayoutInflater().inflate(R.layout.header, null);
		viewPager = (ViewPager) headView.findViewById(R.id.viewPager);
		pointGroup = (LinearLayout) headView.findViewById(R.id.viewGroup);
		initPoint(pics.length);
		views = addViews(pics);
	    viewPager.setAdapter(new PicsPagerAdapter(this,views)); 
	    viewPager.setOnPageChangeListener(this); 
	    
		partList = (MyListView) this.findViewById(R.id.partlist);
		partList.addHeaderView(headView);
		partList.setAdapter(adapter);
		partList.setOnItemClickListener(itemListener);
	}
	
	private void initPoint(int len) {
		 imageViews = new ImageView[len]; 
	     for (int i = 0; i < len; i++) {  
	        ImageView imageView = new ImageView(this);  
	        imageView.setLayoutParams(new LayoutParams(20,20));  
	        imageView.setPadding(10, 0, 10, 0);  
	        imageViews[i] = imageView;  
	        pointGroup.addView(imageView);  
	     }
	        setFocus(0);
	}
	private void setFocus(int p) {
		int len = pics.length;
		for(int i = 0 ; i < len ; i++){
			 if (i == p) {  
	             // 默认进入程序后第p张图片被选中;  
	             imageViews[i].setBackgroundResource(R.drawable.point_1+p);  
	         } else {  
	             imageViews[i].setBackgroundResource(R.drawable.point_default);  
	         }  
		}
	}
	private List<View> addViews(int[] advIds) {
		int len= advIds.length;
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
   	ArrayList<View> views = new ArrayList<View>();
   	for(int i = 0 ; i < len ; i++){
   		ImageView iv = new ImageView(this);
			iv.setLayoutParams(mParams);
			iv.setImageResource(pics[i]);
			iv.setAdjustViewBounds(true);
			iv.setScaleType(ScaleType.CENTER_INSIDE);
			views.add(iv);
   	}
   	return views;
	}
	class  PicsPagerAdapter extends PagerAdapter{
		List<View> lists;
		public PicsPagerAdapter(Context context,List<View> lists){
			this.lists =lists;
		}
		@Override
		public int getCount() {
			return lists.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			return super.getItemPosition(object);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return super.getPageTitle(position);
		}
	    
		@Override
		public Parcelable saveState() {
			return super.saveState();
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView(lists.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			  ((ViewPager) container).addView(lists.get(position),0); 
	          return lists.get(position);  
		}
	}
	
	OnItemClickListener itemListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
				Log.d("debug", "click:"+arg2);
				if(arg2>0){
					String chartset = parts.get(arg2-1).getCharset();
					Intent i = new Intent(MapActivity.this,MapDetailsActivity.class);
					i.putExtra("charset", chartset);
					startActivity(i);
				}
		}
	};
		
	private void prepareData() {
		AreaPart apA = new AreaPart();
		apA.setCharset("A");
		apA.setImgRes(R.drawable.index_a);
		apA.setInfo("Located the place in A zone");
		
		AreaPart apB = new AreaPart();
		apB.setCharset("B");
		apB.setImgRes(R.drawable.index_b);
		apB.setInfo("Located the place in B zone");
		
		AreaPart apC = new AreaPart();
		apC.setCharset("C");
		apC.setImgRes(R.drawable.index_c);
		apC.setInfo("Located the place in C zone");
		
		AreaPart apD = new AreaPart();
		apD.setCharset("D");
		apD.setImgRes(R.drawable.index_d);
		apD.setInfo("Located the place in D zone");
		
		AreaPart apE = new AreaPart();
		apE.setCharset("E");
		apE.setImgRes(R.drawable.index_e);
		apE.setInfo("Located the place in E zone");
		
		AreaPart apF = new AreaPart();
		apF.setCharset("F");
		apF.setImgRes(R.drawable.button_star_on_normal);
		apF.setInfo("Located the place in F zone");
		
		AreaPart apCv = new AreaPart();
		apCv.setCharset("Culture Village");
		apCv.setImgRes(R.drawable.ic_dashboard_latest);
		apCv.setInfo("Located the place in Culture village");
		
		AreaPart apLib = new AreaPart();
		apLib.setCharset("Library");
		apLib.setImgRes(R.drawable.button_star_on_disabled_focused);
		apLib.setInfo("Located the place in Library");
		
		parts.add(apA);
		parts.add(apB);
		parts.add(apC);
		parts.add(apD);
		parts.add(apE);
		parts.add(apF);
		parts.add(apCv);
		parts.add(apLib);
		
	}

	ListAdapter adapter = new ListAdapter() {
		
		@Override
		public void unregisterDataSetObserver(DataSetObserver observer) {
			
		}
		
		@Override
		public void registerDataSetObserver(DataSetObserver observer) {
			
		}
		
		@Override
		public boolean isEmpty() {
			return false;
		}
		
		@Override
		public boolean hasStableIds() {
			return false;
		}
		
		@Override
		public int getViewTypeCount() {
			return 1;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Holder h;
			if(null == convertView){
				h = new Holder();
				convertView = LayoutInflater.from(MapActivity.this).inflate(R.layout.map_listitem, null);
				h.charset = (TextView) convertView.findViewById(R.id.charset);
				h.info = (TextView) convertView.findViewById(R.id.info);
				h.img = (ImageView) convertView.findViewById(R.id.image);
				convertView.setTag(h);
			}else{
				h = (Holder) convertView.getTag();
			}
			h.charset.setText(""+parts.get(position).getCharset());
			h.info.setText(""+parts.get(position).getInfo());
			h.img.setImageResource(parts.get(position).getImgRes());
			return convertView;
		}
		
		@Override
		public int getItemViewType(int position) {
			// TODO Auto-generated method stub
			return 1;
		}
		
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return parts.get(position);
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return parts.size();
		}
		
		@Override
		public boolean isEnabled(int position) {
			// TODO Auto-generated method stub
			return true;
		}
		
		@Override
		public boolean areAllItemsEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
		class Holder{
			ImageView img;
			TextView charset,info;
		}
	};
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageSelected(int arg0) {
		setFocus(arg0);
	}
}
