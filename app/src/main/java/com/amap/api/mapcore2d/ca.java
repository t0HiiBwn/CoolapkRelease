package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

/* compiled from: UiSettingsDelegateImp */
class ca implements al {
    private y a;
    private boolean b = true;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = true;
    private boolean g = false;
    private int h = 0;
    private int i = 0;
    private final Handler j = new Handler() {
        /* class com.amap.api.mapcore2d.ca.AnonymousClass1 */

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && ca.this.a != null) {
                try {
                    int i = message.what;
                    if (i == 0) {
                        ca.this.a.showZoomControlsEnabled(ca.this.e);
                    } else if (i == 1) {
                        ca.this.a.showScaleEnabled(ca.this.g);
                    } else if (i == 2) {
                        ca.this.a.showCompassEnabled(ca.this.f);
                    } else if (i == 3) {
                        ca.this.a.showMyLocationButtonEnabled(ca.this.c);
                    }
                } catch (Throwable th) {
                    cm.a(th, "UiSettingsDelegateImp", "handle_handleMessage");
                }
            }
        }
    };
    private boolean k;

    ca(y yVar) {
        this.a = yVar;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setScaleControlsEnabled(boolean z) throws RemoteException {
        this.g = z;
        this.j.obtainMessage(1).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setZoomControlsEnabled(boolean z) throws RemoteException {
        this.e = z;
        this.j.obtainMessage(0).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setCompassEnabled(boolean z) throws RemoteException {
        this.f = z;
        this.j.obtainMessage(2).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        this.c = z;
        this.j.obtainMessage(3).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setScrollGesturesEnabled(boolean z) throws RemoteException {
        this.b = z;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setZoomGesturesEnabled(boolean z) throws RemoteException {
        this.d = z;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setAllGesturesEnabled(boolean z) throws RemoteException {
        setZoomGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setLogoPosition(int i2) throws RemoteException {
        this.h = i2;
        this.a.setLogoPosition(i2);
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setZoomPosition(int i2) throws RemoteException {
        this.i = i2;
        this.a.setZoomPosition(i2);
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public boolean isScaleControlsEnabled() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public boolean isZoomControlsEnabled() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public boolean isCompassEnabled() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public boolean isScrollGesturesEnabled() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public boolean isZoomGesturesEnabled() throws RemoteException {
        return this.d;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public int getLogoPosition() throws RemoteException {
        return this.h;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public int getZoomPosition() throws RemoteException {
        return this.i;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setZoomInByScreenCenter(boolean z) {
        this.k = z;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public boolean isZoomInByScreenCenter() {
        return this.k;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public void setLogoCenter(int i2, int i3) {
        y yVar = this.a;
        if (yVar != null) {
            yVar.a(i2, i3);
        }
    }
}
