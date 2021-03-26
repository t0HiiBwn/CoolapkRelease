package com.coolapk.market.view.feed;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.style.URLSpan;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.feed.FeedItemDialog;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rx.Observable;
import rx.Subscriber;

/* compiled from: FeedReplyItemDialog.kt */
public final class FeedReplyItemDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private FeedActionPresenter mPresenter = FeedActionPresenter.getInstance();
    private Function1<? super FeedReply, Unit> viewReplyCallback;

    public static final FeedReplyItemDialog newInstance(FeedReply feedReply, URLSpan[] uRLSpanArr) {
        return Companion.newInstance(feedReply, uRLSpanArr);
    }

    public final FeedActionPresenter getMPresenter$presentation_coolapkAppRelease() {
        return this.mPresenter;
    }

    public final void setMPresenter$presentation_coolapkAppRelease(FeedActionPresenter feedActionPresenter) {
        this.mPresenter = feedActionPresenter;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.coolapk.market.model.FeedReply, kotlin.Unit>, kotlin.jvm.functions.Function1<com.coolapk.market.model.FeedReply, kotlin.Unit> */
    public final Function1<FeedReply, Unit> getViewReplyCallback() {
        return this.viewReplyCallback;
    }

    public final void setViewReplyCallback(Function1<? super FeedReply, Unit> function1) {
        this.viewReplyCallback = function1;
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        requireArguments().getParcelableArrayList("urlspan");
        FeedReply feedReply = (FeedReply) requireArguments().getParcelable("reply");
        if (feedReply != null) {
            Intrinsics.checkNotNullExpressionValue(feedReply, "requireArguments().getPa…Reply>(\"reply\") ?: return");
            updateDataList(new FeedReplyItemDialog$onActivityCreated$1(this, feedReply));
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class CancelReportSpamActionItem extends ActionItem {
        private final FeedReply feed;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CancelReportSpamActionItem(FeedReplyItemDialog feedReplyItemDialog, FeedReply feedReply) {
            super("取消举报屏蔽", null, 2, null);
            Intrinsics.checkNotNullParameter(feedReply, "feed");
            this.this$0 = feedReplyItemDialog;
            this.feed = feedReply;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().cancelReportSpam(this.feed.getId(), this.feed.getEntityType()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedReplyItemDialog$CancelReportSpamActionItem$takeAction$1(this));
        }
    }

    public final MultiActionItem buildAdminActionItem(FeedReply feedReply) {
        return new MultiActionItem("管理", new FeedReplyItemDialog$buildAdminActionItem$1(this, feedReply));
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class HomePagePYActionItem extends ActionItem {
        private boolean mAdd;
        private FeedReply mFeed;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomePagePYActionItem(FeedReplyItemDialog feedReplyItemDialog, boolean z, FeedReply feedReply) {
            super(z ? "上头条" : "下头条", null, 2, null);
            Intrinsics.checkNotNullParameter(feedReply, "mFeed");
            this.this$0 = feedReplyItemDialog;
            this.mAdd = z;
            this.mFeed = feedReply;
        }

        public final boolean getMAdd$presentation_coolapkAppRelease() {
            return this.mAdd;
        }

        public final FeedReply getMFeed$presentation_coolapkAppRelease() {
            return this.mFeed;
        }

        public final void setMAdd$presentation_coolapkAppRelease(boolean z) {
            this.mAdd = z;
        }

        public final void setMFeed$presentation_coolapkAppRelease(FeedReply feedReply) {
            Intrinsics.checkNotNullParameter(feedReply, "<set-?>");
            this.mFeed = feedReply;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.mAdd)).flatMap(new FeedReplyItemDialog$HomePagePYActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedReplyItemDialog$HomePagePYActionItem$takeAction$2());
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class RefuseActionItem extends ActionItem {
        private final FeedReply feedReply;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RefuseActionItem(FeedReplyItemDialog feedReplyItemDialog, FeedReply feedReply2) {
            super("驳回", null, 2, null);
            Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
            this.this$0 = feedReplyItemDialog;
            this.feedReply = feedReply2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().refuseSpamFeedReply(this.feedReply.getId(), this.feedReply.getSpamTime()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedReplyItemDialog$RefuseActionItem$takeAction$1(this));
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class BannedActionItem extends ActionItem {
        private final FeedReply feedReply;
        private boolean isSet;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BannedActionItem(FeedReplyItemDialog feedReplyItemDialog, boolean z, FeedReply feedReply2) {
            super(z ? "取消屏蔽" : "屏蔽/禁止访问", null, 2, null);
            Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
            this.this$0 = feedReplyItemDialog;
            this.isSet = z;
            this.feedReply = feedReply2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_BANNED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feedReply, 2, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消屏蔽此回复？" : "确定要屏蔽此回复？", z ? "取消屏蔽后，将恢复成正常的回复" : "屏蔽后禁止访问，等同于删除，但不会真正删除数据");
            newInstance.setAction(this.feedReply, 2, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_BANNED", true).apply();
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class DetailViewActionItem extends ActionItem {
        private final FeedReply feedReply;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DetailViewActionItem(FeedReplyItemDialog feedReplyItemDialog, String str, FeedReply feedReply2) {
            super(str, null, 2, null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.this$0 = feedReplyItemDialog;
            this.feedReply = feedReply2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (this.feedReply != null) {
                if (this.this$0.getViewReplyCallback() == null) {
                    ActionManager.startFeedReplyDetailActivity(this.this$0.getActivity(), this.feedReply);
                    return;
                }
                Function1<FeedReply, Unit> viewReplyCallback = this.this$0.getViewReplyCallback();
                if (viewReplyCallback != null) {
                    viewReplyCallback.invoke(this.feedReply);
                }
            }
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class StatusActionItem extends ActionItem {
        private final FeedReply feedReply;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StatusActionItem(FeedReplyItemDialog feedReplyItemDialog, FeedReply feedReply2) {
            super("查看状态", null, 2, null);
            Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
            this.this$0 = feedReplyItemDialog;
            this.feedReply = feedReply2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            FeedItemDialog.InfoDialogFragment newInstance = FeedItemDialog.InfoDialogFragment.Companion.newInstance(this.feedReply);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class PrivateActionItem extends ActionItem {
        private final FeedReply feedReply;
        private boolean isSet;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrivateActionItem(FeedReplyItemDialog feedReplyItemDialog, boolean z, FeedReply feedReply2) {
            super(z ? "取消仅作者可见" : "仅作者自己可见", null, 2, null);
            Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
            this.this$0 = feedReplyItemDialog;
            this.isSet = z;
            this.feedReply = feedReply2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_PRIVATE", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feedReply, 0, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定取消仅作者可见？" : "确定要设为仅作者可见?", z ? "取消后，将恢复成正常回复" : "内容只显示在作者主页，通过作者主页可以访问");
            newInstance.setAction(this.feedReply, 0, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_PRIVATE", true).apply();
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class FoldedActionItem extends ActionItem {
        private final FeedReply feedReply;
        private boolean isSet;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FoldedActionItem(FeedReplyItemDialog feedReplyItemDialog, boolean z, FeedReply feedReply2) {
            super(z ? "取消折叠" : "折叠/不在公共区域显示", null, 2, null);
            Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
            this.this$0 = feedReplyItemDialog;
            this.isSet = z;
            this.feedReply = feedReply2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_FLODED", false)) {
                ConfirmFeedBlockDialog.executeAction(this.feedReply, 1, this.isSet, this.this$0.getActivity());
                return;
            }
            boolean z = this.isSet;
            ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消折叠此回复？" : "确定要折叠此回复？", z ? "取消折叠后将恢复成正常的回复" : "折叠后不在公共区域显示，但还会显示在粉丝的好友圈");
            newInstance.setAction(this.feedReply, 1, this.isSet, this.this$0.getActivity());
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_FLODED", true).apply();
        }
    }

    public final MultiActionItem buildMultiActionItem(FeedReply feedReply) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) requireArguments().getParcelableArrayList("urlspan");
        if (objectRef.element == null) {
            objectRef.element = (T) CollectionsKt.emptyList();
        }
        String string = getString(2131886121);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.action_copy)");
        return new MultiActionItem(string, new FeedReplyItemDialog$buildMultiActionItem$1(this, feedReply, objectRef));
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public final class DeleteActionItem extends ActionItem {
        private final FeedReply mFeedReply;
        final /* synthetic */ FeedReplyItemDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteActionItem(FeedReplyItemDialog feedReplyItemDialog, String str, FeedReply feedReply) {
            super(str, null, 2, null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(feedReply, "mFeedReply");
            this.this$0 = feedReplyItemDialog;
            this.mFeedReply = feedReply;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            String string = this.this$0.getString(2131886784);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_delete_title)");
            String string2 = this.this$0.getString(2131886781, this.mFeedReply.getUserName(), this.mFeedReply.getMessage());
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_d…Name, mFeedReply.message)");
            ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(string, string2);
            newInstance.setDeleteTarget(this.mFeedReply);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    /* compiled from: FeedReplyItemDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedReplyItemDialog newInstance(FeedReply feedReply, URLSpan[] uRLSpanArr) {
            Intrinsics.checkNotNullParameter(feedReply, "reply");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (uRLSpanArr != null) {
                if (!(uRLSpanArr.length == 0)) {
                    arrayList.addAll(Arrays.asList((URLSpan[]) Arrays.copyOf(uRLSpanArr, uRLSpanArr.length)));
                }
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("urlspan", arrayList);
            bundle.putParcelable("reply", feedReply);
            FeedReplyItemDialog feedReplyItemDialog = new FeedReplyItemDialog();
            feedReplyItemDialog.setArguments(bundle);
            return feedReplyItemDialog;
        }
    }
}
