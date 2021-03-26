package com.coolapk.market.view.feedv8;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.SubmitFeedRelativeInfoPickerBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0014J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0007H\u0014R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/feedv8/RelativeInfoPickerViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/SubmitFeedRelativeInfoPickerBinding;", "Lcom/coolapk/market/model/FeedUIConfig;", "()V", "onCloseViewClick", "Lkotlin/Function0;", "", "getOnCloseViewClick", "()Lkotlin/jvm/functions/Function0;", "setOnCloseViewClick", "(Lkotlin/jvm/functions/Function0;)V", "onPickItemClick", "getOnPickItemClick", "setOnPickItemClick", "onBindToContent", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RelativeInfoPickerViewPart.kt */
public final class RelativeInfoPickerViewPart extends BindingViewPart<SubmitFeedRelativeInfoPickerBinding, FeedUIConfig> {
    private Function0<Unit> onCloseViewClick;
    private Function0<Unit> onPickItemClick;

    public final Function0<Unit> getOnCloseViewClick() {
        return this.onCloseViewClick;
    }

    public final void setOnCloseViewClick(Function0<Unit> function0) {
        this.onCloseViewClick = function0;
    }

    public final Function0<Unit> getOnPickItemClick() {
        return this.onPickItemClick;
    }

    public final void setOnPickItemClick(Function0<Unit> function0) {
        this.onPickItemClick = function0;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public SubmitFeedRelativeInfoPickerBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559169, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…picker, viewGroup, false)");
        return (SubmitFeedRelativeInfoPickerBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ImageView imageView = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).addImageView;
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        imageView.setImageTintList(ColorStateList.valueOf(colorAccent));
        imageView.setBackgroundColor(ColorUtils.adjustAlpha(colorAccent, 0.1f));
        ImageView imageView2 = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).closeView;
        long j = AppHolder.getAppTheme().isDarkTheme() ? 4286808963L : 4290624957L;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor((int) j);
        gradientDrawable.setShape(1);
        Unit unit = Unit.INSTANCE;
        Drawable drawable = ResourceUtils.getDrawable(imageView2.getContext(), 2131231211);
        drawable.setTint(AppHolder.getAppTheme().getContentBackgroundColor());
        Unit unit2 = Unit.INSTANCE;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawable});
        layerDrawable.setLayerInset(1, NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 2));
        Unit unit3 = Unit.INSTANCE;
        imageView2.setImageDrawable(layerDrawable);
        ((SubmitFeedRelativeInfoPickerBinding) getBinding()).setClick(this);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(feedUIConfig, "data");
        super.onBindToContent((RelativeInfoPickerViewPart) feedUIConfig);
        String relativeTitle = feedUIConfig.relativeTitle();
        Intrinsics.checkNotNullExpressionValue(relativeTitle, "data.relativeTitle()");
        boolean z = true;
        if (!(relativeTitle.length() > 0)) {
            String relativeLogo = feedUIConfig.relativeLogo();
            Intrinsics.checkNotNullExpressionValue(relativeLogo, "data.relativeLogo()");
            if (relativeLogo.length() <= 0) {
                z = false;
            }
            if (!z) {
                LinearLayout linearLayout = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).addRelativeView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addRelativeView");
                linearLayout.setVisibility(0);
                LinearLayout linearLayout2 = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).relativeView;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.relativeView");
                linearLayout2.setVisibility(8);
                return;
            }
        }
        LinearLayout linearLayout3 = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).addRelativeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.addRelativeView");
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).relativeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.relativeView");
        linearLayout4.setVisibility(0);
        TextView textView = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(feedUIConfig.relativeTitle());
        AppHolder.getContextImageLoader().displayImage(getContext(), feedUIConfig.relativeLogo(), ((SubmitFeedRelativeInfoPickerBinding) getBinding()).imageView, 2131231374);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id != 2131362003) {
            if (id == 2131362262) {
                View root = ((SubmitFeedRelativeInfoPickerBinding) getBinding()).getRoot();
                Objects.requireNonNull(root, "null cannot be cast to non-null type android.view.ViewGroup");
                TransitionManager.beginDelayedTransition((ViewGroup) root);
                Function0<Unit> function0 = this.onCloseViewClick;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            } else if (id != 2131363244) {
                return;
            }
        }
        Function0<Unit> function02 = this.onPickItemClick;
        if (function02 != null) {
            function02.invoke();
        }
        StatisticHelper.Companion.getInstance().recordViewClickEvent("动态发布 选择发布到");
    }
}
