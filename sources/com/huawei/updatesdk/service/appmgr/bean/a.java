package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.a.a;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.a.a.c.g;
import com.huawei.updatesdk.service.a.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class a extends c {
    public static final String APIMETHOD = "client.updateCheck";
    public static final int DEFAULT_UPGRADE_RESULT = 0;
    public static final int FULL_UPGRADE_RESULT = 1;
    public static final int INSTALL_CHECK_DEFAULT = 0;
    private static final int PARSE_IS_REMOVABLE_PREINSTALLED_APK = 33554432;
    public static final int PRE_DOWNLOAD_CLOSE = 0;
    private static final String TAG = "UpgradeRequest";
    private static final int TYPE_NOT_PREINSTALL = 0;
    private static final int TYPE_PREINSTALL = 2;
    private static final int TYPE_PREINSTALL_REMOVABLE = 1;
    private String agVersion_;
    private String buildNumber_;
    private String density_;
    private com.huawei.updatesdk.a.a.c.a.a deviceSpecParams_;
    private int emuiApiLevel_ = 0;
    private String firmwareVersion_;
    private int getSafeGame_ = 1;
    private int gmsSupport_;
    private int installCheck_ = 0;
    private int isFirstLaunch_ = 0;
    private int isFullUpgrade_ = 0;
    private int mapleVer_;
    private String packageName_;
    private String phoneType_;
    private C0079a pkgInfo_;
    private String resolution_;
    private String serviceCountry_;
    private int supportMaple_ = 0;
    private int versionCode_;
    private String version_;

    /* renamed from: com.huawei.updatesdk.service.appmgr.bean.a$a  reason: collision with other inner class name */
    public static class C0079a extends com.huawei.updatesdk.a.b.d.a.b {
        private List<b> params_;

        public void a(List<b> list) {
            this.params_ = list;
        }
    }

    public static class b extends com.huawei.updatesdk.a.b.d.a.b {
        private static final String FILE_SHA_KEY = "fileshakey";
        private static final String PACKAGE_KEY = "packagekey";
        private String fSha2_;
        private int isPre_;
        private int maple_;
        private String oldVersion_;
        private String package_;
        private String sSha2_;
        private int targetSdkVersion_;
        private int versionCode_;

        public b() {
        }

        public b(PackageInfo packageInfo) {
            this.package_ = packageInfo.packageName;
            this.versionCode_ = packageInfo.versionCode;
            this.oldVersion_ = packageInfo.versionName == null ? "null" : packageInfo.versionName;
            this.targetSdkVersion_ = packageInfo.applicationInfo.targetSdkVersion;
            this.isPre_ = a.b(packageInfo);
            this.maple_ = com.huawei.updatesdk.service.e.c.b(this.package_);
            if (packageInfo.signatures != null) {
                String c = g.c(com.huawei.updatesdk.a.a.c.a.a(g.d(packageInfo.signatures[0].toCharsString())));
                if (!TextUtils.isEmpty(c)) {
                    this.sSha2_ = c.toLowerCase(Locale.getDefault());
                }
            }
            String str = "packagekey" + this.package_;
            String str2 = "fileshakey" + this.package_;
            if (TextUtils.isEmpty(packageInfo.applicationInfo.sourceDir)) {
                this.fSha2_ = null;
                com.huawei.updatesdk.service.a.a.a().d(str);
                com.huawei.updatesdk.service.a.a.a().d(str2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.lastUpdateTime);
            sb.append(packageInfo.versionCode);
            sb.append(this.package_);
            boolean z = !TextUtils.equals(sb.toString(), com.huawei.updatesdk.service.a.a.a().c(str));
            if (z) {
                com.huawei.updatesdk.service.a.a.a().a(str, sb.toString());
            }
            String c2 = com.huawei.updatesdk.service.a.a.a().c(str2);
            if (TextUtils.isEmpty(c2) || z) {
                c2 = d.a(packageInfo.applicationInfo.sourceDir, "SHA-256");
                com.huawei.updatesdk.service.a.a.a().a(str2, c2);
            }
            this.fSha2_ = c2;
        }
    }

    public a() {
        Context b2 = com.huawei.updatesdk.a.b.a.a.a().b();
        b("client.updateCheck");
        c("1.2");
        e(com.huawei.updatesdk.a.a.c.a.b.e());
        n(com.huawei.updatesdk.a.a.c.a.b.b());
        g(com.huawei.updatesdk.a.a.c.a.b.i(b2));
        h(com.huawei.updatesdk.a.a.c.a.b.a());
        i(Build.MODEL);
        f(com.huawei.updatesdk.a.a.c.a.b.a(b2));
        e(com.huawei.updatesdk.a.a.c.a.b.f(b2));
        f(com.huawei.updatesdk.a.a.c.a.b.e(b2) ? 1 : 0);
        j(com.huawei.updatesdk.a.a.c.a.b.d(b2));
        k(com.huawei.updatesdk.a.b.a.a.a().b().getPackageName());
        g(com.huawei.updatesdk.service.e.b.a().b());
        l(com.huawei.updatesdk.service.a.a.a().c());
        c(com.huawei.updatesdk.a.a.c.a.b.f().g());
        d(com.huawei.updatesdk.a.a.c.a.b.f().h());
        this.deviceSpecParams_ = new a.C0076a(b2).a(true).a();
        m(com.huawei.updatesdk.a.a.c.a.b.h(b2));
    }

    public static a a(List<PackageInfo> list) {
        a aVar = new a();
        C0079a aVar2 = new C0079a();
        aVar.a(aVar2);
        ArrayList arrayList = new ArrayList();
        aVar2.a(arrayList);
        for (PackageInfo packageInfo : list) {
            arrayList.add(new b(packageInfo));
        }
        return aVar;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        String str;
        StringBuilder sb;
        int i = applicationInfo.flags;
        Integer a = com.huawei.updatesdk.service.e.c.a();
        if (a != null && (i & a.intValue()) != 0) {
            return true;
        }
        Field b2 = com.huawei.updatesdk.service.e.c.b();
        if (b2 == null) {
            return false;
        }
        try {
            return (b2.getInt(applicationInfo) & 33554432) != 0;
        } catch (IllegalAccessException e) {
            sb = new StringBuilder();
            sb.append("can not get hwflags");
            str = e.toString();
            sb.append(str);
            com.huawei.updatesdk.a.a.b.a.a.a.a("UpgradeRequest", sb.toString());
            return false;
        } catch (IllegalArgumentException e2) {
            sb = new StringBuilder();
            sb.append("can not get hwflags");
            str = e2.toString();
            sb.append(str);
            com.huawei.updatesdk.a.a.b.a.a.a.a("UpgradeRequest", sb.toString());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static int b(PackageInfo packageInfo) {
        if ((packageInfo.applicationInfo.flags & 1) == 0) {
            return 0;
        }
        return a(packageInfo.applicationInfo) ? 1 : 2;
    }

    public static a d(String str) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = str;
        packageInfo.versionName = "1.0";
        packageInfo.versionCode = 1;
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.targetSdkVersion = 19;
        packageInfo.applicationInfo = applicationInfo;
        ArrayList arrayList = new ArrayList();
        arrayList.add(packageInfo);
        a a = a(arrayList);
        a.b(1);
        return a;
    }

    public void a(int i) {
        this.installCheck_ = i;
    }

    public void a(C0079a aVar) {
        this.pkgInfo_ = aVar;
    }

    public void b(int i) {
        this.isFullUpgrade_ = i;
    }

    public void c(int i) {
        this.supportMaple_ = i;
    }

    public void d(int i) {
        this.mapleVer_ = i;
    }

    public void e(int i) {
        this.versionCode_ = i;
    }

    public void e(String str) {
        this.firmwareVersion_ = str;
    }

    public void f(int i) {
        this.gmsSupport_ = i;
    }

    public void f(String str) {
        this.density_ = str;
    }

    public void g(int i) {
        this.emuiApiLevel_ = i;
    }

    public void g(String str) {
        this.version_ = str;
    }

    public void h(String str) {
        this.buildNumber_ = str;
    }

    public void i(String str) {
        this.phoneType_ = str;
    }

    public void j(String str) {
        this.resolution_ = str;
    }

    public void k(String str) {
        this.packageName_ = str;
    }

    public void l(String str) {
        this.serviceCountry_ = str;
    }

    public void m(String str) {
        this.agVersion_ = str;
    }
}
