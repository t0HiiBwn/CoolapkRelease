package com.alibaba.alibclinkpartner.linkpartner.param.jump;

import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import java.util.HashMap;

public class ALPShopParam extends ALPTBJumpParam {
    public String shopID;

    public ALPShopParam(String str) {
        this.shopID = str;
        this.module = "shop";
        this.d = "ali.open.nav";
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public boolean checkParam() {
        if (g.b(this.shopID)) {
            return true;
        }
        ALSLLogUtil.e("ALPShopParam", "checkParam", "mShopId is not rig");
        return false;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getBackUpH5Url() {
        return !checkParam() ? "" : String.format("http://shop.m.taobao.com/shop/shopIndex.htm?shop_id=%s", this.shopID);
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam
    public HashMap<String, String> getExtraParams() {
        d("shopId", this.shopID);
        return super.getExtraParams();
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam, com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getModule() {
        return this.module;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getPostfix() {
        return checkParam() ? String.format("shop_id=%s&", this.shopID) : super.getPostfix();
    }
}
