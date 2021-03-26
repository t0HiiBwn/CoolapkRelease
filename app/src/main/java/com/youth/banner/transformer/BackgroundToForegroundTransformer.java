package com.youth.banner.transformer;

import android.view.View;

public class BackgroundToForegroundTransformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f) {
        float height = (float) view.getHeight();
        float width = (float) view.getWidth();
        float f2 = 1.0f;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i >= 0) {
            f2 = Math.abs(1.0f - f);
        }
        float min = min(f2, 0.5f);
        view.setScaleX(min);
        view.setScaleY(min);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationX(i < 0 ? width * f : (-width) * f * 0.25f);
    }
}
