package com.alibaba.mtl.log;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.d.c;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.UTAnalytics;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: UTMCStatConfig */
public class b {
    private static b a = new b();
    private String C = null;
    private String D = null;
    private String E = null;
    private String F = null;
    private String G = null;

    /* renamed from: a  reason: collision with other field name */
    private Application f53a = null;

    /* renamed from: a  reason: collision with other field name */
    private IUTRequestAuthentication f54a = null;
    private Context mContext = null;
    private boolean t = false;
    private boolean u = false;

    private b() {
    }

    public static b a() {
        return a;
    }

    public void setAppVersion(String str) {
        this.G = str;
    }

    public String f() {
        return this.G;
    }

    public void turnOnDebug() {
        i.d(true);
    }

    private void c(String str) {
        Context context;
        this.C = str;
        if (!TextUtils.isEmpty(str)) {
            this.D = str;
        }
        if (!TextUtils.isEmpty(str) && (context = this.mContext) != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_lun", new String(c.encode(str.getBytes("UTF-8"), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    private void d(String str) {
        Context context;
        this.E = str;
        if (!TextUtils.isEmpty(str)) {
            this.F = str;
        }
        if (!TextUtils.isEmpty(str) && (context = this.mContext) != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_luid", new String(c.encode(str.getBytes("UTF-8"), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateUserAccount(String str, String str2) {
        c(str);
        d(str2);
        if (!TextUtils.isEmpty(str)) {
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("UT", 1007, str, str2, null, null).build());
        }
    }

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("UTCommon", 0);
            String string = sharedPreferences.getString("_lun", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.D = new String(c.decode(string.getBytes(), 2), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String string2 = sharedPreferences.getString("_luid", "");
            if (!TextUtils.isEmpty(string2)) {
                try {
                    this.F = new String(c.decode(string2.getBytes(), 2), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        n();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setAppApplicationInstance(Application application) {
        this.f53a = application;
        n();
    }

    private void n() {
        if (!this.t && Build.VERSION.SDK_INT >= 14) {
            try {
                if (a().m12a() != null) {
                    UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks(a().m12a());
                    this.t = true;
                    return;
                }
                UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks((Application) a().getContext().getApplicationContext());
                this.t = true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("UTEngine", "You need set a application instance for UT.");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Application m12a() {
        return this.f53a;
    }
}
