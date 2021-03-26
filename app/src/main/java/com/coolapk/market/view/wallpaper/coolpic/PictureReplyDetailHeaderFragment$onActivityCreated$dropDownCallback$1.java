package com.coolapk.market.view.wallpaper.coolpic;

import android.view.View;
import com.coolapk.market.util.DropDownCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1", "Lcom/coolapk/market/util/DropDownCallback;", "onDropDownEnd", "", "offset", "", "onDropDownOffset", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureReplyDetailHeaderFragment.kt */
public final class PictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1 implements DropDownCallback {
    final /* synthetic */ PictureReplyDetailHeaderFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    PictureReplyDetailHeaderFragment$onActivityCreated$dropDownCallback$1(PictureReplyDetailHeaderFragment pictureReplyDetailHeaderFragment) {
        this.this$0 = pictureReplyDetailHeaderFragment;
    }

    @Override // com.coolapk.market.util.DropDownCallback
    public void onDropDownEnd(int i) {
        this.this$0.requestRestoreCommentView();
    }

    @Override // com.coolapk.market.util.DropDownCallback
    public void onDropDownOffset(int i) {
        View root = this.this$0.getBinding$presentation_coolapkAppRelease().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setTranslationY((float) i);
    }
}
