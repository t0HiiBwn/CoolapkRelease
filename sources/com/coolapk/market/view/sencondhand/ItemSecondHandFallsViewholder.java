package com.coolapk.market.view.sencondhand;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemSecondHandFallBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.view.ScalingImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0017J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/sencondhand/ItemSecondHandFallsViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSecondHandFallBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "feed", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemSecondHandFallsViewholder.kt */
public final class ItemSecondHandFallsViewholder extends GenericBindHolder<ItemSecondHandFallBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558926;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemSecondHandFallsViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        TextView textView = ((ItemSecondHandFallBinding) getBinding()).priceText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.priceText");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
    }

    public void bindToContent(Feed feed) {
        int i;
        Intrinsics.checkNotNullParameter(feed, "feed");
        GlideApp.with(((ItemSecondHandFallBinding) getBinding()).picView).clear(((ItemSecondHandFallBinding) getBinding()).picView);
        ItemSecondHandFallBinding itemSecondHandFallBinding = (ItemSecondHandFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandFallBinding, "binding");
        itemSecondHandFallBinding.setModel(feed);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[SecondHand]");
        int i2 = 0;
        int i3 = 0;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 24.0f), 0);
        spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[SecondHand]"), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) feed.getMessageTitle());
        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(feed.getThumbnailPic());
        Integer num = null;
        Integer valueOf = size != null ? Integer.valueOf(size.getHeight()) : null;
        if (valueOf == null) {
            valueOf = 0;
        }
        float intValue = (float) valueOf.intValue();
        if (size != null) {
            num = Integer.valueOf(size.getWidth());
        }
        if (num != null) {
            i3 = num;
        }
        float intValue2 = ((float) i3.intValue()) / intValue;
        if (intValue2 < 0.56f) {
            intValue2 = 0.56f;
        } else if (intValue2 > 1.0f) {
            intValue2 = 1.0f;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int dp = (resources.getDisplayMetrics().widthPixels / 2) - NumberExtendsKt.getDp((Number) 24);
        ScalingImageView scalingImageView = ((ItemSecondHandFallBinding) getBinding()).picView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.picView");
        scalingImageView.setMaxHeight(dp * 2);
        float f = ((float) dp) / intValue2;
        ScalingImageView scalingImageView2 = ((ItemSecondHandFallBinding) getBinding()).picView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.picView");
        scalingImageView2.getLayoutParams().height = dp;
        ScalingImageView scalingImageView3 = ((ItemSecondHandFallBinding) getBinding()).picView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView3, "binding.picView");
        scalingImageView3.getLayoutParams().height = (int) f;
        ((ItemSecondHandFallBinding) getBinding()).picView.requestLayout();
        TextView textView = ((ItemSecondHandFallBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(spannableStringBuilder);
        TextView textView2 = ((ItemSecondHandFallBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setVisibility(TextUtils.isEmpty(feed.getMessageTitle()) ? 8 : 0);
        SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
        if (secondHandInfo != null) {
            ImageView imageView = ((ItemSecondHandFallBinding) getBinding()).selledView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.selledView");
            imageView.setVisibility(secondHandInfo.isSelled() ? 0 : 8);
            TextView textView3 = ((ItemSecondHandFallBinding) getBinding()).titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleTagView");
            textView3.setVisibility(0);
            boolean z = true;
            boolean z2 = secondHandInfo.getStoreType() == 2;
            TextView textView4 = ((ItemSecondHandFallBinding) getBinding()).titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleTagView");
            textView4.setText(secondHandInfo.getStoreTypeText());
            int colorInt = ResourceUtils.getColorInt(getContext(), 2131100040);
            int colorInt2 = ResourceUtils.getColorInt(getContext(), 2131099687);
            if (!z2) {
                colorInt = colorInt2;
            }
            TextView textView5 = ((ItemSecondHandFallBinding) getBinding()).titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleTagView");
            textView5.setBackground(new ColorDrawable(colorInt));
            String timeDescription = DateUtils.getTimeDescription(getContext(), secondHandInfo.getDateline());
            secondHandInfo.getProvince();
            if (secondHandInfo.isXianyu()) {
                i = 2131232065;
            } else if (secondHandInfo.isZhuanzhuan()) {
                i = 2131232067;
            } else {
                i = secondHandInfo.isJiaoYiMao() ? 2131231385 : 2131231799;
            }
            ((ItemSecondHandFallBinding) getBinding()).signLink.setImageResource(i);
            TextView textView6 = ((ItemSecondHandFallBinding) getBinding()).signLinkText;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.signLinkText");
            textView6.setText(TextUtils.isEmpty(secondHandInfo.getSource()) ? "无链接" : secondHandInfo.getSource());
            String locationText = EntityExtendsKt.getLocationText(secondHandInfo);
            TextView textView7 = ((ItemSecondHandFallBinding) getBinding()).infoText;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.infoText");
            textView7.setText(timeDescription + (char) 183 + locationText);
            TextView textView8 = ((ItemSecondHandFallBinding) getBinding()).priceText;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.priceText");
            boolean isFaceDeal = secondHandInfo.isFaceDeal();
            String priceShowText = secondHandInfo.getPriceShowText();
            String priceText = secondHandInfo.getPriceText();
            if (!isFaceDeal) {
                priceShowText = priceText;
            }
            textView8.setText(priceShowText);
            TextView textView9 = ((ItemSecondHandFallBinding) getBinding()).exchangePriceView;
            Intrinsics.checkNotNullExpressionValue(textView9, "binding.exchangePriceView");
            textView9.setText(secondHandInfo.getPriceShowText());
            if (TextUtils.isEmpty(secondHandInfo.getPriceShowText()) || secondHandInfo.isFaceDeal()) {
                z = false;
            }
            TextView textView10 = ((ItemSecondHandFallBinding) getBinding()).exchangePriceView;
            Intrinsics.checkNotNullExpressionValue(textView10, "binding.exchangePriceView");
            if (!z) {
                i2 = 8;
            }
            textView10.setVisibility(i2);
        }
        FrameLayout frameLayout = ((ItemSecondHandFallBinding) getBinding()).frameView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.frameView");
        ViewExtendsKt.darkForegroundIfNeed(frameLayout);
        ItemSecondHandFallBinding itemSecondHandFallBinding2 = (ItemSecondHandFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandFallBinding2, "binding");
        itemSecondHandFallBinding2.setClick(this);
        ((ItemSecondHandFallBinding) getBinding()).executePendingBindings();
        ((ItemSecondHandFallBinding) getBinding()).cardView.setOnLongClickListener(new ItemSecondHandFallsViewholder$bindToContent$1(this, feed));
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemSecondHandFallBinding itemSecondHandFallBinding3 = (ItemSecondHandFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandFallBinding3, "binding");
        View root = itemSecondHandFallBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, "瀑布流二手");
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        ItemSecondHandFallBinding itemSecondHandFallBinding = (ItemSecondHandFallBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandFallBinding, "binding");
        Feed model = itemSecondHandFallBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            if (valueOf != null && valueOf.intValue() == 2131362205) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(model), null, null, 12, null);
            } else if (valueOf != null && valueOf.intValue() == 2131362098) {
                ActionManager.startUserSpaceActivity(getContext(), model.getUid());
            } else {
                super.onClick(view);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/sencondhand/ItemSecondHandFallsViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemSecondHandFallsViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
