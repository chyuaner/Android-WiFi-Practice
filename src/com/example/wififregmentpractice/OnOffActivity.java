package com.example.wififregmentpractice;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class OnOffActivity extends Activity implements OnCheckedChangeListener {
	private WifiManager wiFiManager;
	private ToggleButton wifiOnOff;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_on_off);
		
		wiFiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
		
		wifiOnOff = (ToggleButton)findViewById(R.id.toggleButton1);
		wifiOnOff.setChecked(wiFiManager.isWifiEnabled());
		wifiOnOff.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.on_off, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.toggleButton1:
			if(arg1){
				Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
				if (!wiFiManager.isWifiEnabled()) {
					wiFiManager.setWifiEnabled(true);
				}
			}
			else {
				Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();
				if (wiFiManager.isWifiEnabled()) {
					wiFiManager.setWifiEnabled(false);
				}
			}
			break;
		}
	}

}
