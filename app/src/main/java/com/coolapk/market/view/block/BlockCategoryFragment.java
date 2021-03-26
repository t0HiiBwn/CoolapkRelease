package com.coolapk.market.view.block;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemBlockHeaderBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.ShortAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0002¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/block/BlockCategoryFragment;", "Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment;", "Landroid/os/Parcelable;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestResponse", "result", "onResume", "updateTitle", "BlockHeaderViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlockCategoryFragment.kt */
public final class BlockCategoryFragment extends ShortAsyncListFragment<Parcelable> {
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Parcelable>> onCreateRequest(boolean z, int i) {
        Observable<R> map = BlockContentManager.INSTANCE.reloadBlockDataObservable().compose(RxUtils.apiCommonToData()).map(BlockCategoryFragment$onCreateRequest$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "BlockContentManager.relo…odeList\n                }");
        return map;
    }

    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558625).constructor(new BlockCategoryFragment$onActivityCreated$1(new FragmentBindingComponent(this))).suitedMethod(BlockCategoryFragment$onActivityCreated$2.INSTANCE).build(), 0, 2, null);
        initData();
        setLoadMoreEnable(false);
        setRefreshEnable(false);
        setHasOptionsMenu(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment
    public boolean onRequestResponse(boolean z, List<? extends Parcelable> list) {
        updateTitle();
        return super.onRequestResponse(z, (List) list);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateTitle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.add(0, 888, 0, "功能说明").setShowAsAction(2);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 888) {
            ActionManager.startWebViewActivity(getActivity(), "https://m.coolapk.com/mp/user/spamWordListDescription");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final void updateTitle() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("屏蔽管理（" + BlockContentManager.INSTANCE.getBlockNums() + '/' + BlockContentManager.INSTANCE.getBlockMaxCount() + (char) 65289);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/block/BlockCategoryFragment$BlockHeaderViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BlockCategoryFragment.kt */
    public static final class BlockHeaderViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558625;

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BlockHeaderViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemBlockHeaderBinding itemBlockHeaderBinding = (ItemBlockHeaderBinding) getBinding();
            itemBlockHeaderBinding.blockKeyView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.coolapk.market.view.block.BlockCategoryFragment.BlockHeaderViewHolder.AnonymousClass1 */
                final /* synthetic */ BlockHeaderViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActionManager.startUserBlockWordListActivity(this.this$0.getContext());
                }
            });
            itemBlockHeaderBinding.blockNodeView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.coolapk.market.view.block.BlockCategoryFragment.BlockHeaderViewHolder.AnonymousClass2 */
                final /* synthetic */ BlockHeaderViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActionManager.startUserBlockNodeListActivity(this.this$0.getContext());
                }
            });
            itemBlockHeaderBinding.blockUserView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.coolapk.market.view.block.BlockCategoryFragment.BlockHeaderViewHolder.AnonymousClass3 */
                final /* synthetic */ BlockHeaderViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActionManager.startUserBlockUserListActivity(this.this$0.getContext());
                }
            });
            itemBlockHeaderBinding.executePendingBindings();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/block/BlockCategoryFragment$BlockHeaderViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: BlockCategoryFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
