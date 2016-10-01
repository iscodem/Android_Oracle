package com.example.oracle10.three;

import com.example.android_oracle.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class ThreeRadio extends Activity {
	RadioGroup mGroup;
	TextView sextext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_radio);
		mGroup = (RadioGroup) findViewById(R.id.three_radiogroup);
		sextext = (TextView) findViewById(R.id.three_radiotext);
		mGroup.setOnCheckedChangeListener(new OnChecked());
	}

	class OnChecked implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.three_radiobtn1:
				Toast.makeText(ThreeRadio.this, "��", 0).show();
				sextext.setText("�Ա�:��");
				break;
			case R.id.three_radiobtn2:
				Toast.makeText(ThreeRadio.this, "Ů", 0).show();
				sextext.setText("�Ա�:Ů");
				break;
			default:
				break;
			}
		}
	}
}
