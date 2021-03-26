package com.tencent.beacon.qimei;

import android.content.Context;
import android.os.Environment;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.b.e;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class QimeiUtil {
    private static final String QIMEI_SDCARD_PATH = "tencent/beacon/meta.dat";
    private static final String SP_LAST_GEN_QIMEI_DATE = "GEN_QIMEI";
    private static final String SP_QIMEI = "QIMEI_DENGTA";
    private static final String SP_QIMEI_V2 = "qimei_v2";
    private static final String SP_TODAY_GEN_QIMEI_TIMES = "GEN_QIMEI_TIMES";

    public static String loadQIMEI(Context context) {
        c a = c.a(context);
        String str = "";
        String a2 = a.a("QIMEI_DENGTA", str);
        b.b("[qimei] get QIMEI:%s from sp", a2);
        if (a2 == null || a2.trim().equals(str)) {
            e.a(context);
            if (e.g()) {
                a2 = loadQIMEIFromSDCard(context);
                b.b("[qimei] get QIMEI:%s from sdcard", a2);
                if (a2 != null && !a2.trim().equals(str)) {
                    b.b("[qimei] Save QIMEI:%s to sp", a2);
                    a.a().a("QIMEI_DENGTA", (Object) a2).b();
                }
            }
        }
        if (a2 != null) {
            str = a2;
        }
        b.a("[qimei] load QIMEI:%s from sp/sdcard", str);
        return str;
    }

    public static void saveQIMEI(Context context, String str) {
        if (str != null && !str.trim().equals("")) {
            e.a(context);
            if (e.g()) {
                saveQIMEIToSDCard(str);
                b.b("[qimei] Save QIMEI:%s to SDCard", str);
            }
            c.a(context).a("QIMEI_DENGTA", (Object) str).b();
            b.b("[qimei] update QIMEI:%s, and save to sp.", str);
        }
    }

    public static boolean isMaxGenToday(Context context) {
        return h.a().equals(getLastGenDate(context)) && getTodayGenTimes(context) >= ModuleImpl.getInstance(context).getMaxQIMEIQueryOneDay();
    }

    public static void incGenQIMEITimes(Context context) {
        int todayGenTimes = getTodayGenTimes(context);
        if (!h.a().equals(getLastGenDate(context))) {
            setLastGenDateAsToday(context);
            todayGenTimes = 0;
        }
        c.a(context).a().a("GEN_QIMEI_TIMES", Integer.valueOf(todayGenTimes + 1)).b();
    }

    private static int getTodayGenTimes(Context context) {
        return c.a(context).a("GEN_QIMEI_TIMES");
    }

    private static String getLastGenDate(Context context) {
        return c.a(context).a("GEN_QIMEI", "");
    }

    private static void setLastGenDateAsToday(Context context) {
        c.a(context).a().a("GEN_QIMEI", (Object) h.a()).b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0046, code lost:
        if (r1 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r1 != null) goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    private static String loadQIMEIFromSDCard(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(Environment.getExternalStorageDirectory(), "tencent/beacon/meta.dat");
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[((int) file.length())];
                fileInputStream.read(bArr);
                fileInputStream.close();
                byte[] b = h.b(bArr, 3, getLocalEncryptKey());
                if (b != null) {
                    String str = new String(b);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return str;
                }
            } catch (FileNotFoundException unused2) {
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            fileInputStream = null;
        } catch (IOException unused6) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused7) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[SYNTHETIC, Splitter:B:16:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044 A[SYNTHETIC, Splitter:B:22:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004b A[SYNTHETIC, Splitter:B:27:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    private static void saveQIMEIToSDCard(String str) {
        Throwable th;
        File file = new File(Environment.getExternalStorageDirectory(), "tencent/beacon/meta.dat");
        FileOutputStream fileOutputStream = null;
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(h.a(str.getBytes(), 3, getLocalEncryptKey()));
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (FileNotFoundException unused2) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (IOException unused4) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused7) {
            if (fileOutputStream == null) {
            }
        } catch (IOException unused8) {
            if (fileOutputStream == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private static String getLocalEncryptKey() {
        byte[] bArr = {64, 38, 40, 42, 35, 72, 78, 75, 74, 103, 49, 50, 33, 64, 41};
        byte[] bArr2 = {27, 81, 19, 34, 88, 32};
        for (int i = 0; i < 15; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i % 6]);
        }
        for (int i2 = 0; i2 < 15; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % 6]);
        }
        return new String(bArr);
    }
}
