package com.coolapk.market.view.feedv8;

import android.app.Activity;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.CoolFileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feedv8/ArticleFeedBaseContentHolder$compressAndCrop$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/ImageUrl;", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleFeedBaseContentHolder.kt */
public final class ArticleFeedBaseContentHolder$compressAndCrop$2 extends EmptySubscriber<ImageUrl> {
    final /* synthetic */ String $tempFilePath;
    final /* synthetic */ ArticleFeedBaseContentHolder this$0;

    ArticleFeedBaseContentHolder$compressAndCrop$2(ArticleFeedBaseContentHolder articleFeedBaseContentHolder, String str) {
        this.this$0 = articleFeedBaseContentHolder;
        this.$tempFilePath = str;
    }

    public void onNext(ImageUrl imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "t");
        super.onNext((ArticleFeedBaseContentHolder$compressAndCrop$2) imageUrl);
        Activity activity = this.this$0.getActivity();
        String unwrap = CoolFileUtils.unwrap(imageUrl.getCompressedUrl());
        Intrinsics.checkNotNullExpressionValue(unwrap, "CoolFileUtils.unwrap(t.compressedUrl)");
        ActionManagerCompat.startUCropActivity$default(activity, unwrap, new File(this.$tempFilePath), 2.2222223f, 1600, 720, null, 64, null);
    }
}
