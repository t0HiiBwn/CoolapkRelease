package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate {
    Context context;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    abstract void initialize();

    boolean isBoxBackgroundModeSupported(int i) {
        return true;
    }

    void onSuffixVisibilityChanged(boolean z) {
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    EndIconDelegate(TextInputLayout textInputLayout2) {
        this.textInputLayout = textInputLayout2;
        this.context = textInputLayout2.getContext();
        this.endIconView = textInputLayout2.getEndIconView();
    }
}
