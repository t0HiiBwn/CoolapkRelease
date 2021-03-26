package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.d.l;

/* compiled from: BannerCellView */
class c extends FrameLayout {
    private ImageView a;
    private final Context b;
    private l c;

    public c(Context context) {
        super(context);
        this.b = context;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(this.b);
        this.a = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.a);
    }

    l a() {
        return this.c;
    }

    void a(l lVar) {
        this.c = lVar;
    }

    void a(Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
    }

    void b() {
        this.a.setImageBitmap(null);
        setOnClickListener(null);
        this.c = null;
    }
}
