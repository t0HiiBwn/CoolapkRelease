package com.ss.android.socialbase.appdownloader.f.a;

import java.io.PrintStream;

/* compiled from: XmlPullParserException */
public class h extends Exception {
    protected Throwable a;
    protected int b;
    protected int c;

    /* JADX WARNING: Illegal instructions before constructor call */
    public h(String str, g gVar, Throwable th) {
        super(r0.toString());
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = str4;
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (gVar == null) {
            str3 = str4;
        } else {
            str3 = "(position:" + gVar.d() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        this.b = -1;
        this.c = -1;
        if (gVar != null) {
            this.b = gVar.c();
            this.c = gVar.f();
        }
        this.a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.a.printStackTrace();
        }
    }
}
