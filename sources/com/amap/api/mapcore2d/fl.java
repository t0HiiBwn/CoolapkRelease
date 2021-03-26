package com.amap.api.mapcore2d;

/* compiled from: LogJsonDataStrategy */
public class fl extends fo {
    private StringBuilder a = new StringBuilder();
    private boolean b = true;

    public fl() {
    }

    public fl(fo foVar) {
        super(foVar);
    }

    @Override // com.amap.api.mapcore2d.fo
    protected byte[] a(byte[] bArr) {
        byte[] a2 = db.a(this.a.toString());
        c(a2);
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a2;
    }

    @Override // com.amap.api.mapcore2d.fo
    public void b(byte[] bArr) {
        String a2 = db.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.a.append(",");
        }
        StringBuilder sb = this.a;
        sb.append("{\"log\":\"");
        sb.append(a2);
        sb.append("\"}");
    }
}
