package com.tencent.msdk.dns.base.log;

import android.os.Build;
import android.util.Log;

/* compiled from: AndroidLogNode */
public final class a implements ILogNode {
    @Override // com.tencent.msdk.dns.base.log.ILogNode
    public void println(int i, String str, String str2, Throwable th) {
        if (i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
            a(i, str, str2, th);
        }
    }

    private void a(int i, String str, String str2, Throwable th) {
        int min;
        String a = a(str);
        if (str2 == null) {
            str2 = "";
        }
        if (th != null) {
            str2 = str2 + "\n" + Log.getStackTraceString(th);
        }
        if (4000 >= str2.length()) {
            Log.println(i, a, str2);
            return;
        }
        int i2 = 0;
        int length = str2.length();
        while (i2 < length) {
            int indexOf = str2.indexOf(10, i2);
            if (-1 == indexOf) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i2 + 4000);
                Log.println(i, a, str2.substring(i2, min));
                if (min >= indexOf) {
                    break;
                }
                i2 = min;
            }
            i2 = min + 1;
        }
    }

    private String a(String str) {
        if (str == null) {
            str = "";
        }
        return (23 >= str.length() || 24 <= Build.VERSION.SDK_INT) ? str : str.substring(0, 23);
    }
}
