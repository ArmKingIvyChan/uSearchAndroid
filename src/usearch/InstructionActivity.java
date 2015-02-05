package usearch;

import usearch.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class InstructionActivity extends Activity {
	private ImageView backImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_instruction);
		init();
	}
	private void init() {
		backImage = (ImageView) this.findViewById(R.id.back);
		backImage.setOnClickListener(backListener);
	}
	
	OnClickListener backListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			InstructionActivity.this.finish();
		}
	};
}
