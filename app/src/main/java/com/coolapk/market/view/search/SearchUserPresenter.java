package com.coolapk.market.view.search;

import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.search.SearchUserContract;
import java.util.List;
import rx.Observable;

public class SearchUserPresenter extends SearchUserContract.Presenter {
    private String keyword;
    private SearchUserContract.View view;

    public SearchUserPresenter(SearchUserContract.View view2, String str) {
        super(view2);
        this.view = view2;
        this.keyword = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    @Override // com.coolapk.market.view.search.SearchUserContract.Presenter
    public String getKeyword() {
        return this.keyword;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        if (TextUtils.isEmpty(this.keyword)) {
            return null;
        }
        return DataManager.getInstance().searchUser(this.keyword, i, this.view.findFirstItem(), this.view.findLastItem());
    }
}
