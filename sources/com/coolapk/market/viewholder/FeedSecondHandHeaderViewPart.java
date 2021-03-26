package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedSecondHandHeaderViewPartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0018B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0015J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedSecondHandHeaderViewPartBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "list", "", "", "paramsList", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedSecondHandHeaderViewPart.kt */
public final class FeedSecondHandHeaderViewPart extends BindingViewPart<ItemFeedSecondHandHeaderViewPartBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558724;
    private final DataBindingComponent component;
    private Feed feed;
    private final List<String> list;
    private final List<String> paramsList;

    public FeedSecondHandHeaderViewPart() {
        this(null, 1, null);
    }

    public FeedSecondHandHeaderViewPart(DataBindingComponent dataBindingComponent) {
        this.component = dataBindingComponent;
        this.list = new ArrayList();
        this.paramsList = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedSecondHandHeaderViewPart(DataBindingComponent dataBindingComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataBindingComponent);
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSecondHandHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "shouldShowView", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSecondHandHeaderViewPart.kt */
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
        super.onBindToContent((FeedSecondHandHeaderViewPart) feed2);
        this.feed = feed2;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        SecondHandInfo secondHandInfo = feed2.getSecondHandInfo();
        if (secondHandInfo == null) {
            ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).executePendingBindings();
            return;
        }
        TextView textView = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleTagView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTagView");
        textView.setText("");
        TextView textView2 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleTagView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleTagView");
        int i2 = 8;
        textView2.setVisibility(8);
        TextView textView3 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
        textView3.setVisibility(8);
        FrameLayout frameLayout = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.titleContainer");
        frameLayout.setVisibility(8);
        TextView textView4 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        textView4.setText(feed3.getMessageTitle());
        TextView textView5 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).messageView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.messageView");
        textView5.setVisibility(8);
        TextView textView6 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.textView");
        boolean isFaceDeal = secondHandInfo.isFaceDeal();
        String priceShowText = secondHandInfo.getPriceShowText();
        String priceText = secondHandInfo.getPriceText();
        if (!isFaceDeal) {
            priceShowText = priceText;
        }
        textView6.setText(priceShowText);
        TextView textView7 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).exchangePriceView;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.exchangePriceView");
        textView7.setText(secondHandInfo.getPriceShowText());
        boolean z = !TextUtils.isEmpty(secondHandInfo.getPriceShowText()) && !secondHandInfo.isFaceDeal();
        TextView textView8 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).exchangePriceView;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding.exchangePriceView");
        textView8.setVisibility(z ? 0 : 8);
        String locationText = EntityExtendsKt.getLocationText(secondHandInfo);
        TextView textView9 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).provinceView;
        Intrinsics.checkNotNullExpressionValue(textView9, "binding.provinceView");
        textView9.setText(locationText);
        TextView textView10 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView10, "binding.textView");
        textView10.setVisibility(TextUtils.isEmpty(secondHandInfo.getPrice()) ? 8 : 0);
        boolean z2 = UiUtils.getActivityNullable(getContext()) instanceof FeedDetailActivityV8;
        if (secondHandInfo.isXianyu()) {
            i = 2131232047;
        } else if (secondHandInfo.isZhuanzhuan()) {
            i = 2131232049;
        } else {
            i = secondHandInfo.isJiaoYiMao() ? 2131231374 : 2131231788;
        }
        ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLink.setImageResource(i);
        TextView textView11 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLinkText;
        Intrinsics.checkNotNullExpressionValue(textView11, "binding.signLinkText");
        textView11.setText(TextUtils.isEmpty(secondHandInfo.getSource()) ? "无链接" : secondHandInfo.getSource());
        TextView textView12 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLinkText;
        Intrinsics.checkNotNullExpressionValue(textView12, "binding.signLinkText");
        textView12.setVisibility(z2 ? 8 : 0);
        ImageView imageView = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).signLink;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.signLink");
        imageView.setVisibility(z2 ? 8 : 0);
        TextView textView13 = ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).provinceView;
        Intrinsics.checkNotNullExpressionValue(textView13, "binding.provinceView");
        if (z2) {
            i2 = 0;
        }
        textView13.setVisibility(i2);
        ((ItemFeedSecondHandHeaderViewPartBinding) getBinding()).executePendingBindings();
    }
}
