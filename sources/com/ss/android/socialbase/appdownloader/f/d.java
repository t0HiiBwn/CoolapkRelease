package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.ss.android.socialbase.downloader.i.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* compiled from: SecurityUtils */
public class d {
    private static Boolean a;

    public static boolean a() {
        Boolean bool = a;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            if (a == null) {
                a = Boolean.valueOf(!b() && !b(context) && !c(context) && d(context) && !c() && !e(context));
            }
        }
    }

    public static boolean b() {
        if (d() == 0) {
            return true;
        }
        return e();
    }

    public static boolean b(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int d() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, a("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        if (str != null && "0".equals(str)) {
            return 0;
        }
        return 1;
    }

    private static boolean e() {
        String[] strArr = {a("2f7362696e2f7375"), a("2f73797374656d2f62696e2f7375"), a("2f73797374656d2f7862696e2f7375"), a("2f646174612f6c6f63616c2f7862696e2f7375"), a("2f646174612f6c6f63616c2f62696e2f7375"), a("2f73797374656d2f73642f7862696e2f7375"), a("2f73797374656d2f62696e2f6661696c736166652f7375"), a("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2) {
            return true;
        }
        return false;
    }

    public static boolean d(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        return (simState == 1 || simState == 0) ? false : true;
    }

    public static boolean c() {
        try {
            InetAddress.getByName("127.0.0.1");
            new Socket("127.0.0.1", Integer.parseInt(a("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        return f() || f(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005c A[Catch:{ Exception -> 0x0089 }] */
    private static boolean f() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(a("636f6d2e73617572696b2e737562737472617465")) || str.contains(a("58706f7365644272696467652e6a6172")) || str.contains(a("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean f(Context context) {
        List<String> asList = Arrays.asList(a("64652e726f62762e616e64726f69642e78706f736564"), a("636f6d2e746f706a6f686e77752e6d616769736b"), a("696f2e76612e6578706f736564"), a("636f6d2e77696e642e636f74746572"), a("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), a("6d652e7765697368752e657870"), a("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        for (String str : asList) {
            try {
                if (packageManager.getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static String a(String str) {
        return e.a(str);
    }
}
