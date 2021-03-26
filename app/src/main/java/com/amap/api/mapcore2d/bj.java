package com.amap.api.mapcore2d;

import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;

/* compiled from: ProtocalHandler */
abstract class bj<T, V> extends ew {
    protected boolean a;
    protected T b;
    private int f;
    private int g;

    protected abstract V a(byte[] bArr) throws AMapException;

    protected V d() {
        return null;
    }

    public bj(T t) {
        this();
        this.b = t;
    }

    public bj() {
        this.a = false;
        this.f = 1;
        this.g = 0;
        this.f = 1;
        this.g = 2;
    }

    public V a() throws AMapException {
        if (this.b != null) {
            return e();
        }
        return null;
    }

    protected byte[] b() throws AMapException {
        int i = 0;
        while (i < this.f) {
            try {
                return c();
            } catch (cp e) {
                i++;
                if (i < this.f) {
                    try {
                        Thread.sleep((long) (this.g * 1000));
                        cm.a(e, "ProtocalHandler", "getData");
                    } catch (InterruptedException unused) {
                        throw new AMapException(e.getMessage());
                    }
                } else {
                    throw new AMapException(e.a());
                }
            }
        }
        return null;
    }

    protected byte[] c() throws cp {
        int protocol = MapsInitializer.getProtocol();
        ev a2 = ev.a(false);
        if (protocol == 1) {
            if (this.a) {
                return a2.b(this);
            }
            return a2.d(this);
        } else if (protocol != 2) {
            return null;
        } else {
            if (this.a) {
                return a2.a(this);
            }
            return a2.e(this);
        }
    }

    private V e() throws AMapException {
        try {
            return b(b());
        } catch (AMapException e) {
            d();
            throw new AMapException(e.getErrorMessage());
        } catch (Throwable th) {
            cm.a(th, "ProtocalHandler", "GetDataMayThrow");
            return null;
        }
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }
}
