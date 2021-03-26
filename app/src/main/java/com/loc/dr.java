package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;

/* compiled from: LocFilter */
public final class dr {
    ds a = null;
    long b = 0;
    long c = 0;
    int d = 0;
    long e = 0;
    AMapLocation f = null;
    long g = 0;
    private boolean h = true;

    private ds b(ds dsVar) {
        int i;
        if (ep.a(dsVar)) {
            if (!this.h || !ei.a(dsVar.getTime())) {
                i = this.d;
            } else if (dsVar.getLocationType() == 5 || dsVar.getLocationType() == 6) {
                i = 4;
            }
            dsVar.setLocationType(i);
        }
        return dsVar;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (!ep.a(aMapLocation)) {
            return aMapLocation;
        }
        long b2 = ep.b() - this.g;
        this.g = ep.b();
        if (b2 > 5000) {
            return aMapLocation;
        }
        AMapLocation aMapLocation2 = this.f;
        if (aMapLocation2 == null) {
            this.f = aMapLocation;
            return aMapLocation;
        } else if (1 != aMapLocation2.getLocationType() && !"gps".equalsIgnoreCase(this.f.getProvider())) {
            this.f = aMapLocation;
            return aMapLocation;
        } else if (this.f.getAltitude() == aMapLocation.getAltitude() && this.f.getLongitude() == aMapLocation.getLongitude()) {
            this.f = aMapLocation;
            return aMapLocation;
        } else {
            long abs = Math.abs(aMapLocation.getTime() - this.f.getTime());
            if (30000 < abs) {
                this.f = aMapLocation;
                return aMapLocation;
            } else if (ep.a(aMapLocation, this.f) > (((this.f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                return this.f;
            } else {
                this.f = aMapLocation;
                return aMapLocation;
            }
        }
    }

    public final ds a(ds dsVar) {
        if (ep.b() - this.e > 30000) {
            this.a = dsVar;
            this.e = ep.b();
            return this.a;
        }
        this.e = ep.b();
        if (!ep.a(this.a) || !ep.a(dsVar)) {
            this.b = ep.b();
            this.a = dsVar;
            return dsVar;
        } else if (dsVar.getTime() == this.a.getTime() && dsVar.getAccuracy() < 300.0f) {
            return dsVar;
        } else {
            if (dsVar.getProvider().equals("gps")) {
                this.b = ep.b();
                this.a = dsVar;
                return dsVar;
            } else if (dsVar.c() != this.a.c()) {
                this.b = ep.b();
                this.a = dsVar;
                return dsVar;
            } else if (dsVar.getBuildingId().equals(this.a.getBuildingId()) || TextUtils.isEmpty(dsVar.getBuildingId())) {
                this.d = dsVar.getLocationType();
                float a2 = ep.a(dsVar, this.a);
                float accuracy = this.a.getAccuracy();
                float accuracy2 = dsVar.getAccuracy();
                float f2 = accuracy2 - accuracy;
                long b2 = ep.b();
                long j = b2 - this.b;
                boolean z = true;
                boolean z2 = accuracy <= 100.0f && accuracy2 > 299.0f;
                int i = (accuracy > 299.0f ? 1 : (accuracy == 299.0f ? 0 : -1));
                if (i <= 0 || accuracy2 <= 299.0f) {
                    z = false;
                }
                if (z2 || z) {
                    long j2 = this.c;
                    if (j2 == 0) {
                        this.c = b2;
                    } else if (b2 - j2 > 30000) {
                        this.b = b2;
                        this.a = dsVar;
                        this.c = 0;
                        return dsVar;
                    }
                    ds b3 = b(this.a);
                    this.a = b3;
                    return b3;
                } else if (accuracy2 >= 100.0f || i <= 0) {
                    if (accuracy2 <= 299.0f) {
                        this.c = 0;
                    }
                    if (a2 >= 10.0f || ((double) a2) <= 0.1d || accuracy2 <= 5.0f) {
                        if (f2 < 300.0f) {
                            this.b = ep.b();
                            this.a = dsVar;
                            return dsVar;
                        } else if (j >= 30000) {
                            this.b = ep.b();
                            this.a = dsVar;
                            return dsVar;
                        } else {
                            ds b4 = b(this.a);
                            this.a = b4;
                            return b4;
                        }
                    } else if (f2 >= -300.0f) {
                        ds b5 = b(this.a);
                        this.a = b5;
                        return b5;
                    } else if (accuracy / accuracy2 >= 2.0f) {
                        this.b = b2;
                        this.a = dsVar;
                        return dsVar;
                    } else {
                        ds b6 = b(this.a);
                        this.a = b6;
                        return b6;
                    }
                } else {
                    this.b = b2;
                    this.a = dsVar;
                    this.c = 0;
                    return dsVar;
                }
            } else {
                this.b = ep.b();
                this.a = dsVar;
                return dsVar;
            }
        }
    }

    public final void a() {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.f = null;
        this.g = 0;
    }

    public final void a(boolean z) {
        this.h = z;
    }
}
