package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.network.i;
import java.io.BufferedInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: NotificationIconCache */
public class c {
    private static int a = 8;
    private static volatile c b;
    private a<Integer, Bitmap> c = null;

    /* compiled from: NotificationIconCache */
    private static class a<K, T> extends LinkedHashMap<K, T> {
        final int a;

        public a(int i, int i2) {
            super(i2, 0.75f, true);
            this.a = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.a;
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
        int i = a;
        this.c = new a<>(i, i / 2);
    }

    public Bitmap a(int i) {
        return (Bitmap) this.c.get(Integer.valueOf(i));
    }

    public void a(final int i, final String str) {
        if (!TextUtils.isEmpty(str)) {
            b.m().submit(new Runnable() {
                /* class com.ss.android.socialbase.appdownloader.e.c.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    Exception e;
                    try {
                        i a2 = b.a(true, 0, str, null);
                        if (a2 == null) {
                            e.a(null);
                            return;
                        }
                        bufferedInputStream = new BufferedInputStream(a2.a());
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i = options.outWidth;
                            int i2 = options.outHeight;
                            int a3 = com.ss.android.socialbase.appdownloader.c.a(b.L(), 44.0f);
                            options.inSampleSize = c.a(a3, a3, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            c.this.c.put(Integer.valueOf(i), BitmapFactory.decodeStream(bufferedInputStream, null, options));
                            e.a(bufferedInputStream);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                e.a(bufferedInputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                e.a(bufferedInputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        bufferedInputStream = null;
                        e = e3;
                        e.printStackTrace();
                        e.a(bufferedInputStream);
                    } catch (Throwable th3) {
                        bufferedInputStream = null;
                        th = th3;
                        e.a(bufferedInputStream);
                        throw th;
                    }
                }
            });
        }
    }

    public static int a(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(((float) options.outWidth) / ((float) i)), Math.round(((float) options.outHeight) / ((float) i2)));
        }
        return 1;
    }
}
