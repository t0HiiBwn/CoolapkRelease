package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.BaseWebViewRequestData;
import com.sina.weibo.sdk.web.WebRequestType;
import java.util.Objects;

public abstract class BaseWebViewRequestParam {
    private BaseWebViewRequestData baseData;
    protected Context context;
    private String transaction;

    public interface ExtraTaskCallback {
        void onComplete(String str);

        void onException(String str);
    }

    protected abstract void childFillBundle(Bundle bundle);

    public void doExtraTask(ExtraTaskCallback extraTaskCallback) {
    }

    public abstract String getRequestUrl();

    public boolean hasExtraTask() {
        return false;
    }

    protected abstract void transformChildBundle(Bundle bundle);

    public abstract void updateRequestUrl(String str);

    public BaseWebViewRequestParam() {
    }

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context2) {
        this(authInfo, webRequestType, str, 0, str2, str3, context2);
    }

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3, Context context2) {
        this.baseData = new BaseWebViewRequestData(authInfo, webRequestType, str, i, str2, str3);
        this.context = context2;
        this.transaction = String.valueOf(System.currentTimeMillis());
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public Context getContext() {
        return this.context;
    }

    public Bundle fillBundle(Bundle bundle) {
        BaseWebViewRequestData baseWebViewRequestData = this.baseData;
        Objects.requireNonNull(baseWebViewRequestData, "构造方法错误，请使用全参数的构造方法构建");
        bundle.putSerializable("base", baseWebViewRequestData);
        int i = AnonymousClass1.$SwitchMap$com$sina$weibo$sdk$web$WebRequestType[this.baseData.getType().ordinal()];
        if (i == 1) {
            bundle.putInt("type", 0);
        } else if (i == 2) {
            bundle.putInt("type", 1);
        } else if (i == 3) {
            bundle.putInt("type", 2);
        }
        bundle.putString("_weibo_transaction", this.transaction);
        childFillBundle(bundle);
        return bundle;
    }

    /* renamed from: com.sina.weibo.sdk.web.param.BaseWebViewRequestParam$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sina$weibo$sdk$web$WebRequestType;

        static {
            int[] iArr = new int[WebRequestType.values().length];
            $SwitchMap$com$sina$weibo$sdk$web$WebRequestType = iArr;
            try {
                iArr[WebRequestType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sina$weibo$sdk$web$WebRequestType[WebRequestType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sina$weibo$sdk$web$WebRequestType[WebRequestType.AUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void transformBundle(Bundle bundle) {
        this.baseData = (BaseWebViewRequestData) bundle.getSerializable("base");
        this.transaction = bundle.getString("_weibo_transaction");
        transformChildBundle(bundle);
    }

    public BaseWebViewRequestData getBaseData() {
        return this.baseData;
    }
}
