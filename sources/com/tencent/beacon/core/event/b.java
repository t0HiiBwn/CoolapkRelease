package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.d.c;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.protocol.common.MixPackage;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.protocol.event.EventRecord;
import com.tencent.beacon.core.protocol.event.EventRecordPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CommonRecordUploadDatas */
public final class b extends com.tencent.beacon.core.c.a {
    private static AbstractC0140b m = new a((byte) 0);
    private Context h = null;
    private Long[] i = null;
    private List<Long> j = null;
    private byte[] k = null;
    private boolean l = false;

    /* renamed from: com.tencent.beacon.core.event.b$b  reason: collision with other inner class name */
    /* compiled from: CommonRecordUploadDatas */
    public interface AbstractC0140b {
        byte[] a(List<RDBean> list, List<Long> list2);
    }

    public b(Context context, String str) {
        super(context, 1, 4, str);
        this.h = context;
    }

    private synchronized boolean g() {
        return this.l;
    }

    public final synchronized void a(boolean z) {
        this.l = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x011e A[LOOP:1: B:63:0x0119->B:65:0x011e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0131 A[EDGE_INSN: B:92:0x0131->B:66:0x0131 ?: BREAK  , SYNTHETIC] */
    @Override // com.tencent.beacon.core.c.a
    public final synchronized RequestPackage a() {
        byte[] bArr;
        MixPackage mixPackage;
        int i2;
        Long[] lArr;
        List a2;
        TunnelModule instance = TunnelModule.getInstance(this.c);
        RequestPackage requestPackage = null;
        if (instance != null) {
            if (instance.isEnable) {
                d a3 = d.a();
                if (a3 == null) {
                    com.tencent.beacon.core.d.b.d("[event] strategy null!", new Object[0]);
                    return null;
                }
                try {
                    if (!g() || (a2 = com.tencent.beacon.core.a.a.b.a(this.h, this.f)) == null || a2.size() <= 0) {
                        bArr = null;
                    } else {
                        bArr = (byte[]) a2.get(3);
                        this.d = String.valueOf(a2.get(1));
                        this.e = ((Integer) a2.get(4)).intValue();
                    }
                    if (bArr != null) {
                        return a(this.a, bArr, this.f);
                    }
                    int f = a3.f();
                    if (!c.a(this.h)) {
                        f /= 2;
                    }
                    List<RDBean> a4 = f >= 0 ? l.a(this.h, this.f, f) : null;
                    if (a4 == null || a4.size() <= 0) {
                        com.tencent.beacon.core.d.b.h("[event] No event need upload.", new Object[0]);
                        return null;
                    }
                    int size = a4.size();
                    com.tencent.beacon.core.d.b.h("[event] %d events need upload.", Integer.valueOf(size));
                    this.e = size;
                    for (RDBean rDBean : a4) {
                        Map<String, String> eMap = rDBean.getEMap();
                        if (eMap != null) {
                            eMap.put("A3", d.a(this.c).f());
                        }
                    }
                    if (a4 != null) {
                        try {
                            if (a4.size() > 0) {
                                ArrayList arrayList = new ArrayList();
                                this.j = arrayList;
                                AbstractC0140b bVar = m;
                                byte[] a5 = bVar != null ? bVar.a(a4, arrayList) : null;
                                if (this.j.size() > 0) {
                                    Context context = this.h;
                                    String str = this.f;
                                    List<Long> list = this.j;
                                    l.a(context, str, (Long[]) list.toArray(new Long[list.size()]));
                                }
                                if (a5 != null) {
                                    HashMap hashMap = new HashMap();
                                    if (a5 != null) {
                                        hashMap.put(1, a5);
                                    }
                                    mixPackage = new MixPackage();
                                    mixPackage.mixMap = hashMap;
                                    this.i = new Long[size];
                                    i2 = 0;
                                    while (true) {
                                        lArr = this.i;
                                        if (i2 < lArr.length) {
                                            break;
                                        }
                                        lArr[i2] = Long.valueOf(a4.get(i2).getCid());
                                        i2++;
                                    }
                                    a4.clear();
                                    if (mixPackage != null) {
                                        byte[] byteArray = mixPackage.toByteArray();
                                        byte[] bArr2 = new byte[byteArray.length];
                                        this.k = bArr2;
                                        System.arraycopy(byteArray, 0, bArr2, 0, byteArray.length);
                                        this.d = h.a(this.c, 4);
                                        com.tencent.beacon.core.d.b.b("[event] comm rid:%s", this.d);
                                        try {
                                            requestPackage = a(this.a, byteArray, this.f);
                                        } catch (Exception unused) {
                                            b();
                                        }
                                        return requestPackage;
                                    }
                                    return null;
                                }
                            }
                        } catch (Exception unused2) {
                            b();
                        }
                    }
                    mixPackage = null;
                    this.i = new Long[size];
                    i2 = 0;
                    while (true) {
                        lArr = this.i;
                        if (i2 < lArr.length) {
                        }
                        lArr[i2] = Long.valueOf(a4.get(i2).getCid());
                        i2++;
                    }
                    a4.clear();
                    if (mixPackage != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    com.tencent.beacon.core.d.b.a(th);
                    com.tencent.beacon.core.d.b.d("[event] get req data error: %s", th.toString());
                }
            }
        }
        com.tencent.beacon.core.d.b.d("[event] module null!", new Object[0]);
        return null;
    }

    @Override // com.tencent.beacon.core.c.a
    public final synchronized void b() {
        com.tencent.beacon.core.d.b.c("[event] encode failed, clear db data", new Object[0]);
        Long[] lArr = this.i;
        if (lArr != null && lArr.length > 0) {
            int a2 = l.a(this.h, this.f, this.i);
            com.tencent.beacon.core.d.b.b("[event] remove num :" + a2, new Object[0]);
            this.i = null;
        }
    }

    @Override // com.tencent.beacon.core.c.a
    public final synchronized void b(boolean z) {
        Long[] lArr = this.i;
        int length = lArr != null ? lArr.length : 0;
        if (length > 0) {
            int a2 = l.a(this.h, this.f, this.i);
            com.tencent.beacon.core.d.b.b("[event] t_event remove num :" + a2, new Object[0]);
        }
        this.i = null;
        if (z && g()) {
            com.tencent.beacon.core.a.a.b.a(this.h, this.f, this.d);
        } else if (!z && this.k != null) {
            com.tencent.beacon.core.d.b.b("[event] comm rid2:%s", this.d);
            com.tencent.beacon.core.a.a.b.a(this.h, this.f, this.k, this.d, length);
        }
        this.k = null;
    }

    /* compiled from: CommonRecordUploadDatas */
    private static class a implements AbstractC0140b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.tencent.beacon.core.event.b.AbstractC0140b
        public final byte[] a(List<RDBean> list, List<Long> list2) {
            if (list != null && list.size() > 0) {
                ArrayList<EventRecord> arrayList = new ArrayList<>();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    try {
                        RDBean rDBean = list.get(i);
                        if (rDBean.getEMap() != null && "UA".equals(rDBean.getTP())) {
                            com.tencent.beacon.core.d.b.f("[event] pack eName: %s", rDBean.getEN());
                            EventRecord a = k.a(rDBean);
                            if (a != null) {
                                arrayList.add(a);
                            } else {
                                list2.add(Long.valueOf(rDBean.getCid()));
                            }
                        }
                    } catch (Throwable th) {
                        com.tencent.beacon.core.d.b.d("[event] encode2MixPackage error.", new Object[0]);
                        com.tencent.beacon.core.d.b.a(th);
                    }
                }
                com.tencent.beacon.core.d.b.b("[event] up erList:" + arrayList.size(), new Object[0]);
                if (arrayList.size() > 0) {
                    EventRecordPackage eventRecordPackage = new EventRecordPackage();
                    eventRecordPackage.list = arrayList;
                    return eventRecordPackage.toByteArray();
                }
            }
            return null;
        }
    }
}
