package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore2d.et;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

@Deprecated
/* compiled from: SDKCoordinatorDownload */
public class cz extends Thread implements et.a {
    protected static boolean g = false;
    private static String i = "sodownload";
    private static String j = "sofail";
    protected a a;
    protected RandomAccessFile b;
    protected String c;
    protected String d;
    protected String e;
    protected Context f;
    private et h;

    public cz(Context context, String str, String str2, String str3) {
        this.f = context;
        this.e = str3;
        this.c = a(context, str + "temp.so");
        this.d = a(context, "libwgs2gcj.so");
        a aVar = new a(str2);
        this.a = aVar;
        this.h = new et(aVar);
    }

    public static String a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    private static String b(Context context, String str) {
        return a(context, str);
    }

    public void a() {
        a aVar = this.a;
        if (aVar != null && !TextUtils.isEmpty(aVar.h()) && this.a.h().contains("libJni_wgs2gcj.so") && this.a.h().contains(db.a(this.f)) && !new File(this.d).exists()) {
            start();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            File file = new File(b(this.f, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.h.a(this);
        } catch (Throwable th) {
            Cdo.c(th, "sdl", "run");
            d();
        }
    }

    @Override // com.amap.api.mapcore2d.et.a
    public void a(byte[] bArr, long j2) {
        try {
            if (this.b == null) {
                File file = new File(this.c);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    this.b = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e2) {
                    Cdo.c(e2, "sdl", "oDd");
                    d();
                }
            }
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.seek(j2);
                    this.b.write(bArr);
                } catch (IOException e3) {
                    d();
                    Cdo.c(e3, "sdl", "oDd");
                }
            }
        } catch (Throwable th) {
            d();
            Cdo.c(th, "sdl", "oDd");
        }
    }

    @Override // com.amap.api.mapcore2d.et.a
    public void b() {
        d();
    }

    @Override // com.amap.api.mapcore2d.et.a
    public void c() {
        try {
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            String a2 = cx.a(this.c);
            if (a2 == null || !a2.equalsIgnoreCase(this.e)) {
                d();
            } else if (new File(this.d).exists()) {
                d();
            } else {
                new File(this.c).renameTo(new File(this.d));
            }
        } catch (Throwable th) {
            d();
            File file = new File(this.d);
            if (file.exists()) {
                file.delete();
            }
            Cdo.c(th, "sdl", "ofs");
        }
    }

    @Override // com.amap.api.mapcore2d.et.a
    public void a(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            d();
            File file = new File(b(this.f, "tempfile"));
            if (!file.exists()) {
                try {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdir();
                    }
                    file.createNewFile();
                } catch (Throwable th2) {
                    Cdo.c(th2, "sdl", "oe");
                }
            }
        } catch (Throwable th3) {
            Cdo.c(th3, "sdl", "oe");
        }
    }

    protected void d() {
        File file = new File(this.c);
        if (file.exists()) {
            file.delete();
        }
    }

    /* compiled from: SDKCoordinatorDownload */
    public static class a extends ew {
        private String a;

        @Override // com.amap.api.mapcore2d.ew
        public Map<String, String> f() {
            return null;
        }

        @Override // com.amap.api.mapcore2d.ew
        public Map<String, String> g() {
            return null;
        }

        a(String str) {
            this.a = str;
        }

        @Override // com.amap.api.mapcore2d.ew
        public String h() {
            return this.a;
        }
    }
}
