package com.coolapk.market.view.sencondhand;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemSecondHandSearchBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/sencondhand/ItemSecondHandSearchViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSecondHandSearchBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "feed", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemSecondHandSearchViewholder.kt */
public final class ItemSecondHandSearchViewholder extends GenericBindHolder<ItemSecondHandSearchBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558927;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemSecondHandSearchViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        TextView textView = ((ItemSecondHandSearchBinding) getBinding()).discountPriceView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.discountPriceView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
    }

    public void bindToContent(Feed feed) {
        int i;
        Intrinsics.checkNotNullParameter(feed, "feed");
        ItemSecondHandSearchBinding itemSecondHandSearchBinding = (ItemSecondHandSearchBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandSearchBinding, "binding");
        itemSecondHandSearchBinding.setModel(feed);
        TextView textView = ((ItemSecondHandSearchBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        int i2 = 8;
        textView.setVisibility(TextUtils.isEmpty(feed.getMessageTitle()) ? 8 : 0);
        SecondHandInfo secondHandInfo = feed.getSecondHandInfo();
        if (secondHandInfo != null) {
            ImageView imageView = ((ItemSecondHandSearchBinding) getBinding()).imgSellView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imgSellView");
            imageView.setVisibility(secondHandInfo.isSelled() ? 0 : 8);
            View view = ((ItemSecondHandSearchBinding) getBinding()).maskView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.maskView");
            view.setVisibility(secondHandInfo.isSelled() ? 0 : 8);
            ItemSecondHandSearchBinding itemSecondHandSearchBinding2 = (ItemSecondHandSearchBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemSecondHandSearchBinding2, "binding");
            itemSecondHandSearchBinding2.setModel(feed);
            String locationText = EntityExtendsKt.getLocationText(secondHandInfo);
            ItemSecondHandSearchBinding itemSecondHandSearchBinding3 = (ItemSecondHandSearchBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemSecondHandSearchBinding3, "binding");
            itemSecondHandSearchBinding3.setLocationText(locationText);
            if (secondHandInfo.isXianyu()) {
                i = 2131232065;
            } else if (secondHandInfo.isZhuanzhuan()) {
                i = 2131232067;
            } else {
                i = secondHandInfo.isJiaoYiMao() ? 2131231385 : 2131231799;
            }
            ((ItemSecondHandSearchBinding) getBinding()).signLink.setImageResource(i);
            TextView textView2 = ((ItemSecondHandSearchBinding) getBinding()).signLinkText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.signLinkText");
            textView2.setText(TextUtils.isEmpty(secondHandInfo.getSource()) ? "无链接" : secondHandInfo.getSource());
            SecondHandInfo secondHandInfo2 = feed.getSecondHandInfo();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[SecondHand]");
            ColorDrawable colorDrawable = new ColorDrawable(0);
            colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 38.0f), 0);
            spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[SecondHand]"), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) feed.getMessageTitle());
            TextView textView3 = ((ItemSecondHandSearchBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
            textView3.setText(spannableStringBuilder);
            TextView textView4 = ((ItemSecondHandSearchBinding) getBinding()).titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleTagView");
            textView4.setVisibility(0);
            Intrinsics.checkNotNull(secondHandInfo2);
            boolean z = true;
            boolean z2 = secondHandInfo2.getStoreType() == 2;
            TextView textView5 = ((ItemSecondHandSearchBinding) getBinding()).titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleTagView");
            textView5.setText(secondHandInfo2.getStoreTypeText());
            int colorInt = ResourceUtils.getColorInt(getContext(), 2131100040);
            int colorInt2 = ResourceUtils.getColorInt(getContext(), 2131099687);
            if (!z2) {
                colorInt = colorInt2;
            }
            TextView textView6 = ((ItemSecondHandSearchBinding) getBinding()).titleTagView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleTagView");
            textView6.setBackground(new ColorDrawable(colorInt));
            if (!TextUtils.isEmpty(secondHandInfo2.getPriceShowText()) && !secondHandInfo2.isFaceDeal()) {
                z = false;
            }
            TextView textView7 = ((ItemSecondHandSearchBinding) getBinding()).exchangePriceView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.exchangePriceView");
            if (!z) {
                i2 = 0;
            }
            textView7.setVisibility(i2);
        }
        ItemSecondHandSearchBinding itemSecondHandSearchBinding4 = (ItemSecondHandSearchBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandSearchBinding4, "binding");
        itemSecondHandSearchBinding4.setClick(this);
        ((ItemSecondHandSearchBinding) getBinding()).executePendingBindings();
        ((ItemSecondHandSearchBinding) getBinding()).itemView.setOnLongClickListener(new ItemSecondHandSearchViewholder$bindToContent$1(this, feed));
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemSecondHandSearchBinding itemSecondHandSearchBinding5 = (ItemSecondHandSearchBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandSearchBinding5, "binding");
        View root = itemSecondHandSearchBinding5.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        ItemSecondHandSearchBinding itemSecondHandSearchBinding = (ItemSecondHandSearchBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSecondHandSearchBinding, "binding");
        Feed model = itemSecondHandSearchBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            if (valueOf != null && valueOf.intValue() == 2131362779) {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/sencondhand/ItemSecondHandSearchViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemSecondHandSearchViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
