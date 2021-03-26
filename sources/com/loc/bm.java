package com.loc;

import java.io.File;

/* compiled from: FileNumUpdateStrategy */
public final class bm extends bq {
    private int a = 30;
    private String b;

    public bm(String str, bq bqVar) {
        super(bqVar);
        this.b = str;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            ab.b(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.loc.bq
    protected final boolean a() {
        return a(this.b) >= this.a;
    }
}
