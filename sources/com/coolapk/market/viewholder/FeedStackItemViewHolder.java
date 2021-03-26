package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedStackItemBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0002R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/viewholder/FeedStackItemViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedStackItemBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "callback", "Lkotlin/Function0;", "Lcom/coolapk/market/model/EntityCard;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "bindToContent", "", "feed", "onClick", "view", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedStackCardViewHolder.kt */
final class FeedStackItemViewHolder extends GenericBindHolder<ItemFeedStackItemBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558738;
    private final Function0<EntityCard> callback;
    private final Lazy headerViewPart$delegate;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public final Function0<EntityCard> getCallback() {
        return this.callback;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends com.coolapk.market.model.EntityCard> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedStackItemViewHolder(View view, DataBindingComponent dataBindingComponent, Function0<? extends EntityCard> function0) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.callback = function0;
        this.headerViewPart$delegate = LazyKt.lazy(new FeedStackItemViewHolder$headerViewPart$2(this, dataBindingComponent));
        ItemFeedStackItemBinding itemFeedStackItemBinding = (ItemFeedStackItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedStackItemBinding, "binding");
        itemFeedStackItemBinding.setClick(this);
        itemFeedStackItemBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.FeedStackItemViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedStackItemViewHolder this$0;

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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedStackItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedStackCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        ItemFeedStackItemBinding itemFeedStackItemBinding = (ItemFeedStackItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedStackItemBinding, "binding");
        if (!Intrinsics.areEqual(feed, itemFeedStackItemBinding.getModel())) {
            itemFeedStackItemBinding.setModel(feed);
            getHeaderViewPart().bindTo(feed);
            CoolEllipsizeTextView coolEllipsizeTextView = itemFeedStackItemBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
            String message = feed.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "feed.message");
            ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 3, message);
            LinearLayout linearLayout = itemFeedStackItemBinding.cardView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
            Context context = getContext();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setStroke(NumberExtendsKt.getDp(Double.valueOf(0.5d)), AppHolder.getAppTheme().getCurrencyColorDivider());
            gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 8));
            Unit unit = Unit.INSTANCE;
            linearLayout.setBackground(ShapeUtils.createSelectableItemBackgroundWith(context, gradientDrawable));
            itemFeedStackItemBinding.executePendingBindings();
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            View root = itemFeedStackItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            instance.traceFeedStayInList(root, feed.getFeedTypeName());
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemFeedStackItemBinding itemFeedStackItemBinding = (ItemFeedStackItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedStackItemBinding, "binding");
        Feed model = itemFeedStackItemBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            if (view.getId() != 2131362205) {
                super.onClick(view);
                return;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(model), null, null, 12, null);
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
            StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, model, getAdapterPosition(), this.callback.invoke(), null, 16, null);
        }
    }

    /* access modifiers changed from: private */
    public final void showItemDialog() {
        ItemFeedStackItemBinding itemFeedStackItemBinding = (ItemFeedStackItemBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedStackItemBinding, "binding");
        Feed model = itemFeedStackItemBinding.getModel();
        if (model != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            EntityExtendsKt.showItemDialog(model, context);
        }
    }
}
