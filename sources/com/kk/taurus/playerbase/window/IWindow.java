package com.kk.taurus.playerbase.window;

import android.animation.Animator;

public interface IWindow {
    public static final int DURATION_ANIMATION = 200;
    public static final int MIN_MOVE_DISTANCE = 20;

    public interface OnWindowListener {
        void onClose();

        void onShow();
    }

    void close();

    void close(Animator... animatorArr);

    boolean isWindowShow();

    void setDragEnable(boolean z);

    void setOnWindowListener(OnWindowListener onWindowListener);

    boolean show();

    boolean show(Animator... animatorArr);

    void updateWindowViewLayout(int i, int i2);
}
