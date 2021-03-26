package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ab {
    private static volatile ab a;

    /* renamed from: a  reason: collision with other field name */
    private Context f139a;

    /* renamed from: a  reason: collision with other field name */
    private List<v> f140a = new ArrayList();

    private ab(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f139a = applicationContext;
        if (applicationContext == null) {
            this.f139a = context;
        }
    }

    public static ab a(Context context) {
        if (a == null) {
            synchronized (ab.class) {
                if (a == null) {
                    a = new ab(context);
                }
            }
        }
        return a;
    }

    public int a(String str) {
        synchronized (this.f140a) {
            v vVar = new v();
            vVar.f178a = str;
            if (this.f140a.contains(vVar)) {
                for (v vVar2 : this.f140a) {
                    if (vVar2.equals(vVar)) {
                        return vVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(ap apVar) {
        return this.f139a.getSharedPreferences("mipush_extra", 0).getString(apVar.name(), "");
    }

    public synchronized void a(ap apVar, String str) {
        SharedPreferences sharedPreferences = this.f139a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(apVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m57a(String str) {
        synchronized (this.f140a) {
            v vVar = new v();
            vVar.a = 0;
            vVar.f178a = str;
            if (this.f140a.contains(vVar)) {
                this.f140a.remove(vVar);
            }
            this.f140a.add(vVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m58a(String str) {
        synchronized (this.f140a) {
            v vVar = new v();
            vVar.f178a = str;
            return this.f140a.contains(vVar);
        }
    }

    public void b(String str) {
        synchronized (this.f140a) {
            v vVar = new v();
            vVar.f178a = str;
            if (this.f140a.contains(vVar)) {
                Iterator<v> it2 = this.f140a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    v next = it2.next();
                    if (vVar.equals(next)) {
                        vVar = next;
                        break;
                    }
                }
            }
            vVar.a++;
            this.f140a.remove(vVar);
            this.f140a.add(vVar);
        }
    }

    public void c(String str) {
        synchronized (this.f140a) {
            v vVar = new v();
            vVar.f178a = str;
            if (this.f140a.contains(vVar)) {
                this.f140a.remove(vVar);
            }
        }
    }
}
