package com.coolapk.market.view.feedv8;

import android.view.ViewGroup;
import com.coolapk.market.widget.emotion.EmotionPanel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/emotion/EmotionPanel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$emotionPanel$2 extends Lambda implements Function0<EmotionPanel> {
    final /* synthetic */ SubmitFeedV8Activity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitFeedV8Activity$emotionPanel$2(SubmitFeedV8Activity submitFeedV8Activity) {
        super(0);
        this.this$0 = submitFeedV8Activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EmotionPanel invoke() {
        EmotionPanel emotionPanel = new EmotionPanel(this.this$0.getActivity());
        emotionPanel.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        emotionPanel.setupWithListener(SubmitFeedV8Activity.access$getContentHolder$p(this.this$0));
        return emotionPanel;
    }
}
