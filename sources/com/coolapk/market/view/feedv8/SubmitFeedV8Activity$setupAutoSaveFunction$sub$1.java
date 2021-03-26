package com.coolapk.market.view.feedv8;

import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "save", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$setupAutoSaveFunction$sub$1<T> implements Action1<Boolean> {
    final /* synthetic */ SubmitFeedV8Activity this$0;

    SubmitFeedV8Activity$setupAutoSaveFunction$sub$1(SubmitFeedV8Activity submitFeedV8Activity) {
        this.this$0 = submitFeedV8Activity;
    }

    public final void call(Boolean bool) {
        if (bool.booleanValue() && !this.this$0.isFinishing()) {
            this.this$0.saveDraftRightNow();
        }
    }
}
