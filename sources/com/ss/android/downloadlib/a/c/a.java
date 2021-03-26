package com.ss.android.downloadlib.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.a.c.c;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.f.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AidlClient */
public class a {
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static volatile a g;
    public c a;
    public final List<AbstractC0082a> b = new ArrayList();
    public final Object c = new Object();
    private boolean h = true;
    private boolean i = false;
    private volatile boolean j = false;
    private Context k;

    /* renamed from: l  reason: collision with root package name */
    private final List<Pair<b, d>> f1401l = new ArrayList();
    private final ServiceConnection m = new ServiceConnection() {
        /* class com.ss.android.downloadlib.a.c.a.AnonymousClass1 */

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                for (AbstractC0082a aVar : a.this.b) {
                    aVar.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.c) {
                a.this.a(false);
                a.this.a = null;
                for (AbstractC0082a aVar : a.this.b) {
                    aVar.b();
                }
            }
        }
    };
    private String n = "";

    /* renamed from: com.ss.android.downloadlib.a.c.a$a  reason: collision with other inner class name */
    /* compiled from: AidlClient */
    public interface AbstractC0082a {
        void a();

        void b();
    }

    private a() {
    }

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
            }
        }
        return g;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(d)) {
            JSONObject i2 = k.i();
            String optString = i2.optString("s");
            d = b.a(i2.optString("q"), optString);
            e = b.a(i2.optString("u"), optString);
            f = b.a(i2.optString("w"), optString);
        }
        this.i = z;
        if (context == null) {
            return true;
        }
        this.k = context.getApplicationContext();
        if (TextUtils.isEmpty(f)) {
            f = this.k.getPackageName();
        }
        if (this.a != null || d()) {
            return true;
        }
        return this.k.bindService(a(context), this.m, 33);
    }

    public void b() {
        if (this.a != null) {
            this.k.unbindService(this.m);
            this.a = null;
        }
        this.b.clear();
        this.f1401l.clear();
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.c) {
            bVar.e = f;
            if (TextUtils.isEmpty(bVar.f)) {
                bVar.f = this.n;
            }
            c cVar = this.a;
            if (cVar != null) {
                try {
                    cVar.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.k, this.i)) {
                this.f1401l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void c() {
        for (Pair<b, d> pair : this.f1401l) {
            try {
                this.a.a((b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f1401l.clear();
    }

    public boolean d() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }
}
