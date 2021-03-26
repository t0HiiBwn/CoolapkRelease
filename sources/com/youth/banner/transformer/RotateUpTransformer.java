package com.youth.banner.transformer;

import android.view.View;

public class RotateUpTransformer extends ABaseTransformer {
    private static final float ROT_MOD = -15.0f;

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected boolean isPagingEnabled() {
        return true;
    }

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f) {
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(f * -15.0f);
    }
}
