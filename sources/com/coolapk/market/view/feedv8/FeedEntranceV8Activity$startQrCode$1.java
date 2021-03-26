package com.coolapk.market.view.feedv8;

import android.content.Intent;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.view.photo.QRCodeActivity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/feedv8/FeedEntranceV8Activity$startQrCode$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "aBoolean", "(Ljava/lang/Boolean;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
public final class FeedEntranceV8Activity$startQrCode$1 extends EmptySubscriber<Boolean> {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedEntranceV8Activity$startQrCode$1(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    public void onNext(Boolean bool) {
        super.onNext((FeedEntranceV8Activity$startQrCode$1) bool);
        this.this$0.getActivity().startActivity(new Intent(this.this$0.getActivity(), QRCodeActivity.class));
        this.this$0.finish();
    }
}
