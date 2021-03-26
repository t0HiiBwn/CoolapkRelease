package com.alibaba.wireless.security.open.avmpTest;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.avmp.IAVMPGenericComponent;

public class AVMPUTTest {
    public static final String TAG = "AVMPUTTest_T";
    private static IAVMPGenericComponent a;
    private static IAVMPGenericComponent.IAVMPGenericInstance b;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012a  */
    private static synchronized void a(Context context) {
        Throwable th;
        boolean z;
        synchronized (AVMPUTTest.class) {
            int i = 0;
            int isForeground = isForeground(context);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = true;
            try {
                if (b != null) {
                    a("AVMP instance has been initialized");
                } else {
                    IAVMPGenericComponent iAVMPGenericComponent = (IAVMPGenericComponent) SecurityGuardManager.getInstance(context).getInterface(IAVMPGenericComponent.class);
                    a = iAVMPGenericComponent;
                    if (iAVMPGenericComponent != null) {
                        IAVMPGenericComponent iAVMPGenericComponent2 = (IAVMPGenericComponent) SecurityGuardManager.getInstance(context).getInterface(IAVMPGenericComponent.class);
                        a = iAVMPGenericComponent2;
                        b = iAVMPGenericComponent2.createAVMPInstance("mwua", "sgcipher");
                        z = true;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        int isForeground2 = isForeground(context);
                        if (b == null) {
                            z2 = false;
                        }
                        String valueOf = String.valueOf(z);
                        String valueOf2 = String.valueOf(z2);
                        UserTrackMethodJniBridge.addUtRecord("100086", 0, 1, "", currentTimeMillis2, "", valueOf, valueOf2, "" + isForeground + "" + isForeground2, "");
                    }
                }
                z = false;
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                int isForeground2 = isForeground(context);
                if (b == null) {
                }
                String valueOf = String.valueOf(z);
                String valueOf2 = String.valueOf(z2);
                UserTrackMethodJniBridge.addUtRecord("100086", 0, 1, "", currentTimeMillis2, "", valueOf, valueOf2, "" + isForeground + "" + isForeground2, "");
            } catch (SecException e) {
                int errorCode = e.getErrorCode();
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                int isForeground3 = isForeground(context);
                if (b == null) {
                    z2 = false;
                }
                String valueOf3 = String.valueOf(false);
                String valueOf4 = String.valueOf(z2);
                UserTrackMethodJniBridge.addUtRecord("100086", errorCode, 1, "", currentTimeMillis3, "", valueOf3, valueOf4, "" + isForeground + "" + isForeground3, "");
            } catch (Exception e2) {
                String message = e2.getMessage();
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                int isForeground4 = isForeground(context);
                if (b == null) {
                    z2 = false;
                }
                String valueOf5 = String.valueOf(false);
                String valueOf6 = String.valueOf(z2);
                UserTrackMethodJniBridge.addUtRecord("100086", 1999, 1, "", currentTimeMillis4, message, valueOf5, valueOf6, "" + isForeground + "" + isForeground4, "");
            } catch (Throwable th2) {
                th = th2;
                long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                int isForeground5 = isForeground(context);
                if (b == null) {
                }
                String valueOf7 = String.valueOf(false);
                String valueOf8 = String.valueOf(z2);
                UserTrackMethodJniBridge.addUtRecord("100086", i, 1, "", currentTimeMillis5, "", valueOf7, valueOf8, "" + isForeground + "" + isForeground5, "");
                throw th;
            }
        }
    }

    private static void a(String str) {
        Log.d("AVMPUTTest", str);
    }

    public static byte[] avmpSign(IAVMPGenericComponent.IAVMPGenericInstance iAVMPGenericInstance, byte[] bArr, String str, int i) throws Exception {
        if (iAVMPGenericInstance == null) {
            return null;
        }
        return (byte[]) iAVMPGenericInstance.invokeAVMP("sign", new byte[0].getClass(), Integer.valueOf(i), str.getBytes(), Integer.valueOf(str.getBytes().length), null, bArr, 0);
    }

    public static byte[] avmpSign2(IAVMPGenericComponent.IAVMPGenericInstance iAVMPGenericInstance, String str, String str2) throws Exception {
        if (iAVMPGenericInstance == null) {
            return null;
        }
        return (byte[]) iAVMPGenericInstance.invokeAVMP2("sign_v2", new byte[0].getClass(), str2, str, 0);
    }

    public static void avmpTest(Context context, String str) {
        a("enter avmpTest");
        Context applicationContext = context.getApplicationContext();
        runAVMPSignSchedule(applicationContext, str + "|startLVMTrack");
    }

