package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.RomUtils;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import com.sdsmdg.harjot.vectormaster.models.PathModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"createSvgIconCompat", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "drawableRes", "", "color", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: PostButtonView2.kt */
public final class PostButtonView2Kt {
    public static final Drawable createSvgIconCompat(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "$this$createSvgIconCompat");
        if (AppHolder.getAppTheme().isNightTheme() && RomUtils.isMiui()) {
            VectorMasterDrawable vectorMasterDrawable = new VectorMasterDrawable(context, i);
            PathModel pathModelByName = vectorMasterDrawable.getPathModelByName("background");
            Intrinsics.checkNotNullExpressionValue(pathModelByName, "outline");
            pathModelByName.setFillColor(i2);
            return vectorMasterDrawable;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        Intrinsics.checkNotNull(drawable);
        DrawableCompat.setTint(drawable, i2);
        return drawable;
    }
}
