package com.tencent.android.tpush;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.b;

/* compiled from: ProGuard */
public class XGVipPushKAProvider extends ContentProvider {
    private void a(Uri uri, Context context) {
        if (context != null) {
            try {
                TLogger.d("XGVipPushKAProvider", "prepare startService");
                Intent intent = new Intent();
                intent.setData(uri);
                intent.setClass(context, XGVipPushService.class);
                context.startService(intent);
            } catch (Throwable th) {
                TLogger.w("XGVipPushKAProvider", "start service failed.", th);
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate start service context: ");
        sb.append(context != null);
        TLogger.d("XGVipPushKAProvider", sb.toString());
        if (context != null) {
            b.a(context);
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        a(uri, getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        a(uri, getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        a(uri, getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        a(uri, getContext());
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a(uri, getContext());
        return 0;
    }
}
