package com.alibaba.baichuan.android.trade.miniapp;

import com.alibaba.baichuan.android.trade.b;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;

public class a {
    private static a a;
    private AlibcBasePage b;
    private b c;
    private int d;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a(AlibcBasePage alibcBasePage) {
        this.b = alibcBasePage;
    }

    public AlibcBasePage b() {
        return this.b;
    }

    public b c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }
}
