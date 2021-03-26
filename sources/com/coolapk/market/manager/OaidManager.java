package com.coolapk.market.manager;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/manager/OaidManager;", "Lcom/bun/miitmdid/interfaces/IIdentifierListener;", "()V", "<set-?>", "", "aaid", "getAaid", "()Ljava/lang/String;", "oaid", "getOaid", "vaid", "getVaid", "OnSupport", "", "isSupport", "", "_supplier", "Lcom/bun/miitmdid/interfaces/IdSupplier;", "init", "context", "Landroid/content/Context;", "loadDevicesIds", "cxt", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OaidManager.kt */
public final class OaidManager implements IIdentifierListener {
    public static final OaidManager INSTANCE = new OaidManager();
    private static String aaid;
    private static String oaid;
    private static String vaid;

    private OaidManager() {
    }

    public final String getOaid() {
        return oaid;
    }

    public final String getVaid() {
        return vaid;
    }

    public final String getAaid() {
        return aaid;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppHolder.getMainThreadHandler().postDelayed(new OaidManager$init$1(context), 200);
    }

    /* access modifiers changed from: private */
    public final void loadDevicesIds(Context context) {
        try {
            MdidSdkHelper.InitSdk(context, true, this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void OnSupport(boolean z, IdSupplier idSupplier) {
        if (idSupplier != null && z) {
            oaid = idSupplier.getOAID();
            vaid = idSupplier.getVAID();
            aaid = idSupplier.getAAID();
        }
    }
}
