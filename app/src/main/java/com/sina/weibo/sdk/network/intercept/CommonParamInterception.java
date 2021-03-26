package com.sina.weibo.sdk.network.intercept;

import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.sso.WeiboSsoManager;
import com.sina.weibo.sdk.utils.LogUtil;

public class CommonParamInterception implements IRequestIntercept {
    public static String aidInfo;
    private static String appKey;

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean needIntercept(IRequestParam iRequestParam, Bundle bundle) {
        return true;
    }

    public static void setAppKey(String str) {
        appKey = str;
    }

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean doIntercept(IRequestParam iRequestParam, Bundle bundle) throws InterceptException {
        Bundle bundle2;
        String str;
        if (TextUtils.isEmpty(aidInfo)) {
            aidInfo = WeiboSsoManager.getInstance().getAid(iRequestParam.getContext(), appKey);
        }
        if (!TextUtils.isEmpty(aidInfo)) {
            if (!TextUtils.isEmpty(aidInfo)) {
                bundle.putString("aid", aidInfo);
            }
            if (iRequestParam.getMethod() == IRequestParam.RequestType.GET) {
                bundle2 = iRequestParam.getGetBundle();
            } else {
                bundle2 = iRequestParam.getPostBundle();
            }
            Object obj = bundle2.get("access_token");
            Object obj2 = bundle2.get("refresh_token");
            Object obj3 = bundle2.get("phone");
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            } else if (obj2 == null || !(obj2 instanceof String)) {
                str = (obj3 == null || !(obj3 instanceof String)) ? "" : (String) obj3;
            } else {
                str = (String) obj2;
            }
            String timestamp = getTimestamp();
            bundle.putString("oauth_timestamp", timestamp);
            bundle.putString("oauth_sign", HttpManager.getOauthSign(iRequestParam.getContext(), aidInfo, str, appKey, timestamp));
            LogUtil.e("weiboSdk param", aidInfo + "  " + timestamp + "  " + appKey + "   " + str);
            return false;
        }
        throw new InterceptException("aid get error");
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}
