package com.coolapk.market.view.feed;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.feed.FeedContract;
import java.util.List;
import rx.Observable;

public class EditorChoicePresenter extends FeedContract.Presenter {
    private FeedContract.View mView;

    public EditorChoicePresenter(FeedContract.View view) {
        super(view);
        this.mView = view;
    }

    @Override // com.coolapk.market.view.feed.FeedContract.Presenter
    public Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getEditorChoiceList(i, this.mView.findFirstItem(), this.mView.findLastItem());
    }
}
