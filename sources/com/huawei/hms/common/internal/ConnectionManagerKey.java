package com.huawei.hms.common.internal;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;

public class ConnectionManagerKey<TOption extends Api.ApiOptions> {
    private final Api<TOption> a;
    private final TOption b;
    private final boolean c = false;
    private final int d;
    private final String e;
    private final Context f;

    private ConnectionManagerKey(Context context, Api<TOption> api, TOption toption, String str) {
        this.f = context;
        this.a = api;
        this.b = toption;
        this.d = Objects.hashCode(context, api, toption);
        this.e = str;
    }

    private ConnectionManagerKey(Api<TOption> api, String str) {
        this.a = api;
        this.b = null;
        this.d = System.identityHashCode(this);
        this.e = str;
        this.f = null;
    }

    public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Context context, Api<TOption> api, TOption toption, String str) {
        return new ConnectionManagerKey<>(context, api, toption, str);
    }

    public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Api<TOption> api, String str) {
        return new ConnectionManagerKey<>(api, str);
    }

    public final int hashCode() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionManagerKey)) {
            return false;
        }
        ConnectionManagerKey connectionManagerKey = (ConnectionManagerKey) obj;
        if (this.c != connectionManagerKey.c || !Objects.equal(this.a, connectionManagerKey.a) || !Objects.equal(this.b, connectionManagerKey.b) || !Objects.equal(this.e, connectionManagerKey.e) || !Objects.equal(this.f, connectionManagerKey.f)) {
            return false;
        }
        return true;
    }
}
