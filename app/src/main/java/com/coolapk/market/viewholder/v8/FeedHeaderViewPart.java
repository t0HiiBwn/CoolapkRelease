package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedTopBinding;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.ItemFeedHeaderViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SimpleInfo;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.view.cardlist.EntityDataHelper;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import com.dinuscxj.ellipsize.EllipsizeTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0014J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedHeaderViewBinding;", "Lcom/coolapk/market/model/Feed;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedHeaderViewPart.kt */
public final class FeedHeaderViewPart extends BindingViewPart<ItemFeedHeaderViewBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558706;
    private final DataBindingComponent component;
    private Feed feed;

    public FeedHeaderViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedHeaderViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558706, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemFeedHeaderViewBinding) inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        SpannableStringBuilder spannableStringBuilder;
        EntityDataHelper entityDataHelper$presentation_coolapkAppRelease;
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedHeaderViewPart) feed2);
        this.feed = feed2;
        ((ItemFeedHeaderViewBinding) getBinding()).setClick(this);
        ((ItemFeedHeaderViewBinding) getBinding()).setModel(feed2);
        ((ItemFeedHeaderViewBinding) getBinding()).executePendingBindings();
        EntityListFragment entityListFragment = KotlinExtendKt.getEntityListFragment(this.component);
        SimpleInfo simpleInfo = null;
        EntityDataHelper.BaseAssistData obtainAssistData = (entityListFragment == null || (entityDataHelper$presentation_coolapkAppRelease = entityListFragment.getEntityDataHelper$presentation_coolapkAppRelease()) == null) ? null : entityDataHelper$presentation_coolapkAppRelease.obtainAssistData(feed2);
        if (!(obtainAssistData instanceof EntityDataHelper.FeedAssistData)) {
            obtainAssistData = null;
        }
        EntityDataHelper.FeedAssistData feedAssistData = (EntityDataHelper.FeedAssistData) obtainAssistData;
        int i = 0;
        if (feedAssistData != null) {
            EllipsizeTextView ellipsizeTextView = ((ItemFeedHeaderViewBinding) getBinding()).fromWhereView;
            Intrinsics.checkNotNullExpressionValue(ellipsizeTextView, "binding.fromWhereView");
            CharSequence headerInfoHtml = feedAssistData.getHeaderInfoHtml();
            ellipsizeTextView.setText(headerInfoHtml == null || headerInfoHtml.length() == 0 ? feed2.getInfo() : feedAssistData.getHeaderInfoHtml());
        } else {
            EllipsizeTextView ellipsizeTextView2 = ((ItemFeedHeaderViewBinding) getBinding()).fromWhereView;
            Intrinsics.checkNotNullExpressionValue(ellipsizeTextView2, "binding.fromWhereView");
            String infoHtml = feed2.getInfoHtml();
            if (infoHtml == null || infoHtml.length() == 0) {
                spannableStringBuilder = feed2.getInfo();
            } else {
                spannableStringBuilder = LinkTextUtils.convert(feed2.getInfoHtml(), AppHolder.getAppTheme().getColorAccent(), null);
            }
            ellipsizeTextView2.setText(spannableStringBuilder);
        }
        EllipsizeTextView ellipsizeTextView3 = ((ItemFeedHeaderViewBinding) getBinding()).fromWhereView;
        Intrinsics.checkNotNullExpressionValue(ellipsizeTextView3, "binding.fromWhereView");
        ViewExtendsKt.makeSpanClickable(ellipsizeTextView3);
        FeedWarningBinding feedWarningBinding = ((ItemFeedHeaderViewBinding) getBinding()).alertView;
        Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
        Feed feed3 = this.feed;
        BindingExtensionKt.updateInfo(feedWarningBinding, feed3 != null ? feed3.getInnerInfo() : null);
        FeedTopBinding feedTopBinding = ((ItemFeedHeaderViewBinding) getBinding()).topView;
        Intrinsics.checkNotNullExpressionValue(feedTopBinding, "binding.topView");
        Feed feed4 = this.feed;
        if (feed4 != null) {
            simpleInfo = feed4.getTopInfo();
        }
        Feed feed5 = this.feed;
        BindingExtensionKt.updateInfo(feedTopBinding, simpleInfo, feed5 != null ? feed5.isTop() : false);
        View view = ((ItemFeedHeaderViewBinding) getBinding()).topDivider;
        Intrinsics.checkNotNullExpressionValue(view, "binding.topDivider");
        FeedTopBinding feedTopBinding2 = ((ItemFeedHeaderViewBinding) getBinding()).topView;
        Intrinsics.checkNotNullExpressionValue(feedTopBinding2, "binding.topView");
        View root = feedTopBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.topView.root");
        if (!(root.getVisibility() == 0)) {
            i = 8;
        }
        view.setVisibility(i);
        if (EntityExtendsKt.isLoadFromHistoryApi(feed2)) {
            ImageView imageView = ((ItemFeedHeaderViewBinding) getBinding()).moreView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.moreView");
            imageView.setVisibility(8);
            TextView textView = ((ItemFeedHeaderViewBinding) getBinding()).modifyView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.modifyView");
            textView.setVisibility(8);
            if (feed2.getIsHistory() != 1) {
                TextView textView2 = ((ItemFeedHeaderViewBinding) getBinding()).timeView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.timeView");
                ViewExtendsKt.applyText(textView2, FeedHeaderViewPart$onBindToContent$1.INSTANCE);
            }
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            switch (view.getId()) {
                case 2131362595:
                    CharSequence text = ((TextView) view).getText();
                    if (text instanceof SpannableString) {
                        URLSpan[] uRLSpanArr = (URLSpan[]) ((SpannableString) text).getSpans(0, text.length(), URLSpan.class);
                        Intrinsics.checkNotNullExpressionValue(uRLSpanArr, "spans");
                        if (!(uRLSpanArr.length == 0)) {
                            uRLSpanArr[0].onClick(view);
                            return;
                        }
                        return;
                    }
                    return;
                case 2131362942:
                    if (feed2.getIsModified() == 1) {
                        ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
                        Context context = getContext();
                        String id = feed2.getId();
                        if (id == null) {
                            id = "";
                        }
                        actionManagerCompat.startFeedHistoryListActivity(context, id);
                        return;
                    }
                    return;
                case 2131362970:
                    showItemDialog();
                    return;
                case 2131363877:
                    ActionManager.startUserSpaceActivity(view, feed2.getUid(), feed2.getUserAvatar());
                    return;
                default:
                    super.onClick(view);
                    return;
            }
        }
    }

    private final void showItemDialog() {
        Feed feed2 = this.feed;
        if (feed2 != null) {
            EntityExtendsKt.showItemDialog(feed2, getContext());
        }
    }
}
