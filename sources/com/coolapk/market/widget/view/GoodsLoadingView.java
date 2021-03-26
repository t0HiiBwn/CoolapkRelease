package com.coolapk.market.widget.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoodsLoadingView.kt */
public final class GoodsLoadingView extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    public static final long DURATION_PER_LOOP = 1300;
    private AnimatorSet animatorSet;
    private final List<DotData> dotDataList;
    private final List<AppCompatImageView> dotViews;
    private boolean isVisibilityAggregated;
    private final int marginButton;
    private final AppCompatImageView squareView;
    private final int squareWidth;
    private final Runnable startAnimationRunnable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        List<DotData> mutableListOf = CollectionsKt.mutableListOf(new DotData(NumberExtendsKt.getDp((Number) 24), 2131231567, -NumberExtendsKt.getDp((Number) 60), -NumberExtendsKt.getDp((Number) 20)), new DotData(NumberExtendsKt.getDp((Number) 24), 2131231605, -NumberExtendsKt.getDp((Number) 30), -NumberExtendsKt.getDp((Number) 40)), new DotData(NumberExtendsKt.getDp((Number) 24), 2131231483, NumberExtendsKt.getDp((Number) 0), -NumberExtendsKt.getDp((Number) 60)), new DotData(NumberExtendsKt.getDp((Number) 24), 2131231236, NumberExtendsKt.getDp((Number) 30), -NumberExtendsKt.getDp((Number) 40)), new DotData(NumberExtendsKt.getDp((Number) 24), 2131231177, NumberExtendsKt.getDp((Number) 60), -NumberExtendsKt.getDp((Number) 20)));
        this.dotDataList = mutableListOf;
        List<DotData> list = mutableListOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(createDotView(it2.next()));
        }
        ArrayList<AppCompatImageView> arrayList2 = arrayList;
        this.dotViews = arrayList2;
        this.startAnimationRunnable = new GoodsLoadingView$startAnimationRunnable$1(this);
        this.squareWidth = NumberExtendsKt.getDp((Number) 40);
        this.marginButton = NumberExtendsKt.getDp((Number) 20);
        this.squareView = createDotView(new DotData(NumberExtendsKt.getDp((Number) 40), 2131231168, 0, 0));
        for (AppCompatImageView appCompatImageView : arrayList2) {
            addView(appCompatImageView);
        }
        addView(this.squareView);
    }

    /* compiled from: GoodsLoadingView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GoodsLoadingView.kt */
    public static final class DotData {
        private final int drawable;
        private final int offsetX;
        private final int offsetY;
        private final int size;

        public static /* synthetic */ DotData copy$default(DotData dotData, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = dotData.size;
            }
            if ((i5 & 2) != 0) {
                i2 = dotData.drawable;
            }
            if ((i5 & 4) != 0) {
                i3 = dotData.offsetX;
            }
            if ((i5 & 8) != 0) {
                i4 = dotData.offsetY;
            }
            return dotData.copy(i, i2, i3, i4);
        }

        public final int component1() {
            return this.size;
        }

        public final int component2() {
            return this.drawable;
        }

        public final int component3() {
            return this.offsetX;
        }

        public final int component4() {
            return this.offsetY;
        }

        public final DotData copy(int i, int i2, int i3, int i4) {
            return new DotData(i, i2, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DotData)) {
                return false;
            }
            DotData dotData = (DotData) obj;
            return this.size == dotData.size && this.drawable == dotData.drawable && this.offsetX == dotData.offsetX && this.offsetY == dotData.offsetY;
        }

        public int hashCode() {
            return (((((this.size * 31) + this.drawable) * 31) + this.offsetX) * 31) + this.offsetY;
        }

        public String toString() {
            return "DotData(size=" + this.size + ", drawable=" + this.drawable + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ")";
        }

        public DotData(int i, int i2, int i3, int i4) {
            this.size = i;
            this.drawable = i2;
            this.offsetX = i3;
            this.offsetY = i4;
        }

        public final int getDrawable() {
            return this.drawable;
        }

        public final int getOffsetX() {
            return this.offsetX;
        }

        public final int getOffsetY() {
            return this.offsetY;
        }

        public final int getSize() {
            return this.size;
        }
    }

    private final AppCompatImageView createDotView(DotData dotData) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams(dotData.getSize(), dotData.getSize()));
        appCompatImageView.setImageResource(dotData.getDrawable());
        appCompatImageView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return appCompatImageView;
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i3 + i) / 2) - i;
        int i6 = ((i4 - this.marginButton) - (this.squareWidth / 2)) - i2;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            Intrinsics.checkNotNullExpressionValue(childAt, "child");
            childAt.layout(i5 - (childAt.getMeasuredWidth() / 2), i6 - (childAt.getMeasuredHeight() / 2), (childAt.getMeasuredWidth() / 2) + i5, (childAt.getMeasuredHeight() / 2) + i6);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        this.isVisibilityAggregated = z;
        if (z) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    private final void stopAnimation() {
        removeCallbacks(this.startAnimationRunnable);
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    public final void startAnimation() {
        removeCallbacks(this.startAnimationRunnable);
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        int i = 0;
        for (T t : this.dotViews) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            DotData dotData = this.dotDataList.get(i);
            t2.setTranslationX((float) dotData.getOffsetX());
            t2.setTranslationY((float) dotData.getOffsetY());
            t2.setScaleX(1.0f);
            t2.setScaleY(1.0f);
            t2.setAlpha(0.0f);
            i = i2;
        }
        List<AppCompatImageView> list = this.dotViews;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(ObjectAnimator.ofFloat(it2.next(), View.ALPHA, 0.0f, 1.0f).setDuration(400L));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        for (T t3 : this.dotViews) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(t3, View.ALPHA, 1.0f, 0.0f).setDuration(200L);
            duration.setStartDelay(400);
            Unit unit = Unit.INSTANCE;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(t3, View.SCALE_X, 1.0f, 0.5f).setDuration(200L);
            duration2.setStartDelay(400);
            Unit unit2 = Unit.INSTANCE;
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(t3, View.SCALE_Y, 1.0f, 0.5f).setDuration(200L);
            duration3.setStartDelay(400);
            Unit unit3 = Unit.INSTANCE;
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(t3, View.TRANSLATION_X, t3.getTranslationX(), 0.0f).setDuration(200L);
            duration4.setStartDelay(400);
            Unit unit4 = Unit.INSTANCE;
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(t3, View.TRANSLATION_Y, t3.getTranslationY(), 0.0f).setDuration(200L);
            duration5.setStartDelay(400);
            Unit unit5 = Unit.INSTANCE;
            CollectionsKt.addAll(mutableList, CollectionsKt.mutableListOf(duration, duration2, duration3, duration4, duration5));
        }
        List list2 = mutableList;
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(this.squareView, View.ROTATION, 0.0f, -10.0f).setDuration(200L);
        duration6.setStartDelay(600);
        Unit unit6 = Unit.INSTANCE;
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(this.squareView, View.ROTATION, -10.0f, 10.0f).setDuration(200L);
        duration7.setStartDelay(800);
        Unit unit7 = Unit.INSTANCE;
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(this.squareView, View.ROTATION, 10.0f, 0.0f).setDuration(200L);
        duration8.setStartDelay(600 + (200 * ((long) 2)));
        Unit unit8 = Unit.INSTANCE;
        mutableList.addAll(CollectionsKt.mutableListOf(duration6, duration7, duration8));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.animatorSet = animatorSet3;
        Intrinsics.checkNotNull(animatorSet3);
        animatorSet3.playTogether(list2);
        AnimatorSet animatorSet4 = this.animatorSet;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
        AnimatorSet animatorSet5 = this.animatorSet;
        if (animatorSet5 != null) {
            ExtraExtendsKt.addListeners$default(animatorSet5, null, new GoodsLoadingView$startAnimation$6(this, 500), 1, null);
        }
    }

    public final void delayStartAnimation(long j) {
        removeCallbacks(this.startAnimationRunnable);
        postDelayed(this.startAnimationRunnable, j);
    }
}
