package com.amap.api.col.s;

/* compiled from: UpdateStrategy */
public abstract class dt {
    dt c;

    protected abstract boolean a();

    public dt() {
    }

    public dt(dt dtVar) {
        this.c = dtVar;
    }

    public void a(boolean z) {
        dt dtVar = this.c;
        if (dtVar != null) {
            dtVar.a(z);
        }
    }

    public int b() {
        dt dtVar = this.c;
        return Math.min(Integer.MAX_VALUE, dtVar != null ? dtVar.b() : Integer.MAX_VALUE);
    }

    public void a(int i) {
        dt dtVar = this.c;
        if (dtVar != null) {
            dtVar.a(i);
        }
    }

    public final boolean c() {
        boolean z;
        dt dtVar = this.c;
        if (dtVar != null) {
            z = dtVar.c();
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        return a();
    }
}
