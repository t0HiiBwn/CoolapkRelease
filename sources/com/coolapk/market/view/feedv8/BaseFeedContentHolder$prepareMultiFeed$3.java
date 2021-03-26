package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.ImageUrl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/BaseFeedContentHolder$prepareMultiFeed$3", "Lrx/functions/Func1;", "", "Lrx/Observable;", "call", "aBoolean", "(Ljava/lang/Boolean;)Lrx/Observable;", "isImageNeedDownload", "url", "Lcom/coolapk/market/model/ImageUrl;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
public final class BaseFeedContentHolder$prepareMultiFeed$3 implements Func1<Boolean, Observable<Boolean>> {
    final /* synthetic */ BaseFeedContentHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFeedContentHolder$prepareMultiFeed$3(BaseFeedContentHolder baseFeedContentHolder) {
        this.this$0 = baseFeedContentHolder;
    }

    public Observable<Boolean> call(Boolean bool) {
        Observable observable;
        List<ImageUrl> imageUriList = this.this$0.getMultiPart().imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "imageUrls");
        int size = imageUriList.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            ImageUrl imageUrl = imageUriList.get(i);
            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
            if (isImageNeedDownload(imageUrl)) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            observable = Observable.just(true);
        } else {
            observable = Observable.defer(new BaseFeedContentHolder$prepareMultiFeed$3$call$observable$1(this, imageUriList));
        }
        Observable<Boolean> observeOn = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "observable.subscribeOn(S…dSchedulers.mainThread())");
        return observeOn;
    }

    /* access modifiers changed from: private */
    public final boolean isImageNeedDownload(ImageUrl imageUrl) {
        String compressedUrl = imageUrl.getCompressedUrl();
        if (compressedUrl == null || !StringsKt.startsWith$default(compressedUrl, "http", false, 2, (Object) null)) {
            return false;
        }
        String uploadDir = this.this$0.getMultiPart().uploadDir();
        Intrinsics.checkNotNullExpressionValue(uploadDir, "multiPart.uploadDir()");
        if (!StringsKt.contains$default((CharSequence) compressedUrl, (CharSequence) uploadDir, false, 2, (Object) null)) {
            return true;
        }
        return false;
    }
}
