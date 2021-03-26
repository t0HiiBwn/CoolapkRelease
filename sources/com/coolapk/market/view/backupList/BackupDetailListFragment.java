package com.coolapk.market.view.backupList;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.view.cardlist.divider.ViewMarginRule;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0003()*B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0011H\u0014J \u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupDetailListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "backupId", "", "backupInfo", "Lcom/coolapk/market/model/BackupInfo;", "isLoadHeader", "", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackupLoaded", "backup", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRegisterCards", "onRequestResponse", "data", "BackUpListDividerRule", "BackUpListViewMarginRule", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupDetailListFragment.kt */
public final class BackupDetailListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_BACKUP_ID = "EXTRA_BACKUP_ID";
    private String backupId;
    private BackupInfo backupInfo;
    private boolean isLoadHeader;

    public static final /* synthetic */ String access$getBackupId$p(BackupDetailListFragment backupDetailListFragment) {
        String str = backupDetailListFragment.backupId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backupId");
        }
        return str;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("EXTRA_BACKUP_ID");
        Intrinsics.checkNotNull(string);
        this.backupId = string;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLoadMoreEnable(false);
        setRefreshEnable(false);
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new BackUpListViewMarginRule());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new BackUpListDividerRule());
        getRecyclerView().setPadding(0, 0, 0, NumberExtendsKt.getDp((Number) 16));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupDetailListFragment$BackUpListViewMarginRule;", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "()V", "getViewMarginData", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "position", "", "current", "", "default", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupDetailListFragment.kt */
    public static final class BackUpListViewMarginRule implements ViewMarginRule {
        @Override // com.coolapk.market.view.cardlist.divider.ViewMarginRule
        public ViewMarginData getViewMarginData(int i, Object obj, ViewMarginData viewMarginData) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(viewMarginData, "default");
            if ((obj instanceof HolderItem) || (obj instanceof BackupInfo)) {
                return ViewMarginData.Companion.getEMPTY();
            }
            return ViewMarginData.Companion.getDEFAULT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupDetailListFragment$BackUpListDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "()V", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupDetailListFragment.kt */
    public static final class BackUpListDividerRule implements DividerRule {
        @Override // com.coolapk.market.view.cardlist.divider.DividerRule
        public DividerData getDividerData(int i, Object obj, Object obj2) {
            if (i == -1) {
                return DividerData.Companion.getEMPTY();
            }
            if (obj instanceof BackupInfo) {
                return DividerData.Companion.getH12DP();
            }
            return DividerData.Companion.getEMPTY();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        menuInflater.inflate(2131623941, menu);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        MenuItem findItem = menu.findItem(2131361892);
        if (findItem != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isLogin()) {
                String uid = loginSession.getUid();
                BackupInfo backupInfo2 = this.backupInfo;
                if (backupInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backupInfo");
                }
                if (TextUtils.equals(uid, backupInfo2.getUid())) {
                    findItem.setVisible(true);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361892) {
            return super.onOptionsItemSelected(menuItem);
        }
        ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要删除此备份单吗？", "确定", "取消");
        newInstance.setOnOkRunnable(new BackupDetailListFragment$onOptionsItemSelected$1(this));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String str = this.backupId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backupId");
        }
        Observable<R> map = instance.getBackupDetail(str).map(new BackupDetailListFragment$onCreateRequest$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…appList\n                }");
        return map;
    }

    /* access modifiers changed from: private */
    public final void onBackupLoaded(BackupInfo backupInfo2) {
        this.backupInfo = backupInfo2;
        FragmentActivity activity = getActivity();
        if (activity instanceof BackupDetailListActivity) {
            ((BackupDetailListActivity) activity).setAppList(backupInfo2.getServiceApps());
        }
        setHasOptionsMenu(true);
        FragmentActivity activity2 = getActivity();
        if (activity2 instanceof AlphableToolbar) {
            ((AlphableToolbar) activity2).setToolbarAlpha(0.0f);
            FragmentActivity fragmentActivity = activity2;
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 40.0f), new BackupDetailListFragment$onBackupLoaded$1(this, activity2, backupInfo2)));
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 80.0f), new BackupDetailListFragment$onBackupLoaded$2(activity2)));
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558625).suitedMethod(BackupDetailListFragment$onRegisterCards$1.INSTANCE).constructor(new BackupDetailListFragment$onRegisterCards$2(this)).build(), 0);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558627).suitedMethod(BackupDetailListFragment$onRegisterCards$3.INSTANCE).constructor(new BackupDetailListFragment$onRegisterCards$4(this)).build(), 0);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558626).suitedMethod(BackupDetailListFragment$onRegisterCards$5.INSTANCE).constructor(new BackupDetailListFragment$onRegisterCards$6(this)).build(), 0);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558624).suitedMethod(BackupDetailListFragment$onRegisterCards$7.INSTANCE).constructor(new BackupDetailListFragment$onRegisterCards$8(this)).build(), 0);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (!CollectionUtils.isEmpty(list) && z) {
            List<Parcelable> dataList = getDataList();
            HolderItem.Builder entityType = HolderItem.newBuilder().entityType("backupDeatilHeader");
            BackupInfo backupInfo2 = this.backupInfo;
            if (backupInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupInfo");
            }
            HolderItem.Builder dateline = entityType.dateline(backupInfo2.getCreateTime());
            BackupInfo backupInfo3 = this.backupInfo;
            if (backupInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupInfo");
            }
            HolderItem build = dateline.string(backupInfo3.getTitle()).value("全部恢复").entityTemplate("backupDeatilHeader").build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…                 .build()");
            dataList.add(0, build);
            List<Parcelable> dataList2 = getDataList();
            BackupInfo backupInfo4 = this.backupInfo;
            if (backupInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupInfo");
            }
            dataList2.add(1, backupInfo4);
        }
        return onRequestResponse;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupDetailListFragment$Companion;", "", "()V", "EXTRA_BACKUP_ID", "", "newInstance", "Lcom/coolapk/market/view/backupList/BackupDetailListFragment;", "id", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupDetailListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupDetailListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_BACKUP_ID", str);
            BackupDetailListFragment backupDetailListFragment = new BackupDetailListFragment();
            backupDetailListFragment.setArguments(bundle);
            return backupDetailListFragment;
        }
    }
}
