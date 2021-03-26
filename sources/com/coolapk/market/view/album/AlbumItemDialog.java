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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00122\u00020\u0001:\u000f\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "mPresenter", "Lcom/coolapk/market/view/album/AlbumActionPresenter;", "kotlin.jvm.PlatformType", "buildAdminActionItem", "Lcom/coolapk/market/view/base/MultiActionItem;", "album", "Lcom/coolapk/market/model/Album;", "buildMultiActionItem", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "BannedActionItem", "CollectionRemoveActionItem", "CollectionTop", "Companion", "DeleteActionItem", "EditorChoiceActionItem", "FoldedActionItem", "HeadlineActionItem", "HomePageActionItem", "InfoDialogFragment", "NoHomePageActionItem", "PrivateActionItem", "RecommendActionItem", "SoftFoldedActionItem", "StatusActionItem", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumItemDialog.kt */
public final class AlbumItemDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final AlbumActionPresenter mPresenter = AlbumActionPresenter.getInstance();

    @JvmStatic
    public static final AlbumItemDialog newInstance(Album album, URLSpan[] uRLSpanArr) {
        return Companion.newInstance(album, uRLSpanArr);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/album/AlbumItemDialog;", "album", "Lcom/coolapk/market/model/Album;", "spans", "", "Landroid/text/style/URLSpan;", "(Lcom/coolapk/market/model/Album;[Landroid/text/style/URLSpan;)Lcom/coolapk/market/view/album/AlbumItemDialog;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumItemDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$CollectionRemoveActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "title", "", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;Ljava/lang/String;Lcom/coolapk/market/model/Album;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$CollectionTop;", "Lcom/coolapk/market/view/base/ActionItem;", "mAdd", "", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "getAlbum", "()Lcom/coolapk/market/model/Album;", "getMAdd", "()Z", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    /* access modifiers changed from: private */
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

    /* access modifiers changed from: private */
    public final MultiActionItem buildAdminActionItem(Album album) {
        return new MultiActionItem("管理", new AlbumItemDialog$buildAdminActionItem$1(this, album));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$HeadlineActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "mAdd", "", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "getAlbum", "()Lcom/coolapk/market/model/Album;", "getMAdd", "()Z", "onErrorEvent", "", "throwable", "", "takeAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

        /* access modifiers changed from: private */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$HomePageActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "mAdd", "", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "getAlbum", "()Lcom/coolapk/market/model/Album;", "getMAdd", "()Z", "onErrorEvent", "", "throwable", "", "takeAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

        /* access modifiers changed from: private */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$NoHomePageActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;Lcom/coolapk/market/model/Album;)V", "getAlbum", "()Lcom/coolapk/market/model/Album;", "onErrorEvent", "", "throwable", "", "takeAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

        /* access modifiers changed from: private */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$PrivateActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "isSet", "", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "()Z", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$StatusActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;Lcom/coolapk/market/model/Album;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$FoldedActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "isSet", "", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "()Z", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$SoftFoldedActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;Lcom/coolapk/market/model/Album;)V", "isSet", "", "()Z", "setSet", "(Z)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$BannedActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "isSet", "", "album", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "()Z", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$EditorChoiceActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "isRecommended", "", "mFeed", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "()Z", "getMFeed", "()Lcom/coolapk/market/model/Album;", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$DeleteActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "title", "", "feed", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;Ljava/lang/String;Lcom/coolapk/market/model/Album;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
            String string = this.this$0.getString(2131886784);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_delete_title)");
            ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(string, "删除 " + this.feed.getUserName() + " 的应用集： " + this.feed.getIntroduce());
            newInstance.setDeleteTarget(this.feed);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$RecommendActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "mAdd", "", "mFeed", "Lcom/coolapk/market/model/Album;", "(Lcom/coolapk/market/view/album/AlbumItemDialog;ZLcom/coolapk/market/model/Album;)V", "getMAdd", "()Z", "getMFeed", "()Lcom/coolapk/market/model/Album;", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$InfoDialogFragment;", "Lcom/coolapk/market/widget/MinimumWidthDialog;", "()V", "blockStatus", "", "blockStatusText", "", "entity", "Lcom/coolapk/market/model/Album;", "isHeadline", "isHeadlineV8", "messageStatus", "messageStatusText", "modelInfo", "recommend", "status", "statusText", "uid", "url", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/album/AlbumItemDialog$InfoDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/album/AlbumItemDialog$InfoDialogFragment;", "entity", "Lcom/coolapk/market/model/Album;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
