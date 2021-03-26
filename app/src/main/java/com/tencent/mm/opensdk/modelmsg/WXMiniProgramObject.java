package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXMiniProgramObject implements WXMediaMessage.IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public int disableforward = 0;
    public int miniprogramType = 0;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        if (d.b(this.webpageUrl)) {
            str = "webPageUrl is null";
        } else if (d.b(this.userName)) {
            str = "userName is null";
        } else {
            int i = this.miniprogramType;
            if (i >= 0 && i <= 2) {
                return true;
            }
            str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
        }
        Log.e("MicroMsg.SDK.WXMiniProgramObject", str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        bundle.putInt("_wxminiprogram_disableforward", this.disableforward);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 36;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        this.disableforward = bundle.getInt("_wxminiprogram_disableforward");
    }
}
