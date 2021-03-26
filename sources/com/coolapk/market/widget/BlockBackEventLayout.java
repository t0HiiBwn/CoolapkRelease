package com.coolapk.market.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

public class BlockBackEventLayout extends RelativeLayout {
    public BlockBackEventLayout(Context context) {
        super(context);
    }

    public BlockBackEventLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlockBackEventLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        if (keyEvent.getKeyCode() == 4 && (keyDispatcherState = getKeyDispatcherState()) != null) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && keyDispatcherState.isTracking(keyEvent)) {
                ((Activity) getContext()).onBackPressed();
                return true;
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
