package com.xiaomi.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.al;

public class a {
    private String a;
    private boolean b;
    private boolean c;
    private boolean d;
    private long e;
    private long f;
    private long g;

    /* renamed from: com.xiaomi.b.a.a$a  reason: collision with other inner class name */
    public static class C0183a {
        private int a = -1;
        private int b = -1;
        private int c = -1;
        private String d = null;
        private long e = -1;
        private long f = -1;
        private long g = -1;

        public C0183a a(long j) {
            this.e = j;
            return this;
        }

        public C0183a a(String str) {
            this.d = str;
            return this;
        }

        public C0183a a(boolean z) {
            this.a = z ? 1 : 0;
            return this;
        }

        public a a(Context context) {
            return new a(context, this);
        }

        public C0183a b(long j) {
            this.f = j;
            return this;
        }

        public C0183a b(boolean z) {
            this.b = z ? 1 : 0;
            return this;
        }

        public C0183a c(long j) {
            this.g = j;
            return this;
        }

        public C0183a c(boolean z) {
            this.c = z ? 1 : 0;
            return this;
        }
    }

    private a() {
        this.b = true;
        this.c = false;
        this.d = false;
        this.e = 1048576;
        this.f = 86400;
        this.g = 86400;
    }

    private a(Context context, C0183a aVar) {
        this.b = true;
        this.c = false;
        this.d = false;
        long j = 1048576;
        this.e = 1048576;
        this.f = 86400;
        this.g = 86400;
        if (aVar.a == 0) {
            this.b = false;
        } else {
            int i = aVar.a;
            this.b = true;
        }
        this.a = !TextUtils.isEmpty(aVar.d) ? aVar.d : al.a(context);
        this.e = aVar.e > -1 ? aVar.e : j;
        if (aVar.f > -1) {
            this.f = aVar.f;
        } else {
            this.f = 86400;
        }
        if (aVar.g > -1) {
            this.g = aVar.g;
        } else {
            this.g = 86400;
        }
        if (aVar.b != 0 && aVar.b == 1) {
            this.c = true;
        } else {
            this.c = false;
        }
        if (aVar.c != 0 && aVar.c == 1) {
            this.d = true;
        } else {
            this.d = false;
        }
    }

    public static C0183a a() {
        return new C0183a();
    }

    public static a a(Context context) {
        return a().a(true).a(al.a(context)).a(1048576).b(false).b(86400).c(false).c(86400).a(context);
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public long f() {
        return this.f;
    }

    public long g() {
        return this.g;
    }

    public String toString() {
        return "Config{mEventEncrypted=" + this.b + ", mAESKey='" + this.a + "', mMaxFileLength=" + this.e + ", mEventUploadSwitchOpen=" + this.c + ", mPerfUploadSwitchOpen=" + this.d + ", mEventUploadFrequency=" + this.f + ", mPerfUploadFrequency=" + this.g + '}';
    }
}
