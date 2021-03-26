package com.coolapk.market.view.block;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemBlockUserBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.ShortAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/block/BlockUserListFragment;", "Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment;", "Landroid/os/Parcelable;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "", "removeBlockNode", "blockItem", "Lcom/coolapk/market/view/block/BlockItem;", "BlockUserViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlockUserListFragment.kt */
public final class BlockUserListFragment extends ShortAsyncListFragment<Parcelable> {
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Parcelable>> onCreateRequest(boolean z, int i) {
        Observable<List<Parcelable>> just = Observable.just(BlockContentManager.INSTANCE.getBlockItems("user"));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(BlockCon…ems(BlockItem.USER_TYPE))");
        return just;
    }

    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558627).constructor(new BlockUserListFragment$onActivityCreated$1(new FragmentBindingComponent(this))).suitedMethod(BlockUserListFragment$onActivityCreated$2.INSTANCE).build(), 0, 2, null);
        initData();
        setLoadMoreEnable(false);
        setRefreshEnable(false);
    }

    /* access modifiers changed from: private */
    public final void removeBlockNode(BlockItem blockItem) {
        BlockContentManager.INSTANCE.updateSpamConfig(CollectionsKt.listOf(BlockItem.copy$default(blockItem, null, null, null, null, false, null, null, 111, null))).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new BlockUserListFragment$removeBlockNode$1(this, blockItem));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/block/BlockUserListFragment$BlockUserViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BlockUserListFragment.kt */
    public static final class BlockUserViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558627;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BlockUserViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemBlockUserBinding itemBlockUserBinding = (ItemBlockUserBinding) getBinding();
            TextView textView = itemBlockUserBinding.actionButton;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionButton");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), AppHolder.getAppTheme().getColorAccent());
            gradientDrawable.setCornerRadius(NumberExtendsKt.getDpf((Number) 14));
            Unit unit = Unit.INSTANCE;
            textView.setBackground(gradientDrawable);
            BlockUserViewHolder blockUserViewHolder = this;
            itemBlockUserBinding.actionButton.setOnClickListener(blockUserViewHolder);
            itemBlockUserBinding.cardView.setOnClickListener(blockUserViewHolder);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/block/BlockUserListFragment$BlockUserViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: BlockUserListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemBlockUserBinding itemBlockUserBinding = (ItemBlockUserBinding) getBinding();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.block.BlockItem");
            Intrinsics.checkNotNullExpressionValue(itemBlockUserBinding, "binding");
            itemBlockUserBinding.setModel((BlockItem) obj);
            itemBlockUserBinding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            int id = view.getId();
            if (id == 2131361876) {
                DataBindingComponent component = getComponent();
                LifecycleOwner lifecycleOwner = null;
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (lifecycleOwner2 instanceof BlockUserListFragment) {
                    lifecycleOwner = lifecycleOwner2;
                }
                BlockUserListFragment blockUserListFragment = (BlockUserListFragment) lifecycleOwner;
                if (blockUserListFragment != null) {
                    ViewDataBinding binding = getBinding();
                    Intrinsics.checkNotNullExpressionValue(binding, "getBinding<ItemBlockUserBinding>()");
                    BlockItem model = ((ItemBlockUserBinding) binding).getModel();
                    if (model != null) {
                        Intrinsics.checkNotNullExpressionValue(model, "getBinding<ItemBlockUserBinding>().model ?: return");
                        blockUserListFragment.removeBlockNode(model);
                    }
                }
            } else if (id == 2131362200) {
                ViewDataBinding binding2 = getBinding();
                Intrinsics.checkNotNullExpressionValue(binding2, "getBinding<ItemBlockUserBinding>()");
                BlockItem model2 = ((ItemBlockUserBinding) binding2).getModel();
                if (model2 != null) {
                    Intrinsics.checkNotNullExpressionValue(model2, "getBinding<ItemBlockUserBinding>().model ?: return");
                    ActionManager.startUserSpaceActivity(getContext(), model2.getName());
                }
            }
        }
    }
}
