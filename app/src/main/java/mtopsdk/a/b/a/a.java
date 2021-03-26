package mtopsdk.a.b.a;

import com.taobao.tao.remotebusiness.b.e;
import java.util.LinkedList;
import java.util.List;
import mtopsdk.a.a.b;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: AbstractFilterManager */
public abstract class a implements mtopsdk.a.b.a {
    private List<b> a = new LinkedList();
    private List<mtopsdk.a.a.a> b = new LinkedList();

    public final void a(b bVar) {
        this.a.add(bVar);
    }

    public final void a(mtopsdk.a.a.a aVar) {
        this.b.add(aVar);
    }

    @Override // mtopsdk.a.b.a
    public final void a(String str, e eVar) {
        boolean isBlank = StringUtils.isBlank(str);
        for (b bVar : this.a) {
            if (!isBlank) {
                if (!str.equals(bVar.a())) {
                    continue;
                } else {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        String str2 = eVar.h;
                        TBSdkLog.i("mtopsdk.AbstractFilterManager", str2, "[start]jump to beforeFilter:" + str);
                    }
                    isBlank = true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            String b2 = bVar.b(eVar);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                String str3 = eVar.h;
                TBSdkLog.d("mtopsdk.AbstractFilterManager", str3, "[start]execute BeforeFilter: " + bVar.a() + ",time(ms)= " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if ("STOP".equals(b2)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    String str4 = eVar.h;
                    TBSdkLog.i("mtopsdk.AbstractFilterManager", str4, "[start]execute BeforeFilter: " + bVar.a() + ",result=" + b2);
                    return;
                }
                return;
            }
        }
    }

    @Override // mtopsdk.a.b.a
    public final void b(String str, e eVar) {
        String str2 = null;
        boolean isBlank = StringUtils.isBlank(null);
        for (mtopsdk.a.a.a aVar : this.b) {
            if (!isBlank) {
                if (!str2.equals(aVar.a())) {
                    continue;
                } else {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        String str3 = eVar.h;
                        TBSdkLog.i("mtopsdk.AbstractFilterManager", str3, "[callback]jump to afterFilter:" + ((String) null));
                    }
                    isBlank = true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            String a2 = aVar.a(eVar);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                String str4 = eVar.h;
                TBSdkLog.d("mtopsdk.AbstractFilterManager", str4, "[callback]execute AfterFilter: " + aVar.a() + ",time(ms)= " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if ("STOP".equals(a2)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    String str5 = eVar.h;
                    TBSdkLog.i("mtopsdk.AbstractFilterManager", str5, "[callback]execute AfterFilter: " + aVar.a() + ",result=" + a2);
                    return;
                }
                return;
            }
        }
    }
}
