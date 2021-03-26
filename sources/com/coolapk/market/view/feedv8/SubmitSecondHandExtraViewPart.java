package com.coolapk.market.view.feedv8;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.SubmitSecondHandDealExtraChildBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.LocationInfo;
import com.coolapk.market.model.ProductParams;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.sencondhand.EditSecondHandDialogFragment;
import com.coolapk.market.view.sencondhand.EditSecondHandPriceDialogFragment;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.Toast;
import group.infotech.drawable.dsl.ShapesKt;
import group.infotech.drawable.dsl.ViewStates;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 B2\u00020\u0001:\u0001BB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010!\u001a\n \"*\u0004\u0018\u00010\u00070\u00072\u0006\u0010#\u001a\u00020\u000fH\u0002J\u001e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001eH\u0016J\u001a\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-2\b\u0010#\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0016\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u0011J$\u00103\u001a\u00020\u000b2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000202052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\u0010\u00107\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u00108\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u00109\u001a\u000202H\u0002J\u0006\u0010:\u001a\u00020\u000bJ\b\u0010;\u001a\u00020\u000bH\u0002J\u001a\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010>\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u0011H\u0002J\u0014\u0010@\u001a\u00020\u000b*\u00020\u00072\u0006\u0010A\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/coolapk/market/view/feedv8/SubmitSecondHandExtraViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "()V", "activity", "Lcom/coolapk/market/view/feedv8/SubmitFeedV8Activity;", "bindingArray", "Landroid/util/SparseArray;", "Lcom/coolapk/market/databinding/SubmitSecondHandDealExtraChildBinding;", "locationInfo", "Lcom/coolapk/market/model/LocationInfo;", "bindDataSecondHandType", "", "binding", "buildSecondHandInfo", "parentView", "Landroid/widget/LinearLayout;", "id", "", "divider", "", "createSelectedBackground", "Landroid/graphics/drawable/StateListDrawable;", "unSelectMode", "", "createSelectedTextColor", "Landroid/content/res/ColorStateList;", "initLocation", "info", "initWith", "newSmallDividerView", "Landroid/view/View;", "context", "Landroid/content/Context;", "newSubmitSecondHandDealTypeExtraBinding", "kotlin.jvm.PlatformType", "viewGroup", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "onPickLocation", "onPickSHOutLink", "title", "", "onPickSHPirce", "price", "Lkotlin/Pair;", "onRequestLocation", "onRequestSecondHand", "showSecondHandDialog", "content", "updataSecondParams", "updateLocationInfo", "updateSecondHandDealType", "type", "updateSecondHandInfo", "updateSecondHandSthType", "setTint", "color", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SubmitSecondHandExtraViewPart.kt */
public final class SubmitSecondHandExtraViewPart extends ViewPart {
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_LOCATION = 2131363444;
    public static final int TYPE_SH_DEAL_TYPE = 2131363452;
    public static final int TYPE_SH_OUT_LINK = 2131363446;
    public static final int TYPE_SH_PARAMTER = 2131363448;
    public static final int TYPE_SH_PRICE = 2131363450;
    public static final int TYPE_SH_TYPE = 2131363454;
    private SubmitFeedV8Activity activity;
    private final SparseArray<SubmitSecondHandDealExtraChildBinding> bindingArray = new SparseArray<>();
    private LocationInfo locationInfo;

    public static final /* synthetic */ SubmitFeedV8Activity access$getActivity$p(SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart) {
        SubmitFeedV8Activity submitFeedV8Activity = submitSecondHandExtraViewPart.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        return submitFeedV8Activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feedv8/SubmitSecondHandExtraViewPart$Companion;", "", "()V", "TYPE_LOCATION", "", "TYPE_SH_DEAL_TYPE", "TYPE_SH_OUT_LINK", "TYPE_SH_PARAMTER", "TYPE_SH_PRICE", "TYPE_SH_TYPE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SubmitSecondHandExtraViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final View newSmallDividerView(Context context, int i) {
        View view = new View(context);
        view.setId(i);
        view.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(2131165598));
        layoutParams.leftMargin = DisplayUtils.dp2px(context, 16.0f);
        layoutParams.rightMargin = DisplayUtils.dp2px(context, 16.0f);
        Unit unit = Unit.INSTANCE;
        view.setLayoutParams(layoutParams);
        return view;
    }

    private final SubmitSecondHandDealExtraChildBinding newSubmitSecondHandDealTypeExtraBinding(LinearLayout linearLayout) {
        return (SubmitSecondHandDealExtraChildBinding) DataBindingUtil.inflate(LayoutInflater.from(linearLayout.getContext()), 2131559169, linearLayout, false);
    }

    private final void setTint(SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding, int i) {
        submitSecondHandDealExtraChildBinding.arrowView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        submitSecondHandDealExtraChildBinding.imageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        submitSecondHandDealExtraChildBinding.titleView.setTextColor(i);
        submitSecondHandDealExtraChildBinding.descriptionView.setTextColor(i);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(layoutInflater.getContext());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        return linearLayout;
    }

