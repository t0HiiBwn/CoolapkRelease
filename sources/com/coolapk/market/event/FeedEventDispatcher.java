package com.coolapk.market.event;

import com.coolapk.market.AppHolder;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.Vote;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/event/FeedEventDispatcher;", "", "()V", "dispatchLikeResult", "", "id", "", "error", "", "isLike", "", "likeResult", "Lcom/coolapk/market/model/LikeResult;", "dispatchVoteResult", "vote", "Lcom/coolapk/market/model/Vote;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventProcessor.kt */
public final class FeedEventDispatcher {
    public static final FeedEventDispatcher INSTANCE = new FeedEventDispatcher();

    private FeedEventDispatcher() {
    }

    public final void dispatchLikeResult(String str, Throwable th, boolean z, LikeResult likeResult) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (th == null) {
            EventBus.getDefault().post(new FeedLikeEvent(str, z, likeResult));
        } else {
            Toast.error(AppHolder.getApplication(), th);
        }
    }

    public final void dispatchVoteResult(Throwable th, Vote vote) {
        if (vote != null) {
            EventBus.getDefault().post(new FeedVoteEvent(vote));
        } else {
            Toast.error(AppHolder.getApplication(), th);
        }
    }
}
