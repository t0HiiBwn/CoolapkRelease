package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemRelativeChildBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 G2\u00020\u0001:\u0003GHIB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001a\u00107\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020#H\u0002J\u0006\u0010<\u001a\u00020*J0\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u0010H\u0014J\u0018\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u0010H\u0014J\u0006\u0010F\u001a\u00020*R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u000e\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006J"}, d2 = {"Lcom/coolapk/market/widget/view/RelativeInfoView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dataItems", "", "Lcom/coolapk/market/widget/view/RelativeInfoView$RelativeItem;", "getDataItems", "()Ljava/util/List;", "setDataItems", "(Ljava/util/List;)V", "dividerHeight", "", "getDividerHeight", "()I", "setDividerHeight", "(I)V", "goodsItemBackgroundColor", "getGoodsItemBackgroundColor", "setGoodsItemBackgroundColor", "itemBackgroundColor", "getItemBackgroundColor", "setItemBackgroundColor", "itemDividerWidth", "getItemDividerWidth", "setItemDividerWidth", "maxLines", "getMaxLines", "setMaxLines", "maxLinesBackup", "moreBinding", "Lcom/coolapk/market/databinding/ItemRelativeChildBinding;", "getMoreBinding", "()Lcom/coolapk/market/databinding/ItemRelativeChildBinding;", "setMoreBinding", "(Lcom/coolapk/market/databinding/ItemRelativeChildBinding;)V", "onItemClickListener", "Lkotlin/Function1;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "showMoreView", "", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "getViewPartPool", "()Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "setViewPartPool", "(Lcom/coolapk/market/widget/hotplug/ViewPartPool;)V", "bindChildViewPart", "cachedViewPart", "Lcom/coolapk/market/widget/view/RelativeInfoView$RelateInfoChildViewPart;", "data", "createMoreItemView", "notifyDataSetChange", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "toggleMaxLine", "Companion", "RelateInfoChildViewPart", "RelativeItem", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RelativeInfoView.kt */
public final class RelativeInfoView extends ViewGroup {
    public static final Companion Companion = new Companion(null);
    private static final int minAcceptedWidth = NumberExtendsKt.getDp((Number) 56);
    private static final RelativeItem moreItem = new RelativeItem("", String.valueOf(2131231435), null, false, false, null, 60, null);
    private List<RelativeItem> dataItems;
    private int dividerHeight = ConvertUtils.dp2px(8.0f);
    private int goodsItemBackgroundColor = ResourceUtils.getColorInt(getContext(), 2131099705);
    private int itemBackgroundColor = ResourceUtils.resolveData(getContext(), 2130968793);
    private int itemDividerWidth = ConvertUtils.dp2px(6.0f);
    private int maxLines = 2;
    private int maxLinesBackup = 2;
    private ItemRelativeChildBinding moreBinding = createMoreItemView();
    private Function1<? super RelativeItem, Unit> onItemClickListener;
    private boolean showMoreView = true;
    public ViewPartPool viewPartPool;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RelativeInfoView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RelativeInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/view/RelativeInfoView$Companion;", "", "()V", "minAcceptedWidth", "", "getMinAcceptedWidth", "()I", "moreItem", "Lcom/coolapk/market/widget/view/RelativeInfoView$RelativeItem;", "getMoreItem", "()Lcom/coolapk/market/widget/view/RelativeInfoView$RelativeItem;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RelativeInfoView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RelativeItem getMoreItem() {
            return RelativeInfoView.moreItem;
        }

