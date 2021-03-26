package com.coolapk.market.widget;

import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

public class FixArrowKeyMovementMethod extends ArrowKeyMovementMethod {
    private static FixArrowKeyMovementMethod sInstance;

    public static FixArrowKeyMovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new FixArrowKeyMovementMethod();
        }
        return sInstance;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        FixTouchLinkMovementMethod.getInstance().onTouchEvent(textView, spannable, motionEvent);
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
