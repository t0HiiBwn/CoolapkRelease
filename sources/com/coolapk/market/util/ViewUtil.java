package com.coolapk.market.util;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class ViewUtil {
    private static final long CLICK_EVENT_INTERVAL = 250;
    private static long LAST_CLICK_TIME;

    public interface OnDoubleClickListener {
        boolean onDoubleClick(View view);
    }

    public interface OnDoubleClickListener2 extends OnDoubleClickListener {
        @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
        boolean onDoubleClick(View view);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);
    }

    public static void clickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            if (onClickListener == null) {
                view.setOnClickListener(null);
            } else {
                view.setOnClickListener(new View.OnClickListener(onClickListener) {
                    /* class com.coolapk.market.util.$$Lambda$ViewUtil$WxmV6_fPpl5hzSXQLrIhO2Uelc */
                    public final /* synthetic */ View.OnClickListener f$0;

                    {
                        this.f$0 = r1;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewUtil.lambda$clickListener$0(this.f$0, view);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$clickListener$0(View.OnClickListener onClickListener, View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - LAST_CLICK_TIME) >= 250) {
            onClickListener.onClick(view);
            LAST_CLICK_TIME = currentTimeMillis;
        }
    }

    public static void directClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null && !view.isInEditMode()) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void replaceView(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int indexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        viewGroup.addView(view2, indexOfChild);
    }

    public static void doubleClickListener(View view, OnDoubleClickListener onDoubleClickListener) {
        if (onDoubleClickListener == null) {
            view.setOnTouchListener(null);
        } else {
            view.setOnTouchListener(new SimpleTouchListener(view, onDoubleClickListener));
        }
    }

    public static void setChildViewDoubleClickListener2(View view, OnDoubleClickListener2 onDoubleClickListener2) {
        setChildViewDoubleClickListener(view, onDoubleClickListener2);
    }

    public static void setChildViewDoubleClickListener(View view, OnDoubleClickListener onDoubleClickListener) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                doubleClickListener(viewGroup.getChildAt(i), onDoubleClickListener);
            }
        }
    }

    public static void setChildViewClickListener(View view, View.OnClickListener onClickListener) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                clickListener(viewGroup.getChildAt(i), onClickListener);
            }
        }
    }

    public static <T extends ViewGroup> T getParentView(View view) {
        return (T) ((ViewGroup) view.getParent());
    }

    private static class SimpleTouchListener implements View.OnTouchListener, GestureDetector.OnDoubleTapListener {
        private final GestureDetector mGestureDetector;
        private final OnDoubleClickListener mListener;
        private final View mView;

        public SimpleTouchListener(View view, OnDoubleClickListener onDoubleClickListener) {
            this.mView = view;
            GestureDetector gestureDetector = new GestureDetector(view.getContext(), new GestureDetector.SimpleOnGestureListener());
            this.mGestureDetector = gestureDetector;
            gestureDetector.setOnDoubleTapListener(this);
            this.mListener = onDoubleClickListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            OnDoubleClickListener onDoubleClickListener = this.mListener;
            if (onDoubleClickListener instanceof OnDoubleClickListener2) {
                return ((OnDoubleClickListener2) onDoubleClickListener).onSingleTapConfirmed(motionEvent);
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return this.mListener.onDoubleClick(this.mView);
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            OnDoubleClickListener onDoubleClickListener = this.mListener;
            if (onDoubleClickListener instanceof OnDoubleClickListener2) {
                return ((OnDoubleClickListener2) onDoubleClickListener).onDoubleTapEvent(motionEvent);
            }
            return false;
        }
    }
}
