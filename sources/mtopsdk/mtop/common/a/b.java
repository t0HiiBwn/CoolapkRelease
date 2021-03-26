package mtopsdk.mtop.common.a;

import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: MtopCacheListenerProxy */
public final class b extends a implements MtopCallback.MtopCacheListener {
    public b(MtopListener mtopListener) {
        super(mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopCacheListener
    public final void onCached(MtopCacheEvent mtopCacheEvent, Object obj) {
        if (this.a instanceof MtopCallback.MtopCacheListener) {
            ((MtopCallback.MtopCacheListener) this.a).onCached(mtopCacheEvent, obj);
            this.d = true;
        }
    }
}
