package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

public class ObservableListView extends ListView implements Scrollable {
    private ObservableScrollViewCallbacks mCallbacks;
    private SparseIntArray mChildrenHeights;
    private boolean mDragging;
    private boolean mFirstScroll;
    private boolean mIntercepted;
    private AbsListView.OnScrollListener mOriginalScrollListener;
    private int mPrevFirstVisibleChildHeight = -1;
    private int mPrevFirstVisiblePosition;
    private MotionEvent mPrevMoveEvent;
    private int mPrevScrollY;
    private int mPrevScrolledChildrenHeight;
    private AbsListView.OnScrollListener mScrollListener = new AbsListView.OnScrollListener() {
        /* class com.github.ksoichiro.android.observablescrollview.ObservableListView.AnonymousClass1 */

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (ObservableListView.this.mOriginalScrollListener != null) {
                ObservableListView.this.mOriginalScrollListener.onScrollStateChanged(absListView, i);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (ObservableListView.this.mOriginalScrollListener != null) {
                ObservableListView.this.mOriginalScrollListener.onScroll(absListView, i, i2, i3);
            }
            ObservableListView.this.onScrollChanged();
        }
    };
    private ScrollState mScrollState;
    private int mScrollY;
    private ViewGroup mTouchInterceptionViewGroup;

    public ObservableListView(Context context) {
        super(context);
        init();
    }

