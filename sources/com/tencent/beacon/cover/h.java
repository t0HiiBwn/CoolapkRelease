package com.tencent.beacon.cover;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: VersionCheck */
public final class h implements Runnable {
    public static String a;
    public static String b;
    private static h e;
    private Context c;
    private List<a> d = new ArrayList();

    public static h a(Context context) {
        if (e == null) {
            e = new h(context);
        }
        return e;
    }

    private h(Context context) {
        if (context == null) {
            g.a("W", "context is null!", new Object[0]);
        } else {
            this.c = context.getApplicationContext();
        }
    }

    private boolean a(long j) {
        long j2;
        try {
            j2 = Long.valueOf(g.b(this.c, "LAST_UPDATE_TIME", "0")).longValue();
        } catch (Exception unused) {
            j2 = 0;
        }
        return j - j2 > 86400000;
    }

    private List<String> b() {
        File[] listFiles;
        File file = new File(this.c.getFilesDir(), "beacon/comp");
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            arrayList.add(file2.getName() + "," + file2.length() + "," + g.a(file2));
        }
        return arrayList;
    }

    final List<a> a() {
        return this.d;
    }

    private void a(a aVar) {
        int i = 0;
        while (true) {
            if (i >= this.d.size()) {
                i = -1;
                break;
            } else if (aVar.a == this.d.get(i).a) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            this.d.remove(i);
        }
        this.d.add(aVar);
    }

    private static long a(String str) {
        try {
            return Long.parseLong(str.replaceAll("\\.", ""));
        } catch (Exception unused) {
            return 0;
        }
    }

    private List<a> a(List<a> list) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            boolean z = false;
            boolean z2 = false;
            for (a aVar2 : this.d) {
                if (aVar.a == aVar2.a) {
                    if (a(aVar.b) > a(aVar2.b)) {
                        z = true;
                    }
                    z2 = true;
                }
            }
            if (z || !z2) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private String c() {
        List<a> a2 = a(g.a(g.b(this.c, "beaconcomp" + File.separator + "comp_list")));
        byte[] bArr = new byte[2048];
        String str = this.c.getFilesDir().getAbsolutePath() + File.separator + "beacon/comp";
        a aVar = null;
        a aVar2 = null;
        for (a aVar3 : a2) {
            String str2 = "beaconcomp" + File.separator + aVar3.d;
            if (aVar3.c == g.b) {
                aVar3.d += ".jar";
                if (g.a(this.c, str2, str, aVar3.d, (long) aVar3.f, bArr)) {
                    a(aVar3);
                }
            }
            if (aVar3.c == g.c) {
                if (g.b().equals(aVar3.h)) {
                    aVar = aVar3;
                }
                if ("armeabi".equals(aVar3.h)) {
                    aVar2 = aVar3;
                }
            }
        }
        if (aVar == null) {
            aVar = aVar2;
        }
        if (aVar != null) {
            String str3 = "beaconcomp" + File.separator + aVar.d;
            aVar.d = aVar.d.substring(0, aVar.d.lastIndexOf("."));
            if (g.a(this.c, str3, str, aVar.d, (long) aVar.f, bArr)) {
                a(aVar);
            }
        }
        if (a2.size() <= 0) {
            return "";
        }
        String a3 = g.a(this.d);
        g.a(this.c, "COMP_INFO", a3);
        return a3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        if (this.c.getFilesDir() != null && d.a(this.c).a("check")) {
            File file = new File(this.c.getFilesDir(), "beacon/comp");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.c.getFilesDir(), "beacon/odex");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String c2 = g.c(this.c);
            if (!g.b(this.c, "APP_VER", "").equals(c2)) {
                c();
                g.a(this.c, "APP_VER", c2);
            }
            List<a> a2 = g.a(g.b(this.c, "COMP_INFO", ""));
            boolean z3 = false;
            if (a2.size() == 0) {
                g.a("W", "comp config has error!", new Object[0]);
            }
            List<String> b2 = b();
            if (b2 == null || b2.size() == 0) {
                g.a("W", "local comps has error!", new Object[0]);
                z = true;
            } else {
                z = true;
                for (a aVar : a2) {
                    if (!(aVar == null || aVar.c == g.c)) {
                        Iterator<String> it2 = b2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z2 = false;
                                break;
                            }
                            String[] split = it2.next().split(",");
                            if (split.length == 3 && aVar.d.equals(split[0]) && String.valueOf(aVar.f).equals(split[1]) && aVar.g.equals(split[2])) {
                                this.d.add(aVar);
                                z2 = true;
                                break;
                            }
                        }
                        if (!z2) {
                            g.a("W", "the config is not match local comp!", new Object[0]);
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                g.a("W", "start thread to load component.", new Object[0]);
                new Thread(b.a(this.c, this.d)).start();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!z || a(currentTimeMillis)) {
                z3 = true;
            }
            if (z3) {
                new Thread(new i(this.c, this.d)).start();
                g.a(this.c, "LAST_UPDATE_TIME", String.valueOf(currentTimeMillis));
            }
            d.a(this.c).b("check");
        }
    }
}
