package com.coolapk.market.view.video;

import com.coolapk.market.widget.video.VideoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: VideoDetailListActivity.kt */
final /* synthetic */ class VideoDetailListActivity$onCreate$1 extends MutablePropertyReference0Impl {
    VideoDetailListActivity$onCreate$1(VideoDetailListActivity videoDetailListActivity) {
        super(videoDetailListActivity, VideoDetailListActivity.class, "videoModel", "getVideoModel()Lcom/coolapk/market/widget/video/VideoModel;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return VideoDetailListActivity.access$getVideoModel$p((VideoDetailListActivity) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((VideoDetailListActivity) this.receiver).videoModel = (VideoModel) obj;
    }
}
