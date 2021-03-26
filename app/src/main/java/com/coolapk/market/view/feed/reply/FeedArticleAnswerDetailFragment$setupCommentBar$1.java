package com.coolapk.market.view.feed.reply;

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
/* compiled from: FeedArticleAnswerDetailFragment.kt */
final class FeedArticleAnswerDetailFragment$setupCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FeedArticleAnswerDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedArticleAnswerDetailFragment$setupCommentBar$1(FeedArticleAnswerDetailFragment feedArticleAnswerDetailFragment) {
        super(1);
        this.this$0 = feedArticleAnswerDetailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Activity currentActivity;
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131362284) {
            ActionManager.startFeedCommentActivity(this.this$0.getActivity(), this.this$0.getFeed$presentation_coolapkAppRelease().getId(), this.this$0.getFeed$presentation_coolapkAppRelease().getUserName());
        } else if (id == 2131362291) {
            this.this$0.scrollToCommentPosition();
        } else if (id == 2131362851 && (currentActivity = AppHolder.getCurrentActivity()) != null) {
            Boolean checkLogin = ActionManager.checkLogin(currentActivity);
            Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
            if (checkLogin.booleanValue()) {
                FeedDetailPresenter feedPresenter$presentation_coolapkAppRelease = this.this$0.getFeedPresenter$presentation_coolapkAppRelease();
                UserAction userAction = this.this$0.getFeed$presentation_coolapkAppRelease().getUserAction();
                boolean z = true;
                if (userAction == null || userAction.getLike() != 1) {
                    z = false;
                }
                feedPresenter$presentation_coolapkAppRelease.likeFeed(z);
            }
        }
    }
}
