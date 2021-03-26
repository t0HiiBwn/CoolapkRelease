package com.taobao.tao.remotebusiness.login;

import com.taobao.tao.remotebusiness.login.a;
import java.util.HashMap;
import java.util.HashSet;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.stat.IUploadStats;

/* compiled from: DefaultLoginImpl */
final class c implements Runnable {
    private /* synthetic */ IUploadStats a;
    private /* synthetic */ a.C0129a b;

    c(a aVar, IUploadStats iUploadStats, a.C0129a aVar2) {
        this.a = iUploadStats;
        this.b = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (a.o.compareAndSet(false, true)) {
                HashSet hashSet = new HashSet();
                hashSet.add("long_nick");
                hashSet.add("apiName");
                hashSet.add("apiV");
                hashSet.add("msgCode");
                hashSet.add("S_STATUS");
                hashSet.add("processName");
                hashSet.add("appBackGround");
                IUploadStats iUploadStats = this.a;
                if (iUploadStats != null) {
                    iUploadStats.onRegister("mtoprb", "SessionInvalid", hashSet, null, false);
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e("mtopsdk.DefaultLoginImpl", "onRegister called. module=mtoprb,monitorPoint=SessionInvalid");
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("long_nick", this.b.a);
            hashMap.put("apiName", this.b.b);
            hashMap.put("apiV", this.b.c);
            hashMap.put("msgCode", this.b.d);
            hashMap.put("S_STATUS", this.b.e);
            hashMap.put("processName", this.b.f);
            hashMap.put("appBackGround", this.b.g ? "1" : "0");
            IUploadStats iUploadStats2 = this.a;
            if (iUploadStats2 != null) {
                iUploadStats2.onCommit("mtoprb", "SessionInvalid", hashMap, null);
            }
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.DefaultLoginImpl", "upload  SessionInvalid Stats error.", e);
        }
    }
}
