package com.coolapk.market.extend;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.animation.Interpolator.Ease;
import com.coolapk.market.animation.Interpolator.EasingInterpolator;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.util.ATEUtil;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.cardlist.divider.VXDividerDecoration;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import com.coolapk.market.widget.FixTouchLinkMovementMethod;
import com.coolapk.market.widget.RoundRectDrawableWithShadow;
import com.coolapk.market.widget.ViewTouchAnimatorKt;
import com.coolapk.market.widget.decoration.CustomizedItemDecoration;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import rx.Emitter;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0011\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u001a#\u0010 \u001a\u00020\u001a*\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001a0#¢\u0006\u0002\b%\u001a\n\u0010&\u001a\u00020\u001f*\u00020\n\u001a\n\u0010'\u001a\u00020\u001f*\u00020\n\u001a\n\u0010(\u001a\u00020\u001f*\u00020\n\u001a\u0012\u0010)\u001a\u00020\u001a*\u00020\n2\u0006\u0010*\u001a\u00020+\u001a\u001e\u0010,\u001a\u00020\u001a*\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\u001d\u001a\n\u0010/\u001a\u00020\u001a*\u00020\n\u001a\n\u00100\u001a\u00020\u001a*\u00020\n\u001a\n\u00101\u001a\u00020\u001a*\u00020\n\u001a \u00102\u001a\u00020\u001a*\u00020\n2\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a03H\bø\u0001\u0000\u001a \u00104\u001a\u00020\u001a*\u00020\n2\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a03H\bø\u0001\u0000\u001a5\u00105\u001a\u00020\u001a*\u00020\n2#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u001a0#H\bø\u0001\u0000\u001a \u00109\u001a\u00020\u001a*\u00020\n2\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f03H\bø\u0001\u0000\u001a\u0012\u0010:\u001a\u00020\u001a*\u00020\n2\u0006\u0010;\u001a\u00020\u0001\u001a\n\u0010<\u001a\u00020\u001a*\u00020\n\u001a&\u0010=\u001a\u00020\u001a*\u00020>2\u0006\u0010?\u001a\u00020\u00012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0#\u001a\n\u0010@\u001a\u00020\u001d*\u00020\n\u001a\n\u0010A\u001a\u00020\u001a*\u00020\n\u001a\u001c\u0010B\u001a\u00020\n*\u00020>2\u0006\u0010C\u001a\u00020\u00012\b\b\u0002\u0010D\u001a\u00020\u001f\u001a\n\u0010E\u001a\u00020\u001a*\u00020F\u001a\u0012\u0010G\u001a\u00020\u001a*\u00020F2\u0006\u0010H\u001a\u00020I\u001a\n\u0010J\u001a\u00020\u001a*\u00020\n\u001a\n\u0010K\u001a\u00020\u001f*\u00020\n\u001a\n\u0010L\u001a\u00020\u001f*\u00020F\u001a\n\u0010M\u001a\u00020\u001f*\u00020\n\u001a\u001c\u0010N\u001a\u00020\u001a*\u00020O2\u0006\u0010P\u001a\u00020\u00012\b\b\u0002\u0010Q\u001a\u00020\u0001\u001a\n\u0010R\u001a\u00020\u001a*\u00020!\u001a\u0014\u0010S\u001a\u00020\u001a*\u00020\n2\b\b\u0002\u0010T\u001a\u00020\u0001\u001a\u0010\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00010V*\u00020O\u001a\u0018\u0010W\u001a\u00020\u001a*\u00020\n2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a03\u001a\n\u0010Y\u001a\u00020\u001a*\u00020O\u001a\n\u0010Z\u001a\u00020\u001a*\u00020\n\u001a\n\u0010[\u001a\u00020\u001a*\u00020\u001b\u001a&\u0010\\\u001a\u00020\u001a*\u00020!2\u0006\u0010]\u001a\u00020\u00012\b\u0010^\u001a\u0004\u0018\u00010I2\b\b\u0002\u0010_\u001a\u00020`\u001a\u0012\u0010a\u001a\u00020\u001a*\u00020b2\u0006\u0010c\u001a\u00020d\u001a/\u0010e\u001a\u00020\u001a*\u00020b2\u0006\u0010f\u001a\u00020g2\u0006\u0010c\u001a\u00020d2\u000e\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0i¢\u0006\u0002\u0010k\u001a.\u0010l\u001a\u00020\u001a*\u00020m2\u0006\u0010n\u001a\u00020\u00012\u0006\u0010o\u001a\u00020`2\b\b\u0002\u0010_\u001a\u00020`2\b\b\u0002\u0010p\u001a\u00020\u001f\u001a\u001a\u0010l\u001a\u00020\u001a*\u00020m2\u0006\u0010n\u001a\u00020\u00012\u0006\u0010q\u001a\u00020I\u001a\u001e\u0010r\u001a\u00020\u001a*\u00020\n2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0#\u001a\u0017\u0010r\u001a\u00020\u001a*\u00020\n2\b\u0010s\u001a\u0004\u0018\u00010tH\b\u001a\n\u0010u\u001a\u00020\u001a*\u00020\n\u001a\n\u0010v\u001a\u00020\u001a*\u00020\u001b\u001a\u0012\u0010v\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010w\u001a\u00020\u0001\u001a\u0014\u0010x\u001a\u00020\u001a*\u00020\n2\b\b\u0002\u0010y\u001a\u00020\u001d\u001a\u001e\u0010z\u001a\u00020\u001a*\u00020\n2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a0#\u001a\u0015\u0010z\u001a\u00020\u001a*\u00020\n2\u0006\u0010s\u001a\u00020{H\b\u001a\n\u0010|\u001a\u00020\u001a*\u00020b\u001a\u0012\u0010}\u001a\u00020\u001a*\u00020b2\u0006\u0010~\u001a\u00020\u001f\u001a\u0013\u0010\u001a\u00020\u001a*\u00020b2\u0007\u0010\u0001\u001a\u00020\u0001\u001a#\u0010\u0001\u001a\u00020\u001a*\u00020\n2\n\b\u0002\u0010\u0001\u001a\u00030\u00012\n\b\u0002\u0010\u0001\u001a\u00030\u0001\u001aH\u0010\u0001\u001a\u00020\u001a*\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u00012\u0011\b\u0002\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u000103\u001a\u0013\u0010\u0001\u001a\u00020\b*\u00020\b2\u0006\u0010w\u001a\u00020\u0001\u001a7\u0010\u0001\u001a\u00020\u001a*\u00020\u00162\t\b\u0002\u0010\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u0001\u001a+\u0010\u0001\u001a\u00020\u001a*\u00020\n2\u0018\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001a0#¢\u0006\u0002\b%H\bø\u0001\u0000\u001a\u000b\u0010\u0001\u001a\u00020\u001a*\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\",\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\"\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"CLIP_CAPSULE", "", "CLIP_OVAL", "CLIP_RECTANGLE", "CLIP_ROUND_RECT", "MATCH_PARENT", "WRAP_CONTENT", "value", "Landroid/graphics/drawable/Drawable;", "compatForeground", "Landroid/view/View;", "getCompatForeground", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "setCompatForeground", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "globalRect", "Landroid/graphics/Rect;", "getGlobalRect", "(Landroid/view/View;)Landroid/graphics/Rect;", "globalRectInsetPadding", "getGlobalRectInsetPadding", "marginParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "getMarginParams", "(Landroid/view/View;)Landroid/view/ViewGroup$MarginLayoutParams;", "adjustTintColorByAlpha", "", "Landroidx/appcompat/widget/Toolbar;", "alpha", "", "isBackgroundLight", "", "applyText", "Landroid/widget/TextView;", "action", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "Lkotlin/ExtensionFunctionType;", "canScrollDown", "canScrollRight", "checkShouldRequestLayout", "clipRoundRect", "radiusArray", "", "clipView", "newShape", "newRadius", "darkForegroundIfNeed", "detachFromParent", "disableAccessibilityClick", "doOnNextAttach", "Lkotlin/Function0;", "doOnNextDetach", "doOnNextLayout", "Lkotlin/ParameterName;", "name", "view", "doOnNextPreDraw", "expandTouchRect", "howMuch", "fadeForeground", "foreachChild", "Landroid/view/ViewGroup;", "deep", "getClipRectRadius", "gone", "inflateView", "layoutId", "attachToRoot", "insertBackKey", "Landroid/widget/EditText;", "insertText", "inputText", "", "invisible", "isRequestLayoutRecursived", "isTrimTextEmpty", "isVisible", "makePositionInScreen", "Landroidx/recyclerview/widget/RecyclerView;", "position", "extraOffset", "makeSpanClickable", "measureWithScreenWidth", "extraMargin", "newScrollYObservable", "Lrx/Observable;", "onceOnGlobalLayoutListener", "callback", "removeAllItemDecorations", "requestLayoutRecursive", "resetTintColor", "setBriefMessage", "maxWords", "message", "endText", "", "setDefaultDoubleClickListener", "Lcom/coolapk/market/widget/view/TabLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "setDefaultSubTabConfigListener", "activity", "Landroid/app/Activity;", "tabApi", "", "Lcom/coolapk/market/model/ConfigPage;", "(Lcom/coolapk/market/widget/view/TabLayout;Landroid/app/Activity;Landroidx/viewpager/widget/ViewPager;[Lcom/coolapk/market/model/ConfigPage;)V", "setMaxLineEllipsize", "Lcom/coolapk/market/widget/view/CoolEllipsizeTextView;", "maxLines", "content", "spanClickable", "needConvertString", "setOnDoubleClickListener", "listener", "Lcom/coolapk/market/util/ViewUtil$OnDoubleClickListener;", "setScaleUpWhenTouch", "setTintColor", "color", "setTopElevation", "elevation", "setUtilClickListener", "Landroid/view/View$OnClickListener;", "setV8CompatTabUI", "setV9TabColor", "isInsideAppBar", "setV9TabUI", "tabMode", "showShakingAnimation", "duration", "", "delay", "startAlphaRevealAnimation", "backView", "centerX", "centerY", "finalRadius", "onEnd", "tintColor", "updateMargin", "left", "top", "right", "bottom", "updateMarginLayoutParams", "block", "visible", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt {
    public static final int CLIP_CAPSULE = 2;
    public static final int CLIP_OVAL = 1;
    public static final int CLIP_RECTANGLE = 0;
    public static final int CLIP_ROUND_RECT = 3;
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;

    public static final boolean canScrollDown(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$canScrollDown");
        return view.canScrollVertically(-1);
    }

    public static final boolean canScrollRight(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$canScrollRight");
        return view.canScrollHorizontally(-1);
    }

    public static final void gone(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$gone");
        view.setVisibility(8);
    }

    public static final void invisible(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$invisible");
        view.setVisibility(4);
    }

    public static final void visible(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$visible");
        view.setVisibility(0);
    }

    public static final boolean isVisible(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }

    public static final void removeAllItemDecorations(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$removeAllItemDecorations");
        while (recyclerView.getItemDecorationCount() > 0) {
            RecyclerView.ItemDecoration itemDecorationAt = recyclerView.getItemDecorationAt(0);
            Intrinsics.checkNotNullExpressionValue(itemDecorationAt, "getItemDecorationAt(0)");
            recyclerView.removeItemDecoration(itemDecorationAt);
            if (itemDecorationAt instanceof CustomizedItemDecoration) {
                ((CustomizedItemDecoration) itemDecorationAt).detach();
            } else if (itemDecorationAt instanceof VXDividerDecoration) {
                ((VXDividerDecoration) itemDecorationAt).detach();
            }
        }
    }

    public static /* synthetic */ void makePositionInScreen$default(RecyclerView recyclerView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        makePositionInScreen(recyclerView, i, i2);
    }

    public static final void makePositionInScreen(RecyclerView recyclerView, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(recyclerView, "$this$makePositionInScreen");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() > i || linearLayoutManager.findLastCompletelyVisibleItemPosition() < i) {
                if (recyclerView.getPaddingTop() > 0) {
                    i3 = 0;
                } else {
                    i3 = UiUtils.getStatusBarHeight(recyclerView.getContext()) + UiUtils.getActionBarSize(recyclerView.getContext());
                }
                linearLayoutManager.scrollToPositionWithOffset(i, i3 + i2);
            }
        }
    }

    public static final void expandTouchRect(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$expandTouchRect");
        Rect rect = new Rect();
        view.getHitRect(rect);
        int i2 = -i;
        rect.inset(i2, i2);
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.setTouchDelegate(new TouchDelegate(rect, view));
        }
    }

    public static final void detachFromParent(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$detachFromParent");
        ViewParent parent = view.getParent();
        if (parent != null) {
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    public static final void darkForegroundIfNeed(View view) {
        ColorDrawable colorDrawable;
        Intrinsics.checkNotNullParameter(view, "$this$darkForegroundIfNeed");
        if (Build.VERSION.SDK_INT >= 23) {
            AppTheme appTheme = AppHolder.getAppTheme();
            if (appTheme.isDarkTheme()) {
                ColorDrawable colorDrawable2 = new ColorDrawable(appTheme.getContentBackgroundColor());
                colorDrawable2.setAlpha(26);
                Unit unit = Unit.INSTANCE;
                colorDrawable = colorDrawable2;
            } else {
                colorDrawable = null;
            }
            view.setForeground(colorDrawable);
        }
    }

    public static final void doOnNextAttach(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$doOnNextAttach");
        Intrinsics.checkNotNullParameter(function0, "action");
        view.addOnAttachStateChangeListener(new ViewExtendsKt$doOnNextAttach$1(view, function0));
    }

    public static final void doOnNextDetach(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$doOnNextDetach");
        Intrinsics.checkNotNullParameter(function0, "action");
        view.addOnAttachStateChangeListener(new ViewExtendsKt$doOnNextDetach$1(view, function0));
    }

    public static final void doOnNextLayout(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$doOnNextLayout");
        Intrinsics.checkNotNullParameter(function1, "action");
        view.addOnLayoutChangeListener(new ViewExtendsKt$doOnNextLayout$1(function1));
    }

    public static /* synthetic */ void startAlphaRevealAnimation$default(View view, View view2, int i, int i2, int i3, Function0 function0, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = view2.getWidth() / 4;
        }
        if ((i4 & 4) != 0) {
            i2 = view2.getHeight() / 2;
        }
        if ((i4 & 8) != 0) {
            i3 = Math.max(view2.getWidth(), view2.getHeight());
        }
        if ((i4 & 16) != 0) {
            function0 = null;
        }
        startAlphaRevealAnimation(view, view2, i, i2, i3, function0);
    }

    public static final void startAlphaRevealAnimation(View view, View view2, int i, int i2, int i3, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$startAlphaRevealAnimation");
        Intrinsics.checkNotNullParameter(view2, "backView");
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, (float) (i3 / 4), (float) i3);
        Intrinsics.checkNotNullExpressionValue(createCircularReveal, "revealAnim");
        createCircularReveal.setInterpolator(new EasingInterpolator(Ease.LINEAR));
        createCircularReveal.setDuration(400);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "coverMaskAlphaAnim");
        ofFloat.setInterpolator(new EasingInterpolator(Ease.LINEAR));
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "coverAlphaAnim");
        ofFloat2.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, createCircularReveal, ofFloat2);
        animatorSet.addListener(new ViewExtendsKt$startAlphaRevealAnimation$1(function0));
        animatorSet.start();
    }

    public static final Drawable getCompatForeground(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$compatForeground");
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getForeground();
        }
        return null;
    }

    public static final void setCompatForeground(View view, Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "$this$compatForeground");
        if (Build.VERSION.SDK_INT >= 23) {
            view.setForeground(drawable);
        }
    }

    public static final void setUtilClickListener(View view, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(view, "$this$setUtilClickListener");
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        ViewUtil.clickListener(view, onClickListener);
    }

    public static final void setUtilClickListener(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$setUtilClickListener");
        Intrinsics.checkNotNullParameter(function1, "listener");
        ViewUtil.clickListener(view, new ViewExtendsKt$sam$android_view_View_OnClickListener$0(function1));
    }

    public static final void setOnDoubleClickListener(View view, ViewUtil.OnDoubleClickListener onDoubleClickListener) {
        Intrinsics.checkNotNullParameter(view, "$this$setOnDoubleClickListener");
        ViewUtil.doubleClickListener(view, onDoubleClickListener);
    }

    public static final void setOnDoubleClickListener(View view, Function1<? super View, Boolean> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$setOnDoubleClickListener");
        Intrinsics.checkNotNullParameter(function1, "listener");
        ViewUtil.doubleClickListener(view, new ViewExtendsKt$sam$com_coolapk_market_util_ViewUtil_OnDoubleClickListener$0(function1));
    }

    public static /* synthetic */ void measureWithScreenWidth$default(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        measureWithScreenWidth(view, i);
    }

    public static final void measureWithScreenWidth(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$measureWithScreenWidth");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = null;
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            i2 = Integer.valueOf(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (i2 == null) {
            i2 = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((DisplayUtils.getDecorViewWidth(view.getContext()) - i) - i2.intValue(), 1073741824), View.MeasureSpec.makeMeasureSpec(DisplayUtils.getDecorViewHeight(view.getContext()), 0));
    }

    public static /* synthetic */ View inflateView$default(ViewGroup viewGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return inflateView(viewGroup, i, z);
    }

    public static final View inflateView(ViewGroup viewGroup, int i, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$inflateView");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…utId, this, attachToRoot)");
        return inflate;
    }

    public static final Rect getGlobalRectInsetPadding(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$globalRectInsetPadding");
        Rect globalRect = getGlobalRect(view);
        if (globalRect == null) {
            return null;
        }
        globalRect.left += view.getPaddingLeft();
        globalRect.top += view.getPaddingTop();
        globalRect.right -= view.getPaddingRight();
        globalRect.bottom -= view.getPaddingBottom();
        return globalRect;
    }

    public static final Rect getGlobalRect(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$globalRect");
        int[] iArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationInWindow(iArr);
        if (iArr[0] == Integer.MIN_VALUE || iArr[1] == Integer.MIN_VALUE) {
            return null;
        }
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public static /* synthetic */ void setMaxLineEllipsize$default(CoolEllipsizeTextView coolEllipsizeTextView, int i, CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        setMaxLineEllipsize(coolEllipsizeTextView, i, charSequence, charSequence2, z);
    }

    public static final void setMaxLineEllipsize(CoolEllipsizeTextView coolEllipsizeTextView, int i, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(coolEllipsizeTextView, "$this$setMaxLineEllipsize");
        Intrinsics.checkNotNullParameter(charSequence, "content");
        Intrinsics.checkNotNullParameter(charSequence2, "endText");
        coolEllipsizeTextView.setMaxLines(i);
        coolEllipsizeTextView.setEllipsizeText(charSequence2, 0);
        coolEllipsizeTextView.setText(charSequence);
        if (z) {
            makeSpanClickable(coolEllipsizeTextView);
        }
    }

    public static /* synthetic */ void setBriefMessage$default(TextView textView, int i, String str, CharSequence charSequence, int i2, Object obj) {
        if ((i2 & 4) != 0) {
        }
        setBriefMessage(textView, i, str, charSequence);
    }

    public static final void setBriefMessage(TextView textView, int i, String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(textView, "$this$setBriefMessage");
        Intrinsics.checkNotNullParameter(charSequence, "endText");
        TextViewBindingAdapters.setTextViewLinkable(textView, str, Integer.valueOf(i), null, null, null, charSequence.toString());
    }

    public static final void makeSpanClickable(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "$this$makeSpanClickable");
        textView.setMovementMethod(FixTouchLinkMovementMethod.getInstance());
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setLongClickable(false);
    }

    public static final void setTintColor(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$setTintColor");
        setTintColor(toolbar, AppHolder.getAppTheme().getMainTextColor());
    }

    public static final void resetTintColor(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$resetTintColor");
        Object tag = toolbar.getTag(2131363492);
        if (!(tag instanceof Integer)) {
            tag = null;
        }
        Integer num = (Integer) tag;
        if (num != null) {
            int intValue = num.intValue();
            toolbar.setTag(2131363492, null);
            setTintColor(toolbar, intValue);
        }
    }

    public static final void setTintColor(Toolbar toolbar, int i) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$setTintColor");
        Object tag = toolbar.getTag(2131363492);
        if (!((tag instanceof Integer) && i == ((Integer) tag).intValue())) {
            toolbar.setTag(2131363492, Integer.valueOf(i));
            toolbar.setSubtitleTextColor(ATEUtil.adjustAlpha(i, 0.6f));
            toolbar.setTitleTextColor(i);
            if (toolbar.getParent() instanceof CollapsingToolbarLayout) {
                ViewParent parent = toolbar.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout");
                ((CollapsingToolbarLayout) parent).setCollapsedTitleTextColor(i);
            }
            if (AppHolder.getAppTheme().isDarkTheme()) {
                toolbar.setPopupTheme(2131952196);
            } else {
                toolbar.setPopupTheme(2131952202);
            }
            ViewExtendsKt$setTintColor$1 viewExtendsKt$setTintColor$1 = ViewExtendsKt$setTintColor$1.INSTANCE;
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
            int childCount = toolbar.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = toolbar.getChildAt(i2);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                viewExtendsKt$setTintColor$1.invoke(childAt, porterDuffColorFilter, i);
            }
            toolbar.setOnHierarchyChangeListener(new ViewExtendsKt$setTintColor$2(porterDuffColorFilter, i));
        }
    }

    public static final Drawable tintColor(Drawable drawable, int i) {
        Intrinsics.checkNotNullParameter(drawable, "$this$tintColor");
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "mutate()");
        mutate.setTint(i);
        return mutate;
    }

    public static /* synthetic */ void adjustTintColorByAlpha$default(Toolbar toolbar, float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        adjustTintColorByAlpha(toolbar, f, z);
    }

    public static final void adjustTintColorByAlpha(Toolbar toolbar, float f, boolean z) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$adjustTintColorByAlpha");
        boolean z2 = !AppHolder.getAppTheme().isLightColorTheme() ? f >= 0.5f || !z : f < 0.5f && !z;
        Context context = toolbar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("transparent_status_bar");
        if (z2) {
            setTintColor(toolbar, -1);
            if (booleanPref) {
                ThemeUtils.setDarkStatusIconBar(activityNullable, false, 0);
                return;
            }
            return;
        }
        setTintColor(toolbar, ResourceUtils.getColorInt(activityNullable, 2131099891));
        if (booleanPref) {
            ThemeUtils.setDarkStatusIconBar(activityNullable, true, 0);
        }
    }

    public static /* synthetic */ void setTopElevation$default(View view, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 3.0f;
        }
        setTopElevation(view, f);
    }

    public static final void setTopElevation(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "$this$setTopElevation");
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float f2 = resources.getDisplayMetrics().density;
        float f3 = (float) 1;
        view.setBackground(new RoundRectDrawableWithShadow(view.getContext(), -16777216, 0.0f, f * f2, ((f + f3) * f2) + f3));
    }

    public static final void fadeForeground(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$fadeForeground");
        if (Build.VERSION.SDK_INT >= 23) {
            Drawable foreground = view.getForeground();
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(1200L);
            valueAnimator.setIntValues(0, 64, 0);
            valueAnimator.addUpdateListener(new ViewExtendsKt$fadeForeground$$inlined$apply$lambda$1(new ColorDrawable(AppHolder.getAppTheme().getColorAccent()), view, foreground));
            valueAnimator.addListener(new ViewExtendsKt$fadeForeground$$inlined$apply$lambda$2(view, foreground));
            valueAnimator.start();
        }
    }

    public static final Observable<Integer> newScrollYObservable(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$newScrollYObservable");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) null;
        Observable<Integer> doOnUnsubscribe = Observable.create(new ViewExtendsKt$newScrollYObservable$1(recyclerView, objectRef), Emitter.BackpressureMode.LATEST).doOnUnsubscribe(new ViewExtendsKt$newScrollYObservable$2(recyclerView, objectRef));
        Intrinsics.checkNotNullExpressionValue(doOnUnsubscribe, "Observable.create<Int>({…listener!!)\n            }");
        return doOnUnsubscribe;
    }

    public static final void clipRoundRect(View view, float[] fArr) {
        Intrinsics.checkNotNullParameter(view, "$this$clipRoundRect");
        Intrinsics.checkNotNullParameter(fArr, "radiusArray");
        if (!view.getClipToOutline()) {
            view.setClipToOutline(true);
        }
        view.setOutlineProvider(new ViewExtendsKt$clipRoundRect$1(fArr));
    }

    public static /* synthetic */ void clipView$default(View view, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        clipView(view, i, f);
    }

    public static final void clipView(View view, int i, float f) {
        Intrinsics.checkNotNullParameter(view, "$this$clipView");
        if (!view.getClipToOutline()) {
            view.setClipToOutline(true);
        }
        ViewOutlineProvider outlineProvider = view.getOutlineProvider();
        if (outlineProvider instanceof SimpleOutLineProvider) {
            SimpleOutLineProvider simpleOutLineProvider = (SimpleOutLineProvider) outlineProvider;
            simpleOutLineProvider.setNewRadius(f);
            simpleOutLineProvider.setNewShape(i);
            return;
        }
        view.setOutlineProvider(new SimpleOutLineProvider(i, f));
    }

    public static final float getClipRectRadius(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$getClipRectRadius");
        if (!view.getClipToOutline()) {
            return 0.0f;
        }
        ViewOutlineProvider outlineProvider = view.getOutlineProvider();
        if (!(outlineProvider instanceof SimpleOutLineProvider)) {
            outlineProvider = null;
        }
        SimpleOutLineProvider simpleOutLineProvider = (SimpleOutLineProvider) outlineProvider;
        if (simpleOutLineProvider == null || simpleOutLineProvider.getNewShape() != 0) {
            return 0.0f;
        }
        return simpleOutLineProvider.getNewRadius();
    }

    public static /* synthetic */ void updateMargin$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        updateMargin(marginLayoutParams, i, i2, i3, i4);
    }

    public static final void updateMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "$this$updateMargin");
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.rightMargin = i3;
        marginLayoutParams.bottomMargin = i4;
    }

    public static final ViewGroup.MarginLayoutParams getMarginParams(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$marginParams");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        return (ViewGroup.MarginLayoutParams) layoutParams;
    }

    public static final void requestLayoutRecursive(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$requestLayoutRecursive");
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup == null) {
            return;
        }
        if (viewGroup.isLayoutRequested()) {
            requestLayoutRecursive(viewGroup);
        } else {
            viewGroup.requestLayout();
        }
    }

    public static final boolean isRequestLayoutRecursived(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$isRequestLayoutRecursived");
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup == null) {
            return true;
        }
        if (viewGroup.isLayoutRequested()) {
            return isRequestLayoutRecursived(viewGroup);
        }
        return false;
    }

    public static final void doOnNextPreDraw(View view, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$doOnNextPreDraw");
        Intrinsics.checkNotNullParameter(function0, "action");
        view.getViewTreeObserver().addOnPreDrawListener(new ViewExtendsKt$doOnNextPreDraw$1(view, function0));
    }

    public static final void onceOnGlobalLayoutListener(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$onceOnGlobalLayoutListener");
        Intrinsics.checkNotNullParameter(function0, "callback");
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewExtendsKt$onceOnGlobalLayoutListener$1(view, function0));
    }

    public static final void setV9TabColor(TabLayout tabLayout, boolean z) {
        Intrinsics.checkNotNullParameter(tabLayout, "$this$setV9TabColor");
        if (z) {
            AppTheme appTheme = AppHolder.getAppTheme();
            Context context = tabLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int tabIndicatorColor = appTheme.getTabIndicatorColor(context);
            tabLayout.setTabTextColors(ResourceUtils.resolveData(tabLayout.getContext(), 2130969533), tabIndicatorColor);
            tabLayout.setSelectedTabIndicatorColor(tabIndicatorColor);
            return;
        }
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        tabLayout.setTabTextColors(ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099891), colorAccent);
        tabLayout.setSelectedTabIndicatorColor(colorAccent);
    }

    public static final void setV8CompatTabUI(TabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "$this$setV8CompatTabUI");
        tabLayout.setSelectedTabIndicatorHeight(NumberExtendsKt.getDp(Double.valueOf(2.5d)));
        tabLayout.setTabTextSize((float) NumberExtendsKt.getSp((Number) 16));
        tabLayout.setTabMinWidth(NumberExtendsKt.getDp((Number) 48));
        tabLayout.setScrollableTabMinWidth(NumberExtendsKt.getDp((Number) 48));
        tabLayout.setTabBackgroundResId(0);
        tabLayout.applyModeAndGravity();
    }

    public static final void setV9TabUI(TabLayout tabLayout, int i) {
        Intrinsics.checkNotNullParameter(tabLayout, "$this$setV9TabUI");
        tabLayout.setTabMode(i);
        tabLayout.setSelectedTabIndicatorWidth(NumberExtendsKt.getDp((Number) 10));
        tabLayout.setTabIndicatorMarginBottom(NumberExtendsKt.getDp((Number) 5));
        tabLayout.setSelectTabIndicatorRadius(NumberExtendsKt.getDp((Number) 2));
        tabLayout.setSelectedTabIndicatorHeight(NumberExtendsKt.getDp((Number) 3));
        tabLayout.setTabTextSize((float) NumberExtendsKt.getSp((Number) 16));
        tabLayout.setTabSelectedTextSize((float) NumberExtendsKt.getSp((Number) 18));
        tabLayout.setTabSelectedTextStyle(1);
        tabLayout.setTabMinWidth(NumberExtendsKt.getDp((Number) 48));
        tabLayout.setScrollableTabMinWidth(NumberExtendsKt.getDp((Number) 48));
        tabLayout.setTabPaddingStart(i == 0 ? NumberExtendsKt.getDp((Number) 12) : 0);
        tabLayout.setTabPaddingEnd(i == 0 ? NumberExtendsKt.getDp((Number) 12) : 0);
        tabLayout.setTabBackgroundResId(0);
        if (i == 0) {
            tabLayout.setPadding(NumberExtendsKt.getDp((Number) 6), 0, NumberExtendsKt.getDp((Number) 6), 0);
            tabLayout.setClipToPadding(false);
            tabLayout.setClipChildren(false);
        }
        tabLayout.applyModeAndGravity();
    }

    public static final void setDefaultDoubleClickListener(TabLayout tabLayout, ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(tabLayout, "$this$setDefaultDoubleClickListener");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        ViewUtil.setChildViewDoubleClickListener(tabLayout.getChildAt(0), new ViewExtendsKt$setDefaultDoubleClickListener$1(viewPager));
    }

    public static final void setDefaultSubTabConfigListener(TabLayout tabLayout, Activity activity, ViewPager viewPager, ConfigPage[] configPageArr) {
        Intrinsics.checkNotNullParameter(tabLayout, "$this$setDefaultSubTabConfigListener");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(configPageArr, "tabApi");
        DataListViewPagerConverter.SubConfigPageTabListener subConfigPageTabListener = new DataListViewPagerConverter.SubConfigPageTabListener(activity, viewPager, configPageArr);
        tabLayout.addOnTabSelectedListener(subConfigPageTabListener);
        TabLayout.Tab tabAt = tabLayout.getTabAt(viewPager.getCurrentItem());
        if (tabAt != null) {
            Intrinsics.checkNotNullExpressionValue(tabAt, "this");
            subConfigPageTabListener.onTabSelected(tabAt);
        }
    }

    public static final void foreachChild(ViewGroup viewGroup, int i, Function1<? super View, Boolean> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$foreachChild");
        Intrinsics.checkNotNullParameter(function1, "action");
        if (i > 0) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                Intrinsics.checkNotNullExpressionValue(childAt, "child");
                if (!function1.invoke(childAt).booleanValue() && (childAt instanceof ViewGroup)) {
                    foreachChild((ViewGroup) childAt, i - 1, function1);
                }
            }
        }
    }

    public static final void insertText(EditText editText, String str) {
        Intrinsics.checkNotNullParameter(editText, "$this$insertText");
        Intrinsics.checkNotNullParameter(str, "inputText");
        if (editText.isFocused()) {
            if (editText.getSelectionStart() != editText.getSelectionEnd()) {
                insertBackKey(editText);
            }
            editText.getText().insert(editText.getSelectionStart(), str);
            return;
        }
        editText.append(str);
    }

    public static final void insertBackKey(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$this$insertBackKey");
        editText.dispatchKeyEvent(new KeyEvent(0, 0, 0, 67, 0, 0, 0, 0, 6));
    }

    public static final boolean checkShouldRequestLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$checkShouldRequestLayout");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.width < 0 || layoutParams.height < 0 || layoutParams.width != view.getWidth() || layoutParams.height != view.getHeight()) {
            return true;
        }
        return false;
    }

    public static final boolean isTrimTextEmpty(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$this$isTrimTextEmpty");
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Editable editable = text;
        int length = editable.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(editable.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        if (editable.subSequence(i, length + 1).length() == 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void showShakingAnimation$default(View view, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 300;
        }
        if ((i & 2) != 0) {
            j2 = 0;
        }
        showShakingAnimation(view, j, j2);
    }

    public static final void showShakingAnimation(View view, long j, long j2) {
        Intrinsics.checkNotNullParameter(view, "$this$showShakingAnimation");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 36.0f, -16.0f, 10.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.addUpdateListener(new ViewExtendsKt$showShakingAnimation$1(view));
        view.setTranslationY(36.0f);
        view.setAlpha(0.0f);
        ofFloat.start();
    }

    public static final void setScaleUpWhenTouch(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$setScaleUpWhenTouch");
        view.setOnTouchListener(ViewTouchAnimatorKt.getSCALE_TOUCH_ANIMATOR());
    }

    public static final void disableAccessibilityClick(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$disableAccessibilityClick");
        view.setAccessibilityDelegate(new ViewExtendsKt$disableAccessibilityClick$1());
    }

    public static final void applyText(TextView textView, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(textView, "$this$applyText");
        Intrinsics.checkNotNullParameter(function1, "action");
        SpannableStringBuilder text = textView.getText();
        if (!(text instanceof SpannableStringBuilder)) {
            text = new SpannableStringBuilder(text);
        }
        function1.invoke(text);
        textView.setText(text);
    }

    public static final void setMaxLineEllipsize(CoolEllipsizeTextView coolEllipsizeTextView, int i, String str) {
        Intrinsics.checkNotNullParameter(coolEllipsizeTextView, "$this$setMaxLineEllipsize");
        Intrinsics.checkNotNullParameter(str, "needConvertString");
        setMaxLineEllipsize$default(coolEllipsizeTextView, i, LinkTextUtils.convert(new Regex("[\\n\\r]").replace(str, " "), AppHolder.getAppTheme().getColorAccent(), null), null, false, 12, null);
    }

    public static final void updateMarginLayoutParams(View view, Function1<? super ViewGroup.MarginLayoutParams, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$updateMarginLayoutParams");
        Intrinsics.checkNotNullParameter(function1, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        function1.invoke(marginLayoutParams);
        view.setLayoutParams(marginLayoutParams);
    }
}
