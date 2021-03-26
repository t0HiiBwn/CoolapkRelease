package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class SendMessageToWX {

    public static class Req extends BaseReq {
        private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
        private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
        public static final int WXSceneFavorite = 2;
        public static final int WXSceneSession = 0;
        public static final int WXSceneSpecifiedContact = 3;
        public static final int WXSceneTimeline = 1;
        public WXMediaMessage message;
        public int scene;
        public String userOpenId;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage == null) {
                str = "checkArgs fail ,message is null";
            } else {
                if (wXMediaMessage.mediaObject.type() == 6 && this.scene == 2) {
                    ((WXFileObject) this.message.mediaObject).setContentLengthLimit(26214400);
                }
                int i = this.scene;
                if (i == 3 && this.userOpenId == null) {
                    str = "Send specifiedContact userOpenId can not be null.";
                } else if (i != 3 || this.openId != null) {
                    return this.message.checkArgs();
                } else {
                    str = "Send specifiedContact openid can not be null.";
                }
            }
            Log.e("MicroMsg.SDK.SendMessageToWX.Req", str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
            this.scene = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
            this.userOpenId = bundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
            bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
            bundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
            bundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
        }
    }

    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    private SendMessageToWX() {
    }
}
