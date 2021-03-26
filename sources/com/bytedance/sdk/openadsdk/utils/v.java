package com.bytedance.sdk.openadsdk.utils;

import android.os.StatFs;
import android.text.TextUtils;

/* compiled from: MemorySize */
public class v {
    public static long a(String str) {
        StringBuilder sb;
        long j = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                StatFs statFs = new StatFs(str);
                j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            sb = new StringBuilder();
        } catch (Throwable unused) {
            sb = new StringBuilder();
        }
        sb.append("getAvailableSize=");
        sb.append(j);
        sb.append(", ");
        sb.append(String.valueOf(str));
        u.b("MemorySize", sb.toString());
        return j;
    }
}
