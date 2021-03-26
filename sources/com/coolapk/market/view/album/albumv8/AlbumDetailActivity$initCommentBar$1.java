package com.coolapk.market.view.album.albumv8;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
final class AlbumDetailActivity$initCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Album $album;
    final /* synthetic */ AlbumDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumDetailActivity$initCommentBar$1(AlbumDetailActivity albumDetailActivity, Album album) {
        super(1);
        this.this$0 = albumDetailActivity;
        this.$album = album;
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
        int i = 1;
        switch (view.getId()) {
            case 2131362284:
                ActionManager.startFeedCommentActivity(this.this$0.getActivity(), this.$album.getFeedId(), this.$album.getUserName());
                ScrollStateViewPager scrollStateViewPager = AlbumDetailActivity.access$getBinding$p(this.this$0).viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                scrollStateViewPager.setCurrentItem(1);
                return;
            case 2131362291:
                ScrollStateViewPager scrollStateViewPager2 = AlbumDetailActivity.access$getBinding$p(this.this$0).viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
                if (this.this$0.getCurrentPage() == 1) {
                    i = 0;
                }
                scrollStateViewPager2.setCurrentItem(i);
                return;
            case 2131362851:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        this.this$0.onLikeClick();
                        return;
                    }
                    return;
                }
                return;
            case 2131363358:
                ActionManager.shareText(this.this$0.getActivity(), this.$album);
                return;
            case 2131363418:
                Activity currentActivity2 = AppHolder.getCurrentActivity();
                if (currentActivity2 != null) {
                    Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                    Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                    if (checkLogin2.booleanValue()) {
                        this.this$0.onStarClick();
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
