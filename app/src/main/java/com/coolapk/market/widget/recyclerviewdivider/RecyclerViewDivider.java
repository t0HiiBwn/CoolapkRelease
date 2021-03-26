package com.coolapk.market.widget.recyclerviewdivider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.recyclerviewdivider.extension.LayoutManagerExtensionsKt;
import com.coolapk.market.widget.recyclerviewdivider.extension.LayoutParamsExtensionsKt;
import com.coolapk.market.widget.recyclerviewdivider.extension.ViewExtensionsKt;
import com.coolapk.market.widget.recyclerviewdivider.manager.drawable.DefaultDrawableManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.drawable.DrawableManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.inset.DefaultInsetManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.inset.InsetManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.size.DefaultSizeManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.size.SizeManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.tint.DefaultTintManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.tint.TintManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.visibility.DefaultVisibilityManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.visibility.HideLastVisibilityManager;
import com.coolapk.market.widget.recyclerviewdivider.manager.visibility.VisibilityManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0003\u001f !B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "isSpace", "", "drawableManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/drawable/DrawableManager;", "insetManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/inset/InsetManager;", "sizeManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager;", "tintManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/tint/TintManager;", "visibilityManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager;", "(ZLcom/coolapk/market/widget/recyclerviewdivider/manager/drawable/DrawableManager;Lcom/coolapk/market/widget/recyclerviewdivider/manager/inset/InsetManager;Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager;Lcom/coolapk/market/widget/recyclerviewdivider/manager/tint/TintManager;Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager;)V", "addTo", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "removeFrom", "Builder", "BuilderProvider", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecyclerViewDivider.kt */
public final class RecyclerViewDivider extends RecyclerView.ItemDecoration {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = RecyclerViewDivider.class.getSimpleName();
    private final DrawableManager drawableManager;
    private final InsetManager insetManager;
    private final boolean isSpace;
    private final SizeManager sizeManager;
    private final TintManager tintManager;
    private final VisibilityManager visibilityManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider$BuilderProvider;", "", "provideDividerBuilder", "Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider$Builder;", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecyclerViewDivider.kt */
    public interface BuilderProvider {
        Builder provideDividerBuilder(Context context);
    }

    @JvmStatic
    public static final Builder with(Context context) {
        return Companion.with(context);
    }

