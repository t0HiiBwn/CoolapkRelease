package com.tencent.mm.opensdk.modelbiz;

import com.tencent.mm.opensdk.modelbase.BaseReq;

public class OpenRankList {

    public static class Req extends BaseReq {
        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 11;
        }
    }
}
