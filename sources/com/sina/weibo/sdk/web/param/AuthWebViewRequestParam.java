package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebRequestType;

public class AuthWebViewRequestParam extends BaseWebViewRequestParam {
    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    protected void childFillBundle(Bundle bundle) {
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    protected void transformChildBundle(Bundle bundle) {
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void updateRequestUrl(String str) {
    }

    public AuthWebViewRequestParam() {
    }

    public AuthWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        super(authInfo, webRequestType, str, str2, str3, context);
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public boolean hasExtraTask() {
        return super.hasExtraTask();
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public String getRequestUrl() {
        return getBaseData().getUrl();
    }
}
