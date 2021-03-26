package com.coolapk.market.view.collectionList;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0003\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/collectionList/AppViewForCollectionItemDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "CollectionRemoveActionItem", "CollectionTop", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewForCollectionItemDialog.kt */
public final class AppViewForCollectionItemDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DATA = "DATA";

    @JvmStatic
    public static final AppViewForCollectionItemDialog newInstance(Album album) {
        return Companion.newInstance(album);
    }

    @JvmStatic
    public static final AppViewForCollectionItemDialog newInstance(DyhArticle dyhArticle) {
        return Companion.newInstance(dyhArticle);
    }

    @JvmStatic
    public static final AppViewForCollectionItemDialog newInstance(ItemPlaceHolder itemPlaceHolder) {
        return Companion.newInstance(itemPlaceHolder);
    }

    @JvmStatic
    public static final AppViewForCollectionItemDialog newInstance(ServiceApp serviceApp) {
        return Companion.newInstance(serviceApp);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/collectionList/AppViewForCollectionItemDialog$Companion;", "", "()V", "KEY_DATA", "", "newInstance", "Lcom/coolapk/market/view/collectionList/AppViewForCollectionItemDialog;", "entity", "Lcom/coolapk/market/model/Album;", "Lcom/coolapk/market/model/DyhArticle;", "Lcom/coolapk/market/model/ItemPlaceHolder;", "Lcom/coolapk/market/model/ServiceApp;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewForCollectionItemDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AppViewForCollectionItemDialog newInstance(ServiceApp serviceApp) {
            Intrinsics.checkNotNullParameter(serviceApp, "entity");
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", serviceApp);
            AppViewForCollectionItemDialog appViewForCollectionItemDialog = new AppViewForCollectionItemDialog();
            appViewForCollectionItemDialog.setArguments(bundle);
            return appViewForCollectionItemDialog;
        }

        @JvmStatic
        public final AppViewForCollectionItemDialog newInstance(DyhArticle dyhArticle) {
            Intrinsics.checkNotNullParameter(dyhArticle, "entity");
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", dyhArticle);
            AppViewForCollectionItemDialog appViewForCollectionItemDialog = new AppViewForCollectionItemDialog();
            appViewForCollectionItemDialog.setArguments(bundle);
            return appViewForCollectionItemDialog;
        }

        @JvmStatic
        public final AppViewForCollectionItemDialog newInstance(ItemPlaceHolder itemPlaceHolder) {
            Intrinsics.checkNotNullParameter(itemPlaceHolder, "entity");
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", itemPlaceHolder);
            AppViewForCollectionItemDialog appViewForCollectionItemDialog = new AppViewForCollectionItemDialog();
            appViewForCollectionItemDialog.setArguments(bundle);
            return appViewForCollectionItemDialog;
        }

        @JvmStatic
        public final AppViewForCollectionItemDialog newInstance(Album album) {
            Intrinsics.checkNotNullParameter(album, "entity");
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", album);
            AppViewForCollectionItemDialog appViewForCollectionItemDialog = new AppViewForCollectionItemDialog();
            appViewForCollectionItemDialog.setArguments(bundle);
            return appViewForCollectionItemDialog;
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Entity entity = (Entity) requireArguments().getParcelable("DATA");
        if (entity != null) {
            Intrinsics.checkNotNullExpressionValue(entity, "requireArguments().getPa…tity>(KEY_DATA) ?: return");
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getLoginSession();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) null;
            if (entity instanceof ServiceApp) {
                objectRef.element = (T) ((ServiceApp) entity);
            }
            updateDataList(new AppViewForCollectionItemDialog$onActivityCreated$1(this, objectRef, entity));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/collectionList/AppViewForCollectionItemDialog$CollectionRemoveActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "entity", "Lcom/coolapk/market/model/Entity;", "(Lcom/coolapk/market/view/collectionList/AppViewForCollectionItemDialog;Lcom/coolapk/market/model/Entity;)V", "getEntity$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/Entity;", "setEntity$presentation_coolapkAppRelease", "(Lcom/coolapk/market/model/Entity;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewForCollectionItemDialog.kt */
    public final class CollectionRemoveActionItem extends ActionItem {
        private Entity entity;
        final /* synthetic */ AppViewForCollectionItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CollectionRemoveActionItem(AppViewForCollectionItemDialog appViewForCollectionItemDialog, Entity entity2) {
            super("从收藏单中移除", null, 2, null);
            Intrinsics.checkNotNullParameter(entity2, "entity");
            this.this$0 = appViewForCollectionItemDialog;
            this.entity = entity2;
        }

        public final Entity getEntity$presentation_coolapkAppRelease() {
            return this.entity;
        }

        public final void setEntity$presentation_coolapkAppRelease(Entity entity2) {
            Intrinsics.checkNotNullParameter(entity2, "<set-?>");
            this.entity = entity2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Entity entity2 = this.entity;
            if (entity2 instanceof ServiceApp) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Entity entity3 = this.entity;
                Objects.requireNonNull(entity3, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                objectRef.element = (T) ((ServiceApp) entity3);
                DataManager instance = DataManager.getInstance();
                CollectionItem collectionItem = objectRef.element.getCollectionItem();
                Intrinsics.checkNotNull(collectionItem);
                Intrinsics.checkNotNullExpressionValue(collectionItem, "app.collectionItem!!");
                instance.removeCollectionItem(collectionItem.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AppViewForCollectionItemDialog$CollectionRemoveActionItem$takeAction$1(objectRef));
            } else if (entity2 instanceof ItemPlaceHolder) {
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                Entity entity4 = this.entity;
                Objects.requireNonNull(entity4, "null cannot be cast to non-null type com.coolapk.market.model.ItemPlaceHolder");
                objectRef2.element = (T) ((ItemPlaceHolder) entity4);
                DataManager instance2 = DataManager.getInstance();
                CollectionItem collectionItemInfo = objectRef2.element.getCollectionItemInfo();
                Intrinsics.checkNotNull(collectionItemInfo);
                Intrinsics.checkNotNullExpressionValue(collectionItemInfo, "placeHolder.collectionItemInfo!!");
                instance2.removeCollectionItem(collectionItemInfo.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AppViewForCollectionItemDialog$CollectionRemoveActionItem$takeAction$2(objectRef2));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/collectionList/AppViewForCollectionItemDialog$CollectionTop;", "Lcom/coolapk/market/view/base/ActionItem;", "mAdd", "", "mApp", "Lcom/coolapk/market/model/ServiceApp;", "(Lcom/coolapk/market/view/collectionList/AppViewForCollectionItemDialog;ZLcom/coolapk/market/model/ServiceApp;)V", "getMApp$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/ServiceApp;", "setMApp$presentation_coolapkAppRelease", "(Lcom/coolapk/market/model/ServiceApp;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewForCollectionItemDialog.kt */
    public final class CollectionTop extends ActionItem {
        private boolean mAdd;
        private ServiceApp mApp;
        final /* synthetic */ AppViewForCollectionItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CollectionTop(AppViewForCollectionItemDialog appViewForCollectionItemDialog, boolean z, ServiceApp serviceApp) {
            super(z ? "取消置顶" : "置顶", null, 2, null);
            Intrinsics.checkNotNullParameter(serviceApp, "mApp");
            this.this$0 = appViewForCollectionItemDialog;
            this.mAdd = z;
            this.mApp = serviceApp;
        }

        public final ServiceApp getMApp$presentation_coolapkAppRelease() {
            return this.mApp;
        }

        public final void setMApp$presentation_coolapkAppRelease(ServiceApp serviceApp) {
            Intrinsics.checkNotNullParameter(serviceApp, "<set-?>");
            this.mApp = serviceApp;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.mAdd)).flatMap(new AppViewForCollectionItemDialog$CollectionTop$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AppViewForCollectionItemDialog$CollectionTop$takeAction$2(this));
        }
    }
}
