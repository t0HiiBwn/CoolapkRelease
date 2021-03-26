package com.bun.miitmdid.provider.freeme;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class FreemeProvider extends BaseProvider {
    private static final String TAG = "SDK call Freeme: ";
    private Context context;
    private String packagename;

    public FreemeProvider(Context context2) {
        this.context = context2;
        this.packagename = context2.getPackageName();
    }

    public static /* synthetic */ boolean access$002(FreemeProvider freemeProvider, boolean z) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = 53;
        objArr[4] = 1606976968525L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    public static /* synthetic */ String access$100(FreemeProvider freemeProvider) {
        Object[] objArr = new Object[4];
        objArr[1] = freemeProvider;
        objArr[2] = 54;
        objArr[3] = 1606976968526L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$202(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 55;
        objArr[4] = 1606976968527L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$302(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 56;
        objArr[4] = 1606976968528L;
        return (String) Utils.rL(objArr);
    }

    public static /* synthetic */ String access$402(FreemeProvider freemeProvider, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = freemeProvider;
        objArr[2] = str;
        objArr[3] = 57;
        objArr[4] = 1606976968529L;
        return (String) Utils.rL(objArr);
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 58, 1606976968530L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 59, 1606976968531L})).booleanValue();
    }
}
