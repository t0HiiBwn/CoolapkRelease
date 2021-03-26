package com.coolapk.market.view.live;

import com.coolapk.market.widget.video.VideoManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final class LiveVideoViewPart$showSelectLineView$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Map $requestParamsMap;
    final /* synthetic */ String $videoLineKey;
    final /* synthetic */ LiveVideoViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveVideoViewPart$showSelectLineView$2(LiveVideoViewPart liveVideoViewPart, String str, Map map) {
        super(1);
        this.this$0 = liveVideoViewPart;
        this.$videoLineKey = str;
        this.$requestParamsMap = map;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke(str);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        if ((!Intrinsics.areEqual(this.$videoLineKey, str)) && this.$requestParamsMap.get(this.$videoLineKey) != null) {
            this.this$0.getViewModel().setVideoLineKey(str);
            VideoManager.INSTANCE.getSharedPlayer().detachPlayerBridge();
            LiveVideoViewPart liveVideoViewPart = this.this$0;
            liveVideoViewPart.bindToContent(liveVideoViewPart.getPresenter().getLive());
        }
    }
}
