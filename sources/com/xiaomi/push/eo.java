package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;

public class eo extends er {
    private int a = 16777216;
    private Bitmap b;

    public eo(Context context, String str) {
        super(context, str);
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public eo mo295a(Bitmap bitmap) {
        if (b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                b.m41a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.b = bitmap;
            }
        }
        return this;
    }

    public eo a(String str) {
        if (b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                b.m41a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a  reason: collision with other method in class */
    public er setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    protected String mo296a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    public void mo296a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        if (!b() || this.b == null) {
            b();
            return;
        }
        super.mo304a();
        Resources resources = mo296a().getResources();
        String packageName = mo296a().getPackageName();
        int a2 = a(resources, "bg", "id", packageName);
        if (l.a(mo296a()) >= 10) {
            remoteViews = mo296a();
            bitmap = a(this.b, 30.0f);
        } else {
            remoteViews = mo296a();
            bitmap = this.b;
        }
        remoteViews.setImageViewBitmap(a2, bitmap);
        a(a(resources, "icon", "id", packageName));
        int a3 = a(resources, "title", "id", packageName);
        mo296a().setTextViewText(a3, this.f407a);
        if (this.f409a != null && this.a == 16777216) {
            a((String) this.f409a.get("notification_image_text_color"));
        }
        RemoteViews a4 = mo296a();
        int i = this.a;
        a4.setTextColor(a3, (i == 16777216 || !a(i)) ? -1 : -16777216);
        setCustomContentView(mo296a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    protected boolean mo296a() {
        if (!l.m569a(mo296a())) {
            return false;
        }
        Resources resources = mo296a().getResources();
        String packageName = mo296a().getPackageName();
        return (a(mo296a().getResources(), "bg", "id", mo296a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || l.a(mo296a()) < 9) ? false : true;
    }

    @Override // com.xiaomi.push.er
    protected String b() {
        return null;
    }
}
