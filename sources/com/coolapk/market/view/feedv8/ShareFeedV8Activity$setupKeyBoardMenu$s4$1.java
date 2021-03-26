package com.coolapk.market.view.feedv8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0017\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"com/coolapk/market/view/feedv8/ShareFeedV8Activity$setupKeyBoardMenu$s4$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "checkHeight", "", "keyboardHeight", "onNext", "integer", "(Ljava/lang/Integer;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShareFeedV8Activity.kt */
public final class ShareFeedV8Activity$setupKeyBoardMenu$s4$1 extends EmptySubscriber<Integer> {
    final /* synthetic */ ShareFeedV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ShareFeedV8Activity$setupKeyBoardMenu$s4$1(ShareFeedV8Activity shareFeedV8Activity) {
        this.this$0 = shareFeedV8Activity;
    }

    public void onNext(Integer num) {
        super.onNext((ShareFeedV8Activity$setupKeyBoardMenu$s4$1) num);
        Intrinsics.checkNotNull(num);
        checkHeight(num.intValue());
    }

    private final void checkHeight(int i) {
        int i2;
        EditText editText = this.this$0.getBinding$presentation_coolapkAppRelease().editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        View root = this.this$0.getBinding$presentation_coolapkAppRelease().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        int height = root.getHeight();
        if (height <= 0) {
            View root2 = this.this$0.getBinding$presentation_coolapkAppRelease().getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            height = root2.getMeasuredHeight();
        }
        int statusBarHeight = ((height - UiUtils.getStatusBarHeight(this.this$0.getActivity())) - UiUtils.getActionBarSize(this.this$0.getActivity())) - i;
        LinearLayout linearLayout = this.this$0.getBinding$presentation_coolapkAppRelease().bottomAreaView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomAreaView");
        if (linearLayout.isShown()) {
            LinearLayout linearLayout2 = this.this$0.getBinding$presentation_coolapkAppRelease().bottomAreaView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomAreaView");
            i2 = linearLayout2.getHeight();
        } else {
            i2 = 0;
        }
        int i3 = statusBarHeight - i2;
        if (layoutParams.height != i3) {
            layoutParams.height = i3;
            this.this$0.getBinding$presentation_coolapkAppRelease().editText.requestLayout();
            this.this$0.getBinding$presentation_coolapkAppRelease().spaceView.setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        }
    }
}
