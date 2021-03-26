package com.coolapk.market.service;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ColorUtils;

public class DownloadListRemoteService extends RemoteViewsService {
    @Override // android.widget.RemoteViewsService
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ListRemoteViewsFactory(getApplicationContext());
    }

    private static class ListRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
        private Context context;

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getCount() {
            return 2;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
        }

        public ListRemoteViewsFactory(Context context2) {
            this.context = context2;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public RemoteViews getViewAt(int i) {
            RemoteViews remoteViews = new RemoteViews(this.context.getPackageName(), 2131559076);
            remoteViews.setInt(2131362790, "setBackgroundColor", ColorUtils.adjustAlpha(((TextView) remoteViews.apply(this.context, new LinearLayout(this.context)).findViewById(2131363843)).getCurrentTextColor(), 0.6f));
            remoteViews.setTextColor(2131362161, AppHolder.getAppTheme().getColorAccent());
            remoteViews.setTextColor(2131362164, AppHolder.getAppTheme().getColorAccent());
            return remoteViews;
        }
    }
}
