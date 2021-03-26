package com.coolapk.market.view.album;

import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.album.AlbumItemDialog;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumItemDialog.kt */
final class AlbumItemDialog$buildAdminActionItem$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ Album $album;
    final /* synthetic */ AlbumItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumItemDialog$buildAdminActionItem$1(AlbumItemDialog albumItemDialog, Album album) {
        super(1);
        this.this$0 = albumItemDialog;
        this.$album = album;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        boolean z = false;
        boolean z2 = this.$album.getStatus() == -1;
        boolean z3 = this.$album.getBlockStatus() == 1;
        boolean z4 = this.$album.getStatus() == -3;
        boolean z5 = this.$album.getIsHeadlineV8() == 0;
        if (this.$album.getRecommend() == 3) {
            z = true;
        }
        if (!z) {
            list.add(new AlbumItemDialog.HomePageActionItem(this.this$0, z5, this.$album));
        }
        list.add(new AlbumItemDialog.EditorChoiceActionItem(this.this$0, z, this.$album));
        if (this.$album.getRecommend() >= 0) {
            list.add(new AlbumItemDialog.NoHomePageActionItem(this.this$0, this.$album));
        }
        list.add(new AlbumItemDialog.PrivateActionItem(this.this$0, z2, this.$album));
        list.add(new AlbumItemDialog.BannedActionItem(this.this$0, z4, this.$album));
        list.add(new AlbumItemDialog.FoldedActionItem(this.this$0, z3, this.$album));
        list.add(new AlbumItemDialog.SoftFoldedActionItem(this.this$0, this.$album));
        list.add(new AlbumItemDialog.StatusActionItem(this.this$0, this.$album));
        MultiItemDialogFragmentKt.addItem(list, "作者管理", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.album.AlbumItemDialog$buildAdminActionItem$1.AnonymousClass1 */
            final /* synthetic */ AlbumItemDialog$buildAdminActionItem$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                String uid = this.this$0.$album.getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "album.uid");
                ActionManager.startWebViewActivity(this.this$0.this$0.getActivity(), UriUtils.getUserManageUrl(uid));
            }
        });
    }
}
