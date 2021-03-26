package com.coolapk.market.view.main;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import java.util.List;
import rx.Observable;

public class AppForumListFragment extends EntityListFragment {
    public static final String DEFAULT_TYPE = "default";
    public static final String EXTRA_PATH = "path";
    public static final String EXTRA_TYPE = "type";
    public static final String HOT_TYPE = "hot";
    public static final String RECOMMEND_TYPE = "recommend";
    private String path;
    private String type;

    @Override // com.coolapk.market.view.main.EntityListFragment
    protected String getMainEntityType() {
        return "appForum";
    }

    public static AppForumListFragment newInstance() {
        Bundle bundle = new Bundle();
        AppForumListFragment appForumListFragment = new AppForumListFragment();
        appForumListFragment.setArguments(bundle);
        return appForumListFragment;
    }

    @Override // com.coolapk.market.view.main.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getArguments().getString("type", "default");
        this.path = getArguments().getString("path", "");
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        String str2;
        AppForum appForum = (AppForum) EntityUtils.findFirstItem(getDataList(), getMainEntityType());
        AppForum appForum2 = (AppForum) EntityUtils.findLastItem(getDataList(), getMainEntityType());
        String str3 = null;
        if (TextUtils.isEmpty(this.path) || !this.path.startsWith("/appForum")) {
            DataManager instance = DataManager.getInstance();
            String str4 = this.type;
            if (appForum == null) {
                str = null;
            } else {
                str = appForum.id();
            }
            if (appForum2 != null) {
                str3 = appForum2.id();
            }
            return instance.getAppForumList(str4, i, str, str3).map(RxUtils.checkResultToData());
        }
        DataManager instance2 = DataManager.getInstance();
        String lastPathSegment = Uri.parse(this.path).getLastPathSegment();
        if (appForum == null) {
            str2 = null;
        } else {
            str2 = appForum.id();
        }
        if (appForum2 != null) {
            str3 = appForum2.id();
        }
        return instance2.getAppForumListWithPath(lastPathSegment, i, str2, str3).map(RxUtils.checkResultToData());
    }
}
