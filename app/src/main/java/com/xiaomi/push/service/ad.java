package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ai;

final class ad extends ai.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Notification f938a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f939a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f940a;
    final /* synthetic */ String b;

    ad(int i, String str, Context context, String str2, Notification notification) {
        this.a = i;
        this.f940a = str;
        this.f939a = context;
        this.b = str2;
        this.f938a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return ab.b(this.a, this.f940a);
    }

    @Override // java.lang.Runnable
    public void run() {
        ab.a(this.f939a, this.b, this.a, this.f940a, this.f938a);
    }
}
