package com.coolapk.market.view.dyhv8;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.UserAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailFragment.kt */
final class DyhArticleDetailFragment$setupCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ DyhArticleDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DyhArticleDetailFragment$setupCommentBar$1(DyhArticleDetailFragment dyhArticleDetailFragment) {
        super(1);
        this.this$0 = dyhArticleDetailFragment;
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
        switch (view.getId()) {
            case 2131362289:
                ActionManager.startFeedCommentActivity(this.this$0.getActivity(), "dyh_article_comment", this.this$0.getDyhArticle().getId(), this.this$0.getDyhArticle().getUserName());
                return;
            case 2131362296:
                this.this$0.scrollToCommentPosition();
                return;
            case 2131362862:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        DyhArticleDetailPresenter access$getDyhArticleDetailPresenter$p = DyhArticleDetailFragment.access$getDyhArticleDetailPresenter$p(this.this$0);
                        UserAction userAction = DyhArticleDetailFragment.access$getDyhArticleDetailPresenter$p(this.this$0).getDyhArticle().getUserAction();
                        boolean z = true;
                        if (userAction == null || userAction.getLike() != 1) {
                            z = false;
                        }
                        access$getDyhArticleDetailPresenter$p.likeFeed(z);
                        return;
                    }
                    return;
                }
                return;
            case 2131363374:
                ActionManager.startForwardEntityActivity(this.this$0.getActivity(), this.this$0.getDyhArticle());
                return;
            case 2131363436:
                Activity currentActivity2 = AppHolder.getCurrentActivity();
                if (currentActivity2 != null) {
                    Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                    Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                    if (checkLogin2.booleanValue()) {
                        ActionManager.startCollectionSelectActivity(this.this$0.getActivity(), this.this$0.getDyhArticle().getId(), "article");
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
