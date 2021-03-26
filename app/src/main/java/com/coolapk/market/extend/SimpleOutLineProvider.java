package com.coolapk.market.extend;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/extend/SimpleOutLineProvider;", "Landroid/view/ViewOutlineProvider;", "newShape", "", "newRadius", "", "(IF)V", "getNewRadius", "()F", "setNewRadius", "(F)V", "getNewShape", "()I", "setNewShape", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class SimpleOutLineProvider extends ViewOutlineProvider {
    private float newRadius;
    private int newShape;

    public SimpleOutLineProvider() {
        this(0, 0.0f, 3, null);
    }

    public SimpleOutLineProvider(int i, float f) {
        this.newShape = i;
        this.newRadius = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleOutLineProvider(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f);
    }

    public final float getNewRadius() {
        return this.newRadius;
    }

    public final int getNewShape() {
        return this.newShape;
    }

    public final void setNewRadius(float f) {
        this.newRadius = f;
    }

    public final void setNewShape(int i) {
        this.newShape = i;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        int i = this.newShape;
        if (i == 0) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.newRadius);
        } else if (i == 1) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        } else if (i == 2) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ((float) Math.min(view.getWidth(), view.getHeight())) / 2.0f);
        }
    }
}
