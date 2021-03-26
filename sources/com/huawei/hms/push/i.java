package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;

/* compiled from: PushClientBuilder */
public class i extends AbstractClientBuilder<h, Api.ApiOptions.NoOptions> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public h buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        clientSettings.setApiName(Arrays.asList("HuaweiPush.API", "Core.API"));
        return new h(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
