package com.example.oracle10.three;

import java.util.ArrayList;
import java.util.List;

import com.example.android_oracle.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ThreeItemClick extends Activity {
	ListView listview;
	List<ThreePerson> listPerson;
	ThreeListAdapter myAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_listview);
		listview = (ListView) findViewById(R.id.three_listview);
		addList();
		myAdapter = new ThreeListAdapter(ThreeItemClick.this, listPerson);
		listview.setAdapter(myAdapter);

		listview.setOnItemClickListener(new OnItemClick());
	}

	private void addList() {
		listPerson = new ArrayList<ThreePerson>();
		for (int i = 0; i < 20; i++) {
			listPerson.add(new ThreePerson("������" + i, i, "13931051110",
					R.drawable.log200, R.drawable.yang30));
		}
	}

	class OnItemClick implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				final int position, long id) {
			Toast.makeText(ThreeItemClick.this,
					listPerson.get(position).getName(), 0).show();
			AlertDialog.Builder builder = new AlertDialog.Builder(
					ThreeItemClick.this);
			builder.setTitle("ListItem�������");
			builder.setIcon(R.drawable.yang30);
			builder.setMessage("�Ƿ�ɾ��������¼");
			builder.setPositiveButton("ɾ��", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(ThreeItemClick.this,
							"��ɾ��" + listPerson.get(position).getName(), 0)
							.show();
					listPerson.remove(position);
					myAdapter.notifyDataSetChanged();
				}
			});
			builder.setNegativeButton("����", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(ThreeItemClick.this, "��ȡ��ɾ������", 0).show();
				}
			});
			builder.show();
		}
	}
}
