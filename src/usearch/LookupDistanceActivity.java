package usearch;

import usearch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LookupDistanceActivity extends Activity {
	
	private TextView titleText;
	private EditText settingEdit;
	private String info;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendsms_dialog);
		init();
	}

	private void init() {
		titleText = (TextView) this.findViewById(R.id.titleinfo);
		settingEdit = (EditText) this.findViewById(R.id.settinginfo);
		titleText.setText("Input your location(ABCDEFCvLib)");
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}
	
	public void lookup_distance(View v){
		info = settingEdit.getText().toString().trim();
		if(null != info && !"".equals(info)){
			Intent i = new Intent(this,SearchActivity.class);
			i.putExtra("charset", info);
			setResult(1000, i);
			this.finish();
		}else{
			Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
		}
	}
	
	public void cancel_lookup(View v){
		this.finish();
	}
}
