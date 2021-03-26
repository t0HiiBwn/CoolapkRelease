package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* compiled from: BitmapDrawer */
class i {
    private Bitmap a = null;
    private Canvas b = null;
    private Bitmap.Config c;

    public i(Bitmap.Config config) {
        this.c = config;
    }

    public void a(Bitmap bitmap) {
        this.a = bitmap;
        this.b = new Canvas(this.a);
    }

    public void a(j jVar) {
        this.b.save(1);
        jVar.a(this.b);
        this.b.restore();
    }
}
