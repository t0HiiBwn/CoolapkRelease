package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;

final class b implements OAuthListener {
    final /* synthetic */ a f;

    b(a aVar) {
        this.f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        this.f.d = null;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f.c);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(str)));
        ArrayList<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f.c);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f.handler != null) {
            this.f.handler.post(new c(this));
        }
    }
}
