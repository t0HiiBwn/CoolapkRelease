package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ObservableGridView extends GridView implements Scrollable {
    private ObservableScrollViewCallbacks mCallbacks;
    private SparseIntArray mChildrenHeights;
    private boolean mDragging;
    private boolean mFirstScroll;
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private ArrayList<FixedViewInfo> mHeaderViewInfos;
    private boolean mIntercepted;
    private AbsListView.OnScrollListener mOriginalScrollListener;
    private int mPrevFirstVisibleChildHeight = -1;
    private int mPrevFirstVisiblePosition;
    private MotionEvent mPrevMoveEvent;
    private int mPrevScrollY;
    private int mPrevScrolledChildrenHeight;
    private AbsListView.OnScrollListener mScrollListener = new AbsListView.OnScrollListener() {
        /* class com.github.ksoichiro.android.observablescrollview.ObservableGridView.AnonymousClass1 */

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (ObservableGridView.this.mOriginalScrollListener != null) {
                ObservableGridView.this.mOriginalScrollListener.onScrollStateChanged(absListView, i);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (ObservableGridView.this.mOriginalScrollListener != null) {
                ObservableGridView.this.mOriginalScrollListener.onScroll(absListView, i, i2, i3);
            }
            ObservableGridView.this.onScrollChanged();
        }
    };
    private ScrollState mScrollState;
    private int mScrollY;
    private ViewGroup mTouchInterceptionViewGroup;

    public static class FixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;
        public ViewGroup viewContainer;
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean z) {
    }

    public ObservableGridView(Context context) {
        super(context);
        init();
    }

    public ObservableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableGridView(Context context, AttributeSet attributeSet, int i) {
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
        if (r0 != 3) goto L_0x0093;
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
                            /* class com.github.ksoichiro.android.observablescrollview.ObservableGridView.AnonymousClass2 */

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

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    public void addFooterView(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter == null || (adapter instanceof HeaderViewGridAdapter)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            FullWidthFixedViewLayout fullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
            if (layoutParams != null) {
                view.setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
                fullWidthFixedViewLayout.setLayoutParams(new AbsListView.LayoutParams(layoutParams.width, layoutParams.height));
            }
            fullWidthFixedViewLayout.addView(view);
            fixedViewInfo.view = view;
            fixedViewInfo.viewContainer = fullWidthFixedViewLayout;
            fixedViewInfo.data = obj;
            fixedViewInfo.isSelectable = z;
            this.mFooterViewInfos.add(fixedViewInfo);
            if (adapter != null) {
                ((HeaderViewGridAdapter) adapter).notifyDataSetChanged();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public boolean removeFooterView(View view) {
        boolean z = false;
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewGridAdapter) adapter).removeFooter(view)) {
                z = true;
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
        }
        return z;
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
        scrollTo(0, i);
    }

    @Override // com.github.ksoichiro.android.observablescrollview.Scrollable
    public int getCurrentScrollY() {
        return this.mScrollY;
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.mHeaderViewInfos.size() > 0) {
            HeaderViewGridAdapter headerViewGridAdapter = new HeaderViewGridAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
            int numColumnsCompat = getNumColumnsCompat();
            if (1 < numColumnsCompat) {
                headerViewGridAdapter.setNumColumns(numColumnsCompat);
            }
            super.setAdapter((ListAdapter) headerViewGridAdapter);
            return;
        }
        super.setAdapter(listAdapter);
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter == null || (adapter instanceof HeaderViewGridAdapter)) {
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            FullWidthFixedViewLayout fullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
            fullWidthFixedViewLayout.addView(view);
            fixedViewInfo.view = view;
            fixedViewInfo.viewContainer = fullWidthFixedViewLayout;
            fixedViewInfo.data = obj;
            fixedViewInfo.isSelectable = z;
            this.mHeaderViewInfos.add(fixedViewInfo);
            if (adapter != null) {
                ((HeaderViewGridAdapter) adapter).notifyDataSetChanged();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    public boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && (adapter instanceof HeaderViewGridAdapter) && ((HeaderViewGridAdapter) adapter).removeHeader(view)) {
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
        }
        return z;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof HeaderViewGridAdapter)) {
            ((HeaderViewGridAdapter) adapter).setNumColumns(getNumColumnsCompat());
        }
    }

    private void init() {
        this.mChildrenHeights = new SparseIntArray();
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        super.setClipChildren(false);
        super.setOnScrollListener(this.mScrollListener);
    }

    private int getNumColumnsCompat() {
        int measuredWidth;
        if (Build.VERSION.SDK_INT >= 11) {
            return getNumColumns();
        }
        int i = 0;
        if (getChildCount() > 0 && (measuredWidth = getChildAt(0).getMeasuredWidth()) > 0) {
            i = getWidth() / measuredWidth;
        }
        if (i > 0) {
            return i;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void onScrollChanged() {
        int i;
        int i2;
        if (this.mCallbacks != null && getChildCount() > 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int firstVisiblePosition2 = getFirstVisiblePosition();
            int i3 = 0;
            while (firstVisiblePosition2 <= getLastVisiblePosition()) {
                if ((this.mChildrenHeights.indexOfKey(firstVisiblePosition2) < 0 || getChildAt(i3).getHeight() != this.mChildrenHeights.get(firstVisiblePosition2)) && firstVisiblePosition2 % getNumColumnsCompat() == 0) {
                    this.mChildrenHeights.put(firstVisiblePosition2, getChildAt(i3).getHeight());
                }
                firstVisiblePosition2++;
                i3++;
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                int i4 = this.mPrevFirstVisiblePosition;
                if (i4 < firstVisiblePosition) {
                    if (firstVisiblePosition - i4 != 1) {
                        i2 = 0;
                        for (int i5 = firstVisiblePosition - 1; i5 > this.mPrevFirstVisiblePosition; i5--) {
                            if (this.mChildrenHeights.indexOfKey(i5) > 0) {
                                i2 += this.mChildrenHeights.get(i5);
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    this.mPrevScrolledChildrenHeight += this.mPrevFirstVisibleChildHeight + i2;
                    this.mPrevFirstVisibleChildHeight = childAt.getHeight();
                } else if (firstVisiblePosition < i4) {
                    if (i4 - firstVisiblePosition != 1) {
                        i = 0;
                        for (int i6 = i4 - 1; i6 > firstVisiblePosition; i6--) {
                            if (this.mChildrenHeights.indexOfKey(i6) > 0) {
                                i += this.mChildrenHeights.get(i6);
                            }
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
                int i7 = this.mPrevScrollY;
                int i8 = this.mScrollY;
                if (i7 < i8) {
                    this.mScrollState = ScrollState.UP;
                } else if (i8 < i7) {
                    this.mScrollState = ScrollState.DOWN;
                } else {
                    this.mScrollState = ScrollState.STOP;
                }
                this.mPrevScrollY = this.mScrollY;
            }
        }
    }

    private void removeFixedViewInfo(View view, ArrayList<FixedViewInfo> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).view == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    private class FullWidthFixedViewLayout extends FrameLayout {
        public FullWidthFixedViewLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((ObservableGridView.this.getMeasuredWidth() - ObservableGridView.this.getPaddingLeft()) - ObservableGridView.this.getPaddingRight(), View.MeasureSpec.getMode(i)), i2);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.github.ksoichiro.android.observablescrollview.ObservableGridView.SavedState.AnonymousClass1 */

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

    public static class HeaderViewGridAdapter implements WrapperListAdapter, Filterable {
        static final ArrayList<FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<>();
        private final ListAdapter mAdapter;
        boolean mAreAllFixedViewsSelectable;
        private boolean mCacheFirstHeaderView;
        private boolean mCachePlaceHoldView;
        private final DataSetObservable mDataSetObservable = new DataSetObservable();
        ArrayList<FixedViewInfo> mFooterViewInfos;
        ArrayList<FixedViewInfo> mHeaderViewInfos;
        private final boolean mIsFilterable;
        private int mNumColumns;
        private int mRowHeight;

        public HeaderViewGridAdapter(ArrayList<FixedViewInfo> arrayList, ArrayList<FixedViewInfo> arrayList2, ListAdapter listAdapter) {
            boolean z = true;
            this.mNumColumns = 1;
            this.mRowHeight = -1;
            this.mCachePlaceHoldView = true;
            this.mCacheFirstHeaderView = false;
            this.mAdapter = listAdapter;
            this.mIsFilterable = listAdapter instanceof Filterable;
            if (arrayList == null) {
                this.mHeaderViewInfos = EMPTY_INFO_LIST;
            } else {
                this.mHeaderViewInfos = arrayList;
            }
            if (arrayList2 == null) {
                this.mFooterViewInfos = EMPTY_INFO_LIST;
            } else {
                this.mFooterViewInfos = arrayList2;
            }
            this.mAreAllFixedViewsSelectable = (!areAllListInfosSelectable(this.mHeaderViewInfos) || !areAllListInfosSelectable(this.mFooterViewInfos)) ? false : z;
        }

        public void setNumColumns(int i) {
            if (i >= 1 && this.mNumColumns != i) {
                this.mNumColumns = i;
                notifyDataSetChanged();
            }
        }

        public void setRowHeight(int i) {
            this.mRowHeight = i;
        }

        public int getHeadersCount() {
            return this.mHeaderViewInfos.size();
        }

        public int getFootersCount() {
            return this.mFooterViewInfos.size();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            ListAdapter listAdapter = this.mAdapter;
            return listAdapter == null || listAdapter.isEmpty();
        }

        private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> arrayList) {
            if (arrayList == null) {
                return true;
            }
            Iterator<FixedViewInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!it2.next().isSelectable) {
                    return false;
                }
            }
            return true;
        }

        public boolean removeHeader(View view) {
            boolean z = false;
            for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
                if (this.mHeaderViewInfos.get(i).view == view) {
                    this.mHeaderViewInfos.remove(i);
                    if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                        z = true;
                    }
                    this.mAreAllFixedViewsSelectable = z;
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        public boolean removeFooter(View view) {
            boolean z = false;
            for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
                if (this.mFooterViewInfos.get(i).view == view) {
                    this.mFooterViewInfos.remove(i);
                    if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                        z = true;
                    }
                    this.mAreAllFixedViewsSelectable = z;
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mAdapter != null) {
                return ((getFootersCount() + getHeadersCount()) * this.mNumColumns) + getAdapterAndPlaceHolderCount();
            }
            return (getFootersCount() + getHeadersCount()) * this.mNumColumns;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mAdapter;
            return listAdapter == null || (this.mAreAllFixedViewsSelectable && listAdapter.areAllItemsEnabled());
        }

        private int getAdapterAndPlaceHolderCount() {
            return (int) (Math.ceil((double) ((((float) this.mAdapter.getCount()) * 1.0f) / ((float) this.mNumColumns))) * ((double) this.mNumColumns));
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            int i2;
            int headersCount = getHeadersCount();
            int i3 = this.mNumColumns;
            int i4 = headersCount * i3;
            if (i >= i4) {
                int i5 = i - i4;
                if (this.mAdapter != null) {
                    i2 = getAdapterAndPlaceHolderCount();
                    if (i5 < i2) {
                        if (i5 >= this.mAdapter.getCount() || !this.mAdapter.isEnabled(i5)) {
                            return false;
                        }
                        return true;
                    }
                } else {
                    i2 = 0;
                }
                int i6 = i5 - i2;
                int i7 = this.mNumColumns;
                if (i6 % i7 != 0 || !this.mFooterViewInfos.get(i6 / i7).isSelectable) {
                    return false;
                }
                return true;
            } else if (i % i3 != 0 || !this.mHeaderViewInfos.get(i / i3).isSelectable) {
                return false;
            } else {
                return true;
            }
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int i3 = headersCount * i2;
            if (i >= i3) {
                int i4 = i - i3;
                int i5 = 0;
                if (this.mAdapter == null || i4 >= (i5 = getAdapterAndPlaceHolderCount())) {
                    int i6 = i4 - i5;
                    if (i6 % this.mNumColumns == 0) {
                        return this.mFooterViewInfos.get(i6).data;
                    }
                    return null;
                } else if (i4 < this.mAdapter.getCount()) {
                    return this.mAdapter.getItem(i4);
                } else {
                    return null;
                }
            } else if (i % i2 == 0) {
                return this.mHeaderViewInfos.get(i / i2).data;
            } else {
                return null;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            int i2;
            int headersCount = getHeadersCount() * this.mNumColumns;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null || i < headersCount || (i2 = i - headersCount) >= listAdapter.getCount()) {
                return -1;
            }
            return this.mAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            ListAdapter listAdapter = this.mAdapter;
            return listAdapter != null && listAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int i3 = headersCount * i2;
            if (i < i3) {
                ViewGroup viewGroup2 = this.mHeaderViewInfos.get(i / i2).viewContainer;
                if (i % this.mNumColumns == 0) {
                    return viewGroup2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(viewGroup2.getHeight());
                return view;
            }
            int i4 = i - i3;
            int i5 = 0;
            if (this.mAdapter == null || i4 >= (i5 = getAdapterAndPlaceHolderCount())) {
                int i6 = i4 - i5;
                if (i6 < getCount()) {
                    ViewGroup viewGroup3 = this.mFooterViewInfos.get(i6 / this.mNumColumns).viewContainer;
                    if (i % this.mNumColumns == 0) {
                        return viewGroup3;
                    }
                    if (view == null) {
                        view = new View(viewGroup.getContext());
                    }
                    view.setVisibility(4);
                    view.setMinimumHeight(viewGroup3.getHeight());
                    return view;
                }
                throw new ArrayIndexOutOfBoundsException(i);
            } else if (i4 < this.mAdapter.getCount()) {
                return this.mAdapter.getView(i4, view, viewGroup);
            } else {
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(this.mRowHeight);
                return view;
            }
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            int i2;
            int headersCount = getHeadersCount() * this.mNumColumns;
            ListAdapter listAdapter = this.mAdapter;
            int i3 = 0;
            int viewTypeCount = listAdapter == null ? 0 : listAdapter.getViewTypeCount() - 1;
            int i4 = -2;
            if (this.mCachePlaceHoldView && i < headersCount) {
                if (i == 0 && this.mCacheFirstHeaderView) {
                    i4 = this.mHeaderViewInfos.size() + viewTypeCount + this.mFooterViewInfos.size() + 1 + 1;
                }
                int i5 = this.mNumColumns;
                if (i % i5 != 0) {
                    i4 = (i / i5) + 1 + viewTypeCount;
                }
            }
            int i6 = i - headersCount;
            if (this.mAdapter != null) {
                i3 = getAdapterAndPlaceHolderCount();
                if (i6 >= 0 && i6 < i3) {
                    if (i6 < this.mAdapter.getCount()) {
                        i4 = this.mAdapter.getItemViewType(i6);
                    } else if (this.mCachePlaceHoldView) {
                        i4 = this.mHeaderViewInfos.size() + viewTypeCount + 1;
                    }
                }
            }
            return (!this.mCachePlaceHoldView || (i2 = i6 - i3) < 0 || i2 >= getCount() || i2 % this.mNumColumns == 0) ? i4 : viewTypeCount + this.mHeaderViewInfos.size() + 1 + (i2 / this.mNumColumns) + 1;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            ListAdapter listAdapter = this.mAdapter;
            int viewTypeCount = listAdapter == null ? 1 : listAdapter.getViewTypeCount();
            if (!this.mCachePlaceHoldView) {
                return viewTypeCount;
            }
            int size = this.mHeaderViewInfos.size() + 1 + this.mFooterViewInfos.size();
            if (this.mCacheFirstHeaderView) {
                size++;
            }
            return viewTypeCount + size;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.registerObserver(dataSetObserver);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.mIsFilterable) {
                return ((Filterable) this.mAdapter).getFilter();
            }
            return null;
        }

        @Override // android.widget.WrapperListAdapter
        public ListAdapter getWrappedAdapter() {
            return this.mAdapter;
        }

        public void notifyDataSetChanged() {
            this.mDataSetObservable.notifyChanged();
        }
    }
}
