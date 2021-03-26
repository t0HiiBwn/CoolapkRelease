package com.bytedance.sdk.openadsdk.h.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;

/* compiled from: GifCache */
public class a {
    private static String a;
    private static String b;
    private static volatile a g;
    private WeakHashMap<String, String> c = new WeakHashMap<>();
    private final com.bytedance.sdk.openadsdk.b.a d = new d();
    private final com.bytedance.sdk.openadsdk.b.a e = new d(20971520, true);
    private final LruCache<String, C0053a> f = new LruCache<String, C0053a>(5242880) {
        /* class com.bytedance.sdk.openadsdk.h.a.a.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, C0053a aVar) {
            int i = 0;
            if (aVar.a != null) {
                i = 0 + aVar.a.length;
            }
            return i == 0 ? super.sizeOf(str, aVar) : i;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, C0053a aVar, C0053a aVar2) {
            super.entryRemoved(z, str, aVar, aVar2);
            if (z && aVar != null) {
                aVar.a = null;
            }
        }
    };

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
            }
        }
        return g;
    }

    private a() {
    }

    public synchronized void a(String str, byte[] bArr) {
        u.f("splashLoadAd", " put GifLoader.mIsSpalsh " + b.b);
        if (b.b) {
            c(str, bArr);
        } else {
            b(str, bArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9  */
    public synchronized void b(String str, byte[] bArr) {
        u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
        if (!TextUtils.isEmpty(str)) {
            if (bArr != null) {
                if (!a(bArr)) {
                    try {
                        this.f.put(str, new C0053a(bArr));
                    } catch (Throwable th) {
                        u.c("GifCache", "gifCache mLruCache.put error ", th);
                    }
                }
                File file = new File(c(), str);
                if (!file.exists() || !file.isFile() || file.length() <= 0) {
                    u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 target " + file.getPath());
                    File file2 = new File(file + ".tmp");
                    file2.delete();
                    FileOutputStream fileOutputStream = null;
                    try {
                        file2.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            if (file2.exists() && file2.length() > 0) {
                                if (file.exists()) {
                                    file.delete();
                                }
                                file2.renameTo(file);
                            }
                            this.d.a(file);
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused) {
                            }
                        } catch (Throwable unused2) {
                            fileOutputStream = fileOutputStream2;
                            try {
                                file2.delete();
                                file.delete();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th2) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable unused4) {
                        file2.delete();
                        file.delete();
                        if (fileOutputStream != null) {
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
    public synchronized void c(String str, byte[] bArr) {
        u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
        if (!TextUtils.isEmpty(str)) {
            if (bArr != null) {
                if (!a(bArr)) {
                    try {
                        this.f.put(str, new C0053a(bArr));
                    } catch (Throwable th) {
                        u.c("GifCache", "gifCache mLruCache.put error ", th);
                    }
                }
                u.f("splashLoadAd", " GifCache put 保存到本地图片的素材路径 getCacheDir() " + b());
                File file = new File(b(), str);
                if (!file.exists() || !file.isFile() || file.length() <= 0) {
                    File file2 = new File(file + ".tmp");
                    file2.delete();
                    FileOutputStream fileOutputStream = null;
                    try {
                        file2.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            u.f("splashLoadAd", " GifCache put 图片素材写入本地成功 " + str);
                            if (file2.exists() && file2.length() > 0) {
                                if (file.exists()) {
                                    file.delete();
                                }
                                file2.renameTo(file);
                            }
                            com.bytedance.sdk.openadsdk.b.a aVar = this.e;
                            if (aVar != null) {
                                aVar.a(file);
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused) {
                            }
                        } catch (Throwable unused2) {
                            fileOutputStream = fileOutputStream2;
                            try {
                                file2.delete();
                                file.delete();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return;
                            } catch (Throwable th2) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable unused4) {
                        file2.delete();
                        file.delete();
                        if (fileOutputStream != null) {
                        }
                        return;
                    }
                    return;
                }
                u.f("splashLoadAd", " GifCache put 本地的gif素材以及存在 key " + str);
            }
        }
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public synchronized File a(String str, boolean z) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z) {
            file = new File(b(), str);
        } else {
            file = new File(c(), str);
        }
        if (!file.exists() || file.length() <= 0) {
            return null;
        }
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0070, code lost:
        if (r2 != null) goto L_0x0061;
     */
    public synchronized C0053a a(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        byte[] array;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0053a aVar = this.f.get(str);
        if (aVar != null) {
            return aVar;
        }
        File file = new File(c(), str);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                    fileInputStream.getChannel().read(allocate);
                    array = allocate.array();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        u.c("GifCache", "gifCache get error ", th);
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th3;
                    }
                }
                try {
                    C0053a aVar2 = new C0053a(array);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return aVar2;
                } catch (Throwable unused3) {
                    if (array != null) {
                        C0053a aVar3 = new C0053a(array);
                        this.f.put(str, aVar3);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                        return aVar3;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException unused5) {
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                u.c("GifCache", "gifCache get error ", th);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c6, code lost:
        if (r2 != null) goto L_0x00b7;
     */
    public synchronized C0053a b(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        byte[] array;
        u.f("splashLoadAd", " GifCache get  key " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0053a aVar = this.f.get(str);
        if (aVar != null) {
            return aVar;
        }
        u.f("splashLoadAd", " GifCache 从缓存文件中获取图片素材，图片路径为" + b() + " key " + str);
        File file = new File(b(), str);
        try {
            l.b(file);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                    fileInputStream.getChannel().read(allocate);
                    array = allocate.array();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        u.c("GifCache", "gifCache get error ", th);
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th3;
                    }
                }
                try {
                    C0053a aVar2 = new C0053a(array);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return aVar2;
                } catch (Throwable unused3) {
                    if (array != null) {
                        C0053a aVar3 = new C0053a(array);
                        this.f.put(str, aVar3);
                        u.f("splashLoadAd", " GifCache 从缓存文件中获取图片素材成功 key " + str);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                        return aVar3;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException unused5) {
                    }
                    u.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                u.c("GifCache", "gifCache get error ", th);
            }
        }
        u.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
        return null;
    }

    public synchronized String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        String str2 = this.c.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String a2 = j.a(str);
        this.c.put(str, a2);
        return a2;
    }

    private static String c() {
        if (TextUtils.isEmpty(a)) {
            a = c("diskGif");
        }
        return a;
    }

    private static String c(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        boolean z = true;
        if (p.h().B() == 1) {
            File file = new File(com.bytedance.sdk.adnet.a.b(p.a()), str);
            file.mkdirs();
            return file.getAbsolutePath();
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            z = false;
        }
        File file2 = null;
        if (z) {
            try {
                u.f("splashLoadAd", "当存在外部存储并且开屏支持外部存储");
                file2 = new File(p.a().getExternalCacheDir(), str);
                file2.mkdirs();
                str2 = file2.getAbsolutePath();
            } catch (Throwable unused) {
                return str2;
            }
        }
        if (file2 != null) {
            return str2;
        }
        File file3 = new File(com.bytedance.sdk.adnet.a.b(p.a()), str);
        file3.mkdirs();
        return file3.getAbsolutePath();
    }

    public static String b() {
        if (TextUtils.isEmpty(b)) {
            b = c("splash_image");
        }
        return b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.h.a.a$a  reason: collision with other inner class name */
    /* compiled from: GifCache */
    public static class C0053a {
        byte[] a;

        public C0053a(byte[] bArr) {
            this.a = bArr;
        }
    }
}
