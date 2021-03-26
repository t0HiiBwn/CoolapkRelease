package com.coolapk.market.view.feedv8;

import android.content.res.ColorStateList;
import android.widget.ImageView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "fakeKeyboardShow", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s2$1<T> implements Action1<Boolean> {
    final /* synthetic */ SubmitFeedV8Activity this$0;

    SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s2$1(SubmitFeedV8Activity submitFeedV8Activity) {
        this.this$0 = submitFeedV8Activity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    public final void call(Boolean bool) {
        if (this.this$0.lastActiveMenu == SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuEmotion) {
            Intrinsics.checkNotNullExpressionValue(bool, "fakeKeyboardShow");
            if (bool.booleanValue()) {
                SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuEmotion.setImageResource(2131231386);
                int colorInt = ResourceUtils.getColorInt(this.this$0.getActivity(), 2131099891);
                if (this.this$0.lastActiveMenu == SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuAddMore) {
                    Intrinsics.checkNotNullExpressionValue(bool, "fakeKeyboardShow");
                    if (bool.booleanValue()) {
                        int colorAccent = AppHolder.getAppTheme().getColorAccent();
                        ImageView imageView = this.this$0.lastActiveMenu;
                        Intrinsics.checkNotNull(imageView);
                        imageView.setImageTintList(ColorStateList.valueOf(colorAccent));
                        if (this.this$0.lastActiveMenu == SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuFont) {
                            Intrinsics.checkNotNullExpressionValue(bool, "fakeKeyboardShow");
                            if (bool.booleanValue()) {
                                int colorAccent2 = AppHolder.getAppTheme().getColorAccent();
                                ImageView imageView2 = this.this$0.lastActiveMenu;
                                Intrinsics.checkNotNull(imageView2);
                                imageView2.setImageTintList(ColorStateList.valueOf(colorAccent2));
                                return;
                            }
                        }
                        ImageView imageView3 = SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuFont;
                        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.menuFont");
                        imageView3.setImageTintList(ColorStateList.valueOf(colorInt));
                    }
                }
                ImageView imageView4 = SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuAddMore;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.menuAddMore");
                imageView4.setImageTintList(ColorStateList.valueOf(colorInt));
                if (this.this$0.lastActiveMenu == SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuFont) {
                }
                ImageView imageView3 = SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuFont;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.menuFont");
                imageView3.setImageTintList(ColorStateList.valueOf(colorInt));
            }
        }
        SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuEmotion.setImageResource(2131231277);
        int colorInt = ResourceUtils.getColorInt(this.this$0.getActivity(), 2131099891);
        if (this.this$0.lastActiveMenu == SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuAddMore) {
        }
        ImageView imageView4 = SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuAddMore;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.menuAddMore");
        imageView4.setImageTintList(ColorStateList.valueOf(colorInt));
        if (this.this$0.lastActiveMenu == SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuFont) {
        }
        ImageView imageView3 = SubmitFeedV8Activity.access$getBinding$p(this.this$0).menuFont;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.menuFont");
        imageView3.setImageTintList(ColorStateList.valueOf(colorInt));
    }
}
