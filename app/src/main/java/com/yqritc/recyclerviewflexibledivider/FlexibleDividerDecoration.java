package com.yqritc.recyclerviewflexibledivider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FlexibleDividerDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {16843284};
    private static final int DEFAULT_SIZE = 2;
    protected ColorProvider mColorProvider;
    protected DividerType mDividerType = DividerType.DRAWABLE;
    protected DrawableProvider mDrawableProvider;
    private Paint mPaint;
    protected PaintProvider mPaintProvider;
    protected boolean mPositionInsideItem;
    protected boolean mShowLastDivider;
    protected SizeProvider mSizeProvider;
    protected VisibilityProvider mVisibilityProvider;

    public interface ColorProvider {
        int dividerColor(int i, RecyclerView recyclerView);
    }

    protected enum DividerType {
        DRAWABLE,
        PAINT,
        COLOR
    }

    public interface DrawableProvider {
        Drawable drawableProvider(int i, RecyclerView recyclerView);
    }

    public interface PaintProvider {
        Paint dividerPaint(int i, RecyclerView recyclerView);
    }

    public interface SizeProvider {
        int dividerSize(int i, RecyclerView recyclerView);
    }

    public interface VisibilityProvider {
        boolean shouldHideDivider(int i, RecyclerView recyclerView);
    }

    protected abstract Rect getDividerBound(int i, RecyclerView recyclerView, View view);

    protected abstract void setItemOffsets(Rect rect, int i, RecyclerView recyclerView);

    protected FlexibleDividerDecoration(Builder builder) {
        if (builder.mPaintProvider != null) {
            this.mDividerType = DividerType.PAINT;
            this.mPaintProvider = builder.mPaintProvider;
        } else if (builder.mColorProvider != null) {
            this.mDividerType = DividerType.COLOR;
            this.mColorProvider = builder.mColorProvider;
            this.mPaint = new Paint();
            setSizeProvider(builder);
        } else {
            this.mDividerType = DividerType.DRAWABLE;
            if (builder.mDrawableProvider == null) {
                TypedArray obtainStyledAttributes = builder.mContext.obtainStyledAttributes(ATTRS);
                final Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                this.mDrawableProvider = new DrawableProvider() {
                    /* class com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.AnonymousClass1 */

                    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.DrawableProvider
                    public Drawable drawableProvider(int i, RecyclerView recyclerView) {
                        return drawable;
                    }
                };
            } else {
                this.mDrawableProvider = builder.mDrawableProvider;
            }
            this.mSizeProvider = builder.mSizeProvider;
        }
        this.mVisibilityProvider = builder.mVisibilityProvider;
        this.mShowLastDivider = builder.mShowLastDivider;
        this.mPositionInsideItem = builder.mPositionInsideItem;
    }

    private void setSizeProvider(Builder builder) {
        SizeProvider sizeProvider = builder.mSizeProvider;
        this.mSizeProvider = sizeProvider;
        if (sizeProvider == null) {
            this.mSizeProvider = new SizeProvider() {
                /* class com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.AnonymousClass2 */

                @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.SizeProvider
                public int dividerSize(int i, RecyclerView recyclerView) {
                    return 2;
                }
            };
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            int lastDividerOffset = getLastDividerOffset(recyclerView);
            int childCount = recyclerView.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition >= i) {
                    if ((this.mShowLastDivider || childAdapterPosition < itemCount - lastDividerOffset) && !wasDividerAlreadyDrawn(childAdapterPosition, recyclerView)) {
                        int groupIndex = getGroupIndex(childAdapterPosition, recyclerView);
                        if (!this.mVisibilityProvider.shouldHideDivider(groupIndex, recyclerView)) {
                            Rect dividerBound = getDividerBound(groupIndex, recyclerView, childAt);
                            int i3 = AnonymousClass3.$SwitchMap$com$yqritc$recyclerviewflexibledivider$FlexibleDividerDecoration$DividerType[this.mDividerType.ordinal()];
                            if (i3 == 1) {
                                Drawable drawableProvider = this.mDrawableProvider.drawableProvider(groupIndex, recyclerView);
                                drawableProvider.setBounds(dividerBound);
                                drawableProvider.draw(canvas);
                            } else if (i3 == 2) {
                                this.mPaint = this.mPaintProvider.dividerPaint(groupIndex, recyclerView);
                                canvas.drawLine((float) dividerBound.left, (float) dividerBound.top, (float) dividerBound.right, (float) dividerBound.bottom, this.mPaint);
                            } else if (i3 == 3) {
                                this.mPaint.setColor(this.mColorProvider.dividerColor(groupIndex, recyclerView));
                                this.mPaint.setStrokeWidth((float) this.mSizeProvider.dividerSize(groupIndex, recyclerView));
                                canvas.drawLine((float) dividerBound.left, (float) dividerBound.top, (float) dividerBound.right, (float) dividerBound.bottom, this.mPaint);
                            }
                        }
                    }
                    i = childAdapterPosition;
                }
            }
        }
    }

    /* renamed from: com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$yqritc$recyclerviewflexibledivider$FlexibleDividerDecoration$DividerType;

        static {
            int[] iArr = new int[DividerType.values().length];
            $SwitchMap$com$yqritc$recyclerviewflexibledivider$FlexibleDividerDecoration$DividerType = iArr;
            try {
                iArr[DividerType.DRAWABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yqritc$recyclerviewflexibledivider$FlexibleDividerDecoration$DividerType[DividerType.PAINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yqritc$recyclerviewflexibledivider$FlexibleDividerDecoration$DividerType[DividerType.COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int lastDividerOffset = getLastDividerOffset(recyclerView);
        if (this.mShowLastDivider || childAdapterPosition < itemCount - lastDividerOffset) {
            int groupIndex = getGroupIndex(childAdapterPosition, recyclerView);
            if (!this.mVisibilityProvider.shouldHideDivider(groupIndex, recyclerView)) {
                setItemOffsets(rect, groupIndex, recyclerView);
            }
        }
    }

    protected boolean isReverseLayout(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getReverseLayout();
        }
        return false;
    }

    private int getLastDividerOffset(RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return 1;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
        int spanCount = gridLayoutManager.getSpanCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i = itemCount - 1; i >= 0; i--) {
            if (spanSizeLookup.getSpanIndex(i, spanCount) == 0) {
                return itemCount - i;
            }
        }
        return 1;
    }

    private boolean wasDividerAlreadyDrawn(int i, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return false;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (gridLayoutManager.getSpanSizeLookup().getSpanIndex(i, gridLayoutManager.getSpanCount()) > 0) {
            return true;
        }
        return false;
    }

    private int getGroupIndex(int i, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return i;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        return gridLayoutManager.getSpanSizeLookup().getSpanGroupIndex(i, gridLayoutManager.getSpanCount());
    }

    public static class Builder<T extends Builder> {
        private ColorProvider mColorProvider;
        private Context mContext;
        private DrawableProvider mDrawableProvider;
        private PaintProvider mPaintProvider;
        private boolean mPositionInsideItem = false;
        protected Resources mResources;
        private boolean mShowLastDivider = false;
        private SizeProvider mSizeProvider;
        private VisibilityProvider mVisibilityProvider = new VisibilityProvider() {
            /* class com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.Builder.AnonymousClass1 */

            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.VisibilityProvider
            public boolean shouldHideDivider(int i, RecyclerView recyclerView) {
                return false;
            }
        };

        public Builder(Context context) {
            this.mContext = context;
            this.mResources = context.getResources();
        }

        public T paint(final Paint paint) {
            return paintProvider(new PaintProvider() {
                /* class com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.Builder.AnonymousClass2 */

                @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.PaintProvider
                public Paint dividerPaint(int i, RecyclerView recyclerView) {
                    return paint;
                }
            });
        }

        public T paintProvider(PaintProvider paintProvider) {
            this.mPaintProvider = paintProvider;
            return this;
        }

        public T color(final int i) {
            return colorProvider(new ColorProvider() {
                /* class com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.Builder.AnonymousClass3 */

                @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.ColorProvider
                public int dividerColor(int i, RecyclerView recyclerView) {
                    return i;
                }
            });
        }

        public T colorResId(int i) {
            return color(ContextCompat.getColor(this.mContext, i));
        }

        public T colorProvider(ColorProvider colorProvider) {
            this.mColorProvider = colorProvider;
            return this;
        }

        public T drawable(int i) {
            return drawable(ContextCompat.getDrawable(this.mContext, i));
        }

        public T drawable(final Drawable drawable) {
            return drawableProvider(new DrawableProvider() {
                /* class com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.Builder.AnonymousClass4 */

                @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.DrawableProvider
                public Drawable drawableProvider(int i, RecyclerView recyclerView) {
                    return drawable;
                }
            });
        }

        public T drawableProvider(DrawableProvider drawableProvider) {
            this.mDrawableProvider = drawableProvider;
            return this;
        }

        public T size(final int i) {
            return sizeProvider(new SizeProvider() {
                /* class com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.Builder.AnonymousClass5 */

                @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.SizeProvider
                public int dividerSize(int i, RecyclerView recyclerView) {
                    return i;
                }
            });
        }

        public T sizeResId(int i) {
            return size(this.mResources.getDimensionPixelSize(i));
        }

        public T sizeProvider(SizeProvider sizeProvider) {
            this.mSizeProvider = sizeProvider;
            return this;
        }

        public T visibilityProvider(VisibilityProvider visibilityProvider) {
            this.mVisibilityProvider = visibilityProvider;
            return this;
        }

        public T showLastDivider() {
            this.mShowLastDivider = true;
            return this;
        }

        public T positionInsideItem(boolean z) {
            this.mPositionInsideItem = z;
            return this;
        }

        protected void checkBuilderParams() {
            if (this.mPaintProvider == null) {
                return;
            }
            if (this.mColorProvider != null) {
                throw new IllegalArgumentException("Use setColor method of Paint class to specify line color. Do not provider ColorProvider if you set PaintProvider.");
            } else if (this.mSizeProvider != null) {
                throw new IllegalArgumentException("Use setStrokeWidth method of Paint class to specify line size. Do not provider SizeProvider if you set PaintProvider.");
            }
        }
    }
}
