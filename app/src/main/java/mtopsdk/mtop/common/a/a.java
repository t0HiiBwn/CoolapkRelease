package mtopsdk.mtop.common.a;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.DefaultMtopCallback;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: MtopBaseListenerProxy */
public class a extends DefaultMtopCallback {
    protected MtopListener a;
    public MtopResponse b = null;
    public Object c = null;
    protected boolean d = false;

    public a(MtopListener mtopListener) {
        this.a = mtopListener;
    }

    @Override // mtopsdk.mtop.common.DefaultMtopCallback, mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        MtopResponse mtopResponse;
        if (!(mtopFinishEvent == null || mtopFinishEvent.getMtopResponse() == null)) {
            this.b = mtopFinishEvent.getMtopResponse();
            this.c = obj;
        }
        synchronized (this) {
            try {
                notifyAll();
            } catch (Exception unused) {
                TBSdkLog.e("mtopsdk.MtopListenerProxy", "[onFinished] notify error");
            }
        }
        if (!(this.a instanceof MtopCallback.MtopFinishListener)) {
            return;
        }
        if (!this.d || ((mtopResponse = this.b) != null && mtopResponse.isApiSuccess())) {
            ((MtopCallback.MtopFinishListener) this.a).onFinished(mtopFinishEvent, obj);
        }
    }

    @Override // mtopsdk.mtop.common.DefaultMtopCallback, mtopsdk.mtop.common.MtopCallback.MtopProgressListener
    public void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj) {
        MtopListener mtopListener = this.a;
        if (mtopListener instanceof MtopCallback.MtopProgressListener) {
            ((MtopCallback.MtopProgressListener) mtopListener).onDataReceived(mtopProgressEvent, obj);
        }
    }

    @Override // mtopsdk.mtop.common.DefaultMtopCallback, mtopsdk.mtop.common.MtopCallback.MtopHeaderListener
    public void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        MtopListener mtopListener = this.a;
        if (mtopListener instanceof MtopCallback.MtopHeaderListener) {
            ((MtopCallback.MtopHeaderListener) mtopListener).onHeader(mtopHeaderEvent, obj);
        }
    }
}
