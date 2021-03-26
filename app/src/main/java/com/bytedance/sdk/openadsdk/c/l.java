package com.bytedance.sdk.openadsdk.c;

import android.content.Context;

/* compiled from: StatsBatchEventRepertoryImpl */
public class l extends n {
    @Override // com.bytedance.sdk.openadsdk.c.n
    public String c() {
        return "logstatsbatch";
    }

    public l(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.a.a("stats_serverbusy_retrycount", i);
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS logstatsbatch (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }
}
