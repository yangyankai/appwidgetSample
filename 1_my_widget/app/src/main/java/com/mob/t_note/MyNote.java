/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/9/10 2:47:45
 * Project: T_note
 * File: MyNote.java
 * Class: MyNote
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.mob.t_note;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;

/**
 * Created by yangyankai on 2015/9/10.
 */
public class MyNote extends AppWidgetProvider
{

	final String mPerfName = "com.silenceburn.MyColorNoteConf";

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
						 int[] appWidgetIds) {
		// TODO Auto-generated method stub
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			Log.i("myLog", "this is [" + appWidgetId + "] onUpdate!");

		}
	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			Log.i("myLog", "this is [" + appWidgetId + "] onDelete!");
		}
	}
}
