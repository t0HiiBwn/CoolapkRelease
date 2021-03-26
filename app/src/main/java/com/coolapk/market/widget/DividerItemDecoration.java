package com.coolapk.market.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    private Drawable mDivider;
    private int mOrientation;

    public DividerItemDecoration(Drawable drawable) {
        this(drawable, 1);
    }

    public DividerItemDecoration(Drawable drawable, int i) {
        this.mDivider = drawable;
        setOrientation(i);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            this.mOrientation = i;
            return;
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    protected void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (layoutParams.getViewAdapterPosition() != itemCount - 1) {
                int bottom = childAt.getBottom() + layoutParams.bottomMargin;
                this.mDivider.setBounds(paddingLeft, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
                this.mDivider.draw(canvas);
            }
        }
    }

    protected void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (layoutParams.getViewAdapterPosition() != itemCount - 1) {
                int right = childAt.getRight() + layoutParams.rightMargin;
                this.mDivider.setBounds(right, paddingTop, this.mDivider.getIntrinsicHeight() + right, height);
                this.mDivider.draw(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getAdapter().getItemCount() - 1 != ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition()) {
            if (this.mOrientation == 1) {
                rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
            } else {
                rect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
            }
        }
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getOrientation() {
        return this.mOrientation;
    }
}
