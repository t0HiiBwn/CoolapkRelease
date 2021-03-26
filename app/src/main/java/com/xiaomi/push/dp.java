package com.xiaomi.push;

class dp implements Runnable {
    final /* synthetic */ Cdo a;

    dp(Cdo doVar) {
        this.a = doVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
