package com.tencent.msdk.dns.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.f.a;

/* compiled from: LookupParameters */
public final class l<LookupExtra extends f.a> {
    public final Context a;
    public final String b;
    public final int c;
    public final LookupExtra d;
    public final String e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final boolean m;

    private l(Context context, String str, int i2, LookupExtra lookupextra, String str2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4, int i5, boolean z5) {
        this.a = context;
        this.b = str;
        this.c = i2;
        this.d = lookupextra;
        this.e = str2;
        this.f = i3;
        this.g = z;
        this.h = z2;
        this.i = i4;
        this.j = z3;
        this.k = z4;
        this.l = i5;
        this.m = z5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.c == lVar.c && this.g == lVar.g && this.h == lVar.h && this.i == lVar.i && this.j == lVar.j && this.k == lVar.k && this.l == lVar.l && this.m == lVar.m && com.tencent.msdk.dns.base.e.a.a(this.a, lVar.a) && com.tencent.msdk.dns.base.e.a.a(this.b, lVar.b) && com.tencent.msdk.dns.base.e.a.a(this.d, lVar.d) && com.tencent.msdk.dns.base.e.a.a(this.e, lVar.e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return com.tencent.msdk.dns.base.e.a.b(this.a, this.b, Integer.valueOf(this.c), this.d, this.e, Boolean.valueOf(this.g), Boolean.valueOf(this.h), Integer.valueOf(this.i), Boolean.valueOf(this.j), Boolean.valueOf(this.k), Integer.valueOf(this.l), Boolean.valueOf(this.m));
    }

    public String toString() {
        return "LookupParameters{appContext=" + this.a + ", hostname='" + this.b + "', timeoutMills=" + this.c + ", lookupExtra=" + this.d + ", channel='" + this.e + "', token=" + this.f + ", fallback2Local=" + this.g + ", blockFirst=" + this.h + ", family=" + this.i + ", ignoreCurNetStack=" + this.j + ", enableAsyncLookup=" + this.k + ", curRetryTime=" + this.l + ", netChangeLookup=" + this.m + '}';
    }

    /* compiled from: LookupParameters */
    public static final class a<LookupExtra extends f.a> {
        private Context a;
        private String b;
        private int c = -1;
        private LookupExtra d;
        private String e;
        private int f;
        private boolean g = true;
        private boolean h = false;
        private int i = 3;
        private boolean j = false;
        private boolean k = false;
        private int l = 0;
        private boolean m = false;

        public a() {
        }

        public a(l<LookupExtra> lVar) {
            this.a = lVar.a;
            this.b = lVar.b;
            this.c = lVar.c;
            this.d = lVar.d;
            this.e = lVar.e;
            this.f = lVar.f;
            this.g = lVar.g;
            this.h = lVar.h;
            this.i = lVar.i;
            this.j = lVar.j;
            this.k = lVar.k;
            this.l = lVar.l;
            this.m = lVar.m;
        }

        public a<LookupExtra> a(Context context) {
            if (context != null) {
                this.a = context.getApplicationContext();
                return this;
            }
            throw new IllegalArgumentException("context".concat(" can not be null"));
        }

        public a<LookupExtra> a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("hostname".concat(" can not be empty"));
        }

        public a<LookupExtra> a(int i2) {
            if (i2 > 0) {
                this.c = i2;
                return this;
            }
            throw new IllegalArgumentException("timeoutMills".concat(" can not less than 0"));
        }

        public a<LookupExtra> a(LookupExtra lookupextra) {
            if (lookupextra != null) {
                this.d = lookupextra;
                return this;
            }
            throw new IllegalArgumentException("lookupExtra".concat(" can not be null"));
        }

        public a<LookupExtra> b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.e = str;
                return this;
            }
            throw new IllegalArgumentException("channel".concat(" can not be empty"));
        }

        public a<LookupExtra> b(int i2) {
            this.f = i2;
            return this;
        }

        public a<LookupExtra> a(boolean z) {
            this.g = z;
            return this;
        }

        public a<LookupExtra> b(boolean z) {
            this.h = z;
            return this;
        }

        public a<LookupExtra> c(int i2) {
            if (!c.a(i2)) {
                this.i = i2;
                return this;
            }
            throw new IllegalArgumentException("family".concat(" is invalid"));
        }

        public a<LookupExtra> c(boolean z) {
            this.j = z;
            return this;
        }

        public a<LookupExtra> d(boolean z) {
            this.k = z;
            return this;
        }

        public a<LookupExtra> d(int i2) {
            if (i2 >= 0) {
                this.l = i2;
                return this;
            }
            throw new IllegalArgumentException("curRetryTime".concat(" can not less than 0"));
        }

        public a<LookupExtra> e(boolean z) {
            this.m = z;
            return this;
        }

        public l<LookupExtra> a() {
            Context context = this.a;
            if (context != null) {
                String str = this.b;
                if (str != null) {
                    int i2 = this.c;
                    if (-1 != i2) {
                        LookupExtra lookupextra = this.d;
                        if (lookupextra != null) {
                            String str2 = this.e;
                            if (str2 != null) {
                                return new l<>(context, str, i2, lookupextra, str2, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
                            }
                            throw new IllegalStateException("channel".concat(" is not initialized yet"));
                        }
                        throw new IllegalStateException("mLookupExtra".concat(" is not initialized yet"));
                    }
                    throw new IllegalStateException("timeoutMills".concat(" is not initialized yet"));
                }
                throw new IllegalStateException("mHostname".concat(" is not initialized yet"));
            }
            throw new IllegalStateException("mAppContext".concat(" is not initialized yet"));
        }
    }
}
