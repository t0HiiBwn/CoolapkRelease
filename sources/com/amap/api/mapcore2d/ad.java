package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;

/* compiled from: IOverlayDelegate */
interface ad extends IOverlay {
    void a(Canvas canvas) throws RemoteException;

    boolean a();
}
