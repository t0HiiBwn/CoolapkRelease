package com.tencent.imsdk.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.IMErrInfo;

public class IMContext {
    private final String TAG;
    private IContextFetcher contextFetcher;
    private Handler mainHandler;

    private static class Holder {
        public static IMContext instance = new IMContext();

        private Holder() {
        }
    }

    private IMContext() {
        this.TAG = IMContext.class.getSimpleName();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static IMContext getInstance() {
        return Holder.instance;
    }

    public Context getApplicationContext() {
        return this.contextFetcher.getContext();
    }

    public void init(IContextFetcher iContextFetcher) {
        this.contextFetcher = iContextFetcher;
    }

    public IContextFetcher getContextFetcher() {
        return this.contextFetcher;
    }

    public IMErrInfo readyCheck() {
        IMErrInfo iMErrInfo = new IMErrInfo(0, "");
        IContextFetcher iContextFetcher = this.contextFetcher;
        if (iContextFetcher == null || !iContextFetcher.isInited()) {
            iMErrInfo.setCode(6013);
            iMErrInfo.setMsg("sdk not initialized");
            QLog.e(this.TAG, "readyCheck, sdk not initialized");
        }
        if (!this.contextFetcher.isOnline()) {
            iMErrInfo.setCode(6014);
            iMErrInfo.setMsg("user not logged in");
            QLog.e(this.TAG, "readyCheck, user not logged in");
        }
        BaseConstants.convertErrorCode(iMErrInfo);
        return iMErrInfo;
    }

    public void runOnMainThread(Runnable runnable) {
        this.mainHandler.post(runnable);
    }
}
