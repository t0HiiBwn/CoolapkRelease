package com.coolapk.market.widget;

import android.util.DisplayMetrics;
import android.view.View;

public abstract class OnKeyBoardEventAdapter implements View.OnLayoutChangeListener, KeyBoardListener {
    private static final float ASSUME_KEYBOARD_MAX_SIZE_DP = 0.7f;
    private static final float ASSUME_KEYBOARD_MIN_SIZE_DP = 0.2f;

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i3 == i7 && i2 == i6) {
            int abs = Math.abs(i4 - i8);
            DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
            float f = (float) abs;
            if (f > ((float) displayMetrics.heightPixels) * 0.2f && f < ((float) displayMetrics.heightPixels) * 0.7f) {
                if (i8 > i4) {
                    onKeyBoardShow(abs);
                } else {
                    onKeyBoardHide();
                }
            }
        }
    }
}
