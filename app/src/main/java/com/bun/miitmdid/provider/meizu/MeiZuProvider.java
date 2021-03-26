package com.bun.miitmdid.provider.meizu;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class MeiZuProvider extends BaseProvider {
    private static final String TAG = "SDK call MeiZu: ";
    private Context context;

    public MeiZuProvider(Context context2) {
        this.context = context2;
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 71, 1606976968543L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 72, 1606976968544L})).booleanValue();
    }
}
