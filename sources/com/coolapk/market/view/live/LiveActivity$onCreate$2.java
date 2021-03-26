package com.coolapk.market.view.live;

import android.widget.FrameLayout;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.view.danmaku.DanmakuManager;
import com.coolapk.market.view.danmaku.DanmakuText;
import com.coolapk.market.view.danmaku.DanmakuTextStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/live/LiveActivity$onCreate$2", "Lcom/coolapk/market/view/live/LiveDiscussPollCallback;", "onBubbleData", "", "data", "Lcom/coolapk/market/model/Entity;", "onDataLoaded", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
public final class LiveActivity$onCreate$2 implements LiveDiscussPollCallback {
    final /* synthetic */ LiveActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    LiveActivity$onCreate$2(LiveActivity liveActivity) {
        this.this$0 = liveActivity;
    }

    @Override // com.coolapk.market.view.live.LiveDiscussPollCallback
    public void onDataLoaded(List<? extends Entity> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        EventBus.getDefault().post(new LiveMessageEvent(1, null, "0", null, null, 26, null));
    }

    @Override // com.coolapk.market.view.live.LiveDiscussPollCallback
    public void onBubbleData(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) LiveActivity.access$getLiveVideoViewPart$p(this.this$0).getBinding()).danmakuFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "liveVideoViewPart.binding.danmakuFrame");
        if (frameLayout.getVisibility() == 0) {
            Live live = LiveActivity.access$getViewModel$p(this.this$0).getLive();
            Intrinsics.checkNotNull(live);
            LiveMessage asLiveMessage = LiveUtilsKt.asLiveMessage(entity);
            if (asLiveMessage != null && !LiveUtilsKt.isSentByMyself(asLiveMessage)) {
                if (!LiveUtilsKt.isSentByPresenter(asLiveMessage, live)) {
                    DanmakuManager danmakuManager = this.this$0.getLiveVideoViewPart().getDanmakuManager();
                    String message = asLiveMessage.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message, "liveMessage.message");
                    danmakuManager.addDanmaku(new DanmakuText(message, DanmakuTextStyle.NORMAL, null, 4, null));
                } else if (asLiveMessage.getIsBroadcast() == 0) {
                    DanmakuManager danmakuManager2 = this.this$0.getLiveVideoViewPart().getDanmakuManager();
                    String message2 = asLiveMessage.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message2, "liveMessage.message");
                    danmakuManager2.addDanmaku(new DanmakuText(message2, DanmakuTextStyle.PRESENTER, asLiveMessage.getUserName()));
                }
            }
        }
    }
}
