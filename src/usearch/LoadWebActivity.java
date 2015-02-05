package usearch;

import usearch.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class LoadWebActivity extends Activity {
	private WebView webView;
	private ImageView backImage;
	final static String url = "http://uic.edu.hk";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_loadweb);
		init();
	}
	private void init() {
		backImage = (ImageView) this.findViewById(R.id.back);
		backImage.setOnClickListener(backListener);
		webView = (WebView) this.findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(client);
		webView.loadUrl(url);
	}
	WebViewClient client  = new WebViewClient(){

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
		
	};
	OnClickListener backListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			LoadWebActivity.this.finish();
		}
	};
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
			 webView.goBack();
			 return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
}
