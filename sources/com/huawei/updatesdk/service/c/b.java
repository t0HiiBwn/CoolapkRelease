package com.huawei.updatesdk.service.c;

import com.huawei.updatesdk.service.c.c;
import com.huawei.updatesdk.service.e.a;
import java.io.Serializable;
import java.util.Comparator;

public class b implements Serializable, Comparator<b> {
    private int a;
    private c.a b = c.a.NOT_HANDLER;
    private boolean c = false;
    private String d;
    private String e;
    private c.b f = c.b.INSTALL;
    private int g = -1;

    protected b() {
    }

    protected b(String str, String str2) {
        b(str2);
        a(str);
    }

    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        return (!bVar.a() && bVar.b() > bVar2.b()) ? 1 : -1;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(c.a aVar) {
        this.b = (c.a) a.a(aVar);
    }

    public void a(c.b bVar) {
        this.f = bVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.c = z;
    }

    protected boolean a() {
        return b() == -1;
    }

    public int b() {
        return this.a;
    }

    public void b(int i) {
        this.g = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public c.b e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }
}
