package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.stats.bs;
import com.huawei.hms.stats.bt;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.countrycode.CountryCodeBean;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer {
    private static final Object a = new Object();
    private static HMSBIInitializer b;
    private final Context c;
    private bt.a d;
    private AtomicBoolean e = new AtomicBoolean(false);

    private HMSBIInitializer(Context context) {
        this.c = context;
        this.d = new bt.a(context);
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new HMSBIInitializer(context);
            }
        }
        return b;
    }

    public void initBI() {
        boolean b2 = bs.b();
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + b2);
        if (!b2) {
            boolean biSetting = getBiSetting(this.c);
            HMSLog.i("HMSBIInitializer", "Builder->biSetting :" + biSetting);
            if (!biSetting && this.e.compareAndSet(false, true)) {
                String a2 = new CountryCodeBean(this.c, false).a();
                String upperCase = TextUtils.isEmpty(a2) ? "CN" : a2.toUpperCase(Locale.ENGLISH);
                if ("UNKNOWN".equalsIgnoreCase(upperCase)) {
                    HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
                    this.e.set(false);
                    return;
                }
                new a().execute(upperCase);
            }
        }
    }

    public static boolean getBiSetting(Context context) {
        if (context == null) {
            HMSLog.e("HMSBIInitializer", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSBIInitializer", "In getBiSetting, Failed to get 'PackageManager' instance.");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bi.setting");
            }
            HMSLog.i("HMSBIInitializer", "In getBiSetting, Failed to read meta data bisetting.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("HMSBIInitializer", "In getBiSetting, Failed to read meta data bisetting.");
            return false;
        }
    }

    public boolean isInit() {
        return bs.b();
    }

    private class a extends AsyncTask<String, Integer, Void> {
        private a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.a(strArr[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.c, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOT", new IQueryUrlCallBack() {
            /* class com.huawei.hms.utils.HMSBIInitializer.AnonymousClass1 */

            @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
            public void onCallBackSuccess(String str) {
                if (!TextUtils.isEmpty(str)) {
                    HMSBIInitializer.this.d.d(false).b(false).c(false).a(0, str).a(1, str).a("com.huawei.hwid").a();
                    HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
                }
                HMSBIInitializer.this.e.set(false);
            }

            @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
            public void onCallBackFail(int i) {
                HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i);
                HMSBIInitializer.this.e.set(false);
            }
        });
    }
}
