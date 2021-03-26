package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.SecondHandCommentBarBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailFragmentV8.kt */
final class FeedDetailFragmentV8$setupSecondHandCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SecondHandCommentBarViewPart $viewPart;
    final /* synthetic */ FeedDetailFragmentV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailFragmentV8$setupSecondHandCommentBar$1(FeedDetailFragmentV8 feedDetailFragmentV8, SecondHandCommentBarViewPart secondHandCommentBarViewPart) {
        super(1);
        this.this$0 = feedDetailFragmentV8;
        this.$viewPart = secondHandCommentBarViewPart;
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
        boolean z = false;
        switch (view.getId()) {
            case 2131362291:
                ActionManager.startFeedCommentActivity(this.this$0.getActivity(), this.this$0.getFeed$presentation_coolapkAppRelease().getId(), this.this$0.getFeed$presentation_coolapkAppRelease().getUserName());
                return;
            case 2131362624:
                SecondHandInfo secondHandInfo = this.this$0.getFeed$presentation_coolapkAppRelease().getSecondHandInfo();
                Intrinsics.checkNotNull(secondHandInfo);
                Intrinsics.checkNotNullExpressionValue(secondHandInfo, "feed.secondHandInfo!!");
                if (secondHandInfo.getSecondHandStatus() < 0) {
                    z = true;
                }
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                if (!Intrinsics.areEqual(loginSession.getUid(), this.this$0.getFeed$presentation_coolapkAppRelease().getUid()) || z) {
                    SecondHandInfo secondHandInfo2 = this.this$0.getFeed$presentation_coolapkAppRelease().getSecondHandInfo();
                    Intrinsics.checkNotNull(secondHandInfo2);
                    Intrinsics.checkNotNullExpressionValue(secondHandInfo2, "feed.secondHandInfo!!");
                    ActionManager.startWebViewActivity(this.this$0.getActivity(), secondHandInfo2.getUrl());
                    return;
                }
                ConfirmDialog newInstance = ConfirmDialog.newInstance("", "你确定交易已完成么？商品链接将不再对他人可见");
                newInstance.setOnOkRunnable(new Runnable(this) {
                    /* class com.coolapk.market.view.feed.reply.FeedDetailFragmentV8$setupSecondHandCommentBar$1.AnonymousClass3 */
                    final /* synthetic */ FeedDetailFragmentV8$setupSecondHandCommentBar$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = ((SecondHandCommentBarBinding) this.this$0.$viewPart.getBinding()).goToSecongHand;
                        Intrinsics.checkNotNullExpressionValue(textView, "viewPart.binding.goToSecongHand");
                        textView.setVisibility(8);
                        ProgressBar progressBar = ((SecondHandCommentBarBinding) this.this$0.$viewPart.getBinding()).loadingView;
                        Intrinsics.checkNotNullExpressionValue(progressBar, "viewPart.binding.loadingView");
                        progressBar.setVisibility(0);
                        DataManager.getInstance().changeStatus(this.this$0.this$0.getFeed$presentation_coolapkAppRelease().getId(), "-1").compose(RxUtils.apiCommonToData()).subscribe(new Action1<Feed>(this) {
                            /* class com.coolapk.market.view.feed.reply.FeedDetailFragmentV8$setupSecondHandCommentBar$1.AnonymousClass3.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass3 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void call(Feed feed) {
                                ProgressBar progressBar = ((SecondHandCommentBarBinding) this.this$0.this$0.$viewPart.getBinding()).loadingView;
                                Intrinsics.checkNotNullExpressionValue(progressBar, "viewPart.binding.loadingView");
                                progressBar.setVisibility(8);
                                FeedDetailPresenter feedPresenter$presentation_coolapkAppRelease = this.this$0.this$0.this$0.getFeedPresenter$presentation_coolapkAppRelease();
                                Intrinsics.checkNotNullExpressionValue(feed, "it");
                                feedPresenter$presentation_coolapkAppRelease.updateFeed(feed);
                                SecondHandCommentBarViewPart secondHandCommentBarViewPart = this.this$0.this$0.$viewPart;
                                SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
                                Intrinsics.checkNotNull(secondHandInfo);
                                Intrinsics.checkNotNullExpressionValue(secondHandInfo, "it.secondHandInfo!!");
                                secondHandCommentBarViewPart.changeStatus(secondHandInfo.getSecondHandStatus() < 0);
                            }
                        }, new Action1<Throwable>(this) {
                            /* class com.coolapk.market.view.feed.reply.FeedDetailFragmentV8$setupSecondHandCommentBar$1.AnonymousClass3.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass3 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void call(Throwable th) {
                                ProgressBar progressBar = ((SecondHandCommentBarBinding) this.this$0.this$0.$viewPart.getBinding()).loadingView;
                                Intrinsics.checkNotNullExpressionValue(progressBar, "viewPart.binding.loadingView");
                                progressBar.setVisibility(8);
                                Toast.error(this.this$0.this$0.this$0.getActivity(), th);
                            }
                        });
                    }
                });
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                newInstance.show(childFragmentManager, (String) null);
                return;
            case 2131362851:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        FeedDetailPresenter feedPresenter$presentation_coolapkAppRelease = this.this$0.getFeedPresenter$presentation_coolapkAppRelease();
                        UserAction userAction = this.this$0.getFeed$presentation_coolapkAppRelease().getUserAction();
                        if (userAction != null && userAction.getLike() == 1) {
                            z = true;
                        }
                        feedPresenter$presentation_coolapkAppRelease.likeFeed(z);
                        return;
                    }
                    return;
                }
                return;
            case 2131363358:
                ActionManager.startForwardEntityActivity(this.this$0.getActivity(), this.this$0.getFeed$presentation_coolapkAppRelease());
                return;
            case 2131363418:
                Activity currentActivity2 = AppHolder.getCurrentActivity();
                if (currentActivity2 != null) {
                    Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                    Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                    if (checkLogin2.booleanValue()) {
                        ActionManager.startCollectionSelectActivity(this.this$0.getActivity(), this.this$0.getFeed$presentation_coolapkAppRelease().getId(), this.this$0.getFeed$presentation_coolapkAppRelease().getEntityType());
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
