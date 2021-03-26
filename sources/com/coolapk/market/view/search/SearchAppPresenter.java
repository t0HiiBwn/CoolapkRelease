package com.coolapk.market.view.search;

import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.search.SearchAppContract;
import java.util.List;
import rx.Observable;

public class SearchAppPresenter extends SearchAppContract.Presenter {
    public static final String APK_TYPE_ALL = "0";
    public static final String APK_TYPE_APP = "1";
    public static final String APK_TYPE_GAME = "2";
    private final String apkType;
    private String keyword;
    private final SearchAppContract.View view;

    public SearchAppPresenter(SearchAppContract.View view2, String str, String str2) {
        super(view2);
        this.view = view2;
        this.keyword = str;
        this.apkType = str2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        if (TextUtils.isEmpty(this.keyword)) {
            return Observable.just(new Result(0, null, null, null));
        }
        return DataManager.getInstance().getAppListWithKeyword(this.keyword, this.apkType, i, this.view.findFirstItem(), this.view.findLastItem());
    }

    @Override // com.coolapk.market.view.search.SearchAppContract.Presenter
    public String getKeyword() {
        return this.keyword;
    }

    @Override // com.coolapk.market.view.search.SearchAppContract.Presenter
    public void setKeyword(String str) {
        this.keyword = str;
    }
}
