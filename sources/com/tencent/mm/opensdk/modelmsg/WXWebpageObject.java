package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXWebpageObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
    public String canvasPageXml;
    public String extInfo;
    public String webpageUrl;

    public WXWebpageObject() {
    }

    public WXWebpageObject(String str) {
        this.webpageUrl = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.webpageUrl;
        if (str != null && str.length() != 0 && this.webpageUrl.length() <= 10240) {
            return true;
        }
        Log.e("MicroMsg.SDK.WXWebpageObject", "checkArgs fail, webpageUrl is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxwebpageobject_extInfo", this.extInfo);
        bundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
        bundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxwebpageobject_extInfo");
        this.webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
        this.canvasPageXml = bundle.getString("_wxwebpageobject_canvaspagexml");
    }
}
