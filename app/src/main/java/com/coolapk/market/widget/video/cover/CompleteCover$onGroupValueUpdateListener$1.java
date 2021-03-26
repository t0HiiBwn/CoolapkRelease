package com.coolapk.market.widget.video.cover;

import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/widget/video/cover/CompleteCover$onGroupValueUpdateListener$1", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup$OnGroupValueUpdateListener;", "filterKeys", "", "", "()[Ljava/lang/String;", "onValueUpdate", "", "key", "value", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompleteCover.kt */
public final class CompleteCover$onGroupValueUpdateListener$1 implements IReceiverGroup.OnGroupValueUpdateListener {
    CompleteCover$onGroupValueUpdateListener$1() {
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public String[] filterKeys() {
        return new String[]{"is_has_next"};
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public void onValueUpdate(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        Intrinsics.areEqual(str, "is_has_next");
    }
}
