package com.ss.android.socialbase.appdownloader.f.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ss.android.socialbase.downloader.d.b;
import com.ss.android.socialbase.downloader.i.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PackageInfoUtils */
public class e {
    private static String a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0177 A[SYNTHETIC, Splitter:B:115:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x017e A[SYNTHETIC, Splitter:B:119:0x017e] */
    public static PackageInfo a(File file) {
        Throwable th;
        ZipFile zipFile;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2;
        ZipEntry zipEntry;
        ZipInputStream zipInputStream3;
        int b;
        long j;
        ZipInputStream zipInputStream4;
        FileInputStream fileInputStream2;
        a aVar = null;
        aVar = null;
        aVar = null;
        String str = null;
        aVar = null;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    ZipInputStream zipInputStream5 = new ZipInputStream(fileInputStream3);
                    while (true) {
                        ZipEntry nextEntry = zipInputStream5.getNextEntry();
                        if (nextEntry == null) {
                            zipFile = null;
                            zipEntry = nextEntry;
                            fileInputStream = fileInputStream3;
                            zipInputStream3 = zipInputStream5;
                            zipInputStream2 = null;
                            break;
                        } else if (!nextEntry.isDirectory()) {
                            if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                                zipFile = null;
                                zipEntry = nextEntry;
                                fileInputStream = fileInputStream3;
                                zipInputStream3 = zipInputStream5;
                                zipInputStream2 = zipInputStream5;
                                break;
                            }
                            zipInputStream5.closeEntry();
                        } else {
                            try {
                                zipInputStream5.closeEntry();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zipFile = null;
                    fileInputStream = fileInputStream3;
                    zipInputStream = null;
                    try {
                        throw new c("throwable: " + th.getMessage() + th.toString());
                    } catch (Throwable unused2) {
                    }
                }
            } else {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    ZipEntry zipEntry2 = null;
                    while (true) {
                        if (!entries.hasMoreElements()) {
                            zipInputStream4 = null;
                            zipFile = zipFile2;
                            zipEntry = zipEntry2;
                            fileInputStream2 = null;
                            break;
                        }
                        zipEntry2 = (ZipEntry) entries.nextElement();
                        if (!zipEntry2.isDirectory()) {
                            if ("AndroidManifest.xml".equals(zipEntry2.getName())) {
                                InputStream inputStream = zipFile2.getInputStream(zipEntry2);
                                zipFile = zipFile2;
                                zipEntry = zipEntry2;
                                fileInputStream2 = null;
                                zipInputStream4 = inputStream;
                                break;
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                    zipInputStream3 = fileInputStream2;
                    zipInputStream2 = zipInputStream4;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    zipFile = zipFile2;
                    zipInputStream = null;
                    throw new c("throwable: " + th.getMessage() + th.toString());
                }
            }
            if (zipEntry != null) {
                try {
                    if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                        a aVar2 = new a();
                        try {
                            aVar2.a(zipInputStream2);
                            do {
                                b = aVar2.b();
                                if (b == 1) {
                                    throw new c("已达到END_DOCUMENT");
                                }
                            } while (b != 2);
                            int e = aVar2.e();
                            String str2 = null;
                            String str3 = null;
                            for (int i = 0; i != e; i++) {
                                if ("versionName".equals(aVar2.a(i))) {
                                    str2 = a(aVar2, i);
                                } else if ("versionCode".equals(aVar2.a(i))) {
                                    str = a(aVar2, i);
                                } else if ("package".equals(aVar2.a(i))) {
                                    str3 = a(aVar2, i);
                                }
                            }
                            try {
                                j = Long.parseLong(str);
                            } catch (c unused3) {
                                j = -1;
                            }
                            if (j != -1) {
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = str2;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = str3;
                                if (zipInputStream3 != 0) {
                                    try {
                                        zipInputStream3.closeEntry();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                try {
                                    aVar2.a();
                                } catch (Throwable unused5) {
                                }
                                if (zipInputStream2 != null) {
                                    try {
                                        zipInputStream2.close();
                                    } catch (Throwable unused6) {
                                    }
                                }
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused8) {
                                    }
                                }
                                return packageInfo;
                            }
                            throw new c("versionCode获取失败: " + str);
                        } catch (Throwable th4) {
                            zipInputStream = zipInputStream2;
                            th = th4;
                            aVar = aVar2;
                            throw new c("throwable: " + th.getMessage() + th.toString());
                        }
                    }
                } catch (Throwable th5) {
                    zipInputStream = zipInputStream2;
                    th = th5;
                    throw new c("throwable: " + th.getMessage() + th.toString());
                }
            }
            throw new c("没有找到AndroidManifest.xml entry");
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
            fileInputStream = null;
            zipFile = null;
            throw new c("throwable: " + th.getMessage() + th.toString());
        }
        throw th;
        if (zipFile != null) {
            zipFile.close();
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        throw th;
        if (fileInputStream != null) {
        }
        throw th;
        if (zipInputStream != null) {
            zipInputStream.close();
        }
        if (zipFile != null) {
        }
        if (fileInputStream != null) {
        }
        throw th;
    }

    public static PackageInfo a(Context context, File file, int i) {
        if (!a.a(268435456) || Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 26) {
            return b(context, file, i);
        }
        try {
            return a(file);
        } catch (Throwable th) {
            a("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            return b(context, file, i);
        }
    }

    private static PackageInfo b(Context context, File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            a("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            a("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    private static void a(String str, String str2) {
        b g = com.ss.android.socialbase.downloader.downloader.b.g();
        if (g != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", str2);
            } catch (JSONException unused) {
            }
            g.a(str, jSONObject, null, null);
        }
    }

    private static String a(a aVar, int i) {
        int b = aVar.b(i);
        int c = aVar.c(i);
        if (b == 3) {
            return aVar.d(i);
        }
        if (b == 2) {
            return String.format("?%s%08X", a(c), Integer.valueOf(c));
        }
        if (b < 16 || b > 31) {
            return String.format("<0x%X, type 0x%02X>", Integer.valueOf(c), Integer.valueOf(b));
        }
        return String.valueOf(c);
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            a("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
