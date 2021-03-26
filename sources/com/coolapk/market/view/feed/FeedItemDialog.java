package com.coolapk.market.view.feed;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.style.URLSpan;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.FeedRemoveHeadlineEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog;
import com.coolapk.market.widget.MinimumWidthDialog;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;

/* compiled from: FeedItemDialog.kt */
public class FeedItemDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy feed$delegate = LazyKt.lazy(new FeedItemDialog$feed$2(this));
    private FeedActionPresenter presenter = FeedActionPresenter.getInstance();

    public static final FeedItemDialog newInstance(Feed feed, DyhModel dyhModel) {
        return Companion.newInstance(feed, dyhModel);
    }

    public static final FeedItemDialog newInstance(Feed feed, URLSpan[] uRLSpanArr) {
        return Companion.newInstance(feed, uRLSpanArr);
    }

    public final Feed getFeed() {
        return (Feed) this.feed$delegate.getValue();
    }

    public final FeedActionPresenter getPresenter$presentation_coolapkAppRelease() {
        return this.presenter;
    }

    public final void setPresenter$presentation_coolapkAppRelease(FeedActionPresenter feedActionPresenter) {
        this.presenter = feedActionPresenter;
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedItemDialog newInstance(Feed feed, URLSpan[] uRLSpanArr) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            FeedItemDialog feedItemDialog = new FeedItemDialog();
            feedItemDialog.setArguments(createArgument(feed, uRLSpanArr));
            return feedItemDialog;
        }

        public final Bundle createArgument(Feed feed, URLSpan[] uRLSpanArr) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (uRLSpanArr != null) {
                if (!(uRLSpanArr.length == 0)) {
                    arrayList.addAll(Arrays.asList((URLSpan[]) Arrays.copyOf(uRLSpanArr, uRLSpanArr.length)));
                }
            }
            bundle.putParcelableArrayList("urlspan", arrayList);
            bundle.putParcelable("feed", feed);
            return bundle;
        }

        public final FeedItemDialog newInstance(Feed feed, DyhModel dyhModel) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(dyhModel, "dyhModel");
            Bundle bundle = new Bundle();
            bundle.putParcelable("feed", feed);
            bundle.putParcelable("dyhModel", dyhModel);
            FeedItemDialog feedItemDialog = new FeedItemDialog();
            feedItemDialog.setArguments(bundle);
            return feedItemDialog;
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Feed feed = getFeed();
        if (feed != null) {
            Intrinsics.checkNotNullExpressionValue(feed, "feed ?: return");
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            updateDataList(new FeedItemDialog$onActivityCreated$1(this, instance.getLoginSession(), feed, (DyhModel) requireArguments().getParcelable("dyhModel")));
        }
    }

    public final MultiActionItem buildMultiActionItem(Feed feed) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) requireArguments().getParcelableArrayList("urlspan");
        if (objectRef.element == null) {
            objectRef.element = (T) CollectionsKt.emptyList();
        }
        String string = getString(2131886121);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.action_copy)");
        return new MultiActionItem(string, new FeedItemDialog$buildMultiActionItem$1(this, feed, objectRef));
    }

    public final MultiActionItem buildAdminActionItem(Feed feed) {
        return new MultiActionItem("管理", new FeedItemDialog$buildAdminActionItem$1(this, feed));
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class SecondEditActionItem extends ActionItem {
        private final Activity activity;
        private final Feed feed;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SecondEditActionItem(Activity activity2, Feed feed2) {
            super("编辑", null, 2, null);
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.activity = activity2;
            this.feed = feed2;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Feed getFeed() {
            return this.feed;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().getChangeFeedDetail(this.feed.getId(), "", "", "").map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new FeedItemDialog$SecondEditActionItem$takeAction$1(DialogUtil.INSTANCE.showProgressDialog(this.activity, "正在处理...", false))).subscribe((Subscriber<? super R>) new FeedItemDialog$SecondEditActionItem$takeAction$2(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class CensorActionItem extends ActionItem {
        public static final Companion Companion = new Companion(null);
        private final Feed feed;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CensorActionItem(Feed feed2) {
            super("申请催审", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.feed = feed2;
        }

        public final Feed getFeed() {
            return this.feed;
        }

        /* compiled from: FeedItemDialog.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final boolean shouldShow(Feed feed) {
                Intrinsics.checkNotNullParameter(feed, "feed");
                return feed.getStatus() == -20 || feed.getStatus() == -22;
            }
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().feedCensor(this.feed.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedItemDialog$CensorActionItem$takeAction$1(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class HeadlineActionItem extends ActionItem {
        private boolean add;
        private Feed feed;

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeadlineActionItem(boolean z, Feed feed2) {
            super(z ? "上过头条" : "未上头条", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.add = z;
            this.feed = feed2;
        }

        public final boolean getAdd$presentation_coolapkAppRelease() {
            return this.add;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setAdd$presentation_coolapkAppRelease(boolean z) {
            this.add = z;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class DyhChoiceActionItem extends ActionItem {
        private boolean add;
        private Feed feed;

        public final boolean getAdd$presentation_coolapkAppRelease() {
            return this.add;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setAdd$presentation_coolapkAppRelease(boolean z) {
            this.add = z;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DyhChoiceActionItem(boolean z, Feed feed2) {
            super(z ? "上看看号精选" : "下看看号精选", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.add = z;
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.add)).flatMap(new FeedItemDialog$DyhChoiceActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$DyhChoiceActionItem$takeAction$2(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class DyhArticleRemoveActionItem extends ActionItem {
        private Feed feed;
        private DyhModel mDyhModel;

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DyhArticleRemoveActionItem(Feed feed2, DyhModel dyhModel) {
            super("从看看号中移除", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            Intrinsics.checkNotNullParameter(dyhModel, "mDyhModel");
            this.feed = feed2;
            this.mDyhModel = dyhModel;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().onArticleRemove(this.feed.getId(), 2, this.mDyhModel.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedItemDialog$DyhArticleRemoveActionItem$takeAction$1(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class DyhArticleTop extends ActionItem {
        private boolean add;
        private Feed feed;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DyhArticleTop(boolean z, Feed feed2) {
            super(z ? "取消置顶" : "置顶", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.add = z;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.add)).flatMap(new FeedItemDialog$DyhArticleTop$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$DyhArticleTop$takeAction$2(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class CollectionRemoveActionItem extends ActionItem {
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CollectionRemoveActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("从收藏单中移除", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager instance = DataManager.getInstance();
            CollectionItem collectionItem = this.feed.getCollectionItem();
            Intrinsics.checkNotNull(collectionItem);
            Intrinsics.checkNotNullExpressionValue(collectionItem, "feed.collectionItem!!");
            instance.removeCollectionItem(collectionItem.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedItemDialog$CollectionRemoveActionItem$takeAction$1(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class CollectionTop extends ActionItem {
        private boolean add;
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CollectionTop(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消置顶" : "置顶", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.add = z;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.add)).flatMap(new FeedItemDialog$CollectionTop$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$CollectionTop$takeAction$2(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class HomePageActionItem extends ActionItem {
        private boolean add;
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomePageActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "上头条" : "下头条", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.add = z;
            this.feed = feed2;
        }

        public final boolean getAdd$presentation_coolapkAppRelease() {
            return this.add;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setAdd$presentation_coolapkAppRelease(boolean z) {
            this.add = z;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.add)).flatMap(new FeedItemDialog$HomePageActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$HomePageActionItem$takeAction$2(this));
        }

        public final void onErrorEvent(Throwable th) {
            if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
                Throwable cause = th.getCause();
                Objects.requireNonNull(cause, "null cannot be cast to non-null type com.coolapk.market.network.ClientException");
                ClientException clientException = (ClientException) cause;
                if (clientException.getStatusCode() == -1) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.feed.getId()));
                } else {
                    Toast.error(AppHolder.getApplication(), clientException);
                }
            }
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class HomeSelfActionItem extends ActionItem {
        private boolean add;
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeSelfActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消仅个人主页可见" : "仅个人主页可见", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.add = z;
            this.feed = feed2;
        }

        public final boolean getAdd$presentation_coolapkAppRelease() {
            return this.add;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setAdd$presentation_coolapkAppRelease(boolean z) {
            this.add = z;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.add)).flatMap(new FeedItemDialog$HomeSelfActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$HomeSelfActionItem$takeAction$2(this));
        }

        public final void onErrorEvent(Throwable th) {
            if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
                Throwable cause = th.getCause();
                Objects.requireNonNull(cause, "null cannot be cast to non-null type com.coolapk.market.network.ClientException");
                ClientException clientException = (ClientException) cause;
                if (clientException.getStatusCode() == -1) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.feed.getId()));
                } else {
                    Toast.error(AppHolder.getApplication(), clientException);
                }
            }
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class NoHomePageActionItem extends ActionItem {
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoHomePageActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("禁止该内容上头条", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (this.feed.getType() == 10) {
                ConfirmDialog newInstance = ConfirmDialog.newInstance("确定要禁止该问题上头条？", "禁止该问题上头条后，该问题下的回答都不会再上头条，是否继续？");
                newInstance.setOnOkRunnable(new FeedItemDialog$NoHomePageActionItem$takeAction$1(this));
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                newInstance.show(childFragmentManager, (String) null);
                return;
            }
            action();
        }

        public final void action() {
            this.this$0.getPresenter$presentation_coolapkAppRelease().removeFromHeadlineV8(this.feed, false).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedItemDialog$NoHomePageActionItem$action$1(this));
        }

        public final void onErrorEvent(Throwable th) {
            if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
                Throwable cause = th.getCause();
                Objects.requireNonNull(cause, "null cannot be cast to non-null type com.coolapk.market.network.ClientException");
                ClientException clientException = (ClientException) cause;
                if (clientException.getStatusCode() == -1) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.feed.getId()));
                }
                Toast.error(AppHolder.getApplication(), clientException);
            }
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class HomePagePYActionItem extends ActionItem {
        private boolean add;
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomePagePYActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "上PY头条" : "下PY头条", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.add = z;
            this.feed = feed2;
        }

        public final boolean getAdd$presentation_coolapkAppRelease() {
            return this.add;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setAdd$presentation_coolapkAppRelease(boolean z) {
            this.add = z;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.add)).flatMap(new FeedItemDialog$HomePagePYActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$HomePagePYActionItem$takeAction$2(this));
        }

        public final void onErrorEvent(Throwable th) {
            if ((th instanceof RuntimeException) && (th.getCause() instanceof ClientException)) {
                Throwable cause = th.getCause();
                Objects.requireNonNull(cause, "null cannot be cast to non-null type com.coolapk.market.network.ClientException");
                ClientException clientException = (ClientException) cause;
                if (clientException.getStatusCode() == -1) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.feed.getId()));
                } else {
                    Toast.error(AppHolder.getApplication(), clientException);
                }
            }
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class PrivateActionItem extends ActionItem {
        private final Feed feed;
        private boolean isSet;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrivateActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消仅作者可见" : "仅作者自己可见", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.isSet = z;
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_PRIVATE", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feed, 0, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定取消仅作者可见？" : "确定要设为仅作者可见?", z ? "取消后，将恢复成正常动态" : "内容只显示在作者主页，通过作者主页可以访问");
            newInstance.setAction(this.feed, 0, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_PRIVATE", true).apply();
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class StatusActionItem extends ActionItem {
        private final Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StatusActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("查看状态", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            InfoDialogFragment newInstance = InfoDialogFragment.Companion.newInstance(this.feed);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class RefuseActionItem extends ActionItem {
        private final Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RefuseActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("驳回", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().refuseSpamFeed(this.feed.getId(), this.feed.getSpamTime()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedItemDialog$RefuseActionItem$takeAction$1(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class CancelReportSpamActionItem extends ActionItem {
        private final Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CancelReportSpamActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("取消举报屏蔽", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().cancelReportSpam(this.feed.getId(), this.feed.getEntityType()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedItemDialog$CancelReportSpamActionItem$takeAction$1(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class FoldedActionItem extends ActionItem {
        private final Feed feed;
        private boolean isSet;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FoldedActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消折叠" : "折叠/不在公共区域显示", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.isSet = z;
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_FLODED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feed, 1, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消折叠此动态？" : "确定要折叠此动态？", z ? "取消折叠后将恢复成正常的动态" : "折叠后不在公共区域显示，但还会显示在粉丝的好友圈");
            newInstance.setAction(this.feed, 1, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_FLODED", true).apply();
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class SoftFoldedActionItem extends ActionItem {
        private final Feed feed;
        private boolean isSet;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SoftFoldedActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("去精/不在精选区显示", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        public final boolean isSet$presentation_coolapkAppRelease() {
            return this.isSet;
        }

        public final void setSet$presentation_coolapkAppRelease(boolean z) {
            this.isSet = z;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_SOFT_FLODED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feed, 4, false, this.this$0.getActivity());
                return;
            }
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance("确定要去精此动态？", "去精后不在精选区显示，但还会显示在粉丝的好友圈");
            newInstance.setAction(this.feed, 4, false, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_SOFT_FLODED", true).apply();
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class BannedActionItem extends ActionItem {
        public static final Companion Companion = new Companion(null);
        private final Feed feed;
        private final Fragment fragment;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BannedActionItem(Fragment fragment2, Feed feed2) {
            super(Companion.createText(feed2), null, 2, null);
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.fragment = fragment2;
            this.feed = feed2;
        }

        /* compiled from: FeedItemDialog.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final String createText(Feed feed) {
                Intrinsics.checkNotNullParameter(feed, "feed");
                return feed.getStatus() != -3 ? "手动屏蔽/审核不通过" : "取消屏蔽";
            }
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            boolean z = this.feed.getStatus() == -3;
            FragmentActivity requireActivity = this.fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            FragmentManager childFragmentManager = this.fragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_BANNED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feed, 2, z, requireActivity);
                return;
            }
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消屏蔽此动态？" : "确定要屏蔽此动态？", z ? "取消屏蔽后，将恢复成正常动态" : "屏蔽后禁止访问，等同于删除，但不会真正删除数据");
            newInstance.setAction(this.feed, 2, z, requireActivity);
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_BANNED", true).apply();
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class UnbannedFromMachineActionItem extends ActionItem {
        public static final Companion Companion = new Companion(null);
        private final Feed feed;
        private final Fragment fragment;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnbannedFromMachineActionItem(Fragment fragment2, Feed feed2) {
            super("解除机器屏蔽", null, 2, null);
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.fragment = fragment2;
            this.feed = feed2;
        }

        /* compiled from: FeedItemDialog.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final boolean shouldShow(Feed feed) {
                Intrinsics.checkNotNullParameter(feed, "feed");
                return feed.getStatus() == -20 || feed.getStatus() == -21 || feed.getStatus() == -22;
            }
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            FragmentActivity requireActivity = this.fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            ConfirmFeedBlockDialog.executeAction(this.feed, 2, true, requireActivity);
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class EditorChoiceActionItem extends ActionItem {
        private Feed feed;
        private boolean isRecommended;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EditorChoiceActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消编辑精选" : "上编辑精选", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.isRecommended = z;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final boolean isRecommended$presentation_coolapkAppRelease() {
            return this.isRecommended;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        public final void setRecommended$presentation_coolapkAppRelease(boolean z) {
            this.isRecommended = z;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.isRecommended)).flatMap(new FeedItemDialog$EditorChoiceActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$EditorChoiceActionItem$takeAction$2(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class EditorChoicePYActionItem extends ActionItem {
        private Feed feed;
        private boolean isRecommended;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EditorChoicePYActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消PY编辑精选" : "上PY编辑精选", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.isRecommended = z;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final boolean isRecommended$presentation_coolapkAppRelease() {
            return this.isRecommended;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        public final void setRecommended$presentation_coolapkAppRelease(boolean z) {
            this.isRecommended = z;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.isRecommended)).flatMap(new FeedItemDialog$EditorChoicePYActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$EditorChoicePYActionItem$takeAction$2(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class DeleteActionItem extends ActionItem {
        private final Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteActionItem(FeedItemDialog feedItemDialog, String str, Feed feed2) {
            super(str, null, 2, null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            String string = this.this$0.getString(2131886722);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_delete_title)");
            ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(string, "删除 " + this.feed.getUserName() + " 的" + this.feed.getFeedTypeName() + "： " + this.feed.getMessage());
            newInstance.setDeleteTarget(this.feed);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class RecommendActionItem extends ActionItem {
        private boolean add;
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RecommendActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消推荐" : "上推荐", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.add = z;
            this.feed = feed2;
        }

        public final boolean getAdd$presentation_coolapkAppRelease() {
            return this.add;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setAdd$presentation_coolapkAppRelease(boolean z) {
            this.add = z;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.add)).flatMap(new FeedItemDialog$RecommendActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedItemDialog$RecommendActionItem$takeAction$2(this));
        }
    }

    /* compiled from: FeedItemDialog.kt */
    private final class GoodsListEditActionItem extends ActionItem {
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GoodsListEditActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("编辑", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            ActionManager.startFunThingsListEditActivity(this.this$0.getActivity(), this.feed);
        }
    }

    /* compiled from: FeedItemDialog.kt */
    private final class AddGoodsListActionItem extends ActionItem {
        private Feed feed;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddGoodsListActionItem(FeedItemDialog feedItemDialog, Feed feed2) {
            super("加入好物单", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            ActionManager.startGoodsListSelectActivity(this.this$0.getActivity(), this.feed.getExtraKey(), "");
        }
    }

    /* compiled from: FeedItemDialog.kt */
    private final class FavoriteActionItem extends ActionItem {
        private Feed feed;
        private boolean isFavorited;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        public FavoriteActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(r3, null, 2, null);
            String str;
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            if (z) {
                str = feedItemDialog.getString(2131886153);
            } else {
                str = feedItemDialog.getString(2131886132);
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (isFavorited) getStri…ing.action_favorite_feed)");
            this.isFavorited = z;
            this.feed = feed2;
        }

        public final Feed getFeed$presentation_coolapkAppRelease() {
            return this.feed;
        }

        public final boolean isFavorited$presentation_coolapkAppRelease() {
            return this.isFavorited;
        }

        public final void setFavorited$presentation_coolapkAppRelease(boolean z) {
            this.isFavorited = z;
        }

        public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
            Intrinsics.checkNotNullParameter(feed2, "<set-?>");
            this.feed = feed2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            ActionManager.startCollectionSelectActivity(this.this$0.getActivity(), this.feed.getId(), this.feed.getEntityType());
        }
    }

    /* compiled from: FeedItemDialog.kt */
    public final class FeedUnLinkActionItem extends ActionItem {
        private final Feed feed;
        private boolean isSet;
        final /* synthetic */ FeedItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedUnLinkActionItem(FeedItemDialog feedItemDialog, boolean z, Feed feed2) {
            super(z ? "取消" : "解除/取消与该节点关联", null, 2, null);
            Intrinsics.checkNotNullParameter(feed2, "feed");
            this.this$0 = feedItemDialog;
            this.isSet = z;
            this.feed = feed2;
        }

        public final boolean isSet$presentation_coolapkAppRelease() {
            return this.isSet;
        }

        public final void setSet$presentation_coolapkAppRelease(boolean z) {
            this.isSet = z;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_UNLINK", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feed, 3, this.isSet, this.this$0.getActivity());
                return;
            }
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance("确定要取消与节点的关联？", "解除节点关联后，将不会出现在该节点评论列表里");
            newInstance.setAction(this.feed, 3, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_UNLINK", true).apply();
        }
    }

    private final void postChangeGoodsRecommendStatus(String str, int i) {
        DataManager.getInstance().changedFeedGoodsRecommendStatus(str, i).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedItemDialog$postChangeGoodsRecommendStatus$1(this, i, str));
    }

    /* compiled from: FeedItemDialog.kt */
    public static final class InfoDialogFragment extends MinimumWidthDialog {
        public static final Companion Companion = new Companion(null);
        private int blockStatus;
        private String blockStatusText;
        private Entity entity;
        private String isHeadline;
        private String isHeadlineV8;
        private int messageStatus;
        private String messageStatusText;
        private String modelInfo;
        private int recommend;
        private int status;
        private String statusText;
        private String uid;
        private String url;
        private String userAgent;

        public static final InfoDialogFragment newInstance(Entity entity2) {
            return Companion.newInstance(entity2);
        }

        public static final InfoDialogFragment newInstance(String str, String str2, String str3, String str4) {
            return Companion.newInstance(str, str2, str3, str4);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            Entity entity2 = (Entity) requireArguments().getParcelable("entity");
            this.entity = entity2;
            String str = "";
            if (entity2 != null) {
                Intrinsics.checkNotNull(entity2);
                if (EntityUtils.isFeedType(entity2.getEntityType())) {
                    Feed feed = (Feed) this.entity;
                    Intrinsics.checkNotNull(feed);
                    this.modelInfo = feed.toString();
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://www.coolapk.com");
                    String url2 = feed.getUrl();
                    Intrinsics.checkNotNull(url2);
                    sb.append(url2);
                    this.url = sb.toString();
                    this.status = feed.getStatus();
                    this.recommend = feed.getRecommend();
                    this.statusText = feed.getStatusText();
                    this.messageStatus = feed.getMessageStatus();
                    this.messageStatusText = feed.getMessageStatusText();
                    this.blockStatus = feed.getBlockStatus();
                    this.blockStatusText = feed.getBlockStatusText();
                    String str2 = "否";
                    this.isHeadline = feed.getIsHeadline() == 0 ? str2 : "是";
                    if (feed.getIsHeadlineV8() != 0) {
                        str2 = "是";
                    }
                    this.isHeadlineV8 = str2;
                    this.uid = feed.getUid();
                    this.userAgent = feed.getUseragent();
                } else {
                    FeedReply feedReply = (FeedReply) this.entity;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("https://www.coolapk.com/feed/");
                    Intrinsics.checkNotNull(feedReply);
                    sb2.append(feedReply.getFeedId());
                    sb2.append("?rid=");
                    sb2.append(feedReply.getId());
                    this.url = sb2.toString();
                    this.modelInfo = feedReply.toString();
                    this.status = feedReply.getStatus();
                    this.uid = feedReply.getUid();
                    this.statusText = feedReply.getStatusText();
                    this.messageStatus = feedReply.getMessageStatus();
                    this.messageStatusText = feedReply.getMessageStatusText();
                    this.blockStatus = feedReply.getBlockStatus();
                    this.blockStatusText = feedReply.getBlockStatusText();
                    this.isHeadline = str;
                }
            }
            if (!TextUtils.isEmpty(this.userAgent)) {
                str = "userAgent: " + this.userAgent;
            }
            String str3 = this.url + "\nuid:" + this.uid + "\nrecommend:" + this.recommend + "\nstatus:" + this.statusText + '(' + this.status + ")\nmessageStatus:" + this.messageStatusText + '(' + this.messageStatus + ")\nblockStatus:" + this.blockStatusText + '(' + this.blockStatus + ")\nisHeadline:" + this.isHeadline + "\nisHeadlineV8:" + this.isHeadlineV8 + '\n' + str;
            AlertDialog create = new AlertDialog.Builder(getActivity()).setTitle("状态值").setMessage(str3).setPositiveButton("确定", (DialogInterface.OnClickListener) null).setNeutralButton("复制信息", new FeedItemDialog$InfoDialogFragment$onCreateDialog$1(this, str3)).setNegativeButton("详细信息", new FeedItemDialog$InfoDialogFragment$onCreateDialog$2(this)).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
            return create;
        }

        /* compiled from: FeedItemDialog.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final InfoDialogFragment newInstance(String str, String str2, String str3, String str4) {
                Bundle bundle = new Bundle();
                bundle.putString("url", str);
                bundle.putString("status", str2);
                bundle.putString("messageStatus", str3);
                bundle.putString("blockStatus", str4);
                InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
                infoDialogFragment.setArguments(bundle);
                return infoDialogFragment;
            }

            public final InfoDialogFragment newInstance(Entity entity) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("entity", entity);
                InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
                infoDialogFragment.setArguments(bundle);
                return infoDialogFragment;
            }
        }
    }
}
