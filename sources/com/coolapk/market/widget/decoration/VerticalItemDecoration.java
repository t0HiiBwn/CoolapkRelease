package com.coolapk.market.widget.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

public class VerticalItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {16843284};
    private HashMap<Integer, Drawable> mDividerViewTypeMap;
    private Drawable mFirstDrawable;
    private Drawable mLastDrawable;

    public VerticalItemDecoration(HashMap<Integer, Drawable> hashMap, Drawable drawable, Drawable drawable2) {
        this.mDividerViewTypeMap = hashMap;
        this.mFirstDrawable = drawable;
        this.mLastDrawable = drawable2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable;
        if (isLastPosition(view, recyclerView)) {
            Drawable drawable2 = this.mLastDrawable;
            if (drawable2 != null) {
                rect.bottom = drawable2.getIntrinsicHeight();
                return;
            }
            return;
        }
        Drawable drawable3 = this.mDividerViewTypeMap.get(Integer.valueOf(recyclerView.getLayoutManager().getItemViewType(view)));
        if (drawable3 != null) {
            rect.bottom = drawable3.getIntrinsicHeight();
        }
        if (isFirstPosition(view, recyclerView) && (drawable = this.mFirstDrawable) != null) {
            rect.top = drawable.getIntrinsicHeight();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i <= childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int itemViewType = recyclerView.getLayoutManager().getItemViewType(childAt);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (!isLastPosition(childAt, recyclerView)) {
                Drawable drawable = this.mDividerViewTypeMap.get(Integer.valueOf(itemViewType));
                if (drawable != null) {
                    int bottom = childAt.getBottom() + layoutParams.bottomMargin;
                    drawable.setBounds(paddingLeft, bottom, width, drawable.getIntrinsicHeight() + bottom);
                    drawable.draw(canvas);
                }
                if (isFirstPosition(childAt, recyclerView) && this.mFirstDrawable != null) {
                    int top = childAt.getTop() - layoutParams.topMargin;
                    this.mFirstDrawable.setBounds(paddingLeft, top - this.mFirstDrawable.getIntrinsicHeight(), width, top);
                    this.mFirstDrawable.draw(canvas);
                }
            } else if (this.mLastDrawable != null) {
                int bottom2 = childAt.getBottom() + layoutParams.bottomMargin;
                this.mLastDrawable.setBounds(paddingLeft, bottom2, width, this.mLastDrawable.getIntrinsicHeight() + bottom2);
                this.mLastDrawable.draw(canvas);
                return;
            } else {
                return;
            }
        }
    }

    private boolean isFirstPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) == 0;
    }

    private boolean isLastPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1;
    }

    public static class Builder {
        private Context mContext;
        private HashMap<Integer, Drawable> mDividerViewTypeMap = new HashMap<>();
        private Drawable mFirstDrawable;
        private Drawable mLastDrawable;

        Builder(Context context) {
            this.mContext = context;
        }

        public Builder type(int i) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(VerticalItemDecoration.ATTRS);
            type(i, obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            return this;
        }

        public Builder type(int i, int i2) {
            this.mDividerViewTypeMap.put(Integer.valueOf(i), ContextCompat.getDrawable(this.mContext, i2));
            return this;
        }

        public Builder type(int i, Drawable drawable) {
            this.mDividerViewTypeMap.put(Integer.valueOf(i), drawable);
            return this;
        }

        public Builder first(int i) {
            first(ContextCompat.getDrawable(this.mContext, i));
            return this;
        }

        public Builder first(Drawable drawable) {
            this.mFirstDrawable = drawable;
            return this;
        }

        public Builder last(int i) {
            last(ContextCompat.getDrawable(this.mContext, i));
            return this;
        }

        public Builder last(Drawable drawable) {
            this.mLastDrawable = drawable;
            return this;
        }

        public VerticalItemDecoration create() {
            return new VerticalItemDecoration(this.mDividerViewTypeMap, this.mFirstDrawable, this.mLastDrawable);
        }
    }
}
