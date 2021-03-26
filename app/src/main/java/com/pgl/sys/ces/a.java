package com.pgl.sys.ces;

import android.content.Context;

public final class a {
    static {
        try {
            System.loadLibrary("nms");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static native Object meta(int i, Context context, Object obj);

    public static Object njss(int i, Object obj) {
        try {
            return b.a().a(i, obj);
        } catch (Throwable unused) {
            return null;
        }
    }
}
