package com.coolapk.market.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemSearchSceneBinding;
import com.coolapk.market.databinding.SearchSceneItemBinding;
import com.coolapk.market.databinding.SearchSceneListBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.rd.PageIndicatorView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0005\u000e\u000f\u0010\u0011\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemSearchSceneBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "Companion", "DataAdapter", "DataViewHolder", "PageAdapter", "SearchSceneItemFragment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchSceneViewHolder.kt */
public final class SearchSceneViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558915;
    private final ItemSearchSceneBinding binding = ((ItemSearchSceneBinding) getBinding());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchSceneViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchSceneViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Card<com.coolapk.market.model.Entity>");
        Card card = (Card) obj;
        List entities = card.getEntities();
        Intrinsics.checkNotNull(entities);
        Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
        Iterable withIndex = CollectionsKt.withIndex(entities);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : withIndex) {
            Integer valueOf = Integer.valueOf(((IndexedValue) obj2).getIndex() / 8);
            Object obj3 = linkedHashMap.get(valueOf);
            if (obj3 == null) {
                obj3 = (List) new ArrayList();
                linkedHashMap.put(valueOf, obj3);
            }
            ((List) obj3).add(obj2);
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Iterable<IndexedValue> iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (IndexedValue indexedValue : iterable) {
                arrayList2.add((Entity) indexedValue.getValue());
            }
            arrayList.add(arrayList2);
        }
        ArrayList arrayList3 = arrayList;
        DataBindingComponent component = getComponent();
        Objects.requireNonNull(component, "null cannot be cast to non-null type com.coolapk.market.binding.FragmentBindingComponent");
        Fragment fragment = (Fragment) ((FragmentBindingComponent) component).getContainer();
        Intrinsics.checkNotNull(fragment);
        Intrinsics.checkNotNullExpressionValue(fragment, "(component as FragmentBi…ingComponent).container!!");
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "(component as FragmentBi…er!!.childFragmentManager");
        PageAdapter pageAdapter = new PageAdapter(childFragmentManager);
        pageAdapter.setDataList(arrayList3);
        ViewPager viewPager = this.binding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
        viewPager.setAdapter(pageAdapter);
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(card.getTitle());
        TextView textView2 = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        String title = card.getTitle();
        textView2.setVisibility(title == null || title.length() == 0 ? 8 : 0);
        PageIndicatorView pageIndicatorView = this.binding.pageIndicatorView;
        Intrinsics.checkNotNullExpressionValue(pageIndicatorView, "binding.pageIndicatorView");
        ViewGroup.LayoutParams layoutParams = pageIndicatorView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = arrayList3.size() > 1 ? NumberExtendsKt.getDp((Number) 8) : -NumberExtendsKt.getDp((Number) 4);
        PageIndicatorView pageIndicatorView2 = this.binding.pageIndicatorView;
        Intrinsics.checkNotNullExpressionValue(pageIndicatorView2, "binding.pageIndicatorView");
        ViewGroup.LayoutParams layoutParams2 = pageIndicatorView2.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = NumberExtendsKt.getDp(arrayList3.size() > 1 ? 8 : 0);
        ViewPager viewPager2 = this.binding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.getLayoutParams().height = NumberExtendsKt.getDp(Integer.valueOf(((List) arrayList3.get(0)).size() > 4 ? 80 : 40));
        this.binding.executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\rH\u0016R(\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder$PageAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "dataList", "", "Lcom/coolapk/market/model/Entity;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemTag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchSceneViewHolder.kt */
    public static final class PageAdapter extends FragmentStatePagerAdapter {
        private List<? extends List<? extends Entity>> dataList;

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return "";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends java.util.List<? extends com.coolapk.market.model.Entity>>, java.util.List<java.util.List<com.coolapk.market.model.Entity>> */
        public final List<List<Entity>> getDataList() {
            return this.dataList;
        }

        public final void setDataList(List<? extends List<? extends Entity>> list) {
            this.dataList = list;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            SearchSceneItemFragment.Companion companion = SearchSceneItemFragment.Companion;
            List<? extends List<? extends Entity>> list = this.dataList;
            Intrinsics.checkNotNull(list);
            return companion.newInstance(new ArrayList<>((Collection) list.get(i)));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<? extends List<? extends Entity>> list = this.dataList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder$SearchSceneItemFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchSceneViewHolder.kt */
    public static final class SearchSceneItemFragment extends Fragment {
        public static final Companion Companion = new Companion(null);
        public static final String KEY_ENTITIES = "ENTITIES";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder$SearchSceneItemFragment$Companion;", "", "()V", "KEY_ENTITIES", "", "newInstance", "Lcom/coolapk/market/viewholder/SearchSceneViewHolder$SearchSceneItemFragment;", "entities", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SearchSceneViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SearchSceneItemFragment newInstance(ArrayList<Entity> arrayList) {
                Intrinsics.checkNotNullParameter(arrayList, "entities");
                SearchSceneItemFragment searchSceneItemFragment = new SearchSceneItemFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("ENTITIES", arrayList);
                Unit unit = Unit.INSTANCE;
                searchSceneItemFragment.setArguments(bundle);
                return searchSceneItemFragment;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            SearchSceneListBinding searchSceneListBinding = (SearchSceneListBinding) DataBindingUtil.inflate(layoutInflater, 2131559131, viewGroup, false);
            RecyclerView recyclerView = searchSceneListBinding.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
            RecyclerView recyclerView2 = searchSceneListBinding.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
            DataAdapter dataAdapter = new DataAdapter();
            ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("ENTITIES");
            Intrinsics.checkNotNull(parcelableArrayList);
            dataAdapter.setEntities(parcelableArrayList);
            Unit unit = Unit.INSTANCE;
            recyclerView2.setAdapter(dataAdapter);
            Intrinsics.checkNotNullExpressionValue(searchSceneListBinding, "binding");
            View root = searchSceneListBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/SearchSceneViewHolder$DataViewHolder;", "()V", "entities", "", "Lcom/coolapk/market/model/Entity;", "getEntities", "()Ljava/util/List;", "setEntities", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchSceneViewHolder.kt */
    public static final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        public List<? extends Entity> entities;

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.Entity> */
        public final List<Entity> getEntities() {
            List list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            return list;
        }

        public final void setEntities(List<? extends Entity> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.entities = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131559130, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate, true);
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            dataViewHolder.bindTo(list.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            return list.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "stretch", "", "(Landroid/view/View;Z)V", "binding", "Lcom/coolapk/market/databinding/SearchSceneItemBinding;", "kotlin.jvm.PlatformType", "entity", "Lcom/coolapk/market/model/Entity;", "getStretch", "()Z", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchSceneViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131559130;
        private final SearchSceneItemBinding binding;
        private Entity entity;
        private final boolean stretch;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view, boolean z) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.stretch = z;
            SearchSceneItemBinding searchSceneItemBinding = (SearchSceneItemBinding) getBinding();
            this.binding = searchSceneItemBinding;
            Intrinsics.checkNotNullExpressionValue(searchSceneItemBinding, "binding");
            searchSceneItemBinding.getRoot().setOnClickListener(this);
        }

        public final boolean getStretch() {
            return this.stretch;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchSceneViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SearchSceneViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
            this.entity = (Entity) obj;
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            Entity entity2 = this.entity;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            textView.setText(entity2.getTitle());
            this.binding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("搜索分类");
            Entity entity2 = this.entity;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            sb.append(entity2.getTitle());
            instance.recordEvent("V9新搜索界面", sb.toString());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Entity entity3 = this.entity;
            if (entity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            String url = entity3.getUrl();
            Entity entity4 = this.entity;
            if (entity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            String title = entity4.getTitle();
            Entity entity5 = this.entity;
            if (entity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            ActionManagerCompat.startActivityByUrl(context, url, title, entity5.getSubTitle());
        }
    }
}
