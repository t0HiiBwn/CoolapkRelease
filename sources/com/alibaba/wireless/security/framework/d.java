package com.alibaba.wireless.security.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.framework.utils.b;
import com.alibaba.wireless.security.framework.utils.c;
import com.alibaba.wireless.security.framework.utils.f;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements ISGPluginManager {
    private static String[] n = {"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};
    private static String o = null;
    private static volatile boolean p = true;
    HashMap<Class, Object> a = new HashMap<>();
    c b = null;
    private Context c;
    private final HashMap<String, c> d = new HashMap<>();
    private IRouterComponent e = null;
    private boolean f = true;
    private String g = null;
    private String h = null;
    private b i = null;
    private boolean j = false;
    private File k = null;
    private File l = null;
    private File m = null;

    private static class a {
        File a;
        File b;
        File c;
        boolean d;

        public a(File file, File file2, File file3, boolean z) {
            this.a = file;
            this.b = file2;
            this.c = file3;
            this.d = z;
        }
    }

    private int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i2 = 0; i2 < length; i2++) {
            int parseInt = Integer.parseInt(split[i2]);
            int parseInt2 = Integer.parseInt(split2[i2]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    private PackageInfo a(String str, a aVar, String str2) throws SecException {
        PackageInfo packageInfo;
        String str3 = "";
        try {
            packageInfo = this.c.getPackageManager().getPackageArchiveInfo(aVar.a.getAbsolutePath(), 133);
        } catch (Throwable th) {
            a(100043, 199, "getPackageArchiveInfo failed", str3 + th, c(aVar.a.getAbsolutePath() + str3), aVar.c != null ? c(aVar.c.getAbsolutePath()) : str3, str2);
            if (aVar.a.exists() && !b(aVar.a)) {
                aVar.a.delete();
            }
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo;
        }
        String str4 = str + "[" + str2 + "]";
        String c2 = c(aVar.a.getAbsolutePath());
        if (aVar.c != null) {
            str3 = c(aVar.c.getAbsolutePath());
        }
        a(100043, 199, "packageInfo == null", str4, c2, str3, c());
        throw new SecException(199);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0521, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0522, code lost:
        r14 = r25;
        r32 = r8;
        r30 = r13;
        r13 = r5;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x054b, code lost:
        r5 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x055a, code lost:
        if (r39.length() == 0) goto L_0x055c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x055c, code lost:
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x055e, code lost:
        r6 = r39 + r10 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0573, code lost:
        if (r37.c != null) goto L_0x0575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0575, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(r32);
        r1.append(c(r37.c.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x058d, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(r30);
        r1.append(c(r37.a.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x05a4, code lost:
        a(100043, 103, "", r5, r6, r1.toString(), c(r7.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x05bb, code lost:
        if (r37.d == false) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x05bd, code lost:
        r35.b.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x05c6, code lost:
        if (r7.exists() != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x05c8, code lost:
        r7.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x05d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x05d9, code lost:
        if (r37.d == false) goto L_0x05db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x05db, code lost:
        r35.b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x05e0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x05e1, code lost:
        a(100043, 199, "native exception occurred", r0.toString(), "soName=" + r13 + ", authCode=" + r35.h + ", errorCode=" + r0.getErrorCode(), c(r37.a.getAbsolutePath()), c(r7.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x062c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x062d, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0631, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0632, code lost:
        r2 = r34;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0521 A[ExcHandler: SecException (e com.alibaba.wireless.security.open.SecException), Splitter:B:109:0x043c] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x054b  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x05e1  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x062c A[ExcHandler: IllegalAccessException (r0v3 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:109:0x043c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0272 A[SYNTHETIC, Splitter:B:68:0x0272] */
    private c a(String str, a aVar, Context context, String str2) throws SecException {
        String str3;
        String str4;
        boolean z;
        String str5;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        a aVar2;
        String str12;
        String str13;
        String str14;
        StringBuilder sb;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        c cVar;
        String str21;
        InstantiationException instantiationException;
        String str22;
        String str23;
        StringBuilder sb2;
        String str24;
        StringBuilder sb3;
        String str25;
        StringBuilder sb4;
        String str26;
        StringBuilder sb5;
        Boolean bool4;
        String str27;
        JSONObject b2;
        String absolutePath = aVar.a.getAbsolutePath();
        String absolutePath2 = aVar.b.getAbsolutePath();
        boolean z2 = false;
        a aVar3 = new a(absolutePath2 + File.separator + str + "_" + (aVar.a.lastModified() / 1000) + ".pkgInfo");
        long j2 = 0;
        try {
            c cVar2 = null;
            if (!aVar3.a() || f.a(this.c)) {
                bool = z2;
                str5 = null;
                str4 = null;
                str3 = null;
            } else {
                try {
                    b2 = aVar3.b();
                    str5 = b2.getString("version");
                } catch (JSONException unused) {
                    bool4 = z2;
                    str5 = null;
                    str27 = null;
                    str3 = str27;
                    bool = z2;
                    z2 = bool4;
                    str4 = str27;
                    z = false;
                    if (z) {
                    }
                    if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                    }
                    str8 = "";
                    str10 = "(";
                    str9 = str7;
                    aVar2 = aVar3;
                    str11 = absolutePath2;
                    str12 = str6;
                    String str28 = str + str10 + str9 + ")";
                    if (str2.length() != 0) {
                    }
                    if (a(str12, str13, false)) {
                    }
                } catch (Exception unused2) {
                    bool4 = z2;
                    str5 = null;
                    str27 = null;
                    str3 = str27;
                    bool = z2;
                    z2 = bool4;
                    str4 = str27;
                    z = false;
                    if (z) {
                    }
                    if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                    }
                    str8 = "";
                    str10 = "(";
                    str9 = str7;
                    aVar2 = aVar3;
                    str11 = absolutePath2;
                    str12 = str6;
                    String str28 = str + str10 + str9 + ")";
                    if (str2.length() != 0) {
                    }
                    if (a(str12, str13, false)) {
                    }
                }
                try {
                    str27 = b2.getString("dependencies");
                    try {
                        bool4 = Boolean.valueOf(Boolean.parseBoolean(b2.getString("hasso")));
                    } catch (JSONException unused3) {
                        bool4 = z2;
                        str3 = null;
                        bool = z2;
                        z2 = bool4;
                        str4 = str27;
                        z = false;
                        if (z) {
                        }
                        if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                        }
                        str8 = "";
                        str10 = "(";
                        str9 = str7;
                        aVar2 = aVar3;
                        str11 = absolutePath2;
                        str12 = str6;
                        String str28 = str + str10 + str9 + ")";
                        if (str2.length() != 0) {
                        }
                        if (a(str12, str13, false)) {
                        }
                    } catch (Exception unused4) {
                        bool4 = z2;
                        str3 = null;
                        bool = z2;
                        z2 = bool4;
                        str4 = str27;
                        z = false;
                        if (z) {
                        }
                        if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                        }
                        str8 = "";
                        str10 = "(";
                        str9 = str7;
                        aVar2 = aVar3;
                        str11 = absolutePath2;
                        str12 = str6;
                        String str28 = str + str10 + str9 + ")";
                        if (str2.length() != 0) {
                        }
                        if (a(str12, str13, false)) {
                        }
                    }
                } catch (JSONException unused5) {
                    bool4 = z2;
                    str27 = null;
                    str3 = str27;
                    bool = z2;
                    z2 = bool4;
                    str4 = str27;
                    z = false;
                    if (z) {
                    }
                    if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                    }
                    str8 = "";
                    str10 = "(";
                    str9 = str7;
                    aVar2 = aVar3;
                    str11 = absolutePath2;
                    str12 = str6;
                    String str28 = str + str10 + str9 + ")";
                    if (str2.length() != 0) {
                    }
                    if (a(str12, str13, false)) {
                    }
                } catch (Exception unused6) {
                    bool4 = z2;
                    str27 = null;
                    str3 = str27;
                    bool = z2;
                    z2 = bool4;
                    str4 = str27;
                    z = false;
                    if (z) {
                    }
                    if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                    }
                    str8 = "";
                    str10 = "(";
                    str9 = str7;
                    aVar2 = aVar3;
                    str11 = absolutePath2;
                    str12 = str6;
                    String str28 = str + str10 + str9 + ")";
                    if (str2.length() != 0) {
                    }
                    if (a(str12, str13, false)) {
                    }
                }
                try {
                    str3 = b2.getString("pluginclass");
                    try {
                        bool = Boolean.valueOf(b2.getBoolean("thirdpartyso"));
                        z2 = bool4;
                        str4 = str27;
                        z = true;
                    } catch (Exception | JSONException unused7) {
                        bool = z2;
                        z2 = bool4;
                        str4 = str27;
                        z = false;
                        if (z) {
                        }
                        if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                        }
                        str8 = "";
                        str10 = "(";
                        str9 = str7;
                        aVar2 = aVar3;
                        str11 = absolutePath2;
                        str12 = str6;
                        String str28 = str + str10 + str9 + ")";
                        if (str2.length() != 0) {
                        }
                        if (a(str12, str13, false)) {
                        }
                    }
                } catch (Exception | JSONException unused8) {
                    str3 = null;
                    bool = z2;
                    z2 = bool4;
                    str4 = str27;
                    z = false;
                    if (z) {
                    }
                    if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
                    }
                    str8 = "";
                    str10 = "(";
                    str9 = str7;
                    aVar2 = aVar3;
                    str11 = absolutePath2;
                    str12 = str6;
                    String str28 = str + str10 + str9 + ")";
                    if (str2.length() != 0) {
                    }
                    if (a(str12, str13, false)) {
                    }
                }
                if (z) {
                    PackageInfo a2 = a(str, aVar, str2);
                    String str29 = a2.versionName;
                    String string = a2.applicationInfo.metaData.getString("dependencies");
                    Boolean valueOf = Boolean.valueOf(a2.applicationInfo.metaData.getBoolean("hasso", false));
                    str3 = a2.applicationInfo.metaData.getString("pluginclass");
                    Boolean valueOf2 = Boolean.valueOf(a2.applicationInfo.metaData.getBoolean("thirdpartyso", false));
                    aVar3.a = a2;
                    aVar3.a(a2, str);
                    bool3 = valueOf;
                    str7 = str29;
                    str6 = string;
                    bool2 = valueOf2;
                } else {
                    bool3 = z2;
                    bool2 = bool;
                    str7 = str5;
                    str6 = str4;
                }
                if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName()) || str7 == null || !str7.contains("6.4.3448869")) {
                    str8 = "";
                    str10 = "(";
                    str9 = str7;
                    aVar2 = aVar3;
                    str11 = absolutePath2;
                    str12 = str6;
                } else {
                    String str30 = Build.FINGERPRINT;
                    String absolutePath3 = aVar.c != null ? aVar.c.getAbsolutePath() : "";
                    String str31 = absolutePath + "(" + aVar.a.getTotalSpace() + ")," + absolutePath2;
                    str10 = "(";
                    str9 = str7;
                    str8 = "";
                    aVar2 = aVar3;
                    str11 = absolutePath2;
                    str12 = str6;
                    a(100088, 2, str30, absolutePath3, d.class.getClassLoader().toString(), str31, this.c.getApplicationInfo().sourceDir + "," + new File(this.c.getApplicationInfo().sourceDir).lastModified());
                }
                String str28 = str + str10 + str9 + ")";
                if (str2.length() != 0) {
                    str13 = str28;
                } else {
                    str13 = str2 + "->" + str28;
                }
                if (a(str12, str13, false)) {
                    if (str2.length() == 0) {
                        str26 = str28;
                    } else {
                        str26 = str2 + "->" + str28;
                    }
                    if (aVar.c != null) {
                        sb5 = new StringBuilder();
                        sb5.append("src:");
                        sb5.append(c(aVar.c.getAbsolutePath()));
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append("zipfile:");
                        sb5.append(c(aVar.a.getAbsolutePath()));
                    }
                    a(100043, 199, "loadRequirements failed", str12, str26, sb5.toString(), "");
                    throw new SecException(199);
                }
                try {
                    b(str, str9);
                    if (bool3.booleanValue()) {
                        String str32 = "libsg" + str + "so-" + str9 + ".so";
                        String str33 = "sg" + str + "so-" + str9;
                        str16 = "zipfile:";
                        str15 = str9;
                        str18 = "src:";
                        str17 = "->";
                        if (!a(absolutePath, str11, aVar.c, str32, aVar.d)) {
                            if (str2.length() == 0) {
                                str25 = str28;
                            } else {
                                str25 = str2 + str17 + str28;
                            }
                            if (aVar.c != null) {
                                sb4 = new StringBuilder();
                                sb4.append(str18);
                                sb4.append(c(aVar.c.getAbsolutePath()));
                            } else {
                                sb4 = new StringBuilder();
                                sb4.append(str16);
                                sb4.append(c(aVar.a.getAbsolutePath()));
                            }
                            a(100043, 107, "", str12, str25, sb4.toString(), "");
                            throw new SecException(107);
                        }
                        str20 = str32;
                        str19 = str33;
                    } else {
                        str16 = "zipfile:";
                        str17 = "->";
                        str15 = str9;
                        str18 = "src:";
                        str20 = str8;
                        str19 = str20;
                    }
                    if (str3 == null) {
                        if (str2.length() == 0) {
                            str24 = str28;
                        } else {
                            str24 = str2 + str17 + str28;
                        }
                        if (aVar.c != null) {
                            sb3 = new StringBuilder();
                            sb3.append(str18);
                            sb3.append(c(aVar.c.getAbsolutePath()));
                        } else {
                            sb3 = new StringBuilder();
                            sb3.append(str16);
                            sb3.append(c(aVar.a.getAbsolutePath()));
                        }
                        a(100043, 199, "miss pluginclass", str12, str24, sb3.toString(), "");
                        throw new SecException(199);
                    }
                    String trim = str3.trim();
                    ClassLoader b3 = b(absolutePath, str11, aVar.d);
                    Class<?> a3 = a(b3, trim);
                    if (a3 == null) {
                        com.alibaba.wireless.security.framework.utils.a.b("load " + trim + " failed from plugin ");
                        if (str2.length() == 0) {
                            str23 = str28;
                        } else {
                            str23 = str2 + str17 + str28;
                        }
                        if (aVar.c != null) {
                            sb2 = new StringBuilder();
                            sb2.append(str18);
                            sb2.append(c(aVar.c.getAbsolutePath()));
                        } else {
                            sb2 = new StringBuilder();
                            sb2.append(str16);
                            sb2.append(c(aVar.a.getAbsolutePath()));
                        }
                        a(100043, 199, "clazz == null", str12, str23, sb2.toString(), trim);
                        throw new SecException(199);
                    }
                    try {
                        ISecurityGuardPlugin iSecurityGuardPlugin = (ISecurityGuardPlugin) a3.newInstance();
                        String str34 = str11;
                        String str35 = str16;
                        String str36 = str20;
                        String str37 = str18;
                        String str38 = str28;
                        try {
                            cVar = new c(absolutePath, this, str, b3, aVar2, iSecurityGuardPlugin);
                            if (str.equalsIgnoreCase(getMainPluginName())) {
                                int i2 = this.f ? 1 : 0;
                                if (this.j) {
                                    i2 |= 2;
                                }
                                String str39 = this.g;
                                if (str39 != null && str39.length() > 0) {
                                    i2 |= 4;
                                }
                                if (f.a(this.c)) {
                                    i2 |= 8;
                                }
                                if (f.b(this.c)) {
                                    i2 |= 16;
                                }
                                try {
                                    b bVar = this.i;
                                    if (bVar != null) {
                                        str22 = bVar.a().toString();
                                        this.e = iSecurityGuardPlugin.onPluginLoaded(context, null, cVar, str19, Integer.valueOf(i2), str22, this.l.getAbsolutePath(), this.h);
                                    }
                                } catch (Exception unused9) {
                                }
                                str22 = str8;
                                this.e = iSecurityGuardPlugin.onPluginLoaded(context, null, cVar, str19, Integer.valueOf(i2), str22, this.l.getAbsolutePath(), this.h);
                            } else {
                                SGPluginExtras.slot = 0;
                                iSecurityGuardPlugin.onPluginLoaded(context, this.e, cVar, str19, new Object[0]);
                            }
                            if (bool3.booleanValue() && !bool2.booleanValue()) {
                                this.e.doCommand(10102, str, str15, f.a(b3, str19));
                            }
                        } catch (InstantiationException e2) {
                            instantiationException = e2;
                            cVar2 = cVar;
                            str21 = str8;
                            com.alibaba.wireless.security.framework.utils.a.a(str21, instantiationException);
                            cVar = cVar2;
                            return cVar;
                        } catch (IllegalAccessException e3) {
                            instantiationException = e3;
                            cVar2 = cVar;
                            str21 = str8;
                            com.alibaba.wireless.security.framework.utils.a.a(str21, instantiationException);
                            cVar = cVar2;
                            return cVar;
                        } catch (SecException e4) {
                            SecException e5 = e4;
                            File file = new File(str34 + File.separator + str36);
                            if (e5.getErrorCode() != 103) {
                            }
                            throw e5;
                        }
                    } catch (InstantiationException e6) {
                        instantiationException = e6;
                        str21 = str8;
                        com.alibaba.wireless.security.framework.utils.a.a(str21, instantiationException);
                        cVar = cVar2;
                        return cVar;
                    } catch (IllegalAccessException e7) {
                    } catch (SecException e8) {
                    }
                    return cVar;
                } catch (SecException e9) {
                    if (str2.length() == 0) {
                        str14 = str28;
                    } else {
                        str14 = str2 + "->" + str28;
                    }
                    if (aVar.c != null) {
                        sb = new StringBuilder();
                        sb.append("src:");
                        sb.append(c(aVar.c.getAbsolutePath()));
                    } else {
                        sb = new StringBuilder();
                        sb.append("zipfile:");
                        sb.append(c(aVar.a.getAbsolutePath()));
                    }
                    a(100043, 199, "isMeetReverseDependencies failed", str12, str14, sb.toString(), "");
                    throw e9;
                }
            }
            z = false;
            if (z) {
            }
            if ("com.eg.android.AlipayGphone".equals(this.c.getPackageName())) {
            }
            str8 = "";
            str10 = "(";
            str9 = str7;
            aVar2 = aVar3;
            str11 = absolutePath2;
            str12 = str6;
            String str28 = str + str10 + str9 + ")";
            if (str2.length() != 0) {
            }
            if (a(str12, str13, false)) {
            }
        } finally {
            SGPluginExtras.slot = j2;
        }
    }

    private File a(Context context) throws SecException {
        if (context != null) {
            String str = null;
            if (context != null) {
                try {
                    String str2 = context.getApplicationInfo().sourceDir;
                    if (str2 != null) {
                        File file = new File(str2);
                        if (file.exists()) {
                            str = (file.lastModified() / 1000) + "";
                        }
                    }
                } catch (Exception e2) {
                    a(100038, 115, "", "" + e2, "", "", "");
                    throw new SecException(e2, 115);
                }
            }
            if (str != null) {
                File dir = context.getDir("SGLib", 0);
                this.l = dir;
                if (dir == null || !dir.exists()) {
                    a(100038, 109, "", "" + this.l, "", "", "");
                    throw new SecException(109);
                }
                File file2 = new File(this.l.getAbsolutePath(), "app_" + str);
                if (!file2.exists()) {
                    file2.mkdirs();
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                }
                if (p && file2.exists()) {
                    p = false;
                    a(this.l, "app_" + str);
                }
                if (file2.exists()) {
                    return file2;
                }
                a(100038, 114, "", "", "", "", "");
                throw new SecException(114);
            }
            throw new SecException(115);
        }
        a(100038, 116, "", "", "", "", "");
        throw new SecException(116);
    }

    private File a(Context context, b bVar) {
        if (f.a(context) || bVar == null || bVar.b() == 0 || bVar.c() == null || bVar.c().length() <= 0) {
            return null;
        }
        File file = new File(this.k.getAbsolutePath() + File.separator + "libs" + File.separator + bVar.b() + File.separator + bVar.c());
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    private File a(String str) {
        if (this.g != null) {
            return null;
        }
        String a2 = f.a(d.class.getClassLoader(), "sg" + str);
        if (a2 == null || a2.length() <= 0) {
            return null;
        }
        return new File(a2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[SYNTHETIC, Splitter:B:29:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0092 A[SYNTHETIC, Splitter:B:36:0x0092] */
    private File a(String str, File file) {
        String str2;
        Throwable th;
        IOException e2;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        File file2 = null;
        try {
            str2 = this.c.getApplicationInfo().sourceDir;
        } catch (Exception unused) {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        String str3 = "libsg" + str + ".so";
        try {
            com.alibaba.wireless.security.framework.utils.a.b("Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed");
            zipFile = new ZipFile(str2);
            try {
                String[] strArr = n;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        String str4 = strArr[i2];
                        String str5 = "lib" + File.separator + str4 + File.separator + str3;
                        if (zipFile.getEntry(str5) != null) {
                            o = str4;
                            file2 = a(str, file, zipFile, str5);
                            break;
                        }
                        i2++;
                    }
                }
                try {
                    zipFile.close();
                } catch (Exception unused2) {
                }
                return file2;
            } catch (IOException e3) {
                e2 = e3;
                try {
                    com.alibaba.wireless.security.framework.utils.a.a("getPluginFile throws exception", e2);
                    a(100047, 3, e2.toString(), str, c(str2), "", "");
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            zipFile = null;
            com.alibaba.wireless.security.framework.utils.a.a("getPluginFile throws exception", e2);
            a(100047, 3, e2.toString(), str, c(str2), "", "");
            if (zipFile != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r1 != null) goto L_0x0014;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    private File a(String str, File file, String str2, String str3) {
        Throwable th;
        IOException e2;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        r0 = null;
        File file2 = null;
        if (str2 == null || str3 == null) {
            return null;
        }
        try {
            com.alibaba.wireless.security.framework.utils.a.b("Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed");
            zipFile = new ZipFile(str2);
            try {
                file2 = a(str, file, zipFile, str3);
            } catch (IOException e3) {
                e2 = e3;
                try {
                    com.alibaba.wireless.security.framework.utils.a.a("getPluginFile throws exception", e2);
                    a(100047, 3, e2.toString(), str, c(str2), "", "");
                } catch (Throwable th2) {
                    th = th2;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            zipFile = null;
            com.alibaba.wireless.security.framework.utils.a.a("getPluginFile throws exception", e2);
            a(100047, 3, e2.toString(), str, c(str2), "", "");
        } catch (Throwable th3) {
            th = th3;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Exception unused) {
                }
            }
            throw th;
        }
        try {
            zipFile.close();
        } catch (Exception unused2) {
        }
        return file2;
    }

    private File a(String str, File file, ZipFile zipFile, String str2) throws IOException {
        ZipEntry entry;
        if (!(zipFile == null || str2 == null || (entry = zipFile.getEntry(str2)) == null || !b.a(entry.getName()))) {
            com.alibaba.wireless.security.framework.utils.a.b("Plugin existed  in " + entry.getName());
            File file2 = new File(file, "libsg" + str + "_inner" + entry.getTime() + ".zip");
            if ((!file2.exists() || file2.length() != entry.getSize()) && !f.a(zipFile, entry, file2)) {
                com.alibaba.wireless.security.framework.utils.a.b("Extract failed!!");
            } else {
                com.alibaba.wireless.security.framework.utils.a.b("Extract success");
                return file2;
            }
        }
        return null;
    }

    private Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            a(100042, 199, "Class.forName failed", "" + th, str, classLoader.toString(), "");
            cls = null;
        }
        com.alibaba.wireless.security.framework.utils.a.b("    loadClassFromClassLoader( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return cls;
    }

    private String a(Class<?> cls) {
        InterfacePluginInfo interfacePluginInfo = (InterfacePluginInfo) cls.getAnnotation(InterfacePluginInfo.class);
        if (interfacePluginInfo == null) {
            return null;
        }
        return interfacePluginInfo.pluginName();
    }

    private void a() throws SecException {
        File a2 = a(this.c);
        this.k = a2;
        if (a2 != null) {
            Context context = this.c;
            this.b = new c(context, this.k + File.separator + "lock.lock");
            b b2 = b();
            this.i = b2;
            this.m = a(this.c, b2);
        }
    }

    private void a(int i2, int i3, String str, String str2, String str3, String str4, String str5) {
        UserTrackMethodJniBridge.addUtRecord("" + i2, i3, 0, com.alibaba.wireless.security.open.initialize.c.a(), 0, str, str2, str3, str4, str5);
    }

    /* access modifiers changed from: private */
    public void a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                a(new File(file, str));
            }
        }
        file.delete();
    }

    private void a(final File file, final String str) {
        new Thread(new Runnable() {
            /* class com.alibaba.wireless.security.framework.d.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                File filesDir;
                File[] listFiles;
                File[] listFiles2;
                try {
                    File file = file;
                    if (file != null && file.isDirectory() && (listFiles2 = file.listFiles()) != null && listFiles2.length > 0) {
                        for (File file2 : listFiles2) {
                            if (file2.isDirectory() && file2.getName().startsWith("app_") && !file2.getName().equals(str)) {
                                d.this.a(file2);
                            } else if (file2.getName().startsWith("libsg")) {
                                file2.delete();
                            }
                        }
                    }
                    if (!(d.this.c == null || (filesDir = d.this.c.getFilesDir()) == null || !filesDir.isDirectory() || (listFiles = filesDir.listFiles()) == null || listFiles.length <= 0)) {
                        for (File file3 : listFiles) {
                            if (file3.getName().startsWith("libsecuritysdk")) {
                                file3.delete();
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009e, code lost:
        r1 = r0;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d A[ExcHandler: all (r0v11 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4 A[SYNTHETIC, Splitter:B:48:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00df A[SYNTHETIC, Splitter:B:53:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f1 A[SYNTHETIC, Splitter:B:62:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fc A[SYNTHETIC, Splitter:B:67:0x00fc] */
    private boolean a(File file, File file2) {
        FileChannel fileChannel;
        Throwable th;
        FileChannel fileChannel2;
        Exception e2;
        FileChannel channel;
        File file3 = new File(file2.getAbsolutePath() + ".tmp." + Process.myPid());
        boolean z = false;
        FileChannel fileChannel3 = null;
        try {
            if (file3.exists()) {
                file3.delete();
            }
            FileChannel channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file3).getChannel();
            } catch (Exception e3) {
                e2 = e3;
                fileChannel = null;
                fileChannel2 = channel2;
                try {
                    com.alibaba.wireless.security.framework.utils.a.a("", e2);
                    a(100047, 2, e2.toString(), c(file.getAbsolutePath()), c(file2.getAbsolutePath()), c(file3.getAbsolutePath()), "");
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (Exception e4) {
                            com.alibaba.wireless.security.framework.utils.a.a("", e4);
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Exception e5) {
                            com.alibaba.wireless.security.framework.utils.a.a("", e5);
                        }
                    }
                    file3.delete();
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel3 = fileChannel2;
                    if (fileChannel3 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    file3.delete();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                fileChannel3 = channel2;
                if (fileChannel3 != null) {
                    try {
                        fileChannel3.close();
                    } catch (Exception e6) {
                        com.alibaba.wireless.security.framework.utils.a.a("", e6);
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Exception e7) {
                        com.alibaba.wireless.security.framework.utils.a.a("", e7);
                    }
                }
                file3.delete();
                throw th;
            }
            try {
                channel.transferFrom(channel2, 0, channel2.size());
                channel2.close();
            } catch (Exception e8) {
                e2 = e8;
                fileChannel2 = channel2;
                fileChannel = channel;
                com.alibaba.wireless.security.framework.utils.a.a("", e2);
                a(100047, 2, e2.toString(), c(file.getAbsolutePath()), c(file2.getAbsolutePath()), c(file3.getAbsolutePath()), "");
                if (fileChannel2 != null) {
                }
                if (fileChannel != null) {
                }
                file3.delete();
                return z;
            } catch (Throwable th4) {
                th = th4;
                fileChannel3 = channel2;
                fileChannel = channel;
                if (fileChannel3 != null) {
                }
                if (fileChannel != null) {
                }
                file3.delete();
                throw th;
            }
            try {
                channel.close();
                if (file3.length() == file.length()) {
                    if (file2.exists()) {
                        if (file2.length() == file.length()) {
                            z = true;
                        } else {
                            file2.delete();
                        }
                    }
                    z = file3.renameTo(file2);
                }
            } catch (Exception e9) {
                e2 = e9;
                fileChannel2 = null;
                fileChannel = channel;
                com.alibaba.wireless.security.framework.utils.a.a("", e2);
                a(100047, 2, e2.toString(), c(file.getAbsolutePath()), c(file2.getAbsolutePath()), c(file3.getAbsolutePath()), "");
                if (fileChannel2 != null) {
                }
                if (fileChannel != null) {
                }
                file3.delete();
                return z;
            } catch (Throwable th5) {
                th = th5;
                fileChannel = channel;
                if (fileChannel3 != null) {
                }
                if (fileChannel != null) {
                }
                file3.delete();
                throw th;
            }
        } catch (Exception e10) {
            e2 = e10;
            fileChannel2 = null;
            fileChannel = null;
            com.alibaba.wireless.security.framework.utils.a.a("", e2);
            a(100047, 2, e2.toString(), c(file.getAbsolutePath()), c(file2.getAbsolutePath()), c(file3.getAbsolutePath()), "");
            if (fileChannel2 != null) {
            }
            if (fileChannel != null) {
            }
            file3.delete();
            return z;
        } catch (Throwable th6) {
        }
        file3.delete();
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0092 A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009b A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0 A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a9 A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b7  */
    private synchronized boolean a(String str, String str2, File file, String str3, boolean z) {
        Exception e2;
        c cVar;
        if (f.a(this.c) && Build.VERSION.SDK_INT > 19) {
            return true;
        }
        if (this.g != null) {
            return true;
        }
        if (file != null) {
            if (new File(file.getParent(), str3).exists()) {
                return true;
            }
            str = file.getAbsolutePath();
        }
        if (!z) {
            this.b.a();
        }
        File file2 = null;
        try {
            File file3 = new File(str2, str3);
            try {
                if (file3.exists()) {
                    if (!z) {
                        this.b.b();
                    }
                    return true;
                } else if (f.a(str, str3, file3)) {
                    if (!z) {
                        this.b.b();
                    }
                    return true;
                } else if (f.a(this.c.getApplicationInfo().sourceDir, str3, file3)) {
                    if (!z) {
                        this.b.b();
                    }
                    return true;
                } else {
                    if (!z) {
                        cVar = this.b;
                        cVar.b();
                    }
                    return false;
                }
            } catch (Exception e3) {
                e2 = e3;
                file2 = file3;
                try {
                    a(100039, 107, e2.toString(), c(), c(str), file2 == null ? c(file2.getAbsolutePath()) : "", file == null ? c(file.getAbsolutePath()) : "");
                    com.alibaba.wireless.security.framework.utils.a.a("", e2);
                    if (!z) {
                    }
                    return false;
                } catch (Throwable th) {
                    if (!z) {
                        this.b.b();
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            a(100039, 107, e2.toString(), c(), c(str), file2 == null ? c(file2.getAbsolutePath()) : "", file == null ? c(file.getAbsolutePath()) : "");
            com.alibaba.wireless.security.framework.utils.a.a("", e2);
            if (!z) {
                cVar = this.b;
                cVar.b();
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str, String str2, boolean z) throws SecException {
        SecException th;
        if (str.trim().length() == 0) {
            return true;
        }
        String[] split = str.split(";");
        char c2 = 0;
        int i2 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            if (trim.length() != 0) {
                String[] split2 = trim.split(":");
                if (split2.length == 2) {
                    int indexOf = str2.indexOf(split2[c2]);
                    if (indexOf >= 0) {
                        int indexOf2 = str2.indexOf("(", indexOf);
                        int indexOf3 = str2.indexOf(")", indexOf);
                        if (indexOf2 < 0 || indexOf3 < 0 || indexOf2 > indexOf3) {
                            a(100040, 199, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", "" + indexOf2, "" + indexOf3, "", "" + i2);
                            throw new SecException(199);
                        }
                        String substring = str2.substring(indexOf2 + 1, indexOf3);
                        if (a(substring, split2[1]) < 0) {
                            String str3 = "version " + substring + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str3 = str3 + ", depended by: " + str2;
                            }
                            if (!z) {
                                a(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", substring, split2[0], split2[1], "" + i2);
                            }
                            throw new SecException(str3, 113);
                        }
                    } else {
                        c cVar = this.d.get(split2[0]);
                        if (cVar == null) {
                            try {
                                cVar = d(split2[0], str2, !z);
                                th = null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            if (cVar == null) {
                                if (!z) {
                                    if (th instanceof SecException) {
                                        throw th;
                                    }
                                    a(100040, 199, "throwable in loadPluginInner", "" + th, str, str2, "" + i2);
                                    throw new SecException(str2, 199);
                                }
                            }
                        }
                        if (a(cVar.getVersion(), split2[1]) < 0) {
                            String str4 = "version " + cVar.getVersion() + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str4 = str4 + ", depended by: " + str2;
                            }
                            if (!z) {
                                a(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", cVar.getVersion(), split2[0], split2[1], "" + i2);
                            }
                            throw new SecException(str4, 113);
                        }
                    }
                } else {
                    a(100040, 199, "nameVersionPair.length != 2", trim, str2, "" + z, "" + i2);
                    throw new SecException(199);
                }
            }
            i2++;
            c2 = 0;
        }
        return true;
    }

    private b b() {
        b bVar;
        File file = new File(this.k, "update.config");
        File file2 = new File(this.k, "init.config");
        if (this.j) {
            bVar = b.a(file);
            if (bVar == null) {
                return b.a(file2);
            }
            try {
                this.b.a();
                file2.delete();
                file.renameTo(file2);
            } catch (Throwable th) {
                this.b.b();
                throw th;
            }
        } else {
            try {
                this.b.a();
                bVar = b.a(file2);
            } catch (Throwable th2) {
                this.b.b();
                throw th2;
            }
        }
        this.b.b();
        return bVar;
    }

    private File b(String str) {
        String str2 = this.g;
        if (str2 == null) {
            try {
                str2 = this.c.getApplicationInfo().nativeLibraryDir;
            } catch (Exception unused) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            File file = new File(str2 + File.separator + "libsg" + str + ".so");
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private ClassLoader b(String str, String str2, boolean z) {
        if (!z) {
            try {
                this.b.a();
            } catch (Throwable th) {
                if (!z) {
                    this.b.b();
                }
                throw th;
            }
        }
        String str3 = this.c.getApplicationInfo().nativeLibraryDir + File.pathSeparator + str2;
        if (this.g != null) {
            str3 = str3 + File.pathSeparator + this.g;
            com.alibaba.wireless.security.framework.utils.a.b("add path to native classloader " + str3);
        }
        if (o != null) {
            str3 = str3 + File.pathSeparator + this.c.getApplicationInfo().sourceDir + "!/lib/" + o;
        }
        ClassLoader dexClassLoader = (Build.VERSION.SDK_INT < 21 || "6.0.1".equalsIgnoreCase(Build.VERSION.RELEASE)) ? new DexClassLoader(str, str2, str3, d.class.getClassLoader()) : new PathClassLoader(str, str3, d.class.getClassLoader());
        if (!z) {
            this.b.b();
        }
        return dexClassLoader;
    }

    private boolean b(File file) {
        try {
            return !file.getParentFile().getCanonicalPath().equals(file.getCanonicalFile().getParentFile().getCanonicalPath()) || !file.getName().equals(file.getCanonicalFile().getName());
        } catch (Exception e2) {
            com.alibaba.wireless.security.framework.utils.a.a("", e2);
            a(100047, 0, e2.toString(), file.getAbsolutePath(), "", "", "");
            return false;
        }
    }

    private boolean b(File file, File file2) {
        Method method;
        try {
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 21) {
                method = Class.forName("android.system.Os").getDeclaredMethod("symlink", String.class, String.class);
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                method = obj.getClass().getMethod("symlink", String.class, String.class);
            }
            method.invoke(obj, file.getAbsolutePath(), file2.getAbsolutePath());
            return true;
        } catch (Exception e2) {
            com.alibaba.wireless.security.framework.utils.a.a("create symbolic link( " + file2.getAbsolutePath() + " -> " + file.getAbsolutePath() + " ) failed", e2);
            String exc = e2.toString();
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            a(100047, 1, exc, absolutePath, absolutePath2, "" + Build.VERSION.SDK_INT, "");
            return false;
        }
    }

    private boolean b(String str, String str2) throws SecException {
        for (Map.Entry<String, c> entry : this.d.entrySet()) {
            String key = entry.getKey();
            c value = entry.getValue();
            String a2 = value.a("reversedependencies");
            if (a2 != null) {
                String[] split = a2.split(";");
                for (int i2 = 0; i2 < split.length; i2++) {
                    String trim = split[i2].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(":");
                        if (split2.length != 2) {
                            a(100041, 199, "nameVersionPair.length != 2", str + "(" + str2 + ")", key + "(" + value.getVersion() + ")", c(value.getPluginPath()), a2);
                            throw new SecException(199);
                        } else if (split2[0].equalsIgnoreCase(str) && a(str2, split2[1]) < 0) {
                            String str3 = "plugin " + str + "(" + str2 + ") is not meet the reverse dependency of " + key + "(" + value.getVersion() + "): " + split2[0] + "(" + split2[1] + ")";
                            a(100041, 117, str3, d.class.getClassLoader().toString(), c(value.getPluginPath()), a2, "" + i2);
                            throw new SecException(str3, 117);
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059 A[SYNTHETIC, Splitter:B:18:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x015a A[Catch:{ all -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015f A[Catch:{ all -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0236  */
    private a c(String str, String str2, boolean z) throws SecException {
        boolean z2;
        File file;
        File file2;
        boolean z3;
        Throwable th;
        boolean z4;
        File file3;
        a aVar;
        File file4;
        String str3;
        File file5;
        int i2 = 0;
        if (this.m != null) {
            file2 = new File(this.m, "libsg" + str + ".so");
            if (file2.exists()) {
                file = d(this.m);
                if (file != this.m) {
                    z2 = true;
                    if (file == null) {
                        file = d(this.k);
                        z2 = file != this.k;
                    }
                    if (!z2) {
                        this.b.a();
                    }
                    if (file2 == null) {
                        try {
                            file2 = a(str);
                            if (!c(file2)) {
                                file2 = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z3 = z2;
                            if (!z3) {
                            }
                            throw th;
                        }
                    }
                    if (file2 != null) {
                        String absolutePath = file2.getAbsolutePath();
                        if (!"com.eg.android.AlipayGphone".equals(this.c.getPackageName()) || absolutePath == null || !absolutePath.contains("app_plugins_lib")) {
                            str3 = absolutePath;
                            z4 = z2;
                            file4 = file;
                            file5 = file2;
                        } else {
                            str3 = absolutePath;
                            file4 = file;
                            z4 = z2;
                            try {
                                a(100088, 1, Build.FINGERPRINT, absolutePath + "(" + file2.getTotalSpace() + ")", d.class.getClassLoader().toString(), file.getAbsolutePath(), this.c.getApplicationInfo().sourceDir + "," + new File(this.c.getApplicationInfo().sourceDir).lastModified());
                                file5 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                z3 = z4;
                                if (!z3) {
                                }
                                throw th;
                            }
                        }
                        if (file5 != null && str3 != null && str3.contains("!/")) {
                            String[] split = str3.split("!/", 2);
                            String str4 = split[0];
                            String str5 = split[1];
                            String[] strArr = n;
                            int length = strArr.length;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String str6 = strArr[i2];
                                if (("lib" + File.separator + str6 + File.separator + "libsg" + str + ".so").equals(str5)) {
                                    o = str6;
                                    file3 = file4;
                                    file2 = a(str, file3, str4, str5);
                                    break;
                                }
                                i2++;
                            }
                        }
                        file3 = file4;
                        file2 = file5;
                    } else {
                        z4 = z2;
                        file3 = file;
                    }
                    if (file2 == null) {
                        file2 = b(str);
                    }
                    if (file2 == null && z) {
                        file2 = a(str, file3);
                    }
                    if (file2 != null) {
                        z3 = z4;
                        try {
                            if (file2.getAbsolutePath().endsWith(".zip")) {
                                aVar = new a(file2, file3, null, z3);
                            } else if (f.a()) {
                                aVar = new a(file2, file3, file2, z3);
                            } else {
                                File file6 = new File(file3, "libsg" + str + "_" + file2.lastModified() + ".zip");
                                if (!file6.exists() || !b(file6) || c(file6, file2)) {
                                    file6.delete();
                                    if (b(file2, file6)) {
                                        aVar = new a(file6, file3, file2, z3);
                                    } else {
                                        File file7 = new File(file3, "libsg" + str + "_cp" + file2.lastModified() + ".zip");
                                        aVar = ((!file7.exists() || file7.length() != file2.length()) && !a(file2, file7)) ? null : new a(file7, file3, file2, z3);
                                    }
                                } else {
                                    aVar = new a(file6, file3, file2, z3);
                                }
                            }
                            if (!z3) {
                                this.b.b();
                            }
                            return aVar;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z3) {
                                this.b.b();
                            }
                            throw th;
                        }
                    } else if (z4) {
                        return null;
                    } else {
                        this.b.b();
                        return null;
                    }
                }
                z2 = false;
                if (file == null) {
                }
                if (!z2) {
                }
                if (file2 == null) {
                }
                if (file2 != null) {
                }
                if (file2 == null) {
                }
                file2 = a(str, file3);
                if (file2 != null) {
                }
            }
        }
        file2 = null;
        file = null;
        z2 = false;
        if (file == null) {
        }
        if (!z2) {
        }
        if (file2 == null) {
        }
        if (file2 != null) {
        }
        if (file2 == null) {
        }
        file2 = a(str, file3);
        if (file2 != null) {
        }
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        File file = this.k;
        if (file == null || !file.exists() || !file.isDirectory()) {
            sb.append("not exists!");
        } else {
            try {
                sb.append("[");
                File[] listFiles = file.listFiles();
                int i2 = 0;
                while (listFiles != null && i2 < listFiles.length) {
                    File file2 = listFiles[i2];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith("zip") || file2.getName().endsWith(".so"))) {
                        sb.append(file2.getName());
                        sb.append("(");
                        sb.append(b(file2) + " , ");
                        sb.append(file2.length());
                        sb.append(") , ");
                    }
                    i2++;
                }
                sb.append("]");
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    private String c(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (b(file)) {
            sb.append("->");
            try {
                sb.append(file.getCanonicalPath());
            } catch (Exception unused) {
            }
        }
        sb.append('[');
        sb.append("exists:" + file.exists() + ",");
        sb.append("size:" + file.length() + ",");
        sb.append("canRead:" + file.canRead() + ",");
        sb.append("canWrite:" + file.canWrite() + ",");
        sb.append("totalSpace:" + file.getTotalSpace() + ",");
        sb.append("freeSpace:" + file.getFreeSpace() + ",");
        sb.append(']');
        return sb.toString();
    }

    private boolean c(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null) {
                    if (absolutePath.length() > 0) {
                        if (f.a(this.c) || !absolutePath.startsWith("/system/")) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean c(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getCanonicalPath());
        } catch (Exception e2) {
            com.alibaba.wireless.security.framework.utils.a.a("", e2);
            a(100046, 0, e2.toString(), file.getAbsolutePath(), file2.getAbsolutePath(), "", "");
            return false;
        }
    }

    private synchronized ISGPluginInfo d(String str, String str2, boolean z) throws SecException {
        StringBuilder sb;
        c cVar = this.d.get(str);
        if (cVar != null) {
            return cVar;
        }
        File file = this.k;
        if (file == null || !file.exists()) {
            a();
        }
        a c2 = c(str, str2, z);
        if (c2 != null && c2.a != null && c2.a.exists()) {
            c a2 = a(str, c2, this.c, str2);
            if (a2 == null) {
                if (c2.c != null) {
                    sb = new StringBuilder();
                    sb.append("src:");
                    sb.append(c(c2.c.getAbsolutePath()));
                } else {
                    sb = new StringBuilder();
                    sb.append("zipfile:");
                    sb.append(c(c2.a.getAbsolutePath()));
                }
                a(100044, 110, "", str, str2, sb.toString(), "");
                throw new SecException(str, 111);
            }
            this.d.put(str, a2);
            final String str3 = str + "(" + a2.getVersion() + ")";
            final String a3 = a2.a("weakdependencies");
            if (str2.length() != 0) {
                str3 = str2 + "->" + str3;
            }
            Looper myLooper = Looper.myLooper();
            if (myLooper == null || myLooper == Looper.getMainLooper()) {
                com.alibaba.wireless.security.framework.utils.a.a("looper of current thread is null, try to create a new thread with a looper");
                HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                handlerThread.start();
                myLooper = handlerThread.getLooper();
            }
            new Handler(myLooper).postDelayed(new Runnable() {
                /* class com.alibaba.wireless.security.framework.d.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.a(a3, str3, true);
                    } catch (SecException e) {
                        com.alibaba.wireless.security.framework.utils.a.a("load weak dependency", e);
                    }
                }
            }, 60000);
            return a2;
        } else if (!z) {
            return null;
        } else {
            String str4 = "plugin " + str + " not existed";
            if (str2.length() != 0) {
                str4 = str4 + ", depended by " + str2;
            }
            a(100044, 110, "", str, str2, "", "");
            throw new SecException(str4, 110);
        }
    }

    private File d(File file) {
        if (!file.exists() || !file.isDirectory() || !this.j) {
            return file;
        }
        File file2 = new File(file, "main");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.exists() ? file2 : file;
    }

    public void a(Context context, String str, String str2, boolean z, Object... objArr) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.c = context;
        this.h = str;
        this.j = f.c(context);
        this.f = z;
        UserTrackMethodJniBridge.init(this.c);
        if (str2 != null && !str2.isEmpty()) {
            this.g = str2;
        }
        try {
            a();
        } catch (SecException unused) {
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public synchronized <T> T getInterface(Class<T> cls) throws SecException {
        Object obj = this.a.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        String str = null;
        b bVar = this.i;
        if (bVar != null && ((str = bVar.d()) == null || str.length() == 0)) {
            str = this.i.a(cls.getName());
        }
        if (str == null || str.length() == 0) {
            str = a((Class<?>) cls);
        }
        if (str == null || str.length() == 0) {
            throw new SecException(150);
        }
        ISGPluginInfo pluginInfo = getPluginInfo(str);
        if (pluginInfo != null) {
            Object obj2 = pluginInfo.getSGPluginEntry().getInterface(cls);
            if (obj2 != null) {
                this.a.put(cls, obj2);
                return cls.cast(obj2);
            }
            String name = cls.getName();
            a(100045, 112, "", name, str + "(" + pluginInfo.getVersion() + ")", c(pluginInfo.getPluginPath()), "");
            throw new SecException(112);
        }
        throw new SecException(110);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public String getMainPluginName() {
        return "main";
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public ISGPluginInfo getPluginInfo(String str) throws SecException {
        return d(str, "", true);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public IRouterComponent getRouter() {
        return this.e;
    }
}
