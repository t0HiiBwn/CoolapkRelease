package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;

public class a extends AGConnectInstance {
    private final Context a;
    private final c b;

    public a(Context context) {
        this.a = context;
        this.b = new c(new b(context).a());
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.a;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> cls) {
        return (T) this.b.a(this, cls);
    }
}
