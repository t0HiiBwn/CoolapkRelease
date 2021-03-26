package com.bytedance.sdk.openadsdk.preload.b.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ParallelException */
public class a extends Exception {
    private List<Throwable> a;

    public a(List<Throwable> list) {
        this.a = list;
        if (!(list == null || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            for (Throwable th : list) {
                a(th, arrayList);
            }
            setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        }
    }

    private void a(Throwable th, List<StackTraceElement> list) {
        if (th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (i == 0) {
                    String message = th.getMessage();
                    StringBuilder sb = new StringBuilder();
                    sb.append("\b\b\b\nCaused by:");
                    if (message == null) {
                        message = "";
                    }
                    sb.append(message);
                    sb.append("\n\t");
                    sb.append(stackTraceElement.getClassName());
                    list.add(new StackTraceElement(sb.toString(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber()));
                } else {
                    list.add(stackTraceElement);
                }
            }
            a(th.getCause(), list);
        }
    }
}
