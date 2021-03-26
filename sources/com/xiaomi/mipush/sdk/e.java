package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.gn;
import com.xiaomi.push.service.l;
import java.util.HashMap;
import java.util.Map;

public class e implements AbstractPushManager {
    private static volatile e a;

    /* renamed from: a  reason: collision with other field name */
    private Context f151a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f152a;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f153a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private boolean f154a = false;

    private e(Context context) {
        this.f151a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        PushConfiguration pushConfiguration = this.f152a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f152a.getOpenHmsPush() + " HW online switch : " + h.m74a(this.f151a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f151a)));
                c.a(sb.toString());
            }
            if (this.f152a.getOpenHmsPush() && h.m74a(this.f151a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f151a))) {
                if (!m70a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f151a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                c.c("hw manager add to list");
            } else if (m70a(d.ASSEMBLE_PUSH_HUAWEI) && (a5 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m69a(d.ASSEMBLE_PUSH_HUAWEI);
                a5.unregister();
            }
            if (this.f152a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f152a.getOpenFCMPush() + " FCM online switch : " + h.m74a(this.f151a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m77a(this.f151a));
                c.a(sb2.toString());
            }
            if (this.f152a.getOpenFCMPush() && h.m74a(this.f151a, d.ASSEMBLE_PUSH_FCM) && m.m77a(this.f151a)) {
                if (!m70a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f151a, d.ASSEMBLE_PUSH_FCM));
                }
                c.c("fcm manager add to list");
            } else if (m70a(d.ASSEMBLE_PUSH_FCM) && (a4 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m69a(d.ASSEMBLE_PUSH_FCM);
                a4.unregister();
            }
            if (this.f152a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f152a.getOpenCOSPush() + " COS online switch : " + h.m74a(this.f151a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f151a));
                c.a(sb3.toString());
            }
            if (this.f152a.getOpenCOSPush() && h.m74a(this.f151a, d.ASSEMBLE_PUSH_COS) && m.b(this.f151a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f151a, d.ASSEMBLE_PUSH_COS));
            } else if (m70a(d.ASSEMBLE_PUSH_COS) && (a3 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m69a(d.ASSEMBLE_PUSH_COS);
                a3.unregister();
            }
            if (this.f152a.getOpenFTOSPush() && h.m74a(this.f151a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f151a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f151a, d.ASSEMBLE_PUSH_FTOS));
            } else if (m70a(d.ASSEMBLE_PUSH_FTOS) && (a2 = a(d.ASSEMBLE_PUSH_FTOS)) != null) {
                m69a(d.ASSEMBLE_PUSH_FTOS);
                a2.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f153a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f152a = pushConfiguration;
        this.f154a = l.a(this.f151a).a(gn.AggregatePushSwitch.a(), true);
        if (this.f152a.getOpenHmsPush() || this.f152a.getOpenFCMPush() || this.f152a.getOpenCOSPush()) {
            l.a(this.f151a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m69a(d dVar) {
        this.f153a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f153a.containsKey(dVar)) {
                this.f153a.remove(dVar);
            }
            this.f153a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m70a(d dVar) {
        return this.f153a.containsKey(dVar);
    }

    public boolean b(d dVar) {
        int i = g.a[dVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f152a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i != 2) {
            if (i == 3) {
                PushConfiguration pushConfiguration2 = this.f152a;
                if (pushConfiguration2 != null) {
                    z = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f152a;
            return pushConfiguration3 != null ? pushConfiguration3.getOpenFTOSPush() : z;
        } else {
            PushConfiguration pushConfiguration4 = this.f152a;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
            return false;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        c.a("ASSEMBLE_PUSH : assemble push register");
        if (this.f153a.size() <= 0) {
            a();
        }
        if (this.f153a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f153a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m71a(this.f151a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        c.a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f153a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f153a.clear();
    }
}
