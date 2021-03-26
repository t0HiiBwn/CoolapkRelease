package com.bytedance.sdk.openadsdk.h;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.openadsdk.core.p;

/* compiled from: TTNetClient */
public class d {
    private static volatile d a;
    private static IHttpStack c;
    private Context b;
    private l d;
    private b e;
    private l f;
    private l g;
    private com.bytedance.sdk.adnet.b.d h;
    private com.bytedance.sdk.openadsdk.h.a.b i;

    public static IHttpStack a() {
        return c;
    }

    public static void a(IHttpStack iHttpStack) {
        c = iHttpStack;
    }

    public static e b() {
        return new e();
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private d(Context context) {
        this.b = context == null ? p.a() : context.getApplicationContext();
    }

    public void a(String str, b.a aVar) {
        j();
        if (this.e == null) {
            this.e = new b(this.b, this.d);
        }
        this.e.a(str, aVar);
    }

    public l c() {
        j();
        return this.d;
    }

    public l d() {
        k();
        return this.g;
    }

    public l e() {
        if (this.f == null) {
            this.f = com.bytedance.sdk.adnet.a.a(this.b);
        }
        return this.f;
    }

    public com.bytedance.sdk.openadsdk.h.a.b f() {
        h();
        return this.i;
    }

    public com.bytedance.sdk.adnet.b.d g() {
        i();
        return this.h;
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.AbstractC0032d dVar) {
        i();
        this.h.a(str, dVar);
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        return new a(imageView, str, i2, i3);
    }

    /* compiled from: TTNetClient */
    static class a implements d.AbstractC0032d {
        private ImageView a;
        private final String b;
        private final int c;
        private final int d;

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void a(m<Bitmap> mVar) {
        }

        a(ImageView imageView, String str, int i, int i2) {
            this.a = imageView;
            this.b = str;
            this.c = i;
            this.d = i2;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
        public void a() {
            int i;
            ImageView imageView = this.a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.a.getContext()).isFinishing()) && this.a != null && c() && (i = this.c) != 0) {
                this.a.setImageResource(i);
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
        public void a(d.c cVar, boolean z) {
            ImageView imageView = this.a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.a.getContext()).isFinishing()) && this.a != null && c() && cVar.a() != null) {
                this.a.setImageBitmap(cVar.a());
            }
        }

        @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
        public void b() {
            this.a = null;
        }

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void b(m<Bitmap> mVar) {
            ImageView imageView = this.a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.a.getContext()).isFinishing()) && this.a != null && this.d != 0 && c()) {
                this.a.setImageResource(this.d);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.a;
            if (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.b)) {
                return false;
            }
            return true;
        }
    }

    private void h() {
        if (this.i == null) {
            k();
            this.i = new com.bytedance.sdk.openadsdk.h.a.b(this.g);
        }
    }

    private void i() {
        if (this.h == null) {
            k();
            this.h = new com.bytedance.sdk.adnet.b.d(this.g, a.a());
        }
    }

    private void j() {
        if (this.d == null) {
            this.d = com.bytedance.sdk.adnet.a.a(this.b);
        }
    }

    private void k() {
        if (this.g == null) {
            this.g = com.bytedance.sdk.adnet.a.a(this.b);
        }
    }
}
