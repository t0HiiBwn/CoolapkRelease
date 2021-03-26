package com.coolapk.market.viewholder.v8;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedCoolPicLayoutBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.search.SuperSearchActivity;
import com.coolapk.market.view.search.SuperSearchResultActivity;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.CoolPicViewPart;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0002\u001b\u001f\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001'B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\"H\u0016R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/viewholder/v8/CoolPicViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedCoolPicLayoutBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "urlParams", "", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Ljava/lang/String;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "coolPicViewPart", "Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart;", "getCoolPicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/CoolPicViewPart;", "coolPicViewPart$delegate", "Lkotlin/Lazy;", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "hotReplyHotPlug", "com/coolapk/market/viewholder/v8/CoolPicViewHolder$hotReplyHotPlug$1", "Lcom/coolapk/market/viewholder/v8/CoolPicViewHolder$hotReplyHotPlug$1;", "listType", "relativeInfoHotPlug", "com/coolapk/market/viewholder/v8/CoolPicViewHolder$relativeInfoHotPlug$1", "Lcom/coolapk/market/viewholder/v8/CoolPicViewHolder$relativeInfoHotPlug$1;", "bindToContent", "", "fixLayoutBug", "onClick", "view", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewHolder.kt */
public final class CoolPicViewHolder extends GenericBindHolder<ItemFeedCoolPicLayoutBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558701;
    private final Lazy coolPicViewPart$delegate;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final CoolPicViewHolder$hotReplyHotPlug$1 hotReplyHotPlug;
    private String listType = "list";
    private final CoolPicViewHolder$relativeInfoHotPlug$1 relativeInfoHotPlug;
    private final String urlParams;

    private final CoolPicViewPart getCoolPicViewPart() {
        return (CoolPicViewPart) this.coolPicViewPart$delegate.getValue();
    }

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getFeed$p(CoolPicViewHolder coolPicViewHolder) {
        Feed feed2 = coolPicViewHolder.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolPicViewHolder(String str, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(str, "urlParams");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.urlParams = str;
        this.coolPicViewPart$delegate = LazyKt.lazy(new CoolPicViewHolder$coolPicViewPart$2(this, dataBindingComponent));
        this.headerViewPart$delegate = LazyKt.lazy(new CoolPicViewHolder$headerViewPart$2(this, dataBindingComponent));
        Space space = ((ItemFeedCoolPicLayoutBinding) getBinding()).hotReplySpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.hotReplySpaceView");
        this.hotReplyHotPlug = new CoolPicViewHolder$hotReplyHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        Space space2 = ((ItemFeedCoolPicLayoutBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new CoolPicViewHolder$relativeInfoHotPlug$1(this, dataBindingComponent, space2, dataBindingComponent);
        ItemFeedCoolPicLayoutBinding itemFeedCoolPicLayoutBinding = (ItemFeedCoolPicLayoutBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedCoolPicLayoutBinding, "binding");
        itemFeedCoolPicLayoutBinding.setClick(this);
        itemFeedCoolPicLayoutBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.CoolPicViewHolder.AnonymousClass1 */
            final /* synthetic */ CoolPicViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed access$getFeed$p = CoolPicViewHolder.access$getFeed$p(this.this$0);
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(access$getFeed$p, context);
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/CoolPicViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolPicViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.hotReplyHotPlug.onRecycled();
        getCoolPicViewPart().onRecycled();
        this.relativeInfoHotPlug.onRecycled();
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        ItemFeedCoolPicLayoutBinding itemFeedCoolPicLayoutBinding = (ItemFeedCoolPicLayoutBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedCoolPicLayoutBinding, "binding");
        itemFeedCoolPicLayoutBinding.setModel(feed2);
        getCoolPicViewPart().bindToContent(feed2);
        DataBindingComponent component = getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof EntityListFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        if (((EntityListFragment) lifecycleOwner) instanceof EntityListFragment) {
            String str = getAdapterPosition() == 0 ? "old" : "both";
            getCoolPicViewPart().setParams(str + ',' + this.urlParams);
        }
        getHeaderViewPart().bindTo(feed2);
        this.relativeInfoHotPlug.bindTo(feed2);
        this.hotReplyHotPlug.bindTo(feed2);
        itemFeedCoolPicLayoutBinding.executePendingBindings();
        fixLayoutBug();
        TextView textView = itemFeedCoolPicLayoutBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        String message = feed2.getMessage();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886718));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
        Unit unit = Unit.INSTANCE;
        ViewExtendsKt.setBriefMessage(textView, 90, message, spannableStringBuilder);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedCoolPicLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed2.getFeedTypeName());
    }

    private final void fixLayoutBug() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        if (!view.isLayoutRequested()) {
            this.itemView.requestLayout();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362205) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        boolean z = false;
        this.listType = ((activityNullable instanceof SuperSearchActivity) || (activityNullable instanceof SuperSearchResultActivity)) ? "search" : StringsKt.contains$default(this.urlParams, "uid", false, 2, null) ? "user" : "list";
        Context context2 = getContext();
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String str = this.listType;
        if (getAdapterPosition() == 0) {
            z = true;
        }
        ActionManager.startCoolPicActivity(context2, feed2, str, z ? "old" : "both", this.urlParams);
    }
}
