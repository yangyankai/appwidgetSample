/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/9/10 2:58:48
 * Project: T_note
 * File: MyNoteEdit.java
 * Class: MyNoteEdit
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.mob.t_note;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RemoteViews;
import android.widget.TextView;

/**
 * Created by yangyankai on 2015/9/10.
 */
public class MyNoteEdit extends Activity
{
	int         mAppWidgetId;
	TextView    mTextView;
	ImageButton mImBtn1, mImBtn2, mImBtn3, mImBtn4;

	final String mPerfName = "com.silenceburn.MyNoteConf";
	SharedPreferences mPref;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_note_conf);

		Intent t = getIntent();
		Log.i("myLog", t.getAction());
		mAppWidgetId = t.getExtras().getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
		Log.i("myLog", "it's [" + mAppWidgetId + "] editing!");

		mPref = getSharedPreferences(mPerfName, 0);
		String noteContent = mPref.getString("DAT" + mAppWidgetId, "");

		mTextView = (TextView) findViewById(R.id.EditText02);
		mTextView.setText(noteContent);
		mImBtn1 = (ImageButton) findViewById(R.id.ImageButton01);
		mImBtn2 = (ImageButton) findViewById(R.id.ImageButton02);
		mImBtn3 = (ImageButton) findViewById(R.id.ImageButton03);
		mImBtn4 = (ImageButton) findViewById(R.id.ImageButton04);

		mImBtn1.setOnClickListener(mBtnClick);
		mImBtn2.setOnClickListener(mBtnClick);
		mImBtn3.setOnClickListener(mBtnClick);
		mImBtn4.setOnClickListener(mBtnClick);

	}

	View.OnClickListener mBtnClick = new View.OnClickListener()
	{

		@Override
		public void onClick(View v)
		{

			SharedPreferences.Editor prefsEdit = mPref.edit();
			prefsEdit.putString("DAT" + mAppWidgetId, mTextView.getText().toString());
			prefsEdit.commit();

			int srcId = R.drawable.sketchy_paper_008;
			switch (v.getId())
			{
				case R.id.ImageButton01:
					srcId = R.drawable.sketchy_paper_003;
					break;
				case R.id.ImageButton02:
					srcId = R.drawable.sketchy_paper_004;
					break;
				case R.id.ImageButton03:
					srcId = R.drawable.sketchy_paper_007;
					break;
				case R.id.ImageButton04:
					srcId = R.drawable.sketchy_paper_011;
					break;
			}

			RemoteViews views = new RemoteViews(MyNoteEdit.this.getPackageName(), R.layout.my_note_widget);
			views.setImageViewResource(R.id.my_widget_img, srcId);

			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(MyNoteEdit.this);
			appWidgetManager.updateAppWidget(mAppWidgetId, views);

			MyNoteEdit.this.finish();
		}
	};
}
