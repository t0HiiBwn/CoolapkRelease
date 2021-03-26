package com.taobao.tao.remotebusiness.b;

import android.os.Looper;
import com.taobao.tao.remotebusiness.IRemoteParserListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.a.a;
import com.taobao.tao.remotebusiness.a.c;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: MtopFinishListenerImpl */
final class d extends b implements MtopCallback.MtopFinishListener {
    public d(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public final void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        long j;
        String seqNo = this.b.getSeqNo();
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopFinishListenerImpl", seqNo, "Mtop onFinished event received.");
        }
        if (this.b.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopFinishListenerImpl", seqNo, "The request of MtopBusiness is canceled.");
            }
        } else if (this.a == null) {
            TBSdkLog.e("mtopsdk.MtopFinishListenerImpl", seqNo, "The listener of MtopBusiness is null.");
        } else if (mtopFinishEvent == null) {
            TBSdkLog.e("mtopsdk.MtopFinishListenerImpl", seqNo, "MtopFinishEvent is null.");
        } else {
            MtopResponse mtopResponse = mtopFinishEvent.getMtopResponse();
            if (mtopResponse == null) {
                TBSdkLog.e("mtopsdk.MtopFinishListenerImpl", seqNo, "The MtopResponse of MtopFinishEvent is null.");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.a instanceof IRemoteParserListener) {
                try {
                    ((IRemoteParserListener) this.a).parseResponse(mtopResponse);
                } catch (Exception e) {
                    TBSdkLog.e("mtopsdk.MtopFinishListenerImpl", seqNo, "listener parseResponse callback error.", e);
                }
            }
            c a = a.a(this.a, mtopFinishEvent, this.b);
            a.e = mtopResponse;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!mtopResponse.isApiSuccess() || this.b.clazz == null) {
                j = currentTimeMillis2;
            } else {
                a.c = MtopConvert.mtopResponseToOutputDO(mtopResponse, this.b.clazz);
                j = System.currentTimeMillis();
            }
            this.b.onBgFinishTime = j;
            MtopStatistics mtopStat = mtopResponse.getMtopStat();
            MtopStatistics.RbStatisticData rbStatisticData = null;
            if (mtopStat != null) {
                rbStatisticData = mtopStat.getRbStatData();
                rbStatisticData.beforeReqTime = this.b.sendStartTime - this.b.reqStartTime;
                rbStatisticData.mtopReqTime = currentTimeMillis - this.b.sendStartTime;
                rbStatisticData.afterReqTime = this.b.onBgFinishTime - currentTimeMillis;
                rbStatisticData.parseTime = currentTimeMillis2 - currentTimeMillis;
                rbStatisticData.jsonParseTime = j - currentTimeMillis2;
                rbStatisticData.jsonTime = rbStatisticData.jsonParseTime;
                rbStatisticData.rbReqTime = this.b.onBgFinishTime - this.b.reqStartTime;
                rbStatisticData.totalTime = rbStatisticData.rbReqTime;
                rbStatisticData.mtopDispatchTime = mtopStat.currentTimeMillis() - mtopStat.startCallbackTime;
            }
            if (this.b.mtopProp.handler != null) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.MtopFinishListenerImpl", seqNo, "onReceive: ON_FINISHED in self-defined handler.");
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                if (mtopStat != null) {
                    mtopStat.rspCbStart = System.currentTimeMillis();
                }
                a.d.doFinish(a.e, a.c);
                if (mtopStat != null) {
                    mtopStat.rspCbEnd = System.currentTimeMillis();
                    mtopStat.commitFullTrace();
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    long j2 = 0;
                    if (a.e.getBytedata() != null) {
                        j2 = (long) a.e.getBytedata().length;
                    }
                    StringBuilder sb = new StringBuilder(128);
                    sb.append("onReceive: ON_FINISHED in self-defined handler.doFinishTime=");
                    sb.append(System.currentTimeMillis() - currentTimeMillis3);
                    sb.append(", dataSize=");
                    sb.append(j2);
                    sb.append("; ");
                    if (rbStatisticData != null) {
                        sb.append(rbStatisticData.toString());
                    }
                    TBSdkLog.i("mtopsdk.MtopFinishListenerImpl", seqNo, sb.toString());
                }
                if (mtopStat != null) {
                    mtopStat.isMain = this.b.mtopProp.handler.getLooper().equals(Looper.getMainLooper());
                    mtopStat.commitStatData(true);
                    return;
                }
                return;
            }
            if (mtopStat != null) {
                mtopStat.rspCbDispatch = System.currentTimeMillis();
            }
            a.a().obtainMessage(3, a).sendToTarget();
        }
    }
}
