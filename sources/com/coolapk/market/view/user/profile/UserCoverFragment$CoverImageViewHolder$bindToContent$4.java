package com.coolapk.market.view.user.profile;

import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.databinding.ItemUserCoverImageBinding;
import com.coolapk.market.view.user.profile.UserCoverFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserCoverFragment.kt */
final class UserCoverFragment$CoverImageViewHolder$bindToContent$4 implements Runnable {
    final /* synthetic */ UserCoverFragment.CoverImageViewHolder this$0;

    UserCoverFragment$CoverImageViewHolder$bindToContent$4(UserCoverFragment.CoverImageViewHolder coverImageViewHolder) {
        this.this$0 = coverImageViewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = ((ItemUserCoverImageBinding) this.this$0.getBinding()).foregroundView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.foregroundView");
        int i = view.getLayoutParams().height;
        View view2 = ((ItemUserCoverImageBinding) this.this$0.getBinding()).foregroundView;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.foregroundView");
        if (i != view2.getWidth() / 2) {
            View view3 = ((ItemUserCoverImageBinding) this.this$0.getBinding()).foregroundView;
            Intrinsics.checkNotNullExpressionValue(view3, "binding.foregroundView");
            ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
            View view4 = ((ItemUserCoverImageBinding) this.this$0.getBinding()).foregroundView;
            Intrinsics.checkNotNullExpressionValue(view4, "binding.foregroundView");
            layoutParams.height = view4.getWidth() / 2;
            ((ItemUserCoverImageBinding) this.this$0.getBinding()).foregroundView.requestLayout();
        }
    }
}
