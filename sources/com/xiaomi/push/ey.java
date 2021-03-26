package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ey extends Exception {
    private fh a = null;
    private fi b = null;
    private Throwable c = null;

    public ey() {
    }

    public ey(fh fhVar) {
        this.a = fhVar;
    }

    public ey(String str) {
        super(str);
    }

    public ey(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    public ey(Throwable th) {
        this.c = th;
    }

    public Throwable a() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fh fhVar;
        fi fiVar;
        String message = super.getMessage();
        return (message != null || (fiVar = this.b) == null) ? (message != null || (fhVar = this.a) == null) ? message : fhVar.toString() : fiVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.c != null) {
            printStream.println("Nested Exception: ");
            this.c.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.c != null) {
            printWriter.println("Nested Exception: ");
            this.c.printStackTrace(printWriter);
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
        fi fiVar = this.b;
        if (fiVar != null) {
            sb.append(fiVar);
        }
        fh fhVar = this.a;
        if (fhVar != null) {
            sb.append(fhVar);
        }
        if (this.c != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.c);
        }
        return sb.toString();
    }
}
