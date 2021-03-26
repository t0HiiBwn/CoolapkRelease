package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.amap.api.interfaces.ITileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;

/* compiled from: TileOverlayDelegateImp */
public class bt implements ak {
    private static int a;
    private bu b;
    private an c;
    private boolean d;
    private String e;
    private float f;

    @Override // com.amap.api.mapcore2d.ak
    public void a(boolean z) {
    }

    public bt(TileOverlayOptions tileOverlayOptions, bu buVar, av avVar, az azVar, Context context) {
        this.b = buVar;
        an anVar = new an(avVar);
        this.c = anVar;
        anVar.e = false;
        this.c.g = false;
        this.c.f = tileOverlayOptions.getDiskCacheEnabled();
        this.c.p = new bn<>();
        this.c.k = tileOverlayOptions.getTileProvider();
        this.c.n = new ba(azVar.e.e, azVar.e.f, false, 0, this.c);
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (TextUtils.isEmpty(diskCacheDir)) {
            this.c.f = false;
        }
        this.c.m = diskCacheDir;
        this.c.o = new u(buVar.getContext(), false, this.c);
        this.c.q = new bv(azVar, this.c);
        this.c.a(true);
        this.d = tileOverlayOptions.isVisible();
        this.e = getId();
        this.f = tileOverlayOptions.getZIndex();
    }

    private static String a(String str) {
        a++;
        return str + a;
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public void remove() {
        try {
            this.b.b(this);
            this.c.b();
            this.c.q.b();
        } catch (Throwable th) {
            cm.a(th, "TileOverlayDelegateImp", "remove");
        }
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public void clearTileCache() {
        try {
            this.c.b();
        } catch (Throwable th) {
            cm.a(th, "TileOverlayDelegateImp", "remove");
        }
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public String getId() {
        if (this.e == null) {
            this.e = a("TileOverlay");
        }
        return this.e;
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public void setZIndex(float f2) {
        this.f = f2;
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public float getZIndex() {
        return this.f;
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public void setVisible(boolean z) {
        this.d = z;
        this.c.a(z);
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public boolean isVisible() {
        return this.d;
    }

    @Override // com.amap.api.mapcore2d.ak
    public void a(Canvas canvas) {
        this.c.a(canvas);
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public boolean equalsRemote(ITileOverlay iTileOverlay) {
        return equals(iTileOverlay) || iTileOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.amap.api.mapcore2d.ak
    public void a() {
        this.c.q.c();
    }

    @Override // com.amap.api.mapcore2d.ak
    public void b() {
        this.c.q.d();
    }

    @Override // com.amap.api.mapcore2d.ak
    public void c() {
        this.c.q.b();
    }
}
