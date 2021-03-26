package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ft extends Exception {
    private gc a = null;

    /* renamed from: a  reason: collision with other field name */
    private gd f483a = null;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f484a = null;

    public ft() {
    }

    public ft(gc gcVar) {
        this.a = gcVar;
    }

    public ft(String str) {
        super(str);
    }

    public ft(String str, Throwable th) {
        super(str);
        this.f484a = th;
    }

    public ft(Throwable th) {
        this.f484a = th;
    }

    public Throwable a() {
        return this.f484a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        gc gcVar;
        gd gdVar;
        String message = super.getMessage();
        return (message != null || (gdVar = this.f483a) == null) ? (message != null || (gcVar = this.a) == null) ? message : gcVar.toString() : gdVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f484a != null) {
            printStream.println("Nested Exception: ");
            this.f484a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f484a != null) {
            printWriter.println("Nested Exception: ");
            this.f484a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        gd gdVar = this.f483a;
        if (gdVar != null) {
            sb.append(gdVar);
        }
        gc gcVar = this.a;
        if (gcVar != null) {
            sb.append(gcVar);
        }
        if (this.f484a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f484a);
        }
        return sb.toString();
    }
}
