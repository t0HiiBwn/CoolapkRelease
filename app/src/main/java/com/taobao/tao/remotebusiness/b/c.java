package com.taobao.tao.remotebusiness.b;

import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.a.a;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: MtopCacheListenerImpl */
final class c extends b implements MtopCallback.MtopCacheListener {
    public c(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopCacheListener
    public final void onCached(MtopCacheEvent mtopCacheEvent, Object obj) {
        String seqNo = this.b.getSeqNo();
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopCacheListenerImpl", seqNo, "Mtop onCached event received. apiKey=" + this.b.request.getKey());
        }
        if (this.b.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopCacheListenerImpl", seqNo, "The request of MtopBusiness is cancelled.");
            }
        } else if (this.a == null) {
            TBSdkLog.e("mtopsdk.MtopCacheListenerImpl", seqNo, "The listener of MtopBusiness is null.");
        } else if (mtopCacheEvent == null) {
            TBSdkLog.e("mtopsdk.MtopCacheListenerImpl", seqNo, "MtopCacheEvent is null.");
        } else {
            MtopResponse mtopResponse = mtopCacheEvent.getMtopResponse();
            if (mtopResponse == null) {
                TBSdkLog.e("mtopsdk.MtopCacheListenerImpl", seqNo, "The MtopResponse of MtopCacheEvent is null.");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            MtopStatistics.RbStatisticData rbStatisticData = null;
            BaseOutDo mtopResponseToOutputDO = (!mtopResponse.isApiSuccess() || this.b.clazz == null) ? null : MtopConvert.mtopResponseToOutputDO(mtopResponse, this.b.clazz);
            long currentTimeMillis3 = System.currentTimeMillis();
            this.b.onBgFinishTime = currentTimeMillis3;
            MtopStatistics mtopStat = mtopResponse.getMtopStat();
            if (mtopStat != null) {
                rbStatisticData = mtopStat.getRbStatData();
                rbStatisticData.jsonParseTime = currentTimeMillis3 - currentTimeMillis2;
                rbStatisticData.jsonTime = rbStatisticData.jsonParseTime;
                rbStatisticData.isCache = 1;
                rbStatisticData.mtopReqTime = currentTimeMillis - this.b.sendStartTime;
                rbStatisticData.rbReqTime = this.b.onBgFinishTime - this.b.reqStartTime;
                rbStatisticData.totalTime = rbStatisticData.rbReqTime;
            }
            com.taobao.tao.remotebusiness.a.c a = a.a(this.a, mtopCacheEvent, this.b);
            a.c = mtopResponseToOutputDO;
            a.e = mtopResponse;
            this.b.isCached = true;
            if (this.b.mtopProp.handler != null) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.MtopCacheListenerImpl", seqNo, "onReceive: ON_CACHED in self-defined handler.");
                }
                if (mtopStat != null) {
                    if (rbStatisticData != null && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d("mtopsdk.MtopCacheListenerImpl", seqNo, rbStatisticData.toString());
                    }
                    mtopStat.commitStatData(true);
                }
                try {
                    if (a.a instanceof IRemoteCacheListener) {
                        TBSdkLog.i("mtopsdk.MtopCacheListenerImpl", seqNo, "listener onCached callback");
                        ((IRemoteCacheListener) a.a).onCached(mtopCacheEvent, a.c, obj);
                        return;
                    }
                    TBSdkLog.i("mtopsdk.MtopCacheListenerImpl", seqNo, "listener onCached transfer to onSuccess callback");
                    ((IRemoteListener) a.a).onSuccess(a.d.getRequestType(), a.e, a.c, obj);
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.MtopCacheListenerImpl", seqNo, "listener onCached callback error in self-defined handler.", th);
                }
            } else {
                a.a().obtainMessage(4, a).sendToTarget();
            }
        }
    }
}
