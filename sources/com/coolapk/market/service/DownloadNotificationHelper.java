package com.coolapk.market.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.appmanager.DownloadManagerActivity;
import java.util.concurrent.TimeUnit;

public class DownloadNotificationHelper {
    private static final long NOTIFICATION_MIN_TIME = TimeUnit.SECONDS.toMillis(3);
    private String lastNotifyTag;
    private long lastNotifyTimestamp;

    public static DownloadNotificationHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final DownloadNotificationHelper INSTANCE = new DownloadNotificationHelper();

        private SingletonHolder() {
        }
    }

    private DownloadNotificationHelper() {
    }

    public void onDownloadStart(Context context, DownloadState downloadState) {
        String string = downloadState.getExtra() != null ? downloadState.getExtra().getString("TITLE") : null;
        if (TextUtils.isEmpty(string)) {
            string = downloadState.getFileName();
        }
        int hashCode = downloadState.getKey().hashCode();
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context, String.valueOf(1)).setTicker(context.getString(2131886509, string)).setContentTitle(context.getString(2131886510, string)).setContentText(context.getString(2131886508)).setProgress(100, 0, true).setSmallIcon(17301633).setWhen(downloadState.getStartTime()).setAutoCancel(true).setContentIntent(PendingIntent.getService(context, hashCode, new Intent(context, DownloadManagerActivity.class), 134217728));
        contentIntent.addAction(2131231600, context.getString(2131886143), buildPauseIntent(context, hashCode, downloadState.getUrl()));
        contentIntent.addAction(2131231597, context.getString(2131886124), buildDeleteIntent(context, hashCode, downloadState.getUrl()));
        notify(context, downloadState.getKey(), contentIntent.build());
    }

    public void onDownloadRunning(Context context, DownloadState downloadState) {
        String string = downloadState.getExtra() != null ? downloadState.getExtra().getString("TITLE") : null;
        if (TextUtils.isEmpty(string)) {
            string = downloadState.getFileName();
        }
        int hashCode = downloadState.getKey().hashCode();
        NotificationCompat.Builder progress = new NotificationCompat.Builder(context, String.valueOf(1)).setTicker(context.getString(2131886509, string)).setContentTitle(context.getString(2131886510, string)).setContentText(context.getString(2131886505)).setProgress(100, (int) ((((float) downloadState.getCurrentLength()) * 100.0f) / ((float) downloadState.getTotalLength())), false);
        NotificationCompat.Builder contentIntent = progress.setContentInfo(StringUtils.formatSize(downloadState.getCurrentLength()) + "/" + StringUtils.formatSize(downloadState.getTotalLength())).setSmallIcon(17301633).setWhen(downloadState.getStartTime()).setOngoing(true).setContentIntent(buildDownloadManagerIntent(context, hashCode));
        contentIntent.addAction(2131231600, context.getString(2131886143), buildPauseIntent(context, hashCode, downloadState.getUrl()));
        contentIntent.addAction(2131231597, context.getString(2131886124), buildDeleteIntent(context, hashCode, downloadState.getUrl()));
        notify(context, downloadState.getKey(), contentIntent.build());
    }

    public void onDownloadSuccess(Context context, DownloadState downloadState) {
        String string = downloadState.getExtra() != null ? downloadState.getExtra().getString("TITLE") : null;
        if (TextUtils.isEmpty(string)) {
            string = downloadState.getFileName();
        }
        notifyResult(context, downloadState.getKey(), new NotificationCompat.Builder(context, String.valueOf(1)).setTicker(context.getString(2131886504, string)).setContentTitle(context.getString(2131886510, string)).setContentText(context.getString(2131886503)).setContentInfo(StringUtils.formatSize(downloadState.getTotalLength())).setSmallIcon(17301634).setWhen(downloadState.getStartTime()).setAutoCancel(true).setContentIntent(buildOpenIntent(context, downloadState.getKey().hashCode(), downloadState.getUrl())).build());
    }

    public void onDownloadCancel(Context context, DownloadState downloadState) {
        String string = downloadState.getExtra() != null ? downloadState.getExtra().getString("TITLE") : null;
        if (TextUtils.isEmpty(string)) {
            string = downloadState.getFileName();
        }
        int hashCode = downloadState.getKey().hashCode();
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, String.valueOf(1)).setTicker(context.getString(2131886507, string)).setContentTitle(context.getString(2131886510, string)).setContentText(context.getString(2131886506));
        NotificationCompat.Builder contentIntent = contentText.setContentInfo(StringUtils.formatSize(downloadState.getCurrentLength()) + "/" + StringUtils.formatSize(downloadState.getTotalLength())).setSmallIcon(17301634).setAutoCancel(true).setWhen(downloadState.getStartTime()).setContentIntent(buildDownloadManagerIntent(context, hashCode));
        contentIntent.addAction(2131231595, context.getString(2131886120), buildContinueIntent(context, hashCode, downloadState.getUrl()));
        contentIntent.addAction(2131231597, context.getString(2131886124), buildDeleteIntent(context, hashCode, downloadState.getUrl()));
        notifyResult(context, downloadState.getKey(), contentIntent.build());
    }

    public void onDownloadError(Context context, DownloadState downloadState) {
        onDownloadCancel(context, downloadState);
    }

    private void notify(Context context, String str, Notification notification) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.equals(str, this.lastNotifyTag)) {
            if (currentTimeMillis - this.lastNotifyTimestamp <= NOTIFICATION_MIN_TIME) {
                LogUtils.d("Skip notify %s", str);
                return;
            } else {
                this.lastNotifyTag = str;
                this.lastNotifyTimestamp = currentTimeMillis;
            }
        }
        LogUtils.d("Notify %s", str);
        ((NotificationManager) context.getSystemService("notification")).notify(null, 1, notification);
    }

    private void notifyResult(Context context, String str, Notification notification) {
        ((NotificationManager) context.getSystemService("notification")).notify(str, 1, notification);
    }

    public void cancelResult(Context context, String str) {
        ((NotificationManager) context.getSystemService("notification")).cancel(str, 1);
    }

    private PendingIntent buildDownloadManagerIntent(Context context, int i) {
        return PendingIntent.getActivity(context, i, new Intent(context, DownloadManagerActivity.class), 134217728);
    }

    private PendingIntent buildOpenIntent(Context context, int i, String str) {
        return PendingIntent.getBroadcast(context, i, new Intent("com.coolapk.market.action.ACTION_DOWNLOAD_SUCCESS_ON_OPEN_CLICK").putExtra("URL", str), 134217728);
    }

    private PendingIntent buildContinueIntent(Context context, int i, String str) {
        return PendingIntent.getBroadcast(context, i, new Intent("com.coolapk.market.action.ACTION_DOWNLOAD_ON_CONTINUE_CLICK").putExtra("URL", str), 134217728);
    }

    private PendingIntent buildPauseIntent(Context context, int i, String str) {
        return PendingIntent.getBroadcast(context, i, new Intent("com.coolapk.market.action.ACTION_DOWNLOAD_ON_pause_CLICK").putExtra("URL", str), 134217728);
    }

    private PendingIntent buildDeleteIntent(Context context, int i, String str) {
        return PendingIntent.getBroadcast(context, i, new Intent("com.coolapk.market.action.ACTION_DOWNLOAD_ON_DELETE_CLICK").putExtra("URL", str), 134217728);
    }
}
