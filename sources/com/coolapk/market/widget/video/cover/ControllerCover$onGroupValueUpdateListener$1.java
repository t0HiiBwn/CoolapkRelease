package com.coolapk.market.widget.video.cover;

import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/widget/video/cover/ControllerCover$onGroupValueUpdateListener$1", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup$OnGroupValueUpdateListener;", "filterKeys", "", "", "()[Ljava/lang/String;", "onValueUpdate", "", "key", "value", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
public final class ControllerCover$onGroupValueUpdateListener$1 implements IReceiverGroup.OnGroupValueUpdateListener {
    final /* synthetic */ ControllerCover this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ControllerCover$onGroupValueUpdateListener$1(ControllerCover controllerCover) {
        this.this$0 = controllerCover;
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public String[] filterKeys() {
        return new String[]{"timer_update_enable", "data_source", "isLandscape", "controller_top_enable", "hide_frame_content"};
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public void onValueUpdate(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        switch (str.hashCode()) {
            case -1802542529:
                if (str.equals("timer_update_enable")) {
                    this.this$0.timerUpdateProgressEnable = ((Boolean) obj).booleanValue();
                    return;
                }
                return;
            case -1685900111:
                if (str.equals("isLandscape")) {
                    this.this$0.setSwitchScreenIcon(((Boolean) obj).booleanValue());
                    ControllerCover.access$getBinding$p(this.this$0).titleView.requestLayout();
                    return;
                }
                return;
            case -1333894576:
                if (str.equals("data_source")) {
                    this.this$0.setTitle((ControllerCover) ((DataSource) obj));
                    return;
                }
                return;
            case 886112304:
                if (str.equals("controller_top_enable")) {
                    this.this$0.controllerTopEnable = ((Boolean) obj).booleanValue();
                    if (!this.this$0.controllerTopEnable) {
                        this.this$0.setTopContainerState(false);
                        return;
                    }
                    return;
                }
                return;
            case 2051873642:
                if (str.equals("hide_frame_content")) {
                    this.this$0.hideFrameContent = ((Boolean) obj).booleanValue();
                    if (this.this$0.hideFrameContent) {
                        this.this$0.setControllerState(false);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
