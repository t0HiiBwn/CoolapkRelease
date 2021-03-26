package com.tencent.android.tpush.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;

/* compiled from: ProGuard */
public class g {
    public int a = 100;
    public long b = 0;
    public long c = 0;
    public long d = 0;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private String h = "";
    private long i = -1;
    private String j = "";
    private long k = -1;
    private long l = -1;
    private String m = "";
    private String n = "";
    private String o = "";
    private Context p = null;
    private Intent q = null;
    private a r = null;
    private int s = 0;

    private g(Context context, Intent intent) {
        this.p = context;
        this.q = intent;
    }

    public static g a(Context context, Intent intent) {
        g gVar = new g(context, intent);
        String decrypt = Rijndael.decrypt(intent.getStringExtra("content"));
        TLogger.d("PushMessageManager", "PushMessageManager content:" + decrypt);
        gVar.j = decrypt;
        gVar.f = intent.getLongExtra("msgId", -1);
        gVar.g = intent.getLongExtra("accId", -1);
        gVar.h = intent.getStringExtra("third_app_pkgname");
        gVar.i = intent.getLongExtra("busiMsgId", -1);
        gVar.e = intent.getLongExtra("channel_id", -1);
        gVar.k = intent.getLongExtra("timestamps", -1);
        gVar.l = intent.getLongExtra("type", -1);
        int intExtra = intent.getIntExtra("pushChannel", 100);
        gVar.b = intent.getLongExtra("pushTime", -1);
        gVar.a = intExtra;
        String stringExtra = intent.getStringExtra("group_id");
        gVar.m = stringExtra;
        if (j.b(stringExtra)) {
            gVar.m = intent.getStringExtra("groupId");
        }
        gVar.c = intent.getLongExtra("targetType", 0);
        gVar.d = intent.getLongExtra("source", 0);
        gVar.n = intent.getStringExtra("templateId");
        gVar.o = intent.getStringExtra("traceId");
        a aVar = null;
        int i2 = (int) gVar.l;
        if (i2 == 1) {
            aVar = new e(decrypt);
        } else if (i2 == 2) {
            aVar = new h(decrypt);
        } else if (i2 == 3) {
            c.a().b(context, decrypt);
            XGPushManager.msgAck(context, gVar);
        } else if (i2 != 1000) {
            TLogger.e("PushMessageManager", "error type for message, drop it, type:" + gVar.l + ",intent:" + intent);
            XGPushManager.msgAck(context, gVar);
        }
        if (aVar != null) {
            gVar.r = aVar;
            aVar.a();
        }
        gVar.s = intent.getIntExtra("revokeId", 0);
        return gVar;
    }

    public void a() {
        if (this.r.b() == 1) {
            b.a(this.p, this);
        }
    }

    public long b() {
        return this.f;
    }

    public long c() {
        return this.g;
    }

    public long d() {
        return this.i;
    }

    public long e() {
        return this.k;
    }

    public String f() {
        return this.j;
    }

    public String g() {
        return this.m;
    }

    public String h() {
        return this.n;
    }

    public String i() {
        return this.o;
    }

    public long j() {
        return this.c;
    }

    public long k() {
        return this.d;
    }

    public String l() {
        return this.h;
    }

    public a m() {
        return this.r;
    }

    public String toString() {
        return "PushMessageManager [msgId=" + this.f + ", accessId=" + this.g + ", busiMsgId=" + this.i + ", content=" + this.j + ", timestamps=" + this.k + ", type=" + this.l + ", intent=" + this.q + ", messageHolder=" + this.r + ", appPkgName=" + this.h + ", revokeId=" + this.s + ", templateId=" + this.n + ", traceId=" + this.o + "]";
    }

    public long n() {
        return this.e;
    }
}
