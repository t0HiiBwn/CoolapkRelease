package com.amap.api.mapcore2d;

import android.os.RemoteException;
import com.amap.api.interfaces.IAMap;

/* compiled from: IAMapDelegate */
public interface y extends IAMap {
    az a();

    void a(double d, double d2, ae aeVar);

    void a(double d, double d2, s sVar);

    void a(int i, int i2);

    void a(int i, int i2, s sVar);

    void b(double d, double d2, ae aeVar);

    void b(int i, int i2, s sVar);

    bh d() throws RemoteException;

    void postInvalidate();
}
