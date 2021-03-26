package com.alibaba.alibclinkpartner.linkpartner.param.jump;

import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import java.util.HashMap;

public class ALPDetailParam extends ALPTBJumpParam {
    public String itemID;

    public ALPDetailParam(String str) {
        this.itemID = str;
        this.module = "detail";
        this.d = "ali.open.nav";
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public boolean checkParam() {
        String str = this.itemID;
        if (str != null && g.b(str)) {
            return true;
        }
        ALSLLogUtil.e("ALPDetailParam", "checkParam", "mDetailId is not right");
        return false;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getBackUpH5Url() {
        String str = this.itemID;
        return str == null ? "" : String.format("http://h5.m.taobao.com/awp/core/detail.htm?id=%s", str);
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam
    public HashMap<String, String> getExtraParams() {
        d("itemId", this.itemID);
        return super.getExtraParams();
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam, com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getModule() {
        return this.module;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getPostfix() {
        return checkParam() ? String.format("id=%s&", this.itemID) : super.getPostfix();
    }
}
