package com.yqritc.recyclerviewflexibledivider;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration;

public class VerticalDividerItemDecoration extends FlexibleDividerDecoration {
    private MarginProvider mMarginProvider;

    public interface MarginProvider {
        int dividerBottomMargin(int i, RecyclerView recyclerView);

        int dividerTopMargin(int i, RecyclerView recyclerView);
    }

    protected VerticalDividerItemDecoration(Builder builder) {
        super(builder);
        this.mMarginProvider = builder.mMarginProvider;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    protected Rect getDividerBound(int i, RecyclerView recyclerView, View view) {
        Rect rect = new Rect(0, 0, 0, 0);
        int translationX = (int) ViewCompat.getTranslationX(view);
        int translationY = (int) ViewCompat.getTranslationY(view);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        rect.top = recyclerView.getPaddingTop() + this.mMarginProvider.dividerTopMargin(i, recyclerView) + translationY;
        rect.bottom = ((recyclerView.getHeight() - recyclerView.getPaddingBottom()) - this.mMarginProvider.dividerBottomMargin(i, recyclerView)) + translationY;
        int dividerSize = getDividerSize(i, recyclerView);
        boolean isReverseLayout = isReverseLayout(recyclerView);
        if (this.mDividerType != FlexibleDividerDecoration.DividerType.DRAWABLE) {
            int i2 = dividerSize / 2;
            if (isReverseLayout) {
                rect.left = ((view.getLeft() - layoutParams.leftMargin) - i2) + translationX;
            } else {
                rect.left = view.getRight() + layoutParams.rightMargin + i2 + translationX;
            }
            rect.right = rect.left;
        } else if (isReverseLayout) {
            rect.right = (view.getLeft() - layoutParams.leftMargin) + translationX;
            rect.left = rect.right - dividerSize;
        } else {
            rect.left = view.getRight() + layoutParams.rightMargin + translationX;
            rect.right = rect.left + dividerSize;
        }
        if (this.mPositionInsideItem) {
            if (isReverseLayout) {
                rect.left += dividerSize;
                rect.right += dividerSize;
            } else {
                rect.left -= dividerSize;
                rect.right -= dividerSize;
            }
        }
        return rect;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    protected void setItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        if (this.mPositionInsideItem) {
            rect.set(0, 0, 0, 0);
        } else if (isReverseLayout(recyclerView)) {
            rect.set(getDividerSize(i, recyclerView), 0, 0, 0);
        } else {
            rect.set(0, 0, getDividerSize(i, recyclerView), 0);
        }
    }

    private int getDividerSize(int i, RecyclerView recyclerView) {
        if (this.mPaintProvider != null) {
            return (int) this.mPaintProvider.dividerPaint(i, recyclerView).getStrokeWidth();
        }
        if (this.mSizeProvider != null) {
            return this.mSizeProvider.dividerSize(i, recyclerView);
        }
        if (this.mDrawableProvider != null) {
            return this.mDrawableProvider.drawableProvider(i, recyclerView).getIntrinsicWidth();
        }
        throw new RuntimeException("failed to get size");
    }

    public static class Builder extends FlexibleDividerDecoration.Builder<Builder> {
        private MarginProvider mMarginProvider = new MarginProvider() {
            /* class com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration.Builder.AnonymousClass1 */

            @Override // com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration.MarginProvider
            public int dividerBottomMargin(int i, RecyclerView recyclerView) {
                return 0;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration.MarginProvider
            public int dividerTopMargin(int i, RecyclerView recyclerView) {
                return 0;
            }
        };

        public Builder(Context context) {
            super(context);
        }

        public Builder margin(final int i, final int i2) {
            return marginProvider(new MarginProvider() {
                /* class com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration.Builder.AnonymousClass2 */

                @Override // com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration.MarginProvider
                public int dividerTopMargin(int i, RecyclerView recyclerView) {
                    return i;
                }

                @Override // com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration.MarginProvider
                public int dividerBottomMargin(int i, RecyclerView recyclerView) {
                    return i2;
                }
            });
        }

        public Builder margin(int i) {
            return margin(i, i);
        }

        public Builder marginResId(int i, int i2) {
            return margin(this.mResources.getDimensionPixelSize(i), this.mResources.getDimensionPixelSize(i2));
        }

        public Builder marginResId(int i) {
            return marginResId(i, i);
        }

        public Builder marginProvider(MarginProvider marginProvider) {
            this.mMarginProvider = marginProvider;
            return this;
        }

        public VerticalDividerItemDecoration build() {
            checkBuilderParams();
            return new VerticalDividerItemDecoration(this);
        }
    }
}
