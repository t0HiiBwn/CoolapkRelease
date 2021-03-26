package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedSourceDeletedBinding;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSourceDeletedViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedSourceDeletedBinding;", "", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "setDeletedHint", "setUpdateHint", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedSourceDeletedViewPart.kt */
public final class FeedSourceDeletedViewPart extends BindingViewPart<ItemFeedSourceDeletedBinding, String> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558729;
    private final DataBindingComponent component;

    @JvmStatic
    public static final FeedSourceDeletedViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
        return Companion.newInstance(viewGroup, dataBindingComponent);
    }

    public /* synthetic */ FeedSourceDeletedViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataBindingComponent, itemActionHandler);
    }

    private FeedSourceDeletedViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        this.component = dataBindingComponent;
    }

    public void onBindToContent(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        ItemFeedSourceDeletedBinding itemFeedSourceDeletedBinding = (ItemFeedSourceDeletedBinding) getBinding();
        TextView textView = itemFeedSourceDeletedBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(str);
        itemFeedSourceDeletedBinding.executePendingBindings();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedSourceDeletedBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558729, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemFeedSourceDeletedBinding) inflate;
    }

    public final void setDeletedHint() {
        String string = getContext().getString(2131886782);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…str_feed_forward_deleted)");
        bindToContent(string);
    }

    public final void setUpdateHint() {
        String string = getContext().getString(2131886783);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…feed_forward_low_version)");
        bindToContent(string);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/FeedSourceDeletedViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "newInstance", "Lcom/coolapk/market/viewholder/FeedSourceDeletedViewPart;", "container", "Landroid/view/ViewGroup;", "component", "Landroidx/databinding/DataBindingComponent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedSourceDeletedViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FeedSourceDeletedViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            FeedSourceDeletedViewPart feedSourceDeletedViewPart = new FeedSourceDeletedViewPart(dataBindingComponent, null, null);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(container.context)");
            feedSourceDeletedViewPart.createView(from, viewGroup);
            return feedSourceDeletedViewPart;
        }
    }
}
