package com.tencent.android.tpush.service.channel;

import android.util.SparseArray;

/* compiled from: ProGuard */
public class a {
    private static a a = new a();
    private SparseArray<Object> b = new SparseArray<>();

    public a() {
    }

    public a(Object... objArr) {
        for (int i = 0; i < objArr.length; i += 2) {
            this.b.put(((Integer) objArr[i]).intValue(), objArr[i + 1]);
        }
    }

    public boolean a() {
        return ((Boolean) this.b.get(2, false)).booleanValue();
    }

    public String b() {
        return (String) this.b.get(0, "");
    }

    public int c() {
        return ((Integer) this.b.get(1, 0)).intValue();
    }
}