        public final int getMinAcceptedWidth() {
            return RelativeInfoView.minAcceptedWidth;
        }
    }

    public final ViewPartPool getViewPartPool() {
        ViewPartPool viewPartPool2 = this.viewPartPool;
        if (viewPartPool2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPartPool");
        }
        return viewPartPool2;
    }

    public final void setViewPartPool(ViewPartPool viewPartPool2) {
        Intrinsics.checkNotNullParameter(viewPartPool2, "<set-?>");
        this.viewPartPool = viewPartPool2;
    }

    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    public final void setDividerHeight(int i) {
        this.dividerHeight = i;
    }

    public final int getItemDividerWidth() {
        return this.itemDividerWidth;
    }

    public final void setItemDividerWidth(int i) {
        this.itemDividerWidth = i;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final void setMaxLines(int i) {
        this.maxLines = i;
    }

    public final List<RelativeItem> getDataItems() {
        return this.dataItems;
    }

    public final void setDataItems(List<RelativeItem> list) {
        this.dataItems = list;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.coolapk.market.widget.view.RelativeInfoView$RelativeItem, kotlin.Unit>, kotlin.jvm.functions.Function1<com.coolapk.market.widget.view.RelativeInfoView$RelativeItem, kotlin.Unit> */
    public final Function1<RelativeItem, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final void setOnItemClickListener(Function1<? super RelativeItem, Unit> function1) {
        this.onItemClickListener = function1;
    }

    public final int getItemBackgroundColor() {
        return this.itemBackgroundColor;
    }

    public final void setItemBackgroundColor(int i) {
        this.itemBackgroundColor = i;
    }

    public final int getGoodsItemBackgroundColor() {
        return this.goodsItemBackgroundColor;
    }

    public final void setGoodsItemBackgroundColor(int i) {
        this.goodsItemBackgroundColor = i;
    }

    public final ItemRelativeChildBinding getMoreBinding() {
        return this.moreBinding;
    }

    public final void setMoreBinding(ItemRelativeChildBinding itemRelativeChildBinding) {
        Intrinsics.checkNotNullParameter(itemRelativeChildBinding, "<set-?>");
        this.moreBinding = itemRelativeChildBinding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public final void notifyDataSetChange() {
        List<RelativeItem> list;
        boolean z;
        if (this.viewPartPool == null) {
            this.viewPartPool = new ViewPartPool();
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (true) {
            list = 0;
            z = true;
            if (i2 >= childCount) {
                break;
            }
            Object tag = getChildAt(i2).getTag(2131363492);
            if (tag instanceof RelateInfoChildViewPart) {
                list = tag;
            }
            RelateInfoChildViewPart relateInfoChildViewPart = (RelateInfoChildViewPart) list;
            if (relateInfoChildViewPart != null && (true ^ Intrinsics.areEqual((ItemRelativeChildBinding) relateInfoChildViewPart.getBinding(), this.moreBinding))) {
                ViewPartPool viewPartPool2 = this.viewPartPool;
                if (viewPartPool2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPartPool");
                }
                viewPartPool2.putRecycledViewPart(relateInfoChildViewPart, 2131558896);
            }
            i2++;
        }
        removeAllViews();
        List<RelativeItem> list2 = this.dataItems;
        if (list2 == null || !(!list2.isEmpty())) {
            z = false;
        }
        if (z) {
            list = list2;
        }
        if (list != null) {
            for (T t : list) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                ViewPartPool viewPartPool3 = this.viewPartPool;
                if (viewPartPool3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPartPool");
                }
                ItemRelativeChildBinding bindChildViewPart = bindChildViewPart((RelateInfoChildViewPart) viewPartPool3.getRecycledViewPart(2131558896), t2);
                View root = bindChildViewPart.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                addView(bindChildViewPart.getRoot(), i, layoutParams);
                i = i3;
            }
            View root2 = this.moreBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "moreBinding.root");
            ViewGroup.LayoutParams layoutParams2 = root2.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = generateDefaultLayoutParams();
            }
            addView(this.moreBinding.getRoot(), list.size(), layoutParams2);
        }
        this.maxLinesBackup = this.maxLines;
        requestLayout();
    }

    private final ItemRelativeChildBinding bindChildViewPart(RelateInfoChildViewPart relateInfoChildViewPart, RelativeItem relativeItem) {
        if (relateInfoChildViewPart != null) {
            relateInfoChildViewPart.setRelativeParent(this);
        } else {
            relateInfoChildViewPart = new RelateInfoChildViewPart();
            relateInfoChildViewPart.setRelativeParent(this);
            RelativeInfoView relativeParent = relateInfoChildViewPart.getRelativeParent();
            Intrinsics.checkNotNull(relativeParent);
            LayoutInflater from = LayoutInflater.from(relativeParent.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(relativeParent!!.context)");
            relateInfoChildViewPart.createView(from, relateInfoChildViewPart.getRelativeParent());
            ((ItemRelativeChildBinding) relateInfoChildViewPart.getBinding()).getRoot().setTag(2131363492, relateInfoChildViewPart);
        }
        relateInfoChildViewPart.bindToContent(relativeItem);
        return (ItemRelativeChildBinding) relateInfoChildViewPart.getBinding();
    }

    private final ItemRelativeChildBinding createMoreItemView() {
        ItemRelativeChildBinding bindChildViewPart = bindChildViewPart(null, moreItem);
        SimpleImageView simpleImageView = bindChildViewPart.iconView;
        Intrinsics.checkNotNullExpressionValue(simpleImageView, "moreBinding.iconView");
        ViewGroup.LayoutParams layoutParams = simpleImageView.getLayoutParams();
        layoutParams.width = ConvertUtils.dp2px(24.0f);
        layoutParams.height = ConvertUtils.dp2px(24.0f);
        bindChildViewPart.iconView.setColorFilter((int) 4290624957L, PorterDuff.Mode.SRC_IN);
        bindChildViewPart.getRoot().setPadding(0, 0, 0, 0);
        return bindChildViewPart;
    }

    public final void toggleMaxLine() {
        if (this.maxLines == Integer.MAX_VALUE) {
            this.maxLines = this.maxLinesBackup;
        } else {
            this.maxLines = Integer.MAX_VALUE;
        }
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3;
        if (getChildCount() == 0 || this.dataItems == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = 1;
        this.showMoreView = true;
        int size = View.MeasureSpec.getSize(i);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).measure(makeMeasureSpec, i2);
        }
        List<RelativeItem> list = this.dataItems;
        if (list != null) {
            int i6 = -1;
            int i7 = size;
            int i8 = 1;
            while (true) {
                if (i6 >= getChildCount() - 2) {
                    break;
                }
                i6++;
                if (i8 > this.maxLines) {
                    break;
                }
                RelativeItem relativeItem = list.get(i6);
                boolean z = list.size() - i4 == i6;
                if (!relativeItem.getSingleLine()) {
                    View childAt = getChildAt(i6);
                    Intrinsics.checkNotNullExpressionValue(childAt, "view");
                    boolean z2 = childAt.getMeasuredWidth() <= i7;
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    View root = this.moreBinding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "moreBinding.root");
                    boolean z3 = measuredWidth2 <= (i7 - root.getMeasuredWidth()) - this.itemDividerWidth;
                    boolean z4 = i7 >= minAcceptedWidth;
                    if (z && z2) {
                        this.showMoreView = false;
                        i7 -= childAt.getMeasuredWidth();
                        break;
                    }
                    if (!z || z2) {
                        if (z3) {
                            measuredWidth = i7 - childAt.getMeasuredWidth();
                            i3 = this.itemDividerWidth;
                        } else if (i8 == this.maxLines) {
                            if (!z4) {
                                break;
                            }
                            View root2 = this.moreBinding.getRoot();
                            Intrinsics.checkNotNullExpressionValue(root2, "moreBinding.root");
                            childAt.measure(View.MeasureSpec.makeMeasureSpec((i7 - root2.getMeasuredWidth()) - this.itemDividerWidth, Integer.MIN_VALUE), i2);
                            measuredWidth = i7 - childAt.getMeasuredWidth();
                            i3 = this.itemDividerWidth;
                        } else if (z2) {
                            measuredWidth = i7 - childAt.getMeasuredWidth();
                            i3 = this.itemDividerWidth;
                        }
                        i7 = measuredWidth - i3;
                        i4 = 1;
                    } else if (i8 == this.maxLines) {
                        if (z4) {
                            this.showMoreView = false;
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), i2);
                        } else {
                            this.showMoreView = true;
                        }
                    }
                    i8++;
                    i6--;
                    i7 = size;
                    i4 = 1;
                } else {
                    if (size != i7) {
                        i8++;
                        i6--;
                        i7 = size;
                    } else {
                        i8++;
                    }
                    if (z) {
                        this.showMoreView = false;
                    }
                }
            }
            if (i7 == size && i8 > 0) {
                i8--;
            }
            View root3 = this.moreBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "moreBinding.root");
            setMeasuredDimension(size, (root3.getMeasuredHeight() * i8) + (this.dividerHeight * (i8 - 1)));
            return;
        }
        throw new IllegalStateException("you forget to call notifyDataSetChange() after modify the dataItems");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.dataItems != null) {
            int measuredWidth = getMeasuredWidth();
            List<RelativeItem> list = this.dataItems;
            if (list != null) {
                int childCount = getChildCount() - 1;
                int i7 = 0;
                int i8 = 0;
                int i9 = 1;
                for (int i10 = 0; i10 < childCount; i10++) {
                    RelativeItem relativeItem = list.get(i10);
                    View childAt = getChildAt(i10);
                    if (!Intrinsics.areEqual(childAt, this.moreBinding.getRoot())) {
                        if (relativeItem.getSingleLine()) {
                            if (i7 != 0) {
                                View root = this.moreBinding.getRoot();
                                Intrinsics.checkNotNullExpressionValue(root, "moreBinding.root");
                                i8 += root.getMeasuredHeight() + this.dividerHeight;
                                i9++;
                                i7 = 0;
                            }
                            Intrinsics.checkNotNullExpressionValue(childAt, "view");
                            childAt.layout(i7, i8, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i8);
                            View root2 = this.moreBinding.getRoot();
                            Intrinsics.checkNotNullExpressionValue(root2, "moreBinding.root");
                            i8 += root2.getMeasuredHeight() + this.dividerHeight;
                            i9++;
                            i7 = 0;
                        } else {
                            if (i9 == this.maxLines) {
                                int i11 = measuredWidth - i7;
                                Intrinsics.checkNotNullExpressionValue(childAt, "view");
                                if (i11 < childAt.getMeasuredWidth()) {
                                    childAt.layout(0, 0, 0, 0);
                                } else {
                                    childAt.layout(i7, i8, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i8);
                                    i6 = childAt.getMeasuredWidth();
                                    i5 = this.itemDividerWidth;
                                }
                            } else {
                                int i12 = measuredWidth - i7;
                                Intrinsics.checkNotNullExpressionValue(childAt, "view");
                                if (i12 < childAt.getMeasuredWidth()) {
                                    View root3 = this.moreBinding.getRoot();
                                    Intrinsics.checkNotNullExpressionValue(root3, "moreBinding.root");
                                    i8 += root3.getMeasuredHeight() + this.dividerHeight;
                                    i9++;
                                    i7 = 0;
                                }
                                childAt.layout(i7, i8, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i8);
                                i6 = childAt.getMeasuredWidth();
                                i5 = this.itemDividerWidth;
                            }
                            i7 += i6 + i5;
                        }
                    }
                }
                if (this.showMoreView) {
                    View root4 = this.moreBinding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root4, "moreBinding.root");
                    root4.layout(i7, i8, root4.getMeasuredWidth() + i7, root4.getMeasuredHeight() + i8);
                    return;
                }
                this.moreBinding.getRoot().layout(0, 0, 0, 0);
                return;
            }
            throw new IllegalStateException("you forget to call notifyDataSetChange() after modify the dataItems");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/view/RelativeInfoView$RelativeItem;", "", "title", "", "image", "url", "singleLine", "", "isLargeRadius", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getImage", "()Ljava/lang/String;", "()Z", "getSingleLine", "getTitle", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RelativeInfoView.kt */
    public static final class RelativeItem {
        private final String image;
        private final boolean isLargeRadius;
        private final boolean singleLine;
        private final String title;
        private final String type;
        private final String url;

        public static /* synthetic */ RelativeItem copy$default(RelativeItem relativeItem, String str, String str2, String str3, boolean z, boolean z2, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = relativeItem.title;
            }
            if ((i & 2) != 0) {
                str2 = relativeItem.image;
            }
            if ((i & 4) != 0) {
                str3 = relativeItem.url;
            }
            if ((i & 8) != 0) {
                z = relativeItem.singleLine;
            }
            if ((i & 16) != 0) {
                z2 = relativeItem.isLargeRadius;
            }
            if ((i & 32) != 0) {
                str4 = relativeItem.type;
            }
            return relativeItem.copy(str, str2, str3, z, z2, str4);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.image;
        }

        public final String component3() {
            return this.url;
        }

        public final boolean component4() {
            return this.singleLine;
        }

        public final boolean component5() {
            return this.isLargeRadius;
        }

        public final String component6() {
            return this.type;
        }

        public final RelativeItem copy(String str, String str2, String str3, boolean z, boolean z2, String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "image");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intrinsics.checkNotNullParameter(str4, "type");
            return new RelativeItem(str, str2, str3, z, z2, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeItem)) {
                return false;
            }
            RelativeItem relativeItem = (RelativeItem) obj;
            return Intrinsics.areEqual(this.title, relativeItem.title) && Intrinsics.areEqual(this.image, relativeItem.image) && Intrinsics.areEqual(this.url, relativeItem.url) && this.singleLine == relativeItem.singleLine && this.isLargeRadius == relativeItem.isLargeRadius && Intrinsics.areEqual(this.type, relativeItem.type);
        }

        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.image;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.url;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            boolean z = this.singleLine;
            int i2 = 1;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (hashCode3 + i3) * 31;
            boolean z2 = this.isLargeRadius;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            int i7 = (i6 + i2) * 31;
            String str4 = this.type;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return i7 + i;
        }

        public String toString() {
            return "RelativeItem(title=" + this.title + ", image=" + this.image + ", url=" + this.url + ", singleLine=" + this.singleLine + ", isLargeRadius=" + this.isLargeRadius + ", type=" + this.type + ")";
        }

        public RelativeItem(String str, String str2, String str3, boolean z, boolean z2, String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "image");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intrinsics.checkNotNullParameter(str4, "type");
            this.title = str;
            this.image = str2;
            this.url = str3;
            this.singleLine = z;
            this.isLargeRadius = z2;
            this.type = str4;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public /* synthetic */ RelativeItem(String str, String str2, String str3, boolean z, boolean z2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? r1 : str2, (i & 4) != 0 ? r1 : str3, (i & 8) != 0 ? false : z, (i & 16) == 0 ? z2 : false, (i & 32) == 0 ? str4 : r1);
            String str5 = "";
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final String getType() {
            return this.type;
        }

        public final boolean isLargeRadius() {
            return this.isLargeRadius;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0014J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/view/RelativeInfoView$RelateInfoChildViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemRelativeChildBinding;", "Lcom/coolapk/market/widget/view/RelativeInfoView$RelativeItem;", "()V", "bgRadius", "", "displayImageRunnable", "Ljava/lang/Runnable;", "getDisplayImageRunnable", "()Ljava/lang/Runnable;", "setDisplayImageRunnable", "(Ljava/lang/Runnable;)V", "logoRadius", "relativeParent", "Lcom/coolapk/market/widget/view/RelativeInfoView;", "getRelativeParent", "()Lcom/coolapk/market/widget/view/RelativeInfoView;", "setRelativeParent", "(Lcom/coolapk/market/widget/view/RelativeInfoView;)V", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RelativeInfoView.kt */
    public static final class RelateInfoChildViewPart extends BindingViewPart<ItemRelativeChildBinding, RelativeItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558896;
        private static final Regex NUMS_REGEX = new Regex("^\\d+$");
        private float bgRadius = 3.0f;
        private Runnable displayImageRunnable;
        private float logoRadius = 2.0f;
        private RelativeInfoView relativeParent;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/widget/view/RelativeInfoView$RelateInfoChildViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "NUMS_REGEX", "Lkotlin/text/Regex;", "getNUMS_REGEX", "()Lkotlin/text/Regex;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: RelativeInfoView.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Regex getNUMS_REGEX() {
                return RelateInfoChildViewPart.NUMS_REGEX;
            }
        }

        public final RelativeInfoView getRelativeParent() {
            return this.relativeParent;
        }

        public final void setRelativeParent(RelativeInfoView relativeInfoView) {
            this.relativeParent = relativeInfoView;
        }

        public final Runnable getDisplayImageRunnable() {
            return this.displayImageRunnable;
        }

        public final void setDisplayImageRunnable(Runnable runnable) {
            this.displayImageRunnable = runnable;
        }

        /* access modifiers changed from: protected */
        @Override // com.coolapk.market.viewholder.iview.BindingViewPart
        public ItemRelativeChildBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558896, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
            return (ItemRelativeChildBinding) inflate;
        }

        /* access modifiers changed from: protected */
        public void onBindToContent(RelativeItem relativeItem) {
            Intrinsics.checkNotNullParameter(relativeItem, "data");
            super.onBindToContent((RelateInfoChildViewPart) relativeItem);
            RelativeInfoView relativeInfoView = this.relativeParent;
            if (relativeInfoView != null) {
                if (this.displayImageRunnable != null) {
                    ((ItemRelativeChildBinding) getBinding()).iconView.removeCallbacks(this.displayImageRunnable);
                }
                this.displayImageRunnable = new RelativeInfoView$RelateInfoChildViewPart$onBindToContent$1(this, relativeItem);
                SimpleImageView simpleImageView = ((ItemRelativeChildBinding) getBinding()).iconView;
                Runnable runnable = this.displayImageRunnable;
                Intrinsics.checkNotNull(runnable);
                simpleImageView.post(runnable);
                if (relativeItem.isLargeRadius()) {
                    this.logoRadius = 8.0f;
                    this.bgRadius = 12.0f;
                } else {
                    this.logoRadius = 2.0f;
                    this.bgRadius = 3.0f;
                }
                boolean equals = TextUtils.equals(relativeItem.getType(), "goods_tags");
                boolean equals2 = TextUtils.equals(relativeItem.getType(), "mall_tags");
                if (equals || equals2) {
                    ((ItemRelativeChildBinding) getBinding()).titleView.setTextSize(2, 10.0f);
                    LinearLayout linearLayout = ((ItemRelativeChildBinding) getBinding()).cardView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
                    linearLayout.getLayoutParams().height = NumberExtendsKt.getDp((Number) 14);
                    ((ItemRelativeChildBinding) getBinding()).cardView.setPadding(NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 2));
                    View root = ((ItemRelativeChildBinding) getBinding()).getRoot();
                    int goodsItemBackgroundColor = relativeInfoView.getGoodsItemBackgroundColor();
                    int itemBackgroundColor = relativeInfoView.getItemBackgroundColor();
                    if (!equals2) {
                        goodsItemBackgroundColor = itemBackgroundColor;
                    }
                    root.setBackgroundColor(goodsItemBackgroundColor);
                    View root2 = ((ItemRelativeChildBinding) getBinding()).getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                    Drawable background = root2.getBackground();
                    Intrinsics.checkNotNullExpressionValue(background, "binding.root.background");
                    int i = 26;
                    if (!equals2) {
                        i = 100;
                    }
                    background.setAlpha(i);
                    TextView textView = ((ItemRelativeChildBinding) getBinding()).titleView;
                    int colorInt = ResourceUtils.getColorInt(getContext(), 2131100035);
                    int textColorSecondary = AppHolder.getAppTheme().getTextColorSecondary();
                    if (!equals2) {
                        colorInt = textColorSecondary;
                    }
                    textView.setTextColor(colorInt);
                } else {
                    ((ItemRelativeChildBinding) getBinding()).titleView.setTextSize(2, 12.0f);
                    LinearLayout linearLayout2 = ((ItemRelativeChildBinding) getBinding()).cardView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.cardView");
                    linearLayout2.getLayoutParams().height = NumberExtendsKt.getDp((Number) 24);
                    ((ItemRelativeChildBinding) getBinding()).cardView.setPadding(NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4));
                    ((ItemRelativeChildBinding) getBinding()).getRoot().setBackgroundColor(relativeInfoView.getItemBackgroundColor());
                }
                TextView textView2 = ((ItemRelativeChildBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i2 = 0;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = 0;
                    boolean equals3 = TextUtils.equals(relativeItem.getType(), "goods_tags");
                    int dp = NumberExtendsKt.getDp((Number) 5);
                    if (equals3) {
                        dp = 0;
                    }
                    marginLayoutParams.leftMargin = dp;
                    boolean equals4 = TextUtils.equals(relativeItem.getType(), "goods_tags");
                    int dp2 = NumberExtendsKt.getDp((Number) 3);
                    if (equals4) {
                        dp2 = 0;
                    }
                    marginLayoutParams.rightMargin = dp2;
                    marginLayoutParams.bottomMargin = 0;
                }
                ((ItemRelativeChildBinding) getBinding()).titleView.requestLayout();
                View root3 = ((ItemRelativeChildBinding) getBinding()).getRoot();
                Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
                ViewExtendsKt.clipView(root3, 0, (float) NumberExtendsKt.getDp(Float.valueOf(this.bgRadius)));
                SimpleImageView simpleImageView2 = ((ItemRelativeChildBinding) getBinding()).iconView;
                Intrinsics.checkNotNullExpressionValue(simpleImageView2, "binding.iconView");
                ViewExtendsKt.clipView(simpleImageView2, 0, (float) NumberExtendsKt.getDp(Float.valueOf(this.logoRadius)));
                SimpleImageView simpleImageView3 = ((ItemRelativeChildBinding) getBinding()).iconView;
                Intrinsics.checkNotNullExpressionValue(simpleImageView3, "binding.iconView");
                boolean z = true;
                simpleImageView3.setVisibility(relativeItem.getImage().length() == 0 ? 8 : 0);
                TextView textView3 = ((ItemRelativeChildBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                textView3.setText(relativeItem.getTitle());
                TextView textView4 = ((ItemRelativeChildBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
                if (relativeItem.getTitle().length() != 0) {
                    z = false;
                }
                if (z) {
                    i2 = 8;
                }
                textView4.setVisibility(i2);
                ((ItemRelativeChildBinding) getBinding()).getRoot().setOnClickListener(new RelativeInfoView$RelateInfoChildViewPart$onBindToContent$3(this, relativeItem));
            }
        }

        @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
        public void onRecycled() {
            super.onRecycled();
            this.relativeParent = null;
            ((ItemRelativeChildBinding) getBinding()).getRoot().setOnClickListener(null);
            if (this.displayImageRunnable != null) {
                SimpleImageView simpleImageView = ((ItemRelativeChildBinding) getBinding()).iconView;
                Runnable runnable = this.displayImageRunnable;
                Intrinsics.checkNotNull(runnable);
                simpleImageView.removeCallbacks(runnable);
                this.displayImageRunnable = null;
            }
        }
    }
}
