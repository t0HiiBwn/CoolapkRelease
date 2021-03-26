package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import com.amap.api.mapcore2d.eb;
import com.amap.api.mapcore2d.ee;
import com.amap.api.mapcore2d.et;
import java.io.File;
import java.io.RandomAccessFile;

/* compiled from: DexDownLoad */
public class dz implements et.a {
    protected ea a;
    protected da b;
    protected String c;
    protected RandomAccessFile d;
    protected Context e;
    private et f;

    @Override // com.amap.api.mapcore2d.et.a
    public void b() {
    }

    /* compiled from: DexDownLoad */
    class a implements Runnable {
        private int b;
        private dt c;
        private String d;

        a(int i) {
            this.b = i;
        }

        a(dt dtVar, int i) {
            this.b = i;
            this.c = dtVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.b;
            if (i == 0) {
                try {
                    if (dz.this.d()) {
                        ff ffVar = new ff(dz.this.e, dz.this.b.a(), dz.this.b.b(), "O008");
                        ffVar.a("{\"param_int_first\":0}");
                        fg.a(ffVar, dz.this.e);
                        dz.this.f.a(dz.this);
                    }
                } catch (Throwable th) {
                    eh.a(th, "dDownLoad", "run()");
                }
            } else if (i == 1 || i == 2) {
                try {
                    eb.a(dz.this.e, this.c, dz.this.b, dz.this.c, dz.this.a.e);
                    eb.a(dz.this.e, dz.this.b);
                } catch (Throwable th2) {
                    eh.a(th2, "dDownLoad", "onFinish2");
                }
            } else if (i == 3) {
                try {
                    eb.a(dz.this.e, this.c, dz.this.b, dz.this.c, this.d);
                    eb.a(dz.this.e, dz.this.b);
                } catch (Throwable th3) {
                    eh.a(th3, "dDownLoad", "processDownloadedFile()");
                }
            }
        }
    }

    public dz(Context context, ea eaVar, da daVar) {
        try {
            this.e = context.getApplicationContext();
            this.b = daVar;
            if (eaVar != null) {
                this.a = eaVar;
                this.f = new et(new ej(eaVar));
                this.c = eb.a(context, this.a.b);
            }
        } catch (Throwable th) {
            eh.a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    public void a() {
        try {
            eg.b().a().submit(new a(0));
        } catch (Throwable th) {
            eh.a(th, "dDownLoad", "startDownload()");
        }
    }

    boolean d() {
        ea eaVar = this.a;
        boolean z = eaVar != null && eaVar.d();
        try {
            if (db.b(this.e) || !eh.a(this.b, this.a) || !eh.a(this.a) || !eh.a(this.e, z) || eh.a(this.e, this.a, this.b) || !eh.a(this.e, this.b, this.a)) {
                return false;
            }
            eb.b(this.e, this.b.a());
            return true;
        } catch (Throwable th) {
            eh.a(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    @Override // com.amap.api.mapcore2d.et.a
    public void a(byte[] bArr, long j) {
        try {
            if (this.d == null) {
                File file = new File(this.c);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.d = new RandomAccessFile(file, "rw");
            }
            this.d.seek(j);
            this.d.write(bArr);
        } catch (Throwable th) {
            eh.a(th, "dDownLoad", "onDownload()");
        }
    }

    @Override // com.amap.api.mapcore2d.et.a
    public void a(Throwable th) {
        try {
            eh.a(this.d);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore2d.et.a
    public void c() {
        try {
            RandomAccessFile randomAccessFile = this.d;
            if (randomAccessFile != null) {
                eh.a(randomAccessFile);
                String b2 = this.a.b();
                if (eh.b(this.c, b2)) {
                    a(b2);
                    ff ffVar = new ff(this.e, this.b.a(), this.b.b(), "O008");
                    ffVar.a("{\"param_int_first\":1}");
                    fg.a(ffVar, this.e);
                    return;
                }
                try {
                    new File(this.c).delete();
                } catch (Throwable th) {
                    eh.a(th, "dDownLoad", "onFinish");
                }
            }
        } catch (Throwable th2) {
            eh.a(th2, "dDownLoad", "onFinish()");
        }
    }

    private void a(String str) {
        String c2 = this.a.c();
        dt dtVar = new dt(this.e, ed.c());
        eb.a.a(dtVar, new ee.a(this.a.b, str, this.a.c, c2, this.a.e).a("copy").a(), ee.a(this.a.b, this.a.c, c2, this.a.e));
        a(this.e, this.a.c);
        try {
            eg.b().a().submit(new a(dtVar, 2));
        } catch (Throwable th) {
            eh.a(th, "dDownLoad", "onFinish1");
        }
    }

    private void a(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.commit();
        } catch (Throwable th) {
            eh.a(th, "dDownLoad", "clearMarker()");
        }
    }
}
