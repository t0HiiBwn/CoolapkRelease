package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.a;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.protocol.event.EventRecord;
import com.tencent.beacon.core.protocol.event.EventRecordPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: RealTimeUploadDatas */
public final class j extends a {
    private List<RDBean> h = null;
    private Context i;
    private Long[] j = null;
    private boolean k = false;

    public j(Context context, String str, List<RDBean> list) {
        super(context, 1, 2, str);
        this.h = list;
        this.i = context;
        this.e = list.size();
        if (this.h.size() == 1 && "rqd_heartbeat".equals(this.h.get(0).getEN())) {
            this.k = true;
        }
        this.d = h.a(context, 2);
        b.b("[event] request id:%s", this.d);
    }

    @Override // com.tencent.beacon.core.c.a
    public final synchronized RequestPackage a() {
        b.b("[event] Start encode record", new Object[0]);
        List<RDBean> list = this.h;
        if (list == null || list.size() <= 0) {
            return null;
        }
        try {
            RequestPackage a = a(this.a, this.h);
            if (a != null) {
                b.b("[event] End encode record", new Object[0]);
                return a;
            }
        } catch (Throwable th) {
            b.a(th);
            b.d("[event] TUUD.GetUD start error", new Object[0]);
        }
        return null;
    }

    private RequestPackage a(int i2, List<RDBean> list) {
        byte[] byteArray;
        if (list != null && list.size() > 0) {
            try {
                b.b("[event] encode rd size:" + list.size(), new Object[0]);
                EventRecordPackage a = a(list);
                if (a == null || (byteArray = a.toByteArray()) == null) {
                    return null;
                }
                return a(i2, byteArray, this.f);
            } catch (Throwable th) {
                b.a(th);
                b.d("[event] encode2EventRecordPackage error}", new Object[0]);
            }
        }
        return null;
    }

    private static EventRecordPackage a(List<RDBean> list) {
        if (list != null && list.size() > 0) {
            try {
                EventRecordPackage eventRecordPackage = new EventRecordPackage();
                ArrayList<EventRecord> arrayList = new ArrayList<>();
                for (RDBean rDBean : list) {
                    EventRecord a = k.a(rDBean);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                eventRecordPackage.list = arrayList;
                b.b("[event] encode end", new Object[0]);
                return eventRecordPackage;
            } catch (Throwable th) {
                b.a(th);
            }
        }
        return null;
    }

    @Override // com.tencent.beacon.core.c.a
    public final synchronized void b(boolean z) {
        b.b("[event] isHandled:%b", Boolean.valueOf(z));
        if (this.h != null && !z) {
            b.f("[event] upload failed, save to db", new Object[0]);
            if (!this.k) {
                Long[] a = l.a(this.i, this.f, this.h);
                this.j = a;
                if (a != null) {
                    Iterator<com.tencent.beacon.core.c.j> it2 = i.a(this.i).c().iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
                this.h = null;
            }
        }
        if (z && this.k) {
            g.a(this.i);
        }
        if (z && this.j != null) {
            l.a(this.i, this.f, this.j);
        }
        if (z && this.h != null) {
            Iterator<com.tencent.beacon.core.c.j> it3 = i.a(this.i).c().iterator();
            while (it3.hasNext()) {
                it3.next();
                this.h.size();
            }
        }
        if (z && this.j == null && this.h != null) {
            this.h = null;
        }
    }
}
