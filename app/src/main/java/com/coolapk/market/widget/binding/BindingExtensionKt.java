package com.coolapk.market.widget.binding;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedTopBinding;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.LoadingViewBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.model.SimpleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u001a\n\u0010\f\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\r\u001a\u00020\u0006*\u00020\u0007\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\"\"\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0016"}, d2 = {"binding", "T", "Landroidx/databinding/ViewDataBinding;", "getBinding", "(Landroidx/databinding/ViewDataBinding;)Landroidx/databinding/ViewDataBinding;", "setLoadingError", "", "Lcom/coolapk/market/databinding/LoadingViewBinding;", "errorText", "", "action", "Lkotlin/Function0;", "setLoadingFinished", "setLoadingStart", "updateInfo", "Lcom/coolapk/market/databinding/FeedTopBinding;", "topInfo", "Lcom/coolapk/market/model/SimpleInfo;", "isTop", "", "Lcom/coolapk/market/databinding/FeedWarningBinding;", "innerInfo", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: BindingExtension.kt */
public final class BindingExtensionKt {
    /* access modifiers changed from: private */
    public static final <T extends ViewDataBinding> T getBinding(T t) {
        return t;
    }

    public static final void setLoadingStart(LoadingViewBinding loadingViewBinding) {
        Intrinsics.checkNotNullParameter(loadingViewBinding, "$this$setLoadingStart");
        LoadingViewBinding loadingViewBinding2 = loadingViewBinding;
        FrameLayout frameLayout = ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        ProgressBar progressBar = ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(0);
        TextView textView = ((LoadingViewBinding) getBinding(loadingViewBinding2)).hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingContainer.setOnClickListener(null);
    }

    public static final void setLoadingFinished(LoadingViewBinding loadingViewBinding) {
        Intrinsics.checkNotNullParameter(loadingViewBinding, "$this$setLoadingFinished");
        LoadingViewBinding loadingViewBinding2 = loadingViewBinding;
        ProgressBar progressBar = ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        TextView textView = ((LoadingViewBinding) getBinding(loadingViewBinding2)).hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingContainer.setOnClickListener(null);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingContainer, View.ALPHA, 1.0f, 0.0f);
        ofFloat.addListener(new BindingExtensionKt$setLoadingFinished$$inlined$also$lambda$1(loadingViewBinding));
        ofFloat.start();
    }

    public static final void setLoadingError(LoadingViewBinding loadingViewBinding, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(loadingViewBinding, "$this$setLoadingError");
        Intrinsics.checkNotNullParameter(str, "errorText");
        Intrinsics.checkNotNullParameter(function0, "action");
        LoadingViewBinding loadingViewBinding2 = loadingViewBinding;
        FrameLayout frameLayout = ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        ProgressBar progressBar = ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        TextView textView = ((LoadingViewBinding) getBinding(loadingViewBinding2)).hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(0);
        TextView textView2 = ((LoadingViewBinding) getBinding(loadingViewBinding2)).hintView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.hintView");
        textView2.setText(str);
        ((LoadingViewBinding) getBinding(loadingViewBinding2)).loadingContainer.setOnClickListener(new BindingExtensionKt$setLoadingError$1(function0));
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final void updateInfo(FeedWarningBinding feedWarningBinding, SimpleInfo simpleInfo) {
        Intrinsics.checkNotNullParameter(feedWarningBinding, "$this$updateInfo");
        View root = feedWarningBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "alertBinding.root");
        Context context = root.getContext();
        feedWarningBinding.executePendingBindings();
        int i = 8;
        if (simpleInfo == null) {
            LinearLayout linearLayout = feedWarningBinding.alertView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "alertBinding.alertView");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = feedWarningBinding.alertView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "alertBinding.alertView");
        boolean z = false;
        linearLayout2.setVisibility(0);
        ImageView imageView = feedWarningBinding.closeAlertView;
        Intrinsics.checkNotNullExpressionValue(imageView, "alertBinding.closeAlertView");
        imageView.setVisibility(8);
        ImageView imageView2 = feedWarningBinding.alertImageView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "alertBinding.alertImageView");
        ImageView imageView3 = imageView2;
        String icon = simpleInfo.getIcon();
        if (!(icon == null || icon.length() == 0)) {
            i = 0;
        }
        imageView3.setVisibility(i);
        String icon2 = simpleInfo.getIcon();
        if (!(icon2 == null || icon2.length() == 0)) {
            feedWarningBinding.alertImageView.setImageDrawable(null);
            feedWarningBinding.alertImageView.setColorFilter((int) 4294198070L);
            GlideApp.with(context).load(simpleInfo.getIcon()).into(feedWarningBinding.alertImageView);
        }
        TextView textView = feedWarningBinding.alertTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "alertBinding.alertTextView");
        textView.setText(simpleInfo.getMessage());
        feedWarningBinding.alertTextView.setTextColor((int) 4294198070L);
        feedWarningBinding.alertView.setBackgroundColor(452215606);
        LinearLayout linearLayout3 = feedWarningBinding.alertView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "alertBinding.alertView");
        String url = simpleInfo.getUrl();
        if (url == null || url.length() == 0) {
            z = true;
        }
        linearLayout3.setClickable(!z);
        LinearLayout linearLayout4 = feedWarningBinding.alertView;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "alertBinding.alertView");
        if (linearLayout4.isClickable()) {
            feedWarningBinding.alertView.setOnClickListener(new BindingExtensionKt$updateInfo$1(context, simpleInfo.getUrl()));
        }
    }

    /* JADX WARN: Type inference failed for: r11v20, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final void updateInfo(FeedTopBinding feedTopBinding, SimpleInfo simpleInfo, boolean z) {
        Intrinsics.checkNotNullParameter(feedTopBinding, "$this$updateInfo");
        View root = feedTopBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Context context = root.getContext();
        int i = 8;
        boolean z2 = false;
        if (simpleInfo != null) {
            LinearLayout linearLayout = feedTopBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            linearLayout.setVisibility(0);
            ImageView imageView = feedTopBinding.topImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.topImageView");
            ImageView imageView2 = imageView;
            String icon = simpleInfo.getIcon();
            if (!(icon == null || icon.length() == 0)) {
                i = 0;
            }
            imageView2.setVisibility(i);
            String icon2 = simpleInfo.getIcon();
            if (!(icon2 == null || icon2.length() == 0)) {
                feedTopBinding.topImageView.setImageDrawable(null);
                ImageView imageView3 = feedTopBinding.topImageView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.topImageView");
                imageView3.setImageTintList(null);
                GlideApp.with(context).load(simpleInfo.getIcon()).into(feedTopBinding.topImageView);
            }
            TextView textView = feedTopBinding.topTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.topTextView");
            textView.setText(simpleInfo.getMessage());
            feedTopBinding.topTextView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            LinearLayout linearLayout2 = feedTopBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.topContainer");
            String url = simpleInfo.getUrl();
            if (url == null || url.length() == 0) {
                z2 = true;
            }
            linearLayout2.setClickable(!z2);
            LinearLayout linearLayout3 = feedTopBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.topContainer");
            if (linearLayout3.isClickable()) {
                feedTopBinding.topContainer.setOnClickListener(new BindingExtensionKt$updateInfo$$inlined$let$lambda$1(simpleInfo.getUrl(), feedTopBinding, context));
            }
        } else if (z) {
            LinearLayout linearLayout4 = feedTopBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.topContainer");
            linearLayout4.setVisibility(0);
            ImageView imageView4 = feedTopBinding.topImageView;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.topImageView");
            imageView4.setVisibility(0);
            GlideApp.with(feedTopBinding.topImageView).clear(feedTopBinding.topImageView);
            ImageView imageView5 = feedTopBinding.topImageView;
            Intrinsics.checkNotNullExpressionValue(imageView5, "binding.topImageView");
            int i2 = (int) 4294198070L;
            imageView5.setImageTintList(ColorStateList.valueOf(i2));
            feedTopBinding.topImageView.setImageResource(2131231616);
            TextView textView2 = feedTopBinding.topTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.topTextView");
            textView2.setText("置顶");
            feedTopBinding.topTextView.setTextColor(i2);
            feedTopBinding.topContainer.setOnClickListener(null);
            LinearLayout linearLayout5 = feedTopBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.topContainer");
            linearLayout5.setClickable(false);
        } else {
            LinearLayout linearLayout6 = feedTopBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.topContainer");
            linearLayout6.setVisibility(8);
        }
    }
}
