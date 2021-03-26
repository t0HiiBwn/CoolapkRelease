package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ae;
import com.xiaomi.push.ah;
import com.xiaomi.push.d;
import com.xiaomi.push.fv;
import com.xiaomi.push.gm;
import com.xiaomi.push.ht;
import com.xiaomi.push.ix;
import com.xiaomi.push.j;
import com.xiaomi.push.jg;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class al {
    public static final Object a = new Object();

    public static void a(Context context, gm gmVar) {
        if (ak.a(gmVar.p())) {
            j.a(context).a(new am(context, gmVar));
        }
    }

    public static byte[] a(Context context) {
        String b = ix.a(context).b("mipush", "td_key", "");
        if (TextUtils.isEmpty(b)) {
            b = ah.a(20);
            ix.a(context).a("mipush", "td_key", b);
        }
        return a(b);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(ae.c(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.Closeable, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static void c(Context context, gm gmVar) {
        Throwable th;
        ?? r0;
        String str;
        IOException e;
        ?? r02;
        Object obj;
        String str2;
        byte[] a2 = a(context);
        try {
            byte[] b = fv.b(a2, ht.a(gmVar));
            if (b == null || b.length < 1) {
                str2 = "TinyData write to cache file failed case encryption fail item:" + gmVar.m() + "  ts:" + System.currentTimeMillis();
            } else if (b.length > 10240) {
                str2 = "TinyData write to cache file failed case too much data content item:" + gmVar.m() + "  ts:" + System.currentTimeMillis();
            } else {
                ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                try {
                    bufferedOutputStream.write(d.a(b.length));
                    bufferedOutputStream.write(b);
                    bufferedOutputStream.flush();
                    jg.a((Closeable) null);
                    jg.a((Closeable) bufferedOutputStream);
                    return;
                } catch (IOException e2) {
                    obj = bufferedOutputStream;
                    e = e2;
                    str = "TinyData write to cache file failed cause io exception item:" + gmVar.m();
                    r02 = obj;
                    c.a(str, e);
                    jg.a((Closeable) null);
                    jg.a((Closeable) r02);
                } catch (Exception e3) {
                    a2 = bufferedOutputStream;
                    e = e3;
                    str = "TinyData write to cache file  failed item:" + gmVar.m();
                    r02 = a2;
                    c.a(str, e);
                    jg.a((Closeable) null);
                    jg.a((Closeable) r02);
                } catch (Throwable th2) {
                    r0 = bufferedOutputStream;
                    th = th2;
                    jg.a((Closeable) null);
                    jg.a((Closeable) r0);
                    throw th;
                }
            }
            c.a(str2);
            jg.a((Closeable) null);
            jg.a((Closeable) null);
        } catch (IOException e4) {
            e = e4;
            obj = null;
            str = "TinyData write to cache file failed cause io exception item:" + gmVar.m();
            r02 = obj;
            c.a(str, e);
            jg.a((Closeable) null);
            jg.a((Closeable) r02);
        } catch (Exception e5) {
            e = e5;
            a2 = null;
            str = "TinyData write to cache file  failed item:" + gmVar.m();
            r02 = a2;
            c.a(str, e);
            jg.a((Closeable) null);
            jg.a((Closeable) r02);
        } catch (Throwable th3) {
            th = th3;
            r0 = a2;
            jg.a((Closeable) null);
            jg.a((Closeable) r0);
            throw th;
        }
    }
}
