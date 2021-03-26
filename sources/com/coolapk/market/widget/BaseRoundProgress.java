package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.coolapk.market.R;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DisplayUtils;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseRoundProgress.kt */
public abstract class BaseRoundProgress extends LinearLayout {
    public static final Companion Companion = new Companion(null);
    protected static final int DEFAULT_BACKGROUND_PADDING = 0;
    protected static final int DEFAULT_MAX_PROGRESS = 100;
    protected static final int DEFAULT_PROGRESS = 0;
    protected static final int DEFAULT_PROGRESS_RADIUS = 30;
    protected static final int DEFAULT_SECONDARY_PROGRESS = 0;
    private int colorBackground;
    private int colorProgress;
    private int colorSecondaryProgress;
    private boolean isReverse;
    private LinearLayout layoutBackground;
    private LinearLayout layoutProgress;
    private LinearLayout layoutSecondaryProgress;
    private float max;
    private int padding;
    private float progress;
    private OnProgressChangedListener progressChangedListener;
    private int radius;
    private float secondaryProgress;
    private int totalWidth;

    /* compiled from: BaseRoundProgress.kt */
    public interface OnProgressChangedListener {
        void onProgressChanged(int i, float f, boolean z, boolean z2);
    }

    protected abstract void drawProgress(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z);

    protected abstract int initLayout();

    protected abstract void initStyleable(Context context, AttributeSet attributeSet);

    protected abstract void initView();

