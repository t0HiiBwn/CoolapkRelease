package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemImageListCardBinding;
import java.lang.reflect.Field;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message = "Replace by ImageListCardViewHolder")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCarouselCard1ViewHolder;", "Lcom/coolapk/market/viewholder/ImageListCardViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemImageListCardBinding;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageCarouselCard1ViewHolder.kt */
public final class ImageCarouselCard1ViewHolder extends ImageListCardViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558791;
    private final ItemImageListCardBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageCarouselCard1ViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ViewDataBinding binding2 = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding2, "getBinding()");
        ItemImageListCardBinding itemImageListCardBinding = (ItemImageListCardBinding) binding2;
        this.binding = itemImageListCardBinding;
        int dp2px = ConvertUtils.dp2px(12.0f);
        int dp2px2 = ConvertUtils.dp2px(16.0f);
        itemImageListCardBinding.bannerView.setIndicatorGravity(7);
        itemImageListCardBinding.coolapkCardView.setCardMargin(dp2px2, dp2px, dp2px2, dp2px);
        try {
            Class<?> cls = itemImageListCardBinding.bannerView.getClass();
            Field declaredField = cls.getDeclaredField("mIndicatorWidth");
            declaredField.setAccessible(true);
            declaredField.setInt(itemImageListCardBinding.bannerView, ConvertUtils.dp2px(5.0f));
            Field declaredField2 = cls.getDeclaredField("mIndicatorHeight");
            declaredField2.setAccessible(true);
            declaredField2.setInt(itemImageListCardBinding.bannerView, ConvertUtils.dp2px(5.0f));
            Field declaredField3 = cls.getDeclaredField("mIndicatorMargin");
            declaredField3.setAccessible(true);
            declaredField3.setInt(itemImageListCardBinding.bannerView, ConvertUtils.dp2px(2.0f));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ImageCarouselCard1ViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageCarouselCard1ViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
