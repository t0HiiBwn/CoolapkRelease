package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class ObservableWebView extends WebView implements Scrollable {
    private ObservableScrollViewCallbacks mCallbacks;
    private boolean mDragging;
    private boolean mFirstScroll;
    private boolean mIntercepted;
    private MotionEvent mPrevMoveEvent;
    private int mPrevScrollY;
    private ScrollState mScrollState;
    private int mScrollY;
    private ViewGroup mTouchInterceptionViewGroup;

    public ObservableWebView(Context context) {
        super(context);
    }

    public ObservableWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.mPrevScrollY = savedState.prevScrollY;
        this.mScrollY = savedState.scrollY;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.prevScrollY = this.mPrevScrollY;
        savedState.scrollY = this.mScrollY;
        return savedState;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ObservableScrollViewCallbacks observableScrollViewCallbacks = this.mCallbacks;
        if (observableScrollViewCallbacks != null) {
            this.mScrollY = i2;
            observableScrollViewCallbacks.onScrollChanged(i2, this.mFirstScroll, this.mDragging);
            if (this.mFirstScroll) {
                this.mFirstScroll = false;
            }
            int i5 = this.mPrevScrollY;
            if (i5 < i2) {
                this.mScrollState = ScrollState.UP;
            } else if (i2 < i5) {
                this.mScrollState = ScrollState.DOWN;
            } else {
                this.mScrollState = ScrollState.STOP;
            }
            this.mPrevScrollY = i2;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mCallbacks != null && motionEvent.getActionMasked() == 0) {
            this.mDragging = true;
            this.mFirstScroll = true;
            this.mCallbacks.onDownMotionEvent();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != 3) goto L_0x0093;
     */
    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCallbacks != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.mPrevMoveEvent == null) {
                        this.mPrevMoveEvent = motionEvent;
                    }
                    float y = motionEvent.getY() - this.mPrevMoveEvent.getY();
                    this.mPrevMoveEvent = MotionEvent.obtainNoHistory(motionEvent);
                    float currentScrollY = ((float) getCurrentScrollY()) - y;
                    float f = 0.0f;
                    if (currentScrollY <= 0.0f) {
                        if (this.mIntercepted) {
                            return false;
                        }
                        final ViewGroup viewGroup = this.mTouchInterceptionViewGroup;
                        if (viewGroup == null) {
                            viewGroup = (ViewGroup) getParent();
                        }
                        float f2 = 0.0f;
                        View view = this;
                        while (view != null && view != viewGroup) {
                            f += (float) (view.getLeft() - view.getScrollX());
                            f2 += (float) (view.getTop() - view.getScrollY());
                            view = (View) view.getParent();
                        }
                        final MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                        obtainNoHistory.offsetLocation(f, f2);
                        if (!viewGroup.onInterceptTouchEvent(obtainNoHistory)) {
                            return super.onTouchEvent(motionEvent);
                        }
                        this.mIntercepted = true;
                        obtainNoHistory.setAction(0);
                        post(new Runnable() {
                            /* class com.github.ksoichiro.android.observablescrollview.ObservableWebView.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                viewGroup.dispatchTouchEvent(obtainNoHistory);
                            }
                        });
                        return false;
                    }
                }
            }
            this.mIntercepted = false;
            this.mDragging = false;
            this.mCallbacks.onUpOrCancelMotionEvent(this.mScrollState);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.github.ksoichiro.android.observablescrollview.Scrollable
    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.mCallbacks = observableScrollViewCallbacks;
    }

    @Override // com.github.ksoichiro.android.observablescrollview.Scrollable
    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.mTouchInterceptionViewGroup = viewGroup;
    }

    @Override // com.github.ksoichiro.android.observablescrollview.Scrollable
    public void scrollVerticallyTo(int i) {
        scrollTo(0, i);
    }

    @Override // com.github.ksoichiro.android.observablescrollview.Scrollable
    public int getCurrentScrollY() {
        return this.mScrollY;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.github.ksoichiro.android.observablescrollview.ObservableWebView.SavedState.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int prevScrollY;
        int scrollY;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.prevScrollY = parcel.readInt();
            this.scrollY = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.prevScrollY);
            parcel.writeInt(this.scrollY);
        }
    }
}
