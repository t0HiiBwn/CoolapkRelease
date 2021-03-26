package com.tencent.android.tpush.d.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class g extends c {
    private String a = null;
    private String b = null;
    private Context c;

    @Override // com.tencent.android.tpush.d.c
    public int e(Context context) {
        return 8;
    }

    public g(Context context) {
        this.c = context;
        TLogger.dd("OtherPushXgSysImpl", "OtherPushXgSysImpl");
    }

    @Override // com.tencent.android.tpush.d.c
    public void a(Context context) {
        this.a = null;
        PushPreferences.putString(context, "xg_sys_token", "");
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.tpns.syspush.auth/register"), null, Long.toString(XGApiConfig.getAccessId(context)), null, null);
            if (query != null) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("xg_sys_token"));
                this.a = string;
                PushPreferences.putString(context, "xg_sys_token", string);
                query.close();
            }
            TLogger.ii("OtherPushXgSysImpl", "registerPush ret otherToken:" + this.a);
        } catch (Throwable th) {
            TLogger.ee("OtherPushXgSysImpl", "registerPush throwable:", th);
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.tpns.syspush.auth/unregister"), null, Long.toString(XGApiConfig.getAccessId(context)), null, null);
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            TLogger.ee("OtherPushXgSysImpl", "unregisterPush throwable:", th);
        }
        this.a = null;
        PushPreferences.putString(context, "xg_sys_token", "");
    }

    @Override // com.tencent.android.tpush.d.c
    public String c(Context context) {
        if (j.b(this.a)) {
            this.a = PushPreferences.getString(context, "xg_sys_token", "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.d.c
    public boolean d(Context context) {
        f(context);
        boolean z = !j.b(this.b);
        TLogger.dd("OtherPushXgSysImpl", "isConfig: " + z);
        return z;
    }

    @Override // com.tencent.android.tpush.d.c
    public String a() {
        f(this.c);
        return this.b;
    }

    private void f(Context context) {
        if (this.b == null) {
            this.b = "";
            JSONObject g = g(context);
            if (g == null) {
                return;
            }
            if (g.optString("xg_sys_pkg", "").equals(context.getPackageName())) {
                TLogger.ii("OtherPushXgSysImpl", "Run in sys app, set pushinfo empty");
            } else {
                this.b = g.optString("xg_sys_pushinfo", "");
            }
        }
    }

    private JSONObject g(Context context) {
        try {
            String type = context.getContentResolver().getType(Uri.parse("content://com.tencent.tpns.syspush.auth"));
            TLogger.ii("OtherPushXgSysImpl", "sysPushInfo:" + type);
            if (type != null) {
                return new JSONObject(type);
            }
            return null;
        } catch (Throwable unused) {
            TLogger.ii("OtherPushXgSysImpl", "get sysPushInfo get throwable");
            return null;
        }
    }
}
