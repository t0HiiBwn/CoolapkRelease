package com.coolapk.market.viewholder;

import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemFeedSecondHandHeaderViewPartBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0014B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0015J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSourceSecondHandHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedSecondHandHeaderViewPartBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedSourceSecondHandHeaderViewPart.kt */
public final class FeedSourceSecondHandHeaderViewPart extends BindingViewPart<ItemFeedSecondHandHeaderViewPartBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558724;
    private final DataBindingComponent component;
    private Feed feed;

    public FeedSourceSecondHandHeaderViewPart() {
        this(null, 1, null);
    }

    public FeedSourceSecondHandHeaderViewPart(DataBindingComponent dataBindingComponent) {
        this.component = dataBindingComponent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedSourceSecondHandHeaderViewPart(DataBindingComponent dataBindingComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataBindingComponent);
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSourceSecondHandHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSourceSecondHandHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean shouldShowView(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "data");
            return feed.isSecondHand();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedSecondHandHeaderViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558724, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemFeedSecondHandHeaderViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        TextView textView = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(getContext()));
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        int i;
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedSourceSecondHandHeaderViewPart) feed2);
        this.feed = feed2;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        SecondHandInfo secondHandInfo = feed2.getSecondHandInfo();
        if (secondHandInfo == null) {
            ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).executePendingBindings();
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[SecondHand]");
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 38.0f), 0);
        spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[SecondHand]"), 0, spannableStringBuilder.length(), 33);
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        spannableStringBuilder.append((CharSequence) feed3.getMessageTitle());
        TextView textView = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(spannableStringBuilder);
        TextView textView2 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        textView2.setVisibility(TextUtils.isEmpty(feed4.getMessageTitle()) ? 8 : 0);
        FrameLayout frameLayout = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.titleContainer");
        Feed feed5 = this.feed;
        if (feed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        frameLayout.setVisibility(TextUtils.isEmpty(feed5.getMessageTitle()) ? 8 : 0);
        TextView textView3 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleTagView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleTagView");
        textView3.setVisibility(0);
        boolean z = secondHandInfo.getStoreType() == 2;
        TextView textView4 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleTagView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleTagView");
        textView4.setText(secondHandInfo.getStoreTypeText());
        int colorInt = ResourceUtils.getColorInt(getContext(), 2131100035);
        int colorInt2 = ResourceUtils.getColorInt(getContext(), 2131099687);
        if (!z) {
            colorInt = colorInt2;
        }
        TextView textView5 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleTagView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleTagView");
        textView5.setBackground(new ColorDrawable(colorInt));
        TextView textView6 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).messageView;
        Feed feed6 = this.feed;
        if (feed6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        TextViewBindingAdapters.setTextViewLinkable(textView6, feed6.getMessage());
        TextView textView7 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleTagView;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleTagView");
        textView7.setBackground(new ColorDrawable(colorInt));
        TextView textView8 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).messageView;
        Feed feed7 = this.feed;
        if (feed7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        TextViewBindingAdapters.setTextViewLinkable(textView8, feed7.getMessage());
        TextView textView9 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).messageView;
        Intrinsics.checkNotNullExpressionValue(textView9, "binding.messageView");
        textView9.setVisibility(0);
        TextView textView10 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleTagView;
        Intrinsics.checkNotNullExpressionValue(textView10, "binding.titleTagView");
        textView10.setVisibility(0);
        TextView textView11 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView11, "binding.titleView");
        textView11.setVisibility(0);
        FrameLayout frameLayout2 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.titleContainer");
        frameLayout2.setVisibility(0);
        TextView textView12 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView12, "binding.textView");
        textView12.setText(secondHandInfo.getPriceText());
        TextView textView13 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView13, "binding.textView");
        textView13.setVisibility(TextUtils.isEmpty(secondHandInfo.getPrice()) ? 8 : 0);
        TextView textView14 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).provinceView;
        Intrinsics.checkNotNullExpressionValue(textView14, "binding.provinceView");
        textView14.setVisibility(8);
        if (secondHandInfo.isXianyu()) {
            i = 2131232047;
        } else if (secondHandInfo.isZhuanzhuan()) {
            i = 2131232049;
        } else {
            i = secondHandInfo.isJiaoYiMao() ? 2131231374 : 2131231788;
        }
        ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLink.setImageResource(i);
        TextView textView15 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLinkText;
        Intrinsics.checkNotNullExpressionValue(textView15, "binding.signLinkText");
        textView15.setText(TextUtils.isEmpty(secondHandInfo.getSource()) ? "无链接" : secondHandInfo.getSource());
        TextView textView16 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLinkText;
        Intrinsics.checkNotNullExpressionValue(textView16, "binding.signLinkText");
        textView16.setVisibility(0);
        ImageView imageView = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLink;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.signLink");
        imageView.setVisibility(0);
        ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).executePendingBindings();
    }
}
