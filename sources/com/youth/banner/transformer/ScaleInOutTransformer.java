package com.youth.banner.transformer;

import android.view.View;

public class ScaleInOutTransformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f) {
        float f2 = 0.0f;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i >= 0) {
            f2 = (float) view.getWidth();
        }
        view.setPivotX(f2);
        view.setPivotY(((float) view.getHeight()) / 2.0f);
        float f3 = i < 0 ? f + 1.0f : 1.0f - f;
        view.setScaleX(f3);
        view.setScaleY(f3);
    }
}
