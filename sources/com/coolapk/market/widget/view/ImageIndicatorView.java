package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.ResourceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0014J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010 \u001a\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"2\u0006\u0010#\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000bJ\u000e\u0010)\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000bJ \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/coolapk/market/widget/view/ImageIndicatorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "click", "Lcom/coolapk/market/widget/view/ImageIndicatorView$ClickItem;", "currentPosition", "", "pic", "", "", "selectedColor", "selectedIndex", "totalCount", "unselectedColor", "checkIndicatorCount", "", "createIndicatorView", "Landroid/widget/ImageView;", "index", "ensureIndicatorCount", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "selectIndicator", "setClick", "setList", "pics", "", "position", "setSelectedDrawableColor", "color", "setSelectedIndex", "setTotalIndicatorCount", "count", "setUnSelectedDrawableColor", "zoomImage", "Landroid/graphics/drawable/Drawable;", "drawable", "w", "h", "ClickItem", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageIndicatorView.kt */
public final class ImageIndicatorView extends LinearLayout {
    private ClickItem click;
    private int currentPosition = -1;
    private List<String> pic = new ArrayList();
    private int selectedColor = ResourceUtils.getColorInt(getContext(), 2131099896);
    private int selectedIndex = -1;
    private int totalCount = -1;
    private int unselectedColor = ResourceUtils.getColorInt(getContext(), 2131099898);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/view/ImageIndicatorView$ClickItem;", "", "onClick", "", "index", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageIndicatorView.kt */
    public interface ClickItem {
        void onClick(int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageIndicatorView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setTotalIndicatorCount(int i) {
        if (this.totalCount != i) {
            this.totalCount = i;
            requestLayout();
        }
    }

    public final void setClick(ClickItem clickItem) {
        Intrinsics.checkNotNullParameter(clickItem, "click");
        this.click = clickItem;
    }

    public final void setSelectedIndex(int i) {
        if (this.selectedIndex != i) {
            this.selectedIndex = i;
            requestLayout();
        }
    }

    public final void setSelectedDrawableColor(int i) {
        this.selectedColor = i;
    }

    public final void setUnSelectedDrawableColor(int i) {
        this.unselectedColor = i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        checkIndicatorCount();
        super.onMeasure(i, i2);
    }

    private final void checkIndicatorCount() {
        if (this.totalCount > 0 && this.selectedIndex >= 0) {
            ensureIndicatorCount();
            selectIndicator();
        } else if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    private final void ensureIndicatorCount() {
        ImageIndicatorView imageIndicatorView = this;
        int childCount = imageIndicatorView.getChildCount();
        int i = this.totalCount;
        int i2 = 0;
        if (i < childCount) {
            int i3 = childCount - i;
            for (int i4 = 0; i4 < i3; i4++) {
                imageIndicatorView.removeViewAt(0);
            }
        } else if (i > childCount) {
            int i5 = i - childCount;
            int i6 = 0;
            while (i2 < i5) {
                addView(createIndicatorView(i6));
                i2++;
                i6++;
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final ImageView createIndicatorView(int i) {
        NiceImageView niceImageView = new NiceImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(NumberExtendsKt.getDp((Number) 30), NumberExtendsKt.getDp((Number) 30));
        layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 4);
        layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 4);
        layoutParams.topMargin = NumberExtendsKt.getDp((Number) 4);
        layoutParams.bottomMargin = NumberExtendsKt.getDp((Number) 4);
        Unit unit = Unit.INSTANCE;
        niceImageView.setLayoutParams(layoutParams);
        niceImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        niceImageView.isCircle(false);
        niceImageView.setCornerRadius(6);
        niceImageView.isCoverSrc(true);
        niceImageView.setBorderWidth(1);
        niceImageView.setBorderColor(Color.parseColor("#99FFFFFF"));
        Object tag = niceImageView.getTag(2131363510);
        if (tag != null) {
            int i2 = this.currentPosition;
            if (!(tag instanceof Integer) || i2 != ((Integer) tag).intValue()) {
                NiceImageView niceImageView2 = niceImageView;
                GlideApp.with(niceImageView2).clear(niceImageView2);
            }
        }
        NiceImageView niceImageView3 = niceImageView;
        GlideApp.with(getContext()).load(this.pic.get(i)).centerCrop().placeholder(2131231884).diskCacheStrategy(DiskCacheStrategy.DATA).into(niceImageView3);
        niceImageView.setTag(2131363510, Integer.valueOf(this.currentPosition));
        niceImageView.setOnClickListener(new ImageIndicatorView$createIndicatorView$2(this, i));
        return niceImageView3;
    }

    private final Drawable zoomImage(Drawable drawable, int i, int i2) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(BitmapUtil.drawableToBitmap(drawable), i, i2, true));
    }

    private final void selectIndicator() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.coolapk.market.widget.view.NiceImageView");
            NiceImageView niceImageView = (NiceImageView) childAt;
            if (i == this.selectedIndex) {
                niceImageView.animate().setListener(new ImageIndicatorView$selectIndicator$1$1(niceImageView)).scaleX(1.2f).scaleY(1.2f).setDuration(200).start();
            } else {
                niceImageView.animate().setListener(new ImageIndicatorView$selectIndicator$1$2(niceImageView)).scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            }
        }
    }

    public final void setList(List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "pics");
        if (!TypeIntrinsics.isMutableList(list)) {
            list = null;
        }
        Intrinsics.checkNotNull(list);
        this.pic = list;
        if (this.currentPosition != i) {
            this.currentPosition = i;
            requestLayout();
        }
    }
}
