package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ah;
import com.xiaomi.push.jf;
import com.xiaomi.push.jg;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public class j {
    private static long a;

    public static class a {
        byte[] a;
        int b;

        public a(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    public static class b {
        public Bitmap a;
        public long b;

        public b(Bitmap bitmap, long j) {
            this.a = bitmap;
            this.b = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            c.a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    public static Bitmap a(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        IOException e;
        InputStream inputStream2;
        int a2;
        Uri parse = Uri.parse(str);
        InputStream inputStream3 = null;
        try {
            inputStream = context.getContentResolver().openInputStream(parse);
            try {
                a2 = a(context, inputStream);
                inputStream2 = context.getContentResolver().openInputStream(parse);
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
                try {
                    c.a(e);
                    jg.a(inputStream2);
                    jg.a(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream3 = inputStream2;
                    jg.a(inputStream3);
                    jg.a(inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                jg.a(inputStream3);
                jg.a(inputStream);
                throw th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                jg.a(inputStream2);
                jg.a(inputStream);
                return decodeStream;
            } catch (IOException e3) {
                e = e3;
                c.a(e);
                jg.a(inputStream2);
                jg.a(inputStream);
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            inputStream2 = null;
            inputStream = null;
            c.a(e);
            jg.a(inputStream2);
            jg.a(inputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            jg.a(inputStream3);
            jg.a(inputStream);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00dd, code lost:
        if (r1 == null) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00df, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fc, code lost:
        if (r1 == null) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ff, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0107  */
    private static a a(String str, boolean z) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        IOException e;
        InputStream inputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (!z || contentLength <= 102400) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        c.a("Invalid Http Response Code " + responseCode + " received");
                        jg.a((Closeable) null);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i = z ? 102400 : 2048000;
                        byte[] bArr = new byte[1024];
                        while (true) {
                            if (i <= 0) {
                                break;
                            }
                            int read = inputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            i -= read;
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (i <= 0) {
                            c.a("length 102400 exhausted.");
                            a aVar = new a(null, 102400);
                            jg.a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return aVar;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a aVar2 = new a(byteArray, byteArray.length);
                        jg.a(inputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return aVar2;
                    } catch (SocketTimeoutException unused) {
                        c.d("Connect timeout to " + str);
                        jg.a(inputStream);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            c.a(e);
                            jg.a(inputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = inputStream;
                            jg.a(inputStream2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                } else {
                    c.a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    jg.a((Closeable) null);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
            } catch (SocketTimeoutException unused2) {
                inputStream = null;
                c.d("Connect timeout to " + str);
                jg.a(inputStream);
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
                c.a(e);
                jg.a(inputStream);
            } catch (Throwable th3) {
                th = th3;
                jg.a(inputStream2);
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (SocketTimeoutException unused3) {
            httpURLConnection = null;
            inputStream = null;
            c.d("Connect timeout to " + str);
            jg.a(inputStream);
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            inputStream = null;
            c.a(e);
            jg.a(inputStream);
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            jg.a(inputStream2);
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    public static b a(Context context, String str, boolean z) {
        Throwable th;
        Exception e;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0);
        Bitmap b2 = b(context, str);
        if (b2 != null) {
            bVar.a = b2;
            return bVar;
        }
        try {
            a a2 = a(str, z);
            if (a2 == null) {
                jg.a((Closeable) null);
                return bVar;
            }
            bVar.b = (long) a2.b;
            byte[] bArr = a2.a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            c.a(e);
                            jg.a(byteArrayInputStream);
                            return bVar;
                        } catch (Throwable th2) {
                            th = th2;
                            jg.a(byteArrayInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream = byteArrayInputStream2;
                        jg.a(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.a, str);
            jg.a(byteArrayInputStream);
            return bVar;
        } catch (Exception e3) {
            e = e3;
            c.a(e);
            jg.a(byteArrayInputStream);
            return bVar;
        }
    }

    private static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (a == 0) {
                a = jf.a(file);
            }
            if (a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                            listFiles[i].delete();
                        }
                    }
                } catch (Exception e) {
                    c.a(e);
                }
                a = 0;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private static void a(Context context, byte[] bArr, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            c.a("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ah.a(str));
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    c.a(e);
                    jg.a(bufferedOutputStream2);
                    jg.a(fileOutputStream);
                    if (a != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jg.a(bufferedOutputStream2);
                    jg.a(fileOutputStream);
                    throw th;
                }
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                jg.a(bufferedOutputStream);
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream2 = bufferedOutputStream;
                c.a(e);
                jg.a(bufferedOutputStream2);
                jg.a(fileOutputStream);
                if (a != 0) {
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                jg.a(bufferedOutputStream2);
                jg.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            c.a(e);
            jg.a(bufferedOutputStream2);
            jg.a(fileOutputStream);
            if (a != 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            jg.a(bufferedOutputStream2);
            jg.a(fileOutputStream);
            throw th;
        }
        jg.a(fileOutputStream);
        if (a != 0) {
            a = jf.a(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
        }
    }

    private static Bitmap b(Context context, String str) {
        Throwable th;
        Bitmap bitmap;
        Exception e;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", ah.a(str));
        FileInputStream fileInputStream = null;
        Bitmap bitmap2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bitmap2 = BitmapFactory.decodeStream(fileInputStream2);
                file.setLastModified(System.currentTimeMillis());
                jg.a(fileInputStream2);
                return bitmap2;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                bitmap = bitmap2;
                try {
                    c.a(e);
                    jg.a(fileInputStream);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    jg.a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                jg.a(fileInputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bitmap = null;
            c.a(e);
            jg.a(fileInputStream);
            return bitmap;
        }
    }
}
