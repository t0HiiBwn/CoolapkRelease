package com.coolapk.market.view.userv9;

import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.userv9.UserSpaceV9Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
final class UserSpaceV9Activity$ChangeUserCoverFragment$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ UserProfile $userProfile;
    final /* synthetic */ UserSpaceV9Activity.ChangeUserCoverFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserSpaceV9Activity$ChangeUserCoverFragment$onActivityCreated$1(UserSpaceV9Activity.ChangeUserCoverFragment changeUserCoverFragment, UserProfile userProfile) {
        super(1);
        this.this$0 = changeUserCoverFragment;
        this.$userProfile = userProfile;
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
        MultiItemDialogFragmentKt.addItem(list, "更改个人主页背景图", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.userv9.UserSpaceV9Activity$ChangeUserCoverFragment$onActivityCreated$1.AnonymousClass1 */
            final /* synthetic */ UserSpaceV9Activity$ChangeUserCoverFragment$onActivityCreated$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                ActionManager.startChangeUserCover(this.this$0.this$0.getActivity(), this.this$0.$userProfile);
            }
        });
    }
}
