package com.coolapk.market.view.live;

import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.PushMessage;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "miPushMessage", "Lcom/coolapk/market/manager/PushMessage;", "kotlin.jvm.PlatformType", "interceptNotification"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$messageIntercept$1 implements AppNotification.MessageIntercept {
    final /* synthetic */ LiveActivity this$0;

    LiveActivity$messageIntercept$1(LiveActivity liveActivity) {
        this.this$0 = liveActivity;
    }

    @Override // com.coolapk.market.manager.AppNotification.MessageIntercept
    public final boolean interceptNotification(PushMessage pushMessage) {
        String type = pushMessage.getType();
        JSONObject jSONObject = new JSONObject(pushMessage.getContent());
        Lazy lazy = LazyKt.lazy(new LiveActivity$messageIntercept$1$messageId$2(jSONObject));
        Lazy lazy2 = LazyKt.lazy(new LiveActivity$messageIntercept$1$uid$2(jSONObject));
        Lazy lazy3 = LazyKt.lazy(new LiveActivity$messageIntercept$1$isLiveStream$2(jSONObject));
        switch (type.hashCode()) {
            case -742476495:
                if (!type.equals("liveAddToBroadcast")) {
                    return true;
                }
                EventBus.getDefault().post(new LiveMessageEvent(1, null, "1", null, null, 26, null));
                return true;
            case 270270395:
                if (!type.equals("newLiveMessage") || !((Boolean) lazy3.getValue()).booleanValue()) {
                    return true;
                }
                EventBus.getDefault().post(new LiveMessageEvent(1, null, "1", null, null, 26, null));
                return true;
            case 365614471:
                if (!type.equals("liveRemoveFromBroadcast")) {
                    return true;
                }
                EventBus.getDefault().post(new LiveMessageEvent(2, null, null, (String) lazy.getValue(), null, 22, null));
                return true;
            case 427578461:
                if (!type.equals("liveDetail") || LiveActivity.access$getPresenter$p(this.this$0).isLoadingLive()) {
                    return true;
                }
                LiveActivity.access$getPresenter$p(this.this$0).loadLive();
                return true;
            case 1886833232:
                if (!type.equals("liveDeleteMessage")) {
                    return true;
                }
                EventBus.getDefault().post(new LiveMessageEvent(2, null, null, (String) lazy.getValue(), null, 22, null));
                return true;
            case 1949113916:
                if (!type.equals("liveDeleteAllMessageByUid")) {
                    return true;
                }
                EventBus.getDefault().post(new LiveMessageEvent(2, null, null, null, (String) lazy2.getValue(), 14, null));
                return true;
            default:
                return true;
        }
    }
}
