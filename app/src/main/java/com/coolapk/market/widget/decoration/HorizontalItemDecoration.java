package com.coolapk.market.widget.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

public class HorizontalItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {16843284};
    private HashMap<Integer, Drawable> mDividerViewTypeMap;
    private Drawable mFirstDrawable;
    private Drawable mLastDrawable;

    public HorizontalItemDecoration(HashMap<Integer, Drawable> hashMap, Drawable drawable, Drawable drawable2) {
        this.mDividerViewTypeMap = hashMap;
        this.mFirstDrawable = drawable;
        this.mLastDrawable = drawable2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable;
        boolean reverseLayout = recyclerView.getLayoutManager() instanceof LinearLayoutManager ? ((LinearLayoutManager) recyclerView.getLayoutManager()).getReverseLayout() : false;
        if (isLastPosition(view, recyclerView)) {
            Drawable drawable2 = this.mLastDrawable;
            if (drawable2 == null) {
                return;
            }
            if (reverseLayout) {
                rect.left = drawable2.getIntrinsicWidth();
            } else {
                rect.right = drawable2.getIntrinsicWidth();
            }
        } else {
            Drawable drawable3 = this.mDividerViewTypeMap.get(Integer.valueOf(recyclerView.getLayoutManager().getItemViewType(view)));
            if (drawable3 != null) {
                if (reverseLayout) {
                    rect.left = drawable3.getIntrinsicWidth();
                } else {
                    rect.right = drawable3.getIntrinsicWidth();
                }
            }
            if (isFirstPosition(view, recyclerView) && (drawable = this.mFirstDrawable) != null) {
                if (reverseLayout) {
                    rect.right = drawable.getIntrinsicWidth();
                } else {
                    rect.left = drawable.getIntrinsicWidth();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        boolean reverseLayout = recyclerView.getLayoutManager() instanceof LinearLayoutManager ? ((LinearLayoutManager) recyclerView.getLayoutManager()).getReverseLayout() : false;
        int childCount = recyclerView.getChildCount();
        for (int i7 = 0; i7 <= childCount - 1; i7++) {
            View childAt = recyclerView.getChildAt(i7);
            int itemViewType = recyclerView.getLayoutManager().getItemViewType(childAt);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (!isLastPosition(childAt, recyclerView)) {
                Drawable drawable = this.mDividerViewTypeMap.get(Integer.valueOf(itemViewType));
                if (drawable != null) {
                    if (reverseLayout) {
                        i6 = childAt.getLeft() - layoutParams.leftMargin;
                        i5 = i6 - drawable.getIntrinsicWidth();
                    } else {
                        i5 = layoutParams.rightMargin + childAt.getRight();
                        i6 = drawable.getIntrinsicWidth() + i5;
                    }
                    drawable.setBounds(i5, paddingTop, i6, height);
                    drawable.draw(canvas);
                }
                if (isFirstPosition(childAt, recyclerView) && this.mFirstDrawable != null) {
                    if (reverseLayout) {
                        i4 = childAt.getRight() + layoutParams.rightMargin;
                        i3 = this.mFirstDrawable.getIntrinsicWidth() + i4;
                    } else {
                        i3 = childAt.getLeft() - layoutParams.leftMargin;
                        i4 = i3 - this.mFirstDrawable.getIntrinsicWidth();
                    }
                    this.mFirstDrawable.setBounds(i4, paddingTop, i3, height);
                    this.mFirstDrawable.draw(canvas);
                }
            } else if (this.mLastDrawable != null) {
                if (reverseLayout) {
                    i = childAt.getLeft() - layoutParams.leftMargin;
                    i2 = i - this.mLastDrawable.getIntrinsicWidth();
                } else {
                    i2 = layoutParams.rightMargin + childAt.getRight();
                    i = this.mLastDrawable.getIntrinsicWidth() + i2;
                }
                this.mLastDrawable.setBounds(i2, paddingTop, i, height);
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
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(HorizontalItemDecoration.ATTRS);
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

        public HorizontalItemDecoration create() {
            return new HorizontalItemDecoration(this.mDividerViewTypeMap, this.mFirstDrawable, this.mLastDrawable);
        }
    }
}
