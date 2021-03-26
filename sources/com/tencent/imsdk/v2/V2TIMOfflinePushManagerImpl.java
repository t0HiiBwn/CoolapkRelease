package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMBackgroundParam;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.log.QLog;

public class V2TIMOfflinePushManagerImpl extends V2TIMOfflinePushManager {
    private final String TAG;

    private static class V2TIMOfflinePushManagerImplHolder {
        private static final V2TIMOfflinePushManagerImpl v2TIMOfflinePushManagerImpl = new V2TIMOfflinePushManagerImpl();

        private V2TIMOfflinePushManagerImplHolder() {
        }
    }

    static V2TIMOfflinePushManagerImpl getInstance() {
        return V2TIMOfflinePushManagerImplHolder.v2TIMOfflinePushManagerImpl;
    }

    private V2TIMOfflinePushManagerImpl() {
        this.TAG = "V2TIMOfflinePushManagerImpl";
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void setOfflinePushConfig(V2TIMOfflinePushConfig v2TIMOfflinePushConfig, final V2TIMCallback v2TIMCallback) {
        if (v2TIMOfflinePushConfig == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "config is null");
            }
            QLog.e("V2TIMOfflinePushManagerImpl", "setOfflinePushConfig config is null");
            return;
        }
        TIMManager.getInstance().setOfflinePushToken(v2TIMOfflinePushConfig.getTIMOfflinePushToken(), new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.AnonymousClass1 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void doBackground(int i, final V2TIMCallback v2TIMCallback) {
        if (i < 0) {
            i = 0;
        }
        TIMBackgroundParam tIMBackgroundParam = new TIMBackgroundParam();
        tIMBackgroundParam.setC2cUnread(i);
        TIMManager.getInstance().doBackground(tIMBackgroundParam, new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.AnonymousClass2 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void doForeground(final V2TIMCallback v2TIMCallback) {
        TIMManager.getInstance().doForeground(new TIMCallBack() {
            /* class com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.AnonymousClass3 */

            @Override // com.tencent.imsdk.TIMCallBack
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.TIMCallBack
            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        });
    }
}
