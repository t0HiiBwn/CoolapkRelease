package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.al;
import com.xiaomi.push.service.bh;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class cz {
    private static volatile cz a;

    /* renamed from: a */
    private Context f295a;

    /* renamed from: a */
    private final ConcurrentLinkedQueue<b> f296a;

    class a extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a() {
            super();
            cz.this = r1;
        }

        @Override // com.xiaomi.push.cz.b, com.xiaomi.push.al.b
        /* renamed from: b */
        public void mo197b() {
            cz.this.b();
        }
    }

    class b extends al.b {
        long a = System.currentTimeMillis();

        b() {
            cz.this = r3;
        }

        @Override // com.xiaomi.push.al.b
        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: b */
        public void mo197b() {
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: b */
        final boolean mo197b() {
            return System.currentTimeMillis() - this.a > 172800000;
        }
    }

    class c extends b {
        int a;

        /* renamed from: a */
        File f298a;

        /* renamed from: a */
        String f299a;

        /* renamed from: a */
        boolean f300a;
        String b;

        /* renamed from: b */
        boolean f301b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, String str2, File file, boolean z) {
            super();
            cz.this = r1;
            this.f299a = str;
            this.b = str2;
            this.f298a = file;
            this.f301b = z;
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c */
        private boolean mo198c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = cz.this.f295a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i > 10) {
                return false;
            } else {
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.cz.b, com.xiaomi.push.al.b
        public boolean a() {
            return bc.d(cz.this.f295a) || (this.f301b && bc.b(cz.this.f295a));
        }

        @Override // com.xiaomi.push.cz.b, com.xiaomi.push.al.b
        /* renamed from: b */
        public void mo197b() {
            try {
                if (mo198c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", bh.m641a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", bc.m129a(cz.this.f295a));
                    bc.a(this.f299a, hashMap, this.f298a, "file");
                }
                this.f300a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c */
        public void mo198c() {
            if (!this.f300a) {
                int i = this.a + 1;
                this.a = i;
                if (i < 3) {
                    cz.this.f296a.add(this);
                }
            }
            if (this.f300a || this.a >= 3) {
                this.f298a.delete();
            }
            cz.this.a((long) ((1 << this.a) * 1000));
        }
    }

    private cz(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f296a = concurrentLinkedQueue;
        this.f295a = context;
        concurrentLinkedQueue.add(new a());
        b(0);
    }

    public static cz a(Context context) {
        if (a == null) {
            synchronized (cz.class) {
                if (a == null) {
                    a = new cz(context);
                }
            }
        }
        a.f295a = context;
        return a;
    }

    public void a(long j) {
        b peek = this.f296a.peek();
        if (peek != null && peek.a()) {
            b(j);
        }
    }

    public void b() {
        if (!aa.b() && !aa.m100a()) {
            try {
                File file = new File(this.f295a.getExternalFilesDir(null) + "/.logcache");
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    private void b(long j) {
        if (!this.f296a.isEmpty()) {
            gl.a(new db(this), j);
        }
    }

    private void c() {
        while (!this.f296a.isEmpty()) {
            b peek = this.f296a.peek();
            if (peek != null) {
                if (peek.mo197b() || this.f296a.size() > 6) {
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.f296a.remove(peek);
                } else {
                    return;
                }
            }
        }
    }

    public void a() {
        c();
        a(0);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f296a.add(new da(this, i, date, date2, str, str2, z));
        b(0);
    }
}
