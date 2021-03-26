package com.tencent.beacon.core.d;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: RootUtil */
public final class e {
    private static e b;
    private boolean a = false;

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e();
            }
            eVar = b;
        }
        return eVar;
    }

    protected e() {
        boolean z = true;
        this.a = true;
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            z = false;
        } else {
            b.b("[core] test-keys}", new Object[0]);
        }
        if (!z && !c() && !d()) {
            this.a = false;
        }
    }

    public final synchronized boolean b() {
        return this.a;
    }

    private static boolean c() {
        try {
            if (!new File("/system/app/Superuser.apk").exists()) {
                return false;
            }
            b.b("[core] super_apk}", new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean d() {
        ArrayList<String> e = e();
        if (e == null || e.size() <= 0) {
            b.b("[core] no response}", new Object[0]);
            return false;
        }
        Iterator<String> it2 = e.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            b.b(next, new Object[0]);
            if (next.contains("not found")) {
                return false;
            }
        }
        b.b("[core] sufile}", new Object[0]);
        return true;
    }

    private static ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "-c", "type su"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 == null) {
                    return arrayList;
                }
                arrayList.add(readLine2);
            }
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }
}
