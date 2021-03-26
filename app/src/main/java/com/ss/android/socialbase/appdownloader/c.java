package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.appdownloader.c.f;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.b;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppDownloadUtils */
public class c {
    private static int a;
    private static NotificationChannel b;

    private static String a(long j, long j2, String str, boolean z) {
        double d = (double) j;
        if (j2 > 1) {
            d /= (double) j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static String a(long j) {
        return a(j, true);
    }

    public static String a(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return a(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    private static String a(long j, long j2, String str) {
        double d = (double) j;
        if (j2 > 1) {
            d /= (double) j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    public static String b(long j) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return a(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static int a(final Context context, final int i, final boolean z) {
        j g = d.j().g();
        if (g == null) {
            return d(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        a = 1;
        g.a(downloadInfo, new i() {
            /* class com.ss.android.socialbase.appdownloader.c.AnonymousClass1 */

            @Override // com.ss.android.socialbase.appdownloader.c.i
            public void a() {
                int unused = c.a = c.d(context, i, z);
            }
        });
        return a;
    }

    /* access modifiers changed from: private */
    public static int d(Context context, int i, boolean z) {
        boolean z2 = true;
        if (a.a(i).b("notification_opt_2") == 1) {
            b.a().f(i);
        }
        a((Activity) h.a().b());
        if (a.a(i).a("install_queue_enable", 0) != 1) {
            z2 = false;
        }
        if (z2) {
            return h.a().a(context, i, z);
        }
        return b(context, i, z);
    }

    public static int b(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.b.a(new Runnable() {
                    /* class com.ss.android.socialbase.appdownloader.c.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        c.b(downloadInfo, z, c.a(context, i, z, downloadInfo, file));
                    }
                });
                return 1;
            }
        }
        b(downloadInfo, z, 2);
        return 2;
    }

    /* access modifiers changed from: private */
    public static void b(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("by_user", z ? 1 : 2);
                jSONObject.put("view_result", i);
                jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.ss.android.socialbase.downloader.downloader.b.N().a(downloadInfo.getId(), "install_view_result", jSONObject);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0033, code lost:
        if (r0 != null) goto L_0x003f;
     */
    public static int a(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        Throwable th;
        PackageInfo packageInfo;
        Intent intent;
        Process process;
        Throwable th2;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    process.waitFor();
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        th2.printStackTrace();
                    } finally {
                        if (process != null) {
                            process.destroy();
                        }
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                process = null;
                th2.printStackTrace();
            }
        }
        try {
            packageInfo = a(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            th = null;
        } catch (Throwable th6) {
            th = th6;
            packageInfo = null;
        }
        if (d.j().c() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                d.j().c().a(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                d.j().c().a(downloadInfo, null, 11);
            }
        }
        if (a(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && a.a(downloadInfo.getId()).a("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (b(context, downloadInfo, packageInfo)) {
            intent = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else if (z || !a(context, i, file)) {
            intent = a(context, downloadInfo, file, z, iArr);
        } else {
            downloadInfo.getTempCacheData().put("extra_silent_install_succeed", true);
            return 1;
        }
        if (intent != null) {
            intent.addFlags(268435456);
            if (downloadInfo.getLinkMode() > 0 && a.a(downloadInfo.getId()).a("app_install_return_result", 0) == 1) {
                intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            if (iArr[0] != 0 || !b.a(context, downloadInfo, intent, z)) {
                return a(context, intent);
            }
            return 1;
        } else if (iArr[0] == 1) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int a(Context context, Intent intent) {
        try {
            if (d.j().n() != null && d.j().n().a(intent)) {
                return 1;
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        d b2 = d.j().b();
        if (b2 != null) {
            b2.a(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (b2.a()) {
                return true;
            }
        }
        ab downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.a(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.c.c a2 = d.j().a();
        if (!(a2 instanceof com.ss.android.socialbase.appdownloader.c.a) || !((com.ss.android.socialbase.appdownloader.c.a) a2).c()) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, int i, File file) {
        if (a.a(i).a("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.f.c.k() || com.ss.android.socialbase.appdownloader.f.c.l()) && com.ss.android.socialbase.downloader.i.i.a(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int a() {
        return d.j().f() ? 16384 : 0;
    }

    public static Uri a(int i, t tVar, Context context, String str, File file) {
        Uri uri;
        if (tVar != null) {
            try {
                uri = tVar.a(str, file.getAbsolutePath());
            } catch (Throwable unused) {
            }
        } else {
            f e = d.j().e();
            if (e != null) {
                uri = e.a(i, str, file.getAbsolutePath());
            }
            uri = null;
        }
        if (uri != null) {
            return uri;
        }
        try {
            if (Build.VERSION.SDK_INT < 24 || TextUtils.isEmpty(str)) {
                return Uri.fromFile(file);
            }
            return FileProvider.getUriForFile(context, str, file);
        } catch (Throwable th) {
            th.printStackTrace();
            return uri;
        }
    }

    private static Intent a(Context context, DownloadInfo downloadInfo, File file, boolean z, int[] iArr) {
        Uri a2 = a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, d.j().d(), file);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(a2, "application/vnd.android.package-archive");
        d b2 = d.j().b();
        boolean a3 = b2 != null ? b2.a(downloadInfo.getId(), z) : false;
        ab downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener != null) {
            a3 = downloadNotificationEventListener.a(z);
        }
        int i = a3 ? 1 : 0;
        int i2 = a3 ? 1 : 0;
        int i3 = a3 ? 1 : 0;
        int i4 = a3 ? 1 : 0;
        int i5 = a3 ? 1 : 0;
        iArr[0] = i;
        if (a3) {
            return null;
        }
        return intent;
    }

    public static boolean a(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(downloadInfo.getPackageName()) && str.equals(downloadInfo.getPackageName())) {
            return true;
        }
        if (TextUtils.isEmpty(downloadInfo.getName()) || !a(com.ss.android.socialbase.downloader.downloader.b.L(), downloadInfo, str)) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo a2 = a(downloadInfo, file);
                if (a2 == null || !a2.packageName.equals(str)) {
                    return false;
                }
                int i = a2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else if (!a.a(downloadInfo.getId()).a("install_callback_error")) {
                return false;
            } else {
                String a3 = e.a(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int a4 = e.a(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (a3 == null || TextUtils.isEmpty(a3) || !a3.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || a4 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return a(context, downloadInfo, packageInfo, false);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, a());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        if (z) {
            if (i < i2) {
                return true;
            }
            return false;
        } else if (downloadInfo == null || a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) != 1) {
            if (i <= i2) {
                return true;
            }
            return false;
        } else if (i < i2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo) {
        return a(context, downloadInfo, true);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return c(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, a());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        if (a.a(downloadInfo.getId()).a("install_with_same_version_code", 0) == 1) {
            if (appVersionCode < packageInfo.versionCode) {
                return true;
            }
            return false;
        } else if (appVersionCode <= packageInfo.versionCode) {
            return true;
        } else {
            return false;
        }
    }

    public static int b(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo a2 = a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (a2 != null) {
                    int i = a2.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return b(context, downloadInfo, a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static PackageInfo a(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return a(downloadInfo, file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static String a(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(parse.getLastPathSegment())) {
                    str2 = parse.getLastPathSegment();
                }
            }
            if (c(str3) && !str2.endsWith(".apk")) {
                return str2 + ".apk";
            }
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment)) {
            str2 = lastPathSegment;
        }
        return c(str3) ? str2 : str2;
        str2 = "default.apk";
        if (c(str3)) {
        }
    }

    public static String b() {
        return e.e();
    }

    public static String a(String str, a aVar) {
        JSONObject d;
        String format;
        if (aVar == null || (d = aVar.d("download_dir")) == null) {
            return "";
        }
        String optString = d.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (new JSONObject(str).optBoolean("bind_app", false)) {
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optBoolean("bind_app", false) || !jSONObject.optBoolean("auto_install_with_notification", true)) {
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        if (DownloadStatus.isDownloadOver(i)) {
            return 3;
        }
        return 0;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r0 == null) goto L_0x0044;
     */
    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT > 20 && context != null) {
            TypedArray typedArray = null;
            try {
                int color = context.getResources().getColor(e.b());
                typedArray = context.obtainStyledAttributes(e.e(), new int[]{e.c(), e.d()});
                if (color == typedArray.getColor(0, 0)) {
                    if (typedArray != null) {
                        try {
                            typedArray.recycle();
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    public static String b(Context context) {
        try {
            if (b == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                b = notificationChannel;
                notificationChannel.setSound(null, null);
                b.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static void a(DownloadInfo downloadInfo, boolean z, boolean z2) {
        d.j().a(new f(com.ss.android.socialbase.downloader.downloader.b.L(), downloadInfo.getUrl()).a(downloadInfo.getTitle()).b(downloadInfo.getName()).c(downloadInfo.getSavePath()).a(downloadInfo.isShowNotification()).b(downloadInfo.isAutoInstallWithoutNotification()).c(downloadInfo.isOnlyWifi() || z2).d(downloadInfo.getExtra()).e(downloadInfo.getMimeType()).a(downloadInfo.getExtraHeaders()).e(true).b(downloadInfo.getRetryCount()).c(downloadInfo.getBackUpUrlRetryCount()).b(downloadInfo.getBackUpUrls()).d(downloadInfo.getMinProgressTimeMsInterval()).e(downloadInfo.getMaxProgressCount()).f(z).d(downloadInfo.isNeedHttpsToHttpRetry()).f(downloadInfo.getPackageName()).g(downloadInfo.getMd5()).a(downloadInfo.getExpectFileLength()).i(downloadInfo.isNeedDefaultHttpServiceBackUp()).j(downloadInfo.isNeedReuseFirstConnection()).l(downloadInfo.isNeedIndependentProcess()).a(downloadInfo.getEnqueueType()).n(downloadInfo.isForce()).m(downloadInfo.isHeadConnectionAvailable()).g(downloadInfo.isNeedRetryDelay()).h(downloadInfo.getRetryDelayTimeArray()).a(d(downloadInfo.getDownloadSettingString())).j(downloadInfo.getIconUrl()).f(downloadInfo.getExecutorGroup()));
    }

    private static JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static PackageInfo a(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.b.L(), file, a());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo a2 = com.ss.android.socialbase.appdownloader.f.a.e.a(com.ss.android.socialbase.downloader.downloader.b.L(), file, a());
        downloadInfo.setPackageInfo(a2);
        return a2;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
