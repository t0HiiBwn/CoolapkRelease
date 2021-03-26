package com.loc;

/* compiled from: LogJsonDataStrategy */
public final class bh extends bk {
    private StringBuilder a = new StringBuilder();
    private boolean b = true;

    public bh() {
    }

    public bh(bk bkVar) {
        super(bkVar);
    }

    @Override // com.loc.bk
    protected final byte[] a(byte[] bArr) {
        byte[] a2 = u.a(this.a.toString());
        this.d = a2;
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a2;
    }

    @Override // com.loc.bk
    public final void b(byte[] bArr) {
        String a2 = u.a(bArr);
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
