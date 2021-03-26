package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class n {
    public static final long a = System.currentTimeMillis();
    private static n b;
    private Context c;
    private String d = a.b().d;
    private Map<Integer, Map<String, m>> e = new HashMap();
    private SharedPreferences f;

    private n(Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (b == null) {
                b = new n(context);
            }
            nVar = b;
        }
        return nVar;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = b;
        }
        return nVar;
    }

    /* access modifiers changed from: private */
    public synchronized boolean b(int i) {
        try {
            List<m> c2 = c(i);
            if (c2 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (m mVar : c2) {
                if (mVar.b != null && mVar.b.equalsIgnoreCase(this.d) && mVar.d > 0) {
                    arrayList.add(mVar);
                }
                if (mVar.c + 86400000 < currentTimeMillis) {
                    arrayList2.add(mVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() < 2) {
                c2.removeAll(arrayList2);
                a(i, (int) c2);
                return false;
            } else if (arrayList.size() <= 0 || ((m) arrayList.get(arrayList.size() - 1)).c + 86400000 >= currentTimeMillis) {
                return true;
            } else {
                c2.clear();
                a(i, (int) c2);
                return false;
            }
        } catch (Exception unused) {
            x.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final void a(int i, final int i2) {
        w.a().a(new Runnable(1004) {
            /* class com.tencent.bugly.proguard.n.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                m mVar;
                try {
                    if (!TextUtils.isEmpty(n.this.d)) {
                        List<m> c2 = n.this.c(1004);
                        if (c2 == null) {
                            c2 = new ArrayList();
                        }
                        if (n.this.e.get(Integer.valueOf(1004)) == null) {
                            n.this.e.put(Integer.valueOf(1004), new HashMap());
                        }
                        if (((Map) n.this.e.get(Integer.valueOf(1004))).get(n.this.d) == null) {
                            mVar = new m();
                            mVar.a = (long) 1004;
                            mVar.g = n.a;
                            mVar.b = n.this.d;
                            mVar.f = a.b().k;
                            mVar.e = a.b().f;
                            mVar.c = System.currentTimeMillis();
                            mVar.d = i2;
                            ((Map) n.this.e.get(Integer.valueOf(1004))).put(n.this.d, mVar);
                        } else {
                            mVar = (m) ((Map) n.this.e.get(Integer.valueOf(1004))).get(n.this.d);
                            mVar.d = i2;
                        }
                        ArrayList arrayList = new ArrayList();
                        boolean z = false;
                        for (m mVar2 : c2) {
                            if (mVar2.g == mVar.g && mVar2.b != null && mVar2.b.equalsIgnoreCase(mVar.b)) {
                                z = true;
                                mVar2.d = mVar.d;
                            }
                            if (!(mVar2.e == null || mVar2.e.equalsIgnoreCase(mVar.e)) || (!(mVar2.f == null || mVar2.f.equalsIgnoreCase(mVar.f)) || mVar2.d <= 0)) {
                                arrayList.add(mVar2);
                            }
                        }
                        c2.removeAll(arrayList);
                        if (!z) {
                            c2.add(mVar);
                        }
                        n.this.a(1004, (int) c2);
                    }
                } catch (Exception unused) {
                    x.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r6 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        if (r6 != null) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0058  */
    public synchronized <T extends List<?>> T c(int i) {
        ObjectInputStream objectInputStream;
        Throwable th;
        try {
            File dir = this.c.getDir("crashrecord", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            File file = new File(dir, sb.toString());
            if (!file.exists()) {
                return null;
            }
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                try {
                    T t = (T) ((List) objectInputStream.readObject());
                    objectInputStream.close();
                    return t;
                } catch (IOException unused) {
                    x.a("open record file error", new Object[0]);
                } catch (ClassNotFoundException unused2) {
                    try {
                        x.a("get object error", new Object[0]);
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException unused3) {
                objectInputStream = null;
                x.a("open record file error", new Object[0]);
            } catch (ClassNotFoundException unused4) {
                objectInputStream = null;
                x.a("get object error", new Object[0]);
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused5) {
            x.e("readCrashRecord error", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    public synchronized <T extends List<?>> void a(int i, T t) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        IOException e2;
        if (t != null) {
            try {
                File dir = this.c.getDir("crashrecord", 0);
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(dir, sb.toString())));
                    try {
                        objectOutputStream.writeObject(t);
                        objectOutputStream.close();
                    } catch (IOException e3) {
                        e2 = e3;
                        try {
                            e2.printStackTrace();
                            x.a("open record file error", new Object[0]);
                            if (objectOutputStream == null) {
                                objectOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw th;
                        }
                    }
                } catch (IOException e4) {
                    objectOutputStream = null;
                    e2 = e4;
                    e2.printStackTrace();
                    x.a("open record file error", new Object[0]);
                    if (objectOutputStream == null) {
                    }
                } catch (Throwable th3) {
                    objectOutputStream = null;
                    th = th3;
                    if (objectOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused) {
                x.e("writeCrashRecord error", new Object[0]);
            }
            return;
        }
        return;
    }

    public final synchronized boolean a(final int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f;
            z = sharedPreferences.getBoolean(i + "_" + this.d, true);
            w.a().a(new Runnable() {
                /* class com.tencent.bugly.proguard.n.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    boolean b2 = n.this.b(i);
                    SharedPreferences.Editor edit = n.this.f.edit();
                    edit.putBoolean(i + "_" + n.this.d, !b2).commit();
                }
            });
        } catch (Exception unused) {
            x.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
