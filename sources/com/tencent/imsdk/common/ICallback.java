package com.tencent.imsdk.common;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMValueCallBack;

public abstract class ICallback<T> {
    protected TIMCallBack cb;
    protected TIMValueCallBack<T> valueCallback;

    protected ICallback(TIMCallBack tIMCallBack) {
        this.cb = tIMCallBack;
    }

    protected ICallback(TIMValueCallBack<T> tIMValueCallBack) {
        this.valueCallback = tIMValueCallBack;
    }

    public void done(final T t) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            /* class com.tencent.imsdk.common.ICallback.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.tencent.imsdk.TIMValueCallBack<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (ICallback.this.cb != null) {
                    ICallback.this.cb.onSuccess();
                } else if (ICallback.this.valueCallback != null) {
                    ICallback.this.valueCallback.onSuccess(t);
                }
            }
        });
    }

    public void fail(final int i, final String str) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            /* class com.tencent.imsdk.common.ICallback.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (ICallback.this.cb != null) {
                    ICallback.this.cb.onError(i, str);
                } else if (ICallback.this.valueCallback != null) {
                    ICallback.this.valueCallback.onError(i, str);
                }
            }
        });
    }
}
