package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class q {
    private static q a;
    private ConcurrentHashMap<String, HashMap<String, b>> b = new ConcurrentHashMap<>();
    private List<a> c = new ArrayList();

    public interface a {
        void a();
    }

    public static class b {
        public String a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public bb k;
        public Context l;
        c m = c.unbind;
        c n = null;
        Messenger o;
        IBinder.DeathRecipient p = null;
        final C0187b q = new C0187b();
        private int r = 0;
        private List<a> s = new ArrayList();
        private XMPushService t;
        private boolean u = false;
        private XMPushService.b v = new XMPushService.b(this);

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.q$b$b  reason: collision with other inner class name */
        class C0187b extends XMPushService.i {
            int a;
            int b;
            String c;
            String d;

            public C0187b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.a = i;
                this.b = i2;
                this.d = str2;
                this.c = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void a() {
                if (b.this.a(this.a, this.b, this.d)) {
                    b.this.a(this.a, this.b, this.c, this.d);
                    return;
                }
                com.xiaomi.a.a.a.c.b(" ignore notify client :" + b.this.h);
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String b() {
                return "notify job";
            }
        }

        class c implements IBinder.DeathRecipient {
            final b a;
            final Messenger b;

            c(b bVar, Messenger messenger) {
                this.a = bVar;
                this.b = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.a.a.a.c.b("peer died, chid = " + this.a.h);
                b.this.t.a(new s(this, 0), 0);
                if ("9".equals(this.a.h) && "com.xiaomi.xmsf".equals(b.this.t.getPackageName())) {
                    b.this.t.a(new t(this, 0), 60000);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.t = xMPushService;
            a(new r(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf("/")) != -1) ? str.substring(lastIndexOf + 1) : "";
        }

        /* access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.m;
            this.n = cVar;
            if (i2 == 2) {
                this.k.a(this.l, this, i3);
            } else if (i2 == 3) {
                this.k.a(this.l, this, str2, str);
            } else if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.r++;
                } else if (z) {
                    this.r = 0;
                    if (this.o != null) {
                        try {
                            this.o.send(Message.obtain(null, 16, this.t.b));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.k.a(this.t, this, z, i3, str);
            }
        }

        /* access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.n;
            if (cVar == null || !(z = this.u)) {
                return true;
            }
            if (cVar == this.m) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.o == null || !z) {
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            } else {
                com.xiaomi.a.a.a.c.b("Peer alive notify status to client:" + this.h);
                return true;
            }
            sb.append(str2);
            sb.append(this.h);
            com.xiaomi.a.a.a.c.b(sb.toString());
            return false;
        }

        private boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return this.m != c.binded && this.t.f() && i3 != 21 && (i3 != 7 || !"wait".equals(str));
            }
            if (i2 == 2) {
                return this.t.f();
            }
            if (i2 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        void a() {
            try {
                Messenger messenger = this.o;
                if (!(messenger == null || this.p == null)) {
                    messenger.getBinder().unlinkToDeath(this.p, 0);
                }
            } catch (Exception unused) {
            }
            this.n = null;
        }

        void a(Messenger messenger) {
            a();
            if (messenger != null) {
                try {
                    this.o = messenger;
                    this.u = true;
                    this.p = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.p, 0);
                } catch (Exception e2) {
                    com.xiaomi.a.a.a.c.b("peer linkToDeath err: " + e2.getMessage());
                    this.o = null;
                    this.u = false;
                }
            } else {
                com.xiaomi.a.a.a.c.b("peer linked with old sdk chid = " + this.h);
            }
        }

        public void a(a aVar) {
            synchronized (this.s) {
                this.s.add(aVar);
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            synchronized (this.s) {
                for (a aVar : this.s) {
                    aVar.a(this.m, cVar, i3);
                }
            }
            c cVar2 = this.m;
            int i4 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.a.a.a.c.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), u.a(i3), str, str2, this.h));
                this.m = cVar;
            }
            if (this.k == null) {
                com.xiaomi.a.a.a.c.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.n != null && (z = this.u)) {
                    i4 = (this.o == null || !z) ? 10100 : 1000;
                }
                this.t.b(this.q);
                if (b(i2, i3, str2)) {
                    a(i2, i3, str, str2);
                } else {
                    this.t.a(this.q.a(i2, i3, str, str2), (long) i4);
                }
            }
        }

        public long b() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.r + 1) * 15))) * 1000;
        }

        public void b(a aVar) {
            synchronized (this.s) {
                this.s.remove(aVar);
            }
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private q() {
    }

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (a == null) {
                a = new q();
            }
            qVar = a;
        }
        return qVar;
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.c.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.b.get(bVar.h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.b.put(bVar.h, hashMap);
        }
        hashMap.put(d(bVar.b), bVar);
        for (a aVar : this.c) {
            aVar.a();
        }
    }

    public synchronized void a(String str) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.a();
            }
            hashMap.clear();
            this.b.remove(str);
        }
        for (a aVar : this.c) {
            aVar.a();
        }
    }

    public synchronized void a(String str, String str2) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(d(str2));
            if (bVar != null) {
                bVar.a();
            }
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.b.remove(str);
            }
        }
        for (a aVar : this.c) {
            aVar.a();
        }
    }

    public synchronized b b(String str, String str2) {
        HashMap<String, b> hashMap = this.b.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(d(str2));
    }

    public synchronized ArrayList<b> b() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.b.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    public synchronized List<String> b(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.b.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.a)) {
                    arrayList.add(bVar.h);
                }
            }
        }
        return arrayList;
    }

    public synchronized int c() {
        return this.b.size();
    }

    public synchronized Collection<b> c(String str) {
        if (!this.b.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.b.get(str).clone()).values();
    }

    public synchronized void d() {
        Iterator<b> it2 = b().iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.b.clear();
    }

    public synchronized void e() {
        this.c.clear();
    }
}
