package com.amap.api.col.s;

import java.io.File;

/* compiled from: FileNumUpdateStrategy */
public final class dp extends dt {
    private int a = 30;
    private String b;

    public dp(String str, dt dtVar) {
        super(dtVar);
        this.b = str;
    }

    @Override // com.amap.api.col.s.dt
    protected final boolean a() {
        return a(this.b) >= this.a;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            cg.c(th, "fus", "gfn");
            return 0;
        }
    }
}
