package com.amap.api.col.s;

/* compiled from: LogJsonDataStrategy */
public final class dk extends dn {
    private StringBuilder a = new StringBuilder();
    private boolean b = true;

    public dk() {
    }

    public dk(dn dnVar) {
        super(dnVar);
    }

    @Override // com.amap.api.col.s.dn
    protected final byte[] a(byte[] bArr) {
        byte[] a2 = bs.a(this.a.toString());
        this.d = a2;
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a2;
    }

    @Override // com.amap.api.col.s.dn
    public final void b(byte[] bArr) {
        String a2 = bs.a(bArr);
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
