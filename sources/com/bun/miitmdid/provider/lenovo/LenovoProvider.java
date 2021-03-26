package com.bun.miitmdid.provider.lenovo;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;
import com.zui.opendeviceidlibrary.OpenDeviceId;

public class LenovoProvider extends BaseProvider {
    private static final String TAG = "SDK call Lenovo: ";
    private Context context;
    private OpenDeviceId openDeviceId = new OpenDeviceId();

    public LenovoProvider(Context context2) {
        this.context = context2;
    }

    public static /* synthetic */ boolean access$002(LenovoProvider lenovoProvider, boolean z) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = 64;
        objArr[4] = 1606976968536L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    public static /* synthetic */ String access$102(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 65;
        objArr[4] = 1606976968537L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$202(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 66;
        objArr[4] = 1606976968538L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$302(LenovoProvider lenovoProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = lenovoProvider;
        objArr[2] = str;
        objArr[3] = 67;
        objArr[4] = 1606976968539L;
        return (String) Utils.rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 68, 1606976968540L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 69, 1606976968541L})).booleanValue();
    }
}
