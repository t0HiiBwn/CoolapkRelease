package com.coolapk.market.view.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemMainCategoryLinkBinding;
import com.coolapk.market.databinding.ItemMainCatogoryTypeBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.Link;
import com.coolapk.market.model.LinkCard;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment;
import com.coolapk.market.view.main.MainCategoryContract;
import com.coolapk.market.viewholder.AppCategoryViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class MainCategoryFragment extends SimpleAsyncListFragment<Result<List<Entity>>, Entity> implements MainCategoryContract.View {
    private static final String CATEGORY_TYPE_APP = "category_app_title";
    private static final String CATEGORY_TYPE_GAME = "category_game_title";
    private String mCategoryType;
    private ResultModifier modifier;

    public static MainCategoryFragment newInstance() {
        Bundle bundle = new Bundle();
        MainCategoryFragment mainCategoryFragment = new MainCategoryFragment();
        mainCategoryFragment.setArguments(bundle);
        return mainCategoryFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(new PaddingDividerItemDecoration(new PaddingDividerItemDecoration.SimpleCallBack(getActivity()) {
            /* class com.coolapk.market.view.main.MainCategoryFragment.AnonymousClass1 */

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getItemCount() {
                return MainCategoryFragment.this.getDataList().size();
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getDividerHeight(int i) {
                return this.m1dp;
            }
        }));
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setLoadMoreEnable(false);
        setRefreshEnable(false);
        ResultModifier resultModifier = new ResultModifier();
        this.modifier = resultModifier;
        if (bundle != null) {
            resultModifier.reset(getDataList(), bundle);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getUserVisibleHint()) {
            initData();
        }
        if (bundle != null) {
            this.mCategoryType = bundle.getString("categoryType", "category_app_title");
        }
        if (this.mCategoryType == null) {
            this.mCategoryType = "category_app_title";
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.modifier.onSaveInstanceState(bundle);
        bundle.putString("categoryType", this.mCategoryType);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        if (result.getData() != null && !result.getData().isEmpty()) {
            List<Entity> data = result.getData();
            this.modifier.modify(data);
            getDataList().addAll(data);
            this.modifier.reset(getDataList(), null);
        }
        updateContentUI();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        switch (i) {
            case 2131558819:
                return new AppCategoryViewHolder(inflate, getComponent());
            case 2131558820:
                return new LinkCardsHolder(inflate, null);
            case 2131558821:
                return new CategoryTypeViewHolder(inflate, null);
            default:
                throw new RuntimeException("onCreateViewHolder");
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.SimpleAsyncListFragment
    public int getItemViewType(int i) {
        Entity entity = (Entity) getDataList().get(i);
        String entityType = entity.getEntityType();
        entityType.hashCode();
        char c = 65535;
        switch (entityType.hashCode()) {
            case -602316283:
                if (entityType.equals("holder_title")) {
                    c = 0;
                    break;
                }
                break;
            case 50511102:
                if (entityType.equals("category")) {
                    c = 1;
                    break;
                }
                break;
            case 1193677354:
                if (entityType.equals("linkCard")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2131558821;
            case 1:
                return 2131558819;
            case 2:
                return 2131558820;
            default:
                throw new RuntimeException("unknown view type " + entity);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    public class LinkCardsHolder extends GenericBindHolder<ItemMainCategoryLinkBinding, LinkCard> {
        public static final int LAYOUT_ID = 2131558820;

        public LinkCardsHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        public void bindToContent(LinkCard linkCard) {
            ItemMainCategoryLinkBinding itemMainCategoryLinkBinding = (ItemMainCategoryLinkBinding) getBinding();
            List<Link> entities = linkCard.getEntities();
            itemMainCategoryLinkBinding.itemView1.setLinkCard(entities.get(0));
            itemMainCategoryLinkBinding.itemView2.setLinkCard(entities.get(1));
            itemMainCategoryLinkBinding.itemView3.setLinkCard(entities.get(2));
            itemMainCategoryLinkBinding.itemView4.setLinkCard(entities.get(3));
            ViewUtil.clickListener(itemMainCategoryLinkBinding.itemView1.getRoot(), this);
            ViewUtil.clickListener(itemMainCategoryLinkBinding.itemView2.getRoot(), this);
            ViewUtil.clickListener(itemMainCategoryLinkBinding.itemView3.getRoot(), this);
            ViewUtil.clickListener(itemMainCategoryLinkBinding.itemView4.getRoot(), this);
            ((ItemMainCategoryLinkBinding) getBinding()).executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            int id = view.getId();
            if (id != 2131362769) {
                switch (id) {
                    case 2131362773:
                        Link linkCard = ((ItemMainCategoryLinkBinding) getBinding()).itemView2.getLinkCard();
                        ActionManager.startActivityByLink(MainCategoryFragment.this.getActivity(), linkCard.getTitle(), linkCard.getUrl(), null, linkCard.getSubTitle());
                        return;
                    case 2131362774:
                        Link linkCard2 = ((ItemMainCategoryLinkBinding) getBinding()).itemView3.getLinkCard();
                        ActionManager.startActivityByLink(MainCategoryFragment.this.getActivity(), linkCard2.getTitle(), linkCard2.getUrl(), null, linkCard2.getSubTitle());
                        return;
                    case 2131362775:
                        Link linkCard3 = ((ItemMainCategoryLinkBinding) getBinding()).itemView4.getLinkCard();
                        ActionManager.startActivityByLink(MainCategoryFragment.this.getActivity(), linkCard3.getTitle(), linkCard3.getUrl(), null, linkCard3.getSubTitle());
                        return;
                    default:
                        return;
                }
            } else {
                Link linkCard4 = ((ItemMainCategoryLinkBinding) getBinding()).itemView1.getLinkCard();
                ActionManager.startActivityByLink(MainCategoryFragment.this.getActivity(), linkCard4.getTitle(), linkCard4.getUrl(), null, linkCard4.getSubTitle());
            }
        }
    }

    public class CategoryTypeViewHolder extends GenericBindHolder<ItemMainCatogoryTypeBinding, HolderItem> {
        public static final int LAYOUT_ID = 2131558821;

        public CategoryTypeViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        public void bindToContent(HolderItem holderItem) {
            ViewUtil.clickListener(((ItemMainCatogoryTypeBinding) getBinding()).click1, this);
            ViewUtil.clickListener(((ItemMainCatogoryTypeBinding) getBinding()).click2, this);
            updateState();
        }

        private void updateState() {
            String str = MainCategoryFragment.this.mCategoryType;
            str.hashCode();
            if (str.equals("category_game_title")) {
                ((ItemMainCatogoryTypeBinding) getBinding()).textView2.setChecked(true);
                ((ItemMainCatogoryTypeBinding) getBinding()).textView1.setChecked(false);
            } else if (str.equals("category_app_title")) {
                ((ItemMainCatogoryTypeBinding) getBinding()).textView1.setChecked(true);
                ((ItemMainCatogoryTypeBinding) getBinding()).textView2.setChecked(false);
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            if (view == ((ItemMainCatogoryTypeBinding) getBinding()).click1 && !TextUtils.equals(MainCategoryFragment.this.mCategoryType, "category_app_title")) {
                MainCategoryFragment.this.mCategoryType = "category_app_title";
                MainCategoryFragment.this.modifier.switchList(MainCategoryFragment.this.mCategoryType);
                updateState();
            }
            if (view == ((ItemMainCatogoryTypeBinding) getBinding()).click2 && !TextUtils.equals(MainCategoryFragment.this.mCategoryType, "category_game_title")) {
                MainCategoryFragment.this.mCategoryType = "category_game_title";
                MainCategoryFragment.this.modifier.switchList(MainCategoryFragment.this.mCategoryType);
                updateState();
            }
        }
    }

    private class ResultModifier {
        ArrayList<AppCategory> apkList;
        List<Entity> data;
        ArrayList<AppCategory> gameList;

        private ResultModifier() {
            this.apkList = new ArrayList<>();
            this.gameList = new ArrayList<>();
        }

        public void reset(List<Entity> list, Bundle bundle) {
            this.data = list;
            if (bundle != null) {
                this.apkList = bundle.getParcelableArrayList("apkList");
                this.gameList = bundle.getParcelableArrayList("gameList");
            }
        }

        public void modify(List<Entity> list) {
            this.data = list;
            this.apkList.clear();
            this.gameList.clear();
            sortCategory();
            this.data.clear();
            addHolders();
        }

        public void onSaveInstanceState(Bundle bundle) {
            bundle.putParcelableArrayList("apkList", this.apkList);
            bundle.putParcelableArrayList("gameList", this.gameList);
        }

        private void sortCategory() {
            for (Entity entity : this.data) {
                if (EntityUtils.isCategoryType(entity.getEntityType())) {
                    AppCategory appCategory = (AppCategory) entity;
                    if (appCategory.isAppType()) {
                        this.apkList.add(appCategory);
                    } else if (appCategory.isGameType()) {
                        this.gameList.add(appCategory);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void switchList(String str) {
            ArrayList<AppCategory> arrayList;
            str.hashCode();
            if (str.equals("category_game_title")) {
                arrayList = this.gameList;
            } else if (str.equals("category_app_title")) {
                arrayList = this.apkList;
            } else {
                return;
            }
            int indexOf = this.data.indexOf((Entity) EntityUtils.findFirstItem(this.data, "holder_title"));
            for (int size = this.data.size() - 1; size > indexOf; size--) {
                this.data.remove(size);
            }
            this.data.addAll(arrayList);
        }

        private void addHolders() {
            this.data.add(HolderItem.newBuilder().entityType("holder_title").build());
            this.data.addAll(this.apkList);
        }
    }
}
