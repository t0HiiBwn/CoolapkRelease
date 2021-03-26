package com.xiaomi.push;

class el extends Thread {
    final /* synthetic */ ek a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    el(ek ekVar, String str) {
        super(str);
        this.a = ekVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.a.w.a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
