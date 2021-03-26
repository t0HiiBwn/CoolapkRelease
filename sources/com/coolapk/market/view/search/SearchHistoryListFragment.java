package com.coolapk.market.view.search;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSearchExtendBinding;
import com.coolapk.market.databinding.ItemSearchExtendFooterBinding;
import com.coolapk.market.databinding.ItemSearchExtendHeaderBinding;
import com.coolapk.market.local.Db;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.TagsView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.Arrays;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class SearchHistoryListFragment extends NewAsyncListFragment<Cursor> {
    private static final int ITEM_TYPE_FOOTER = 2;
    private static final int ITEM_TYPE_HEADER = 1;
    private static final String KEY_KEYWORD = "KEYWORD";
    private HeaderAdapter adapter;
    private Cursor cursor;
    private Subscription hotSearchKeywordsSub;
    private String keyword;

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return false;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return true;
    }

    public static SearchHistoryListFragment newInstance() {
        return newInstance("");
    }

    public static SearchHistoryListFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("KEYWORD", str);
        SearchHistoryListFragment searchHistoryListFragment = new SearchHistoryListFragment();
        searchHistoryListFragment.setArguments(bundle);
        return searchHistoryListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.keyword = getArguments().getString("KEYWORD");
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData("", 0);
        setAdapter(new DataAdapter());
        this.adapter = new HeaderAdapter(getRecyclerView().getAdapter());
        getRecyclerView().setAdapter(this.adapter);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(0, 2131231062).create());
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        if (getUserVisibleHint()) {
            initData();
        }
        updateSections();
        initHotSearchKeywords();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RxUtils.unsubscribe(this.hotSearchKeywordsSub);
        Cursor cursor2 = this.cursor;
        if (cursor2 != null) {
            cursor2.close();
        }
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Cursor cursor2) {
        Cursor cursor3 = this.cursor;
        if (cursor3 != null) {
            cursor3.close();
        }
        this.cursor = cursor2;
        updateContentUI();
        updateSections();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<Cursor> onCreateRequest(boolean z, int i) {
        return Observable.create(new Observable.OnSubscribe<Cursor>() {
            /* class com.coolapk.market.view.search.SearchHistoryListFragment.AnonymousClass1 */

            public void call(Subscriber<? super Cursor> subscriber) {
                try {
                    SearchHistoryListFragment searchHistoryListFragment = SearchHistoryListFragment.this;
                    subscriber.onNext(searchHistoryListFragment.loadData(searchHistoryListFragment.keyword));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    private void initHotSearchKeywords() {
        this.hotSearchKeywordsSub = DataManager.getInstance().getHotSearchKeywords().compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new Subscriber<String>() {
            /* class com.coolapk.market.view.search.SearchHistoryListFragment.AnonymousClass2 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(SearchHistoryListFragment.this.getActivity(), th);
            }

            public void onNext(String str) {
                DataManager.getInstance().getPreferencesEditor().putString("HOT_SEARCH_KEYWORDS", str).apply();
                if (!SearchHistoryListFragment.this.adapter.hasSections()) {
                    SearchHistoryListFragment.this.updateSections();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateSections() {
        ArrayList arrayList = new ArrayList();
        String preferencesString = DataManager.getInstance().getPreferencesString("HOT_SEARCH_KEYWORDS", null);
        if (!TextUtils.isEmpty(preferencesString)) {
            arrayList.add(new SectionedAdapter.Section(0, 1, preferencesString));
        }
        Cursor cursor2 = this.cursor;
        if (cursor2 != null && cursor2.getCount() > 0) {
            arrayList.add(new SectionedAdapter.Section(this.cursor.getCount(), 2, preferencesString));
        }
        this.adapter.setSections(arrayList);
    }

    /* access modifiers changed from: private */
    public Cursor loadData(String str) {
        Db dataBase = DataManager.getInstance().getDataBase();
        Cursor query = dataBase.query("SELECT * FROM searchHistory WHERE keyword LIKE ? ORDER BY modified DESC", "%" + str + "%");
        query.getCount();
        return query;
    }

    private class HeaderAdapter extends SectionedAdapter {
        public HeaderAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558917, viewGroup, false), null);
            }
            if (i == 2) {
                return new FooterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558916, viewGroup, false), new ItemActionHandler() {
                    /* class com.coolapk.market.view.search.SearchHistoryListFragment.HeaderAdapter.AnonymousClass1 */

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                        if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                            DataManager.getInstance().getDataBase().delete("searchHistory", null, new String[0]);
                            SearchHistoryListFragment.this.setPage(1);
                            SearchHistoryListFragment.this.reloadData();
                        }
                    }
                });
            }
            throw new RuntimeException("Unknown view type " + i);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((BindingViewHolder) viewHolder).bindTo(SearchHistoryListFragment.this.adapter.getSection(i).getObject());
        }
    }

    private static class HeaderViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558917;

        public HeaderViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            ((ItemSearchExtendHeaderBinding) getBinding()).keywordsView.setOnTagClickListener(new TagsView.OnTagClickListener() {
                /* class com.coolapk.market.view.search.SearchHistoryListFragment.HeaderViewHolder.AnonymousClass1 */

                @Override // com.coolapk.market.widget.TagsView.OnTagClickListener
                public void onTagClick(View view, int i, String str) {
                    if (view.getTag() != null) {
                        ActionManager.startActivityByUrl(HeaderViewHolder.this.getContext(), (String) view.getTag());
                    } else {
                        ((SuperSearchActivity) HeaderViewHolder.this.getContext()).inputKeyword(str);
                    }
                    StatisticHelper instance = StatisticHelper.getInstance();
                    instance.recordEvent("V9搜索界面", "热门搜索(" + str + ")");
                }
            });
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemSearchExtendHeaderBinding itemSearchExtendHeaderBinding = (ItemSearchExtendHeaderBinding) getBinding();
            String str = (String) obj;
            if (!TextUtils.equals(str, (CharSequence) itemSearchExtendHeaderBinding.keywordsView.getTag())) {
                if (!TextUtils.isEmpty(str)) {
                    itemSearchExtendHeaderBinding.keywordsView.setKeywords(Arrays.asList(str.split("\\|")));
                } else {
                    itemSearchExtendHeaderBinding.keywordsView.setKeywords(null);
                }
                itemSearchExtendHeaderBinding.keywordsView.setTag(str);
            }
            itemSearchExtendHeaderBinding.executePendingBindings();
        }
    }

    private static class FooterViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558916;

        public FooterViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            view.setOnClickListener(this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ((ItemSearchExtendFooterBinding) getBinding()).executePendingBindings();
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558915, viewGroup, false), new ItemActionHandler() {
                /* class com.coolapk.market.view.search.SearchHistoryListFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        SearchHistoryListFragment.this.cursor.moveToPosition(SearchHistoryListFragment.this.adapter.sectionedPositionToPosition(viewHolder.getAdapterPosition()));
                        String string = SearchHistoryListFragment.this.cursor.getString(1);
                        if (view.getId() != 2131362380) {
                            ((SuperSearchActivity) SearchHistoryListFragment.this.getActivity()).inputKeyword(string);
                            return;
                        }
                        DataManager.getInstance().getDataBase().delete("searchHistory", "keyword=?", string);
                        SearchHistoryListFragment.this.setPage(1);
                        SearchHistoryListFragment.this.reloadData();
                    }
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            SearchHistoryListFragment.this.cursor.moveToPosition(i);
            bindingViewHolder.bindTo(SearchHistoryListFragment.this.cursor);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (SearchHistoryListFragment.this.cursor != null) {
                return SearchHistoryListFragment.this.cursor.getCount();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return super.getItemViewType(i);
        }
    }

    private static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558915;

        public DataViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            view.setOnClickListener(this);
            ((ItemSearchExtendBinding) getBinding()).deleteView.setOnClickListener(this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemSearchExtendBinding itemSearchExtendBinding = (ItemSearchExtendBinding) getBinding();
            itemSearchExtendBinding.setText(((Cursor) obj).getString(1));
            itemSearchExtendBinding.executePendingBindings();
        }
    }
}
