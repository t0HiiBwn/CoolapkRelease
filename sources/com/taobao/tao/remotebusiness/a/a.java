package com.taobao.tao.remotebusiness.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: HandlerMgr */
public class a extends Handler {
    private static volatile Handler a;

    private a(Looper looper) {
        super(looper);
    }

    public static Handler a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(Looper.getMainLooper());
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a1  */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        long j;
        MtopStatistics.RbStatisticData rbStatisticData;
        MtopStatistics mtopStatistics;
        MtopStatistics mtopStat;
        c cVar = (c) message.obj;
        String str = "";
        if (cVar == null) {
            TBSdkLog.e("mtopsdk.HandlerMgr", str, "HandlerMsg is null.");
            return;
        }
        if (cVar.d != null) {
            str = cVar.d.getSeqNo();
            if (cVar.d.isTaskCanceled()) {
                TBSdkLog.i("mtopsdk.HandlerMgr", str, "The request of MtopBusiness is cancelled.");
                return;
            }
        }
        Object reqContext = cVar.d.getReqContext();
        int i = message.what;
        if (i == 1) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.HandlerMgr", str, "onReceive: ON_DATA_RECEIVED.");
            }
            try {
                ((IRemoteProcessListener) cVar.a).onDataReceived((MtopProgressEvent) cVar.b, reqContext);
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.HandlerMgr", str, "listener onDataReceived callback error.", th);
            }
        } else if (i == 2) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.HandlerMgr", str, "onReceive: ON_HEADER.");
            }
            try {
                ((IRemoteProcessListener) cVar.a).onHeader((MtopHeaderEvent) cVar.b, reqContext);
            } catch (Throwable th2) {
                TBSdkLog.e("mtopsdk.HandlerMgr", str, "listener onHeader callback error.", th2);
            }
        } else if (i == 3) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.HandlerMgr", str, "onReceive: ON_FINISHED.");
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = 0;
            if (cVar.e != null) {
                mtopStatistics = cVar.e.getMtopStat();
                if (mtopStatistics != null) {
                    rbStatisticData = mtopStatistics.getRbStatData();
                    rbStatisticData.toMainThTime = currentTimeMillis - cVar.d.onBgFinishTime;
                    j = cVar.e.getBytedata() != null ? (long) cVar.e.getBytedata().length : 0;
                    if (cVar.d.mtopProp.handler == null) {
                        if (mtopStatistics != null) {
                            mtopStatistics.isMain = cVar.d.mtopProp.handler.getLooper().equals(Looper.getMainLooper());
                            mtopStatistics.rspCbStart = System.currentTimeMillis();
                            mtopStatistics.rspCbEnd = mtopStatistics.rspCbStart;
                        }
                        cVar.d.mtopProp.handler.post(new b(this, cVar));
                    } else {
                        if (rbStatisticData != null) {
                            j2 = mtopStatistics.currentTimeMillis();
                            mtopStatistics.rspCbStart = System.currentTimeMillis();
                        }
                        cVar.d.doFinish(cVar.e, cVar.c);
                        if (rbStatisticData != null) {
                            rbStatisticData.bizCallbackTime = mtopStatistics.currentTimeMillis() - j2;
                            mtopStatistics.rspCbEnd = System.currentTimeMillis();
                        }
                    }
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        StringBuilder sb = new StringBuilder(128);
                        sb.append("onReceive: ON_FINISHED. doFinishTime=");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append("; dataSize=");
                        sb.append(j);
                        sb.append("; ");
                        if (rbStatisticData != null) {
                            sb.append(rbStatisticData.toString());
                        }
                        TBSdkLog.i("mtopsdk.HandlerMgr", str, sb.toString());
                    }
                    if (mtopStatistics != null) {
                        mtopStatistics.commitStatData(true);
                        mtopStatistics.commitFullTrace();
                    }
                } else {
                    j = 0;
                }
            } else {
                j = 0;
                mtopStatistics = null;
            }
            rbStatisticData = null;
            if (cVar.d.mtopProp.handler == null) {
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            }
            if (mtopStatistics != null) {
            }
        } else if (i == 4) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.HandlerMgr", str, "onReceive: ON_CACHED");
            }
            MtopCacheEvent mtopCacheEvent = (MtopCacheEvent) cVar.b;
            if (mtopCacheEvent == null) {
                TBSdkLog.e("mtopsdk.HandlerMgr", str, "HandlerMsg.event is null.");
                return;
            }
            if (!(mtopCacheEvent.getMtopResponse() == null || (mtopStat = mtopCacheEvent.getMtopResponse().getMtopStat()) == null)) {
                MtopStatistics.RbStatisticData rbStatData = mtopStat.getRbStatData();
                rbStatData.toMainThTime = System.currentTimeMillis() - cVar.d.onBgFinishTime;
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("mtopsdk.HandlerMgr", str, rbStatData.toString());
                }
                mtopStat.commitStatData(true);
            }
            try {
                if (cVar.a instanceof IRemoteCacheListener) {
                    TBSdkLog.i("mtopsdk.HandlerMgr", str, "listener onCached callback");
                    ((IRemoteCacheListener) cVar.a).onCached(mtopCacheEvent, cVar.c, reqContext);
                } else {
                    TBSdkLog.i("mtopsdk.HandlerMgr", cVar.d.getSeqNo(), "listener onCached transfer to onSuccess callback");
                    ((IRemoteListener) cVar.a).onSuccess(cVar.d.getRequestType(), cVar.e, cVar.c, reqContext);
                }
            } catch (Throwable th3) {
                TBSdkLog.e("mtopsdk.HandlerMgr", str, "listener onCached callback error.", th3);
            }
        }
        message.obj = null;
    }

    public static c a(MtopListener mtopListener, MtopEvent mtopEvent, MtopBusiness mtopBusiness) {
        return new c(mtopListener, mtopEvent, mtopBusiness);
    }
}
