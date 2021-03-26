package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.downloadlib.h.c;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.g;
import com.ss.android.socialbase.downloader.network.i;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BitmapCache */
public class d extends g<Long, Bitmap> {
    private final Map<Long, SoftReference<a>> a;

    /* compiled from: BitmapCache */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* compiled from: BitmapCache */
    private static class b {
        private static d a = new d();
    }

    public static d a() {
        return b.a;
    }

    private d() {
        super(8, 8);
        this.a = new HashMap();
    }

    public void a(long j, a aVar) {
        if (get(Long.valueOf(j)) != null) {
            aVar.a((Bitmap) get(Long.valueOf(j)));
        } else {
            this.a.put(Long.valueOf(j), new SoftReference<>(aVar));
        }
    }

    public void a(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<a> remove = this.a.remove(Long.valueOf(j));
            if (remove != null && remove.get() != null) {
                remove.get().a((Bitmap) get(Long.valueOf(j)));
            }
        } else if (TextUtils.isEmpty(str)) {
            e.a(12, j2);
        } else {
            c.a(new c.a<Object, Object>() {
                /* class com.ss.android.downloadlib.addownload.compliance.d.AnonymousClass2 */

                @Override // com.ss.android.downloadlib.h.c.a
                public Object a(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    Exception e;
                    int i;
                    try {
                        i a2 = com.ss.android.socialbase.downloader.downloader.b.a(true, 0, str, null);
                        if (a2 == null) {
                            e.a(null);
                            return null;
                        }
                        bufferedInputStream = new BufferedInputStream(a2.a());
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i2 = options.outWidth;
                            int i3 = options.outHeight;
                            int a3 = k.a(com.ss.android.downloadlib.addownload.k.a(), 60.0f);
                            options.inSampleSize = d.b(a3, a3, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                                if (decodeStream == null) {
                                    i = -1;
                                } else {
                                    i = decodeStream.getByteCount();
                                }
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(i));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            com.ss.android.downloadlib.e.a.a().a("ttd_pref_monitor", jSONObject, j2);
                            d.this.put(Long.valueOf(j), decodeStream);
                            e.a(bufferedInputStream);
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                com.ss.android.downloadlib.f.a.a(e);
                                e.a(bufferedInputStream);
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                e.a(bufferedInputStream);
                                throw th;
                            }
                        }
                        return null;
                    } catch (Exception e4) {
                        e = e4;
                        bufferedInputStream = null;
                        com.ss.android.downloadlib.f.a.a(e);
                        e.a(bufferedInputStream);
                        return null;
                    } catch (Throwable th3) {
                        bufferedInputStream = null;
                        th = th3;
                        e.a(bufferedInputStream);
                        throw th;
                    }
                }
            }, (Object) null).a(new c.a<Object, Object>() {
                /* class com.ss.android.downloadlib.addownload.compliance.d.AnonymousClass1 */

                @Override // com.ss.android.downloadlib.h.c.a
                public Object a(Object obj) {
                    SoftReference softReference = (SoftReference) d.this.a.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((a) softReference.get()).a((Bitmap) d.this.get(Long.valueOf(j)));
                    return null;
                }
            }).a();
        }
    }

    /* access modifiers changed from: private */
    public static int b(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(((float) options.outWidth) / ((float) i)), Math.round(((float) options.outHeight) / ((float) i2)));
        }
        return 1;
    }
}
