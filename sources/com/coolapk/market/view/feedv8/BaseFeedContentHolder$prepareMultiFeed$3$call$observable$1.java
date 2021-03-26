package com.coolapk.market.view.feedv8;

import com.bumptech.glide.load.model.GlideUrl;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.PhotoUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$prepareMultiFeed$3$call$observable$1<R> implements Func0<Observable<Boolean>> {
    final /* synthetic */ List $imageUrls;
    final /* synthetic */ BaseFeedContentHolder$prepareMultiFeed$3 this$0;

    BaseFeedContentHolder$prepareMultiFeed$3$call$observable$1(BaseFeedContentHolder$prepareMultiFeed$3 baseFeedContentHolder$prepareMultiFeed$3, List list) {
        this.this$0 = baseFeedContentHolder$prepareMultiFeed$3;
        this.$imageUrls = list;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<Boolean> call() {
        List list = this.$imageUrls;
        Intrinsics.checkNotNullExpressionValue(list, "imageUrls");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageUrl imageUrl = (ImageUrl) this.$imageUrls.get(i);
            BaseFeedContentHolder$prepareMultiFeed$3 baseFeedContentHolder$prepareMultiFeed$3 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
            if (baseFeedContentHolder$prepareMultiFeed$3.isImageNeedDownload(imageUrl)) {
                File first = PhotoUtils.saveImageObservable(new GlideUrl(imageUrl.getSourceUrl()), BitmapUtil.generateFileOutputPath(this.this$0.this$0.getActivity(), imageUrl.getSourceUrl()), true).toBlocking().first();
                List list2 = this.$imageUrls;
                String sourceUrl = imageUrl.getSourceUrl();
                Intrinsics.checkNotNullExpressionValue(first, "file");
                list2.set(i, ImageUrl.create(sourceUrl, CoolFileUtils.wrap(first.getAbsolutePath()), imageUrl.getUploadDir()));
            }
        }
        return Observable.just(true);
    }
}
