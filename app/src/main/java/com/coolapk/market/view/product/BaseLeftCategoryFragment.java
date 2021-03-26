package com.coolapk.market.view.product;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemProductBrandLeftItemBinding;
import com.coolapk.market.databinding.ProductBrandListBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.product.ISupportDisplayVerticalModeFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0011H\u0004J\u0012\u0010)\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\u0011H&J\u0018\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u0010/\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020&H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168B@BX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R*\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f` X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/coolapk/market/view/product/BaseLeftCategoryFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "getAdapter", "()Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "setAdapter", "(Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;)V", "binding", "Lcom/coolapk/market/databinding/ProductBrandListBinding;", "getBinding", "()Lcom/coolapk/market/databinding/ProductBrandListBinding;", "setBinding", "(Lcom/coolapk/market/databinding/ProductBrandListBinding;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "value", "", "isDisplayInVerticalMode", "()Z", "setDisplayInVerticalMode", "(Z)V", "isSupportDisplayInVerticalMode", "savedStateMaps", "Ljava/util/HashMap;", "", "Landroidx/fragment/app/Fragment$SavedState;", "Lkotlin/collections/HashMap;", "selectedIndex", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onBrandClick", "data", "onCreate", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "Companion", "ProductBrandIndicatorHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseLeftCategoryFragment.kt */
public abstract class BaseLeftCategoryFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_DATA_ARRAY = "EXTRA_DATA_ARRAY";
    private static final String EXTRA_INIT_INDEX = "EXTRA_INIT_INDEX";
    private static final String KEY_SELECT_INDEX = "EXTRA_SELECT_INDEX";
    private static final String KEY_VERTICAL_MODE = "PRODUCT_VERTICAL_MODE";
    private static final int LEFT_LAYOUT_ID = 2131558861;
    protected MultiTypeAdapter adapter;
    protected ProductBrandListBinding binding;
    private final ArrayList<Entity> dataList = new ArrayList<>();
    private final HashMap<String, Fragment.SavedState> savedStateMaps = new HashMap<>();
    private int selectedIndex = -1;

    public boolean isSupportDisplayInVerticalMode() {
        return true;
    }

    public abstract Fragment onCreateFragment(Entity entity);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/product/BaseLeftCategoryFragment$Companion;", "", "()V", "EXTRA_DATA_ARRAY", "", "EXTRA_INIT_INDEX", "KEY_SELECT_INDEX", "KEY_VERTICAL_MODE", "LEFT_LAYOUT_ID", "", "createBundle", "Landroid/os/Bundle;", "T", "Lcom/coolapk/market/model/Entity;", "list", "", "initIndex", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BaseLeftCategoryFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle createBundle$default(Companion companion, List list, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = -1;
            }
            return companion.createBundle(list, i);
        }

        public final <T extends Entity> Bundle createBundle(List<? extends T> list, int i) {
            Intrinsics.checkNotNullParameter(list, "list");
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.addAll(list);
            Unit unit = Unit.INSTANCE;
            bundle.putParcelableArrayList("EXTRA_DATA_ARRAY", arrayList);
            bundle.putInt("EXTRA_INIT_INDEX", i);
            return bundle;
        }
    }

    /* access modifiers changed from: protected */
    public final ProductBrandListBinding getBinding() {
        ProductBrandListBinding productBrandListBinding = this.binding;
        if (productBrandListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return productBrandListBinding;
    }

    /* access modifiers changed from: protected */
    public final void setBinding(ProductBrandListBinding productBrandListBinding) {
        Intrinsics.checkNotNullParameter(productBrandListBinding, "<set-?>");
        this.binding = productBrandListBinding;
    }

    /* access modifiers changed from: protected */
    public final MultiTypeAdapter getAdapter() {
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return multiTypeAdapter;
    }

    /* access modifiers changed from: protected */
    public final void setAdapter(MultiTypeAdapter multiTypeAdapter) {
        Intrinsics.checkNotNullParameter(multiTypeAdapter, "<set-?>");
        this.adapter = multiTypeAdapter;
    }

    private final boolean isDisplayInVerticalMode() {
        return DataManager.getInstance().getPreferencesBoolean("PRODUCT_VERTICAL_MODE", true);
    }

    private final void setDisplayInVerticalMode(boolean z) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("PRODUCT_VERTICAL_MODE", z).apply();
    }

    /* access modifiers changed from: protected */
    public final ArrayList<Entity> getDataList() {
        return this.dataList;
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putInt("EXTRA_SELECT_INDEX", this.selectedIndex);
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.selectedIndex = bundle.getInt("EXTRA_SELECT_INDEX", this.selectedIndex);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559107, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…d_list, container, false)");
        ProductBrandListBinding productBrandListBinding = (ProductBrandListBinding) inflate;
        this.binding = productBrandListBinding;
        if (productBrandListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return productBrandListBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            FragmentActivity fragmentActivity = activity;
            int actionBarSize = UiUtils.getActionBarSize(fragmentActivity) + UiUtils.getStatusBarHeight(fragmentActivity);
            ProductBrandListBinding productBrandListBinding = this.binding;
            if (productBrandListBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = productBrandListBinding.contentView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.contentView");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(frameLayout);
            if (marginParams != null) {
                marginParams.topMargin = actionBarSize;
            }
            ((AlphableToolbar) activity).setToolbarAlpha(1.0f);
        }
        ArrayList<Entity> arrayList = this.dataList;
        Collection<? extends Entity> parcelableArrayList = requireArguments().getParcelableArrayList("EXTRA_DATA_ARRAY");
        if (parcelableArrayList == null) {
            parcelableArrayList = CollectionsKt.emptyList();
        }
        arrayList.addAll(parcelableArrayList);
        this.adapter = new MultiTypeAdapter(this.dataList);
        ProductBrandListBinding productBrandListBinding2 = this.binding;
        if (productBrandListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = productBrandListBinding2.recyclerView;
        preventAutoScrollRecyclerView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        preventAutoScrollRecyclerView.setLayoutManager(new LinearLayoutManager(preventAutoScrollRecyclerView.getContext()));
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        preventAutoScrollRecyclerView.setAdapter(multiTypeAdapter);
        preventAutoScrollRecyclerView.setItemAnimator(null);
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(multiTypeAdapter2, SimpleViewHolderFactor.Companion.withLayoutId(2131558861).constructor(new BaseLeftCategoryFragment$onActivityCreated$2(this)).suitedEntityType("productBrand").build(), 0, 2, null);
        if (bundle == null) {
            int i = requireArguments().getInt("EXTRA_INIT_INDEX", -1);
            if (i >= 0 && i < this.dataList.size()) {
                Entity entity = this.dataList.get(i);
                Intrinsics.checkNotNullExpressionValue(entity, "dataList[initIndex]");
                onBrandClick(entity);
            } else if (!this.dataList.isEmpty()) {
                onBrandClick((Entity) CollectionsKt.first((List<? extends Object>) this.dataList));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onBrandClick(Entity entity) {
        Entity entity2;
        Fragment.SavedState saveFragmentInstanceState;
        Intrinsics.checkNotNullParameter(entity, "data");
        int i = this.selectedIndex;
        int indexOf = this.dataList.indexOf(entity);
        this.selectedIndex = indexOf;
        if (i != indexOf) {
            Fragment findFragmentById = getChildFragmentManager().findFragmentById(2131362594);
            String str = "";
            if (!(findFragmentById == null || (entity2 = (Entity) CollectionsKt.getOrNull(this.dataList, i)) == null || (saveFragmentInstanceState = getChildFragmentManager().saveFragmentInstanceState(findFragmentById)) == null)) {
                HashMap<String, Fragment.SavedState> hashMap = this.savedStateMaps;
                String title = entity2.getTitle();
                if (title == null) {
                    title = str;
                }
                hashMap.put(title, saveFragmentInstanceState);
            }
            MultiTypeAdapter multiTypeAdapter = this.adapter;
            if (multiTypeAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            multiTypeAdapter.notifyItemChanged(i);
            MultiTypeAdapter multiTypeAdapter2 = this.adapter;
            if (multiTypeAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            multiTypeAdapter2.notifyItemChanged(indexOf);
            Fragment onCreateFragment = onCreateFragment(entity);
            HashMap<String, Fragment.SavedState> hashMap2 = this.savedStateMaps;
            String title2 = entity.getTitle();
            if (title2 == null) {
                title2 = str;
            }
            Fragment.SavedState savedState = hashMap2.get(title2);
            if (savedState != null) {
                onCreateFragment.setInitialSavedState(savedState);
                HashMap<String, Fragment.SavedState> hashMap3 = this.savedStateMaps;
                String title3 = entity.getTitle();
                if (title3 != null) {
                    str = title3;
                }
                hashMap3.remove(str);
            }
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            if (findFragmentById != null) {
                beginTransaction.remove(findFragmentById);
            }
            beginTransaction.add(2131362594, onCreateFragment).commitAllowingStateLoss();
            getChildFragmentManager().executePendingTransactions();
            if (onCreateFragment instanceof ISupportDisplayVerticalModeFragment) {
                ISupportDisplayVerticalModeFragment.DefaultImpls.setDisplayInVerticalMode$default((ISupportDisplayVerticalModeFragment) onCreateFragment, isDisplayInVerticalMode(), false, 2, null);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isSupportDisplayInVerticalMode()) {
            MenuItem add = menu.add(0, 2131361860, 101, "切换");
            if (isDisplayInVerticalMode()) {
                add.setIcon(2131689480);
            } else {
                add.setIcon(2131689484);
            }
            add.setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361860) {
            return super.onOptionsItemSelected(menuItem);
        }
        setDisplayInVerticalMode(!isDisplayInVerticalMode());
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("PRODUCT_VERTICAL_MODE", isDisplayInVerticalMode()).apply();
        if (isDisplayInVerticalMode()) {
            menuItem.setIcon(2131689480);
        } else {
            menuItem.setIcon(2131689484);
        }
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(2131362594);
        if (findFragmentById instanceof ISupportDisplayVerticalModeFragment) {
            ISupportDisplayVerticalModeFragment.DefaultImpls.setDisplayInVerticalMode$default((ISupportDisplayVerticalModeFragment) findFragmentById, isDisplayInVerticalMode(), false, 2, null);
        }
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/product/BaseLeftCategoryFragment$ProductBrandIndicatorHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProductBrandLeftItemBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "(Lcom/coolapk/market/view/product/BaseLeftCategoryFragment;Landroid/view/View;)V", "bindToContent", "", "data", "setSelectedState", "select", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BaseLeftCategoryFragment.kt */
    public final class ProductBrandIndicatorHolder extends GenericBindHolder<ItemProductBrandLeftItemBinding, Entity> {
        final /* synthetic */ BaseLeftCategoryFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductBrandIndicatorHolder(BaseLeftCategoryFragment baseLeftCategoryFragment, View view) {
            super(view, null, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = baseLeftCategoryFragment;
        }

        @Override // com.coolapk.market.viewholder.GenericBindHolder
        public void bindToContent(Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "data");
            TextView textView = ((ItemProductBrandLeftItemBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(entity.getTitle());
            setSelectedState(this.this$0.selectedIndex == getAdapterPosition());
            ((ItemProductBrandLeftItemBinding) getBinding()).itemView.setOnClickListener(new BaseLeftCategoryFragment$ProductBrandIndicatorHolder$bindToContent$1(this, entity));
            ((ItemProductBrandLeftItemBinding) getBinding()).executePendingBindings();
        }

        private final void setSelectedState(boolean z) {
            if (z) {
                ((ItemProductBrandLeftItemBinding) getBinding()).titleView.setTextColor(AppHolder.getAppTheme().getColorAccent());
                View view = ((ItemProductBrandLeftItemBinding) getBinding()).indicatorView;
                Intrinsics.checkNotNullExpressionValue(view, "binding.indicatorView");
                view.setVisibility(0);
                ((ItemProductBrandLeftItemBinding) getBinding()).itemView.setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
                return;
            }
            ((ItemProductBrandLeftItemBinding) getBinding()).titleView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            View view2 = ((ItemProductBrandLeftItemBinding) getBinding()).indicatorView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.indicatorView");
            view2.setVisibility(8);
            ((ItemProductBrandLeftItemBinding) getBinding()).itemView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        }
    }
}
