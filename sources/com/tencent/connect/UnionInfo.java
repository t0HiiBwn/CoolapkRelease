package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
public class UnionInfo extends BaseApi {
    public static final String URL_GET_UNION_ID = "https://graph.qq.com/oauth2.0/me";

    public UnionInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getUnionId(IUiListener iUiListener) {
        Bundle a = a();
        a.putString("unionid", "1");
        HttpUtils.requestAsync(this.b, e.a(), "https://graph.qq.com/oauth2.0/me", a, "GET", new BaseApi.TempRequestListener(iUiListener));
    }
}
