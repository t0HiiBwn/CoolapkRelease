package com.bun.miitmdid.provider.vivo;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class VivoProvider extends BaseProvider {
    private static final String TAG = "SDK call Vivo: ";
    private String appID;
    private Context context;

    public VivoProvider(Context context2, String str) {
        this.context = context2;
        this.appID = str;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 94, 1606976968566L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 95, 1606976968567L})).booleanValue();
    }
}
