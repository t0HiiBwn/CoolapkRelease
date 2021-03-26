package com.taobao.tao.remotebusiness.a;

/* compiled from: HandlerMgr */
final class b implements Runnable {
    private /* synthetic */ c a;

    b(a aVar, c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d.doFinish(this.a.e, this.a.c);
    }
}
