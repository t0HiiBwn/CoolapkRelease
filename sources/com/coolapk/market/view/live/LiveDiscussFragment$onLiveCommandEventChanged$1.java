package com.coolapk.market.view.live;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussFragment.kt */
final class LiveDiscussFragment$onLiveCommandEventChanged$1 implements Runnable {
    final /* synthetic */ LiveDiscussFragment this$0;

    LiveDiscussFragment$onLiveCommandEventChanged$1(LiveDiscussFragment liveDiscussFragment) {
        this.this$0 = liveDiscussFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.this$0.getAdapter$presentation_coolapkAppRelease().notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
