package com.coolapk.market.widget.expandable;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onPreDraw"}, k = 3, mv = {1, 4, 2})
/* compiled from: ExpandTextView.kt */
final class ExpandTextView$setText$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ ExpandTextView this$0;

    ExpandTextView$setText$1(ExpandTextView expandTextView) {
        this.this$0 = expandTextView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.this$0.isInitTextView) {
            boolean z = false;
            this.this$0.isInitTextView = false;
            ExpandTextView expandTextView = this.this$0;
            expandTextView.textLines = ExpandTextView.access$getContentTextView$p(expandTextView).getLineCount();
            if (this.this$0.textLines > this.this$0.maxCollapsedLines) {
                z = true;
            }
            this.this$0.setState(!z);
        }
        return true;
    }
}
