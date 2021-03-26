package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Stack */
public final class m {
    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (c(th)) {
                a(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Exception unused) {
            printWriter.close();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0029 A[SYNTHETIC] */
    public static JSONObject a(String str) {
        boolean z;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!b(name)) {
                    if (str != null) {
                        if (!str.equals(name) && !name.startsWith(str)) {
                            if (name.endsWith(str)) {
                            }
                        }
                    }
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        if (jSONArray2.length() <= 0) {
                            z = false;
                            if (!z) {
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean b(String str) {
        Set<String> a2 = e.a();
        if (a2.contains(str)) {
            return true;
        }
        for (String str2 : a2) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* compiled from: Stack */
    private static class a {
        private final PrintWriter a;

        a(PrintWriter printWriter) {
            this.a = printWriter;
        }

        Object a() {
            return this.a;
        }

        void a(Object obj) {
            this.a.println(obj);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (!(th == null || printWriter == null)) {
            a aVar = new a(printWriter);
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (aVar.a()) {
                aVar.a(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (i2 > 256) {
                        aVar.a("\t... skip " + (stackTrace.length - i2) + " lines");
                        break;
                    }
                    aVar.a("\tat " + stackTraceElement);
                    i2++;
                    i++;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    for (Throwable th2 : th.getSuppressed()) {
                        a(th2, aVar, stackTrace, "Suppressed: ", "\t", newSetFromMap);
                    }
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    a(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            aVar.a("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int min = Math.min(stackTrace.length, 256);
        int i = min - 1;
        int min2 = Math.min(stackTraceElementArr.length, 256) - 1;
        int i2 = i;
        while (i2 >= 0 && min2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[min2])) {
            i2--;
            min2--;
        }
        int i3 = i - i2;
        aVar.a(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            aVar.a(str2 + "\tat " + stackTrace[i4]);
        }
        if (min < stackTrace.length) {
            aVar.a("\t... skip " + (stackTrace.length - min) + " lines");
        }
        if (i3 != 0) {
            aVar.a(str2 + "\t... " + i3 + " more");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, stackTrace, "Suppressed: ", str2 + "\t", set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, aVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean c(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }
}
