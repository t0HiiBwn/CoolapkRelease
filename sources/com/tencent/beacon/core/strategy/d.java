package com.tencent.beacon.core.strategy;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.c.g;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.protocol.strategy.CommonStrategy;
import com.tencent.beacon.core.protocol.strategy.ModuleStrategy;
import com.tencent.beacon.core.strategy.a;
import com.tencent.beacon.core.wup.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: StrategyRespHandler */
public final class d implements g {
    private Context a = null;

    public d(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02b6  */
    @Override // com.tencent.beacon.core.c.g
    public final void a(int i, byte[] bArr, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ArrayList<ModuleStrategy> arrayList;
        boolean z6 = false;
        if (i != 101) {
            b.c("[strategy] com strategy unmatch key: %d", Integer.valueOf(i));
        } else if (bArr != null && bArr.length > 0) {
            a strategy = StrategyQueryModule.getInstance(this.a).getStrategy();
            if (strategy == null) {
                b.c("[strategy] impossible! common strategy null!", new Object[0]);
                return;
            }
            try {
                CommonStrategy commonStrategy = new CommonStrategy();
                commonStrategy.readFrom(new a(bArr));
                StrategyQueryModule instance = StrategyQueryModule.getInstance(this.a);
                b.b("[strategy] -> common strategy: %s", commonStrategy);
                if (strategy != null) {
                    if (!commonStrategy.url.equals(strategy.b())) {
                        b.b("[strategy] url changed to: %s", commonStrategy.url);
                        strategy.a(commonStrategy.url);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (commonStrategy.queryInterval != strategy.c()) {
                        b.b("[strategy] QueryPeriod changed to: %d", Integer.valueOf(commonStrategy.queryInterval));
                        strategy.a(commonStrategy.queryInterval);
                        z2 = true;
                    }
                    ArrayList<ModuleStrategy> arrayList2 = commonStrategy.moduleList;
                    if (strategy != null) {
                        if (arrayList2 != null) {
                            SparseArray<a.C0123a> e = strategy.e();
                            if (e != null) {
                                z4 = false;
                                for (int i2 = 0; i2 < e.size(); i2++) {
                                    a.C0123a valueAt = e.valueAt(i2);
                                    Iterator<ModuleStrategy> it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        ModuleStrategy next = it2.next();
                                        if (next.mId == valueAt.e()) {
                                            arrayList = arrayList2;
                                            b.a("[strategy] server module strategy mid: %d", Byte.valueOf(next.mId));
                                            boolean z7 = next.onOff == 1;
                                            if (valueAt.a() != z7) {
                                                b.b("[strategy] mid: %d , isUsable changed: %b ", Byte.valueOf(next.mId), Boolean.valueOf(z7));
                                                valueAt.a(z7);
                                                z4 = true;
                                            }
                                            if (!valueAt.b().equals(next.url)) {
                                                b.b("[strategy] mid: %d , url changed: %s", Byte.valueOf(next.mId), next.url);
                                                valueAt.a(next.url);
                                                z4 = true;
                                            }
                                            if (next.mId == 1 || next.mId == 2) {
                                                if (valueAt.c() == null || next.detail == null) {
                                                    if (next.detail != null && valueAt.c() == null) {
                                                        b.b("[strategy] mid: %d , detail changed...", Byte.valueOf(next.mId));
                                                        valueAt.a(next.detail);
                                                        StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(next.mId, next.detail);
                                                    }
                                                } else if (!valueAt.c().equals(next.detail)) {
                                                    b.b("[strategy] mid: %d , detail changed...", Byte.valueOf(next.mId));
                                                    valueAt.a(next.detail);
                                                    StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(next.mId, next.detail);
                                                }
                                                z4 = true;
                                            }
                                            if (next.mId == 1) {
                                                if (valueAt.d() != null) {
                                                }
                                                b.b("[strategy] mid: %d , PreventEventCode changed...", Byte.valueOf(next.mId));
                                                valueAt.a(h.a(next.preventEventCode));
                                                z4 = true;
                                                if (valueAt.f() == null || next.sampleEvent == null ? !(valueAt.f() == null && next.sampleEvent == null) : !valueAt.f().equals(next.sampleEvent)) {
                                                    b.b("[strategy] mid: %d , SampleEventSet changed...", Byte.valueOf(next.mId));
                                                    valueAt.b(h.a(next.sampleEvent));
                                                    z4 = true;
                                                }
                                            }
                                            if (next.mId == 2) {
                                                b.b("[strategy] mid: %d , SpeedMonitorStrategy", Byte.valueOf(next.mId));
                                            }
                                        } else {
                                            arrayList = arrayList2;
                                        }
                                        z2 = z2;
                                        arrayList2 = arrayList;
                                    }
                                }
                                z3 = z2;
                            }
                        } else {
                            z3 = z2;
                            SparseArray<a.C0123a> e2 = strategy.e();
                            if (e2 != null) {
                                int size = e2.size();
                                boolean z8 = false;
                                for (int i3 = 0; i3 < size; i3++) {
                                    a.C0123a valueAt2 = e2.valueAt(i3);
                                    if (valueAt2.a()) {
                                        b.b("[strategy] mid: %d , server not response strategy, sdk local close it!", Integer.valueOf(valueAt2.e()));
                                        valueAt2.a(false);
                                        z8 = true;
                                    }
                                }
                                z4 = z8;
                            }
                            z4 = false;
                        }
                        boolean z9 = !z4 ? true : z3;
                        Map<String, String> map = commonStrategy.cloudParas;
                        if (strategy != null) {
                            if (map == null || strategy.d() == null) {
                                if (map != null && strategy.d() == null) {
                                    strategy.a(map);
                                }
                            } else if (!map.equals(strategy.d())) {
                                strategy.a(map);
                            }
                            z5 = true;
                            if (z5) {
                                z9 = true;
                            }
                            z6 = z9;
                        }
                        z5 = false;
                        if (z5) {
                        }
                        z6 = z9;
                    }
                    z3 = z2;
                    z4 = false;
                    if (!z4) {
                    }
                    Map<String, String> map = commonStrategy.cloudParas;
                    if (strategy != null) {
                    }
                    z5 = false;
                    if (z5) {
                    }
                    z6 = z9;
                }
                if (z6) {
                    if (z) {
                        b.e("[strategy] update common strategy should save ", new Object[0]);
                        b.a(this.a, i, bArr);
                    }
                    instance.notifyStrategyChanged(strategy);
                }
                if (z) {
                    instance.setAtLeastAComQuerySuccess(true);
                    com.tencent.beacon.core.event.d a2 = com.tencent.beacon.core.event.d.a();
                    if (a2 != null && a2.m()) {
                        c a3 = c.a(this.a);
                        a3.a().a("today_success_strategy_query_times", Integer.valueOf(a3.a("today_success_strategy_query_times") + 1)).a("last_success_strategy_query_time", Long.valueOf(System.currentTimeMillis())).b();
                    }
                }
            } catch (Throwable th) {
                b.a(th);
                b.d("[strategy] error to common strategy!", new Object[0]);
            }
        }
    }
}
