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

public class as {
    private static as a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f958a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f959a = new ConcurrentHashMap<>();

    public interface a {
        void a();
    }

    public static class b {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Context f960a;

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f961a = null;

        /* renamed from: a  reason: collision with other field name */
        Messenger f962a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.b f963a = new XMPushService.b(this);

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f964a;

        /* renamed from: a  reason: collision with other field name */
        final C0158b f965a = new C0158b();

        /* renamed from: a  reason: collision with other field name */
        c f966a = c.unbind;

        /* renamed from: a  reason: collision with other field name */
        public d f967a;

        /* renamed from: a  reason: collision with other field name */
        public String f968a;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f969a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        public boolean f970a;
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        public String f971b;

        /* renamed from: b  reason: collision with other field name */
        private boolean f972b = false;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.as$b$b  reason: collision with other inner class name */
        class C0158b extends XMPushService.i {

            /* renamed from: a  reason: collision with other field name */
            String f973a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f974b;
            int c;

            public C0158b() {
                super(0);
            }

            public XMPushService.i a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f974b = str2;
                this.f973a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            /* renamed from: a */
            public String mo344a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            /* renamed from: a  reason: collision with other method in class */
            public void mo631a() {
                if (b.this.a(this.b, this.c, this.f974b)) {
                    b.this.a(this.b, this.c, this.f973a, this.f974b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }
        }

        class c implements IBinder.DeathRecipient {
            final Messenger a;

            /* renamed from: a  reason: collision with other field name */
            final b f975a;

            c(b bVar, Messenger messenger) {
                this.f975a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f975a.g);
                b.this.f964a.a(new au(this, 0), 0);
                if ("9".equals(this.f975a.g) && "com.xiaomi.xmsf".equals(b.this.f964a.getPackageName())) {
                    b.this.f964a.a(new av(this, 0), 60000);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f964a = xMPushService;
            a(new at(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf("/")) != -1) ? str.substring(lastIndexOf + 1) : "";
        }

        /* access modifiers changed from: private */
        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.f966a;
            this.b = cVar;
            if (i2 == 2) {
                this.f967a.a(this.f960a, this, i3);
            } else if (i2 == 3) {
                this.f967a.a(this.f960a, this, str2, str);
            } else if (i2 == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f962a != null) {
                        try {
                            this.f962a.send(Message.obtain(null, 16, this.f964a.f900a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f967a.a(this.f964a, this, z, i3, str);
            }
        }

        /* access modifiers changed from: private */
        public boolean a(int i2, int i3, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.b;
            if (cVar == null || !(z = this.f972b)) {
                return true;
            }
            if (cVar == this.f966a) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.f962a == null || !z) {
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            }
            sb.append(str2);
            sb.append(this.g);
            com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
            return false;
        }

        private boolean b(int i2, int i3, String str) {
            if (i2 == 1) {
                return this.f966a != c.binded && this.f964a.m588c() && i3 != 21 && (i3 != 7 || !"wait".equals(str));
            }
            if (i2 == 2) {
                return this.f964a.m588c();
            }
            if (i2 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.a + 1) * 15))) * 1000;
        }

        public String a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a  reason: collision with other method in class */
        void m630a() {
            try {
                Messenger messenger = this.f962a;
                if (!(messenger == null || this.f961a == null)) {
                    messenger.getBinder().unlinkToDeath(this.f961a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        void a(Messenger messenger) {
            m630a();
            if (messenger != null) {
                try {
                    this.f962a = messenger;
                    this.f972b = true;
                    this.f961a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f961a, 0);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e2.getMessage());
                    this.f962a = null;
                    this.f972b = false;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
            }
        }

        public void a(a aVar) {
            synchronized (this.f969a) {
                this.f969a.add(aVar);
            }
        }

        public void a(c cVar, int i2, int i3, String str, String str2) {
            boolean z;
            synchronized (this.f969a) {
                for (a aVar : this.f969a) {
                    aVar.a(this.f966a, cVar, i3);
                }
            }
            c cVar2 = this.f966a;
            int i4 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m41a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i2), aw.a(i3), str, str2, this.g));
                this.f966a = cVar;
            }
            if (this.f967a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.b != null && (z = this.f972b)) {
                    i4 = (this.f962a == null || !z) ? 10100 : 1000;
                }
                this.f964a.b(this.f965a);
                if (b(i2, i3, str2)) {
                    a(i2, i3, str, str2);
                } else {
                    this.f964a.a(this.f965a.a(i2, i3, str, str2), (long) i4);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f969a) {
                this.f969a.remove(aVar);
            }
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private as() {
    }

    public static synchronized as a() {
        as asVar;
        synchronized (as.class) {
            if (a == null) {
                a = new as();
            }
            asVar = a;
        }
        return asVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m623a() {
        return this.f959a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap = this.f959a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m624a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f959a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m625a(String str) {
        if (!this.f959a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f959a.get(str).clone()).values();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m626a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f959a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f968a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m627a() {
        Iterator<b> it2 = m624a().iterator();
        while (it2.hasNext()) {
            it2.next().m630a();
        }
        this.f959a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f959a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f959a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f958a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f959a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f959a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f971b), bVar);
        for (a aVar : this.f958a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m628a(String str) {
        HashMap<String, b> hashMap = this.f959a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m630a();
            }
            hashMap.clear();
            this.f959a.remove(str);
        }
        for (a aVar : this.f958a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m629a(String str, String str2) {
        HashMap<String, b> hashMap = this.f959a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m630a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f959a.remove(str);
            }
        }
        for (a aVar : this.f958a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f958a.clear();
    }
}
