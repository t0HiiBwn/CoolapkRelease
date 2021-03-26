package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/FeedMultiPart;", "kotlin.jvm.PlatformType", "feedMultiPart", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: RatingContentHolderVX1.kt */
final class RatingContentHolderVX1$prepareMultiFeed$1<T, R> implements Func1<FeedMultiPart, FeedMultiPart> {
    final /* synthetic */ RatingContentHolderVX1 this$0;

    RatingContentHolderVX1$prepareMultiFeed$1(RatingContentHolderVX1 ratingContentHolderVX1) {
        this.this$0 = ratingContentHolderVX1;
    }

    public final FeedMultiPart call(FeedMultiPart feedMultiPart) {
        List<ImageUrl> imageUriList = feedMultiPart.imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "feedMultiPart.imageUriList()");
        List<ImageUrl> list = imageUriList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (T t : list) {
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            linkedHashMap.put(t2.getSourceUrl(), t);
        }
        String commentGoodPic = feedMultiPart.commentGoodPic();
        Intrinsics.checkNotNullExpressionValue(commentGoodPic, "feedMultiPart.commentGoodPic()");
        ArrayList arrayList = new ArrayList();
        for (T t3 : StringsKt.split$default((CharSequence) commentGoodPic, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank(t3)) {
                arrayList.add(t3);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (T t4 : arrayList2) {
            if (linkedHashMap.containsKey(t4)) {
                Object obj = linkedHashMap.get(t4);
                Intrinsics.checkNotNull(obj);
                t4 = ((ImageUrl) obj).getCompressedUrl();
            }
            arrayList3.add(t4);
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList3, ",", null, null, 0, null, null, 62, null);
        String commentBadPic = feedMultiPart.commentBadPic();
        Intrinsics.checkNotNullExpressionValue(commentBadPic, "feedMultiPart.commentBadPic()");
        ArrayList arrayList4 = new ArrayList();
        for (T t5 : StringsKt.split$default((CharSequence) commentBadPic, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank(t5)) {
                arrayList4.add(t5);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        for (T t6 : arrayList5) {
            if (linkedHashMap.containsKey(t6)) {
                Object obj2 = linkedHashMap.get(t6);
                Intrinsics.checkNotNull(obj2);
                t6 = ((ImageUrl) obj2).getCompressedUrl();
            }
            arrayList6.add(t6);
        }
        String joinToString$default2 = CollectionsKt.joinToString$default(arrayList6, ",", null, null, 0, null, null, 62, null);
        String commentGeneralPic = feedMultiPart.commentGeneralPic();
        Intrinsics.checkNotNullExpressionValue(commentGeneralPic, "feedMultiPart.commentGeneralPic()");
        ArrayList arrayList7 = new ArrayList();
        for (T t7 : StringsKt.split$default((CharSequence) commentGeneralPic, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank(t7)) {
                arrayList7.add(t7);
            }
        }
        ArrayList arrayList8 = arrayList7;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
        for (T t8 : arrayList8) {
            if (linkedHashMap.containsKey(t8)) {
                Object obj3 = linkedHashMap.get(t8);
                Intrinsics.checkNotNull(obj3);
                t8 = ((ImageUrl) obj3).getCompressedUrl();
            }
            arrayList9.add(t8);
        }
        FeedMultiPart build = FeedMultiPart.builder(feedMultiPart).pic("").commentGoodPic(joinToString$default).commentBadPic(joinToString$default2).commentGeneralPic(CollectionsKt.joinToString$default(arrayList9, ",", null, null, 0, null, null, 62, null)).build();
        RatingContentHolderVX1 ratingContentHolderVX1 = this.this$0;
        Intrinsics.checkNotNullExpressionValue(build, "multiPart");
        ratingContentHolderVX1.updateMultiPart$presentation_coolapkAppRelease(build);
        return build;
    }
}
