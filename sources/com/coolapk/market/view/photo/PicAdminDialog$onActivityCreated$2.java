package com.coolapk.market.view.photo;

import com.coolapk.market.model.FileDetail;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/FileDetail;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: PicAdminDialog.kt */
final class PicAdminDialog$onActivityCreated$2<T> implements Action1<FileDetail> {
    final /* synthetic */ PicAdminDialog this$0;

    PicAdminDialog$onActivityCreated$2(PicAdminDialog picAdminDialog) {
        this.this$0 = picAdminDialog;
    }

    public final void call(FileDetail fileDetail) {
        if (fileDetail != null) {
            PicAdminDialog.access$updateList(this.this$0, fileDetail);
        }
    }
}
