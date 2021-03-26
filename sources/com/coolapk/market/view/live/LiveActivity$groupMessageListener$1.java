package com.coolapk.market.view.live;

import android.widget.FrameLayout;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import com.coolapk.market.manager.AppIMManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.danmaku.DanmakuManager;
import com.coolapk.market.view.danmaku.DanmakuText;
import com.coolapk.market.view.danmaku.DanmakuTextStyle;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/live/LiveActivity$groupMessageListener$1", "Lcom/coolapk/market/manager/AppIMManager$GroupMessageListener;", "onRecvAddToBroadcast", "", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "onRecvDeleteAllMessage", "uid", "", "onRecvDeleteMessage", "messageId", "onRecvLiveDetail", "live", "Lcom/coolapk/market/model/Live;", "onRecvNewMessage", "onRecvRemoveFromBroadcast", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
public final class LiveActivity$groupMessageListener$1 implements AppIMManager.GroupMessageListener {
    final /* synthetic */ LiveActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    LiveActivity$groupMessageListener$1(LiveActivity liveActivity) {
        this.this$0 = liveActivity;
    }

    @Override // com.coolapk.market.manager.AppIMManager.GroupMessageListener
    public void onRecvNewMessage(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
        Live live = LiveActivity.access$getViewModel$p(this.this$0).getLive();
        Intrinsics.checkNotNull(live);
        String entityType = liveMessage.getEntityType();
        if (entityType != null) {
            int hashCode = entityType.hashCode();
            if (hashCode != -232766085) {
                if (hashCode == -174423732 && entityType.equals("liveSystemMessage")) {
                    EventBus.getDefault().post(new LiveMessageEvent(3, CollectionsKt.arrayListOf(liveMessage), null, null, null, 28, null));
                }
            } else if (entityType.equals("liveMessage") && !LiveUtilsKt.isSentByMyself(liveMessage)) {
                FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) LiveActivity.access$getLiveVideoViewPart$p(this.this$0).getBinding()).danmakuFrame;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "liveVideoViewPart.binding.danmakuFrame");
                if (frameLayout.getVisibility() == 0) {
                    if (!LiveUtilsKt.isSentByPresenter(liveMessage, live)) {
                        DanmakuManager danmakuManager = this.this$0.getLiveVideoViewPart().getDanmakuManager();
                        String message = liveMessage.getMessage();
                        Intrinsics.checkNotNullExpressionValue(message, "liveMessage.message");
                        danmakuManager.addDanmaku(new DanmakuText(message, DanmakuTextStyle.NORMAL, null, 4, null));
                    } else if (liveMessage.getIsBroadcast() == 0) {
                        DanmakuManager danmakuManager2 = this.this$0.getLiveVideoViewPart().getDanmakuManager();
                        String message2 = liveMessage.getMessage();
                        Intrinsics.checkNotNullExpressionValue(message2, "liveMessage.message");
                        danmakuManager2.addDanmaku(new DanmakuText(message2, DanmakuTextStyle.PRESENTER, liveMessage.getUserName()));
                    }
                }
                LiveUpdateTabHelper.Companion.onLiveUpdateTab(liveMessage);
                EventBus.getDefault().post(new LiveMessageEvent(3, CollectionsKt.arrayListOf(liveMessage), null, null, null, 28, null));
            }
        }
    }

    @Override // com.coolapk.market.manager.AppIMManager.GroupMessageListener
    public void onRecvLiveDetail(Live live) {
        if (live != null) {
            LiveActivity.access$getPresenter$p(this.this$0).setNewResult(new Result<>(0, "", null, live));
        } else if (!LiveActivity.access$getPresenter$p(this.this$0).isLoadingLive()) {
            LiveActivity.access$getPresenter$p(this.this$0).loadLive();
        }
    }

    @Override // com.coolapk.market.manager.AppIMManager.GroupMessageListener
    public void onRecvDeleteMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        EventBus.getDefault().post(new LiveMessageEvent(2, null, null, str, null, 22, null));
    }

    @Override // com.coolapk.market.manager.AppIMManager.GroupMessageListener
    public void onRecvDeleteAllMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        EventBus.getDefault().post(new LiveMessageEvent(2, null, null, null, str, 14, null));
    }

    @Override // com.coolapk.market.manager.AppIMManager.GroupMessageListener
    public void onRecvAddToBroadcast(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
        EventBus.getDefault().post(new LiveMessageEvent(4, CollectionsKt.arrayListOf(liveMessage), "1", null, null, 24, null));
    }

    @Override // com.coolapk.market.manager.AppIMManager.GroupMessageListener
    public void onRecvRemoveFromBroadcast(String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        EventBus.getDefault().post(new LiveMessageEvent(2, null, null, str, null, 22, null));
    }
}
