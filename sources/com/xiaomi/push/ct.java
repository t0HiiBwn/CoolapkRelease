package com.xiaomi.push;

import android.content.Context;
import java.util.List;

public abstract class ct {
    private int a;

    public ct(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public abstract String a(Context context, String str, List<bb> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m195a(Context context, String str, List<bb> list) {
        return true;
    }
}
