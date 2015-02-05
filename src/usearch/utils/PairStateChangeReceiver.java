package usearch.utils;


import usearch.adapter.AdapterManager;
import usearch.app.BluetoothApplication;
import usearch.entity.DeviceItem;
import usearch.entity.TouchObject;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * 配对状态改变监听器
 * @author 210001001427
 *
 */
public class PairStateChangeReceiver extends BroadcastReceiver {
	private BluetoothApplication mApplication;
	private Activity mActivity;
	private AdapterManager mAdapterManager;
	private TouchObject mTouchObject;
	
	public PairStateChangeReceiver(Activity activity){
		this.mApplication = BluetoothApplication.getInstance();
		this.mActivity = activity;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		if(intent.getAction().equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)){
			//状态改变
			if(null == mAdapterManager){
				mAdapterManager = mApplication.getAdapterManager();
			}
			if(null == mTouchObject){
				mTouchObject = mApplication.getTouchObject();
			}
			//取得状态改变的设备，更新设备列表信息 （配对状态）
			BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			short rssi = intent.getExtras().getShort(BluetoothDevice.EXTRA_RSSI);
			DeviceItem item = new DeviceItem();
			item.setDevice(device);
			item.setRssi(rssi);
			mAdapterManager.changeDevice(mTouchObject.clickDeviceItemId, item);
			mAdapterManager.updateDeviceAdapter();
			mActivity.unregisterReceiver(this);
		}
	}

}
