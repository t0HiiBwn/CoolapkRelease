package com.coolapk.market.view.album;

import android.text.style.URLSpan;
import com.coolapk.market.model.Album;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.base.CopyFreeActionItem;
import com.coolapk.market.view.base.CopyUserActionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumItemDialog.kt */
final class AlbumItemDialog$buildMultiActionItem$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ Album $album;
    final /* synthetic */ Ref.ObjectRef $spanList;
    final /* synthetic */ AlbumItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumItemDialog$buildMultiActionItem$1(AlbumItemDialog albumItemDialog, Album album, Ref.ObjectRef objectRef) {
        super(1);
        this.this$0 = albumItemDialog;
        this.$album = album;
        this.$spanList = objectRef;
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
        String string = this.this$0.getString(2131886774);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_copy_content)");
        String string2 = this.this$0.getString(2131886775);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_dialog_copy_free)");
        String string3 = this.this$0.getString(2131886423);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.menu_action_copy_link)");
        list.add(new CopyActionItem(string3, "https://www.coolapk.com" + this.$album.getUrl() + " "));
        String allLinkAndText = StringUtils.getAllLinkAndText(this.$album.getIntroduce());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(album.introduce)");
        list.add(new CopyActionItem(string, LinkTextUtils.reconvert(allLinkAndText)));
        String allLinkAndText2 = StringUtils.getAllLinkAndText(this.$album.getIntroduce());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText2, "StringUtils.getAllLinkAndText(album.introduce)");
        list.add(new CopyFreeActionItem(string2, LinkTextUtils.reconvert(allLinkAndText2)));
        String userName = this.$album.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName, "album.userName");
        list.add(new CopyUserActionItem(userName));
        for (URLSpan uRLSpan : this.$spanList.element) {
            String url = uRLSpan.getURL();
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
                String string4 = this.this$0.getString(2131886776, url);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.str_dialog_copy_something, url)");
                list.add(new CopyActionItem(string4, url));
            }
        }
    }
}
