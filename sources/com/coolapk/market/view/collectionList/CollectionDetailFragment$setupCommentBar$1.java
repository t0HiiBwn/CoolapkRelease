package com.coolapk.market.view.collectionList;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CollectionDetailFragment.kt */
final class CollectionDetailFragment$setupCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ CollectionDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionDetailFragment$setupCommentBar$1(CollectionDetailFragment collectionDetailFragment) {
        super(1);
        this.this$0 = collectionDetailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        boolean z = false;
        if (id == 2131362582) {
            Activity currentActivity = AppHolder.getCurrentActivity();
            if (currentActivity != null) {
                Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                if (checkLogin.booleanValue()) {
                    CollectionDetailPresenter collectionPresenter$presentation_coolapkAppRelease = this.this$0.getCollectionPresenter$presentation_coolapkAppRelease();
                    UserAction userAction = CollectionDetailFragment.access$getCollection$p(this.this$0).getUserAction();
                    if (userAction != null && userAction.getFollow() == 1) {
                        z = true;
                    }
                    collectionPresenter$presentation_coolapkAppRelease.followCollection(z);
                }
            }
        } else if (id == 2131362851) {
            Activity currentActivity2 = AppHolder.getCurrentActivity();
            if (currentActivity2 != null) {
                Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                if (checkLogin2.booleanValue()) {
                    CollectionDetailPresenter collectionPresenter$presentation_coolapkAppRelease2 = this.this$0.getCollectionPresenter$presentation_coolapkAppRelease();
                    UserAction userAction2 = CollectionDetailFragment.access$getCollection$p(this.this$0).getUserAction();
                    if (userAction2 != null && userAction2.getLike() == 1) {
                        z = true;
                    }
                    collectionPresenter$presentation_coolapkAppRelease2.likeCollection(z);
                }
            }
        } else if (id == 2131363358) {
            if (!CollectionDetailFragment.access$getCollection$p(this.this$0).getIsOpened()) {
                Toast.show$default(this.this$0.getActivity(), "该收藏单为私密收藏单，无法分享", 0, false, 12, null);
            } else {
                ActionManager.shareText(this.this$0.getActivity(), CollectionDetailFragment.access$getCollection$p(this.this$0));
            }
        }
    }
}