    public static int isForeground(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (Build.VERSION.SDK_INT < 21) {
                return activityManager.getRunningTasks(1).get(0).topActivity.getPackageName().equals(context.getPackageName()) ? 1 : 0;
            }
            int i = 0;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.importance == 100) {
                        for (String str : runningAppProcessInfo.pkgList) {
                            if (str.equals(context.getPackageName())) {
                                i = 1;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return i;
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void mySleep(long j) {
        try {
            Thread.sleep(j);
        } catch (Exception unused) {
        }
    }

    public static void runAVMPSignSchedule(Context context, String str) {
        for (int i = 0; i < 15; i++) {
            a("enter runAVMPSignSchedule");
            runAVMPSignSchedule1(context, str, "ib00000010b4732dc6645e87a20900b653a94ef27d72696f99", "ib0001002026f1091f2042df0cae1af323ac6e80a661d4a169");
        }
    }

    public static synchronized void runAVMPSignSchedule1(Context context, String str, String str2, String str3) {
        int i;
        boolean z;
        Throwable th;
        int i2;
        int i3;
        Throwable th2;
        int i4;
        int i5;
        long currentTimeMillis;
        int i6;
        String str4;
        int i7;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i8;
        boolean z2;
        int i9;
        boolean z3;
        int i10;
        boolean z4;
        int i11;
        synchronized (AVMPUTTest.class) {
            a(context);
            mySleep(3000);
            int isForeground = isForeground(context);
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                byte[] avmpSign = avmpSign(b, new byte[4], "ib00000010b4732dc6645e87a20900b653a94ef27d72696f99", 0);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                int isForeground2 = isForeground(context);
                try {
                    i11 = new String(avmpSign).length();
                    z4 = true;
                } catch (Exception unused) {
                    i11 = 0;
                    z4 = false;
                }
                a("enter test1: isForeground1=" + isForeground + " isForeground11=" + isForeground2 + " msg callRes1" + z4 + " signLength=" + i11 + " duration=" + currentTimeMillis3);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(isForeground);
                sb.append("");
                sb.append(isForeground2);
                sb.append("&");
                sb.append("");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(String.valueOf(z4));
                z = false;
                UserTrackMethodJniBridge.addUtRecord("100087", 0, 1, "", currentTimeMillis3, sb2, "1", sb3.toString(), "" + i11, "");
            } catch (SecException e) {
                z = false;
                int errorCode = e.getErrorCode();
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                int isForeground3 = isForeground(context);
                try {
                    i9 = new String((byte[]) null).length();
                    z2 = true;
                } catch (Exception unused2) {
                    i9 = 0;
                    z2 = false;
                }
                a("enter test1: isForeground1=" + isForeground + " isForeground11=" + isForeground3 + " msg callRes1" + z2 + " signLength=" + i9 + " duration=" + currentTimeMillis4);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(isForeground);
                sb4.append("");
                sb4.append(isForeground3);
                sb4.append("&");
                sb4.append("");
                String sb5 = sb4.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(String.valueOf(z2));
                UserTrackMethodJniBridge.addUtRecord("100087", errorCode, 1, "", currentTimeMillis4, sb5, "1", sb6.toString(), "" + i9, "");
            } catch (Exception e2) {
                z = false;
                String message = e2.getMessage();
                long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis2;
                int isForeground4 = isForeground(context);
                try {
                    i10 = new String((byte[]) null).length();
                    z3 = true;
                } catch (Exception unused3) {
                    i10 = 0;
                    z3 = false;
                }
                a("enter test1: isForeground1=" + isForeground + " isForeground11=" + isForeground4 + " msg" + message + " callRes1" + z3 + " signLength=" + i10 + " duration=" + currentTimeMillis5);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                sb7.append(isForeground);
                sb7.append("");
                sb7.append(isForeground4);
                sb7.append("&");
                sb7.append(message);
                String sb8 = sb7.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append("");
                sb9.append(String.valueOf(z3));
                UserTrackMethodJniBridge.addUtRecord("100087", 1999, 1, "", currentTimeMillis5, sb8, "1", sb9.toString(), "" + i10, "");
            } catch (Throwable th3) {
                th = th3;
                i = 0;
                long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis2;
                int isForeground5 = isForeground(context);
                i2 = new String((byte[]) null).length();
                z = true;
                a("enter test1: isForeground1=" + isForeground + " isForeground11=" + isForeground5 + " msg callRes1" + z + " signLength=" + i2 + " duration=" + currentTimeMillis6);
                StringBuilder sb10 = new StringBuilder();
                sb10.append("");
                sb10.append(isForeground);
                sb10.append("");
                sb10.append(isForeground5);
                sb10.append("&");
                sb10.append("");
                String sb11 = sb10.toString();
                StringBuilder sb12 = new StringBuilder();
                sb12.append("");
                sb12.append(String.valueOf(z));
                UserTrackMethodJniBridge.addUtRecord("100087", i, 1, "", currentTimeMillis6, sb11, "1", sb12.toString(), "" + i2, "");
                throw th;
            }
            mySleep(3000);
            int i12 = 0;
            int isForeground6 = isForeground(context);
            long currentTimeMillis7 = System.currentTimeMillis();
            try {
                byte[] avmpSign2 = avmpSign2(b, "ib00000010b4732dc6645e87a20900b653a94ef27d72696f99", "vs_config_0");
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis7;
                int isForeground7 = isForeground(context);
                try {
                    i8 = new String(avmpSign2).length();
                    z = true;
                } catch (Exception unused4) {
                    i8 = 0;
                }
                a("enter test2: isForeground1=" + isForeground6 + " isForeground11=" + isForeground7 + " msg callRes1" + z + " signLength=" + i8 + " dration=" + currentTimeMillis);
                str4 = "100087";
                i7 = 1;
                str5 = "";
                str6 = "" + isForeground6 + "" + isForeground7 + "&";
                str7 = "3";
                str8 = "" + String.valueOf(z);
                str9 = "" + i8;
                str10 = "";
            } catch (SecException e3) {
                int errorCode2 = e3.getErrorCode();
                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis7;
                int isForeground8 = isForeground(context);
                try {
                    i5 = new String((byte[]) null).length();
                    z = true;
                } catch (Exception unused5) {
                    i5 = 0;
                }
                a("enter test2: isForeground1=" + isForeground6 + " isForeground11=" + isForeground8 + " msg callRes1" + z + " signLength=" + i5 + " dration=" + currentTimeMillis8);
                StringBuilder sb13 = new StringBuilder();
                sb13.append("");
                sb13.append(isForeground6);
                sb13.append("");
                sb13.append(isForeground8);
                sb13.append("&");
                sb13.append("");
                String sb14 = sb13.toString();
                StringBuilder sb15 = new StringBuilder();
                sb15.append("");
                sb15.append(String.valueOf(z));
                UserTrackMethodJniBridge.addUtRecord("100087", errorCode2, 1, "", currentTimeMillis8, sb14, "3", sb15.toString(), "" + i5, "");
            } catch (Exception e4) {
                i12 = 1999;
                String message2 = e4.getMessage();
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis7;
                int isForeground9 = isForeground(context);
                try {
                    i6 = new String((byte[]) null).length();
                    z = true;
                } catch (Exception unused6) {
                    i6 = 0;
                }
                a("enter test2: isForeground1=" + isForeground6 + " isForeground11=" + isForeground9 + " msg" + message2 + " callRes1" + z + " signLength=" + i6 + " dration=" + currentTimeMillis);
                str4 = "100087";
                i7 = 1;
                str5 = "";
                str6 = "" + isForeground6 + "" + isForeground9 + "&" + message2;
                str7 = "3";
                str8 = "" + String.valueOf(z);
                str9 = "" + i6;
                str10 = "";
            } catch (Throwable th4) {
                th2 = th4;
                i3 = 0;
                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis7;
                int isForeground10 = isForeground(context);
                i4 = new String((byte[]) null).length();
                z = true;
                a("enter test2: isForeground1=" + isForeground6 + " isForeground11=" + isForeground10 + " msg callRes1" + z + " signLength=" + i4 + " dration=" + currentTimeMillis9);
                StringBuilder sb16 = new StringBuilder();
                sb16.append("");
                sb16.append(isForeground6);
                sb16.append("");
                sb16.append(isForeground10);
                sb16.append("&");
                sb16.append("");
                String sb17 = sb16.toString();
                StringBuilder sb18 = new StringBuilder();
                sb18.append("");
                sb18.append(String.valueOf(z));
                UserTrackMethodJniBridge.addUtRecord("100087", i3, 1, "", currentTimeMillis9, sb17, "3", sb18.toString(), "" + i4, "");
                throw th2;
            }
            UserTrackMethodJniBridge.addUtRecord(str4, i12, i7, str5, currentTimeMillis, str6, str7, str8, str9, str10);
        }
    }
}
