package com.yqritc.recyclerviewflexibledivider;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration;

public class HorizontalDividerItemDecoration extends FlexibleDividerDecoration {
    private MarginProvider mMarginProvider;

    public interface MarginProvider {
        int dividerLeftMargin(int i, RecyclerView recyclerView);

        int dividerRightMargin(int i, RecyclerView recyclerView);
    }

    protected HorizontalDividerItemDecoration(Builder builder) {
        super(builder);
        this.mMarginProvider = builder.mMarginProvider;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    protected Rect getDividerBound(int i, RecyclerView recyclerView, View view) {
        Rect rect = new Rect(0, 0, 0, 0);
        int translationX = (int) ViewCompat.getTranslationX(view);
        int translationY = (int) ViewCompat.getTranslationY(view);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        rect.left = recyclerView.getPaddingLeft() + this.mMarginProvider.dividerLeftMargin(i, recyclerView) + translationX;
        rect.right = ((recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.mMarginProvider.dividerRightMargin(i, recyclerView)) + translationX;
        int dividerSize = getDividerSize(i, recyclerView);
        boolean isReverseLayout = isReverseLayout(recyclerView);
        if (this.mDividerType != FlexibleDividerDecoration.DividerType.DRAWABLE) {
            int i2 = dividerSize / 2;
            if (isReverseLayout) {
                rect.top = ((view.getTop() - layoutParams.topMargin) - i2) + translationY;
            } else {
                rect.top = view.getBottom() + layoutParams.bottomMargin + i2 + translationY;
            }
            rect.bottom = rect.top;
        } else if (isReverseLayout) {
            rect.bottom = (view.getTop() - layoutParams.topMargin) + translationY;
            rect.top = rect.bottom - dividerSize;
        } else {
            rect.top = view.getBottom() + layoutParams.bottomMargin + translationY;
            rect.bottom = rect.top + dividerSize;
        }
        if (this.mPositionInsideItem) {
            if (isReverseLayout) {
                rect.top += dividerSize;
                rect.bottom += dividerSize;
            } else {
                rect.top -= dividerSize;
                rect.bottom -= dividerSize;
            }
        }
        return rect;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    protected void setItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        if (this.mPositionInsideItem) {
            rect.set(0, 0, 0, 0);
        } else if (isReverseLayout(recyclerView)) {
            rect.set(0, getDividerSize(i, recyclerView), 0, 0);
        } else {
            rect.set(0, 0, 0, getDividerSize(i, recyclerView));
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
            return this.mDrawableProvider.drawableProvider(i, recyclerView).getIntrinsicHeight();
        }
        throw new RuntimeException("failed to get size");
    }

    public static class Builder extends FlexibleDividerDecoration.Builder<Builder> {
        private MarginProvider mMarginProvider = new MarginProvider() {
            /* class com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration.Builder.AnonymousClass1 */

            @Override // com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration.MarginProvider
            public int dividerLeftMargin(int i, RecyclerView recyclerView) {
                return 0;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration.MarginProvider
            public int dividerRightMargin(int i, RecyclerView recyclerView) {
                return 0;
            }
        };

        public Builder(Context context) {
            super(context);
        }

        public Builder margin(final int i, final int i2) {
            return marginProvider(new MarginProvider() {
                /* class com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration.Builder.AnonymousClass2 */

                @Override // com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration.MarginProvider
                public int dividerLeftMargin(int i, RecyclerView recyclerView) {
                    return i;
                }

                @Override // com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration.MarginProvider
                public int dividerRightMargin(int i, RecyclerView recyclerView) {
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

        public HorizontalDividerItemDecoration build() {
            checkBuilderParams();
            return new HorizontalDividerItemDecoration(this);
        }
    }
}
