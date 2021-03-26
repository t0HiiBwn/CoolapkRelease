package com.coolapk.market.view.feedv8;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import androidx.core.graphics.ColorUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feedv8/FeedEntranceV8Activity$initBackgroundImageView$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Landroid/graphics/Bitmap;", "onError", "", "e", "", "onNext", "bitmap", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
public final class FeedEntranceV8Activity$initBackgroundImageView$2 extends EmptySubscriber<Bitmap> {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedEntranceV8Activity$initBackgroundImageView$2(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    public void onNext(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        super.onNext((FeedEntranceV8Activity$initBackgroundImageView$2) bitmap);
        if (!this.this$0.isFinishing()) {
            this.this$0.hasImage = true;
            FeedEntranceV8Activity.access$getImageView$p(this.this$0).setImageBitmap(bitmap);
            FeedEntranceV8Activity.access$getBinding$p(this.this$0).maskView.setBackgroundColor(ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getContentBackgroundColor(), 128));
        }
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        if (!this.this$0.isFinishing()) {
            FeedEntranceV8Activity.access$getImageView$p(this.this$0).setImageDrawable(new ColorDrawable(ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getContentBackgroundColor(), 240)));
        }
    }
}
