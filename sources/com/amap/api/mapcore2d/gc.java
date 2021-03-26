package com.amap.api.mapcore2d;

import android.text.TextUtils;

/* compiled from: MapLocFilter */
public final class gc {
    private static gc b;
    long a = 0;
    private gg c = null;
    private long d = 0;
    private long e = 0;

    private gc() {
    }

    public static synchronized gc a() {
        gc gcVar;
        synchronized (gc.class) {
            if (b == null) {
                b = new gc();
            }
            gcVar = b;
        }
        return gcVar;
    }

    public static gg b(gg ggVar) {
        return ggVar;
    }

    public final gg a(gg ggVar) {
        int i;
        if (gy.b() - this.a > 30000) {
            this.c = ggVar;
            this.a = gy.b();
            return this.c;
        }
        this.a = gy.b();
        if (!gk.a(this.c) || !gk.a(ggVar)) {
            this.d = gy.b();
            this.c = ggVar;
            return ggVar;
        } else if (ggVar.getTime() == this.c.getTime() && ggVar.getAccuracy() < 300.0f) {
            return ggVar;
        } else {
            if (ggVar.getProvider().equalsIgnoreCase("gps")) {
                this.d = gy.b();
                this.c = ggVar;
                return ggVar;
            } else if (ggVar.c() != this.c.c()) {
                this.d = gy.b();
                this.c = ggVar;
                return ggVar;
            } else if (ggVar.getBuildingId().equals(this.c.getBuildingId()) || TextUtils.isEmpty(ggVar.getBuildingId())) {
                float a2 = gy.a(new double[]{ggVar.getLatitude(), ggVar.getLongitude(), this.c.getLatitude(), this.c.getLongitude()});
                float accuracy = this.c.getAccuracy();
                float accuracy2 = ggVar.getAccuracy();
                float f = accuracy2 - accuracy;
                long b2 = gy.b();
                long j = b2 - this.d;
                if ((accuracy < 101.0f && accuracy2 > 299.0f) || (accuracy > 299.0f && accuracy2 > 299.0f)) {
                    long j2 = this.e;
                    if (j2 == 0) {
                        this.e = b2;
                    } else if (b2 - j2 > 30000) {
                        this.d = b2;
                        this.c = ggVar;
                        this.e = 0;
                        return ggVar;
                    }
                    return this.c;
                } else if (accuracy2 >= 101.0f || i <= 0) {
                    if (accuracy2 <= 299.0f) {
                        this.e = 0;
                    }
                    if (a2 >= 10.0f || ((double) a2) <= 0.1d || accuracy2 <= 5.0f) {
                        if (f < 300.0f) {
                            this.d = gy.b();
                            this.c = ggVar;
                            return ggVar;
                        } else if (j < 30000) {
                            return this.c;
                        } else {
                            this.d = gy.b();
                            this.c = ggVar;
                            return ggVar;
                        }
                    } else if (f >= -300.0f) {
                        return this.c;
                    } else {
                        if (accuracy / accuracy2 < 2.0f) {
                            return this.c;
                        }
                        this.d = b2;
                        this.c = ggVar;
                        return ggVar;
                    }
                } else {
                    this.d = b2;
                    this.c = ggVar;
                    this.e = 0;
                    return ggVar;
                }
            } else {
                this.d = gy.b();
                this.c = ggVar;
                return ggVar;
            }
        }
    }
}
