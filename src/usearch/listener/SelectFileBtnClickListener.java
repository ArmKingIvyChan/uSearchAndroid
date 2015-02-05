package usearch.listener;


import usearch.SearchActivity;
import usearch.SelectFileActivity;
import usearch.db.DBHelper;
import usearch.db.RssToDistanceDB;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 选择文件按钮监听器
 * @author 210001001427
 *
 */
public class SelectFileBtnClickListener implements OnClickListener {
	private Activity mActivity;
	
	public SelectFileBtnClickListener(Activity activity){
		this.mActivity = activity;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(mActivity, SelectFileActivity.class);
		mActivity.startActivityForResult(intent, SearchActivity.RESULT_CODE);
		
	}

}
