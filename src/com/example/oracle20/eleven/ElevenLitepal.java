package com.example.oracle20.eleven;

import java.util.Date;
import java.util.List;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import com.example.android_oracle.R;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ElevenLitepal extends Activity implements OnClickListener {
	TextView create, insert, update, select, delete;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eleven_litepal);
		create = (TextView) findViewById(R.id.eleven_create);
		insert = (TextView) findViewById(R.id.eleven_insert);
		update = (TextView) findViewById(R.id.eleven_update);
		select = (TextView) findViewById(R.id.eleven_select);
		delete = (TextView) findViewById(R.id.eleven_delete);
		create.setOnClickListener(this);
		insert.setOnClickListener(this);
		update.setOnClickListener(this);
		select.setOnClickListener(this);
		delete.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.eleven_create:
			createdb();
			break;
		case R.id.eleven_insert:
			insertdb();
			break;
		case R.id.eleven_update:
			updatedb();
			break;
		case R.id.eleven_select:
			selectdb();
			break;
		case R.id.eleven_delete:
			deletedb();
			break;
		default:
			break;
		}
	}

	private void createdb() {
		Connector.getDatabase();
		Toast.makeText(ElevenLitepal.this, "���ݿⴴ���ɹ�", 0).show();
	}

	private void insertdb() {
		ElevenNews news = new ElevenNews();
		news.setTitle("����1");
		news.setContent("���ߴ��¼���������1");
		news.setPublishDate(new Date());
		if (news.save()) {
			Toast.makeText(ElevenLitepal.this, "���ݴ洢�ɹ�", Toast.LENGTH_SHORT)
					.show();
		} else {
			Toast.makeText(ElevenLitepal.this, "���ݴ洢ʧ��", Toast.LENGTH_SHORT)
					.show();
		}
	}

	private void updatedb() {
		ContentValues values = new ContentValues();
		values.put("title", "����iPhone6����");
		DataSupport.update(ElevenNews.class, values, 1);
		Toast.makeText(ElevenLitepal.this, "�����޸ĳɹ�", 0).show();
	}

	private void selectdb() {
		List<ElevenNews> newsList = DataSupport.select("title", "content")
				.where("commentcount = ?", "0").order("publishdate desc")
				.limit(10).find(ElevenNews.class);
		Toast.makeText(ElevenLitepal.this, "��ѯ���������ǣ�" + newsList.toString(), 0)
				.show();
	}

	private void deletedb() {
		DataSupport.deleteAll(ElevenNews.class,
				"title = ? and commentcount = ?", "����iPhone6����", "0");
		Toast.makeText(ElevenLitepal.this, "����ɾ���ɹ�", 0).show();
	}
}
