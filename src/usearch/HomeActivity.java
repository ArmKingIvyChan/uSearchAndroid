package usearch;

import usearch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class HomeActivity extends Activity implements OnClickListener {
	TextView instructionText,contactText,loadwebText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		init();
	}

	private void init() {
		instructionText = (TextView) this.findViewById(R.id.instruction);
		contactText = (TextView) this.findViewById(R.id.contactus);
		loadwebText = (TextView) this.findViewById(R.id.loadweb);
		instructionText.setOnClickListener(this);
		contactText.setOnClickListener(this);
		loadwebText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.instruction:
				startActivity(new Intent(HomeActivity.this,InstructionActivity.class));
				break;
			case R.id.contactus:
				startActivity(new Intent(HomeActivity.this,ContactUsActivity.class));
				break;
			case R.id.loadweb:
				startActivity(new Intent(HomeActivity.this,LoadWebActivity.class));
				break;
			default:
				break;
		}
	}
	
}
