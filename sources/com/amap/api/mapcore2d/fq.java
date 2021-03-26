package com.amap.api.mapcore2d;

import java.io.File;

/* compiled from: FileNumUpdateStrategy */
public class fq extends fu {
    private int b;
    private String c;

    public fq(int i, String str, fu fuVar) {
        super(fuVar);
        this.b = i;
        this.c = str;
    }

    @Override // com.amap.api.mapcore2d.fu
    protected boolean a() {
        return a(this.c) >= this.b;
    }

    public int a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            Cdo.c(th, "fus", "gfn");
            return 0;
        }
    }
}
