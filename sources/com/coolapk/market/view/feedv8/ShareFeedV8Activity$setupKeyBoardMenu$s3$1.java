package com.coolapk.market.view.feedv8;

import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feedv8/ShareFeedV8Activity$setupKeyBoardMenu$s3$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "show", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShareFeedV8Activity.kt */
public final class ShareFeedV8Activity$setupKeyBoardMenu$s3$1 extends EmptySubscriber<Boolean> {
    final /* synthetic */ ShareFeedV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ShareFeedV8Activity$setupKeyBoardMenu$s3$1(ShareFeedV8Activity shareFeedV8Activity) {
        this.this$0 = shareFeedV8Activity;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public /* bridge */ /* synthetic */ void onNext(Object obj) {
        onNext(((Boolean) obj).booleanValue());
    }

    public void onNext(boolean z) {
        super.onNext((ShareFeedV8Activity$setupKeyBoardMenu$s3$1) Boolean.valueOf(z));
        if (z) {
            this.this$0.getBinding$presentation_coolapkAppRelease().menuCloseKeyboard.setImageResource(2131231384);
        } else {
            this.this$0.getBinding$presentation_coolapkAppRelease().menuCloseKeyboard.setImageResource(2131231385);
        }
    }
}
