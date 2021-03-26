package com.loc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: ALLog */
public final class dg {
    private static volatile dh a;

    public static void a(Throwable th) {
        if (cv.a) {
            Throwable th2 = th;
            while (true) {
                if (th2 != null) {
                    if (th2 instanceof UnknownHostException) {
                        break;
                    }
                    th2 = th2.getCause();
                } else {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter.toString();
                    break;
                }
            }
            dh dhVar = a;
        }
    }
}