    public RecyclerViewDivider(boolean z, DrawableManager drawableManager2, InsetManager insetManager2, SizeManager sizeManager2, TintManager tintManager2, VisibilityManager visibilityManager2) {
        Intrinsics.checkNotNullParameter(drawableManager2, "drawableManager");
        Intrinsics.checkNotNullParameter(insetManager2, "insetManager");
        Intrinsics.checkNotNullParameter(sizeManager2, "sizeManager");
        Intrinsics.checkNotNullParameter(visibilityManager2, "visibilityManager");
        this.isSpace = z;
        this.drawableManager = drawableManager2;
        this.insetManager = insetManager2;
        this.sizeManager = sizeManager2;
        this.tintManager = tintManager2;
        this.visibilityManager = visibilityManager2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "with", "Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider$Builder;", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecyclerViewDivider.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Builder with(Context context) {
            Builder provideDividerBuilder;
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof BuilderProvider)) {
                applicationContext = null;
            }
            BuilderProvider builderProvider = (BuilderProvider) applicationContext;
            return (builderProvider == null || (provideDividerBuilder = builderProvider.provideDividerBuilder(context)) == null) ? new Builder(context) : provideDividerBuilder;
        }
    }

    public final void addTo(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        removeFrom(recyclerView);
        recyclerView.addItemDecoration(this);
    }

    public final void removeFrom(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.removeItemDecoration(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager;
        int groupCount;
        int groupIndex;
        VisibilityManager.VisibilityType itemVisibility;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int i = 0;
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (itemCount > 0 && (layoutManager = recyclerView.getLayoutManager()) != null) {
            Intrinsics.checkNotNullExpressionValue(layoutManager, "parent.layoutManager ?: return");
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition != -1 && (itemVisibility = this.visibilityManager.itemVisibility((groupCount = LayoutManagerExtensionsKt.getGroupCount(layoutManager, itemCount)), (groupIndex = LayoutManagerExtensionsKt.getGroupIndex(layoutManager, childAdapterPosition)))) != VisibilityManager.VisibilityType.NONE) {
                int orientation = LayoutManagerExtensionsKt.getOrientation(layoutManager);
                int spanCount = LayoutManagerExtensionsKt.getSpanCount(layoutManager);
                int spanSize = LayoutManagerExtensionsKt.getSpanSize(layoutManager, childAdapterPosition);
                int accumulatedSpanInLine = LayoutManagerExtensionsKt.getAccumulatedSpanInLine(layoutManager, spanSize, childAdapterPosition, groupIndex);
                SizeManager.SizeCompat itemSize = this.sizeManager.itemSize(this.drawableManager.itemDrawable(groupCount, groupIndex), orientation, groupCount, groupIndex);
                int size = itemSize.getSize();
                int i2 = size / 2;
                if (itemVisibility == VisibilityManager.VisibilityType.ITEMS_ONLY) {
                    size = 0;
                }
                if (itemVisibility != VisibilityManager.VisibilityType.GROUP_ONLY) {
                    i = i2;
                }
                RecyclerViewDivider$getItemOffsets$setRect$1 recyclerViewDivider$getItemOffsets$setRect$1 = new RecyclerViewDivider$getItemOffsets$setRect$1(ViewExtensionsKt.isRTL(recyclerView), rect);
                if (orientation == 1) {
                    if (spanCount == 1 || spanSize == spanCount) {
                        recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) 0, 0, 0, (int) Integer.valueOf(size));
                    } else if (accumulatedSpanInLine == spanSize) {
                        recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) Integer.valueOf(itemSize.getFirstMarginInGroup()), (Integer) 0, (int) Integer.valueOf(i), Integer.valueOf(size));
                    } else if (accumulatedSpanInLine == spanCount) {
                        recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) Integer.valueOf(i), (Integer) 0, (int) Integer.valueOf(itemSize.getLastMarginInGroup()), Integer.valueOf(size));
                    } else {
                        recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) Integer.valueOf(i), (Integer) 0, (int) Integer.valueOf(i), Integer.valueOf(size));
                    }
                } else if (spanCount == 1 || spanSize == spanCount) {
                    recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) 0, 0, (int) Integer.valueOf(size), (Integer) 0);
                } else if (accumulatedSpanInLine == spanSize) {
                    recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) 0, (int) Integer.valueOf(itemSize.getFirstMarginInGroup()), Integer.valueOf(size), Integer.valueOf(i));
                } else if (accumulatedSpanInLine == spanCount) {
                    recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) 0, (int) Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(itemSize.getLastMarginInGroup()));
                } else {
                    recyclerViewDivider$getItemOffsets$setRect$1.invoke((RecyclerViewDivider$getItemOffsets$setRect$1) 0, (int) Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(i));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02ff  */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        RecyclerView.LayoutManager layoutManager;
        int i5;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Ref.IntRef intRef3;
        Ref.IntRef intRef4;
        int i6;
        int i7;
        int i8;
        RecyclerViewDivider$onDraw$drawWithBounds$1 recyclerViewDivider$onDraw$drawWithBounds$1;
        Ref.IntRef intRef5;
        Ref.IntRef intRef6;
        Ref.IntRef intRef7;
        int i9;
        RecyclerViewDivider recyclerViewDivider = this;
        Canvas canvas2 = canvas;
        RecyclerView recyclerView2 = recyclerView;
        Intrinsics.checkNotNullParameter(canvas2, "c");
        Intrinsics.checkNotNullParameter(recyclerView2, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (!recyclerViewDivider.isSpace && itemCount != 0) {
            Ref.IntRef intRef8 = new Ref.IntRef();
            Ref.IntRef intRef9 = new Ref.IntRef();
            Ref.IntRef intRef10 = new Ref.IntRef();
            Ref.IntRef intRef11 = new Ref.IntRef();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 != null) {
                Intrinsics.checkNotNullExpressionValue(layoutManager2, "parent.layoutManager ?: return");
                int orientation = LayoutManagerExtensionsKt.getOrientation(layoutManager2);
                int spanCount = LayoutManagerExtensionsKt.getSpanCount(layoutManager2);
                int childCount = recyclerView.getChildCount();
                int groupCount = LayoutManagerExtensionsKt.getGroupCount(layoutManager2, itemCount);
                boolean isRTL = ViewExtensionsKt.isRTL(recyclerView2);
                int i10 = 0;
                while (i10 < childCount) {
                    View childAt = recyclerView2.getChildAt(i10);
                    int childAdapterPosition = recyclerView2.getChildAdapterPosition(childAt);
                    if (childAdapterPosition != -1) {
                        int groupIndex = LayoutManagerExtensionsKt.getGroupIndex(layoutManager2, childAdapterPosition);
                        VisibilityManager.VisibilityType itemVisibility = recyclerViewDivider.visibilityManager.itemVisibility(groupCount, groupIndex);
                        if (itemVisibility == VisibilityManager.VisibilityType.NONE) {
                            i = itemCount;
                            i3 = groupCount;
                            i2 = orientation;
                            layoutManager = layoutManager2;
                            intRef3 = intRef11;
                            intRef = intRef10;
                            intRef4 = intRef9;
                            i4 = i10;
                            i5 = spanCount;
                            intRef2 = intRef8;
                        } else {
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            objectRef.element = (T) recyclerViewDivider.drawableManager.itemDrawable(groupCount, groupIndex);
                            int size = recyclerViewDivider.sizeManager.itemSize(objectRef.element, orientation, groupCount, groupIndex).getSize();
                            int spanSize = LayoutManagerExtensionsKt.getSpanSize(layoutManager2, childAdapterPosition);
                            int accumulatedSpanInLine = LayoutManagerExtensionsKt.getAccumulatedSpanInLine(layoutManager2, spanSize, childAdapterPosition, groupIndex);
                            layoutManager = layoutManager2;
                            int itemInsetBefore = recyclerViewDivider.insetManager.itemInsetBefore(groupCount, groupIndex);
                            int itemInsetAfter = recyclerViewDivider.insetManager.itemInsetAfter(groupCount, groupIndex);
                            if (spanCount <= 1 || (itemInsetBefore <= 0 && itemInsetAfter <= 0)) {
                                i7 = itemInsetBefore;
                                i6 = itemInsetAfter;
                            } else {
                                Log.e(TAG, "the inset won't be applied with a span major than 1.");
                                i7 = 0;
                                i6 = 0;
                            }
                            TintManager tintManager2 = recyclerViewDivider.tintManager;
                            if (tintManager2 != null) {
                                int itemTint = tintManager2.itemTint(groupCount, groupIndex);
                                T t = (T) DrawableCompat.wrap(objectRef.element);
                                DrawableCompat.setTint(t, itemTint);
                                Intrinsics.checkNotNullExpressionValue(t, "wrappedDrawable");
                                objectRef.element = t;
                            }
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                            RecyclerView.LayoutParams layoutParams3 = layoutParams2;
                            int startMarginCompat = LayoutParamsExtensionsKt.getStartMarginCompat(layoutParams3);
                            int i11 = layoutParams2.topMargin;
                            int endMarginCompat = LayoutParamsExtensionsKt.getEndMarginCompat(layoutParams3);
                            int i12 = layoutParams2.bottomMargin;
                            if (size < 2) {
                                i8 = size;
                            } else {
                                i8 = size / 2;
                            }
                            if (itemVisibility == VisibilityManager.VisibilityType.ITEMS_ONLY) {
                                size = 0;
                            }
                            if (itemVisibility == VisibilityManager.VisibilityType.GROUP_ONLY) {
                                i8 = 0;
                            }
                            int bottom = childAt.getBottom();
                            int top = childAt.getTop();
                            int right = childAt.getRight();
                            int left = childAt.getLeft();
                            if (childAdapterPosition == itemCount - 1) {
                                i8 *= 2;
                            }
                            RecyclerViewDivider$onDraw$drawWithBounds$1 recyclerViewDivider$onDraw$drawWithBounds$12 = new RecyclerViewDivider$onDraw$drawWithBounds$1(objectRef, canvas2);
                            if (orientation == 1) {
                                if (spanCount <= 1 || spanSize >= spanCount) {
                                    i = itemCount;
                                    i3 = groupCount;
                                    i9 = spanCount;
                                    i2 = orientation;
                                    recyclerViewDivider$onDraw$drawWithBounds$1 = recyclerViewDivider$onDraw$drawWithBounds$12;
                                    intRef5 = intRef10;
                                    intRef6 = intRef11;
                                    intRef7 = intRef9;
                                    i4 = i10;
                                } else {
                                    intRef9.element = top - i11;
                                    intRef11.element = bottom + i12 + size;
                                    i4 = i10;
                                    i3 = groupCount;
                                    i9 = spanCount;
                                    i2 = orientation;
                                    i = itemCount;
                                    intRef6 = intRef11;
                                    intRef5 = intRef10;
                                    recyclerViewDivider$onDraw$drawWithBounds$1 = recyclerViewDivider$onDraw$drawWithBounds$12;
                                    intRef7 = intRef9;
                                    RecyclerViewDivider$onDraw$partialDrawAfter$1 recyclerViewDivider$onDraw$partialDrawAfter$1 = new RecyclerViewDivider$onDraw$partialDrawAfter$1(isRTL, intRef10, left, endMarginCompat, intRef8, i8, right, recyclerViewDivider$onDraw$drawWithBounds$12, intRef7, intRef6);
                                    RecyclerViewDivider$onDraw$partialDrawBefore$1 recyclerViewDivider$onDraw$partialDrawBefore$1 = new RecyclerViewDivider$onDraw$partialDrawBefore$1(isRTL, intRef5, right, startMarginCompat, intRef8, i8, left, recyclerViewDivider$onDraw$drawWithBounds$1, intRef7, intRef6);
                                    if (accumulatedSpanInLine == spanSize) {
                                        recyclerViewDivider$onDraw$partialDrawAfter$1.invoke();
                                    } else if (accumulatedSpanInLine == i9) {
                                        recyclerViewDivider$onDraw$partialDrawBefore$1.invoke();
                                    } else {
                                        recyclerViewDivider$onDraw$partialDrawBefore$1.invoke();
                                        recyclerViewDivider$onDraw$partialDrawAfter$1.invoke();
                                    }
                                }
                                intRef4 = intRef7;
                                intRef4.element = bottom + i12;
                                intRef3 = intRef6;
                                intRef3.element = intRef4.element + size;
                                if (isRTL) {
                                    intRef2 = intRef8;
                                    intRef2.element = (left + i6) - endMarginCompat;
                                    intRef = intRef5;
                                    intRef.element = (right - i7) + startMarginCompat;
                                } else {
                                    intRef2 = intRef8;
                                    intRef = intRef5;
                                    intRef2.element = (left + i7) - startMarginCompat;
                                    intRef.element = (right - i6) + endMarginCompat;
                                }
                                recyclerViewDivider$onDraw$drawWithBounds$1.invoke((RecyclerViewDivider$onDraw$drawWithBounds$1) Integer.valueOf(intRef2.element), Integer.valueOf(intRef4.element), Integer.valueOf(intRef.element), Integer.valueOf(intRef3.element));
                                canvas2 = canvas;
                                i5 = i9;
                            } else {
                                i = itemCount;
                                i3 = groupCount;
                                i2 = orientation;
                                intRef2 = intRef8;
                                intRef = intRef10;
                                intRef3 = intRef11;
                                intRef4 = intRef9;
                                i4 = i10;
                                if (spanCount > 1 && spanSize < spanCount) {
                                    if (isRTL) {
                                        intRef2.element = (left - endMarginCompat) - size;
                                        intRef.element = right + startMarginCompat;
                                    } else {
                                        intRef2.element = left - startMarginCompat;
                                        intRef.element = right + endMarginCompat + size;
                                    }
                                    if (accumulatedSpanInLine == spanSize) {
                                        intRef4.element = bottom + i12;
                                        intRef3.element = intRef4.element + i8;
                                        recyclerViewDivider$onDraw$drawWithBounds$12.invoke((RecyclerViewDivider$onDraw$drawWithBounds$1) Integer.valueOf(intRef2.element), Integer.valueOf(intRef4.element), Integer.valueOf(intRef.element), Integer.valueOf(intRef3.element));
                                    } else if (accumulatedSpanInLine == spanCount) {
                                        intRef3.element = top - i11;
                                        intRef4.element = intRef3.element - i8;
                                        recyclerViewDivider$onDraw$drawWithBounds$12.invoke((RecyclerViewDivider$onDraw$drawWithBounds$1) Integer.valueOf(intRef2.element), Integer.valueOf(intRef4.element), Integer.valueOf(intRef.element), Integer.valueOf(intRef3.element));
                                    } else {
                                        intRef3.element = top - i11;
                                        intRef4.element = intRef3.element - i8;
                                        i5 = spanCount;
                                        objectRef.element.setBounds(intRef2.element, intRef4.element, intRef.element, intRef3.element);
                                        canvas2 = canvas;
                                        objectRef.element.draw(canvas2);
                                        intRef4.element = bottom + i12;
                                        intRef3.element = intRef4.element + i8;
                                        recyclerViewDivider$onDraw$drawWithBounds$12.invoke((RecyclerViewDivider$onDraw$drawWithBounds$1) Integer.valueOf(intRef2.element), Integer.valueOf(intRef4.element), Integer.valueOf(intRef.element), Integer.valueOf(intRef3.element));
                                        intRef3.element = (bottom - i6) + i12;
                                        intRef4.element = (top + i7) - i11;
                                        if (!isRTL) {
                                            intRef2.element = left - endMarginCompat;
                                            intRef.element = intRef2.element - size;
                                        } else {
                                            intRef2.element = right + endMarginCompat;
                                            intRef.element = intRef2.element + size;
                                        }
                                        recyclerViewDivider$onDraw$drawWithBounds$12.invoke((RecyclerViewDivider$onDraw$drawWithBounds$1) Integer.valueOf(intRef2.element), Integer.valueOf(intRef4.element), Integer.valueOf(intRef.element), Integer.valueOf(intRef3.element));
                                    }
                                }
                                canvas2 = canvas;
                                i5 = spanCount;
                                intRef3.element = (bottom - i6) + i12;
                                intRef4.element = (top + i7) - i11;
                                if (!isRTL) {
                                }
                                recyclerViewDivider$onDraw$drawWithBounds$12.invoke((RecyclerViewDivider$onDraw$drawWithBounds$1) Integer.valueOf(intRef2.element), Integer.valueOf(intRef4.element), Integer.valueOf(intRef.element), Integer.valueOf(intRef3.element));
                            }
                        }
                        i10 = i4 + 1;
                        recyclerViewDivider = this;
                        recyclerView2 = recyclerView;
                        intRef9 = intRef4;
                        intRef11 = intRef3;
                        intRef8 = intRef2;
                        intRef10 = intRef;
                        spanCount = i5;
                        childCount = childCount;
                        layoutManager2 = layoutManager;
                        groupCount = i3;
                        orientation = i2;
                        itemCount = i;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0000J\u001a\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u001a\u001a\u00020\u00152\b\b\u0001\u0010\u001b\u001a\u00020\u0015J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\u0015J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawableManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/drawable/DrawableManager;", "insetManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/inset/InsetManager;", "isSpace", "", "sizeManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager;", "tintManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/tint/TintManager;", "visibilityManager", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/visibility/VisibilityManager;", "asSpace", "build", "Lcom/coolapk/market/widget/recyclerviewdivider/RecyclerViewDivider;", "color", "", "drawable", "Landroid/graphics/drawable/Drawable;", "hideLastDivider", "inset", "insetBefore", "insetAfter", "size", "tint", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecyclerViewDivider.kt */
    public static final class Builder {
        private final Context context;
        private DrawableManager drawableManager;
        private InsetManager insetManager;
        private boolean isSpace;
        private SizeManager sizeManager;
        private TintManager tintManager;
        private VisibilityManager visibilityManager;

        public Builder(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
        }

        public final Builder asSpace() {
            Builder builder = this;
            builder.isSpace = true;
            return builder;
        }

        public final Builder color(int i) {
            return drawable(new ColorDrawable(i));
        }

        public final Builder drawable(Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            return drawableManager(new DefaultDrawableManager(drawable));
        }

        public final Builder hideLastDivider() {
            return visibilityManager(new HideLastVisibilityManager());
        }

        public final Builder inset(int i, int i2) {
            return insetManager(new DefaultInsetManager(i, i2));
        }

        public final Builder size(int i) {
            return sizeManager(new DefaultSizeManager(i));
        }

        public final Builder tint(int i) {
            return tintManager(new DefaultTintManager(i));
        }

        public final Builder drawableManager(DrawableManager drawableManager2) {
            Intrinsics.checkNotNullParameter(drawableManager2, "drawableManager");
            Builder builder = this;
            builder.drawableManager = drawableManager2;
            builder.isSpace = false;
            return builder;
        }

        public final Builder insetManager(InsetManager insetManager2) {
            Intrinsics.checkNotNullParameter(insetManager2, "insetManager");
            Builder builder = this;
            builder.insetManager = insetManager2;
            return builder;
        }

        public final Builder sizeManager(SizeManager sizeManager2) {
            Intrinsics.checkNotNullParameter(sizeManager2, "sizeManager");
            Builder builder = this;
            builder.sizeManager = sizeManager2;
            return builder;
        }

        public final Builder tintManager(TintManager tintManager2) {
            Intrinsics.checkNotNullParameter(tintManager2, "tintManager");
            Builder builder = this;
            builder.tintManager = tintManager2;
            return builder;
        }

        public final Builder visibilityManager(VisibilityManager visibilityManager2) {
            Intrinsics.checkNotNullParameter(visibilityManager2, "visibilityManager");
            Builder builder = this;
            builder.visibilityManager = visibilityManager2;
            return builder;
        }

        public final RecyclerViewDivider build() {
            DefaultDrawableManager defaultDrawableManager = this.drawableManager;
            if (defaultDrawableManager == null) {
                defaultDrawableManager = new DefaultDrawableManager();
            }
            DefaultInsetManager defaultInsetManager = this.insetManager;
            if (defaultInsetManager == null) {
                defaultInsetManager = new DefaultInsetManager();
            }
            DefaultSizeManager defaultSizeManager = this.sizeManager;
            if (defaultSizeManager == null) {
                defaultSizeManager = new DefaultSizeManager(this.context);
            }
            DefaultVisibilityManager defaultVisibilityManager = this.visibilityManager;
            if (defaultVisibilityManager == null) {
                defaultVisibilityManager = new DefaultVisibilityManager();
            }
            return new RecyclerViewDivider(this.isSpace, defaultDrawableManager, defaultInsetManager, defaultSizeManager, this.tintManager, defaultVisibilityManager);
        }
    }
}
