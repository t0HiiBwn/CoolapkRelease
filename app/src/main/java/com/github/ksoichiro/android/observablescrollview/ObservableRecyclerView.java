package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ObservableRecyclerView extends RecyclerView implements Scrollable {
    private static int recyclerViewLibraryVersion = 22;
    private ObservableScrollViewCallbacks mCallbacks;
    private SparseIntArray mChildrenHeights;
    private boolean mDragging;
    private boolean mFirstScroll;
    private boolean mIntercepted;
    private int mPrevFirstVisibleChildHeight = -1;
    private int mPrevFirstVisiblePosition;
    private MotionEvent mPrevMoveEvent;
    private int mPrevScrollY;
    private int mPrevScrolledChildrenHeight;
    private ScrollState mScrollState;
    private int mScrollY;
    private ViewGroup mTouchInterceptionViewGroup;

    public ObservableRecyclerView(Context context) {
        super(context);
        init();
    }

    public ObservableRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
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

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
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

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mCallbacks != null && getChildCount() > 0) {
            int childAdapterPosition = getChildAdapterPosition(getChildAt(0));
            int childAdapterPosition2 = getChildAdapterPosition(getChildAt(getChildCount() - 1));
            int i9 = childAdapterPosition;
            int i10 = 0;
            while (i9 <= childAdapterPosition2) {
                View childAt = getChildAt(i10);
                this.mChildrenHeights.put(i9, (childAt == null || (this.mChildrenHeights.indexOfKey(i9) >= 0 && childAt.getHeight() == this.mChildrenHeights.get(i9))) ? 0 : childAt.getHeight());
                i9++;
                i10++;
            }
            View childAt2 = getChildAt(0);
            if (childAt2 != null) {
                int i11 = this.mPrevFirstVisiblePosition;
                if (i11 < childAdapterPosition) {
                    if (childAdapterPosition - i11 != 1) {
                        i7 = 0;
                        for (int i12 = childAdapterPosition - 1; i12 > this.mPrevFirstVisiblePosition; i12--) {
                            if (this.mChildrenHeights.indexOfKey(i12) > 0) {
                                i8 = this.mChildrenHeights.get(i12);
                            } else {
                                i8 = childAt2.getHeight();
                            }
                            i7 += i8;
                        }
                    } else {
                        i7 = 0;
                    }
                    this.mPrevScrolledChildrenHeight += this.mPrevFirstVisibleChildHeight + i7;
                    this.mPrevFirstVisibleChildHeight = childAt2.getHeight();
                } else if (childAdapterPosition < i11) {
                    if (i11 - childAdapterPosition != 1) {
                        i5 = 0;
                        for (int i13 = i11 - 1; i13 > childAdapterPosition; i13--) {
                            if (this.mChildrenHeights.indexOfKey(i13) > 0) {
                                i6 = this.mChildrenHeights.get(i13);
                            } else {
                                i6 = childAt2.getHeight();
                            }
                            i5 += i6;
                        }
                    } else {
                        i5 = 0;
                    }
                    this.mPrevScrolledChildrenHeight -= childAt2.getHeight() + i5;
                    this.mPrevFirstVisibleChildHeight = childAt2.getHeight();
                } else if (childAdapterPosition == 0) {
                    this.mPrevFirstVisibleChildHeight = childAt2.getHeight();
                    this.mPrevScrolledChildrenHeight = 0;
                }
                if (this.mPrevFirstVisibleChildHeight < 0) {
                    this.mPrevFirstVisibleChildHeight = 0;
                }
                int top = this.mPrevScrolledChildrenHeight - childAt2.getTop();
                this.mScrollY = top;
                this.mPrevFirstVisiblePosition = childAdapterPosition;
                this.mCallbacks.onScrollChanged(top, this.mFirstScroll, this.mDragging);
                if (this.mFirstScroll) {
                    this.mFirstScroll = false;
                }
                int i14 = this.mPrevScrollY;
                int i15 = this.mScrollY;
                if (i14 < i15) {
                    this.mScrollState = ScrollState.UP;
                } else if (i15 < i14) {
                    this.mScrollState = ScrollState.DOWN;
                } else {
                    this.mScrollState = ScrollState.STOP;
                }
                this.mPrevScrollY = this.mScrollY;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
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
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
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
                            /* class com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.AnonymousClass1 */

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
        View childAt = getChildAt(0);
        if (childAt != null) {
            scrollVerticallyToPosition(i / childAt.getHeight());
        }
    }

    public void scrollVerticallyToPosition(int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !(layoutManager instanceof LinearLayoutManager)) {
            scrollToPosition(i);
        } else {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
        }
    }

    @Override // com.github.ksoichiro.android.observablescrollview.Scrollable
    public int getCurrentScrollY() {
        return this.mScrollY;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getChildAdapterPosition(View view) {
        if (22 <= recyclerViewLibraryVersion) {
            return super.getChildAdapterPosition(view);
        }
        return getChildPosition(view);
    }

    private void init() {
        this.mChildrenHeights = new SparseIntArray();
        checkLibraryVersion();
    }

    private void checkLibraryVersion() {
        try {
            super.getChildAdapterPosition(null);
        } catch (NoSuchMethodError unused) {
            recyclerViewLibraryVersion = 21;
        }
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.SavedState.AnonymousClass2 */

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public static final SavedState EMPTY_STATE = new SavedState() {
            /* class com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.SavedState.AnonymousClass1 */
        };
        SparseIntArray childrenHeights;
        int prevFirstVisibleChildHeight;
        int prevFirstVisiblePosition;
        int prevScrollY;
        int prevScrolledChildrenHeight;
        int scrollY;
        Parcelable superState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private SavedState() {
            this.prevFirstVisibleChildHeight = -1;
            this.superState = null;
        }

        SavedState(Parcelable parcelable) {
            this.prevFirstVisibleChildHeight = -1;
            this.superState = parcelable == EMPTY_STATE ? null : parcelable;
        }

        private SavedState(Parcel parcel) {
            this.prevFirstVisibleChildHeight = -1;
            Parcelable readParcelable = parcel.readParcelable(RecyclerView.class.getClassLoader());
            this.superState = readParcelable == null ? EMPTY_STATE : readParcelable;
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

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.superState, i);
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

        public Parcelable getSuperState() {
            return this.superState;
        }
    }
}
