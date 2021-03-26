package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;

final class c implements Runnable {
    final /* synthetic */ b g;

    c(b bVar) {
        this.g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.g.f.c);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onQrcodeScanned();
        }
    }
}
