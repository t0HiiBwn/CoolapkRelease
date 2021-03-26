package com.coolapk.market.view.center;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemCenterMoreMenuBinding;
import com.coolapk.market.databinding.ItemCenterMoreTitleBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.base.refresh.LocalMultiTypeFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.SimpleDiffCallback;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0006\u0010\u001c\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreFragment;", "Lcom/coolapk/market/view/base/refresh/LocalMultiTypeFragment;", "Lcom/coolapk/market/model/HolderItem;", "Lcom/coolapk/market/view/center/CenterMoreListener;", "()V", "centerMorePresenter", "Lcom/coolapk/market/view/center/CenterMorePresenter;", "initData", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroy", "onEditModeChange", "isEditMode", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onUserMenuListChanged", "menuList", "", "Lcom/coolapk/market/view/center/UserMenu;", "reloadData", "CenterMoreMenuViewHolder", "CenterMoreTitleViewHolder", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterMoreFragment.kt */
public final class CenterMoreFragment extends LocalMultiTypeFragment<HolderItem> implements CenterMoreListener {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_ENTRANCE = "entity_type_entrance";
    public static final String ENTITY_TYPE_MENU = "entity_type_menu";
    public static final String ENTITY_TYPE_TITLE = "entity_type_title";
    private final CenterMorePresenter centerMorePresenter = new CenterMorePresenter();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreFragment$Companion;", "", "()V", "ENTITY_TYPE_ENTRANCE", "", "ENTITY_TYPE_MENU", "ENTITY_TYPE_TITLE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterMoreFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.refresh.LocalMultiTypeFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        setEmptyData(getString(2131886827), 0);
        FragmentBindingComponent fragmentBindingComponent = new FragmentBindingComponent(this);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558648).suitedEntityType("entity_type_title").constructor(new CenterMoreFragment$onActivityCreated$1(fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558647).suitedEntityType("entity_type_menu").constructor(new CenterMoreFragment$onActivityCreated$2(this, fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558645).suitedEntityType("entity_type_entrance").constructor(new CenterMoreFragment$onActivityCreated$3(this, fragmentBindingComponent)).build(), 0, 2, null);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipChildren(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        getRecyclerView().setPadding(0, 0, 0, NumberExtendsKt.getDp((Number) 64));
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView3.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(300);
        }
        RecyclerView recyclerView4 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView4.getItemAnimator();
        if (itemAnimator2 != null) {
            itemAnimator2.setMoveDuration(300);
        }
        RecyclerView recyclerView5 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView5.getItemAnimator();
        if (itemAnimator3 != null) {
            itemAnimator3.setAddDuration(300);
        }
        RecyclerView recyclerView6 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView6, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator4 = recyclerView6.getItemAnimator();
        if (itemAnimator4 != null) {
            itemAnimator4.setRemoveDuration(300);
        }
        initData();
        this.centerMorePresenter.addCenterMoreListener(this);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.centerMorePresenter.removeCenterMoreListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.add(1, 2131361932, 100, "恢复默认").setShowAsAction(8);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361932) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.centerMorePresenter.requestRestoreDefaultMenuList();
        return true;
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        List<UserMenu> editingMenuList = this.centerMorePresenter.getEditingMenuList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(editingMenuList, 10));
        Iterator<T> it2 = editingMenuList.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getType());
        }
        ArrayList arrayList2 = arrayList;
        List dataList = getDataList();
        dataList.clear();
        dataList.add(HolderItem.newBuilder().entityType("entity_type_entrance").build());
        dataList.add(HolderItem.newBuilder().entityType("entity_type_title").title("更多功能").build());
        Iterator<T> it3 = this.centerMorePresenter.getMenuPresenter().getGroupedMenuList().iterator();
        while (it3.hasNext()) {
            boolean z = false;
            for (String str : it3.next()) {
                if (this.centerMorePresenter.getMenuPresenter().getUserMenuByType(str) != null && !arrayList2.contains(str)) {
                    z = true;
                    dataList.add(HolderItem.newBuilder().entityType("entity_type_menu").string(str).build());
                }
            }
            if (z) {
                dataList.add(HolderItem.newBuilder().entityType("entity_type_title").build());
            }
        }
    }

    public final void reloadData() {
        setNotifyAdapter(false);
        ArrayList arrayList = new ArrayList();
        List dataList = getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        arrayList.addAll(dataList);
        initData();
        List dataList2 = getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList2, "dataList");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SimpleDiffCallback(arrayList, dataList2), true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(S…empList, dataList), true)");
        calculateDiff.dispatchUpdatesTo(getAdapter());
        setNotifyAdapter(true);
    }

    @Override // com.coolapk.market.view.center.CenterMoreListener
    public void onEditModeChange(boolean z) {
        List dataList = getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        int i = 0;
        for (Object obj : dataList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HolderItem holderItem = (HolderItem) obj;
            Intrinsics.checkNotNullExpressionValue(holderItem, "holderItem");
            if (Intrinsics.areEqual(holderItem.getEntityType(), "entity_type_menu")) {
                getAdapter().notifyItemChanged(i);
            }
            i = i2;
        }
    }

    @Override // com.coolapk.market.view.center.CenterMoreListener
    public void onUserMenuListChanged(List<UserMenu> list) {
        Intrinsics.checkNotNullParameter(list, "menuList");
        reloadData();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreFragment$CenterMoreTitleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCenterMoreTitleBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterMoreFragment.kt */
    private static final class CenterMoreTitleViewHolder extends GenericBindHolder<ItemCenterMoreTitleBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558648;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CenterMoreTitleViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreFragment$CenterMoreTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: CenterMoreFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            TextView textView = ((ItemCenterMoreTitleBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            String title = holderItem.getTitle();
            int i = 0;
            if (title == null || StringsKt.isBlank(title)) {
                i = 8;
            }
            textView.setVisibility(i);
            TextView textView2 = ((ItemCenterMoreTitleBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setText(holderItem.getTitle());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreFragment$CenterMoreMenuViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCenterMoreMenuBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterMorePresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterMorePresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/center/CenterMorePresenter;", "bindToContent", "", "data", "setBubbleUI", "userMenu", "Lcom/coolapk/market/view/center/UserMenu;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterMoreFragment.kt */
    private static final class CenterMoreMenuViewHolder extends GenericBindHolder<ItemCenterMoreMenuBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558647;
        private final CenterMorePresenter presenter;

        public final CenterMorePresenter getPresenter() {
            return this.presenter;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CenterMoreMenuViewHolder(View view, DataBindingComponent dataBindingComponent, CenterMorePresenter centerMorePresenter) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(centerMorePresenter, "presenter");
            this.presenter = centerMorePresenter;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreFragment$CenterMoreMenuViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: CenterMoreFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            CenterUserMenuPresenter menuPresenter = this.presenter.getMenuPresenter();
            String string = holderItem.getString();
            if (string == null) {
                string = "";
            }
            UserMenu userMenuByType = menuPresenter.getUserMenuByType(string);
            if (userMenuByType != null) {
                ((ItemCenterMoreMenuBinding) getBinding()).textView.setText(userMenuByType.getTitleRes());
                ((ItemCenterMoreMenuBinding) getBinding()).imageView.setImageResource(userMenuByType.getIconRes());
                ImageView imageView = ((ItemCenterMoreMenuBinding) getBinding()).imageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
                imageView.setImageTintList(ColorStateList.valueOf(userMenuByType.getTintColor()));
                if (this.presenter.isEditing()) {
                    ImageView imageView2 = ((ItemCenterMoreMenuBinding) getBinding()).addView;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.addView");
                    imageView2.setVisibility(0);
                    ((ItemCenterMoreMenuBinding) getBinding()).addView.setOnClickListener(new CenterMoreFragment$CenterMoreMenuViewHolder$bindToContent$1(this, userMenuByType));
                    ImageView imageView3 = ((ItemCenterMoreMenuBinding) getBinding()).moreView;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.moreView");
                    imageView3.setVisibility(8);
                    LinearLayout linearLayout = ((ItemCenterMoreMenuBinding) getBinding()).itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
                    linearLayout.setClickable(false);
                } else {
                    ImageView imageView4 = ((ItemCenterMoreMenuBinding) getBinding()).addView;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "binding.addView");
                    imageView4.setVisibility(8);
                    ImageView imageView5 = ((ItemCenterMoreMenuBinding) getBinding()).moreView;
                    Intrinsics.checkNotNullExpressionValue(imageView5, "binding.moreView");
                    imageView5.setVisibility(0);
                    LinearLayout linearLayout2 = ((ItemCenterMoreMenuBinding) getBinding()).itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.itemView");
                    ViewExtendsKt.setUtilClickListener(linearLayout2, new CenterMoreFragment$CenterMoreMenuViewHolder$bindToContent$2(this, menuPresenter, userMenuByType));
                }
                ((ItemCenterMoreMenuBinding) getBinding()).executePendingBindings();
                setBubbleUI(userMenuByType);
            }
        }

        private final void setBubbleUI(UserMenu userMenu) {
            TextView textView = ((ItemCenterMoreMenuBinding) getBinding()).bubbleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.bubbleTextView");
            textView.setText(userMenu.getBubbleLongText());
            textView.setVisibility((!userMenu.getShowBubble() || this.presenter.isEditing()) ? 8 : 0);
            if (textView.getVisibility() == 8) {
                ViewParent parent = textView.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).setTouchDelegate(null);
                textView.setOnTouchListener(null);
                return;
            }
            DragAndDropHelper.withTarget(textView).setPaintColor(AppHolder.getAppTheme().getColorAccent()).setDragListener(new CenterMoreFragment$CenterMoreMenuViewHolder$setBubbleUI$1(this, userMenu)).apply();
        }
    }
}
