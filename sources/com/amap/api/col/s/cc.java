package com.amap.api.col.s;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ConstConfig */
public final class cc {
    public static String a = "9aj&#k81";
    public static String b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";
    static byte[] c = null;
    public static boolean d = false;
    public static boolean e = false;
    public static final Integer f = 1;
    public static final Integer g = 2;
    public static final Integer h = 3;
    public static final Integer i = 4;
    public static final Integer j = 5;
    private static String k = "ADgAIwBbAA8AagAIAHIAEwCFAD8AxABDAQcAIQEoADgBYAA8AZwAnwI7APADKwAHAzIADAM+AA9LWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZ1FaMlYwVTJWeWRtbGpaUUljR2h2Ym1VVWFYQm9iMjVsYzNWaWFXNW1id01ZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5ra1UzUjFZZ1FZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWdHVkZKQlRsTkJRMVJKVDA1ZloyVjBSR1YyYVdObFNXUT1FWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua0lZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOEVJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSndhMmNpT2lJbGN5SXNJbTF2WkdWc0lqb2lKWE1pTENKaGNIQnVZVzFsSWpvaUpYTWlMQ0poY0hCMlpYSnphVzl1SWpvaUpYTWlMQ0p6ZVhOMlpYSnphVzl1SWpvaUpYTWlMQUdJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklnPUlZV2xrUFFNZkhObGNtbGhiRDBRWVc1a2NtOXBaRjlwWkE=";

    /* renamed from: l  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f1205l = new ConcurrentHashMap<>(8);

    public static byte[] a(int i2) {
        if (c == null) {
            c = bn.b(k);
        }
        byte[] bArr = new byte[4];
        System.arraycopy(c, i2 * 4, bArr, 0, 4);
        int i3 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i4 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(c, i3, bArr2, 0, i4);
        return bArr2;
    }

    public static void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                synchronized (f1205l) {
                    if (f1205l == null) {
                        f1205l = new ConcurrentHashMap<>(8);
                    }
                    if (!f1205l.containsKey(str)) {
                        f1205l.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f1205l) {
                if (f1205l != null && f1205l.containsKey(str)) {
                    str2 = f1205l.get(str);
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }
}
