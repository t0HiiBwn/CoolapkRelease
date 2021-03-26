package com.bun.miitmdid.provider.oppo;

import XI.XI.K0.XI;
import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class OppoProvider extends BaseProvider {
    private static final String TAG = "SDK call Oppo: ";
    private Context context;

    public OppoProvider(Context context2) {
        XI.xo(context2);
        this.context = context2;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 83, 1606976968555L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 84, 1606976968556L})).booleanValue();
    }
}
