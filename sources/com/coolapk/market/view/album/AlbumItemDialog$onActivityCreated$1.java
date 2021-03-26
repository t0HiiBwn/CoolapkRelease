package com.coolapk.market.view.album;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.album.AlbumItemDialog;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.collectionList.CollectionDetailActivity;
import com.coolapk.market.view.feed.vote.DialogBuilderHelper;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumItemDialog.kt */
final class AlbumItemDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ AlbumItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumItemDialog$onActivityCreated$1(AlbumItemDialog albumItemDialog) {
        super(1);
        this.this$0 = albumItemDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0137, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.getUid(), r1.getUid()) != false) goto L_0x013b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    public final void invoke(List<ActionItem> list) {
        boolean z;
        int i;
        AlbumItemDialog albumItemDialog;
        Intrinsics.checkNotNullParameter(list, "it");
        final Album album = (Album) this.this$0.requireArguments().getParcelable("album");
        if (album != null) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            boolean z2 = true;
            if (loginSession.isLogin()) {
                if (album.getUserAction() != null) {
                    UserAction userAction = album.getUserAction();
                    Intrinsics.checkNotNull(userAction);
                    Intrinsics.checkNotNullExpressionValue(userAction, "album.userAction!!");
                    if (userAction.getFavorite() > 0) {
                        z = true;
                        if (!z) {
                            albumItemDialog = this.this$0;
                            i = 2131886153;
                        } else {
                            albumItemDialog = this.this$0;
                            i = 2131886132;
                        }
                        String string = albumItemDialog.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "if (isFavored) getString…ing.action_favorite_feed)");
                        MultiItemDialogFragmentKt.addItem(list, string, new Function0<Unit>(this) {
                            /* class com.coolapk.market.view.album.AlbumItemDialog$onActivityCreated$1.AnonymousClass1 */
                            final /* synthetic */ AlbumItemDialog$onActivityCreated$1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final void invoke() {
                                ActionManager.startCollectionSelectActivity(this.this$0.this$0.getActivity(), album.getId(), album.getEntityType());
                            }
                        });
                    }
                }
                z = false;
                if (!z) {
                }
                String string = albumItemDialog.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "if (isFavored) getString…ing.action_favorite_feed)");
                MultiItemDialogFragmentKt.addItem(list, string, new Function0<Unit>(this) {
                    /* class com.coolapk.market.view.album.AlbumItemDialog$onActivityCreated$1.AnonymousClass1 */
                    final /* synthetic */ AlbumItemDialog$onActivityCreated$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final void invoke() {
                        ActionManager.startCollectionSelectActivity(this.this$0.this$0.getActivity(), album.getId(), album.getEntityType());
                    }
                });
            }
            list.add(AlbumItemDialog.access$buildMultiActionItem(this.this$0, album));
            String string2 = this.this$0.getString(2131886792);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_dialog_report)");
            MultiItemDialogFragmentKt.addItem(list, string2, new Function0<Unit>(this) {
                /* class com.coolapk.market.view.album.AlbumItemDialog$onActivityCreated$1.AnonymousClass2 */
                final /* synthetic */ AlbumItemDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    FragmentActivity activity = this.this$0.this$0.getActivity();
                    String id = album.getId();
                    if (id == null) {
                        id = "";
                    }
                    ActionManager.startWebViewActivity(activity, UriUtils.buildFeedReportUrl(id));
                }
            });
            if (loginSession.isLogin() && loginSession.isAdmin()) {
                list.add(AlbumItemDialog.access$buildAdminActionItem(this.this$0, album));
            }
            if (loginSession.isLogin() && (Intrinsics.areEqual(album.getUid(), loginSession.getUid()) || loginSession.isAdmin())) {
                AlbumItemDialog albumItemDialog2 = this.this$0;
                list.add(new AlbumItemDialog.DeleteActionItem(albumItemDialog2, albumItemDialog2.getString(2131886778), album));
            }
            if (loginSession.isLogin() && loginSession.isAdmin()) {
                list.add(new AlbumItemDialog.RecommendActionItem(this.this$0, album.getRecommend() > 0, album));
            }
            Activity currentActivity = AppHolder.getCurrentActivity();
            Intrinsics.checkNotNull(currentActivity);
            Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity()!!");
            String localClassName = currentActivity.getLocalClassName();
            Intrinsics.checkNotNullExpressionValue(localClassName, "AppHolder.getCurrentActivity()!!.localClassName");
            Objects.requireNonNull(localClassName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = localClassName.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            boolean contains$default = StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "collectiondetail", false, 2, (Object) null);
            if (album.getCollectionItem() != null) {
                CollectionItem collectionItem = album.getCollectionItem();
                Intrinsics.checkNotNull(collectionItem);
                Intrinsics.checkNotNullExpressionValue(collectionItem, "album.collectionItem!!");
            }
            z2 = false;
            if (contains$default && z2 && (AppHolder.getCurrentActivity() instanceof CollectionDetailActivity)) {
                AlbumItemDialog albumItemDialog3 = this.this$0;
                CollectionItem collectionItem2 = album.getCollectionItem();
                Intrinsics.checkNotNull(collectionItem2);
                list.add(new AlbumItemDialog.CollectionTop(albumItemDialog3, collectionItem2.isTop(), album));
                list.add(new AlbumItemDialog.CollectionRemoveActionItem(this.this$0, "从收藏单移除", album));
            }
            DialogBuilderHelper.Companion companion = DialogBuilderHelper.Companion;
            String name = Album.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
            DialogBuilderHelper<?> ofClassName = companion.ofClassName(name);
            Objects.requireNonNull(ofClassName, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.DialogBuilderHelper<T>");
            ofClassName.handleDataList(list, album, this.this$0.getActivity());
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
