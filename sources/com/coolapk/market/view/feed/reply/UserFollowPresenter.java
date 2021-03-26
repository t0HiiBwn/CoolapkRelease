package com.coolapk.market.view.feed.reply;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

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
