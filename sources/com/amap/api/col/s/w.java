package com.amap.api.col.s;

import android.content.Context;

/* compiled from: PoiHandler */
abstract class w<T, V> extends b<T, V> {
    public w(Context context, T t) {
        super(context, t);
    }

    protected static boolean c(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
