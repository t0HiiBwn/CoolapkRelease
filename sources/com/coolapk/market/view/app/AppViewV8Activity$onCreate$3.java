package com.coolapk.market.view.app;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.imageloader.GlideApp;
import jp.wasabeef.glide.transformations.CropTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/app/AppViewV8Activity$onCreate$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
public final class AppViewV8Activity$onCreate$3 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ AppViewV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppViewV8Activity$onCreate$3(AppViewV8Activity appViewV8Activity) {
        this.this$0 = appViewV8Activity;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView imageView = AppViewV8Activity.access$getBinding$p(this.this$0).loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingBgView");
        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ?? load = GlideApp.with((FragmentActivity) this.this$0.getActivity()).load(Integer.valueOf(AppHolder.getAppTheme().isDarkTheme() ? 2131230839 : 2131230840));
        ImageView imageView2 = AppViewV8Activity.access$getBinding$p(this.this$0).loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.loadingBgView");
        int width = imageView2.getWidth();
        ImageView imageView3 = AppViewV8Activity.access$getBinding$p(this.this$0).loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.loadingBgView");
        load.transform(new CropTransformation(width, imageView3.getHeight(), CropTransformation.CropType.TOP)).into(AppViewV8Activity.access$getBinding$p(this.this$0).loadingBgView);
    }
}
