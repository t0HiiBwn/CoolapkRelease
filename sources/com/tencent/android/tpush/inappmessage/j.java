package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;

/* compiled from: ProGuard */
public class j {
    public static int a(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024 ? 16973841 : 16973840;
    }

    public static void a(View view, int i, boolean z) {
        i.a(view.getContext());
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(a(z ? i.d : 0));
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.setBackground(view, shapeDrawable);
    }

    public static Shape a(int i) {
        float f = (float) i;
        return new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null);
    }

    public static Animation a(long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(j);
        return alphaAnimation;
    }
}
