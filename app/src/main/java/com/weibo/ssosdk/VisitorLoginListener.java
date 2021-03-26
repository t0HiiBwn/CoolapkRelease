package com.weibo.ssosdk;

import com.weibo.ssosdk.WeiboSsoSdk;

public interface VisitorLoginListener {
    void handler(WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo);
}
