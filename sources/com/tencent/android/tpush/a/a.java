package com.tencent.android.tpush.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class a {
    private static volatile a a;
    private Context b = null;
    private PackageManager c = null;
    private HashMap<String, b> d = new HashMap<>();
    private Map<String, Long> e = new HashMap();

    private a(Context context) {
        this.b = context;
        this.c = context.getPackageManager();
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    public void a() {
        try {
            b();
        } catch (Throwable th) {
            TLogger.e("IPCManager", "init", th);
        }
    }

    public void b() {
        TLogger.d("IPCManager", "action - initProviders");
        List<ProviderInfo> queryContentProviders = this.c.queryContentProviders(null, 0, 0);
        List<String> c2 = c();
        if (!(queryContentProviders == null || c2 == null)) {
            for (ProviderInfo providerInfo : queryContentProviders) {
                if (c2.contains(providerInfo.packageName) && providerInfo.exported) {
                    b bVar = this.d.get(providerInfo.packageName);
                    if (bVar == null) {
                        bVar = new b();
                    }
                    bVar.a(providerInfo.packageName);
                    if (providerInfo.name.equals(XGPushProvider.class.getName())) {
                        bVar.a(providerInfo);
                    } else {
                        bVar.b(providerInfo);
                    }
                    this.d.put(providerInfo.packageName, bVar);
                }
            }
        }
    }

    public List<String> c() {
        TLogger.d("IPCManager", "action - getAllLocalXGApps");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryBroadcastReceivers = this.c.queryBroadcastReceivers(new Intent("com.tencent.android.xg.vip.action.SDK"), 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                arrayList.add(resolveInfo.resolvePackageName);
            }
        }
        Map<String, ProviderInfo> a2 = com.tencent.android.tpush.a.a(this.b);
        if (a2 != null) {
            for (Map.Entry<String, ProviderInfo> entry : a2.entrySet()) {
                if (!arrayList.contains(entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    public void a(String str) {
        try {
            if (d() && !this.b.getPackageName().equals(str)) {
                TLogger.d("IPCManager", "tryWakeUpApp packageName:" + str);
                c(str);
            }
        } catch (Throwable th) {
            TLogger.e("IPCManager", "tryWakeUpApp", th);
        }
    }

    private boolean d() {
        String str = com.tencent.android.tpush.service.a.a.a(this.b).I;
        String str2 = Build.MANUFACTURER;
        TLogger.d("IPCManager", "wakeCtr:" + str + ",mf:" + str2);
        if (!j.b(str) || !j.b(str2)) {
            for (String str3 : str.split(",")) {
                if (str3.toLowerCase().equals(str2.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void c(String str) {
        Long l = this.e.get(str);
        if (l == null || System.currentTimeMillis() <= l.longValue()) {
            b b2 = b(str);
            TLogger.d("IPCManager", "tryWakeUpApp ipcAppInfo:" + b2);
            if (b2 != null) {
                ArrayList<ProviderInfo> a2 = b2.a();
                TLogger.d("IPCManager", "tryWakeUpApp providerInfoList:" + a2);
                if (a2 != null) {
                    for (ProviderInfo providerInfo : a2) {
                        if (providerInfo.exported) {
                            String str2 = providerInfo.authority;
                            Uri parse = Uri.parse("content://" + str2);
                            TLogger.d("IPCManager", "tryWakeUpApp uri:" + parse);
                            this.b.getContentResolver().getType(parse);
                        }
                    }
                }
            }
            this.e.put(str, Long.valueOf(System.currentTimeMillis() + 3600000));
        }
    }

    public b b(String str) {
        if (!this.d.containsKey(str)) {
            a();
        }
        return this.d.get(str);
    }
}
