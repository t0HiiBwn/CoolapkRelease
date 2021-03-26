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
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.view.node.rating.NodeRatingDeleteEvent;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserRatingListFragment.kt */
public final class UserRatingListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String UID = "UID";

    public static final UserRatingListFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    /* compiled from: UserRatingListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserRatingListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "uid");
            UserRatingListFragment userRatingListFragment = new UserRatingListFragment();
            Bundle createArguments$default = DataListFragment.Companion.createArguments$default(DataListFragment.Companion, "/feed/nodeRatingList?uid=" + str + "&targetType=all&parseRatingToFeed=1", null, null, 0, 14, null);
            createArguments$default.putString("UID", str);
            Unit unit = Unit.INSTANCE;
            userRatingListFragment.setArguments(createArguments$default);
            return userRatingListFragment;
        }

        public final String buildCardJson(String str) {
            Intrinsics.checkNotNullParameter(str, "uid");
            return "\n            {\"data\": {\"entityType\":\"card\",\"entityTemplate\":\"sortSelectCard\",\"title\":\"筛选\",\"url\":null,\"entities\":[\n            {\"entityType\":\"page\",\"entityId\":\"\",\"title\":\"全部\",\"url\":\"/feed/nodeRatingList?uid=" + str + "&targetType=all&parseRatingToFeed=1\",\"pic\":\",\"},\n            {\"entityType\":\"page\",\"entityId\":\"\",\"title\":\"只看应用\",\"url\":\"/feed/nodeRatingList?uid=" + str + "&targetType=apk&parseRatingToFeed=1\",\"pic\":\",\"},\n            {\"entityType\":\"page\",\"entityId\":\"\",\"title\":\"只看数码\",\"url\":\"/feed/nodeRatingList?uid=" + str + "&targetType=product&parseRatingToFeed=1\",\"pic\":\",\"}\n            ],\"entityId\":997,\"entityFixed\":1}}";
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
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131559064).constructor(new UserRatingListFragment$onActivityCreated$1(this)).suitedMethod(UserRatingListFragment$onActivityCreated$2.INSTANCE).build(), 0, 2, null);
    }

    public final void onNodeRatingDeleteEvent(NodeRatingDeleteEvent nodeRatingDeleteEvent) {
        Intrinsics.checkNotNullParameter(nodeRatingDeleteEvent, "event");
        changeDataListAndAutoCalculateDiff(new UserRatingListFragment$onNodeRatingDeleteEvent$1(this, nodeRatingDeleteEvent));
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        if (getDataList().isEmpty() && list != null && (!list.isEmpty())) {
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
