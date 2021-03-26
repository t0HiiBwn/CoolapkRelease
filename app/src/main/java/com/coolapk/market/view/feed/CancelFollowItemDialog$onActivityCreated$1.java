package com.coolapk.market.view.feed;

import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CancelFollowItemDialog.kt */
final class CancelFollowItemDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ CancelFollowItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CancelFollowItemDialog$onActivityCreated$1(CancelFollowItemDialog cancelFollowItemDialog) {
        super(1);
        this.this$0 = cancelFollowItemDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0069  */
    public final void invoke(List<ActionItem> list) {
        String str;
        Entity access$getEntity$p;
        String str2;
        Intrinsics.checkNotNullParameter(list, "it");
        String entityType = CancelFollowItemDialog.access$getEntity$p(this.this$0).getEntityType();
        if (entityType != null) {
            int hashCode = entityType.hashCode();
            if (hashCode != -567451565) {
                if (hashCode == 110546223 && entityType.equals("topic")) {
                    str = CancelFollowItemDialog.access$getEntity$p(this.this$0).getTitle();
                    access$getEntity$p = CancelFollowItemDialog.access$getEntity$p(this.this$0);
                    if (access$getEntity$p instanceof Feed) {
                        str2 = ((Feed) access$getEntity$p).getFeedType();
                    } else {
                        str2 = access$getEntity$p.getEntityType();
                    }
                    CancelFollowItemDialog cancelFollowItemDialog = this.this$0;
                    Intrinsics.checkNotNull(str);
                    Intrinsics.checkNotNullExpressionValue(str2, "type");
                    MultiItemDialogFragmentKt.addItem(list, new CancelFollowItemDialog.CancelFollowActionItem(cancelFollowItemDialog, str, str2));
                }
            } else if (entityType.equals("contacts")) {
                Entity access$getEntity$p2 = CancelFollowItemDialog.access$getEntity$p(this.this$0);
                Objects.requireNonNull(access$getEntity$p2, "null cannot be cast to non-null type com.coolapk.market.model.Contacts");
                str = ((Contacts) access$getEntity$p2).getFollowUid();
                access$getEntity$p = CancelFollowItemDialog.access$getEntity$p(this.this$0);
                if (access$getEntity$p instanceof Feed) {
                }
                CancelFollowItemDialog cancelFollowItemDialog = this.this$0;
                Intrinsics.checkNotNull(str);
                Intrinsics.checkNotNullExpressionValue(str2, "type");
                MultiItemDialogFragmentKt.addItem(list, new CancelFollowItemDialog.CancelFollowActionItem(cancelFollowItemDialog, str, str2));
            }
        }
        str = CancelFollowItemDialog.access$getEntity$p(this.this$0).getId();
        access$getEntity$p = CancelFollowItemDialog.access$getEntity$p(this.this$0);
        if (access$getEntity$p instanceof Feed) {
        }
        CancelFollowItemDialog cancelFollowItemDialog = this.this$0;
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNullExpressionValue(str2, "type");
        MultiItemDialogFragmentKt.addItem(list, new CancelFollowItemDialog.CancelFollowActionItem(cancelFollowItemDialog, str, str2));
    }
}
