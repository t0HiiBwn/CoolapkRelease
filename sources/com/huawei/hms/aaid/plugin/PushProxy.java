package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;

public interface PushProxy {
    void deleteToken(Context context) throws ApiException;

    int getProxyType();

    void getToken(Context context) throws ApiException;

    Task<Void> subscribe(Context context, String str);

    Task<Void> turnOff(Context context);

    Task<Void> turnOn(Context context);

    Task<Void> unsubscribe(Context context, String str);
}
