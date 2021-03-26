package com.alibaba.alibclinkpartner.linkpartner.param.jump;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import java.util.HashMap;

public class ALPURIParam extends ALPTBJumpParam {
    public String url;

    public ALPURIParam(String str) {
        this.url = str;
        this.d = "ali.open.nav";
        this.module = "h5";
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public boolean checkParam() {
        if (!TextUtils.isEmpty(this.url)) {
            return true;
        }
        ALSLLogUtil.e("ALPURIParam", "checkParam", "url is not right");
        return false;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getBackUpH5Url() {
        String str = this.url;
        return (str == null || !g.c(str)) ? "" : this.url;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam, com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getModule() {
        return this.module;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam, com.alibaba.alibclinkpartner.linkpartner.param.a
    public HashMap<String, String> getParams() {
        a("h5Url", this.url);
        return super.getParams();
    }
}
