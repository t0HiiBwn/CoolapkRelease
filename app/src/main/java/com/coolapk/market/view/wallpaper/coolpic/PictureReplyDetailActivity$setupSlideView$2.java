package com.coolapk.market.view.wallpaper.coolpic;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.AnimationUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.widget.view.SlideUpView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailActivity$setupSlideView$2", "Lcom/coolapk/market/widget/view/SlideUpView$Callback;", "onDismiss", "", "onShow", "onTranslateYChange", "y", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureReplyDetailActivity.kt */
public final class PictureReplyDetailActivity$setupSlideView$2 implements SlideUpView.Callback {
    final /* synthetic */ PictureReplyDetailActivity this$0;

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onShow() {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    PictureReplyDetailActivity$setupSlideView$2(PictureReplyDetailActivity pictureReplyDetailActivity) {
        this.this$0 = pictureReplyDetailActivity;
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onTranslateYChange(int i) {
        if (i != 0) {
            ThemeUtils.setTranslucentStatusBar(this.this$0.getActivity());
            SlideUpView slideUpView = PictureReplyDetailActivity.access$getBinding$p(this.this$0).bottomSheet;
            Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.bottomSheet");
            PictureReplyDetailActivity.access$getBinding$p(this.this$0).mainContent.setBackgroundColor(AnimationUtils.calculateColor(((float) i) / ((float) slideUpView.getHeight()), -1728053248, 0));
            this.this$0.setSlidrEnable(false);
            Boolean bool = this.this$0.isSet;
            Intrinsics.checkNotNull(bool);
            if (!bool.booleanValue()) {
                SlideUpView slideUpView2 = PictureReplyDetailActivity.access$getBinding$p(this.this$0).bottomSheet;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
                float dp2px = (float) ConvertUtils.dp2px(12.0f);
                gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
                Unit unit = Unit.INSTANCE;
                slideUpView2.setBackground(gradientDrawable);
                this.this$0.isSet = true;
                return;
            }
            return;
        }
        ThemeUtils.setStatusBarColor(this.this$0.getActivity(), ThemeUtils.getStatusBarColor());
        this.this$0.setSlidrEnable(true);
        Boolean bool2 = this.this$0.isSet;
        Intrinsics.checkNotNull(bool2);
        if (bool2.booleanValue()) {
            PictureReplyDetailActivity.access$getBinding$p(this.this$0).bottomSheet.setBackground(new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor()));
            this.this$0.isSet = false;
        }
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onDismiss() {
        this.this$0.getActivity().setResult(-1, new Intent().putExtra("feed", PictureReplyDetailActivity.access$getFeedPresenter$p(this.this$0).getFeed()));
        this.this$0.finish();
        this.this$0.overridePendingTransition(0, 0);
    }
}
