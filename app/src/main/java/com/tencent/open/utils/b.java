package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
public class b {
    private static String c;
    private String a;
    private c b;
    private long d;
    private Handler e;
    private Runnable f = new Runnable() {
        /* class com.tencent.open.utils.b.AnonymousClass2 */

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            f.a("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + j.f(b.this.a) + ".jpg";
            String str2 = b.c + str;
            File file = new File(str2);
            Message obtainMessage = b.this.e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - b.this.d));
            } else {
                Bitmap a2 = b.a(b.this.a);
                if (a2 != null) {
                    z = b.this.a(a2, str);
                } else {
                    f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - b.this.d));
            }
            b.this.e.sendMessage(obtainMessage);
        }
    };

    public b(Activity activity) {
        this.e = new Handler(activity.getMainLooper()) {
            /* class com.tencent.open.utils.b.AnonymousClass1 */

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                f.a("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    b.this.b.a(message.arg1, (String) message.obj);
                } else {
                    b.this.b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, c cVar) {
        f.a("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            cVar.a(1, (String) null);
        } else if (!j.b()) {
            cVar.a(2, (String) null);
        } else {
            c = Environment.getExternalStorageDirectory() + "/tmp/";
            this.d = System.currentTimeMillis();
            this.a = str;
            this.b = cVar;
            new Thread(this.f).start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d A[SYNTHETIC, Splitter:B:22:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[SYNTHETIC, Splitter:B:28:0x0078] */
    public boolean a(Bitmap bitmap, String str) {
        Throwable th;
        IOException e2;
        String str2 = c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
            f.a("AsynLoadImg", "saveFile:" + str);
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                    return true;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return true;
                }
            } catch (IOException e4) {
                e2 = e4;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e2.printStackTrace();
                    f.b("AsynLoadImg", "saveFile bmp fail---", e2);
                    if (bufferedOutputStream != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e2 = e6;
            e2.printStackTrace();
            f.b("AsynLoadImg", "saveFile bmp fail---", e2);
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            return false;
        }
    }

    public static Bitmap a(String str) {
        f.a("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            f.a("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
