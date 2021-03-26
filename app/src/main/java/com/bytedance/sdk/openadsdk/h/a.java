package com.bytedance.sdk.openadsdk.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;

/* compiled from: DiskImageCache */
class a extends com.bytedance.sdk.adnet.b.a {
    private static String b;
    private WeakHashMap<String, String> c = new WeakHashMap<>();
    private final com.bytedance.sdk.openadsdk.b.a d = new d();

    public static a a() {
        return new a();
    }

    private a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public Bitmap a(String str) {
        Throwable th;
        Bitmap a = super.a(str);
        if (a == null) {
            File file = new File(b(), str);
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        a = BitmapFactory.decodeFileDescriptor(fileInputStream2.getFD(), null, null);
                        if (a != null) {
                            super.a(str, a);
                        }
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        try {
                            u.c("DiskImageCache", "diskImageCache getBitmap error ", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return a;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    u.c("DiskImageCache", "diskImageCache getBitmap error ", th);
                    if (fileInputStream != null) {
                    }
                    return a;
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public void a(String str, Bitmap bitmap) {
        Throwable th;
        if (bitmap != null) {
            super.a(str, bitmap);
            File file = new File(b(), str);
            if (!file.exists() || !file.isFile() || file.length() <= 0) {
                File file2 = new File(file + ".tmp");
                file2.delete();
                FileOutputStream fileOutputStream = null;
                try {
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                        fileOutputStream2.flush();
                        if (file2.exists() && file2.length() > 0) {
                            file2.renameTo(file);
                        }
                        this.d.a(file);
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        try {
                            u.c("DiskImageCache", "diskImageCache putBitmap error ", th);
                            file2.delete();
                            file.delete();
                            if (fileOutputStream == null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th3) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    u.c("DiskImageCache", "diskImageCache putBitmap error ", th);
                    file2.delete();
                    file.delete();
                    if (fileOutputStream == null) {
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.c.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String a = j.a(str);
        this.c.put(str, a);
        return a;
    }

    private static String b() {
        if (TextUtils.isEmpty(b)) {
            File file = new File(com.bytedance.sdk.adnet.a.b(p.a()), "diskImage");
            file.mkdirs();
            b = file.getAbsolutePath();
        }
        return b;
    }
}
