package com.kepler.sdk;

import android.os.Process;
import com.jd.kepler.res.ApkResources;
import com.kepler.jd.login.KeplerApiManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class q {
    private r a;
    private String b;
    private t c;
    private Thread d;
    private s e;
    private u f;
    private int g;
    private a h;

    interface a {
        boolean a(int i);
    }

    public a a() {
        if (this.h == null) {
            this.h = d();
        }
        return this.h;
    }

    private a d() {
        return new a() {
            /* class com.kepler.sdk.q.AnonymousClass1 */
            int[] a = {-1002, -1100};

            @Override // com.kepler.sdk.q.a
            public boolean a(int i) {
                int[] iArr = this.a;
                if (iArr == null) {
                    return true;
                }
                for (int i2 : iArr) {
                    if (i2 == i) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    private q(r rVar) {
        this.g = -1;
        this.a = rVar;
    }

    public q(r rVar, String str, int i, t tVar) {
        this(rVar);
        this.g = i;
        this.b = str;
        this.c = tVar;
    }

    public void a(s sVar) {
        t tVar = this.c;
        if (tVar != null) {
            tVar.a(sVar);
        }
    }

    public void a(int i, String str) {
        b(i, str);
        t tVar = this.c;
        if (tVar != null) {
            tVar.a(i, str);
        }
    }

    private void b(int i, String str) {
        try {
            if (a().a(i)) {
                this.b.replaceAll(" ", "_");
            }
        } catch (Throwable th) {
            j.a(th);
        }
    }

    public void b() {
        try {
            Thread thread = this.d;
            if (thread != null) {
                thread.destroy();
            }
            u uVar = this.f;
            if (uVar != null) {
                uVar.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = null;
    }

    public void c() {
        if (!ad.a(KeplerApiManager.getWebViewService().getApplicatonContext())) {
            a(-1100, ApkResources.getSingleton().getString("kepler_check_net"));
            return;
        }
        AnonymousClass2 r1 = new Runnable() {
            /* class com.kepler.sdk.q.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (q.this.g > 0) {
                    Process.setThreadPriority(q.this.g);
                }
                try {
                    if (i.q) {
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    j.a(e);
                }
                try {
                    q.this.f = new u();
                    q qVar = q.this;
                    qVar.e = qVar.f.a(q.this.a);
                    int a2 = q.this.e.a();
                    if (a2 != 200) {
                        q qVar2 = q.this;
                        qVar2.a(-1010, "response not 200 " + a2);
                        if (q.this.f != null) {
                            try {
                                q.this.f.a();
                                return;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (af.a(q.this.e.b())) {
                        q qVar3 = q.this;
                        qVar3.a(-1011, "response string null " + a2);
                        if (q.this.f != null) {
                            try {
                                q.this.f.a();
                                return;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        q qVar4 = q.this;
                        qVar4.a(qVar4.e);
                        if (q.this.f != null) {
                            try {
                                q.this.f.a();
                                return;
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (KeyManagementException e2) {
                    j.a(e2);
                    q.this.a(-1002, e2.getMessage());
                    if (q.this.f != null) {
                        q.this.f.a();
                        return;
                    }
                    return;
                } catch (UnsupportedEncodingException e3) {
                    j.a(e3);
                    q.this.a(-1000, e3.getMessage());
                    if (q.this.f != null) {
                        q.this.f.a();
                        return;
                    }
                    return;
                } catch (NoSuchAlgorithmException e4) {
                    j.a(e4);
                    q.this.a(-1003, e4.getMessage());
                    if (q.this.f != null) {
                        q.this.f.a();
                        return;
                    }
                    return;
                } catch (IOException e5) {
                    j.a(e5);
                    q.this.a(-1002, e5.getMessage());
                    if (q.this.f != null) {
                        q.this.f.a();
                        return;
                    }
                    return;
                } catch (Exception e6) {
                    try {
                        j.a(e6);
                        q.this.a(-1011, e6.getMessage());
                        if (q.this.f != null) {
                            q.this.f.a();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                throw th;
            }
        };
        String str = this.b;
        if (str == null) {
            str = "";
        }
        Thread thread = new Thread(r1, str);
        this.d = thread;
        thread.start();
    }
}
