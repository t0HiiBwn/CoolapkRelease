package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.m;
import com.xiaomi.push.service.ag;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class ca {
    private static volatile ca c;
    private final ConcurrentLinkedQueue<b> a;
    private Context b;

    class a extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a() {
            super();
            ca.this = r1;
        }

        @Override // com.xiaomi.push.ca.b, com.xiaomi.push.m.b
        public void b() {
            ca.this.b();
        }
    }

    class b extends m.b {
        long b = System.currentTimeMillis();

        b() {
            ca.this = r3;
        }

        @Override // com.xiaomi.push.m.b
        public void b() {
        }

        public boolean d() {
            return true;
        }

        final boolean e() {
            return System.currentTimeMillis() - this.b > 172800000;
        }
    }

    class c extends b {
        String a;
        String d;
        File e;
        int f;
        boolean g;
        boolean h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, String str2, File file, boolean z) {
            super();
            ca.this = r1;
            this.a = str;
            this.d = str2;
            this.e = file;
            this.h = z;
        }

        private boolean f() {
            int i2;
            int i3 = 0;
            SharedPreferences sharedPreferences = ca.this.b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i2 = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i2 > 10) {
                return false;
            } else {
                i3 = i2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i3 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                com.xiaomi.a.a.a.c.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.ca.b, com.xiaomi.push.m.b
        public void b() {
            try {
                if (f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", ag.e());
                    hashMap.put("token", this.d);
                    hashMap.put("net", aa.k(ca.this.b));
                    aa.a(this.a, hashMap, this.e, "file");
                }
                this.g = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.m.b
        public void c() {
            if (!this.g) {
                int i2 = this.f + 1;
                this.f = i2;
                if (i2 < 3) {
                    ca.this.a.add(this);
                }
            }
            if (this.g || this.f >= 3) {
                this.e.delete();
            }
            ca.this.a((long) ((1 << this.f) * 1000));
        }

        @Override // com.xiaomi.push.ca.b
        public boolean d() {
            return aa.e(ca.this.b) || (this.h && aa.c(ca.this.b));
        }
    }

    private ca(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.a = concurrentLinkedQueue;
        this.b = context;
        concurrentLinkedQueue.add(new a());
        b(0);
    }

    public static ca a(Context context) {
        if (c == null) {
            synchronized (ca.class) {
                if (c == null) {
                    c = new ca(context);
                }
            }
        }
        c.b = context;
        return c;
    }

    public void a(long j) {
        b peek = this.a.peek();
        if (peek != null && peek.d()) {
            b(j);
        }
    }

    public void b() {
        if (!b.b() && !b.a()) {
            try {
                File file = new File(this.b.getExternalFilesDir(null) + "/.logcache");
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
        if (!this.a.isEmpty()) {
            fq.a(new cc(this), j);
        }
    }

    private void c() {
        while (!this.a.isEmpty()) {
            b peek = this.a.peek();
            if (peek != null) {
                if (peek.e() || this.a.size() > 6) {
                    com.xiaomi.a.a.a.c.c("remove Expired task");
                    this.a.remove(peek);
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
        this.a.add(new cb(this, i, date, date2, str, str2, z));
        b(0);
    }
}
