package com.coolapk.market.view.backupList;

import com.coolapk.market.manager.DataManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u0001\u0012F\b\u0001\u0012B\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002 \u0004*L\u0012F\b\u0001\u0012B\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u0002\u0018\u00010\u00010\u00012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "", "kotlin.jvm.PlatformType", "", "it", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupListActivity.kt */
final class BackupListActivity$postAppList$2<T, R> implements Func1<List<? extends String>, Observable<? extends Map<String, String>>> {
    final /* synthetic */ BackupListActivity this$0;

    BackupListActivity$postAppList$2(BackupListActivity backupListActivity) {
        this.this$0 = backupListActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<String, String>> call(List<? extends String> list) {
        return call((List<String>) list);
    }

    public final Observable<? extends Map<String, String>> call(List<String> list) {
        return DataManager.getInstance().uploadBackupLogoImage(list, this.this$0.getActivity());
    }
}
