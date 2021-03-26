package com.coolapk.market.view.userv9;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityConvertUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: UserBlockListFragment.kt */
public final class UserBlockListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String UID = "UID";
    private final Lazy uid$delegate = LazyKt.lazy(new UserBlockListFragment$uid$2(this));

    private final String getUid() {
        return (String) this.uid$delegate.getValue();
    }

    public static final UserBlockListFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    /* compiled from: UserBlockListFragment.kt */
    public static final class Companion {
        public final String buildCardJson(String str) {
            Intrinsics.checkNotNullParameter(str, "uid");
            return "\n            {\"data\": {\"entityType\":\"card\",\"entityTemplate\":\"sortSelectCard\",\"title\":\"筛选\",\"url\":null,\"entities\":[ \n            {\"entityType\":\"page\",\"entityId\":\"\",\"title\":\"动态\",\"url\":\"feed\",\"pic\":\",\"},\n            {\"entityType\":\"page\",\"entityId\":\"\",\"title\":\"回复\",\"url\":\"reply\",\"pic\":\",\"}\n            ],\"entityId\":997,\"entityFixed\":1}}";
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserBlockListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "uid");
            UserBlockListFragment userBlockListFragment = new UserBlockListFragment();
            Bundle createArguments$default = DataListFragment.Companion.createArguments$default(DataListFragment.Companion, "feed", null, null, 0, 14, null);
            createArguments$default.putString("UID", str);
            Unit unit = Unit.INSTANCE;
            userBlockListFragment.setArguments(createArguments$default);
            return userBlockListFragment;
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), NumberExtendsKt.getDp((Number) 8), recyclerView2.getPaddingRight(), recyclerView2.getPaddingBottom());
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        recyclerView3.setClipToPadding(false);
        if (getActivity() instanceof UserSpaceV9Activity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.userv9.UserSpaceV9Activity");
            if (((UserSpaceV9Activity) activity).isInBlackList()) {
                setEmptyData("由于你的黑名单设置，该用户动态对你不可见", 0);
            }
        }
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558898).constructor(new UserBlockListFragment$onActivityCreated$1(this)).suitedMethod(UserBlockListFragment$onActivityCreated$2.INSTANCE).build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public void reloadData() {
        Entity requestArg = getEntityRequestArgHelper().getRequestArg();
        if (requestArg != null) {
            String url = requestArg.getUrl();
            if (url == null) {
                url = "";
            }
            setUrl(url);
            setExtraRequestProvider(null);
        }
        super.reloadData();
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String url = getUrl();
        int hashCode = url.hashCode();
        String str = null;
        if (hashCode != 3138974) {
            if (hashCode == 108401386 && url.equals("reply")) {
                DataManager instance = DataManager.getInstance();
                String uid = getUid();
                Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, true, 7, null);
                String id = findFirstEntity$default != null ? findFirstEntity$default.getId() : null;
                Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, true, 1, null);
                if (findLastEntity$default != null) {
                    str = findLastEntity$default.getId();
                }
                Observable<R> compose = instance.getBlockedUserReplyList(uid, i, id, str).compose(RxUtils.apiCommonToData());
                Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
                return compose;
            }
        } else if (url.equals("feed")) {
            DataManager instance2 = DataManager.getInstance();
            String uid2 = getUid();
            Entity findFirstEntity$default2 = EntityListFragment.findFirstEntity$default(this, null, null, false, true, 7, null);
            String id2 = findFirstEntity$default2 != null ? findFirstEntity$default2.getId() : null;
            Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, true, 1, null);
            if (findLastEntity$default2 != null) {
                str = findLastEntity$default2.getId();
            }
            Observable<R> compose2 = instance2.getUserBlockedFeedList(uid2, i, id2, str, 0).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose2, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose2;
        }
        return super.onCreateRequest(z, i);
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        if (getDataList().isEmpty()) {
            String string = requireArguments().getString("UID");
            if (string == null) {
                string = "";
            }
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            Result<Entity> convertEntity = EntityConvertUtils.convertEntity(instance.getGson(), Companion.buildCardJson(string));
            List<Parcelable> dataList = getDataList();
            Intrinsics.checkNotNullExpressionValue(convertEntity, "selectorCard");
            Entity data = convertEntity.getData();
            Intrinsics.checkNotNullExpressionValue(data, "selectorCard.data");
            dataList.add(0, data);
        }
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (!onRequestResponse && getDataList().size() == 1) {
            addNoMoreDataView();
        } else if (onRequestResponse && list != null && list.size() < 20) {
            addNoMoreDataView();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof Entity) || !Intrinsics.areEqual(((Entity) obj).getEntityTemplate(), "sortSelectCard")) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        return -1;
    }
}
