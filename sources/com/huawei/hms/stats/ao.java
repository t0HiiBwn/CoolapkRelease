package com.huawei.hms.stats;

import java.util.Calendar;
import java.util.UUID;

public class ao {
    private long a = 1800000;
    private long b = 30000;
    private volatile boolean c = false;
    private volatile long d = 0;
    private a e = null;

    private class a {
        String a = UUID.randomUUID().toString().replace("-", "");
        boolean b;
        private long d;

        a(long j) {
            this.a += "_" + j;
            this.d = j;
            this.b = true;
            ao.this.c = false;
        }

        private boolean a(long j, long j2) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j2);
            return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
        }

        private void b(long j) {
            af.b("SessionWrapper", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.a = uuid;
            this.a = uuid.replace("-", "");
            this.a += "_" + j;
            this.d = j;
            this.b = true;
        }

        private boolean b(long j, long j2) {
            return j2 - j >= ao.this.a;
        }

        void a(long j) {
            if (ao.this.c) {
                ao.this.c = false;
                b(j);
            } else if (b(this.d, j) || a(this.d, j)) {
                b(j);
            } else {
                this.d = j;
                this.b = false;
            }
        }
    }

    public String a() {
        a aVar = this.e;
        if (aVar != null) {
            return aVar.a;
        }
        af.c("SessionWrapper", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    void a(long j) {
        a aVar = this.e;
        if (aVar == null) {
            af.b("SessionWrapper", "Session is first flush");
            this.e = new a(j);
            return;
        }
        aVar.a(j);
    }

    public boolean b() {
        a aVar = this.e;
        if (aVar != null) {
            return aVar.b;
        }
        af.c("SessionWrapper", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }

    public void c() {
        this.e = null;
        this.d = 0;
        this.c = false;
    }
}
