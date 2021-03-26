package com.coolapk.market.view.feedv8;

import android.net.Uri;
import android.text.TextUtils;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$prepareMultiFeed$4$call$1<R> implements Func0<Observable<Boolean>> {
    final /* synthetic */ List $imageUrls;
    final /* synthetic */ FeedMultiPart $multiPart;
    final /* synthetic */ BaseFeedContentHolder$prepareMultiFeed$4 this$0;

    BaseFeedContentHolder$prepareMultiFeed$4$call$1(BaseFeedContentHolder$prepareMultiFeed$4 baseFeedContentHolder$prepareMultiFeed$4, List list, FeedMultiPart feedMultiPart) {
        this.this$0 = baseFeedContentHolder$prepareMultiFeed$4;
        this.$imageUrls = list;
        this.$multiPart = feedMultiPart;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<Boolean> call() {
        String path;
        for (int i = 0; i < this.$imageUrls.size(); i++) {
            ImageUrl imageUrl = (ImageUrl) this.$imageUrls.get(i);
            BaseFeedContentHolder$prepareMultiFeed$4 baseFeedContentHolder$prepareMultiFeed$4 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
            if (baseFeedContentHolder$prepareMultiFeed$4.isImageNeedCompress(imageUrl)) {
                Uri parse = Uri.parse(imageUrl.getSourceUrl());
                Intrinsics.checkNotNullExpressionValue(parse, "source");
                if (TextUtils.equals(parse.getScheme(), "content") && (path = BitmapUtil.getPath(this.this$0.this$0.getActivity(), parse)) != null) {
                    parse = Uri.parse(CoolFileUtils.wrap(path));
                }
                ImageUrl first = BitmapUtil.compressImage(this.this$0.this$0.getActivity(), parse.toString(), this.$multiPart.compressFlag()).toBlocking().first();
                List list = this.$imageUrls;
                String sourceUrl = imageUrl.getSourceUrl();
                Intrinsics.checkNotNullExpressionValue(first, "file");
                list.set(i, ImageUrl.create(sourceUrl, first.getCompressedUrl(), imageUrl.getUploadDir()));
            }
        }
        return Observable.just(true);
    }
}
