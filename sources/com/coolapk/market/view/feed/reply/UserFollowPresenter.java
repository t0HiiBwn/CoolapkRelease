package com.coolapk.market.view.feed.reply;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feed/reply/UserFollowPresenter;", "", "resultHandler", "Lkotlin/Function2;", "", "", "", "(Lkotlin/jvm/functions/Function2;)V", "isPostingFollow", "()Z", "setPostingFollow", "(Z)V", "followUser", "isFollowing", "uid", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFollowPresenter.kt */
public final class UserFollowPresenter {
    private boolean isPostingFollow;
    private final Function2<Boolean, Throwable, Unit> resultHandler;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public UserFollowPresenter(Function2<? super Boolean, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "resultHandler");
        this.resultHandler = function2;
    }

    public final boolean isPostingFollow() {
        return this.isPostingFollow;
    }

    public final void setPostingFollow(boolean z) {
        this.isPostingFollow = z;
    }

    public final void followUser(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        if (!this.isPostingFollow) {
            this.isPostingFollow = true;
            if (z) {
                DataManager.getInstance().unfollowUser(str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new UserFollowPresenter$followUser$1(this, z));
            } else {
                DataManager.getInstance().followUser(str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new UserFollowPresenter$followUser$2(this, z));
            }
        }
    }
}
