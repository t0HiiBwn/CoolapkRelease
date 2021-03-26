package com.bun.miitmdid.provider.zte;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class ZteProvider extends BaseProvider {
    private static final String TAG = "SDK call Zte: ";
    private Context context;
    private MsaClient msaClient;
    private String packgename;

    public ZteProvider(Context context2) {
        this.context = context2;
        String packageName = context2.getPackageName();
        this.packgename = packageName;
        if (!TextUtils.isEmpty(packageName)) {
            MsaClient.StartMsaKlService(this.context, this.packgename);
        }
    }

    public static /* synthetic */ boolean access$002(ZteProvider zteProvider, boolean z) {
        Object[] objArr = new Object[5];
        objArr[1] = zteProvider;
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = 125;
        objArr[4] = 1606976968597L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    public static /* synthetic */ MsaClient access$100(ZteProvider zteProvider) {
        Object[] objArr = new Object[4];
        objArr[1] = zteProvider;
        objArr[2] = 126;
        objArr[3] = 1606976968598L;
        return (MsaClient) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$202(ZteProvider zteProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = zteProvider;
        objArr[2] = str;
        objArr[3] = 127;
        objArr[4] = 1606976968599L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$302(ZteProvider zteProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = zteProvider;
        objArr[2] = str;
        objArr[3] = 128;
        objArr[4] = 1606976968600L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$402(ZteProvider zteProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = zteProvider;
        objArr[2] = str;
        objArr[3] = 129;
        objArr[4] = 1606976968601L;
        return (String) Utils.rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 130, 1606976968602L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 131, 1606976968603L})).booleanValue();
    }

    @Override // com.bun.miitmdid.provider.BaseProvider, com.bun.miitmdid.interfaces.InnerIdProvider
    public void shutDown() {
        Utils.rL(new Object[]{this, 132, 1606976968604L});
    }
}
