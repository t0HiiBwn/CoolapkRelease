package com.coolapk.market.widget.video;

import com.coolapk.market.model.Video;
import com.coolapk.market.model.VideoUrls;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.widget.video.util.JsUrlDecodeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0014\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "subscriber", "Lrx/Subscriber;", "Lcom/coolapk/market/model/VideoUrls;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolApkDataProvider.kt */
final class CoolApkDataProvider$loadPlayerUrlObservable$1<T> implements Observable.OnSubscribe<VideoUrls> {
    final /* synthetic */ String $requestParams;
    final /* synthetic */ Video $video;

    CoolApkDataProvider$loadPlayerUrlObservable$1(String str, Video video) {
        this.$requestParams = str;
        this.$video = video;
    }

    public final void call(Subscriber<? super VideoUrls> subscriber) {
        Intrinsics.checkNotNullExpressionValue(subscriber, "subscriber");
        if (subscriber.isUnsubscribed()) {
            subscriber.onCompleted();
            return;
        }
        try {
            VideoUrls decodeRequestParams = JsUrlDecodeUtils.INSTANCE.decodeRequestParams(this.$requestParams, this.$video);
            if (!subscriber.isUnsubscribed()) {
                subscriber.onNext(decodeRequestParams);
            }
            subscriber.onCompleted();
        } catch (Exception e) {
            LogUtils.e("unsubscribe " + subscriber.isUnsubscribed() + ' ' + this.$requestParams, new Object[0]);
            if (subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            } else {
                subscriber.onError(e);
            }
        }
    }
}
