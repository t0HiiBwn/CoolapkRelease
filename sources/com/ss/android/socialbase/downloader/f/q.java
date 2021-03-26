package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: UrlRecord */
class q {
    final String a;
    final String b;
    final String c;
    final boolean d;
    private final List<m> e = new ArrayList();
    private int f;
    private boolean g;
    private int h;
    private String i;
    private final AtomicLong j = new AtomicLong();

    public q(String str, boolean z) {
        this.a = str;
        this.d = z;
        this.b = null;
        this.c = null;
    }

    public q(String str, String str2) {
        this.a = str;
        this.d = false;
        this.b = str2;
        this.c = a(str2);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized void a(m mVar) {
        this.e.add(mVar);
    }

    public synchronized void b(m mVar) {
        try {
            this.e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized int a() {
        return this.e.size();
    }

    public synchronized void b() {
        this.f++;
        this.g = true;
    }

    public synchronized void c() {
        this.g = false;
    }

    public synchronized boolean d() {
        return this.g;
    }

    public void a(long j2) {
        this.j.addAndGet(j2);
    }

    public int hashCode() {
        if (this.h == 0) {
            this.h = e().hashCode();
        }
        return this.h;
    }

    private String e() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return e().equals(((q) obj).e());
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + "', ip='" + this.b + "', ipFamily='" + this.c + "', isMainUrl=" + this.d + ", failedTimes=" + this.f + ", isCurrentFailed=" + this.g + '}';
    }
}
