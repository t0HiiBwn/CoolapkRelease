package com.coolapk.market.view.feed;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.base.MultiActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.collectionList.CollectionDetailActivity;
import com.coolapk.market.view.dyhv8.DyhDetailActivity;
import com.coolapk.market.view.feed.FeedItemDialog;
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
/* compiled from: FeedItemDialog.kt */
final class FeedItemDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ DyhModel $dyhModel;
    final /* synthetic */ Feed $feed;
    final /* synthetic */ LoginSession $session;
    final /* synthetic */ FeedItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedItemDialog$onActivityCreated$1(FeedItemDialog feedItemDialog, LoginSession loginSession, Feed feed, DyhModel dyhModel) {
        super(1);
        this.this$0 = feedItemDialog;
        this.$session = loginSession;
        this.$feed = feed;
        this.$dyhModel = dyhModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0198, code lost:
        if (r2.isAdmin() != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ed, code lost:
        if (r2.isAdmin() != false) goto L_0x01ef;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0363 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02e1  */
    public final void invoke(List<ActionItem> list) {
        boolean z;
        boolean z2;
        boolean z3;
        LoginSession loginSession;
        LoginSession loginSession2;
        LoginSession loginSession3;
        boolean z4;
        boolean z5;
        DyhModel dyhModel;
        boolean z6;
        LoginSession loginSession4;
        Collection collectionInfo;
        boolean z7;
        DyhModel dyhModel2;
        boolean z8;
        boolean z9;
        Intrinsics.checkNotNullParameter(list, "it");
        LoginSession loginSession5 = this.$session;
        Intrinsics.checkNotNullExpressionValue(loginSession5, "session");
        if (loginSession5.isLogin() && FeedUtils.isGoodsType(this.$feed.getFeedType())) {
            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.AddGoodsListActionItem(this.this$0, this.$feed));
        }
        LoginSession loginSession6 = this.$session;
        Intrinsics.checkNotNullExpressionValue(loginSession6, "session");
        if (loginSession6.isLogin()) {
            String uid = this.$feed.getUid();
            LoginSession loginSession7 = this.$session;
            Intrinsics.checkNotNullExpressionValue(loginSession7, "session");
            if (Intrinsics.areEqual(uid, loginSession7.getUid())) {
                z = true;
                if (z) {
                    int status = this.$feed.getStatus();
                    if (status == -22 || status == -20) {
                        z2 = true;
                        z3 = !z && this.$feed.getStatus() == -21;
                        boolean z10 = !z2 || z3;
                        if (z2) {
                            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.CensorActionItem(this.$feed));
                        }
                        if (z3) {
                            MultiItemDialogFragmentKt.addItem(list, new ActionItem("催审中", AnonymousClass1.INSTANCE));
                        }
                        LoginSession loginSession8 = this.$session;
                        Intrinsics.checkNotNullExpressionValue(loginSession8, "session");
                        if (loginSession8.isLogin() && !z10) {
                            if (this.$feed.getUserAction() != null) {
                                UserAction userAction = this.$feed.getUserAction();
                                Intrinsics.checkNotNull(userAction);
                                Intrinsics.checkNotNullExpressionValue(userAction, "feed.userAction!!");
                                if (userAction.getCollect() > 0) {
                                    z9 = true;
                                    MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.FavoriteActionItem(this.this$0, z9, this.$feed));
                                }
                            }
                            z9 = false;
                            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.FavoriteActionItem(this.this$0, z9, this.$feed));
                        }
                        MultiItemDialogFragmentKt.addItem(list, this.this$0.buildMultiActionItem(this.$feed));
                        loginSession = this.$session;
                        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                        if (loginSession.isAdmin()) {
                            String string = this.this$0.getString(2131886730);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_report)");
                            MultiItemDialogFragmentKt.addItem(list, new MultiActionItem(string, new FeedItemDialog$onActivityCreated$1$item$1(this)));
                        } else if (!z10) {
                            String string2 = this.this$0.getString(2131886730);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_dialog_report)");
                            MultiItemDialogFragmentKt.addItem(list, string2, new Function0<Unit>(this) {
                                /* class com.coolapk.market.view.feed.FeedItemDialog$onActivityCreated$1.AnonymousClass2 */
                                final /* synthetic */ FeedItemDialog$onActivityCreated$1 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final void invoke() {
                                    String id = this.this$0.$feed.getId();
                                    Intrinsics.checkNotNull(id);
                                    Intrinsics.checkNotNullExpressionValue(id, "feed.id!!");
                                    ActionManager.startWebViewActivity(this.this$0.this$0.getActivity(), UriUtils.buildFeedReportUrl(id));
                                }
                            });
                        }
                        loginSession2 = this.$session;
                        Intrinsics.checkNotNullExpressionValue(loginSession2, "session");
                        if (loginSession2.isLogin()) {
                            LoginSession loginSession9 = this.$session;
                            Intrinsics.checkNotNullExpressionValue(loginSession9, "session");
                            if (loginSession9.isAdmin()) {
                                MultiItemDialogFragmentKt.addItem(list, this.this$0.buildAdminActionItem(this.$feed));
                            }
                        }
                        loginSession3 = this.$session;
                        Intrinsics.checkNotNullExpressionValue(loginSession3, "session");
                        if (loginSession3.isLogin()) {
                            if (EntityExtendsKt.isShowCancelReportSpam(this.$feed)) {
                                LoginSession loginSession10 = this.$session;
                                Intrinsics.checkNotNullExpressionValue(loginSession10, "session");
                                if (loginSession10.isAdmin()) {
                                    MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.CancelReportSpamActionItem(this.this$0, this.$feed));
                                }
                            }
                            String uid2 = this.$feed.getUid();
                            LoginSession loginSession11 = this.$session;
                            Intrinsics.checkNotNullExpressionValue(loginSession11, "session");
                            if (!Intrinsics.areEqual(uid2, loginSession11.getUid())) {
                                LoginSession loginSession12 = this.$session;
                                Intrinsics.checkNotNullExpressionValue(loginSession12, "session");
                            }
                            if (this.$feed.getEnableModify() == 1) {
                                FragmentActivity requireActivity = this.this$0.requireActivity();
                                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                                MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.SecondEditActionItem(requireActivity, this.$feed));
                            }
                            if (this.$feed.getIsModified() == 1) {
                                MultiItemDialogFragmentKt.addItem(list, "编辑历史", new Function0<Unit>(this) {
                                    /* class com.coolapk.market.view.feed.FeedItemDialog$onActivityCreated$1.AnonymousClass3 */
                                    final /* synthetic */ FeedItemDialog$onActivityCreated$1 this$0;

                                    {
                                        this.this$0 = r1;
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final void invoke() {
                                        ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
                                        FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                                        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                                        FragmentActivity fragmentActivity = requireActivity;
                                        String id = this.this$0.$feed.getId();
                                        if (id == null) {
                                            id = "";
                                        }
                                        actionManagerCompat.startFeedHistoryListActivity(fragmentActivity, id);
                                    }
                                });
                            }
                            String uid3 = this.$feed.getUid();
                            LoginSession loginSession13 = this.$session;
                            Intrinsics.checkNotNullExpressionValue(loginSession13, "session");
                            if (!Intrinsics.areEqual(uid3, loginSession13.getUid())) {
                                LoginSession loginSession14 = this.$session;
                                Intrinsics.checkNotNullExpressionValue(loginSession14, "session");
                            }
                            FeedItemDialog feedItemDialog = this.this$0;
                            String string3 = feedItemDialog.getString(2131886716);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.str_dialog_delete)");
                            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.DeleteActionItem(feedItemDialog, string3, this.$feed));
                            LoginSession loginSession15 = this.$session;
                            Intrinsics.checkNotNullExpressionValue(loginSession15, "session");
                            if (loginSession15.isAdmin() && !TextUtils.isEmpty(this.$feed.getSpamReason())) {
                                MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.RefuseActionItem(this.this$0, this.$feed));
                                String spamContent = this.$feed.getSpamContent();
                                if (spamContent == null) {
                                    spamContent = "";
                                }
                                MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制违规内容", spamContent));
                            }
                            Activity currentActivity = AppHolder.getCurrentActivity();
                            Intrinsics.checkNotNull(currentActivity);
                            Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity()!!");
                            String localClassName = currentActivity.getLocalClassName();
                            Intrinsics.checkNotNullExpressionValue(localClassName, "AppHolder.getCurrentActivity()!!.localClassName");
                            Objects.requireNonNull(localClassName, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase = localClassName.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            boolean contains$default = StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "dyhdetail", false, 2, (Object) null);
                            DyhModel dyhModel3 = this.$dyhModel;
                            if (dyhModel3 != null) {
                                List<String> editors = dyhModel3.getEditors();
                                DataManager instance = DataManager.getInstance();
                                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                                LoginSession loginSession16 = instance.getLoginSession();
                                Intrinsics.checkNotNullExpressionValue(loginSession16, "DataManager.getInstance().loginSession");
                                if (editors.contains(loginSession16.getUid())) {
                                    z5 = true;
                                    dyhModel = this.$dyhModel;
                                    if (dyhModel != null) {
                                        DataManager instance2 = DataManager.getInstance();
                                        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                                        LoginSession loginSession17 = instance2.getLoginSession();
                                        Intrinsics.checkNotNullExpressionValue(loginSession17, "DataManager.getInstance().loginSession");
                                        if (TextUtils.equals(dyhModel.getUid(), loginSession17.getUid())) {
                                            z6 = true;
                                            DataManager instance3 = DataManager.getInstance();
                                            Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                                            LoginSession loginSession18 = instance3.getLoginSession();
                                            Intrinsics.checkNotNullExpressionValue(loginSession18, "DataManager.getInstance().loginSession");
                                            boolean isAdmin = loginSession18.isAdmin();
                                            loginSession4 = this.$session;
                                            Intrinsics.checkNotNullExpressionValue(loginSession4, "session");
                                            if (loginSession4.isAdmin() || !TextUtils.isEmpty(this.$feed.getSpamReason()) || contains$default) {
                                                z4 = z10;
                                            } else {
                                                z4 = z10;
                                                MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.RecommendActionItem(this.this$0, this.$feed.getRecommend() > 0, this.$feed));
                                            }
                                            if (!contains$default && z5) {
                                                Activity currentActivity2 = AppHolder.getCurrentActivity();
                                                if (currentActivity2 instanceof DyhDetailActivity) {
                                                    DyhDetailActivity dyhDetailActivity = (DyhDetailActivity) currentActivity2;
                                                    Integer page = dyhDetailActivity.getPage();
                                                    if (page != null) {
                                                        if (page.intValue() == 1) {
                                                            z8 = true;
                                                            Integer page2 = dyhDetailActivity.getPage();
                                                            if (page2 != null && page2.intValue() == 0 && z6) {
                                                                MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.DyhArticleTop(this.$feed.isTop(), this.$feed));
                                                            }
                                                        }
                                                    }
                                                    z8 = false;
                                                    Integer page2 = dyhDetailActivity.getPage();
                                                    MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.DyhArticleTop(this.$feed.isTop(), this.$feed));
                                                } else {
                                                    z8 = false;
                                                }
                                                MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.DyhChoiceActionItem(z8, this.$feed));
                                            }
                                            boolean z11 = !z5 || isAdmin;
                                            if (contains$default && z11 && (dyhModel2 = this.$dyhModel) != null) {
                                                MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.DyhArticleRemoveActionItem(this.$feed, dyhModel2));
                                            }
                                            collectionInfo = this.$feed.getCollectionInfo();
                                            Activity currentActivity3 = AppHolder.getCurrentActivity();
                                            Intrinsics.checkNotNull(currentActivity3);
                                            Intrinsics.checkNotNullExpressionValue(currentActivity3, "AppHolder.getCurrentActivity()!!");
                                            String localClassName2 = currentActivity3.getLocalClassName();
                                            Intrinsics.checkNotNullExpressionValue(localClassName2, "AppHolder.getCurrentActivity()!!.localClassName");
                                            Objects.requireNonNull(localClassName2, "null cannot be cast to non-null type java.lang.String");
                                            String lowerCase2 = localClassName2.toLowerCase();
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                                            boolean contains$default2 = StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "collectiondetail", false, 2, (Object) null);
                                            if (collectionInfo != null) {
                                                DataManager instance4 = DataManager.getInstance();
                                                Intrinsics.checkNotNullExpressionValue(instance4, "DataManager.getInstance()");
                                                LoginSession loginSession19 = instance4.getLoginSession();
                                                Intrinsics.checkNotNullExpressionValue(loginSession19, "DataManager.getInstance().loginSession");
                                                if (TextUtils.equals(loginSession19.getUid(), collectionInfo.getUid())) {
                                                    z7 = true;
                                                    if (contains$default2 && z7) {
                                                        if (AppHolder.getCurrentActivity() instanceof CollectionDetailActivity) {
                                                            FeedItemDialog feedItemDialog2 = this.this$0;
                                                            CollectionItem collectionItem = this.$feed.getCollectionItem();
                                                            Intrinsics.checkNotNull(collectionItem);
                                                            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.CollectionTop(feedItemDialog2, collectionItem.isTop(), this.$feed));
                                                        }
                                                        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.CollectionRemoveActionItem(this.this$0, this.$feed));
                                                    }
                                                }
                                            }
                                            z7 = false;
                                            if (AppHolder.getCurrentActivity() instanceof CollectionDetailActivity) {
                                            }
                                            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.CollectionRemoveActionItem(this.this$0, this.$feed));
                                        }
                                    }
                                    z6 = false;
                                    DataManager instance3 = DataManager.getInstance();
                                    Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                                    LoginSession loginSession18 = instance3.getLoginSession();
                                    Intrinsics.checkNotNullExpressionValue(loginSession18, "DataManager.getInstance().loginSession");
                                    boolean isAdmin = loginSession18.isAdmin();
                                    loginSession4 = this.$session;
                                    Intrinsics.checkNotNullExpressionValue(loginSession4, "session");
                                    if (loginSession4.isAdmin()) {
                                    }
                                    z4 = z10;
                                    if (!contains$default) {
                                    }
                                    if (!z5) {
                                    }
                                    MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.DyhArticleRemoveActionItem(this.$feed, dyhModel2));
                                    collectionInfo = this.$feed.getCollectionInfo();
                                    Activity currentActivity3 = AppHolder.getCurrentActivity();
                                    Intrinsics.checkNotNull(currentActivity3);
                                    Intrinsics.checkNotNullExpressionValue(currentActivity3, "AppHolder.getCurrentActivity()!!");
                                    String localClassName2 = currentActivity3.getLocalClassName();
                                    Intrinsics.checkNotNullExpressionValue(localClassName2, "AppHolder.getCurrentActivity()!!.localClassName");
                                    Objects.requireNonNull(localClassName2, "null cannot be cast to non-null type java.lang.String");
                                    String lowerCase2 = localClassName2.toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                                    boolean contains$default2 = StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "collectiondetail", false, 2, (Object) null);
                                    if (collectionInfo != null) {
                                    }
                                    z7 = false;
                                    if (AppHolder.getCurrentActivity() instanceof CollectionDetailActivity) {
                                    }
                                    MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.CollectionRemoveActionItem(this.this$0, this.$feed));
                                }
                            }
                            z5 = false;
                            dyhModel = this.$dyhModel;
                            if (dyhModel != null) {
                            }
                            z6 = false;
                            DataManager instance3 = DataManager.getInstance();
                            Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                            LoginSession loginSession18 = instance3.getLoginSession();
                            Intrinsics.checkNotNullExpressionValue(loginSession18, "DataManager.getInstance().loginSession");
                            boolean isAdmin = loginSession18.isAdmin();
                            loginSession4 = this.$session;
                            Intrinsics.checkNotNullExpressionValue(loginSession4, "session");
                            if (loginSession4.isAdmin()) {
                            }
                            z4 = z10;
                            if (!contains$default) {
                            }
                            if (!z5) {
                            }
                            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.DyhArticleRemoveActionItem(this.$feed, dyhModel2));
                            collectionInfo = this.$feed.getCollectionInfo();
                            Activity currentActivity3 = AppHolder.getCurrentActivity();
                            Intrinsics.checkNotNull(currentActivity3);
                            Intrinsics.checkNotNullExpressionValue(currentActivity3, "AppHolder.getCurrentActivity()!!");
                            String localClassName2 = currentActivity3.getLocalClassName();
                            Intrinsics.checkNotNullExpressionValue(localClassName2, "AppHolder.getCurrentActivity()!!.localClassName");
                            Objects.requireNonNull(localClassName2, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase2 = localClassName2.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                            boolean contains$default2 = StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "collectiondetail", false, 2, (Object) null);
                            if (collectionInfo != null) {
                            }
                            z7 = false;
                            if (AppHolder.getCurrentActivity() instanceof CollectionDetailActivity) {
                            }
                            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.CollectionRemoveActionItem(this.this$0, this.$feed));
                        } else {
                            z4 = z10;
                        }
                        if (!z4) {
                            DialogBuilderHelper.Companion companion = DialogBuilderHelper.Companion;
                            String name = Feed.class.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
                            DialogBuilderHelper<?> ofClassName = companion.ofClassName(name);
                            Objects.requireNonNull(ofClassName, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.DialogBuilderHelper<T>");
                            ofClassName.handleDataList(list, this.$feed, this.this$0.getActivity());
                            return;
                        }
                        return;
                    }
                }
                z2 = false;
                if (!z) {
                }
                if (!z2) {
                }
                if (z2) {
                }
                if (z3) {
                }
                LoginSession loginSession8 = this.$session;
                Intrinsics.checkNotNullExpressionValue(loginSession8, "session");
                if (this.$feed.getUserAction() != null) {
                }
                z9 = false;
                MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.FavoriteActionItem(this.this$0, z9, this.$feed));
                MultiItemDialogFragmentKt.addItem(list, this.this$0.buildMultiActionItem(this.$feed));
                loginSession = this.$session;
                Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                if (loginSession.isAdmin()) {
                }
                loginSession2 = this.$session;
                Intrinsics.checkNotNullExpressionValue(loginSession2, "session");
                if (loginSession2.isLogin()) {
                }
                loginSession3 = this.$session;
                Intrinsics.checkNotNullExpressionValue(loginSession3, "session");
                if (loginSession3.isLogin()) {
                }
                if (!z4) {
                }
            }
        }
        z = false;
        if (z) {
        }
        z2 = false;
        if (!z) {
        }
        if (!z2) {
        }
        if (z2) {
        }
        if (z3) {
        }
        LoginSession loginSession8 = this.$session;
        Intrinsics.checkNotNullExpressionValue(loginSession8, "session");
        if (this.$feed.getUserAction() != null) {
        }
        z9 = false;
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.FavoriteActionItem(this.this$0, z9, this.$feed));
        MultiItemDialogFragmentKt.addItem(list, this.this$0.buildMultiActionItem(this.$feed));
        loginSession = this.$session;
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isAdmin()) {
        }
        loginSession2 = this.$session;
        Intrinsics.checkNotNullExpressionValue(loginSession2, "session");
        if (loginSession2.isLogin()) {
        }
        loginSession3 = this.$session;
        Intrinsics.checkNotNullExpressionValue(loginSession3, "session");
        if (loginSession3.isLogin()) {
        }
        if (!z4) {
        }
    }
}
