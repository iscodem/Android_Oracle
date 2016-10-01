package com.example.oracle19.ten;

import com.example.android_oracle.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TenLifecycle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ten_lifecycle);
		Log.e("TAG", "---����---onCreate---");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.e("TAG", "---��ʼ---onStart---");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e("TAG", "---���¿�ʼ---onResume---");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e("TAG", "---��ͣ---onPause---");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e("TAG", "---ֹͣ---onStop---");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e("TAG", "---����---onDestroy---");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e("TAG", "---��������---onRestart---");
	}
}
