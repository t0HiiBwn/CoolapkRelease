package com.coolapk.market.view.feed.reply;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.UserAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailFragmentV8.kt */
final class FeedDetailFragmentV8$setupCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FeedDetailFragmentV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailFragmentV8$setupCommentBar$1(FeedDetailFragmentV8 feedDetailFragmentV8) {
        super(1);
        this.this$0 = feedDetailFragmentV8;
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
                ActionManager.startFeedCommentActivity(this.this$0.getActivity(), this.this$0.getFeed$presentation_coolapkAppRelease().getId(), this.this$0.getFeed$presentation_coolapkAppRelease().getUserName());
                return;
            case 2131362296:
                this.this$0.scrollToCommentPosition();
                return;
            case 2131362862:
                Boolean checkLogin = ActionManager.checkLogin(this.this$0.getActivity());
                Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(activity)");
                if (checkLogin.booleanValue()) {
                    FeedDetailPresenter feedPresenter$presentation_coolapkAppRelease = this.this$0.getFeedPresenter$presentation_coolapkAppRelease();
                    UserAction userAction = this.this$0.getFeed$presentation_coolapkAppRelease().getUserAction();
                    boolean z = true;
                    if (userAction == null || userAction.getLike() != 1) {
                        z = false;
                    }
                    feedPresenter$presentation_coolapkAppRelease.likeFeed(z);
                    return;
                }
                StatisticHelper.Companion.getInstance().recordLoginClickEvent("点赞");
                return;
            case 2131363374:
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                String feedTypeName = this.this$0.getFeed$presentation_coolapkAppRelease().getFeedTypeName();
                if (feedTypeName == null) {
                    feedTypeName = this.this$0.getFeed$presentation_coolapkAppRelease().getFeedType();
                }
                Intrinsics.checkNotNullExpressionValue(feedTypeName, "feed.feedTypeName.elvis { feed.feedType }");
                instance.recordShareFeedEvent(feedTypeName, "点击底部toolbar上的分享");
                ActionManager.startForwardEntityActivity(this.this$0.getActivity(), this.this$0.getFeed$presentation_coolapkAppRelease());
                return;
            case 2131363436:
                Boolean checkLogin2 = ActionManager.checkLogin(this.this$0.getActivity());
                Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(activity)");
                if (checkLogin2.booleanValue()) {
                    ActionManager.startCollectionSelectActivity(this.this$0.getActivity(), this.this$0.getFeed$presentation_coolapkAppRelease().getId(), this.this$0.getFeed$presentation_coolapkAppRelease().getEntityType());
                    return;
                } else {
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("收藏");
                    return;
                }
            default:
                return;
        }
    }
}
