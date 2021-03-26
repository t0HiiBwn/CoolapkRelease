package com.coolapk.market.view.live;

import android.view.View;
import com.coolapk.market.event.LiveFollowEvent;
import com.coolapk.market.model.Live;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final class LiveVideoViewPart$onViewCreated$1 implements View.OnClickListener {
    final /* synthetic */ LiveVideoViewPart this$0;

    LiveVideoViewPart$onViewCreated$1(LiveVideoViewPart liveVideoViewPart) {
        this.this$0 = liveVideoViewPart;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Live live = this.this$0.getViewModel().getLive();
        if (live != null) {
            boolean z = !this.this$0.getViewModel().isFollowLive();
            LivePresenter presenter = this.this$0.getPresenter();
            String id = live.getId();
            Intrinsics.checkNotNull(id);
            Intrinsics.checkNotNullExpressionValue(id, "live.id!!");
            presenter.followLive(id, z);
            this.this$0.getViewModel().setFollowLive(z);
            this.this$0.getActivity().updateLiveVideoViewPart();
            EventBus eventBus = EventBus.getDefault();
            String id2 = live.getId();
            Intrinsics.checkNotNull(id2);
            Intrinsics.checkNotNullExpressionValue(id2, "live.id!!");
            eventBus.post(new LiveFollowEvent(id2, z));
        }
    }
}
