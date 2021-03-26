package com.coolapk.market.view.feedv8;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¨\u0006\f"}, d2 = {"com/coolapk/market/view/feedv8/BaseFeedContentHolder$prepareMultiFeed$5", "Lrx/functions/Func1;", "", "Lrx/Observable;", "Lcom/coolapk/market/model/FeedMultiPart;", "call", "aBoolean", "(Ljava/lang/Boolean;)Lrx/Observable;", "uploadImage", "options", "", "Lcom/coolapk/market/model/ImageUploadOption;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
public final class BaseFeedContentHolder$prepareMultiFeed$5 implements Func1<Boolean, Observable<FeedMultiPart>> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ BaseFeedContentHolder this$0;

    BaseFeedContentHolder$prepareMultiFeed$5(BaseFeedContentHolder baseFeedContentHolder, ProgressDialog progressDialog) {
        this.this$0 = baseFeedContentHolder;
        this.$dialog = progressDialog;
    }

    public Observable<FeedMultiPart> call(Boolean bool) {
        Bundle bundle = new Bundle();
        if (this.this$0.getMultiPart().isAnonymous()) {
            bundle.putBoolean("extra_anonymous", true);
        }
        List<ImageUrl> imageUriList = this.this$0.getMultiPart().imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "multiPart.imageUriList()");
        List<ImageUrl> list = imageUriList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            String uploadDir = t.getUploadDir();
            arrayList.add(ImageUploadOption.create(t.getCompressedUrl(), uploadDir == null || uploadDir.length() == 0 ? this.this$0.getMultiPart().uploadDir() : t.getUploadDir(), "FEED", bundle));
        }
        return uploadImage(arrayList);
    }

    private final Observable<FeedMultiPart> uploadImage(List<? extends ImageUploadOption> list) {
        Observable<R> flatMap = DataManager.getInstance().uploadImage(list).compose(RxUtils.applyIOSchedulers()).doOnNext(BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$1.INSTANCE).doOnNext(new BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$2(this)).all(BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$3.INSTANCE).defaultIfEmpty(null).flatMap(new BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$4(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(…                        }");
        return flatMap;
    }
}
