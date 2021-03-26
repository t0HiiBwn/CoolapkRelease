package com.coolapk.market.widget;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import com.coolapk.market.AppHolder;

public class FixTouchLinkMovementMethod extends LinkMovementMethod {
    private static FixTouchLinkMovementMethod sInstance;
    private GestureDetector gestureDetector = new GestureDetector(AppHolder.getApplication(), this.gestureListener);
    private SimpleOnGestureListener gestureListener = new SimpleOnGestureListener();

    public static FixTouchLinkMovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new FixTouchLinkMovementMethod();
        }
        return sInstance;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (this.gestureDetector.onTouchEvent(motionEvent)) {
            int action = motionEvent.getAction();
            if (action == 1) {
                ClickableSpan findClickableSpan = findClickableSpan(textView, spannable, motionEvent);
                if (findClickableSpan != null) {
                    findClickableSpan.onClick(textView);
                    return true;
                }
                Selection.removeSelection(spannable);
                Touch.onTouchEvent(textView, spannable, motionEvent);
                return false;
            } else if (action == 0) {
                ClickableSpan findClickableSpan2 = findClickableSpan(textView, spannable, motionEvent);
                if (findClickableSpan2 != null) {
                    Selection.setSelection(spannable, spannable.getSpanStart(findClickableSpan2), spannable.getSpanEnd(findClickableSpan2));
                    return true;
                }
                Selection.removeSelection(spannable);
                Touch.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
        }
        return Touch.onTouchEvent(textView, spannable, motionEvent);
    }

    private ClickableSpan findClickableSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(y + textView.getScrollY());
        float f = (float) scrollX;
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
        if (layout.getPrimaryHorizontal(layout.getLineEnd(lineForVertical) - 1) < f) {
            return null;
        }
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpanArr.length != 0) {
            return clickableSpanArr[0];
        }
        return null;
    }

    private static class SimpleOnGestureListener implements GestureDetector.OnGestureListener {
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }

        private SimpleOnGestureListener() {
        }
    }
}