    public ObservableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.mPrevFirstVisiblePosition = savedState.prevFirstVisiblePosition;
        this.mPrevFirstVisibleChildHeight = savedState.prevFirstVisibleChildHeight;
        this.mPrevScrolledChildrenHeight = savedState.prevScrolledChildrenHeight;
        this.mPrevScrollY = savedState.prevScrollY;
        this.mScrollY = savedState.scrollY;
        this.mChildrenHeights = savedState.childrenHeights;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.prevFirstVisiblePosition = this.mPrevFirstVisiblePosition;
        savedState.prevFirstVisibleChildHeight = this.mPrevFirstVisibleChildHeight;
        savedState.prevScrolledChildrenHeight = this.mPrevScrolledChildrenHeight;
        savedState.prevScrollY = this.mPrevScrollY;
        savedState.scrollY = this.mScrollY;
        savedState.childrenHeights = this.mChildrenHeights;
        return savedState;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mCallbacks != null && motionEvent.getActionMasked() == 0) {
            this.mDragging = true;
            this.mFirstScroll = true;
            this.mCallbacks.onDownMotionEvent();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != 3) goto L_0x0094;
     */
    @Override // android.widget.AbsListView, android.view.View
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
                            try {
                                view = (View) view.getParent();
                            } catch (ClassCastException unused) {
                            }
                        }
                        final MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                        obtainNoHistory.offsetLocation(f, f2);
                        if (!viewGroup.onInterceptTouchEvent(obtainNoHistory)) {
                            return super.onTouchEvent(motionEvent);
                        }
                        this.mIntercepted = true;
                        obtainNoHistory.setAction(0);
                        post(new Runnable() {
                            /* class com.github.ksoichiro.android.observablescrollview.ObservableListView.AnonymousClass2 */

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

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOriginalScrollListener = onScrollListener;
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
        View childAt = getChildAt(0);
        if (childAt != null) {
            setSelection(i / childAt.getHeight());
        }
    }

    @Override // com.github.ksoichiro.android.observablescrollview.Scrollable
    public int getCurrentScrollY() {
        return this.mScrollY;
    }

    private void init() {
        this.mChildrenHeights = new SparseIntArray();
        super.setOnScrollListener(this.mScrollListener);
    }

    /* access modifiers changed from: private */
    public void onScrollChanged() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mCallbacks != null && getChildCount() > 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int firstVisiblePosition2 = getFirstVisiblePosition();
            int i5 = 0;
            while (firstVisiblePosition2 <= getLastVisiblePosition()) {
                if (this.mChildrenHeights.indexOfKey(firstVisiblePosition2) < 0 || getChildAt(i5).getHeight() != this.mChildrenHeights.get(firstVisiblePosition2)) {
                    this.mChildrenHeights.put(firstVisiblePosition2, getChildAt(i5).getHeight());
                }
                firstVisiblePosition2++;
                i5++;
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                int i6 = this.mPrevFirstVisiblePosition;
                if (i6 < firstVisiblePosition) {
                    if (firstVisiblePosition - i6 != 1) {
                        i3 = 0;
                        for (int i7 = firstVisiblePosition - 1; i7 > this.mPrevFirstVisiblePosition; i7--) {
                            if (this.mChildrenHeights.indexOfKey(i7) > 0) {
                                i4 = this.mChildrenHeights.get(i7);
                            } else {
                                i4 = childAt.getHeight();
                            }
                            i3 += i4;
                        }
                    } else {
                        i3 = 0;
                    }
                    this.mPrevScrolledChildrenHeight += this.mPrevFirstVisibleChildHeight + i3;
                    this.mPrevFirstVisibleChildHeight = childAt.getHeight();
                } else if (firstVisiblePosition < i6) {
                    if (i6 - firstVisiblePosition != 1) {
                        i = 0;
                        for (int i8 = i6 - 1; i8 > firstVisiblePosition; i8--) {
                            if (this.mChildrenHeights.indexOfKey(i8) > 0) {
                                i2 = this.mChildrenHeights.get(i8);
                            } else {
                                i2 = childAt.getHeight();
                            }
                            i += i2;
                        }
                    } else {
                        i = 0;
                    }
                    this.mPrevScrolledChildrenHeight -= childAt.getHeight() + i;
                    this.mPrevFirstVisibleChildHeight = childAt.getHeight();
                } else if (firstVisiblePosition == 0) {
                    this.mPrevFirstVisibleChildHeight = childAt.getHeight();
                }
                if (this.mPrevFirstVisibleChildHeight < 0) {
                    this.mPrevFirstVisibleChildHeight = 0;
                }
                int top = this.mPrevScrolledChildrenHeight - childAt.getTop();
                this.mScrollY = top;
                this.mPrevFirstVisiblePosition = firstVisiblePosition;
                this.mCallbacks.onScrollChanged(top, this.mFirstScroll, this.mDragging);
                if (this.mFirstScroll) {
                    this.mFirstScroll = false;
                }
                int i9 = this.mPrevScrollY;
                int i10 = this.mScrollY;
                if (i9 < i10) {
                    this.mScrollState = ScrollState.UP;
                } else if (i10 < i9) {
                    this.mScrollState = ScrollState.DOWN;
                } else {
                    this.mScrollState = ScrollState.STOP;
                }
                this.mPrevScrollY = this.mScrollY;
            }
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.github.ksoichiro.android.observablescrollview.ObservableListView.SavedState.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        SparseIntArray childrenHeights;
        int prevFirstVisibleChildHeight;
        int prevFirstVisiblePosition;
        int prevScrollY;
        int prevScrolledChildrenHeight;
        int scrollY;

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.prevFirstVisibleChildHeight = -1;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.prevFirstVisibleChildHeight = -1;
            this.prevFirstVisiblePosition = parcel.readInt();
            this.prevFirstVisibleChildHeight = parcel.readInt();
            this.prevScrolledChildrenHeight = parcel.readInt();
            this.prevScrollY = parcel.readInt();
            this.scrollY = parcel.readInt();
            this.childrenHeights = new SparseIntArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    this.childrenHeights.put(parcel.readInt(), parcel.readInt());
                }
            }
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.prevFirstVisiblePosition);
            parcel.writeInt(this.prevFirstVisibleChildHeight);
            parcel.writeInt(this.prevScrolledChildrenHeight);
            parcel.writeInt(this.prevScrollY);
            parcel.writeInt(this.scrollY);
            SparseIntArray sparseIntArray = this.childrenHeights;
            int size = sparseIntArray == null ? 0 : sparseIntArray.size();
            parcel.writeInt(size);
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    parcel.writeInt(this.childrenHeights.keyAt(i2));
                    parcel.writeInt(this.childrenHeights.valueAt(i2));
                }
            }
        }
    }
}
