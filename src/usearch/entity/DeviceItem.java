package usearch.entity;

import android.bluetooth.BluetoothDevice;

public class DeviceItem {
	BluetoothDevice device;
	short rssi;
	public BluetoothDevice getDevice() {
		return device;
	}
	public void setDevice(BluetoothDevice device) {
		this.device = device;
	}
	public short getRssi() {
		return rssi;
	}
	public void setRssi(short rssi) {
		this.rssi = rssi;
	}
	
	
}
