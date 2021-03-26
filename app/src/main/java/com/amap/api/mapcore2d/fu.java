package com.amap.api.mapcore2d;

/* compiled from: UpdateStrategy */
public abstract class fu {
    fu a;

    protected abstract boolean a();

    public fu() {
    }

    public fu(fu fuVar) {
        this.a = fuVar;
    }

    public boolean c() {
        if (!d()) {
            return false;
        }
        return a();
    }

    private boolean d() {
        fu fuVar = this.a;
        if (fuVar != null) {
            return fuVar.c();
        }
        return true;
    }

    public void a(boolean z) {
        fu fuVar = this.a;
        if (fuVar != null) {
            fuVar.a(z);
        }
    }

    public int b() {
        fu fuVar = this.a;
        return Math.min(Integer.MAX_VALUE, fuVar != null ? fuVar.b() : Integer.MAX_VALUE);
    }

    public void a(int i) {
        fu fuVar = this.a;
        if (fuVar != null) {
            fuVar.a(i);
        }
    }
}
