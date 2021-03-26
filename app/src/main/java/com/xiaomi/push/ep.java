package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;

public class ep extends Notification.Builder {
    private Context a;

    public ep(Context context) {
        super(context);
        this.a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return 0;
    }

    /* renamed from: a */
    protected Context mo296a() {
        return this.a;
    }

    /* renamed from: a */
    public ep addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    /* renamed from: a */
    public ep setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    protected void a() {
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        a();
        return super.build();
    }
}
