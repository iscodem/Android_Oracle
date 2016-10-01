package com.example.oracle15.seven;

import com.example.android_oracle.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class SevenShared extends Activity {
	TextView save, read;
	SharedPreferences shared;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seven_saveread);

		save = (TextView) findViewById(R.id.seven_save);
		read = (TextView) findViewById(R.id.seven_read);
		save.setOnClickListener(new OnClick());
		read.setOnClickListener(new OnClick());

	}

	class OnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.seven_save:
				save();
				break;
			case R.id.seven_read:
				read();
				break;

			default:
				break;
			}
		}
	}

	private void save() {
		shared = getSharedPreferences("shared", MODE_PRIVATE);
		SharedPreferences.Editor editor = shared.edit();
		editor.putString("name", "���������");
		editor.putString("age", "���������");
		editor.commit();
		Toast.makeText(this, "�����ѱ���", 0).show();
	}

	private void read() {
		shared = getSharedPreferences("shared", MODE_PRIVATE);
		String name = shared.getString("name", "Ϊ��Ĭ��ֵ");
		String age = shared.getString("age", "Ϊ��Ĭ��ֵ");
		Toast.makeText(this, name + "#" + age, 0).show();
	}
}
