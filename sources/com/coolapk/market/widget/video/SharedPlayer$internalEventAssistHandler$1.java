package com.coolapk.market.widget.video;

import android.os.Bundle;
import com.kk.taurus.playerbase.assist.AssistPlay;
import com.kk.taurus.playerbase.assist.OnAssistPlayEventHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"com/coolapk/market/widget/video/SharedPlayer$internalEventAssistHandler$1", "Lcom/kk/taurus/playerbase/assist/OnAssistPlayEventHandler;", "onAssistHandle", "", "assist", "Lcom/kk/taurus/playerbase/assist/AssistPlay;", "eventCode", "", "bundle", "Landroid/os/Bundle;", "requestReset", "requestResume", "assistPlay", "requestSeek", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SharedPlayer.kt */
public final class SharedPlayer$internalEventAssistHandler$1 extends OnAssistPlayEventHandler {
    final /* synthetic */ SharedPlayer this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SharedPlayer$internalEventAssistHandler$1(SharedPlayer sharedPlayer) {
        this.this$0 = sharedPlayer;
    }

    public void onAssistHandle(AssistPlay assistPlay, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(assistPlay, "assist");
        switch (i) {
            case -660011:
            case -66014:
            case -66013:
            case -66005:
            case -66003:
                if (this.this$0.getPlayerBridge() != null) {
                    super.onAssistHandle((SharedPlayer$internalEventAssistHandler$1) assistPlay, i, bundle);
                    return;
                }
                return;
            case -66009:
            case -66007:
            case -66001:
                super.onAssistHandle((SharedPlayer$internalEventAssistHandler$1) assistPlay, i, bundle);
                return;
            case -111:
                this.this$0.relationAssist.reset();
                return;
            default:
                return;
        }
    }

    @Override // com.kk.taurus.playerbase.assist.OnAssistPlayEventHandler
    public void requestResume(AssistPlay assistPlay, Bundle bundle) {
        Intrinsics.checkNotNullParameter(assistPlay, "assistPlay");
        if (assistPlay.isInPlaybackState()) {
            assistPlay.resume();
        } else {
            assistPlay.rePlay(VideoManager.INSTANCE.getProgressMap().get(this.this$0.getVideoModel().getKey()));
        }
    }

    @Override // com.kk.taurus.playerbase.assist.OnAssistPlayEventHandler
    public void requestSeek(AssistPlay assistPlay, Bundle bundle) {
        Intrinsics.checkNotNullParameter(assistPlay, "assistPlay");
        if (assistPlay.getState() == 6) {
            int i = 0;
            if (bundle != null) {
                i = bundle.getInt("int_data");
            }
            assistPlay.rePlay(i);
            return;
        }
        super.requestSeek(assistPlay, bundle);
    }

    @Override // com.kk.taurus.playerbase.assist.OnAssistPlayEventHandler
    public void requestReset(AssistPlay assistPlay, Bundle bundle) {
        Intrinsics.checkNotNullParameter(assistPlay, "assist");
        this.this$0.detachPlayerBridge();
    }
}
