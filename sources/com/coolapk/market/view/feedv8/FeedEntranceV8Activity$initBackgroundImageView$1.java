package com.coolapk.market.view.feedv8;

import android.graphics.Bitmap;
import com.coolapk.market.util.BlurUtils;
import kotlin.Metadata;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "bitmap", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$initBackgroundImageView$1<T, R> implements Func1<Bitmap, Bitmap> {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    FeedEntranceV8Activity$initBackgroundImageView$1(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    public final Bitmap call(Bitmap bitmap) {
        BlurUtils.fastBlur(this.this$0.getApplicationContext(), bitmap, 8.0f);
        return bitmap;
    }
}
