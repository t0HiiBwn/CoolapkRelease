package com.coolapk.market.view.main;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public class RecommendAlbumListFragment extends EntityListFragment {
    public static final String KEY_ALBUM_TYPE = "album_type";
    private String albumType;

    @Override // com.coolapk.market.view.main.EntityListFragment
    public String getMainEntityType() {
        return "album";
    }

    public static RecommendAlbumListFragment newInstance(String str) {
        RecommendAlbumListFragment recommendAlbumListFragment = new RecommendAlbumListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("album_type", str);
        recommendAlbumListFragment.setArguments(bundle);
        return recommendAlbumListFragment;
    }

    @Override // com.coolapk.market.view.main.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.albumType = getArguments().getString("album_type");
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Album findFirstAlbumType = EntityUtils.findFirstAlbumType(getDataList());
        Album findLastAlbumType = EntityUtils.findLastAlbumType(getDataList());
        DataManager instance = DataManager.getInstance();
        String str = null;
        String albumId = findFirstAlbumType != null ? findFirstAlbumType.getAlbumId() : null;
        if (findLastAlbumType != null) {
            str = findLastAlbumType.getAlbumId();
        }
        return instance.getAlbumList(i, albumId, str, this.albumType).map(RxUtils.checkResultToData()).flatMap(new Func1<List<Entity>, Observable<Entity>>() {
            /* class com.coolapk.market.view.main.RecommendAlbumListFragment.AnonymousClass2 */

            public Observable<Entity> call(List<Entity> list) {
                return Observable.from(list);
            }
        }).filter(new Func1<Entity, Boolean>() {
            /* class com.coolapk.market.view.main.RecommendAlbumListFragment.AnonymousClass1 */

            public Boolean call(Entity entity) {
                return Boolean.valueOf(EntityUtils.isAlbumType(entity.getEntityType()));
            }
        }).toList();
    }

    @Override // com.coolapk.market.view.main.EntityListFragment
    public String getApkType() {
        return this.albumType;
    }
}
