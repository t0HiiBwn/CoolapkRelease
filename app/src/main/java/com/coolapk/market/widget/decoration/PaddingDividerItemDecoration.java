package com.coolapk.market.widget.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.util.DisplayUtils;

public class PaddingDividerItemDecoration extends RecyclerView.ItemDecoration {
    private final CallBack mCallBack;
    private final Drawable mDividerDrawable;
    private final Drawable mEdgeDrawable;

    public interface CallBack {
        int getCurrencyColor();

        int getDividerColor();

        int getDividerHeight(int i);

        int getEdgeColor();

        int getFirstColor();

        int getFirstHeight();

        int getItemCount();

        int getLastColor();

        int getLastHeight();

        int getPaddingLeft();

        int getPaddingRight();

        boolean hasPadding(int i);

        boolean isThinnestDivider(int i);
    }

    public PaddingDividerItemDecoration(CallBack callBack) {
        this.mCallBack = callBack;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        this.mEdgeDrawable = shapeDrawable;
        shapeDrawable.setColorFilter(callBack.getEdgeColor(), PorterDuff.Mode.SRC_IN);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RectShape());
        this.mDividerDrawable = shapeDrawable2;
        shapeDrawable2.setColorFilter(callBack.getDividerColor(), PorterDuff.Mode.SRC_IN);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(i));
            if (childLayoutPosition < this.mCallBack.getItemCount() && childLayoutPosition >= 0) {
                setColor(childLayoutPosition);
            }
            if (childLayoutPosition < this.mCallBack.getItemCount() - 1 && childLayoutPosition >= 0) {
                if (this.mCallBack.hasPadding(childLayoutPosition)) {
                    drawPaddingDivider(canvas, recyclerView, paddingLeft, paddingLeft + this.mCallBack.getPaddingLeft(), i, childLayoutPosition);
                    drawMainDivider(canvas, recyclerView, paddingLeft + this.mCallBack.getPaddingLeft(), width - this.mCallBack.getPaddingRight(), i, childLayoutPosition);
                    drawPaddingDivider(canvas, recyclerView, width - this.mCallBack.getPaddingRight(), width, i, childLayoutPosition);
                } else {
                    drawMainDivider(canvas, recyclerView, paddingLeft, width, i, childLayoutPosition);
                }
            }
            if (childLayoutPosition == 0 && this.mCallBack.getFirstHeight() != 0) {
                drawFirstDivider(canvas, recyclerView, paddingLeft, width);
            }
            if (childLayoutPosition == this.mCallBack.getItemCount() - 1 && this.mCallBack.getLastHeight() != 0) {
                if (this.mCallBack.hasPadding(childLayoutPosition)) {
                    drawPaddingDivider(canvas, recyclerView, paddingLeft, paddingLeft + this.mCallBack.getPaddingLeft(), i, childLayoutPosition);
                    drawLastDivider(canvas, recyclerView, paddingLeft + this.mCallBack.getPaddingLeft(), width - this.mCallBack.getPaddingRight(), i);
                    drawPaddingDivider(canvas, recyclerView, width - this.mCallBack.getPaddingRight(), width, i, childLayoutPosition);
                } else {
                    drawLastDivider(canvas, recyclerView, paddingLeft, width, i);
                }
            }
        }
    }

    private void setColor(int i) {
        if (this.mCallBack.isThinnestDivider(i)) {
            this.mDividerDrawable.setColorFilter(this.mCallBack.getCurrencyColor(), PorterDuff.Mode.SRC_IN);
        } else {
            this.mDividerDrawable.setColorFilter(this.mCallBack.getDividerColor(), PorterDuff.Mode.SRC_IN);
        }
    }

    private boolean isFirstPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildLayoutPosition(view) == 0;
    }

    private boolean isLastPosition(View view, RecyclerView recyclerView) {
        return recyclerView.getChildLayoutPosition(view) == recyclerView.getAdapter().getItemCount() - 1;
    }

    private void drawFirstDivider(Canvas canvas, RecyclerView recyclerView, int i, int i2) {
        View childAt = recyclerView.getChildAt(0);
        int top = childAt.getTop() - ((RecyclerView.LayoutParams) childAt.getLayoutParams()).topMargin;
        this.mDividerDrawable.setColorFilter(this.mCallBack.getFirstColor(), PorterDuff.Mode.SRC_IN);
        this.mDividerDrawable.setBounds(i, top - this.mCallBack.getFirstHeight(), i2, top);
        this.mDividerDrawable.draw(canvas);
    }

    private void drawLastDivider(Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3) {
        View childAt = recyclerView.getChildAt(i3);
        int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        this.mDividerDrawable.setColorFilter(this.mCallBack.getLastColor(), PorterDuff.Mode.SRC_IN);
        this.mDividerDrawable.setBounds(i, bottom, i2, this.mCallBack.getLastHeight() + bottom);
        this.mDividerDrawable.draw(canvas);
    }

    private void drawPaddingDivider(Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3, int i4) {
        View childAt = recyclerView.getChildAt(i3);
        int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        this.mEdgeDrawable.setBounds(i, bottom, i2, this.mCallBack.getDividerHeight(i4) + bottom);
        this.mEdgeDrawable.draw(canvas);
    }

    private void drawMainDivider(Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3, int i4) {
        View childAt = recyclerView.getChildAt(i3);
        int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        this.mDividerDrawable.setBounds(i, bottom, i2, this.mCallBack.getDividerHeight(i4) + bottom);
        this.mDividerDrawable.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition <= this.mCallBack.getItemCount() - 1) {
            rect.set(0, 0, 0, this.mCallBack.getDividerHeight(childLayoutPosition));
        }
        if (isFirstPosition(view, recyclerView)) {
            rect.top = this.mCallBack.getFirstHeight();
        }
        if (isLastPosition(view, recyclerView)) {
            rect.bottom = this.mCallBack.getLastHeight();
        }
    }

    public static abstract class SimpleCallBack implements CallBack {
        public int m12dp = DisplayUtils.dp2px(this.mContext, 12.0f);
        public int m16dp = DisplayUtils.dp2px(this.mContext, 16.0f);
        public int m1dp;
        public int m8dp = DisplayUtils.dp2px(this.mContext, 8.0f);
        private AppTheme mAppTheme = AppHolder.getAppTheme();
        private Context mContext;

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getFirstHeight() {
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getLastHeight() {
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getPaddingLeft() {
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getPaddingRight() {
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public boolean hasPadding(int i) {
            return false;
        }

        public SimpleCallBack(Context context) {
            this.mContext = context;
            this.m1dp = DisplayUtils.dp2px(context, 0.5f);
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getCurrencyColor() {
            return AppHolder.getAppTheme().getCurrencyColorDivider();
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public boolean isThinnestDivider(int i) {
            return getDividerHeight(i) == this.m1dp;
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getLastColor() {
            return this.mAppTheme.getContentBackgroundDividerColor();
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getFirstColor() {
            return this.mAppTheme.getContentBackgroundDividerColor();
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getEdgeColor() {
            return this.mAppTheme.getContentBackgroundColor();
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getDividerColor() {
            return this.mAppTheme.getContentBackgroundDividerColor();
        }

        @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
        public int getDividerHeight(int i) {
            return this.m1dp;
        }
    }
}
