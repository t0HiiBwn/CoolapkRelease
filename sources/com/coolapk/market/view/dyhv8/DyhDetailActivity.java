package com.coolapk.market.view.dyhv8;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.dyhv8.DyhDetailFragment;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001eH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhDetailActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "dyhId", "", "getDyhId", "()Ljava/lang/String;", "setDyhId", "(Ljava/lang/String;)V", "dyhModel", "Lcom/coolapk/market/model/DyhModel;", "getDyhModel", "()Lcom/coolapk/market/model/DyhModel;", "setDyhModel", "(Lcom/coolapk/market/model/DyhModel;)V", "isEditor", "", "()Z", "setEditor", "(Z)V", "modifier", "Lcom/coolapk/market/view/dyhv8/DyhDetailActivity$FeedDyhDetailSheetModifier;", "page", "", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onDestroy", "Companion", "FeedDyhDetailSheetModifier", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhDetailActivity.kt */
public final class DyhDetailActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_DYH_EDITOR = "DYH_EDITOR";
    public static final String EXTRA_DYH_ID = "DYH_ID";
    private String dyhId;
    private DyhModel dyhModel;
    private boolean isEditor;
    private FeedDyhDetailSheetModifier modifier;
    private Integer page = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhDetailActivity$Companion;", "", "()V", "EXTRA_DYH_EDITOR", "", "EXTRA_DYH_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getDyhId() {
        return this.dyhId;
    }

    public final void setDyhId(String str) {
        this.dyhId = str;
    }

    public final Integer getPage() {
        return this.page;
    }

    public final void setPage(Integer num) {
        this.page = num;
    }

    public final boolean isEditor() {
        return this.isEditor;
    }

    public final void setEditor(boolean z) {
        this.isEditor = z;
    }

    public final DyhModel getDyhModel() {
        return this.dyhModel;
    }

    public final void setDyhModel(DyhModel dyhModel2) {
        this.dyhModel = dyhModel2;
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        this.dyhId = getIntent().getStringExtra("DYH_ID");
        setTitle("");
        this.isEditor = getIntent().getBooleanExtra("DYH_EDITOR", false);
        DyhDetailFragment.Companion companion = DyhDetailFragment.Companion;
        String str = this.dyhId;
        Intrinsics.checkNotNull(str);
        return companion.newInstance(str);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.modifier = new FeedDyhDetailSheetModifier(this);
        SheetGroupModifierManager sheetGroupModifierManager = SheetGroupModifierManager.INSTANCE;
        FeedDyhDetailSheetModifier feedDyhDetailSheetModifier = this.modifier;
        if (feedDyhDetailSheetModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modifier");
        }
        sheetGroupModifierManager.addModifier(feedDyhDetailSheetModifier);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SheetGroupModifierManager sheetGroupModifierManager = SheetGroupModifierManager.INSTANCE;
        FeedDyhDetailSheetModifier feedDyhDetailSheetModifier = this.modifier;
        if (feedDyhDetailSheetModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modifier");
        }
        sheetGroupModifierManager.removeModifier(feedDyhDetailSheetModifier);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhDetailActivity$FeedDyhDetailSheetModifier;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "activity", "Lcom/coolapk/market/view/dyhv8/DyhDetailActivity;", "(Lcom/coolapk/market/view/dyhv8/DyhDetailActivity;)V", "getActivity", "()Lcom/coolapk/market/view/dyhv8/DyhDetailActivity;", "bgColor", "", "userItemColor", "handleDyhRemove", "", "feed", "Lcom/coolapk/market/model/Feed;", "dyhModel", "Lcom/coolapk/market/model/DyhModel;", "handleRecommend", "toRecommend", "", "handleTop", "isTop", "modifySheet", "data", "", "items", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "shouldModify", "anchorActivity", "Landroid/app/Activity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhDetailActivity.kt */
    public static final class FeedDyhDetailSheetModifier implements SheetGroupModifier {
        private final DyhDetailActivity activity;
        private final int bgColor;
        private final int userItemColor;

        public FeedDyhDetailSheetModifier(DyhDetailActivity dyhDetailActivity) {
            Intrinsics.checkNotNullParameter(dyhDetailActivity, "activity");
            this.activity = dyhDetailActivity;
            this.bgColor = ResourceUtils.getColorInt(dyhDetailActivity, 2131100054);
            this.userItemColor = ResourceUtils.resolveData(dyhDetailActivity, 2130969438);
        }

        public final DyhDetailActivity getActivity() {
            return this.activity;
        }

        @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
        public boolean shouldModify(Object obj, Activity activity2) {
            Intrinsics.checkNotNullParameter(obj, "data");
            return (obj instanceof Feed) && activity2 == this.activity;
        }

        @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
        public void modifySheet(Object obj, List<SheetGroup> list) {
            T t;
            ArrayList arrayList;
            SheetDataItem sheetDataItem;
            SheetDataItem sheetDataItem2;
            boolean z;
            Intrinsics.checkNotNullParameter(obj, "data");
            Intrinsics.checkNotNullParameter(list, "items");
            DyhModel dyhModel = this.activity.getDyhModel();
            if (dyhModel != null) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                boolean contains = dyhModel.getEditors().contains(loginSession.getUid());
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                LoginSession loginSession2 = instance2.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
                boolean equals = TextUtils.equals(dyhModel.getUid(), loginSession2.getUid());
                DataManager instance3 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                LoginSession loginSession3 = instance3.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession3, "DataManager.getInstance().loginSession");
                boolean isAdmin = loginSession3.isAdmin();
                Integer page = this.activity.getPage();
                int intValue = page != null ? page.intValue() : 0;
                if (obj instanceof Feed) {
                    Iterator<T> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t = null;
                            break;
                        }
                        t = it2.next();
                        if (t.getType() == SheetGroupType.FeedUser) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        if (!contains || intValue != 0 || !equals) {
                            arrayList = arrayList2;
                        } else {
                            boolean isTop = ((Feed) obj).isTop();
                            arrayList = arrayList2;
                            DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$1 dyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$1 = new DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$1(isTop, this, contains, intValue, equals, obj, isAdmin, dyhModel);
                            if (isTop) {
                                sheetDataItem2 = new SheetDataItem(SheetGroupModifier.Action.Three, "取消置顶", SheetDataItem.Companion.createIconBgApplyer(2131231637, this.userItemColor, this.bgColor), dyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$1, null, 0, false, false, 240, null);
                            } else {
                                sheetDataItem2 = new SheetDataItem(SheetGroupModifier.Action.Three, "置顶", SheetDataItem.Companion.createIconBgApplyer(2131231626, this.userItemColor, this.bgColor), dyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$1, null, 0, false, false, 240, null);
                            }
                            arrayList.add(sheetDataItem2);
                        }
                        if (contains) {
                            boolean z2 = intValue == 0;
                            DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$2 dyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$2 = new DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$2(z2, this, contains, intValue, equals, obj, isAdmin, dyhModel);
                            if (z2) {
                                sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.One, "下看看号精选", SheetDataItem.Companion.createIconBgApplyer(2131231684, this.userItemColor, this.bgColor), dyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$2, null, 2, false, false, 208, null);
                            } else {
                                sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.One, "上看看号精选", SheetDataItem.Companion.createIconBgApplyer(2131231553, this.userItemColor, this.bgColor), dyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$2, null, 2, false, false, 208, null);
                            }
                            arrayList.add(sheetDataItem);
                        }
                        if (contains || isAdmin) {
                            arrayList.add(new SheetDataItem(SheetGroupModifier.Action.Two, "从看看号中移除", SheetDataItem.Companion.createIconBgApplyer(2131231252, this.userItemColor, this.bgColor), new DyhDetailActivity$FeedDyhDetailSheetModifier$modifySheet$$inlined$also$lambda$3(this, contains, intValue, equals, obj, isAdmin, dyhModel), null, 2, false, false, 208, null));
                        }
                        ArrayList arrayList3 = arrayList;
                        if (!arrayList3.isEmpty()) {
                            arrayList.add(SheetDataItem.copy$default((SheetDataItem) CollectionsKt.removeLast(arrayList), null, null, null, null, null, 0, true, false, 191, null));
                            t2.getItems().addAll(0, arrayList3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        /* access modifiers changed from: private */
        public final void handleTop(Feed feed, boolean z) {
            Observable.just(Boolean.valueOf(z)).flatMap(new DyhDetailActivity$FeedDyhDetailSheetModifier$handleTop$1(feed)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new DyhDetailActivity$FeedDyhDetailSheetModifier$handleTop$2(z, feed));
        }

        /* access modifiers changed from: private */
        public final void handleRecommend(Feed feed, boolean z) {
            Observable.just(Boolean.valueOf(z)).flatMap(new DyhDetailActivity$FeedDyhDetailSheetModifier$handleRecommend$1(feed)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new DyhDetailActivity$FeedDyhDetailSheetModifier$handleRecommend$2(z, feed));
        }

        /* access modifiers changed from: private */
        public final void handleDyhRemove(Feed feed, DyhModel dyhModel) {
            DataManager.getInstance().onArticleRemove(feed.getId(), 2, dyhModel.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new DyhDetailActivity$FeedDyhDetailSheetModifier$handleDyhRemove$1(feed));
        }
    }
}
