package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedScrollItemBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001%B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001cH\u0002R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/coolapk/market/viewholder/FeedScrollItemViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedScrollItemBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/util/RVStateEventChangedAdapter$IStateViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "callback", "Lkotlin/Function0;", "Lcom/coolapk/market/model/EntityCard;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "extraTypeViewPart", "Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart;", "getExtraTypeViewPart", "()Lcom/coolapk/market/viewholder/FeedExtraTypeViewPart;", "extraTypeViewPart$delegate", "Lkotlin/Lazy;", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "bindHeaderViewPart", "", "bindToContent", "onClick", "view", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedScrollCardViewHolder.kt */
final class FeedScrollItemViewHolder extends GenericBindHolder<ItemFeedScrollItemBinding, Feed> implements RVStateEventChangedAdapter.IStateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558730;
    private final Function0<EntityCard> callback;
    private final Lazy extraTypeViewPart$delegate;
    private Feed feed;
    private final Lazy headerViewPart$delegate;

    private final FeedExtraTypeViewPart getExtraTypeViewPart() {
        return (FeedExtraTypeViewPart) this.extraTypeViewPart$delegate.getValue();
    }

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public final Function0<EntityCard> getCallback() {
        return this.callback;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function0<? extends com.coolapk.market.model.EntityCard> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedScrollItemViewHolder(View view, DataBindingComponent dataBindingComponent, Function0<? extends EntityCard> function0) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.callback = function0;
        this.headerViewPart$delegate = LazyKt.lazy(new FeedScrollItemViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.extraTypeViewPart$delegate = LazyKt.lazy(new FeedScrollItemViewHolder$extraTypeViewPart$2(this, dataBindingComponent));
        ItemFeedScrollItemBinding itemFeedScrollItemBinding = (ItemFeedScrollItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedScrollItemBinding, "binding");
        itemFeedScrollItemBinding.setClick(this);
        itemFeedScrollItemBinding.setTransformer(new CircleTransform(false, 0, 3, null));
        itemFeedScrollItemBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.FeedScrollItemViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedScrollItemViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                this.this$0.showItemDialog();
                return true;
            }
        });
    }

    @Override // com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return StateViewHolder.isEventBelongTo(event, feed2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedScrollItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedScrollCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        ItemFeedScrollItemBinding itemFeedScrollItemBinding = (ItemFeedScrollItemBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedScrollItemBinding, "binding");
        if (feed2 != itemFeedScrollItemBinding.getModel()) {
            itemFeedScrollItemBinding.setModel(feed2);
            bindHeaderViewPart();
            CoolEllipsizeTextView coolEllipsizeTextView = itemFeedScrollItemBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
            String message = feed2.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "feed.message");
            ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 3, message);
            LinearLayout linearLayout = itemFeedScrollItemBinding.cardView;
            linearLayout.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
            List<Entity> entities = this.callback.invoke().getEntities();
            Intrinsics.checkNotNull(entities);
            if (entities.size() == 1) {
                linearLayout.getLayoutParams().width = -1;
            } else {
                linearLayout.getLayoutParams().width = (DisplayUtils.getDecorMinSideLength(linearLayout.getContext()) / 4) * 3;
            }
        }
        getExtraTypeViewPart().bindToContent(feed2);
        itemFeedScrollItemBinding.executePendingBindings();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedScrollItemBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed2.getFeedTypeName());
    }

    private final void bindHeaderViewPart() {
        FeedIntegratedHeaderViewPart headerViewPart = getHeaderViewPart();
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        headerViewPart.bindTo(feed2);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        if (view.getId() != 2131362205) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed2), null, null, 12, null);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        instance.recordEntityEvent(baseFragment != null ? baseFragment.getFixedRecordId() : null, feed2, getAdapterPosition(), this.callback.invoke(), "横向滚动动态");
    }

    /* access modifiers changed from: private */
    public final void showItemDialog() {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EntityExtendsKt.showItemDialog(feed2, context);
    }
}
