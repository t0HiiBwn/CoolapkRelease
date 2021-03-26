package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hh;
import com.xiaomi.push.service.an;
import java.util.HashMap;
import java.util.Map;

public class e implements AbstractPushManager {
    private static volatile e a;

    /* renamed from: a  reason: collision with other field name */
    private Context f169a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f170a;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f171a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private boolean f172a = false;

    private e(Context context) {
        this.f169a = context.getApplicationContext();
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
        PushConfiguration pushConfiguration = this.f170a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f170a.getOpenHmsPush() + " HW online switch : " + h.m95a(this.f169a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ac.HUAWEI.equals(m.a(this.f169a)));
                b.m41a(sb.toString());
            }
            if (this.f170a.getOpenHmsPush() && h.m95a(this.f169a, d.ASSEMBLE_PUSH_HUAWEI) && ac.HUAWEI.equals(m.a(this.f169a))) {
                if (!m91a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, ag.a(this.f169a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                b.c("hw manager add to list");
            } else if (m91a(d.ASSEMBLE_PUSH_HUAWEI) && (a5 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m90a(d.ASSEMBLE_PUSH_HUAWEI);
                a5.unregister();
            }
            if (this.f170a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f170a.getOpenFCMPush() + " FCM online switch : " + h.m95a(this.f169a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m98a(this.f169a));
                b.m41a(sb2.toString());
            }
            if (this.f170a.getOpenFCMPush() && h.m95a(this.f169a, d.ASSEMBLE_PUSH_FCM) && m.m98a(this.f169a)) {
                if (!m91a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, ag.a(this.f169a, d.ASSEMBLE_PUSH_FCM));
                }
                b.c("fcm manager add to list");
            } else if (m91a(d.ASSEMBLE_PUSH_FCM) && (a4 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m90a(d.ASSEMBLE_PUSH_FCM);
                a4.unregister();
            }
            if (this.f170a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f170a.getOpenCOSPush() + " COS online switch : " + h.m95a(this.f169a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f169a));
                b.m41a(sb3.toString());
            }
            if (this.f170a.getOpenCOSPush() && h.m95a(this.f169a, d.ASSEMBLE_PUSH_COS) && m.b(this.f169a)) {
                a(d.ASSEMBLE_PUSH_COS, ag.a(this.f169a, d.ASSEMBLE_PUSH_COS));
            } else if (m91a(d.ASSEMBLE_PUSH_COS) && (a3 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m90a(d.ASSEMBLE_PUSH_COS);
                a3.unregister();
            }
            if (this.f170a.getOpenFTOSPush() && h.m95a(this.f169a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f169a)) {
                a(d.ASSEMBLE_PUSH_FTOS, ag.a(this.f169a, d.ASSEMBLE_PUSH_FTOS));
            } else if (m91a(d.ASSEMBLE_PUSH_FTOS) && (a2 = a(d.ASSEMBLE_PUSH_FTOS)) != null) {
                m90a(d.ASSEMBLE_PUSH_FTOS);
                a2.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f171a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f170a = pushConfiguration;
        this.f172a = an.a(this.f169a).a(hh.AggregatePushSwitch.a(), true);
        if (this.f170a.getOpenHmsPush() || this.f170a.getOpenFCMPush() || this.f170a.getOpenCOSPush()) {
            an.a(this.f169a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m90a(d dVar) {
        this.f171a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f171a.containsKey(dVar)) {
                this.f171a.remove(dVar);
            }
            this.f171a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m91a(d dVar) {
        return this.f171a.containsKey(dVar);
    }

    public boolean b(d dVar) {
        int i = g.a[dVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f170a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i != 2) {
            if (i == 3) {
                PushConfiguration pushConfiguration2 = this.f170a;
                if (pushConfiguration2 != null) {
                    z = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f170a;
            return pushConfiguration3 != null ? pushConfiguration3.getOpenFTOSPush() : z;
        } else {
            PushConfiguration pushConfiguration4 = this.f170a;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
            return false;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        b.m41a("ASSEMBLE_PUSH : assemble push register");
        if (this.f171a.size() <= 0) {
            a();
        }
        if (this.f171a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f171a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m92a(this.f169a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        b.m41a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f171a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f171a.clear();
    }
}
