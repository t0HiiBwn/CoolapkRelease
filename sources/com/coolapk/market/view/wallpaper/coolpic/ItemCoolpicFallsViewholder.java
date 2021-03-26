package com.coolapk.market.view.wallpaper.coolpic;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemCoolpicFallBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.view.ShapedImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0017J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/ItemCoolpicFallsViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCoolpicFallBinding;", "Lcom/coolapk/market/model/Feed;", "urlParams", "", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Ljava/lang/String;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "feed", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemCoolpicFallsViewholder.kt */
public final class ItemCoolpicFallsViewholder extends GenericBindHolder<ItemCoolpicFallBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558670;
    private final String urlParams;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemCoolpicFallsViewholder(String str, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(str, "urlParams");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.urlParams = str;
    }

    public void bindToContent(Feed feed) {
        ShapedImageView.AlignType alignType;
        Intrinsics.checkNotNullParameter(feed, "feed");
        ItemCoolpicFallBinding itemCoolpicFallBinding = (ItemCoolpicFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCoolpicFallBinding, "binding");
        itemCoolpicFallBinding.setFeed(feed);
        ((ItemCoolpicFallBinding) getBinding()).itemView.setOnLongClickListener(new ItemCoolpicFallsViewholder$bindToContent$1(this, feed));
        ItemCoolpicFallBinding itemCoolpicFallBinding2 = (ItemCoolpicFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCoolpicFallBinding2, "binding");
        itemCoolpicFallBinding2.setClick(this);
        int i = 0;
        boolean z = true;
        int i2 = 1;
        if (feed.getPicArray().size() <= 1) {
            z = false;
        }
        ImageView imageView = ((ItemCoolpicFallBinding) getBinding()).multiPicView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.multiPicView");
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(feed.getThumbnailPic());
        Integer num = null;
        Integer valueOf = size != null ? Integer.valueOf(size.getHeight()) : null;
        if (valueOf == null) {
            valueOf = 1;
        }
        float intValue = (float) valueOf.intValue();
        if (size != null) {
            num = Integer.valueOf(size.getWidth());
        }
        if (num != null) {
            i2 = num;
        }
        float intValue2 = ((float) i2.intValue()) / intValue;
        float f = 1.0f;
        if (intValue2 < 0.45f) {
            alignType = ShapedImageView.AlignType.TOP;
            f = 0.45f;
        } else if (intValue2 > 1.0f) {
            alignType = ShapedImageView.AlignType.CENTER;
        } else {
            f = intValue2;
            alignType = ShapedImageView.AlignType.TOP;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ShapedImageView shapedImageView = ((ItemCoolpicFallBinding) getBinding()).imageView;
        Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.imageView");
        shapedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((ItemCoolpicFallBinding) getBinding()).imageView.setAlignType(alignType);
        int dp = (displayMetrics.widthPixels / 2) - NumberExtendsKt.getDp((Number) 14);
        ShapedImageView shapedImageView2 = ((ItemCoolpicFallBinding) getBinding()).imageView;
        Intrinsics.checkNotNullExpressionValue(shapedImageView2, "binding.imageView");
        shapedImageView2.setMaxHeight(dp * 2);
        float f2 = ((float) dp) / f;
        ShapedImageView shapedImageView3 = ((ItemCoolpicFallBinding) getBinding()).imageView;
        Intrinsics.checkNotNullExpressionValue(shapedImageView3, "binding.imageView");
        shapedImageView3.getLayoutParams().width = -1;
        ShapedImageView shapedImageView4 = ((ItemCoolpicFallBinding) getBinding()).imageView;
        Intrinsics.checkNotNullExpressionValue(shapedImageView4, "binding.imageView");
        shapedImageView4.getLayoutParams().height = (int) f2;
        ((ItemCoolpicFallBinding) getBinding()).imageView.requestLayout();
        ((ItemCoolpicFallBinding) getBinding()).executePendingBindings();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemCoolpicFallBinding itemCoolpicFallBinding3 = (ItemCoolpicFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCoolpicFallBinding3, "binding");
        View root = itemCoolpicFallBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, "瀑布流酷图");
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131362779) {
            Context context = getContext();
            ItemCoolpicFallBinding itemCoolpicFallBinding = (ItemCoolpicFallBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemCoolpicFallBinding, "binding");
            ActionManager.startCoolPicActivity(context, itemCoolpicFallBinding.getFeed(), "list", "old", this.urlParams, 0, getAdapterPosition());
        } else if (valueOf != null && valueOf.intValue() == 2131363911) {
            Context context2 = getContext();
            ItemCoolpicFallBinding itemCoolpicFallBinding2 = (ItemCoolpicFallBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemCoolpicFallBinding2, "binding");
            Feed feed = itemCoolpicFallBinding2.getFeed();
            Intrinsics.checkNotNull(feed);
            Intrinsics.checkNotNullExpressionValue(feed, "binding.feed!!");
            ActionManager.startUserSpaceActivity(context2, feed.getUid());
        } else {
            super.onClick(view);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/ItemCoolpicFallsViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemCoolpicFallsViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
