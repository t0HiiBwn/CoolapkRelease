package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.b.f;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.c.a;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.core.event.TunnelModule;
import java.util.Calendar;
import java.util.Map;

public class ModuleImpl extends c implements f {
    private static ModuleImpl mInstance;
    private Context context;
    private int maxQIMEIQueryOneDay = 1;
    private Runnable queryTask = new Runnable() {
        /* class com.tencent.beacon.qimei.ModuleImpl.AnonymousClass1 */

        @Override // java.lang.Runnable
        public final void run() {
            b.b("[qimei] start query qimei", new Object[0]);
            i.a(ModuleImpl.this.context).a(new b(ModuleImpl.this.context, com.tencent.beacon.core.b.b.a(ModuleImpl.this.context).a(), new a.AbstractC0139a() {
                /* class com.tencent.beacon.qimei.ModuleImpl.AnonymousClass1.AnonymousClass1 */

                @Override // com.tencent.beacon.core.c.a.AbstractC0139a
                public final void a(boolean z) {
                    b.b("[qimei] query qimei finish, result: " + z, new Object[0]);
                    if (z) {
                        com.tencent.beacon.core.a.b.a().a(112, false);
                        QimeiUtil.incGenQIMEITimes(ModuleImpl.this.context);
                        com.tencent.beacon.core.a.b.a().a(new Runnable() {
                            /* class com.tencent.beacon.qimei.ModuleImpl.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public final void run() {
                                TunnelModule.doUploadRecentCommonData(true);
                            }
                        });
                    }
                }
            }));
        }
    };

    public ModuleImpl(Context context2) {
        super(context2);
        this.context = context2;
        d.a(context2).a(this);
    }

    public static synchronized ModuleImpl getInstance(Context context2) {
        ModuleImpl moduleImpl;
        synchronized (ModuleImpl.class) {
            if (mInstance == null) {
                mInstance = new ModuleImpl(context2);
            }
            moduleImpl = mInstance;
        }
        return moduleImpl;
    }

    @Override // com.tencent.beacon.core.c
    public void onSDKInit(Context context2) {
        super.onSDKInit(context2);
        startQueryQimei();
    }

    public void startQueryQimei() {
        try {
            boolean isUpdateQIMEI = isUpdateQIMEI();
            if (isUpdateQIMEI && QimeiUtil.isMaxGenToday(this.context)) {
                isUpdateQIMEI = false;
            }
            if ("".equals(a.a(this.context).b())) {
                isUpdateQIMEI = true;
            }
            b.b("[module] QIMEI query module > %S", Boolean.valueOf(isUpdateQIMEI));
            if (isUpdateQIMEI && !isQIMEIReqZeroPeak()) {
                com.tencent.beacon.core.a.b.a().a(112, this.queryTask, 0, 60000);
            }
        } catch (Exception unused) {
            b.d("[qimei] save GEN_QIMEI flag failed! ", new Object[0]);
        }
    }

    public boolean isUpdateQIMEI() {
        Map<String, String> d = com.tencent.beacon.core.strategy.a.a().d();
        if (d != null) {
            String str = d.get("updateQimei");
            if (str != null && "n".equalsIgnoreCase(str)) {
                return false;
            }
            if (str == null || "y".equalsIgnoreCase(str)) {
            }
        }
        return true;
    }

    public boolean isQIMEIReqZeroPeak() {
        String str;
        Map<String, String> d = com.tencent.beacon.core.strategy.a.a().d();
        return d != null && (str = d.get("qimeiZeroPeak")) != null && "y".equalsIgnoreCase(str) && Calendar.getInstance().get(11) == 0;
    }

    public int getMaxQIMEIQueryOneDay() {
        String str;
        Map<String, String> d = com.tencent.beacon.core.strategy.a.a().d();
        if (d == null || (str = d.get("maxQIMEIQueryOneDay")) == null || str.trim().equals("")) {
            return this.maxQIMEIQueryOneDay;
        }
        int i = this.maxQIMEIQueryOneDay;
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.tencent.beacon.core.b.f
    public String getQimei() {
        return a.a(this.context).a();
    }

    @Override // com.tencent.beacon.core.b.f
    public void updateQimei(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                com.tencent.beacon.core.wup.a aVar = new com.tencent.beacon.core.wup.a(bArr);
                QimeiPackage qimeiPackage = new QimeiPackage();
                qimeiPackage.readFrom(aVar);
                if (!g.a(qimeiPackage.qimei)) {
                    a.a(this.context).a(qimeiPackage.qimei);
                    QimeiUtil.saveQIMEI(this.context, qimeiPackage.qimei);
                }
                b.h("[qimei] update Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s by server.", qimeiPackage.qimei, qimeiPackage.imei, qimeiPackage.imsi, qimeiPackage.androidId, qimeiPackage.mac);
            } catch (Throwable th) {
                b.a(th);
            }
        }
    }
}
