package usearch;

import usearch.R;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RadarActivity extends Activity {
	BluetoothAdapter bluetoothAdapter;
	private ArrayAdapter<String> mNewDevicesArrayAdapter;
	ListView deviceList;
	TextView totalText;
	boolean isfirst = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_radar);
		init();
	}
	
	private void init() {
		totalText = (TextView) this.findViewById(R.id.totalinfo);
		 // Find and set up the ListView for newly discovered devices
		deviceList = (ListView) findViewById(R.id.device_list);
		isfirst = true;
		
		mNewDevicesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        deviceList.setAdapter(mNewDevicesArrayAdapter);
		totalText.setText("Total: " + mNewDevicesArrayAdapter.getCount());
        
        // Register for broadcasts when a device is discovered
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, filter);

        // Register for broadcasts when discovery has finished
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);

        
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if(null != bluetoothAdapter){
			if(bluetoothAdapter.isEnabled()){
				scanBluetoothDevice();
			}else{//打开蓝牙
				if(isfirst){
					 Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);  
					 startActivityForResult(intent, 1000);  
				}
				
			}
		}else{//没有蓝牙设备,不支持蓝牙
			showMsg("there is no bluetooth device");
		}
	}

	
	
	private void showMsg(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(null != data && requestCode == 1000 && resultCode == RESULT_OK){
			scanBluetoothDevice();
		}else{
			showMsg("bluetooth available");
		}
		isfirst = false;
	}

	private void scanBluetoothDevice() {
		setProgressBarIndeterminateVisibility(true);
        setTitle("scanning");
        // If we're already discovering, stop it
        if (bluetoothAdapter.isDiscovering()) {
        	bluetoothAdapter.cancelDiscovery();
        }
        // Request discover from BluetoothAdapter
        bluetoothAdapter.startDiscovery();
        Log.d("debug", "startDiscovery");
	}
	 private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context context, Intent intent) {
	            String action = intent.getAction();

	            // When discovery finds a device
	            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
	                // Get the BluetoothDevice object from the Intent
	                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	                // If it's already paired, skip it, because it's been listed already
	                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
	                	short rssi = intent.getExtras().getShort(BluetoothDevice.EXTRA_RSSI); 
	                	int len = mNewDevicesArrayAdapter.getCount();
	                	String add = device.getName();
	                	for(int i = 0 ; i < len ; i++){
	                		if(mNewDevicesArrayAdapter.getItem(i).equals(device.getName())){
	                			add = "";
	                			break;
	                		}
	                	}
	                	if(!"".equals(add)) mNewDevicesArrayAdapter.add(device.getName());
	                    mNewDevicesArrayAdapter.notifyDataSetChanged();
	                    totalText.setText("Total: " + mNewDevicesArrayAdapter.getCount());
	                }
	            // When discovery is finished, change the Activity title
	            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
	                setProgressBarIndeterminateVisibility(false);
	                setTitle("scan over");
	                if (mNewDevicesArrayAdapter.getCount() == 0) {
	                    String noDevices = "no new device";
	                    mNewDevicesArrayAdapter.add(noDevices);
	                    mNewDevicesArrayAdapter.notifyDataSetChanged();
	                    totalText.setTag("Total: 0");
	                }
	            }
	        }
	    };
	    
	    @Override
	    protected void onDestroy() {
	        super.onDestroy();

	        // Make sure we're not doing discovery anymore
	        if (bluetoothAdapter != null) {
	        	bluetoothAdapter.cancelDiscovery();
	        }

	        // Unregister broadcast listeners
	        this.unregisterReceiver(mReceiver);
	    }

		@Override
		protected void onResume() {
			super.onResume();
		}
		
}
