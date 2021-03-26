package com.coolapk.market.view.video;

import com.coolapk.market.widget.video.VideoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoFullScreenActivity.kt */
final /* synthetic */ class VideoFullScreenActivity$onCreate$1 extends MutablePropertyReference0Impl {
    VideoFullScreenActivity$onCreate$1(VideoFullScreenActivity videoFullScreenActivity) {
        super(videoFullScreenActivity, VideoFullScreenActivity.class, "videoModel", "getVideoModel()Lcom/coolapk/market/widget/video/VideoModel;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return VideoFullScreenActivity.access$getVideoModel$p((VideoFullScreenActivity) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((VideoFullScreenActivity) this.receiver).videoModel = (VideoModel) obj;
    }
}
