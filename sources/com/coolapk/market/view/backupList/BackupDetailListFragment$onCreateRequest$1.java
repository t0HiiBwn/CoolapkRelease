package com.coolapk.market.view.backupList;

import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.LocalApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/BackupInfo;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupDetailListFragment.kt */
final class BackupDetailListFragment$onCreateRequest$1<T, R> implements Func1<Result<BackupInfo>, List<? extends Entity>> {
    final /* synthetic */ BackupDetailListFragment this$0;

    BackupDetailListFragment$onCreateRequest$1(BackupDetailListFragment backupDetailListFragment) {
        this.this$0 = backupDetailListFragment;
    }

    public final List<Entity> call(Result<BackupInfo> result) {
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(result, "it");
        if (result.getData() != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) result.getData();
            this.this$0.requireActivity().runOnUiThread(new Runnable(this) {
                /* class com.coolapk.market.view.backupList.BackupDetailListFragment$onCreateRequest$1.AnonymousClass1 */
                final /* synthetic */ BackupDetailListFragment$onCreateRequest$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BackupDetailListFragment backupDetailListFragment = this.this$0.this$0;
                    T t = objectRef.element;
                    Intrinsics.checkNotNullExpressionValue(t, "backupInfo");
                    backupDetailListFragment.onBackupLoaded(t);
                }
            });
            T t = objectRef.element;
            Intrinsics.checkNotNullExpressionValue(t, "backupInfo");
            List<ServiceApp> serviceApps = t.getServiceApps();
            Intrinsics.checkNotNull(serviceApps);
            Intrinsics.checkNotNullExpressionValue(serviceApps, "backupInfo.serviceApps!!");
            T t2 = objectRef.element;
            Intrinsics.checkNotNullExpressionValue(t2, "backupInfo");
            List<LocalApp> localApps = t2.getLocalApps();
            Intrinsics.checkNotNull(localApps);
            Intrinsics.checkNotNullExpressionValue(localApps, "backupInfo.localApps!!");
            HolderItem.Builder newBuilder = HolderItem.newBuilder();
            HolderItem build = newBuilder.string("未收录应用(" + localApps.size() + ')').entityType("backup_list_title_item").entityTemplate("backup_list_title_item").build();
            arrayList.addAll(serviceApps);
            List<LocalApp> list = localApps;
            if (CollectionUtils.safeSize(list) > 0) {
                Intrinsics.checkNotNullExpressionValue(build, "titleItem");
                arrayList.add(build);
            }
            arrayList.addAll(list);
        }
        return arrayList;
    }
}
