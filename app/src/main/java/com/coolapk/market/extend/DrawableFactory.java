package com.coolapk.market.extend;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.TextDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/extend/DrawableFactory;", "", "()V", "createAuthorIndicator", "Landroid/graphics/drawable/LayerDrawable;", "createFixTopIndicator", "createMallIndicator", "text", "", "height", "", "textColor", "bgColor", "radius", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DrawableExtends.kt */
public final class DrawableFactory {
    public static final DrawableFactory INSTANCE = new DrawableFactory();

    private DrawableFactory() {
    }

    public final LayerDrawable createAuthorIndicator() {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new TextDrawable("楼主")});
        layerDrawable.setLayerInset(0, NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0));
        layerDrawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 14));
        layerDrawable.setTint(AppHolder.getAppTheme().getColorAccent());
        return layerDrawable;
    }

    public final LayerDrawable createFixTopIndicator() {
        TextDrawable textDrawable = new TextDrawable("置顶");
        textDrawable.setBackgroundStyle(1);
        textDrawable.setTextColor(-1);
        textDrawable.setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
        Unit unit = Unit.INSTANCE;
        LayerDrawable layerDrawable = new LayerDrawable(new TextDrawable[]{textDrawable});
        layerDrawable.setLayerInset(0, NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0));
        layerDrawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 14));
        return layerDrawable;
    }

    public final LayerDrawable createMallIndicator(String str, int i, int i2, int i3, float f) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextDrawable textDrawable = new TextDrawable(str);
        textDrawable.setBackgroundStyle(1);
        textDrawable.setBackgroundColor(i3);
        textDrawable.setTextColor(i2);
        textDrawable.setTextSize((((float) i) / 5.0f) * 3.0f);
        Float valueOf = Float.valueOf(4.5f);
        textDrawable.setPadding(NumberExtendsKt.getDp(valueOf), 0, NumberExtendsKt.getDp(valueOf), 0);
        textDrawable.setRadius(f);
        Unit unit = Unit.INSTANCE;
        LayerDrawable layerDrawable = new LayerDrawable(new TextDrawable[]{textDrawable});
        layerDrawable.setLayerInset(0, NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0), NumberExtendsKt.getDp((Number) 0));
        Drawable drawable = layerDrawable.getDrawable(0);
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable.getDrawable(0)");
        layerDrawable.setBounds(0, 0, drawable.getIntrinsicWidth(), i);
        layerDrawable.setTint(AppHolder.getAppTheme().getColorAccent());
        return layerDrawable;
    }
}
