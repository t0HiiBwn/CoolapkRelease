package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXInvoiceAuthInsert {

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXInvoiceAuthInsert.Req";
        private static final int URL_LENGTH_LIMIT = 10240;
        public String url;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final boolean checkArgs() {
            if (d.b(this.url)) {
                Log.i("MicroMsg.SDK.WXInvoiceAuthInsert.Req", "url should not be empty");
                return false;
            } else if (this.url.length() <= 10240) {
                return true;
            } else {
                Log.e("MicroMsg.SDK.WXInvoiceAuthInsert.Req", "url must be in 10k");
                return false;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.url = bundle.getString("_wxapi_invoice_auth_insert_req_url");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final int getType() {
            return 20;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_invoice_auth_insert_req_url", this.url);
        }
    }

    public static final class Resp extends BaseResp {
        public String wxOrderId;

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_invoice_auth_insert_order_id");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final int getType() {
            return 20;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_invoice_auth_insert_order_id", this.wxOrderId);
        }
    }
}
