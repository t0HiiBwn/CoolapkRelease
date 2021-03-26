package com.coolapk.market.view.backupList;

import android.text.TextUtils;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupHeaderViewholder.kt */
final class BackupHeaderViewholder$onClick$1<T> implements Action1<String> {
    final /* synthetic */ BackupHeaderViewholder this$0;

    BackupHeaderViewholder$onClick$1(BackupHeaderViewholder backupHeaderViewholder) {
        this.this$0 = backupHeaderViewholder;
    }

    public final void call(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.this$0.createList();
        }
    }
}
