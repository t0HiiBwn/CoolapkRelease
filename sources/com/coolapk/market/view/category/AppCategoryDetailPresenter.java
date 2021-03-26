package com.coolapk.market.view.category;

import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.category.RankingAppContract;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

public class AppCategoryDetailPresenter extends RankingAppContract.Presenter {
    private String apkType;
    private String categoryId;
    private boolean hasRankHolder;
    private String rankType;
    private String tagKeyword;
    private RankingAppContract.View view;

    public AppCategoryDetailPresenter(RankingAppContract.View view2, String str, String str2, String str3) {
        super(view2);
        this.categoryId = str;
        this.apkType = str3;
        this.view = view2;
        this.tagKeyword = str2;
    }

    @Override // com.coolapk.market.view.category.RankingAppContract.Presenter
    public String getRankType() {
        if (this.rankType == null) {
            this.rankType = "default";
        }
        return this.rankType;
    }

    @Override // com.coolapk.market.view.category.RankingAppContract.Presenter
    public void resetRankType(String str) {
        if (!TextUtils.equals(str, this.rankType)) {
            this.rankType = str;
            this.view.clearCardData();
            this.hasRankHolder = false;
            setPage(1);
            reloadData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        Observable<Result<List<Entity>>> observable;
        String findFirstItem = this.view.findFirstItem();
        String findLastItem = this.view.findLastItem();
        if (this.categoryId != null) {
            observable = DataManager.getInstance().getAppListWithCategory(this.categoryId, this.apkType, getRankType(), i, findFirstItem, findLastItem);
        } else {
            observable = DataManager.getInstance().getAppListWithTag(this.tagKeyword, this.apkType, getRankType(), i, findFirstItem, findLastItem);
        }
        return observable.doOnNext(new Action1<Result<List<Entity>>>() {
            /* class com.coolapk.market.view.category.AppCategoryDetailPresenter.AnonymousClass1 */

            public void call(Result<List<Entity>> result) {
                List<Entity> data = result.getData();
                if (data != null && !data.isEmpty() && !AppCategoryDetailPresenter.this.hasRankHolder) {
                    data.add(0, HolderItem.newBuilder().entityType("holder_order_selector").build());
                    AppCategoryDetailPresenter.this.hasRankHolder = true;
                }
            }
        });
    }
}
