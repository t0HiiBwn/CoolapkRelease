package mtopsdk.xstate;

import mtopsdk.common.util.AsyncServiceBinder;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.aidl.IXState;

/* compiled from: XState */
final class a extends AsyncServiceBinder<IXState> {
    a(Class cls, Class cls2) {
        super(cls, cls2);
    }

    @Override // mtopsdk.common.util.AsyncServiceBinder
    protected final void afterAsyncBind() {
        XState.a.compareAndSet(true, false);
        MtopSDKThreadPoolExecutorFactory.submit(new b(this));
    }
}
