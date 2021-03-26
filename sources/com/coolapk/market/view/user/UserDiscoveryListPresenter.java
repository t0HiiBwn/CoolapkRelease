package com.coolapk.market.view.user;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.feed.FeedContract;
import java.util.List;
import rx.Observable;

public class UserDiscoveryListPresenter extends FeedContract.Presenter {
    private String uid;
    private FeedContract.View view;

    public UserDiscoveryListPresenter(FeedContract.View view2, String str) {
        super(view2);
        this.uid = str;
        this.view = view2;
    }

    @Override // com.coolapk.market.view.feed.FeedContract.Presenter
    public Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getUserDiscoveryList(this.uid, i, this.view.findFirstItem(), this.view.findLastItem());
    }
}
