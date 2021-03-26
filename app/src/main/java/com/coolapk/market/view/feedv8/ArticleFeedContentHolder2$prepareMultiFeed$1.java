package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.view.feedv8.ArticleModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/FeedMultiPart;", "kotlin.jvm.PlatformType", "feedMultiPart", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedContentHolder2.kt */
final class ArticleFeedContentHolder2$prepareMultiFeed$1<T, R> implements Func1<FeedMultiPart, FeedMultiPart> {
    final /* synthetic */ ArticleFeedContentHolder2 this$0;

    ArticleFeedContentHolder2$prepareMultiFeed$1(ArticleFeedContentHolder2 articleFeedContentHolder2) {
        this.this$0 = articleFeedContentHolder2;
    }

    public final FeedMultiPart call(FeedMultiPart feedMultiPart) {
        String str;
        String str2;
        T t;
        boolean z;
        ImageUrl imageUrl;
        List<ImageUrl> imageUriList = feedMultiPart.imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "feedMultiPart.imageUriList()");
        List<ImageUrl> list = imageUriList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (T t2 : list) {
            T t3 = t2;
            Intrinsics.checkNotNullExpressionValue(t3, "it");
            linkedHashMap.put(t3.getSourceUrl(), t2);
        }
        List<ArticleModel> value = this.this$0.getArticleViewModel().getDataList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "articleViewModel.dataList.value!!");
        List mutableList = CollectionsKt.toMutableList((Collection) value);
        List list2 = mutableList;
        Iterator<T> it2 = list2.iterator();
        int i = 0;
        while (true) {
            str = "";
            boolean z2 = true;
            str2 = null;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t4 = next;
            if (t4 instanceof ArticleNative) {
                T t5 = t4;
                if (t5.getImageUrl().length() > 0) {
                    ImageUrl imageUrl2 = (ImageUrl) linkedHashMap.get(t5.getImageUrl());
                    if (imageUrl2 != null) {
                        String compressedUrl = imageUrl2.getCompressedUrl();
                        mutableList.set(i, ArticleNative.copy$default(t5, null, compressedUrl != null ? compressedUrl : str, null, 5, null));
                    }
                    i = i2;
                }
            }
            if (t4 instanceof ArticleImage) {
                T t6 = t4;
                if (t6.getImageUrl().length() <= 0) {
                    z2 = false;
                }
                if (z2 && (imageUrl = (ImageUrl) linkedHashMap.get(t6.getImageUrl())) != null) {
                    String compressedUrl2 = imageUrl.getCompressedUrl();
                    if (compressedUrl2 != null) {
                        str = compressedUrl2;
                    }
                    mutableList.set(i, ArticleImage.copy$default(t6, str, null, 2, null));
                }
            }
            i = i2;
        }
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t = null;
                break;
            }
            t = it3.next();
            if (t.getType() == ArticleModel.Type.Top) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t7 = t;
        FeedMultiPart.Builder message = FeedMultiPart.builder(feedMultiPart).pic(str).message(ArticleModelKt.toJson$default(mutableList, false, 1, null));
        String text = t7 != null ? t7.getText() : null;
        if (text == null) {
            text = str;
        }
        FeedMultiPart.Builder messageTitle = message.messageTitle(text);
        if (t7 != null) {
            str2 = t7.getImageUrl();
        }
        if (str2 != null) {
            str = str2;
        }
        FeedMultiPart build = messageTitle.messageCover(str).build();
        ArticleFeedContentHolder2 articleFeedContentHolder2 = this.this$0;
        Intrinsics.checkNotNullExpressionValue(build, "multiPart");
        articleFeedContentHolder2.updateMultiPart$presentation_coolapkAppRelease(build);
        return build;
    }
}
