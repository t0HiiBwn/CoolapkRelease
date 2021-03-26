package com.coolapk.market.view.search;

import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.main.AppForumListFragment;
import java.util.List;
import rx.Observable;

public class SearchAppForumFragment extends AppForumListFragment {
    public static SearchAppForumFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        SearchAppForumFragment searchAppForumFragment = new SearchAppForumFragment();
        searchAppForumFragment.setArguments(bundle);
        return searchAppForumFragment;
    }

    @Override // com.coolapk.market.view.main.AppForumListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        String str2;
        AppForum appForum = (AppForum) EntityUtils.findFirstItem(getDataList(), getMainEntityType());
        AppForum appForum2 = (AppForum) EntityUtils.findLastItem(getDataList(), getMainEntityType());
        String string = getArguments().getString("keyword");
        if (TextUtils.isEmpty(string)) {
            return Observable.empty();
        }
        DataManager instance = DataManager.getInstance();
        String apkType = getApkType();
        if (appForum == null) {
            str = null;
        } else {
            str = appForum.id();
        }
        if (appForum2 == null) {
            str2 = null;
        } else {
            str2 = appForum2.id();
        }
        return instance.searchAppForumList(string, apkType, i, str, str2).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers());
    }
}
