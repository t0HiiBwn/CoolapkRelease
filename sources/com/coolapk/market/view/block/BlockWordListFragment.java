package com.coolapk.market.view.block;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemBlockWordBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.ShortAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0018H\u0002¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/block/BlockWordListFragment;", "Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment;", "Landroid/os/Parcelable;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "removeBlockWord", "Lcom/coolapk/market/view/block/BlockItem;", "BlockWordViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlockWordListFragment.kt */
public final class BlockWordListFragment extends ShortAsyncListFragment<Parcelable> {
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Parcelable>> onCreateRequest(boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(BlockContentManager.INSTANCE.getBlockItems("word"));
        Observable<List<Parcelable>> just = Observable.just(arrayList);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(nodeList)");
        return just;
    }

    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558633).constructor(new BlockWordListFragment$onActivityCreated$1(new FragmentBindingComponent(this))).suitedMethod(BlockWordListFragment$onActivityCreated$2.INSTANCE).build(), 0, 2, null);
        setHasOptionsMenu(true);
        initData();
        setLoadMoreEnable(false);
        setRefreshEnable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.add(0, 0, 0, "添加").setShowAsAction(2);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 0) {
            AddBlockDialog addBlockDialog = AddBlockDialog.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            addBlockDialog.showAddBlockDialog(requireActivity, new BlockWordListFragment$onOptionsItemSelected$1(this));
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public final void removeBlockWord(BlockItem blockItem) {
        BlockContentManager.INSTANCE.updateSpamConfig(CollectionsKt.mutableListOf(new BlockItem(null, blockItem.getName(), null, null, false, null, "word", 61, null))).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new BlockWordListFragment$removeBlockWord$1(this, blockItem));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/block/BlockWordListFragment$BlockWordViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BlockWordListFragment.kt */
    public static final class BlockWordViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558633;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BlockWordViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemBlockWordBinding itemBlockWordBinding = (ItemBlockWordBinding) getBinding();
            TextView textView = itemBlockWordBinding.actionButton;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionButton");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), AppHolder.getAppTheme().getColorAccent());
            gradientDrawable.setCornerRadius(NumberExtendsKt.getDpf((Number) 14));
            Unit unit = Unit.INSTANCE;
            textView.setBackground(gradientDrawable);
            itemBlockWordBinding.actionButton.setOnClickListener(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/block/BlockWordListFragment$BlockWordViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: BlockWordListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemBlockWordBinding itemBlockWordBinding = (ItemBlockWordBinding) getBinding();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.block.BlockItem");
            Intrinsics.checkNotNullExpressionValue(itemBlockWordBinding, "binding");
            itemBlockWordBinding.setModel((BlockItem) obj);
            itemBlockWordBinding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            if (view.getId() == 2131361877) {
                DataBindingComponent component = getComponent();
                LifecycleOwner lifecycleOwner = null;
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (lifecycleOwner2 instanceof BlockWordListFragment) {
                    lifecycleOwner = lifecycleOwner2;
                }
                BlockWordListFragment blockWordListFragment = (BlockWordListFragment) lifecycleOwner;
                if (blockWordListFragment != null) {
                    ViewDataBinding binding = getBinding();
                    Intrinsics.checkNotNullExpressionValue(binding, "getBinding<ItemBlockWordBinding>()");
                    BlockItem model = ((ItemBlockWordBinding) binding).getModel();
                    if (model != null) {
                        Intrinsics.checkNotNullExpressionValue(model, "getBinding<ItemBlockWordBinding>().model ?: return");
                        blockWordListFragment.removeBlockWord(model);
                    }
                }
            }
        }
    }
}
