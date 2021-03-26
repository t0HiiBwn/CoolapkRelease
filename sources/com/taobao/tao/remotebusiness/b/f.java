package com.taobao.tao.remotebusiness.b;

import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.a.a;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;

/* compiled from: MtopProgressListenerImpl */
final class f extends b implements MtopCallback.MtopHeaderListener, MtopCallback.MtopProgressListener {
    public f(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopProgressListener
    public final void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj) {
        String seqNo = this.b.getSeqNo();
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopProgressListenerImpl", seqNo, "Mtop onDataReceived event received.");
        }
        if (this.b.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopProgressListenerImpl", seqNo, "The request of MtopBusiness is cancelled.");
            }
        } else if (!(this.a instanceof IRemoteProcessListener)) {
        } else {
            if (this.b.mtopProp.handler != null) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.MtopProgressListenerImpl", seqNo, "onReceive: ON_DATA_RECEIVED in self-defined handler.");
                }
                try {
                    ((IRemoteProcessListener) this.a).onDataReceived(mtopProgressEvent, obj);
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.MtopProgressListenerImpl", seqNo, "listener onDataReceived callback error in self-defined handler.", th);
                }
            } else {
                a.a().obtainMessage(1, a.a(this.a, mtopProgressEvent, this.b)).sendToTarget();
            }
        }
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopHeaderListener
    public final void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        String seqNo = this.b.getSeqNo();
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopProgressListenerImpl", seqNo, "Mtop onHeader event received.");
        }
        if (this.b.isTaskCanceled()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.MtopProgressListenerImpl", seqNo, "The request of MtopBusiness is cancelled.");
            }
        } else if (!(this.a instanceof IRemoteProcessListener)) {
        } else {
            if (this.b.mtopProp.handler != null) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.MtopProgressListenerImpl", seqNo, "onReceive: ON_HEADER in self-defined handler.");
                }
                try {
                    ((IRemoteProcessListener) this.a).onHeader(mtopHeaderEvent, obj);
                } catch (Throwable th) {
                    TBSdkLog.e("mtopsdk.MtopProgressListenerImpl", seqNo, "listener onHeader callback error in self-defined handler.", th);
                }
            } else {
                a.a().obtainMessage(2, a.a(this.a, mtopHeaderEvent, this.b)).sendToTarget();
            }
        }
    }
}
