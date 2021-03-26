package com.coolapk.market.util;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ShellUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class PackageUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0099, code lost:
        if (r12 != null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a0, code lost:
        r11.addSuppressed(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a7, code lost:
        if (r2 != null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ad, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ae, code lost:
        r11.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b1, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c4, code lost:
        if (0 == 0) goto L_0x00c9;
     */
    public static boolean installBySession(Context context, String str) {
        Uri uri;
        PackageInstaller.Session session = null;
        try {
            PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
            PackageInstaller.Session openSession = packageInstaller.openSession(packageInstaller.createSession(new PackageInstaller.SessionParams(1)));
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(context, SystemUtils.getAuthority(context), new File(str));
            } else {
                uri = Uri.parse("file://" + str);
            }
            long j = -1;
            String str2 = "temp.apk";
            DocumentFile fromSingleUri = DocumentFile.fromSingleUri(context, uri);
            if (fromSingleUri != null) {
                j = fromSingleUri.length();
                str2 = fromSingleUri.getName();
            }
            OutputStream openWrite = openSession.openWrite(str2, 0, j);
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                openWrite.write(bArr, 0, read);
            }
            if (openInputStream != null) {
                openInputStream.close();
            }
            if (openWrite != null) {
                openWrite.close();
            }
            openSession.commit(PendingIntent.getBroadcast(context, 0, new Intent("com.coolapk.market.action.INSTALL_STATUS"), 134217728).getIntentSender());
            if (openSession != null) {
                openSession.close();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e2) {
            if (0 != 0) {
                session.abandon();
            }
            e2.printStackTrace();
            if (0 != 0) {
                session.close();
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                session.close();
            }
            throw th;
        }
    }

    public static boolean installNormal(Context context, String str) {
        Uri uri;
        File file = new File(str);
        if (file.exists() && file.isFile() && file.length() > 0) {
            try {
                Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.setFlags(1);
                    uri = FileProvider.getUriForFile(context, SystemUtils.getAuthority(context), file);
                } else {
                    uri = Uri.parse("file://" + str);
                }
                intent.setDataAndType(uri, "application/vnd.android.package-archive");
                intent.addFlags(268435456);
                CoolFileUtils.grantUriPermission(context, intent, uri);
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                LogUtils.e(e, "Install normal error", new Object[0]);
            }
        }
        return false;
    }

    public static boolean isEnforcing() throws IOException, InterruptedException {
        final StringBuilder sb = new StringBuilder();
        ShellUtils.execCommand("getenforce", false, new ShellUtils.Callback() {
            /* class com.coolapk.market.util.PackageUtils.AnonymousClass1 */

            @Override // com.coolapk.market.util.ShellUtils.Callback
            public void onOutput(String str) {
                StringBuilder sb = sb;
                sb.append(str.trim());
                sb.append("\n");
            }
        });
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            sb2 = "enforcing";
        }
        return sb2.toLowerCase().contains("enforcing");
    }

    public static boolean installSilent(String str, boolean z) throws IOException, InterruptedException, TimeoutException {
        String str2 = "rm -f ";
        ShellUtils.Callback callback = null;
        boolean z2 = true;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String str3 = "pm install -r --user " + (Process.myUid() / 100000) + " '" + str + "'";
                    LogUtils.d(str3, new Object[0]);
                    final StringBuilder sb = new StringBuilder();
                    ShellUtils.execCommand(str3, true, TimeUnit.MINUTES.toMillis(5), (ShellUtils.Callback) new ShellUtils.Callback() {
                        /* class com.coolapk.market.util.PackageUtils.AnonymousClass2 */

                        @Override // com.coolapk.market.util.ShellUtils.Callback
                        public void onOutput(String str) {
                            StringBuilder sb = sb;
                            sb.append(str.trim());
                            sb.append("\n");
                        }
                    });
                    String lowerCase = sb.toString().toLowerCase();
                    boolean contains = lowerCase.contains("success");
                    if (!contains) {
                        if (!lowerCase.contains("system server has no access to read file context")) {
                            if (!lowerCase.contains("consider using a file under /data/local/tmp/")) {
                                DataManager.getInstance().saveLog("install", lowerCase, "安装失败");
                            }
                        }
                        File file = new File("/data/local/tmp/coolapk");
                        if (!file.exists()) {
                            ShellUtils.execCommand("mkdir -p " + file.getAbsolutePath(), true, null);
                        }
                        String absolutePath = new File(file, "app-install-temp.apk").getAbsolutePath();
                        ShellUtils.execCommand("cp " + str + " " + absolutePath, true, null);
                        return installSilent(absolutePath, true);
                    }
                    if (z) {
                        ShellUtils.execCommand("rm -f " + str, true, null);
                    }
                    return contains;
                }
            } finally {
                if (z) {
                    ShellUtils.execCommand(str2 + str, z2, callback);
                }
            }
        }
        if (z) {
            ShellUtils.execCommand("rm -f " + str, true, null);
        }
        return false;
    }

    public static boolean uninstallNormal(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean uninstallSilent(String str, boolean z) throws IOException, InterruptedException, TimeoutException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pm uninstall ");
        sb.append(z ? "-k " : "");
        sb.append(str.replace(" ", "\\ "));
        String sb2 = sb.toString();
        final StringBuilder sb3 = new StringBuilder();
        ShellUtils.execCommand(sb2, true, TimeUnit.MINUTES.toMillis(3), (ShellUtils.Callback) new ShellUtils.Callback() {
            /* class com.coolapk.market.util.PackageUtils.AnonymousClass3 */

            @Override // com.coolapk.market.util.ShellUtils.Callback
            public void onOutput(String str) {
                sb3.append(str);
            }
        });
        String sb4 = sb3.toString();
        if (sb4.contains("Success") || sb4.contains("success")) {
            return true;
        }
        return false;
    }

    public static boolean isInstalled(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 8192) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAppNewInstall(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null || packageInfo.lastUpdateTime == packageInfo.firstInstallTime) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static CharSequence getApplicationLabel(Context context, String str) {
        PackageManager packageManager;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ApplicationInfo getArchiveApplicationInfo(Context context, String str) {
        PackageManager packageManager;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                packageArchiveInfo.applicationInfo.sourceDir = str;
                packageArchiveInfo.applicationInfo.publicSourceDir = str;
                return packageArchiveInfo.applicationInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getArchiveLabel(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            ApplicationInfo archiveApplicationInfo = getArchiveApplicationInfo(context, str);
            if (archiveApplicationInfo != null) {
                return archiveApplicationInfo.loadLabel(packageManager).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isMarketInstalled(Context context, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.wandoujia.phoenix2");
            arrayList.add("com.android.vending");
            arrayList.add("com.qihoo.appstore");
            arrayList.add("com.baidu.appsearch");
            arrayList.add("com.xiaomi.market");
            arrayList.add("com.tencent.android.qqdownloader");
            arrayList.add("com.diguayouxi");
            arrayList.add("com.netease.apper");
            arrayList.add("com.taptap");
            arrayList.add("cn.com.shouji.market");
            arrayList.add("com.apkpure.aegon");
            arrayList.add("com.yingyonghui.market");
            arrayList.add("com.pp.assistant");
            if (context.getPackageManager().getPackageInfo(str, 8192) == null || !arrayList.contains(str)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<ResolveInfo> getWallpaperApps(Context context, String str) {
        Uri uri;
        final ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context, SystemUtils.getAuthority(context), new File(str));
        } else {
            uri = Uri.fromFile(new File(str));
        }
        Intent intent = new Intent("android.intent.action.ATTACH_DATA");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("mimeType", "image/*");
        intent.addFlags(1);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (CollectionUtils.safeSize(queryIntentActivities) > 0) {
            Observable.from(queryIntentActivities).filter(new Func1<ResolveInfo, Boolean>() {
                /* class com.coolapk.market.util.PackageUtils.AnonymousClass5 */

                public Boolean call(ResolveInfo resolveInfo) {
                    return Boolean.valueOf(resolveInfo.activityInfo.packageName.contains("contacts"));
                }
            }).toList().subscribe((Subscriber) new Subscriber<List<ResolveInfo>>() {
                /* class com.coolapk.market.util.PackageUtils.AnonymousClass4 */

                @Override // rx.Observer
                public void onCompleted() {
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                }

                public void onNext(List<ResolveInfo> list) {
                    arrayList.addAll(list);
                }
            });
        }
        return arrayList;
    }

    public static List<ResolveInfo> getShareApps(Context context) {
        Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("text/plain");
        return context.getPackageManager().queryIntentActivities(intent, 0);
    }
}
