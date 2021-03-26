package com.bun.miitmdid.provider.asus;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class AsusProvider extends BaseProvider implements IDIDBinderStatusListener {
    private static final String TAG = "SDK call Asus: ";
    private Context context;
    public final SupplementaryDIDManager supplementaryDIDManager;

    public AsusProvider(Context context2) {
        this.context = context2;
        this.supplementaryDIDManager = new SupplementaryDIDManager(context2);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return (IBinder) Utils.rL(new Object[]{this, 46, 1606976968518L});
    }

    @Override // com.bun.miitmdid.provider.BaseProvider
    public void doStart() {
        Utils.rL(new Object[]{this, 47, 1606976968519L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 48, 1606976968520L})).booleanValue();
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void onError() {
        Utils.rL(new Object[]{this, 49, 1606976968521L});
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void onSuccess(IDidAidlInterface iDidAidlInterface) {
        Utils.rL(new Object[]{this, iDidAidlInterface, 50, 1606976968522L});
    }

    @Override // com.bun.miitmdid.provider.BaseProvider, com.bun.miitmdid.interfaces.InnerIdProvider
    public void shutDown() {
        Utils.rL(new Object[]{this, 51, 1606976968523L});
    }
}