    protected abstract void onViewDraw();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRoundProgress(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setup(context, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRoundProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setup(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRoundProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setup(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRoundProgress(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        setup(context, attributeSet);
    }

    public final void setup(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        setupStyleable(context, attributeSet);
        removeAllViews();
        LayoutInflater.from(context).inflate(initLayout(), this);
        this.layoutBackground = (LinearLayout) findViewById(2131362833);
        this.layoutProgress = (LinearLayout) findViewById(2131362836);
        this.layoutSecondaryProgress = (LinearLayout) findViewById(2131362840);
        initView();
    }

    private final void setupStyleable(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseRoundProgress);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…leable.BaseRoundProgress)");
        this.radius = (int) obtainStyledAttributes.getDimension(5, 5.0f);
        float f = (float) 0;
        this.padding = (int) obtainStyledAttributes.getDimension(1, DisplayUtils.dp2pxf(context, f));
        this.isReverse = obtainStyledAttributes.getBoolean(6, false);
        this.max = obtainStyledAttributes.getFloat(2, (float) 100);
        this.progress = obtainStyledAttributes.getFloat(3, f);
        this.secondaryProgress = obtainStyledAttributes.getFloat(7, f);
        this.colorBackground = obtainStyledAttributes.getColor(0, ColorUtils.adjustAlpha(-1, 0.5f));
        this.colorProgress = obtainStyledAttributes.getColor(4, -1);
        this.colorSecondaryProgress = obtainStyledAttributes.getColor(8, -1);
        obtainStyledAttributes.recycle();
        initStyleable(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.totalWidth = i;
        drawAll();
        postDelayed(new BaseRoundProgress$onSizeChanged$1(this), 5);
    }

    protected final void drawAll() {
        drawBackgroundProgress();
        drawPadding();
        drawProgressReverse();
        drawPrimaryProgress();
        drawSecondaryProgress();
        onViewDraw();
    }

    private final void drawBackgroundProgress() {
        GradientDrawable createGradientDrawable = createGradientDrawable(this.colorBackground);
        float f = (float) (this.radius - (this.padding / 2));
        createGradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        LinearLayout linearLayout = this.layoutBackground;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setBackground(createGradientDrawable);
    }

    protected final GradientDrawable createGradientDrawable(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public final void drawPrimaryProgress() {
        drawProgress(this.layoutProgress, this.max, this.progress, (float) this.totalWidth, this.radius, this.padding, this.colorProgress, this.isReverse);
    }

    public final void drawSecondaryProgress() {
        drawProgress(this.layoutSecondaryProgress, this.max, this.secondaryProgress, (float) this.totalWidth, this.radius, this.padding, this.colorSecondaryProgress, this.isReverse);
    }

    private final void drawProgressReverse() {
        setupReverse(this.layoutProgress);
        setupReverse(this.layoutSecondaryProgress);
    }

    private final void setupReverse(LinearLayout linearLayout) {
        Intrinsics.checkNotNull(linearLayout);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        removeLayoutParamsRule(layoutParams2);
        if (this.isReverse) {
            layoutParams2.addRule(11);
            layoutParams2.addRule(21);
        } else {
            layoutParams2.addRule(9);
            layoutParams2.addRule(20);
        }
        linearLayout.setLayoutParams(layoutParams2);
    }

    private final void drawPadding() {
        LinearLayout linearLayout = this.layoutBackground;
        Intrinsics.checkNotNull(linearLayout);
        int i = this.padding;
        linearLayout.setPadding(i, i, i, i);
    }

    private final void removeLayoutParamsRule(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.removeRule(11);
        layoutParams.removeRule(21);
        layoutParams.removeRule(9);
        layoutParams.removeRule(20);
    }

    public final boolean getReverse() {
        return this.isReverse;
    }

    public final void setReverse(boolean z) {
        this.isReverse = z;
        drawProgressReverse();
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public final int getRadius() {
        return this.radius;
    }

    public final void setRadius(int i) {
        if (i >= 0) {
            this.radius = i;
        }
        drawBackgroundProgress();
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public final int getPadding() {
        return this.padding;
    }

    public final void setPadding(int i) {
        if (i >= 0) {
            this.padding = i;
        }
        drawPadding();
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public final float getMax() {
        return this.max;
    }

    public final void setMax(float f) {
        if (f >= ((float) 0)) {
            this.max = f;
        }
        if (this.progress > f) {
            this.progress = f;
        }
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public final float getLayoutWidth() {
        return (float) this.totalWidth;
    }

    public final float getProgress() {
        return this.progress;
    }

    public void setProgress(float f) {
        if (f < ((float) 0)) {
            this.progress = 0.0f;
        } else {
            this.progress = Math.min(f, this.max);
        }
        drawPrimaryProgress();
        OnProgressChangedListener onProgressChangedListener = this.progressChangedListener;
        if (onProgressChangedListener != null) {
            Intrinsics.checkNotNull(onProgressChangedListener);
            onProgressChangedListener.onProgressChanged(getId(), this.progress, true, false);
        }
    }

    public final float getSecondaryProgressWidth() {
        LinearLayout linearLayout = this.layoutSecondaryProgress;
        if (linearLayout == null) {
            return 0.0f;
        }
        Intrinsics.checkNotNull(linearLayout);
        return (float) linearLayout.getWidth();
    }

    public final float getSecondaryProgress() {
        return this.secondaryProgress;
    }

    public final void setSecondaryProgress(float f) {
        if (f < ((float) 0)) {
            this.secondaryProgress = 0.0f;
        } else {
            float f2 = this.max;
            if (f > f2) {
                this.secondaryProgress = f2;
            } else {
                this.secondaryProgress = f;
            }
        }
        drawSecondaryProgress();
        OnProgressChangedListener onProgressChangedListener = this.progressChangedListener;
        if (onProgressChangedListener != null) {
            Intrinsics.checkNotNull(onProgressChangedListener);
            onProgressChangedListener.onProgressChanged(getId(), this.secondaryProgress, false, true);
        }
    }

    public final int getProgressBackgroundColor() {
        return this.colorBackground;
    }

    public final void setProgressBackgroundColor(int i) {
        this.colorBackground = i;
        drawBackgroundProgress();
    }

    public final int getProgressColor() {
        return this.colorProgress;
    }

    public final void setProgressColor(int i) {
        this.colorProgress = i;
        drawPrimaryProgress();
    }

    public final int getSecondaryProgressColor() {
        return this.colorSecondaryProgress;
    }

    public final void setSecondaryProgressColor(int i) {
        this.colorSecondaryProgress = i;
        drawSecondaryProgress();
    }

    public final void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.progressChangedListener = onProgressChangedListener;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        drawAll();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setRadius(this.radius);
        savedState.setPadding(this.padding);
        savedState.setColorBackground(this.colorBackground);
        savedState.setColorProgress(this.colorProgress);
        savedState.setColorSecondaryProgress(this.colorSecondaryProgress);
        savedState.setMax(this.max);
        savedState.setProgress(this.progress);
        savedState.setSecondaryProgress(this.secondaryProgress);
        savedState.setReverse(this.isReverse);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.radius = savedState.getRadius();
        this.padding = savedState.getPadding();
        this.colorBackground = savedState.getColorBackground();
        this.colorProgress = savedState.getColorProgress();
        this.colorSecondaryProgress = savedState.getColorSecondaryProgress();
        this.max = savedState.getMax();
        this.progress = savedState.getProgress();
        this.secondaryProgress = savedState.getSecondaryProgress();
        this.isReverse = savedState.isReverse();
    }

    /* compiled from: BaseRoundProgress.kt */
    private static final class SavedState extends View.BaseSavedState {
        private static final Parcelable.Creator<SavedState> CREATOR = new BaseRoundProgress$SavedState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion(null);
        private int colorBackground;
        private int colorProgress;
        private int colorSecondaryProgress;
        private boolean isReverse;
        private float max;
        private int padding;
        private float progress;
        private int radius;
        private float secondaryProgress;

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public final float getMax() {
            return this.max;
        }

        public final void setMax(float f) {
            this.max = f;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final void setProgress(float f) {
            this.progress = f;
        }

        public final float getSecondaryProgress() {
            return this.secondaryProgress;
        }

        public final void setSecondaryProgress(float f) {
            this.secondaryProgress = f;
        }

        public final int getRadius() {
            return this.radius;
        }

        public final void setRadius(int i) {
            this.radius = i;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final void setPadding(int i) {
            this.padding = i;
        }

        public final int getColorBackground() {
            return this.colorBackground;
        }

        public final void setColorBackground(int i) {
            this.colorBackground = i;
        }

        public final int getColorProgress() {
            return this.colorProgress;
        }

        public final void setColorProgress(int i) {
            this.colorProgress = i;
        }

        public final int getColorSecondaryProgress() {
            return this.colorSecondaryProgress;
        }

        public final void setColorSecondaryProgress(int i) {
            this.colorSecondaryProgress = i;
        }

        public final boolean isReverse() {
            return this.isReverse;
        }

        public final void setReverse(boolean z) {
            this.isReverse = z;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.max = parcel.readFloat();
            this.progress = parcel.readFloat();
            this.secondaryProgress = parcel.readFloat();
            this.radius = parcel.readInt();
            this.padding = parcel.readInt();
            this.colorBackground = parcel.readInt();
            this.colorProgress = parcel.readInt();
            this.colorSecondaryProgress = parcel.readInt();
            this.isReverse = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.max);
            parcel.writeFloat(this.progress);
            parcel.writeFloat(this.secondaryProgress);
            parcel.writeInt(this.radius);
            parcel.writeInt(this.padding);
            parcel.writeInt(this.colorBackground);
            parcel.writeInt(this.colorProgress);
            parcel.writeInt(this.colorSecondaryProgress);
            parcel.writeByte(this.isReverse ? (byte) 1 : 0);
        }

        /* compiled from: BaseRoundProgress.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Parcelable.Creator<SavedState> getCREATOR() {
                return SavedState.CREATOR;
            }
        }
    }

    /* compiled from: BaseRoundProgress.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
