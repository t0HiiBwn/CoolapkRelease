package com.coolapk.market.view.contact;

import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.contact.UserContract;
import java.util.List;
import rx.Observable;

public class UserPresenter extends UserContract.Presenter {
    private String keyWord;
    private UserContract.View view;

    public UserPresenter(UserContract.View view2) {
        super(view2);
        this.view = view2;
    }

    @Override // com.coolapk.market.view.contact.UserContract.Presenter
    public void setKeyWord(String str) {
        this.keyWord = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        if (TextUtils.isEmpty(this.keyWord)) {
            return null;
        }
        return DataManager.getInstance().searchUser(this.keyWord, i, this.view.findFirstItem(), this.view.findLastItem());
    }
}
