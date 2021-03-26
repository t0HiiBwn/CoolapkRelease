package com.coolapk.market.view.backupList;

import com.coolapk.market.model.DeviceInfo;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/DeviceInfo;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupCreatDialog.kt */
final class BackupCreateDialog$loadDeviceInfo$1<T> implements Action1<Result<DeviceInfo>> {
    final /* synthetic */ BackupCreateDialog this$0;

    BackupCreateDialog$loadDeviceInfo$1(BackupCreateDialog backupCreateDialog) {
        this.this$0 = backupCreateDialog;
    }

    public final void call(final Result<DeviceInfo> result) {
        if (this.this$0.isAdded()) {
            this.this$0.requireActivity().runOnUiThread(new Runnable(this) {
                /* class com.coolapk.market.view.backupList.BackupCreateDialog$loadDeviceInfo$1.AnonymousClass1 */
                final /* synthetic */ BackupCreateDialog$loadDeviceInfo$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BackupCreateDialog backupCreateDialog = this.this$0.this$0;
                    Result result = result;
                    Intrinsics.checkNotNullExpressionValue(result, "it");
                    Object data = result.getData();
                    Intrinsics.checkNotNullExpressionValue(data, "it.data");
                    backupCreateDialog.onDeviceInfoLoaded((DeviceInfo) data);
                }
            });
        }
    }
}
