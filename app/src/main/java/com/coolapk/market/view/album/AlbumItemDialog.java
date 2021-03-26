package com.coolapk.market.view.album;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.style.URLSpan;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.FeedRemoveHeadlineEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog;
import com.coolapk.market.widget.MinimumWidthDialog;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;

/* compiled from: AlbumItemDialog.kt */
public final class AlbumItemDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final AlbumActionPresenter mPresenter = AlbumActionPresenter.getInstance();

    public static final AlbumItemDialog newInstance(Album album, URLSpan[] uRLSpanArr) {
        return Companion.newInstance(album, uRLSpanArr);
    }

    /* compiled from: AlbumItemDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AlbumItemDialog newInstance(Album album, URLSpan[] uRLSpanArr) {
            Intrinsics.checkNotNullParameter(album, "album");
            Intrinsics.checkNotNullParameter(uRLSpanArr, "spans");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (!(uRLSpanArr.length == 0)) {
                CollectionsKt.addAll(arrayList, uRLSpanArr);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("urlspan", arrayList);
            bundle.putParcelable("album", album);
            AlbumItemDialog albumItemDialog = new AlbumItemDialog();
            albumItemDialog.setArguments(bundle);
            return albumItemDialog;
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        updateDataList(new AlbumItemDialog$onActivityCreated$1(this));
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class CollectionRemoveActionItem extends ActionItem {
        private final Album album;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CollectionRemoveActionItem(AlbumItemDialog albumItemDialog, String str, Album album2) {
            super(str, null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            Intrinsics.checkNotNull(str);
            this.album = album2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager instance = DataManager.getInstance();
            CollectionItem collectionItem = this.album.getCollectionItem();
            Intrinsics.checkNotNull(collectionItem);
            Intrinsics.checkNotNullExpressionValue(collectionItem, "album.collectionItem!!");
            instance.removeCollectionItem(collectionItem.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AlbumItemDialog$CollectionRemoveActionItem$takeAction$1(this));
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class CollectionTop extends ActionItem {
        private final Album album;
        private final boolean mAdd;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CollectionTop(AlbumItemDialog albumItemDialog, boolean z, Album album2) {
            super(z ? "取消置顶" : "置顶", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.mAdd = z;
            this.album = album2;
        }

        public final Album getAlbum() {
            return this.album;
        }

        public final boolean getMAdd() {
            return this.mAdd;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.mAdd)).flatMap(new AlbumItemDialog$CollectionTop$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumItemDialog$CollectionTop$takeAction$2(this));
        }
    }

    public final MultiActionItem buildMultiActionItem(Album album) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) requireArguments().getParcelableArrayList("urlspan");
        if (objectRef.element == null) {
            objectRef.element = (T) CollectionsKt.emptyList();
        }
        String string = getString(2131886121);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.action_copy)");
        return new MultiActionItem(string, new AlbumItemDialog$buildMultiActionItem$1(this, album, objectRef));
    }

    public final MultiActionItem buildAdminActionItem(Album album) {
        return new MultiActionItem("管理", new AlbumItemDialog$buildAdminActionItem$1(this, album));
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class HeadlineActionItem extends ActionItem {
        private final Album album;
        private final boolean mAdd;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeadlineActionItem(AlbumItemDialog albumItemDialog, boolean z, Album album2) {
            super(z ? "上头条（V7）" : "下头条（V7）", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.mAdd = z;
            this.album = album2;
        }

        public static final /* synthetic */ void access$onErrorEvent(HeadlineActionItem headlineActionItem, Throwable th) {
            headlineActionItem.onErrorEvent(th);
        }

        public final Album getAlbum() {
            return this.album;
        }

        public final boolean getMAdd() {
            return this.mAdd;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.mAdd)).flatMap(new AlbumItemDialog$HeadlineActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumItemDialog$HeadlineActionItem$takeAction$2(this));
        }

        private final void onErrorEvent(Throwable th) {
            if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
                ClientException clientException = (ClientException) th.getCause();
                Intrinsics.checkNotNull(clientException);
                if (clientException.getStatusCode() == -1) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.album.getId()));
                } else {
                    Toast.error(AppHolder.getApplication(), clientException);
                }
            }
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class HomePageActionItem extends ActionItem {
        private final Album album;
        private final boolean mAdd;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomePageActionItem(AlbumItemDialog albumItemDialog, boolean z, Album album2) {
            super(z ? "上头条" : "下头条", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.mAdd = z;
            this.album = album2;
        }

        public final Album getAlbum() {
            return this.album;
        }

        public final boolean getMAdd() {
            return this.mAdd;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.mAdd)).flatMap(new AlbumItemDialog$HomePageActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumItemDialog$HomePageActionItem$takeAction$2(this));
        }

        public final void onErrorEvent(Throwable th) {
            if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
                ClientException clientException = (ClientException) th.getCause();
                Intrinsics.checkNotNull(clientException);
                if (clientException.getStatusCode() == -1) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.album.getId()));
                } else {
                    Toast.error(AppHolder.getApplication(), clientException);
                }
            }
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class NoHomePageActionItem extends ActionItem {
        private final Album album;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoHomePageActionItem(AlbumItemDialog albumItemDialog, Album album2) {
            super("禁止该应用集上头条", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.album = album2;
        }

        public final Album getAlbum() {
            return this.album;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            this.this$0.mPresenter.removeFromHeadlineV8(this.album).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AlbumItemDialog$NoHomePageActionItem$takeAction$1(this));
        }

        public final void onErrorEvent(Throwable th) {
            if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
                ClientException clientException = (ClientException) th.getCause();
                Intrinsics.checkNotNull(clientException);
                if (clientException.getStatusCode() == -1) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.album.getId()));
                } else {
                    Toast.error(AppHolder.getApplication(), clientException);
                }
            }
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class PrivateActionItem extends ActionItem {
        private final Album album;
        private final boolean isSet;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrivateActionItem(AlbumItemDialog albumItemDialog, boolean z, Album album2) {
            super(z ? "取消仅作者可见" : "仅作者自己可见", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.isSet = z;
            this.album = album2;
        }

        public final boolean isSet() {
            return this.isSet;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_PRIVATE", false)) {
                ConfirmFeedBlockDialog.executeAction(this.album, 0, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定取消仅作者可见？" : "确定要设为仅作者可见?", z ? "取消后，将恢复成正常动态" : "内容只显示在作者主页，通过作者主页可以访问");
            newInstance.setAction(this.album, 0, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_PRIVATE", true).apply();
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class StatusActionItem extends ActionItem {
        private final Album album;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StatusActionItem(AlbumItemDialog albumItemDialog, Album album2) {
            super("查看状态", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.album = album2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            InfoDialogFragment newInstance = InfoDialogFragment.Companion.newInstance(this.album);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class FoldedActionItem extends ActionItem {
        private final Album album;
        private final boolean isSet;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FoldedActionItem(AlbumItemDialog albumItemDialog, boolean z, Album album2) {
            super(z ? "取消折叠" : "折叠/不在公共区域显示", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.isSet = z;
            this.album = album2;
        }

        public final boolean isSet() {
            return this.isSet;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_FLODED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.album, 1, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消折叠此动态？" : "确定要折叠此动态？", z ? "取消折叠后将恢复成正常的动态" : "折叠后不在公共区域显示，但还会显示在粉丝的好友圈");
            newInstance.setAction(this.album, 1, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_FLODED", true).apply();
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class SoftFoldedActionItem extends ActionItem {
        private final Album album;
        private boolean isSet;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SoftFoldedActionItem(AlbumItemDialog albumItemDialog, Album album2) {
            super("去精/不在精选区显示", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.album = album2;
        }

        public final boolean isSet() {
            return this.isSet;
        }

        public final void setSet(boolean z) {
            this.isSet = z;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_SOFT_FLODED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.album, 4, false, this.this$0.getActivity());
                return;
            }
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance("确定要去精此动态？", "去精后不在精选区显示，但还会显示在粉丝的好友圈");
            newInstance.setAction(this.album, 4, false, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_SOFT_FLODED", true).apply();
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class BannedActionItem extends ActionItem {
        private final Album album;
        private final boolean isSet;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BannedActionItem(AlbumItemDialog albumItemDialog, boolean z, Album album2) {
            super(z ? "取消屏蔽" : "屏蔽/禁止访问", null, 2, null);
            Intrinsics.checkNotNullParameter(album2, "album");
            this.this$0 = albumItemDialog;
            this.isSet = z;
            this.album = album2;
        }

        public final boolean isSet() {
            return this.isSet;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_BANNED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.album, 2, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消屏蔽此动态？" : "确定要屏蔽此动态？", z ? "取消屏蔽后，将恢复成正常动态" : "屏蔽后禁止访问，等同于删除，但不会真正删除数据");
            newInstance.setAction(this.album, 2, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_BANNED", true).apply();
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class EditorChoiceActionItem extends ActionItem {
        private final boolean isRecommended;
        private final Album mFeed;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EditorChoiceActionItem(AlbumItemDialog albumItemDialog, boolean z, Album album) {
            super(z ? "取消编辑精选" : "上编辑精选", null, 2, null);
            Intrinsics.checkNotNullParameter(album, "mFeed");
            this.this$0 = albumItemDialog;
            this.isRecommended = z;
            this.mFeed = album;
        }

        public final Album getMFeed() {
            return this.mFeed;
        }

        public final boolean isRecommended() {
            return this.isRecommended;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.isRecommended)).flatMap(new AlbumItemDialog$EditorChoiceActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumItemDialog$EditorChoiceActionItem$takeAction$2(this));
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    private final class DeleteActionItem extends ActionItem {
        private final Album feed;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteActionItem(AlbumItemDialog albumItemDialog, String str, Album album) {
            super(str, null, 2, null);
            Intrinsics.checkNotNullParameter(album, "feed");
            this.this$0 = albumItemDialog;
            Intrinsics.checkNotNull(str);
            this.feed = album;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            String string = this.this$0.getString(2131886722);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_delete_title)");
            ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(string, "删除 " + this.feed.getUserName() + " 的应用集： " + this.feed.getIntroduce());
            newInstance.setDeleteTarget(this.feed);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public final class RecommendActionItem extends ActionItem {
        private final boolean mAdd;
        private final Album mFeed;
        final /* synthetic */ AlbumItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RecommendActionItem(AlbumItemDialog albumItemDialog, boolean z, Album album) {
            super(z ? "取消推荐" : "上推荐", null, 2, null);
            Intrinsics.checkNotNullParameter(album, "mFeed");
            this.this$0 = albumItemDialog;
            this.mAdd = z;
            this.mFeed = album;
        }

        public final boolean getMAdd() {
            return this.mAdd;
        }

        public final Album getMFeed() {
            return this.mFeed;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.mAdd)).flatMap(new AlbumItemDialog$RecommendActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumItemDialog$RecommendActionItem$takeAction$2(this));
        }
    }

    /* compiled from: AlbumItemDialog.kt */
    public static final class InfoDialogFragment extends MinimumWidthDialog {
        public static final Companion Companion = new Companion(null);
        private int blockStatus;
        private String blockStatusText;
        private Album entity;
        private String isHeadline;
        private String isHeadlineV8;
        private int messageStatus;
        private String messageStatusText;
        private String modelInfo = "";
        private int recommend;
        private int status;
        private String statusText;
        private String uid;
        private String url;

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            Album album = (Album) requireArguments().getParcelable("entity");
            this.entity = album;
            if (album != null) {
                Objects.requireNonNull(album, "null cannot be cast to non-null type com.coolapk.market.model.Album");
                this.modelInfo = album.toString();
                this.url = "https://www.coolapk.com" + album.getUrl();
                this.status = album.getStatus();
                this.recommend = album.getRecommend();
                this.statusText = album.getStatusText();
                this.messageStatus = album.getMessageStatus();
                this.messageStatusText = album.getMessageStatusText();
                this.blockStatus = album.getBlockStatus();
                this.blockStatusText = album.getBlockStatusText();
                this.isHeadlineV8 = album.getIsHeadlineV8() == 0 ? "否" : "是";
                this.uid = album.getUid();
            }
            AlertDialog.Builder title = new AlertDialog.Builder(getActivity()).setTitle("状态值");
            AlertDialog create = title.setMessage(this.url + "\nuid:" + this.uid + "\nrecommend:" + this.recommend + "\nstatus:" + this.statusText + "(" + this.status + ")\nmessageStatus:" + this.messageStatusText + "(" + this.messageStatus + ")\nblockStatus:" + this.blockStatusText + "(" + this.blockStatus + ")\nisHeadlineV8:" + this.isHeadlineV8).setPositiveButton("确定", (DialogInterface.OnClickListener) null).setNegativeButton("详细信息", new AlbumItemDialog$InfoDialogFragment$onCreateDialog$1(this)).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
            return create;
        }

        /* compiled from: AlbumItemDialog.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final InfoDialogFragment newInstance(Album album) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("entity", album);
                InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
                infoDialogFragment.setArguments(bundle);
                return infoDialogFragment;
            }
        }
    }
}
