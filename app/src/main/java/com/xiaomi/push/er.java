package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.ab;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.am;
import java.util.List;
import java.util.Map;

public abstract class er extends ep {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    protected Bitmap f405a;

    /* renamed from: a  reason: collision with other field name */
    private RemoteViews f406a;

    /* renamed from: a  reason: collision with other field name */
    protected CharSequence f407a;

    /* renamed from: a  reason: collision with other field name */
    private String f408a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, String> f409a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f410a;
    protected CharSequence b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f411b;

    public er(Context context, int i, String str) {
        super(context);
        this.f408a = str;
        this.a = i;
        m299c();
    }

    public er(Context context, String str) {
        super(context);
        this.f408a = str;
        m299c();
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    private Bitmap mo296a() {
        return ab.a(g.m355a(mo296a(), this.f408a));
    }

    private String c() {
        boolean e = e();
        this.f411b = e;
        return e ? b() : mo303a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m299c() {
        int a2 = a(mo296a().getResources(), c(), "layout", mo296a().getPackageName());
        if (a2 != 0) {
            this.f406a = new RemoteViews(mo296a().getPackageName(), a2);
            this.f410a = mo305a();
            return;
        }
        b.m41a("create RemoteViews failed, no such layout resource was found");
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m300c() {
        Map<String, String> map = this.f409a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.f407a);
            super.setContentText(this.b);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m301d() {
        return !TextUtils.isEmpty(b()) && !TextUtils.isEmpty(this.f408a);
    }

    private boolean e() {
        return m301d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> b2;
        if (Build.VERSION.SDK_INT >= 20 && (b2 = al.a(mo296a(), this.f408a).b()) != null && !b2.isEmpty()) {
            for (StatusBarNotification statusBarNotification : b2) {
                if (statusBarNotification.getId() == this.a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    protected int a(float f) {
        return (int) ((f * mo296a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    protected Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    protected final RemoteViews mo302a() {
        return this.f406a;
    }

    /* renamed from: a */
    public er addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        return this;
    }

    /* renamed from: a */
    public er addAction(Notification.Action action) {
        return this;
    }

    /* renamed from: a */
    public er setLargeIcon(Bitmap bitmap) {
        this.f405a = bitmap;
        return this;
    }

    /* renamed from: a */
    public er setContentTitle(CharSequence charSequence) {
        this.f407a = charSequence;
        return this;
    }

    public er a(Map<String, String> map) {
        this.f409a = map;
        return this;
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    protected abstract String mo303a();

    @Override // com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    protected void mo304a() {
        super.a();
        Bundle bundle = new Bundle();
        if (m301d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f411b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        addExtras(bundle);
        if (m300c() || !am.m622a(mo296a().getContentResolver())) {
            d();
        }
    }

    protected void a(int i) {
        Bitmap a2 = mo296a();
        if (a2 != null) {
            mo302a().setImageViewBitmap(i, a2);
            return;
        }
        int b2 = g.b(mo296a(), this.f408a);
        if (b2 != 0) {
            mo302a().setImageViewResource(i, b2);
        }
    }

    @Override // com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    protected abstract boolean mo305a();

    /* renamed from: a  reason: collision with other method in class */
    protected final boolean m306a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    /* renamed from: b */
    public er setContentText(CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    protected abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    protected final void m307b() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.f407a);
            super.setContentText(this.b);
            Bitmap bitmap = this.f405a;
            if (bitmap != null) {
                super.setLargeIcon(bitmap);
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    protected final boolean m308b() {
        return this.f410a;
    }
}
