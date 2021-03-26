package com.sina.weibo.sdk.sso;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.weibo.ssosdk.MfpBuilder;
import com.weibo.ssosdk.VisitorLoginListener;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.WeiboSsoSdkConfig;

public final class WeiboSsoManager {
    private static final String TAG = "WeiboSsoManager";
    private String aid;

    private static class Instance {
        private static final WeiboSsoManager instance = new WeiboSsoManager();

        private Instance() {
        }
    }

    private WeiboSsoManager() {
    }

    public static synchronized WeiboSsoManager getInstance() {
        WeiboSsoManager weiboSsoManager;
        synchronized (WeiboSsoManager.class) {
            weiboSsoManager = Instance.instance;
        }
        return weiboSsoManager;
    }

    public void init(Context context, String str) {
        LogUtil.d("WeiboSsoManager", "init config");
        WeiboSsoSdkConfig weiboSsoSdkConfig = new WeiboSsoSdkConfig();
        weiboSsoSdkConfig.setContext(context);
        weiboSsoSdkConfig.setAppKey(str);
        weiboSsoSdkConfig.setFrom("1478195010");
        weiboSsoSdkConfig.setWm("1000_0001");
        WeiboSsoSdk.initConfig(weiboSsoSdkConfig);
        initAid();
    }

    private void initAid() {
        try {
            WeiboSsoSdk.getInstance().visitorLogin(new VisitorLoginListener() {
                /* class com.sina.weibo.sdk.sso.WeiboSsoManager.AnonymousClass1 */

                @Override // com.weibo.ssosdk.VisitorLoginListener
                public void handler(WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo) {
                    if (visitorLoginInfo != null) {
                        WeiboSsoManager.this.aid = visitorLoginInfo.getAid();
                        return;
                    }
                    LogUtil.d("WeiboSsoManager", "VisitorLoginInfo is null.");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("WeiboSsoManager", e.getMessage());
        }
    }

    public String getAid(Context context, String str) {
        LogUtil.d("WeiboSsoManager", "getAid()");
        if (TextUtils.isEmpty(this.aid)) {
            init(context, str);
        }
        return this.aid;
    }

    public String getMfp(Context context) {
        return MfpBuilder.getMfp(context);
    }
}
