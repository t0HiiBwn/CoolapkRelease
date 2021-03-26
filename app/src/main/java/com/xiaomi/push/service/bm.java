package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ac;
import com.xiaomi.push.ai;
import com.xiaomi.push.bf;
import com.xiaomi.push.bi;
import com.xiaomi.push.h;
import com.xiaomi.push.hg;
import com.xiaomi.push.im;
import com.xiaomi.push.p;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class bm {
    public static final Object a = new Object();

    public static void a(Context context, hg hgVar) {
        if (bl.a(hgVar.e())) {
            ai.a(context).a(new bn(context, hgVar));
        }
    }

    public static byte[] a(Context context) {
        String a2 = p.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = bi.a(20);
            p.a(context).m573a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(bf.m137a(str), 16);
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
    public static void c(Context context, hg hgVar) {
        Throwable th;
        ?? r0;
        String str;
        IOException e;
        ?? r02;
        Object obj;
        String str2;
        byte[] a2 = a(context);
        try {
            byte[] b = h.b(a2, im.a(hgVar));
            if (b == null || b.length < 1) {
                str2 = "TinyData write to cache file failed case encryption fail item:" + hgVar.d() + "  ts:" + System.currentTimeMillis();
            } else if (b.length > 10240) {
                str2 = "TinyData write to cache file failed case too much data content item:" + hgVar.d() + "  ts:" + System.currentTimeMillis();
            } else {
                ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                try {
                    bufferedOutputStream.write(ac.a(b.length));
                    bufferedOutputStream.write(b);
                    bufferedOutputStream.flush();
                    y.a((Closeable) null);
                    y.a((Closeable) bufferedOutputStream);
                    return;
                } catch (IOException e2) {
                    obj = bufferedOutputStream;
                    e = e2;
                    str = "TinyData write to cache file failed cause io exception item:" + hgVar.d();
                    r02 = obj;
                    b.a(str, e);
                    y.a((Closeable) null);
                    y.a((Closeable) r02);
                } catch (Exception e3) {
                    a2 = bufferedOutputStream;
                    e = e3;
                    str = "TinyData write to cache file  failed item:" + hgVar.d();
                    r02 = a2;
                    b.a(str, e);
                    y.a((Closeable) null);
                    y.a((Closeable) r02);
                } catch (Throwable th2) {
                    r0 = bufferedOutputStream;
                    th = th2;
                    y.a((Closeable) null);
                    y.a((Closeable) r0);
                    throw th;
                }
            }
            b.m41a(str2);
            y.a((Closeable) null);
            y.a((Closeable) null);
        } catch (IOException e4) {
            e = e4;
            obj = null;
            str = "TinyData write to cache file failed cause io exception item:" + hgVar.d();
            r02 = obj;
            b.a(str, e);
            y.a((Closeable) null);
            y.a((Closeable) r02);
        } catch (Exception e5) {
            e = e5;
            a2 = null;
            str = "TinyData write to cache file  failed item:" + hgVar.d();
            r02 = a2;
            b.a(str, e);
            y.a((Closeable) null);
            y.a((Closeable) r02);
        } catch (Throwable th3) {
            th = th3;
            r0 = a2;
            y.a((Closeable) null);
            y.a((Closeable) r0);
            throw th;
        }
    }
}
