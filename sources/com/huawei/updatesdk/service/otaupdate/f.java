package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.a.b.d.a.c;
import com.huawei.updatesdk.a.b.d.a.d;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.b;
import java.util.List;

public class f {
    private static String a = "com.huawei.appmarket";
    private static b b;

    private static class a implements com.huawei.updatesdk.a.b.d.a.a {
        private a() {
        }

        @Override // com.huawei.updatesdk.a.b.d.a.a
        public void a(c cVar, d dVar) {
        }

        @Override // com.huawei.updatesdk.a.b.d.a.a
        public void b(c cVar, d dVar) {
            if (dVar instanceof b) {
                b bVar = (b) dVar;
                if (dVar.a() == 0 && dVar.c() == 0) {
                    if ((bVar.list_ != null && bVar.list_.size() != 0) || (bVar.notRcmList_ != null && bVar.notRcmList_.size() != 0)) {
                        ApkUpgradeInfo b = f.b(bVar.list_);
                        if (f.b != null) {
                            f.b.a(b);
                        }
                    } else if (f.b != null) {
                        f.b.a(dVar.a());
                    }
                } else if (f.b != null) {
                    f.b.b(dVar.a());
                }
            } else if (f.b != null) {
                f.b.a(dVar.a());
            }
        }
    }

    public static void a(b bVar) {
        b = bVar;
    }

    public static void a(String str) {
        a = str;
        com.huawei.updatesdk.service.d.a.b.a(com.huawei.updatesdk.service.appmgr.bean.a.d(str), new a());
    }

    /* access modifiers changed from: private */
    public static ApkUpgradeInfo b(List<ApkUpgradeInfo> list) {
        if (list == null) {
            return null;
        }
        for (ApkUpgradeInfo apkUpgradeInfo : list) {
            String str = a;
            if (str != null && str.equals(apkUpgradeInfo.getPackage_())) {
                return apkUpgradeInfo;
            }
        }
        return null;
    }
}
