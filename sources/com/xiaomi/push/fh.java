package com.xiaomi.push;

class fh extends Thread {
    final /* synthetic */ fg a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    fh(fg fgVar, String str) {
        super(str);
        this.a = fgVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.a.a.m326a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
