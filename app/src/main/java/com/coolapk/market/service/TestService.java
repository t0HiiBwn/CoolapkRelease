package com.coolapk.market.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.view.appmanager.DownloadManagerActivity;

public class TestService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForeground(1001, new NotificationCompat.Builder(this).setSmallIcon(17301634).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, DownloadManagerActivity.class), 134217728)).setCustomBigContentView(createDownloadView(getApplicationContext())).build());
    }

    private RemoteViews createDownloadView(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2131559075);
        int adjustAlpha = ColorUtils.adjustAlpha(((TextView) remoteViews.apply(context, new LinearLayout(context)).findViewById(2131363844)).getCurrentTextColor(), 0.1f);
        remoteViews.setInt(2131362803, "setBackgroundColor", adjustAlpha);
        remoteViews.setInt(2131362791, "setBackgroundColor", adjustAlpha);
        remoteViews.setInt(2131362792, "setBackgroundColor", adjustAlpha);
        remoteViews.setTextColor(2131362162, AppHolder.getAppTheme().getColorAccent());
        remoteViews.setTextColor(2131362163, AppHolder.getAppTheme().getColorAccent());
        remoteViews.setTextColor(2131362165, AppHolder.getAppTheme().getColorAccent());
        remoteViews.setTextColor(2131362166, AppHolder.getAppTheme().getColorAccent());
        return remoteViews;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
