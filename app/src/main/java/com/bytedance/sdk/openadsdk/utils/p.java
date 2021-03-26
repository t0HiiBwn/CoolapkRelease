package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.f.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: InitChecker */
public class p {
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x021c A[Catch:{ all -> 0x029f }] */
    public static void a() {
        Context a2 = com.bytedance.sdk.openadsdk.core.p.a();
        if (a2 != null && u.c()) {
            u.f("TTAdSdk-InitChecker", "==当前进程名：" + a(a2));
            u.f("TTAdSdk-InitChecker", "==穿山甲sdk接入，环境为debug，初始化配置检测开始==");
            String packageName = a2.getPackageName();
            int i = a2.getApplicationInfo().targetSdkVersion;
            PackageManager packageManager = a2.getPackageManager();
            boolean z = false;
            boolean z2 = false;
            for (ProviderInfo providerInfo : packageManager.queryContentProviders(a2.getApplicationInfo().processName, a2.getApplicationInfo().uid, 131072)) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (TextUtils.isEmpty(str) || !str.equals(providerInfo.authority)) {
                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                    } else {
                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置正常");
                    }
                    z = true;
                } else {
                    if (providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                        if (Build.VERSION.SDK_INT < 24 || i < 24) {
                            u.f("TTAdSdk-InitChecker", "TTFileProvider不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=24");
                        } else {
                            if (providerInfo.exported) {
                                u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                            }
                            if (!providerInfo.grantUriPermissions) {
                                u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                            }
                            try {
                                List<a> a3 = a(a2, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                                if (a3 == null || a3.isEmpty()) {
                                    u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                                } else {
                                    List<a> c = c();
                                    List<a> d = d();
                                    for (a aVar : a3) {
                                        if (aVar != null) {
                                            c.remove(aVar);
                                            d.remove(aVar);
                                        }
                                    }
                                    if (!c.isEmpty() || !d.isEmpty()) {
                                        Iterator<a> it2 = c.iterator();
                                        while (it2.hasNext()) {
                                            u.f("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it2.next().toString());
                                        }
                                        Iterator<a> it3 = d.iterator();
                                        while (it3.hasNext()) {
                                            u.f("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it3.next().toString());
                                        }
                                    } else {
                                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置正常");
                                    }
                                }
                            } catch (Throwable th) {
                                u.c("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                            }
                        }
                        z2 = true;
                    }
                }
            }
            try {
                String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr == null || strArr.length <= 0) {
                    u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
                    try {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (i >= 23) {
                                boolean a4 = d.a().a(a2, "android.permission.READ_PHONE_STATE");
                                boolean a5 = d.a().a(a2, "android.permission.ACCESS_COARSE_LOCATION");
                                boolean a6 = d.a().a(a2, "android.permission.ACCESS_FINE_LOCATION");
                                boolean a7 = d.a().a(a2, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!a4) {
                                    u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                                } else {
                                    u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.READ_PHONE_STATE");
                                }
                                if (!a5) {
                                    u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                                } else {
                                    u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.ACCESS_COARSE_LOCATION");
                                }
                                if (!a6) {
                                    u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                                } else {
                                    u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.ACCESS_FINE_LOCATION");
                                }
                                if (!a7) {
                                    u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                                } else {
                                    u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.WRITE_EXTERNAL_STORAGE");
                                }
                                if (!z) {
                                    u.f("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
                                }
                                if (!z2) {
                                    u.f("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
                                }
                                u.f("TTAdSdk-InitChecker", "==穿山甲sdk初始化配置检测结束==");
                            }
                        }
                        u.f("TTAdSdk-InitChecker", "动态权限不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
                    } catch (Throwable th2) {
                        u.c("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th2);
                    }
                    if (!z) {
                    }
                    if (!z2) {
                    }
                    u.f("TTAdSdk-InitChecker", "==穿山甲sdk初始化配置检测结束==");
                }
                List<String> b = b();
                for (String str2 : strArr) {
                    if (str2 != null) {
                        b.remove(str2);
                    }
                }
                if (b.isEmpty()) {
                    u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中权限配置正常");
                } else {
                    Iterator<String> it4 = b.iterator();
                    while (it4.hasNext()) {
                        u.f("TTAdSdk-InitChecker", "    可能缺少权限：" + it4.next() + "，请参考接入文档");
                    }
                }
                if (Build.VERSION.SDK_INT >= 23) {
                }
                u.f("TTAdSdk-InitChecker", "动态权限不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
                if (!z) {
                }
                if (!z2) {
                }
                u.f("TTAdSdk-InitChecker", "==穿山甲sdk初始化配置检测结束==");
            } catch (Throwable th3) {
                u.c("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th3);
            }
        }
    }

    private static String a(Context context) {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "unknown";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.READ_PHONE_STATE");
        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add("android.permission.GET_TASKS");
        arrayList.add("android.permission.WAKE_LOCK");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        return arrayList;
    }

    private static List<a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("external-path", "tt_external_download", "Download"));
        arrayList.add(new a("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new a("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new a("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<a> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("external-path", "tt_external_root", "."));
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    private static List<a> a(Context context, int i) {
        XmlResourceParser xmlResourceParser;
        try {
            ArrayList arrayList = new ArrayList();
            xmlResourceParser = context.getResources().getXml(i);
            try {
                for (int eventType = xmlResourceParser.getEventType(); eventType != 1; eventType = xmlResourceParser.next()) {
                    if (eventType == 2) {
                        String name = xmlResourceParser.getName();
                        int attributeCount = xmlResourceParser.getAttributeCount();
                        String str = null;
                        String str2 = null;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            String attributeName = xmlResourceParser.getAttributeName(i2);
                            if (attributeName.equals("name")) {
                                str = xmlResourceParser.getAttributeValue(i2);
                            } else if (attributeName.equals("path")) {
                                str2 = xmlResourceParser.getAttributeValue(i2);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            arrayList.add(new a(name, str, str2));
                        }
                    }
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return arrayList;
            } catch (Throwable unused) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return null;
            }
        } catch (Throwable unused2) {
            xmlResourceParser = null;
            if (xmlResourceParser != null) {
            }
            return null;
        }
    }

    /* compiled from: InitChecker */
    private static class a {
        String a;
        String b;
        String c;

        a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            String str2 = this.a;
            return str2 != null && str2.equals(aVar.a) && (str = this.c) != null && str.equals(aVar.c);
        }

        public String toString() {
            try {
                return "<" + this.a + " name=\"" + this.b + "\" path=\"" + this.c + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }
}
