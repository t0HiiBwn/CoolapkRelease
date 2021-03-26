package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ag {
    private static volatile ag a;

    /* renamed from: a  reason: collision with other field name */
    private Context f119a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f120a = new ArrayList();

    private ag(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f119a = applicationContext;
        if (applicationContext == null) {
            this.f119a = context;
        }
    }

    public static ag a(Context context) {
        if (a == null) {
            synchronized (ag.class) {
                if (a == null) {
                    a = new ag(context);
                }
            }
        }
        return a;
    }

    public int a(String str) {
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f167a = str;
            if (this.f120a.contains(zVar)) {
                for (z zVar2 : this.f120a) {
                    if (zVar2.equals(zVar)) {
                        return zVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(av avVar) {
        return this.f119a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f119a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m36a(String str) {
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.a = 0;
            zVar.f167a = str;
            if (this.f120a.contains(zVar)) {
                this.f120a.remove(zVar);
            }
            this.f120a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m37a(String str) {
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f167a = str;
            return this.f120a.contains(zVar);
        }
    }

    public void b(String str) {
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f167a = str;
            if (this.f120a.contains(zVar)) {
                Iterator<z> it2 = this.f120a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    z next = it2.next();
                    if (zVar.equals(next)) {
                        zVar = next;
                        break;
                    }
                }
            }
            zVar.a++;
            this.f120a.remove(zVar);
            this.f120a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f167a = str;
            if (this.f120a.contains(zVar)) {
                this.f120a.remove(zVar);
            }
        }
    }
}