    public final void initWith(SubmitFeedV8Activity submitFeedV8Activity) {
        Intrinsics.checkNotNullParameter(submitFeedV8Activity, "activity");
        this.activity = submitFeedV8Activity;
        View view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        SubmitFeedV8Activity submitFeedV8Activity2 = submitFeedV8Activity;
        linearLayout.addView(newSmallDividerView(submitFeedV8Activity2, 2131363456));
        boolean isLocationViewVisible = submitFeedV8Activity.getUiConfig().isLocationViewVisible();
        boolean isSecondHandViewVisible = submitFeedV8Activity.getUiConfig().isSecondHandViewVisible();
        if (isLocationViewVisible) {
            SubmitSecondHandDealExtraChildBinding newSubmitSecondHandDealTypeExtraBinding = newSubmitSecondHandDealTypeExtraBinding(linearLayout);
            Intrinsics.checkNotNullExpressionValue(newSubmitSecondHandDealTypeExtraBinding, "binding");
            newSubmitSecondHandDealTypeExtraBinding.setClick(this);
            View root = newSubmitSecondHandDealTypeExtraBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setId(2131363444);
            this.bindingArray.put(2131363444, newSubmitSecondHandDealTypeExtraBinding);
            linearLayout.addView(newSubmitSecondHandDealTypeExtraBinding.getRoot());
            updateLocationInfo();
            View newSmallDividerView = newSmallDividerView(submitFeedV8Activity2, 2131363443);
            ViewGroup.LayoutParams layoutParams = newSmallDividerView.getLayoutParams();
            if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                layoutParams = null;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.height = DisplayUtils.dp2px(submitFeedV8Activity2, 8.0f);
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
            }
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(newSmallDividerView);
        }
        if (isSecondHandViewVisible) {
            buildSecondHandInfo(linearLayout, 2131363450, 1.0f);
            buildSecondHandInfo(linearLayout, 2131363454, 1.0f);
            buildSecondHandInfo(linearLayout, 2131363448, 1.0f);
            buildSecondHandInfo(linearLayout, 2131363446, 56.0f);
        }
    }

    private final void buildSecondHandInfo(LinearLayout linearLayout, int i, float f) {
        int i2;
        SubmitSecondHandDealExtraChildBinding newSubmitSecondHandDealTypeExtraBinding = newSubmitSecondHandDealTypeExtraBinding(linearLayout);
        Intrinsics.checkNotNullExpressionValue(newSubmitSecondHandDealTypeExtraBinding, "binding");
        newSubmitSecondHandDealTypeExtraBinding.setClick(this);
        View root = newSubmitSecondHandDealTypeExtraBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setId(i);
        this.bindingArray.put(i, newSubmitSecondHandDealTypeExtraBinding);
        linearLayout.addView(newSubmitSecondHandDealTypeExtraBinding.getRoot());
        int i3 = 0;
        switch (i) {
            case 2131363446:
                i2 = 2131363445;
                break;
            case 2131363447:
            case 2131363449:
            case 2131363451:
            case 2131363453:
            default:
                i2 = 0;
                break;
            case 2131363448:
                i2 = 2131363447;
                break;
            case 2131363450:
                i2 = 2131363449;
                break;
            case 2131363452:
                i2 = 2131363451;
                break;
            case 2131363454:
                i2 = 2131363453;
                break;
        }
        updateSecondHandInfo(i);
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        View newSmallDividerView = newSmallDividerView(submitFeedV8Activity, i2);
        ViewGroup.LayoutParams layoutParams = newSmallDividerView.getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.height = NumberExtendsKt.getDp(Float.valueOf(f));
            boolean z = true;
            int i4 = (f > 8.0f ? 1 : (f == 8.0f ? 0 : -1));
            boolean z2 = i4 < 0;
            int dp = NumberExtendsKt.getDp((Number) 16);
            if (!z2) {
                dp = 0;
            }
            layoutParams2.leftMargin = dp;
            if (i4 >= 0) {
                z = false;
            }
            int dp2 = NumberExtendsKt.getDp((Number) 16);
            if (z) {
                i3 = dp2;
            }
            layoutParams2.rightMargin = i3;
        }
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(newSmallDividerView);
    }

    /* access modifiers changed from: private */
    public final void updateSecondHandSthType(int i) {
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig build = FeedUIConfig.builder(submitFeedV8Activity.getUiConfig()).secondHandType(i).build();
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        Intrinsics.checkNotNullExpressionValue(build, "uiConfig");
        submitFeedV8Activity2.updateUIConfig(build);
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder = FeedMultiPart.builder(submitFeedV8Activity3.getMultiPart());
        builder.secondHandType(i);
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
        submitFeedV8Activity4.updateMultiPart(build2);
    }

    /* access modifiers changed from: private */
    public final void updateSecondHandDealType(int i, SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding) {
        CheckedTextView checkedTextView;
        boolean z = true;
        String str = i != 0 ? i != 1 ? i != 2 ? "选择商品" : "选择要换掉的商品" : "选择要收购的商品" : "选择要出售的商品";
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
        boolean z2 = (uiConfig.secondHandDealType() == 1 && i == 2) || (uiConfig.secondHandDealType() == 2 && i == 1);
        boolean z3 = (uiConfig.secondHandDealType() == 0 && i == 2) || (uiConfig.secondHandDealType() == 2 && i == 0);
        boolean z4 = (uiConfig.secondHandDealType() == 0 && i == 1) || (uiConfig.secondHandDealType() == 1 && i == 0);
        FeedUIConfig.Builder builder = FeedUIConfig.builder(uiConfig);
        builder.secondHandDealType(i);
        if (i == 2) {
            builder.secondHandType(2);
        }
        if (!uiConfig.isProductPicked()) {
            builder.relativeTitle(str);
        }
        if (z2 || z3) {
            builder.secondHandPrice("");
        }
        if (z4 || z2) {
            builder.productConfigCacheList(new ArrayList());
            builder.productConfigShowText("");
        }
        FeedUIConfig build = builder.build();
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newUiConfig");
        submitFeedV8Activity2.updateUIConfig(build);
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder2 = FeedMultiPart.builder(submitFeedV8Activity3.getMultiPart());
        if (z4 || z2) {
            builder2.productConfig("");
        }
        builder2.secondHandDealType(i);
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build2 = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
        submitFeedV8Activity4.updateMultiPart(build2);
        if (!(submitSecondHandDealExtraChildBinding == null || (checkedTextView = submitSecondHandDealExtraChildBinding.switchLeft) == null)) {
            if (i != 0) {
                z = false;
            }
            checkedTextView.setSelected(z);
        }
        updateSecondHandInfo(2131363446);
        updateSecondHandInfo(2131363450);
        updateSecondHandInfo(2131363448);
        updateSecondHandInfo(2131363454);
    }

    /* access modifiers changed from: private */
    public final void bindDataSecondHandType(SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding) {
        CheckedTextView checkedTextView;
        CheckedTextView checkedTextView2;
        CheckedTextView checkedTextView3;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
        int secondHandType = uiConfig.secondHandType();
        boolean z = false;
        boolean z2 = uiConfig.secondHandDealType() == 2;
        if (secondHandType != 0) {
            int colorAccent = AppHolder.getAppTheme().getColorAccent();
            if (!(submitSecondHandDealExtraChildBinding == null || (imageView2 = submitSecondHandDealExtraChildBinding.arrowView) == null)) {
                imageView2.setColorFilter(colorAccent, PorterDuff.Mode.SRC_IN);
            }
            if (!(submitSecondHandDealExtraChildBinding == null || (imageView = submitSecondHandDealExtraChildBinding.imageView) == null)) {
                imageView.setColorFilter(colorAccent, PorterDuff.Mode.SRC_IN);
            }
            if (!(submitSecondHandDealExtraChildBinding == null || (textView = submitSecondHandDealExtraChildBinding.titleView) == null)) {
                textView.setTextColor(colorAccent);
            }
        }
        if (!(!z2 || submitSecondHandDealExtraChildBinding == null || (checkedTextView3 = submitSecondHandDealExtraChildBinding.switchRight) == null)) {
            checkedTextView3.setVisibility(8);
        }
        if (!(submitSecondHandDealExtraChildBinding == null || (checkedTextView2 = submitSecondHandDealExtraChildBinding.switchLeft) == null)) {
            checkedTextView2.setSelected(secondHandType == 2);
        }
        if (!(submitSecondHandDealExtraChildBinding == null || (checkedTextView = submitSecondHandDealExtraChildBinding.switchRight) == null)) {
            if (secondHandType == 1) {
                z = true;
            }
            checkedTextView.setSelected(z);
        }
        updateSecondHandSthType(secondHandType);
        if (uiConfig.secondHandDealType() == 2) {
            SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
            if (submitFeedV8Activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig build = FeedUIConfig.builder(submitFeedV8Activity2.getUiConfig()).secondHandType(2).build();
            SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
            if (submitFeedV8Activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            Intrinsics.checkNotNullExpressionValue(build, "uiConfig");
            submitFeedV8Activity3.updateUIConfig(build);
            SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
            if (submitFeedV8Activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedMultiPart.Builder builder = FeedMultiPart.builder(submitFeedV8Activity4.getMultiPart());
            builder.secondHandType(2);
            SubmitFeedV8Activity submitFeedV8Activity5 = this.activity;
            if (submitFeedV8Activity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedMultiPart build2 = builder.build();
            Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
            submitFeedV8Activity5.updateMultiPart(build2);
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        switch (view.getId()) {
            case 2131363444:
                onRequestLocation();
                return;
            case 2131363445:
            case 2131363447:
            case 2131363449:
            case 2131363451:
            case 2131363453:
            default:
                return;
            case 2131363446:
            case 2131363448:
            case 2131363450:
            case 2131363452:
            case 2131363454:
                onRequestSecondHand(view.getId());
                return;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        if (i == 888) {
            LocationInfo locationInfo2 = (LocationInfo) intent.getParcelableExtra("KEY_LOCATION");
            if (locationInfo2 != null) {
                onPickLocation(locationInfo2);
            }
        } else if (i == 2323 || i == 5555) {
            String stringExtra = intent.getStringExtra("json");
            ArrayList<ProductParams> parcelableArrayListExtra = intent.getParcelableArrayListExtra("paramsList");
            if (parcelableArrayListExtra == null || !CollectionUtils.isNotEmpty(parcelableArrayListExtra)) {
                SubmitFeedV8Activity submitFeedV8Activity = this.activity;
                if (submitFeedV8Activity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedUIConfig build = FeedUIConfig.builder(submitFeedV8Activity.getUiConfig()).productConfigShowText("").productConfigCacheList(new ArrayList()).build();
                SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
                if (submitFeedV8Activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                Intrinsics.checkNotNullExpressionValue(build, "newUiConfig");
                submitFeedV8Activity2.updateUIConfig(build);
                SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
                if (submitFeedV8Activity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedMultiPart.Builder builder = FeedMultiPart.builder(submitFeedV8Activity3.getMultiPart());
                builder.productConfig(stringExtra);
                SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
                if (submitFeedV8Activity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedMultiPart build2 = builder.build();
                Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
                submitFeedV8Activity4.updateMultiPart(build2);
            } else {
                StringBuilder sb = new StringBuilder();
                ArrayList<ProductParams> arrayList = new ArrayList();
                for (ProductParams productParams : parcelableArrayListExtra) {
                    Intrinsics.checkNotNullExpressionValue(productParams, "it");
                    if (productParams.isSingleSelect()) {
                        arrayList.add(productParams);
                    }
                }
                int i3 = 0;
                for (ProductParams productParams2 : arrayList) {
                    sb.append(productParams2.getTitle());
                    if (i3 < arrayList.size() - 1) {
                        sb.append("·");
                    }
                    i3++;
                }
                SubmitFeedV8Activity submitFeedV8Activity5 = this.activity;
                if (submitFeedV8Activity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedUIConfig build3 = FeedUIConfig.builder(submitFeedV8Activity5.getUiConfig()).productConfigShowText(sb.toString()).productConfigCacheList(parcelableArrayListExtra).build();
                SubmitFeedV8Activity submitFeedV8Activity6 = this.activity;
                if (submitFeedV8Activity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                Intrinsics.checkNotNullExpressionValue(build3, "newUiConfig");
                submitFeedV8Activity6.updateUIConfig(build3);
                SubmitFeedV8Activity submitFeedV8Activity7 = this.activity;
                if (submitFeedV8Activity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedMultiPart.Builder builder2 = FeedMultiPart.builder(submitFeedV8Activity7.getMultiPart());
                builder2.productConfig(stringExtra);
                SubmitFeedV8Activity submitFeedV8Activity8 = this.activity;
                if (submitFeedV8Activity8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedMultiPart build4 = builder2.build();
                Intrinsics.checkNotNullExpressionValue(build4, "builder.build()");
                submitFeedV8Activity8.updateMultiPart(build4);
            }
            updateSecondHandInfo(2131363448);
        }
    }

    public final void updataSecondParams() {
        updateSecondHandInfo(2131363448);
    }

    private final void onRequestLocation() {
        LocationInfo locationInfo2 = this.locationInfo;
        if (locationInfo2 == null) {
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedMultiPart multiPart = submitFeedV8Activity.getMultiPart();
            if (!TextUtils.isEmpty(multiPart.location())) {
                locationInfo2 = LocationInfo.newBuilder().setAddress(multiPart.location()).setSnippet("").setCity(multiPart.locationCity()).setCountry(multiPart.locationCountry()).setLongAddress(multiPart.longLocation()).setLatitude(Double.valueOf(multiPart.latitude())).setLongitude(Double.valueOf(multiPart.longitude())).setBusinessArea("").setIsChecked(true).setIsHideLocation(false).setEntityType("location").build();
            }
        }
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        ActionManager.startNearActivity(submitFeedV8Activity2, locationInfo2, "ershou");
    }

    private final void onPickLocation(LocationInfo locationInfo2) {
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder = FeedMultiPart.builder(submitFeedV8Activity.getMultiPart());
        if (locationInfo2.getIsHideLocation()) {
            builder.location("").longitude(0.0d).latitude(0.0d).longLocation("").province("").cityCode("").locationCity("").locationCountry("");
        } else {
            FeedMultiPart.Builder location = builder.location(locationInfo2.getAddress());
            Double longitude = locationInfo2.getLongitude();
            Intrinsics.checkNotNullExpressionValue(longitude, "info.longitude");
            FeedMultiPart.Builder longitude2 = location.longitude(longitude.doubleValue());
            Double latitude = locationInfo2.getLatitude();
            Intrinsics.checkNotNullExpressionValue(latitude, "info.latitude");
            longitude2.latitude(latitude.doubleValue()).longLocation(locationInfo2.getLongAddress()).locationCity(locationInfo2.getCity()).province(locationInfo2.getProvince()).cityCode(locationInfo2.getCityCode()).locationCountry(locationInfo2.getCountry());
        }
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        submitFeedV8Activity2.updateMultiPart(build);
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig build2 = FeedUIConfig.builder(submitFeedV8Activity3.getUiConfig()).tintMarkView(!locationInfo2.getIsHideLocation()).locationName(locationInfo2.getAddress()).build();
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        Intrinsics.checkNotNullExpressionValue(build2, "uiConfig");
        submitFeedV8Activity4.updateUIConfig(build2);
        this.locationInfo = locationInfo2;
        updateLocationInfo();
    }

    private final void updateLocationInfo() {
        SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding = this.bindingArray.get(2131363444);
        if (submitSecondHandDealExtraChildBinding != null) {
            SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding2 = submitSecondHandDealExtraChildBinding;
            submitSecondHandDealExtraChildBinding2.imageView.setImageResource(2131231418);
            TextView textView = submitSecondHandDealExtraChildBinding2.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
            textView.setText("");
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
            if (!uiConfig.tintMarkView()) {
                SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
                if (submitFeedV8Activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                setTint(submitSecondHandDealExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity2, 2131099891));
                submitSecondHandDealExtraChildBinding2.titleView.setText(2131887172);
                return;
            }
            setTint(submitSecondHandDealExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
            TextView textView2 = submitSecondHandDealExtraChildBinding2.titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setText(uiConfig.locationName());
        }
    }

    public final void initLocation(LocationInfo locationInfo2) {
        Intrinsics.checkNotNullParameter(locationInfo2, "info");
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig build = FeedUIConfig.builder(submitFeedV8Activity.getUiConfig()).tintMarkView(!locationInfo2.getIsHideLocation()).locationName(locationInfo2.getCity()).build();
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        Intrinsics.checkNotNullExpressionValue(build, "uiConfig");
        submitFeedV8Activity2.updateUIConfig(build);
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder = FeedMultiPart.builder(submitFeedV8Activity3.getMultiPart());
        FeedMultiPart.Builder location = builder.location(locationInfo2.getCity());
        Double longitude = locationInfo2.getLongitude();
        Intrinsics.checkNotNullExpressionValue(longitude, "info.longitude");
        FeedMultiPart.Builder longitude2 = location.longitude(longitude.doubleValue());
        Double latitude = locationInfo2.getLatitude();
        Intrinsics.checkNotNullExpressionValue(latitude, "info.latitude");
        longitude2.latitude(latitude.doubleValue()).longLocation(locationInfo2.getLongAddress()).locationCity(locationInfo2.getCity()).province(locationInfo2.getProvince()).cityCode(locationInfo2.getCityCode()).locationCountry(locationInfo2.getCountry());
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
        submitFeedV8Activity4.updateMultiPart(build2);
        this.locationInfo = locationInfo2;
        updateLocationInfo();
    }

    private final void updateSecondHandInfo(int i) {
        int i2;
        SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding = this.bindingArray.get(i);
        if (submitSecondHandDealExtraChildBinding != null) {
            SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding2 = submitSecondHandDealExtraChildBinding;
            SubmitFeedV8Activity submitFeedV8Activity = this.activity;
            if (submitFeedV8Activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig uiConfig = submitFeedV8Activity.getUiConfig();
            SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
            if (submitFeedV8Activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            boolean z = !Intrinsics.areEqual(submitFeedV8Activity2.getMultiPart().secondHandSthType(), "104");
            int i3 = 0;
            boolean z2 = uiConfig.secondHandDealType() == 2;
            SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
            if (submitFeedV8Activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig.Builder builder = FeedUIConfig.builder(submitFeedV8Activity3.getUiConfig());
            builder.showParamsItem(z);
            SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
            if (submitFeedV8Activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            FeedUIConfig build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "uiBuilder.build()");
            submitFeedV8Activity4.updateUIConfig(build);
            int i4 = 8;
            String str = "";
            switch (i) {
                case 2131363446:
                    TextView textView = submitSecondHandDealExtraChildBinding2.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                    textView.setText("商品链接");
                    submitSecondHandDealExtraChildBinding2.imageView.setImageResource(2131231401);
                    TextView textView2 = submitSecondHandDealExtraChildBinding2.descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
                    textView2.setText(!TextUtils.isEmpty(uiConfig.secondHandOutLink()) ? "已填写" : str);
                    LinearLayout linearLayout = submitSecondHandDealExtraChildBinding2.itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
                    linearLayout.setVisibility(uiConfig.secondHandDealType() == 1 ? 8 : 0);
                    View view = getView();
                    Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
                    View findViewById = ((LinearLayout) view).findViewById(2131363445);
                    if (findViewById != null) {
                        if (uiConfig.showParamsItem()) {
                            i4 = 0;
                        }
                        findViewById.setVisibility(i4);
                    }
                    String secondHandOutLink = uiConfig.secondHandOutLink();
                    if (secondHandOutLink == null || secondHandOutLink.length() == 0) {
                        SubmitFeedV8Activity submitFeedV8Activity5 = this.activity;
                        if (submitFeedV8Activity5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("activity");
                        }
                        setTint(submitSecondHandDealExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity5, 2131099891));
                        return;
                    }
                    setTint(submitSecondHandDealExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
                    return;
                case 2131363447:
                case 2131363449:
                case 2131363451:
                case 2131363453:
                default:
                    TextView textView3 = submitSecondHandDealExtraChildBinding2.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                    textView3.setText(str);
                    submitSecondHandDealExtraChildBinding2.imageView.setImageResource(0);
                    TextView textView4 = submitSecondHandDealExtraChildBinding2.descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView4, "binding.descriptionView");
                    textView4.setText(str);
                    return;
                case 2131363448:
                    LinearLayout linearLayout2 = submitSecondHandDealExtraChildBinding2.itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.itemView");
                    linearLayout2.setClickable(uiConfig.showParamsItem());
                    LinearLayout linearLayout3 = submitSecondHandDealExtraChildBinding2.itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.itemView");
                    linearLayout3.setVisibility(uiConfig.showParamsItem() ? 0 : 8);
                    View view2 = getView();
                    Objects.requireNonNull(view2, "null cannot be cast to non-null type android.widget.LinearLayout");
                    View findViewById2 = ((LinearLayout) view2).findViewById(2131363447);
                    if (findViewById2 != null) {
                        if (!uiConfig.showParamsItem()) {
                            i3 = 8;
                        }
                        findViewById2.setVisibility(i3);
                    }
                    String str2 = uiConfig.secondHandDealType() != 1 ? "基本参数" : "参数要求";
                    TextView textView5 = submitSecondHandDealExtraChildBinding2.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
                    textView5.setText(str2);
                    submitSecondHandDealExtraChildBinding2.imageView.setImageResource(2131231173);
                    TextView textView6 = submitSecondHandDealExtraChildBinding2.descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView6, "binding.descriptionView");
                    String productConfigShowText = uiConfig.productConfigShowText();
                    if (productConfigShowText != null) {
                        str = productConfigShowText;
                    }
                    textView6.setText(str);
                    if (!TextUtils.isEmpty(uiConfig.productConfigShowText())) {
                        setTint(submitSecondHandDealExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
                    } else {
                        SubmitFeedV8Activity submitFeedV8Activity6 = this.activity;
                        if (submitFeedV8Activity6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("activity");
                        }
                        setTint(submitSecondHandDealExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity6, 2131099891));
                    }
                    if (!TextUtils.isEmpty(uiConfig.productConfigShowText())) {
                        i2 = AppHolder.getAppTheme().getColorAccent();
                    } else if (!uiConfig.showParamsItem()) {
                        i2 = AppHolder.getAppTheme().getContentBackgroundDividerColor();
                    } else {
                        SubmitFeedV8Activity submitFeedV8Activity7 = this.activity;
                        if (submitFeedV8Activity7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("activity");
                        }
                        i2 = ResourceUtils.getColorInt(submitFeedV8Activity7, 2131099891);
                    }
                    setTint(submitSecondHandDealExtraChildBinding2, i2);
                    return;
                case 2131363450:
                    int secondHandDealType = uiConfig.secondHandDealType();
                    String str3 = "开个价";
                    if (secondHandDealType != 0) {
                        if (secondHandDealType == 1) {
                            str3 = "出个价";
                        } else if (secondHandDealType == 2) {
                            str3 = "补差价";
                        }
                    }
                    TextView textView7 = submitSecondHandDealExtraChildBinding2.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
                    textView7.setText(str3);
                    TextView textView8 = submitSecondHandDealExtraChildBinding2.descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView8, "binding.descriptionView");
                    textView8.setVisibility(0);
                    submitSecondHandDealExtraChildBinding2.imageView.setImageResource(2131231238);
                    String secondHandPrice = uiConfig.secondHandPrice();
                    if (secondHandPrice == null) {
                        secondHandPrice = str;
                    }
                    Intrinsics.checkNotNullExpressionValue(secondHandPrice, "uiConfig.secondHandPrice().elvis { \"\" }");
                    int risePriceType = uiConfig.risePriceType();
                    boolean z3 = uiConfig.secondHandFaceDeal() == 1;
                    String str4 = risePriceType != 1 ? risePriceType != 2 ? str : "买家加钱" : "卖家加钱";
                    String str5 = z3 ? str : "¥";
                    TextView textView9 = submitSecondHandDealExtraChildBinding2.descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView9, "binding.descriptionView");
                    boolean z4 = secondHandPrice.length() == 0;
                    String str6 = str4 + str5 + secondHandPrice;
                    if (!z4) {
                        str = str6;
                    }
                    textView9.setText(str);
                    String secondHandPrice2 = uiConfig.secondHandPrice();
                    if (secondHandPrice2 == null || secondHandPrice2.length() == 0) {
                        SubmitFeedV8Activity submitFeedV8Activity8 = this.activity;
                        if (submitFeedV8Activity8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("activity");
                        }
                        setTint(submitSecondHandDealExtraChildBinding2, ResourceUtils.getColorInt(submitFeedV8Activity8, 2131099891));
                        return;
                    }
                    setTint(submitSecondHandDealExtraChildBinding2, AppHolder.getAppTheme().getColorAccent());
                    return;
                case 2131363452:
                    LinearLayout linearLayout4 = submitSecondHandDealExtraChildBinding2.itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.itemView");
                    linearLayout4.setBackground(null);
                    submitSecondHandDealExtraChildBinding2.setClick(new SubmitSecondHandExtraViewPart$updateSecondHandInfo$listener$2(this, submitSecondHandDealExtraChildBinding2));
                    LinearLayout linearLayout5 = submitSecondHandDealExtraChildBinding2.switchContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.switchContainer");
                    linearLayout5.setVisibility(0);
                    submitSecondHandDealExtraChildBinding2.imageView.setImageResource(2131231596);
                    TextView textView10 = submitSecondHandDealExtraChildBinding2.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView10, "binding.titleView");
                    textView10.setText("交易类型");
                    ImageView imageView = submitSecondHandDealExtraChildBinding2.arrowView;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.arrowView");
                    imageView.setVisibility(8);
                    TextView textView11 = submitSecondHandDealExtraChildBinding2.descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView11, "binding.descriptionView");
                    textView11.setVisibility(8);
                    CheckedTextView checkedTextView = submitSecondHandDealExtraChildBinding2.switchLeft;
                    checkedTextView.setText("出售");
                    checkedTextView.setVisibility(0);
                    checkedTextView.setTextColor(createSelectedTextColor());
                    checkedTextView.setBackground(createSelectedBackground());
                    Unit unit = Unit.INSTANCE;
                    int colorAccent = AppHolder.getAppTheme().getColorAccent();
                    submitSecondHandDealExtraChildBinding2.arrowView.setColorFilter(colorAccent, PorterDuff.Mode.SRC_IN);
                    submitSecondHandDealExtraChildBinding2.imageView.setColorFilter(colorAccent, PorterDuff.Mode.SRC_IN);
                    submitSecondHandDealExtraChildBinding2.titleView.setTextColor(colorAccent);
                    updateSecondHandDealType(uiConfig.secondHandDealType(), submitSecondHandDealExtraChildBinding2);
                    return;
                case 2131363454:
                    LinearLayout linearLayout6 = submitSecondHandDealExtraChildBinding2.itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.itemView");
                    linearLayout6.setBackground(null);
                    submitSecondHandDealExtraChildBinding2.setClick(new SubmitSecondHandExtraViewPart$updateSecondHandInfo$listener$1(this, z2, submitSecondHandDealExtraChildBinding2));
                    LinearLayout linearLayout7 = submitSecondHandDealExtraChildBinding2.switchContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.switchContainer");
                    linearLayout7.setVisibility(0);
                    submitSecondHandDealExtraChildBinding2.imageView.setImageResource(2131231357);
                    TextView textView12 = submitSecondHandDealExtraChildBinding2.titleView;
                    Intrinsics.checkNotNullExpressionValue(textView12, "binding.titleView");
                    textView12.setText("我的身份");
                    ImageView imageView2 = submitSecondHandDealExtraChildBinding2.arrowView;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.arrowView");
                    imageView2.setVisibility(8);
                    TextView textView13 = submitSecondHandDealExtraChildBinding2.descriptionView;
                    Intrinsics.checkNotNullExpressionValue(textView13, "binding.descriptionView");
                    textView13.setVisibility(8);
                    CheckedTextView checkedTextView2 = submitSecondHandDealExtraChildBinding2.switchLeft;
                    checkedTextView2.setVisibility(0);
                    checkedTextView2.setText("个人");
                    checkedTextView2.setTextColor(createSelectedTextColor());
                    checkedTextView2.setBackground(createSelectedBackground());
                    Unit unit2 = Unit.INSTANCE;
                    CheckedTextView checkedTextView3 = submitSecondHandDealExtraChildBinding2.switchRight;
                    checkedTextView3.setVisibility(0);
                    checkedTextView3.setText("商家");
                    checkedTextView3.setTextColor(createSelectedTextColor());
                    checkedTextView3.setBackground(createSelectedBackground());
                    Unit unit3 = Unit.INSTANCE;
                    SubmitFeedV8Activity submitFeedV8Activity9 = this.activity;
                    if (submitFeedV8Activity9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    int colorInt = ResourceUtils.getColorInt(submitFeedV8Activity9, 2131099891);
                    submitSecondHandDealExtraChildBinding2.arrowView.setColorFilter(colorInt, PorterDuff.Mode.SRC_IN);
                    submitSecondHandDealExtraChildBinding2.imageView.setColorFilter(colorInt, PorterDuff.Mode.SRC_IN);
                    submitSecondHandDealExtraChildBinding2.titleView.setTextColor(colorInt);
                    bindDataSecondHandType(submitSecondHandDealExtraChildBinding2);
                    return;
            }
        }
    }

    private final void onRequestSecondHand(int i) {
        if (i != 2131363446) {
            boolean z = true;
            if (i == 2131363448) {
                SubmitFeedV8Activity submitFeedV8Activity = this.activity;
                if (submitFeedV8Activity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedMultiPart multiPart = submitFeedV8Activity.getMultiPart();
                String secondHandSthType = multiPart.secondHandSthType();
                if (!(secondHandSthType == null || secondHandSthType.length() == 0)) {
                    z = false;
                }
                if (z) {
                    SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
                    if (submitFeedV8Activity2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    Toast.show$default(submitFeedV8Activity2, "请先选择要发布的商品型号或类别", 0, false, 12, null);
                    SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
                    if (submitFeedV8Activity3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    SubmitFeedV8Activity submitFeedV8Activity4 = submitFeedV8Activity3;
                    SubmitFeedV8Activity submitFeedV8Activity5 = this.activity;
                    if (submitFeedV8Activity5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activity");
                    }
                    ActionManager.startProductBrandListInErshouActivity(submitFeedV8Activity4, 2, submitFeedV8Activity5.getUiConfig().secondHandDealType(), 2323);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                SubmitFeedV8Activity submitFeedV8Activity6 = this.activity;
                if (submitFeedV8Activity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedUIConfig uiConfig = submitFeedV8Activity6.getUiConfig();
                List<ProductParams> productConfigCacheList = uiConfig.productConfigCacheList();
                Intrinsics.checkNotNullExpressionValue(productConfigCacheList, "uiConfig.productConfigCacheList()");
                arrayList.addAll(productConfigCacheList);
                SubmitFeedV8Activity submitFeedV8Activity7 = this.activity;
                if (submitFeedV8Activity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                ActionManager.startSelectParamsAction(submitFeedV8Activity7, multiPart.productId(), multiPart.secondHandSthType(), arrayList, String.valueOf(uiConfig.secondHandDealType()));
            } else if (i == 2131363450) {
                SubmitFeedV8Activity submitFeedV8Activity8 = this.activity;
                if (submitFeedV8Activity8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FeedUIConfig uiConfig2 = submitFeedV8Activity8.getUiConfig();
                int secondHandDealType = uiConfig2.secondHandDealType();
                String str = secondHandDealType != 0 ? secondHandDealType != 1 ? secondHandDealType != 2 ? "" : "补多少差价？" : "你想多少钱买？" : "你想卖多少钱？";
                EditSecondHandPriceDialogFragment.Companion companion = EditSecondHandPriceDialogFragment.Companion;
                String secondHandPrice = uiConfig2.secondHandPrice();
                Intrinsics.checkNotNull(secondHandPrice);
                Intrinsics.checkNotNullExpressionValue(secondHandPrice, "uiConfig.secondHandPrice()!!");
                SubmitFeedV8Activity submitFeedV8Activity9 = this.activity;
                if (submitFeedV8Activity9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                EditSecondHandPriceDialogFragment newInstance = companion.newInstance(str, secondHandPrice, secondHandDealType, submitFeedV8Activity9.getMultiPart().risePriceType());
                newInstance.setListener(new SubmitSecondHandExtraViewPart$onRequestSecondHand$1(this, i, newInstance));
                SubmitFeedV8Activity submitFeedV8Activity10 = this.activity;
                if (submitFeedV8Activity10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activity");
                }
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(submitFeedV8Activity10).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
            }
        } else {
            SubmitFeedV8Activity submitFeedV8Activity11 = this.activity;
            if (submitFeedV8Activity11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activity");
            }
            String secondHandOutLink = submitFeedV8Activity11.getMultiPart().secondHandOutLink();
            Intrinsics.checkNotNullExpressionValue(secondHandOutLink, "activity.multiPart.secondHandOutLink()");
            showSecondHandDialog("商品链接", i, secondHandOutLink);
        }
    }

    public final void onPickSHOutLink(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig.Builder builder = FeedUIConfig.builder(submitFeedV8Activity.getUiConfig());
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder2 = FeedMultiPart.builder(submitFeedV8Activity2.getMultiPart());
        builder.secondHandOutLink(str);
        builder2.secondHandOutLink(str);
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "uiBuilder.build()");
        submitFeedV8Activity3.updateUIConfig(build);
        updateSecondHandInfo(i);
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build2 = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "multiPartBuilder.build()");
        submitFeedV8Activity4.updateMultiPart(build2);
    }

    /* access modifiers changed from: private */
    public final void onPickSHPirce(Pair<Integer, String> pair, int i) {
        int i2 = pair.getFirst().intValue() == 3 ? 1 : 0;
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig.Builder builder = FeedUIConfig.builder(submitFeedV8Activity.getUiConfig());
        SubmitFeedV8Activity submitFeedV8Activity2 = this.activity;
        if (submitFeedV8Activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart.Builder builder2 = FeedMultiPart.builder(submitFeedV8Activity2.getMultiPart());
        builder.secondHandPrice(pair.getSecond());
        builder.secondHandFaceDeal(i2);
        builder2.secondHandFaceDeal(i2);
        String second = pair.getSecond();
        if (i2 != 0) {
            second = "";
        }
        builder2.secondHandPrice(second);
        if (i2 != 0) {
            builder2.secondHandFaceDeal(1);
        }
        builder.risePriceType(pair.getFirst().intValue());
        builder2.risePriceType(pair.getFirst().intValue());
        SubmitFeedV8Activity submitFeedV8Activity3 = this.activity;
        if (submitFeedV8Activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedUIConfig build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "uiBuilder.build()");
        submitFeedV8Activity3.updateUIConfig(build);
        updateSecondHandInfo(i);
        SubmitFeedV8Activity submitFeedV8Activity4 = this.activity;
        if (submitFeedV8Activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FeedMultiPart build2 = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "multiPartBuilder.build()");
        submitFeedV8Activity4.updateMultiPart(build2);
    }

    static /* synthetic */ void showSecondHandDialog$default(SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        submitSecondHandExtraViewPart.showSecondHandDialog(str, i, str2);
    }

    private final void showSecondHandDialog(String str, int i, String str2) {
        EditSecondHandDialogFragment newInstance = EditSecondHandDialogFragment.Companion.newInstance(str, i, str2);
        newInstance.setListener(new SubmitSecondHandExtraViewPart$showSecondHandDialog$1(this, i, newInstance));
        SubmitFeedV8Activity submitFeedV8Activity = this.activity;
        if (submitFeedV8Activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(submitFeedV8Activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    private final ColorStateList createSelectedTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
    }

    private final StateListDrawable createSelectedBackground() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] selected = ViewStates.INSTANCE.selected();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable, ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
        stateListDrawable.addState(selected, gradientDrawable);
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable2, Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#282828" : "#F5F5F5"));
        stateListDrawable.addState(iArr, gradientDrawable2);
        return stateListDrawable;
    }

    private final StateListDrawable createSelectedBackground(boolean z) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] selected = ViewStates.INSTANCE.selected();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable, ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
        stateListDrawable.addState(selected, gradientDrawable);
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable2, Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#282828" : "#F5F5F5"));
        stateListDrawable.addState(iArr, gradientDrawable2);
        return stateListDrawable;
    }
}
