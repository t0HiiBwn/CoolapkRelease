package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXDynamicVideoMiniProgramObject extends WXMiniProgramObject {
    private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
    public String appThumbUrl;
    public String videoSource;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        if (d.b(this.webpageUrl)) {
            str = "webPageUrl is null";
        } else if (d.b(this.userName)) {
            str = "userName is null";
        } else if (this.miniprogramType >= 0 && this.miniprogramType <= 2) {
            return true;
        } else {
            str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
        }
        Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putString("_wxminiprogram_videoSource", this.videoSource);
        bundle.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        bundle.putInt("_wxminiprogram_disableforward", this.disableforward);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 46;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.videoSource = bundle.getString("_wxminiprogram_videoSource");
        this.appThumbUrl = bundle.getString("_wxminiprogram_appThumbUrl");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        this.disableforward = bundle.getInt("_wxminiprogram_disableforward");
    }
}
