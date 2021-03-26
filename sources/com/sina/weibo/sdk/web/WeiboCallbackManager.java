package com.sina.weibo.sdk.web;

import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAuthListener;
import java.util.HashMap;
import java.util.Map;

public class WeiboCallbackManager {
    private static WeiboCallbackManager sInstance;
    private Map<String, WbAuthListener> mWeiboAuthListenerMap = new HashMap();

    private WeiboCallbackManager() {
    }

    public static synchronized WeiboCallbackManager getInstance() {
        WeiboCallbackManager weiboCallbackManager;
        synchronized (WeiboCallbackManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboCallbackManager();
            }
            weiboCallbackManager = sInstance;
        }
        return weiboCallbackManager;
    }

    public synchronized WbAuthListener getWeiboAuthListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mWeiboAuthListenerMap.get(str);
    }

    public synchronized void setWeiboAuthListener(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str)) {
            if (wbAuthListener != null) {
                this.mWeiboAuthListenerMap.put(str, wbAuthListener);
            }
        }
    }

    public synchronized void removeWeiboAuthListener(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mWeiboAuthListenerMap.remove(str);
        }
    }

    public String genCallbackKey() {
        return String.valueOf(System.currentTimeMillis());
    }
}
