package com.example.oracle10.three;

import com.example.android_oracle.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ThreeAlertDialog extends Activity {
	TextView alert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_alertdialog);
		alert = (TextView) findViewById(R.id.three_alert);
		alert.setOnClickListener(new OnClick());
	}

	class OnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.three_alert:
				alert();
				break;

			default:
				break;
			}
		}

	}

	private void alert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("�Ի������");
		builder.setIcon(R.drawable.log200);
		builder.setMessage("�Ի���������Ϣ��ʾ");
		builder.setPositiveButton("true��ť",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(ThreeAlertDialog.this, "ִ��trueʱ�ķ���", 0)
								.show();
					}
				});
		builder.setNegativeButton("false��ť",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(ThreeAlertDialog.this, "ִ��falseʱ�ķ���", 0)
								.show();
					}
				});
		builder.show();
	}

}
