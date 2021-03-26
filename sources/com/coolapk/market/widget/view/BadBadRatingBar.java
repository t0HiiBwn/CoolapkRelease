package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatRatingBar;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.ResourceUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\bJ\u001a\u0010\u0013\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\rH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/widget/view/BadBadRatingBar;", "Landroidx/appcompat/widget/AppCompatRatingBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "sampleSize", "", "createRatingBarProgressDrawable", "Landroid/graphics/drawable/Drawable;", "size", "hasOutline", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setHeartShapeProgressBar", "setProgressBar", "tileify", "drawable", "clip", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BadBadRatingBar.kt */
public final class BadBadRatingBar extends AppCompatRatingBar {
    private int sampleSize = 66;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadBadRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInEditMode()) {
            setProgressBar(66, true);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatRatingBar, android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.sampleSize;
        if (i3 > 0) {
            setMeasuredDimension(View.resolveSizeAndState(i3 * getNumStars(), i, 0), this.sampleSize);
        }
    }

    public static /* synthetic */ void setProgressBar$default(BadBadRatingBar badBadRatingBar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        badBadRatingBar.setProgressBar(i, z);
    }

    public final void setProgressBar(int i, boolean z) {
        this.sampleSize = i;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setProgressDrawable(tileify(createRatingBarProgressDrawable(context, i, z), false));
        requestLayout();
    }

    public final void setHeartShapeProgressBar(int i) {
        this.sampleSize = i;
        Drawable drawable = ResourceUtils.getDrawable(getContext(), 2131231343);
        drawable.setBounds(0, 0, i, i);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapUtil.drawableToBitmap(drawable));
        LayerDrawable layerDrawable = new LayerDrawable(new BitmapDrawable[]{bitmapDrawable, bitmapDrawable, bitmapDrawable});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        setProgressDrawable(tileify(layerDrawable, false));
        requestLayout();
    }

    static /* synthetic */ Drawable createRatingBarProgressDrawable$default(BadBadRatingBar badBadRatingBar, Context context, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return badBadRatingBar.createRatingBarProgressDrawable(context, i, z);
    }

    private final Drawable createRatingBarProgressDrawable(Context context, int i, boolean z) {
        LayerDrawable layerDrawable;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), 2131231567), i, i, true));
        if (z) {
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), 2131231573), i, i, true));
            layerDrawable = new LayerDrawable(new BitmapDrawable[]{bitmapDrawable2, bitmapDrawable2, bitmapDrawable});
        } else {
            layerDrawable = new LayerDrawable(new BitmapDrawable[]{bitmapDrawable, bitmapDrawable, bitmapDrawable});
        }
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        return layerDrawable;
    }

    private final Drawable tileify(Drawable drawable, boolean z) {
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                Drawable drawable2 = layerDrawable.getDrawable(i);
                Intrinsics.checkNotNullExpressionValue(drawable2, "orig.getDrawable(i)");
                drawableArr[i] = tileify(drawable2, id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            Drawable.ConstantState constantState = drawable.getConstantState();
            Intrinsics.checkNotNull(constantState);
            Drawable newDrawable = constantState.newDrawable(getResources());
            Objects.requireNonNull(newDrawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            BitmapDrawable bitmapDrawable = (BitmapDrawable) newDrawable;
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            if (z) {
                return new ClipDrawable(bitmapDrawable, 3, 1);
            }
            return bitmapDrawable;
        }
    }
}
