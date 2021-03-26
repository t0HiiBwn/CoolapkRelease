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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J,\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u0010H\u0014J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u0004H\u0014J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0007J$\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170#2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u001cH\u0014J \u0010&\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014J\u0018\u0010'\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "isLoadHeader", "", "listNum", "", "createHeaderData", "Lcom/coolapk/market/model/HolderItem;", "back", "Lcom/coolapk/market/model/BackupInfo;", "filterDataWhenRefresh", "originData", "", "index", "newDataByCardId", "", "", "findBackup", "list", "", "Landroid/os/Parcelable;", "modifyDataBeforeHandle", "", "Lcom/coolapk/market/model/Entity;", "data", "isRefresh", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackupDel", "event", "Lcom/coolapk/market/event/BackupDelEvent;", "onCreateRequest", "Lrx/Observable;", "page", "onRegisterCards", "onRequestResponse", "putBackupInfo", "isCover", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(activity).type(2131558623, 2131231061).create());
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
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558625).suitedMethod(BackupListFragment$onRegisterCards$1.INSTANCE).constructor(new BackupListFragment$onRegisterCards$2(this)).build(), 0);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558623).suitedMethod(BackupListFragment$onRegisterCards$3.INSTANCE).constructor(new BackupListFragment$onRegisterCards$4(this)).build(), 0);
    }

    /* access modifiers changed from: protected */
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

    @Subscribe
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupListFragment$Companion;", "", "()V", "KEY_BACKUP_HEADER", "", "newInstance", "Lcom/coolapk/market/view/backupList/BackupListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
