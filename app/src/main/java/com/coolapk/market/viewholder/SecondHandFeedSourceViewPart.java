package com.coolapk.market.viewholder;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedSourcePartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UserUtils;
import com.coolapk.market.viewholder.SecondHandFeedSourceViewPart$secondHandHeaderPart$2;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0011\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001fB\u0019\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/coolapk/market/viewholder/SecondHandFeedSourceViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedSourcePartBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "ninePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNinePicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "ninePicViewPart$delegate", "Lkotlin/Lazy;", "secondHandHeaderPart", "com/coolapk/market/viewholder/SecondHandFeedSourceViewPart$secondHandHeaderPart$2$1", "getSecondHandHeaderPart", "()Lcom/coolapk/market/viewholder/SecondHandFeedSourceViewPart$secondHandHeaderPart$2$1;", "secondHandHeaderPart$delegate", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onRecycled", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandFeedSourceViewPart.kt */
public final class SecondHandFeedSourceViewPart extends BindingViewPart<ItemFeedSourcePartBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558730;
    private final DataBindingComponent component;
    private final Lazy ninePicViewPart$delegate;
    private final Lazy secondHandHeaderPart$delegate;

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    private final SecondHandFeedSourceViewPart$secondHandHeaderPart$2.AnonymousClass1 getSecondHandHeaderPart() {
        return (SecondHandFeedSourceViewPart$secondHandHeaderPart$2.AnonymousClass1) this.secondHandHeaderPart$delegate.getValue();
    }

    @JvmStatic
    public static final SecondHandFeedSourceViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
        return Companion.newInstance(viewGroup, dataBindingComponent);
    }

    public /* synthetic */ SecondHandFeedSourceViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataBindingComponent, itemActionHandler);
    }

    private SecondHandFeedSourceViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        this.component = dataBindingComponent;
        this.ninePicViewPart$delegate = LazyKt.lazy(new SecondHandFeedSourceViewPart$ninePicViewPart$2(this));
        this.secondHandHeaderPart$delegate = LazyKt.lazy(new SecondHandFeedSourceViewPart$secondHandHeaderPart$2(this));
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
    }

    public void onBindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        ItemFeedSourcePartBinding itemFeedSourcePartBinding = (ItemFeedSourcePartBinding) getBinding();
        String uid = feed.getUid();
        SpannableStringBuilder convert = LinkTextUtils.convert(UserUtils.getUserSpan(uid, "@" + feed.getUserName()), AppHolder.getAppTheme().getColorAccent(), null);
        String message = feed.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "source.message");
        LinkTextUtils.convert(new Regex("[\\n\\r]").replace(message, " "), AppHolder.getAppTheme().getColorAccent(), null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886656));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(convert);
        CoolEllipsizeTextView coolEllipsizeTextView = itemFeedSourcePartBinding.textView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
        ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView, 4, spannableStringBuilder2, spannableStringBuilder, false, 8, null);
        CoolEllipsizeTextView coolEllipsizeTextView2 = itemFeedSourcePartBinding.bottomTextView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.bottomTextView");
        coolEllipsizeTextView2.setText((CharSequence) null);
        CoolEllipsizeTextView coolEllipsizeTextView3 = itemFeedSourcePartBinding.bottomTextView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView3, "binding.bottomTextView");
        coolEllipsizeTextView3.setVisibility(8);
        getNinePicViewPart().setMaxShowCount(3);
        getNinePicViewPart().setFullSizeWhenOne(false);
        getNinePicViewPart().bindToContent(EntityExtendsKt.getHtmlPicArray(feed));
        getSecondHandHeaderPart().bindTo(feed);
        itemFeedSourcePartBinding.textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        ViewExtendsKt.setUtilClickListener(getView(), new SecondHandFeedSourceViewPart$onBindToContent$1(this, feed));
        itemFeedSourcePartBinding.executePendingBindings();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedSourcePartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558730, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemFeedSourcePartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        getSecondHandHeaderPart().onRecycled();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/SecondHandFeedSourceViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "newInstance", "Lcom/coolapk/market/viewholder/SecondHandFeedSourceViewPart;", "container", "Landroid/view/ViewGroup;", "component", "Landroidx/databinding/DataBindingComponent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandFeedSourceViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SecondHandFeedSourceViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            SecondHandFeedSourceViewPart secondHandFeedSourceViewPart = new SecondHandFeedSourceViewPart(dataBindingComponent, null, null);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(container.context)");
            secondHandFeedSourceViewPart.createView(from, viewGroup);
            return secondHandFeedSourceViewPart;
        }
    }
}
