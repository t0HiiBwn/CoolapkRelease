package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXLaunchMiniProgramWithToken {

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req";
        public String token;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            if (!d.b(this.token)) {
                return true;
            }
            Log.e("MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req", "token is null");
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 29;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_token", this.token);
        }
    }

    public static final class Resp extends BaseResp {
        public static final int ERR_INVALID_TOKEN = -1000;
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_launch_wxminiprogram_ext_msg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 29;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
        }
    }
}
