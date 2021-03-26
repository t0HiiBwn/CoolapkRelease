package com.coolapk.market.view.backupList;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.network.Result;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0000\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012F\u0010\u0005\u001aB\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u0006H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/BackupInfo;", "kotlin.jvm.PlatformType", "it", "", "", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupListActivity.kt */
final class BackupListActivity$postAppList$3<T, R> implements Func1<Map<String, String>, Observable<? extends Result<BackupInfo>>> {
    final /* synthetic */ Ref.ObjectRef $id;

    BackupListActivity$postAppList$3(Ref.ObjectRef objectRef) {
        this.$id = objectRef;
    }

    public final Observable<? extends Result<BackupInfo>> call(Map<String, String> map) {
        return DataManager.getInstance().coverPic(new Gson().toJson(map), this.$id.element);
    }
}
