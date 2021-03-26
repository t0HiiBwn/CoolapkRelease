package com.coolapk.market.view.collectionList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.collectionList.CollectionDetailFragment;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.FastReturnView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0003\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "albumModifier", "Lcom/coolapk/market/view/collectionList/CollectionDetailActivity$AlbumCollectionSheetModifier;", "feedModifier", "Lcom/coolapk/market/view/collectionList/CollectionDetailActivity$FeedCollectionSheetModifier;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onDestroy", "setupFastReturnView", "fragment", "AlbumCollectionSheetModifier", "Companion", "FeedCollectionSheetModifier", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionDetailActivity.kt */
public final class CollectionDetailActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_COLLECTION_ID = "EXTRA_COLLECTION_ID";
    private AlbumCollectionSheetModifier albumModifier;
    private FeedCollectionSheetModifier feedModifier;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailActivity$Companion;", "", "()V", "EXTRA_COLLECTION_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        Intent intent = getIntent();
        Intrinsics.checkNotNull(intent);
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        String string = extras.getString("EXTRA_COLLECTION_ID");
        CollectionDetailFragment.Companion companion = CollectionDetailFragment.Companion;
        Intrinsics.checkNotNull(string);
        return companion.newInstance(string);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    protected void setupFastReturnView(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FastReturnView fastReturnView = new FastReturnView(this);
        fastReturnView.setOffset(ConvertUtils.dp2px(40.0f));
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = getBinding().mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        fastReturnView.addTo(drawSystemBarFrameLayout);
        fastReturnView.bindFragment(fragment);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.feedModifier = new FeedCollectionSheetModifier(this);
        this.albumModifier = new AlbumCollectionSheetModifier(this);
        SheetGroupModifierManager sheetGroupModifierManager = SheetGroupModifierManager.INSTANCE;
        FeedCollectionSheetModifier feedCollectionSheetModifier = this.feedModifier;
        if (feedCollectionSheetModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedModifier");
        }
        sheetGroupModifierManager.addModifier(feedCollectionSheetModifier);
        SheetGroupModifierManager sheetGroupModifierManager2 = SheetGroupModifierManager.INSTANCE;
        AlbumCollectionSheetModifier albumCollectionSheetModifier = this.albumModifier;
        if (albumCollectionSheetModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumModifier");
        }
        sheetGroupModifierManager2.addModifier(albumCollectionSheetModifier);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SheetGroupModifierManager sheetGroupModifierManager = SheetGroupModifierManager.INSTANCE;
        FeedCollectionSheetModifier feedCollectionSheetModifier = this.feedModifier;
        if (feedCollectionSheetModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedModifier");
        }
        sheetGroupModifierManager.removeModifier(feedCollectionSheetModifier);
        SheetGroupModifierManager sheetGroupModifierManager2 = SheetGroupModifierManager.INSTANCE;
        AlbumCollectionSheetModifier albumCollectionSheetModifier = this.albumModifier;
        if (albumCollectionSheetModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumModifier");
        }
        sheetGroupModifierManager2.removeModifier(albumCollectionSheetModifier);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailActivity$FeedCollectionSheetModifier;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "activity", "Lcom/coolapk/market/view/collectionList/CollectionDetailActivity;", "(Lcom/coolapk/market/view/collectionList/CollectionDetailActivity;)V", "getActivity", "()Lcom/coolapk/market/view/collectionList/CollectionDetailActivity;", "bgColor", "", "userItemColor", "handleRemove", "", "feed", "Lcom/coolapk/market/model/Feed;", "handleTop", "isTop", "", "modifySheet", "data", "", "items", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "shouldModify", "anchorActivity", "Landroid/app/Activity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionDetailActivity.kt */
    public static final class FeedCollectionSheetModifier implements SheetGroupModifier {
        private final CollectionDetailActivity activity;
        private final int bgColor;
        private final int userItemColor;

        public FeedCollectionSheetModifier(CollectionDetailActivity collectionDetailActivity) {
            Intrinsics.checkNotNullParameter(collectionDetailActivity, "activity");
            this.activity = collectionDetailActivity;
            this.bgColor = ResourceUtils.getColorInt(collectionDetailActivity, 2131100049);
            this.userItemColor = ResourceUtils.resolveData(collectionDetailActivity, 2130969438);
        }

        public final CollectionDetailActivity getActivity() {
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
            SheetDataItem sheetDataItem;
            boolean z;
            Intrinsics.checkNotNullParameter(obj, "data");
            Intrinsics.checkNotNullParameter(list, "items");
            if (obj instanceof Feed) {
                Feed feed = (Feed) obj;
                Collection collectionInfo = feed.getCollectionInfo();
                if (collectionInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(collectionInfo, "data.collectionInfo ?: return");
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    LoginSession loginSession = instance.getLoginSession();
                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                    if (Intrinsics.areEqual(collectionInfo.getUid(), loginSession.getUid())) {
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
                            ArrayList arrayList = new ArrayList();
                            FeedCollectionSheetModifier feedCollectionSheetModifier = this;
                            CollectionItem collectionItem = feed.getCollectionItem();
                            boolean isTop = collectionItem != null ? collectionItem.isTop() : false;
                            CollectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$1 collectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$1 = new CollectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$1(feedCollectionSheetModifier, isTop, arrayList, this, obj);
                            if (isTop) {
                                sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.Three, "取消置顶", SheetDataItem.Companion.createIconBgApplyer(2131231626, feedCollectionSheetModifier.userItemColor, feedCollectionSheetModifier.bgColor), collectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$1, null, 0, false, false, 240, null);
                            } else {
                                sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.Three, "置顶", SheetDataItem.Companion.createIconBgApplyer(2131231615, feedCollectionSheetModifier.userItemColor, feedCollectionSheetModifier.bgColor), collectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$1, null, 0, false, false, 240, null);
                            }
                            arrayList.add(sheetDataItem);
                            arrayList.add(new SheetDataItem(SheetGroupModifier.Action.Two, "从收藏单中移除", SheetDataItem.Companion.createIconBgApplyer(2131231241, feedCollectionSheetModifier.userItemColor, feedCollectionSheetModifier.bgColor), new CollectionDetailActivity$FeedCollectionSheetModifier$modifySheet$$inlined$also$lambda$2(feedCollectionSheetModifier, arrayList, this, obj), null, 2, false, false, 208, null));
                            ArrayList arrayList2 = arrayList;
                            if (!arrayList2.isEmpty()) {
                                arrayList.add(SheetDataItem.copy$default((SheetDataItem) CollectionsKt.removeLast(arrayList), null, null, null, null, null, 0, true, false, 191, null));
                                t2.getItems().addAll(0, arrayList2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* access modifiers changed from: private */
        public final void handleTop(Feed feed, boolean z) {
            Observable.just(Boolean.valueOf(z)).flatMap(new CollectionDetailActivity$FeedCollectionSheetModifier$handleTop$1(feed)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new CollectionDetailActivity$FeedCollectionSheetModifier$handleTop$2(z, feed));
        }

        /* access modifiers changed from: private */
        public final void handleRemove(Feed feed) {
            DataManager instance = DataManager.getInstance();
            CollectionItem collectionItem = feed.getCollectionItem();
            Intrinsics.checkNotNull(collectionItem);
            Intrinsics.checkNotNullExpressionValue(collectionItem, "feed.collectionItem!!");
            instance.removeCollectionItem(collectionItem.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new CollectionDetailActivity$FeedCollectionSheetModifier$handleRemove$1(feed));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailActivity$AlbumCollectionSheetModifier;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "activity", "Lcom/coolapk/market/view/collectionList/CollectionDetailActivity;", "(Lcom/coolapk/market/view/collectionList/CollectionDetailActivity;)V", "getActivity", "()Lcom/coolapk/market/view/collectionList/CollectionDetailActivity;", "bgColor", "", "userItemColor", "handleRemove", "", "album", "Lcom/coolapk/market/model/Album;", "handleTop", "isTop", "", "modifySheet", "data", "", "items", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "shouldModify", "anchorActivity", "Landroid/app/Activity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionDetailActivity.kt */
    public static final class AlbumCollectionSheetModifier implements SheetGroupModifier {
        private final CollectionDetailActivity activity;
        private final int bgColor;
        private final int userItemColor;

        public AlbumCollectionSheetModifier(CollectionDetailActivity collectionDetailActivity) {
            Intrinsics.checkNotNullParameter(collectionDetailActivity, "activity");
            this.activity = collectionDetailActivity;
            this.bgColor = ResourceUtils.getColorInt(collectionDetailActivity, 2131100049);
            this.userItemColor = ResourceUtils.resolveData(collectionDetailActivity, 2130969438);
        }

        public final CollectionDetailActivity getActivity() {
            return this.activity;
        }

        @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
        public boolean shouldModify(Object obj, Activity activity2) {
            Intrinsics.checkNotNullParameter(obj, "data");
            return (obj instanceof Album) && activity2 == this.activity;
        }

        @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
        public void modifySheet(Object obj, List<SheetGroup> list) {
            T t;
            SheetDataItem sheetDataItem;
            boolean z;
            Intrinsics.checkNotNullParameter(obj, "data");
            Intrinsics.checkNotNullParameter(list, "items");
            if (obj instanceof Album) {
                Album album = (Album) obj;
                Collection collectionInfo = album.getCollectionInfo();
                if (collectionInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(collectionInfo, "data.collectionInfo ?: return");
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    LoginSession loginSession = instance.getLoginSession();
                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                    if (Intrinsics.areEqual(collectionInfo.getUid(), loginSession.getUid())) {
                        Iterator<T> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it2.next();
                            if (t.getType() == SheetGroupType.AlbumUser) {
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
                            ArrayList arrayList = new ArrayList();
                            AlbumCollectionSheetModifier albumCollectionSheetModifier = this;
                            CollectionItem collectionItem = album.getCollectionItem();
                            boolean isTop = collectionItem != null ? collectionItem.isTop() : false;
                            CollectionDetailActivity$AlbumCollectionSheetModifier$modifySheet$$inlined$also$lambda$1 collectionDetailActivity$AlbumCollectionSheetModifier$modifySheet$$inlined$also$lambda$1 = new CollectionDetailActivity$AlbumCollectionSheetModifier$modifySheet$$inlined$also$lambda$1(albumCollectionSheetModifier, isTop, arrayList, this, obj);
                            if (isTop) {
                                sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.Three, "取消置顶", SheetDataItem.Companion.createIconBgApplyer(2131231626, albumCollectionSheetModifier.userItemColor, albumCollectionSheetModifier.bgColor), collectionDetailActivity$AlbumCollectionSheetModifier$modifySheet$$inlined$also$lambda$1, null, 0, false, false, 240, null);
                            } else {
                                sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.Three, "置顶", SheetDataItem.Companion.createIconBgApplyer(2131231615, albumCollectionSheetModifier.userItemColor, albumCollectionSheetModifier.bgColor), collectionDetailActivity$AlbumCollectionSheetModifier$modifySheet$$inlined$also$lambda$1, null, 0, false, false, 240, null);
                            }
                            arrayList.add(sheetDataItem);
                            arrayList.add(new SheetDataItem(SheetGroupModifier.Action.Two, "从收藏单中移除", SheetDataItem.Companion.createIconBgApplyer(2131231241, albumCollectionSheetModifier.userItemColor, albumCollectionSheetModifier.bgColor), new CollectionDetailActivity$AlbumCollectionSheetModifier$modifySheet$$inlined$also$lambda$2(albumCollectionSheetModifier, arrayList, this, obj), null, 2, false, false, 208, null));
                            ArrayList arrayList2 = arrayList;
                            if (!arrayList2.isEmpty()) {
                                arrayList.add(SheetDataItem.copy$default((SheetDataItem) CollectionsKt.removeLast(arrayList), null, null, null, null, null, 0, true, false, 191, null));
                                t2.getItems().addAll(0, arrayList2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* access modifiers changed from: private */
        public final void handleTop(Album album, boolean z) {
            Observable.just(Boolean.valueOf(z)).flatMap(new CollectionDetailActivity$AlbumCollectionSheetModifier$handleTop$1(album)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new CollectionDetailActivity$AlbumCollectionSheetModifier$handleTop$2(z, album));
        }

        /* access modifiers changed from: private */
        public final void handleRemove(Album album) {
            DataManager instance = DataManager.getInstance();
            CollectionItem collectionItem = album.getCollectionItem();
            Intrinsics.checkNotNull(collectionItem);
            Intrinsics.checkNotNullExpressionValue(collectionItem, "album.collectionItem!!");
            instance.removeCollectionItem(collectionItem.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new CollectionDetailActivity$AlbumCollectionSheetModifier$handleRemove$1(album));
        }
    }
}
