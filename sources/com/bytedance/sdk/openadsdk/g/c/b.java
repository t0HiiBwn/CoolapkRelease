package com.bytedance.sdk.openadsdk.g.c;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.c.c;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: LogStatsCache */
public class b {
    private static volatile b a;
    private Context b;
    private AtomicBoolean c = new AtomicBoolean(false);

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private b() {
        b();
    }

    public void b() {
        if (!this.c.get() && p.a() != null) {
            this.b = p.a();
            this.c.set(true);
        }
    }

    public synchronized void c() {
        if (!this.c.get()) {
            b();
        } else {
            try {
                a.a(this.b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        if (r1 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        if (r1 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (r1 == null) goto L_0x006d;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:9:0x0035] */
    public synchronized List<c.a> d() {
        LinkedList linkedList = new LinkedList();
        if (!this.c.get()) {
            b();
            return linkedList;
        }
        Cursor a2 = a.a(this.b, "logstats", new String[]{"id", "value"}, "retry <?", new String[]{String.valueOf(5)}, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    linkedList.add(new c.a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                } catch (Exception unused) {
                } catch (Throwable th) {
                }
            }
        }
        return linkedList;
    }
}
