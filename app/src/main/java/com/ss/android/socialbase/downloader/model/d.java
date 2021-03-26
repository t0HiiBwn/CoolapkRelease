package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;

/* compiled from: HttpResponse */
public class d {
    public final String a;
    public final g b;
    public final int c;
    private long d;
    private long e;

    public d(String str, g gVar) throws IOException {
        this.a = str;
        this.c = gVar.b();
        this.b = gVar;
    }

    public boolean a() {
        return e.c(this.c);
    }

    public boolean b() {
        return e.a(this.c, this.b.a("Accept-Ranges"));
    }

    public String c() {
        return this.b.a("Etag");
    }

    public String d() {
        return this.b.a("Content-Type");
    }

    public String e() {
        return this.b.a("Content-Range");
    }

    public String f() {
        String b2 = e.b(this.b, "last-modified");
        return TextUtils.isEmpty(b2) ? e.b(this.b, "Last-Modified") : b2;
    }

    public String g() {
        return e.b(this.b, "Cache-Control");
    }

    public long h() {
        if (this.d <= 0) {
            this.d = e.a(this.b);
        }
        return this.d;
    }

    public boolean i() {
        if (a.a(8)) {
            return e.c(this.b);
        }
        return e.b(h());
    }

    public long j() {
        if (this.e <= 0) {
            if (!i()) {
                String a2 = this.b.a("Content-Range");
                if (!TextUtils.isEmpty(a2)) {
                    this.e = e.b(a2);
                }
            } else {
                this.e = -1;
            }
        }
        return this.e;
    }

    public long k() {
        return e.h(g());
    }
}
