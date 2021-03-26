package com.coolapk.market.view.collectionList;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.event.CollectionDelEvent;
import com.coolapk.market.event.CollectionUpdataEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "listNum", "", "uid", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCollectioinDel", "event", "Lcom/coolapk/market/event/CollectionDelEvent;", "onCollectioinUpdata", "Lcom/coolapk/market/event/CollectionUpdataEvent;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionListFragment.kt */
public final class CollectionListFragment extends EntityListFragment {
    private int listNum;
    private String uid;

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.setTitle("我的收藏单");
        setHasOptionsMenu(true);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String str = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> compose = instance.getUserCollectionList("", i, entityId, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            MenuItem add = menu.add(0, 2131362982, 0, "添加更多");
            add.setIcon(2131231500);
            add.setShowAsAction(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131362982) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActionManager.startCollectionListCreateActivity(getActivity());
        return true;
    }

    @Subscribe
    public final void onCollectioinDel(CollectionDelEvent collectionDelEvent) {
        Intrinsics.checkNotNullParameter(collectionDelEvent, "event");
        this.listNum = getDataList().size();
        int i = 0;
        for (T t : getDataList()) {
            if (!(t instanceof Collection) || !Intrinsics.areEqual(t.getId(), collectionDelEvent.getColId())) {
                i++;
            } else {
                getDataList().remove(i);
                this.listNum--;
                if (getDataList().size() < 1) {
                    addHintView("这里还没有收藏单", CollectionListFragment$onCollectioinDel$1.INSTANCE);
                    return;
                }
                return;
            }
        }
    }

    @Subscribe
    public final void onCollectioinUpdata(CollectionUpdataEvent collectionUpdataEvent) {
        Intrinsics.checkNotNullParameter(collectionUpdataEvent, "event");
        int action = collectionUpdataEvent.getAction();
        int i = 0;
        if (action != 0) {
            if (action == 1) {
                for (T t : getDataList()) {
                    if (t instanceof Collection) {
                        String id = t.getId();
                        Collection collection = collectionUpdataEvent.getCollection();
                        Intrinsics.checkNotNullExpressionValue(collection, "event.collection");
                        if (Intrinsics.areEqual(id, collection.getId())) {
                            List<Parcelable> dataList = getDataList();
                            Collection collection2 = collectionUpdataEvent.getCollection();
                            Intrinsics.checkNotNullExpressionValue(collection2, "event.collection");
                            dataList.set(i, collection2);
                            return;
                        }
                    }
                    i++;
                }
            }
        } else if (collectionUpdataEvent.getCollection() != null) {
            List<Parcelable> dataList2 = getDataList();
            Collection collection3 = collectionUpdataEvent.getCollection();
            Intrinsics.checkNotNullExpressionValue(collection3, "event.collection");
            dataList2.add(0, collection3);
            getAdapter$presentation_coolapkAppRelease().notifyDataSetChanged();
        }
    }
}
