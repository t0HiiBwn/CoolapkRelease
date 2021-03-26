package com.coolapk.market.view.contact;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.contact.ContactContract;
import java.util.List;
import rx.Observable;

public class FriendContactPresenter extends ContactContract.FriendPresenter {
    private String uid;
    private ContactContract.View view;

    public FriendContactPresenter(ContactContract.View view2, String str) {
        super(view2);
        this.uid = str;
        this.view = view2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getUserFollowerList(this.uid, i, this.view.findFirstItem(), this.view.findLastItem()).compose(RxUtils.applyIOSchedulers());
    }

    @Override // com.coolapk.market.view.contact.ContactContract.FriendPresenter
    public String getUid() {
        return this.uid;
    }
}
