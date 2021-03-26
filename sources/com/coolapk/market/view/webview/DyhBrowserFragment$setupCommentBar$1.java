package com.coolapk.market.view.webview;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.dyhv8.DyhArticleCommentBarViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhBrowserFragemnt.kt */
final class DyhBrowserFragment$setupCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ DyhBrowserFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DyhBrowserFragment$setupCommentBar$1(DyhBrowserFragment dyhBrowserFragment) {
        super(1);
        this.this$0 = dyhBrowserFragment;
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
        Integer num = 0;
        String str = "";
        switch (view.getId()) {
            case 2131362289:
                ActionManager.startFeedCommentActivity(this.this$0.getActivity(), "dyh_article_comment", DyhBrowserFragment.access$getDyhArticle$p(this.this$0).getId(), DyhBrowserFragment.access$getDyhArticle$p(this.this$0).getUserName());
                return;
            case 2131362296:
                ActionManager.startDyhArticleDetailActivity(this.this$0.getActivity(), DyhBrowserFragment.access$getDyhArticle$p(this.this$0).getId());
                return;
            case 2131362862:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue() && !(this.this$0.posting)) {
                        this.this$0.posting = true;
                        Observable.just(Boolean.valueOf(this.this$0.isLiked)).flatMap(new DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$1(this)).compose(RxUtils.apiCommonToData()).subscribe((Subscriber) new DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$2(this));
                        if (this.this$0.isLiked) {
                            DyhArticle access$getDyhArticle$p = DyhBrowserFragment.access$getDyhArticle$p(this.this$0);
                            Intrinsics.checkNotNull(access$getDyhArticle$p);
                            if (access$getDyhArticle$p.getLikeNum() - 1 > 0) {
                                DyhArticle access$getDyhArticle$p2 = DyhBrowserFragment.access$getDyhArticle$p(this.this$0);
                                Intrinsics.checkNotNull(access$getDyhArticle$p2);
                                str = String.valueOf(access$getDyhArticle$p2.getLikeNum() - 1);
                            }
                        } else {
                            DyhArticle access$getDyhArticle$p3 = DyhBrowserFragment.access$getDyhArticle$p(this.this$0);
                            Intrinsics.checkNotNull(access$getDyhArticle$p3);
                            str = String.valueOf(access$getDyhArticle$p3.getLikeNum() + 1);
                        }
                        DyhArticle.Builder newBuilder = DyhArticle.newBuilder(DyhBrowserFragment.access$getDyhArticle$p(this.this$0));
                        if (!TextUtils.isEmpty(str)) {
                            num = Integer.valueOf(str);
                        }
                        Intrinsics.checkNotNullExpressionValue(num, "if (TextUtils.isEmpty(ne…teger.valueOf(newLikeNum)");
                        DyhArticle.Builder likeNum = newBuilder.likeNum(num.intValue());
                        DyhArticle access$getDyhArticle$p4 = DyhBrowserFragment.access$getDyhArticle$p(this.this$0);
                        Intrinsics.checkNotNull(access$getDyhArticle$p4);
                        DyhArticle build = likeNum.userAction(UserAction.newBuilder(access$getDyhArticle$p4.getUserAction()).like(!this.this$0.isLiked ? 1 : 0).build()).build();
                        DyhBrowserFragment dyhBrowserFragment = this.this$0;
                        dyhBrowserFragment.isLiked = !dyhBrowserFragment.isLiked;
                        DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart = this.this$0.commentBarViewPart;
                        Intrinsics.checkNotNull(dyhArticleCommentBarViewPart);
                        Intrinsics.checkNotNullExpressionValue(build, "newDyhArticle");
                        dyhArticleCommentBarViewPart.bindToContent(build);
                        return;
                    }
                    return;
                }
                return;
            case 2131363374:
                ActionManager.startForwardEntityActivity(this.this$0.getActivity(), DyhBrowserFragment.access$getDyhArticle$p(this.this$0));
                return;
            case 2131363436:
                Activity currentActivity2 = AppHolder.getCurrentActivity();
                if (currentActivity2 != null) {
                    Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                    Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                    if (checkLogin2.booleanValue() && !(this.this$0.posting)) {
                        this.this$0.posting = true;
                        Observable.just(Boolean.valueOf(this.this$0.isFaved)).flatMap(new DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$3(this)).compose(RxUtils.apiCommonToData()).subscribe((Subscriber) new DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$4(this));
                        if (!(this.this$0.isFaved)) {
                            str = String.valueOf(DyhBrowserFragment.access$getDyhArticle$p(this.this$0).getFavNum() + 1);
                        } else if (DyhBrowserFragment.access$getDyhArticle$p(this.this$0).getFavNum() - 1 > 0) {
                            str = String.valueOf(DyhBrowserFragment.access$getDyhArticle$p(this.this$0).getFavNum() - 1);
                        }
                        DyhArticle.Builder newBuilder2 = DyhArticle.newBuilder(DyhBrowserFragment.access$getDyhArticle$p(this.this$0));
                        if (!TextUtils.isEmpty(str)) {
                            num = Integer.valueOf(str);
                        }
                        Intrinsics.checkNotNullExpressionValue(num, "if (TextUtils.isEmpty(ne…nteger.valueOf(newFavNum)");
                        DyhArticle build2 = newBuilder2.favNum(num.intValue()).userAction(UserAction.newBuilder(DyhBrowserFragment.access$getDyhArticle$p(this.this$0).getUserAction()).favorite(!this.this$0.isFaved ? 1 : 0).build()).build();
                        DyhBrowserFragment dyhBrowserFragment2 = this.this$0;
                        dyhBrowserFragment2.isFaved = !dyhBrowserFragment2.isFaved;
                        DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart2 = this.this$0.commentBarViewPart;
                        Intrinsics.checkNotNull(dyhArticleCommentBarViewPart2);
                        Intrinsics.checkNotNullExpressionValue(build2, "newDyhArticle");
                        dyhArticleCommentBarViewPart2.bindToContent(build2);
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
