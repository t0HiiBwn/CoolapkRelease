package com.coolapk.market.view.user.block;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import java.util.List;
import rx.Observable;

public class IgnoredUserListFragment extends BlockedUserListFragment {
    @Override // com.coolapk.market.view.user.block.BlockedUserListFragment
    public Observable<Result<String>> onCancelClick(User user) {
        return DataManager.getInstance().removeFromIgnoreList(user.getUid());
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<Result<List<User>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getMyIgnoreListUser(i, findFirstItem(), findLastItem()).compose(RxUtils.applyIOSchedulers());
    }
}
