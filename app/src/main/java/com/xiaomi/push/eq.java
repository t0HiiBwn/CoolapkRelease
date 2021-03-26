package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.ab;

public class eq extends er {
    private int a = 16777216;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f402a;
    private int b = 16777216;

    /* renamed from: b  reason: collision with other field name */
    private Bitmap f403b;
    private int c = 16777216;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f404c;

    public eq(Context context, int i, String str) {
        super(context, i, str);
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            int a2 = a(6.0f);
            remoteViews.setViewPadding(i, a2, 0, a2, 0);
        }
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public eq mo295a(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                b.m41a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f403b = bitmap;
            }
        }
        return this;
    }

    public eq a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (b()) {
            this.f404c = charSequence;
            this.f402a = pendingIntent;
        }
        return this;
    }

    public eq a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                b.m41a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    protected String mo296a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    public void mo297a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        boolean z;
        RemoteViews a2;
        Drawable drawable;
        RemoteViews remoteViews2;
        if (b()) {
            super.mo304a();
            Resources resources = mo296a().getResources();
            String packageName = mo296a().getPackageName();
            int a3 = a(resources, "icon", "id", packageName);
            if (this.f405a == null) {
                a(a3);
            } else {
                mo296a().setImageViewBitmap(a3, this.f405a);
            }
            int a4 = a(resources, "title", "id", packageName);
            int a5 = a(resources, "content", "id", packageName);
            mo296a().setTextViewText(a4, this.f407a);
            mo296a().setTextViewText(a5, this.b);
            if (!TextUtils.isEmpty(this.f404c)) {
                int a6 = a(resources, "buttonContainer", "id", packageName);
                int a7 = a(resources, "button", "id", packageName);
                int a8 = a(resources, "buttonBg", "id", packageName);
                mo296a().setViewVisibility(a6, 0);
                mo296a().setTextViewText(a7, this.f404c);
                mo296a().setOnClickPendingIntent(a6, this.f402a);
                if (this.b != 16777216) {
                    int a9 = a(70.0f);
                    int a10 = a(29.0f);
                    mo296a().setImageViewBitmap(a8, ab.a(a(this.b, a9, a10, ((float) a10) / 2.0f)));
                    mo296a().setTextColor(a7, a(this.b) ? -1 : -16777216);
                }
            }
            int a11 = a(resources, "bg", "id", packageName);
            int a12 = a(resources, "container", "id", packageName);
            if (this.a != 16777216) {
                if (l.a(mo296a()) >= 10) {
                    remoteViews2 = mo296a();
                    drawable = a(this.a, 984, 192, 30.0f);
                } else {
                    remoteViews2 = mo296a();
                    drawable = a(this.a, 984, 192, 0.0f);
                }
                remoteViews2.setImageViewBitmap(a11, ab.a(drawable));
                a2 = mo296a();
                z = a(this.a);
            } else if (this.f403b != null) {
                if (l.a(mo296a()) >= 10) {
                    remoteViews = mo296a();
                    bitmap = a(this.f403b, 30.0f);
                } else {
                    remoteViews = mo296a();
                    bitmap = this.f403b;
                }
                remoteViews.setImageViewBitmap(a11, bitmap);
                if (this.f409a != null && this.c == 16777216) {
                    c((String) this.f409a.get("notification_image_text_color"));
                }
                int i = this.c;
                z = i == 16777216 || !a(i);
                a2 = mo296a();
            } else {
                if (Build.VERSION.SDK_INT >= 24) {
                    mo296a().setViewVisibility(a3, 8);
                    mo296a().setViewVisibility(a11, 8);
                    try {
                        bd.a((Object) this, "setStyle", t.a(mo296a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        b.m41a("load class DecoratedCustomViewStyle failed");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(mo296a());
                return;
            }
            a(a2, a12, a4, a5, z);
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(mo296a());
            return;
        }
        b();
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    protected boolean mo298a() {
        if (!l.m569a(mo296a())) {
            return false;
        }
        Resources resources = mo296a().getResources();
        String packageName = mo296a().getPackageName();
        return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    public eq b(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                b.m41a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    protected String b() {
        return "notification_colorful_copy";
    }

    public eq c(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                b.m41a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
