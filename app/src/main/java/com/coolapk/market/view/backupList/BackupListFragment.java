package com.coolapk.market.view.backupList;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.BackupDelEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: BackupListFragment.kt */
public final class BackupListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_BACKUP_HEADER = "backupHeader";
    private boolean isLoadHeader;
    private int listNum;

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setPadding(0, 0, 0, NumberExtendsKt.getDp((Number) 16));
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        getDataList().add(0, createHeaderData$default(this, null, 1, null));
        setLoadMoreEnable(false);
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            ((AlphableToolbar) activity).setToolbarAlpha(0.0f);
            FragmentActivity fragmentActivity = activity;
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 40.0f), new BackupListFragment$onActivityCreated$1(this, activity)));
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 80.0f), new BackupListFragment$onActivityCreated$2(activity)));
        }
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(activity).type(2131558619, 2131231051).create());
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
        Observable<R> compose = instance.getBackupList(i, entityId, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558621).suitedMethod(BackupListFragment$onRegisterCards$1.INSTANCE).constructor(new BackupListFragment$onRegisterCards$2(this)).build(), 0);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558619).suitedMethod(BackupListFragment$onRegisterCards$3.INSTANCE).constructor(new BackupListFragment$onRegisterCards$4(this)).build(), 0);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        HolderItem holderItem = null;
        if (!CollectionUtils.isEmpty(list)) {
            removeHintOrRefreshView();
            Intrinsics.checkNotNull(list);
            if (list.get(0) instanceof BackupInfo) {
                Object obj = list.get(0);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.BackupInfo");
                BackupInfo backupInfo = (BackupInfo) obj;
                this.listNum = backupInfo.getBackNum();
                holderItem = createHeaderData(backupInfo);
            }
        } else {
            holderItem = createHeaderData$default(this, null, 1, null);
            addHintView("你还没有创建过备份单", BackupListFragment$onRequestResponse$1.INSTANCE);
        }
        if (!this.isLoadHeader) {
            List<Parcelable> dataList = getDataList();
            Intrinsics.checkNotNull(holderItem);
            dataList.set(0, holderItem);
            this.isLoadHeader = true;
        }
        return onRequestResponse;
    }

    static /* synthetic */ HolderItem createHeaderData$default(BackupListFragment backupListFragment, BackupInfo backupInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            backupInfo = null;
        }
        return backupListFragment.createHeaderData(backupInfo);
    }

    private final HolderItem createHeaderData(BackupInfo backupInfo) {
        if (backupInfo != null) {
            HolderItem build = HolderItem.newBuilder().entityType("backupHeader").value("创建备份单").dateline(backupInfo.getCreateTime()).intValue(Integer.valueOf(this.listNum)).entityTemplate("backupHeader").build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…EY_BACKUP_HEADER).build()");
            return build;
        }
        HolderItem build2 = HolderItem.newBuilder().value("创建备份单").entityType("backupHeader").dateline(0L).intValue(0).entityTemplate("backupHeader").build();
        Intrinsics.checkNotNullExpressionValue(build2, "HolderItem.newBuilder().…EY_BACKUP_HEADER).build()");
        return build2;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected List<Entity> modifyDataBeforeHandle(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "data");
        return super.modifyDataBeforeHandle(list, z);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof HolderItem) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    private final BackupInfo findBackup(List<Parcelable> list) {
        for (T t : list) {
            if (t instanceof BackupInfo) {
                return t;
            }
        }
        return null;
    }

    public static /* synthetic */ void putBackupInfo$default(BackupListFragment backupListFragment, BackupInfo backupInfo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        backupListFragment.putBackupInfo(backupInfo, z);
    }

    public final void putBackupInfo(BackupInfo backupInfo, boolean z) {
        Intrinsics.checkNotNullParameter(backupInfo, "back");
        Toast.show$default(getActivity(), "备份成功", 0, false, 12, null);
        this.listNum++;
        removeHintOrRefreshView();
        if (z) {
            int i = 0;
            for (T t : getDataList()) {
                if (!(t instanceof BackupInfo) || !TextUtils.equals(t.getVersionMD5(), backupInfo.getVersionMD5())) {
                    i++;
                } else {
                    getDataList().remove(i);
                    getDataList().add(1, backupInfo);
                    getDataList().set(0, createHeaderData(backupInfo));
                    return;
                }
            }
        }
        getDataList().add(1, backupInfo);
        getDataList().set(0, createHeaderData(backupInfo));
    }

    public final void onBackupDel(BackupDelEvent backupDelEvent) {
        Intrinsics.checkNotNullParameter(backupDelEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (!(t instanceof BackupInfo) || !Intrinsics.areEqual(t.getId(), backupDelEvent.getBackupId())) {
                i++;
            } else {
                getDataList().remove(i);
                this.listNum--;
                if (getDataList().size() < 2) {
                    addHintView("你还没有创建过备份单", BackupListFragment$onBackupDel$1.INSTANCE);
                }
                BackupInfo findBackup = findBackup(getDataList());
                if (findBackup != null) {
                    getDataList().set(0, createHeaderData(findBackup));
                    return;
                } else {
                    getDataList().set(0, createHeaderData$default(this, null, 1, null));
                    return;
                }
            }
        }
    }

    /* compiled from: BackupListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupListFragment newInstance() {
            Bundle bundle = new Bundle();
            BackupListFragment backupListFragment = new BackupListFragment();
            backupListFragment.setArguments(bundle);
            return backupListFragment;
        }
    }
}
