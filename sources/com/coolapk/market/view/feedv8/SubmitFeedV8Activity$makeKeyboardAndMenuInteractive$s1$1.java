package com.coolapk.market.view.feedv8;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "keyboardShow", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s1$1<T> implements Action1<Boolean> {
    final /* synthetic */ SubmitFeedV8Activity this$0;

    SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s1$1(SubmitFeedV8Activity submitFeedV8Activity) {
        this.this$0 = submitFeedV8Activity;
    }

    public final void call(Boolean bool) {
        if (this.this$0.lastActiveMenu == SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuEmotion) {
            Intrinsics.checkNotNullExpressionValue(bool, "keyboardShow");
            if (bool.booleanValue()) {
                ImageView imageView = this.this$0.lastActiveMenu;
                if (imageView != null) {
                    imageView.setImageResource(2131231288);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.this$0.lastActiveMenu;
            if (imageView2 != null) {
                imageView2.setImageResource(2131231397);
            }
        }
    }
}
