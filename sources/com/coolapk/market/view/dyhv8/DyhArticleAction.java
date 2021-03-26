package com.coolapk.market.view.dyhv8;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.widget.MinimumWidthDialog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00112\u00020\u0001:\r\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "mPresenter", "Lcom/coolapk/market/view/dyhv8/DyhActionPresenter;", "kotlin.jvm.PlatformType", "buildAdminActionItem", "Lcom/coolapk/market/view/base/MultiActionItem;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "buildMultiActionItem", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "AddHomePagAction", "BlockAction", "Companion", "DeleteAction", "EditorChoiceActionItem", "InfoDialogFragment", "RecommendAction", "RemoveFromCollectionAction", "SoftRemoveAction", "StarAction", "StatusActionItem", "TopAction", "TopCollectionAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleAction.kt */
public final class DyhArticleAction extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_KEY = "DYH_ARTICLE";
    public static final String EXTRA_KEY_ACTION = "DYH_ARTICLE_ACTION";
    private final DyhActionPresenter mPresenter = DyhActionPresenter.getInstance();

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        DyhArticle dyhArticle = (DyhArticle) requireArguments().getParcelable("DYH_ARTICLE");
        if (dyhArticle != null) {
            Intrinsics.checkNotNullExpressionValue(dyhArticle, "requireArguments().getPa…cle>(EXTRA_KEY) ?: return");
            updateDataList(new DyhArticleAction$onActivityCreated$1(this, dyhArticle));
        }
    }

    /* access modifiers changed from: private */
    public final MultiActionItem buildMultiActionItem(DyhArticle dyhArticle) {
        String string = getString(2131886121);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.action_copy)");
        return new MultiActionItem(string, new DyhArticleAction$buildMultiActionItem$item$1(this, dyhArticle));
    }

    /* access modifiers changed from: private */
    public final MultiActionItem buildAdminActionItem(DyhArticle dyhArticle) {
        return new MultiActionItem("管理", new DyhArticleAction$buildAdminActionItem$item$1(this, dyhArticle));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$StarAction;", "Lcom/coolapk/market/view/base/ActionItem;", "isStar", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;ZLcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class StarAction extends ActionItem {
        private final DyhArticle dyhArticle;
        private final boolean isStar;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StarAction(DyhArticleAction dyhArticleAction, boolean z, DyhArticle dyhArticle2) {
            super(z ? "已收藏" : "收藏", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.isStar = z;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            ActionManager.startCollectionSelectActivity(this.this$0.getActivity(), this.dyhArticle.getId(), "article");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$TopAction;", "Lcom/coolapk/market/view/base/ActionItem;", "isTop", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;ZLcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class TopAction extends ActionItem {
        private final DyhArticle dyhArticle;
        private final boolean isTop;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TopAction(DyhArticleAction dyhArticleAction, boolean z, DyhArticle dyhArticle2) {
            super(z ? "取消置顶" : "置顶", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.isTop = z;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.isTop)).flatMap(new DyhArticleAction$TopAction$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new DyhArticleAction$TopAction$takeAction$2(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$RecommendAction;", "Lcom/coolapk/market/view/base/ActionItem;", "isRecommend", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;ZLcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class RecommendAction extends ActionItem {
        private final DyhArticle dyhArticle;
        private final boolean isRecommend;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RecommendAction(DyhArticleAction dyhArticleAction, boolean z, DyhArticle dyhArticle2) {
            super(z ? "取消推荐" : "上推荐", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.isRecommend = z;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.isRecommend)).flatMap(new DyhArticleAction$RecommendAction$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new DyhArticleAction$RecommendAction$takeAction$2());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$AddHomePagAction;", "Lcom/coolapk/market/view/base/ActionItem;", "isMultiSelect", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;ZLcom/coolapk/market/model/DyhArticle;)V", "()Z", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class AddHomePagAction extends ActionItem {
        private final DyhArticle dyhArticle;
        private final boolean isMultiSelect;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddHomePagAction(DyhArticleAction dyhArticleAction, boolean z, DyhArticle dyhArticle2) {
            super(z ? "上头条" : "下头条", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.isMultiSelect = z;
            this.dyhArticle = dyhArticle2;
        }

        protected final boolean isMultiSelect() {
            return this.isMultiSelect;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            boolean z = this.isMultiSelect;
            if (z) {
                TemplateChooseDialog newInstance = TemplateChooseDialog.Companion.newInstance(this.dyhArticle, "HomePage");
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                newInstance.show(childFragmentManager, (String) null);
                return;
            }
            Observable.just(Boolean.valueOf(z)).flatMap(new DyhArticleAction$AddHomePagAction$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new DyhArticleAction$AddHomePagAction$takeAction$2(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$EditorChoiceActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "isRecommend", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;ZLcom/coolapk/market/model/DyhArticle;)V", "isMultiSelect", "()Z", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class EditorChoiceActionItem extends ActionItem {
        private final DyhArticle dyhArticle;
        private final boolean isRecommend;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EditorChoiceActionItem(DyhArticleAction dyhArticleAction, boolean z, DyhArticle dyhArticle2) {
            super(z ? "取消精选" : "上编辑精选", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.isRecommend = z;
            this.dyhArticle = dyhArticle2;
        }

        protected final boolean isMultiSelect() {
            return !this.isRecommend;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            boolean z = this.isRecommend;
            if (!z) {
                TemplateChooseDialog newInstance = TemplateChooseDialog.Companion.newInstance(this.dyhArticle, "EditorChoice");
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                newInstance.show(childFragmentManager, (String) null);
                return;
            }
            Observable.just(Boolean.valueOf(z)).flatMap(new DyhArticleAction$EditorChoiceActionItem$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new DyhArticleAction$EditorChoiceActionItem$takeAction$2());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$BlockAction;", "Lcom/coolapk/market/view/base/ActionItem;", "isBlock", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;ZLcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class BlockAction extends ActionItem {
        private final DyhArticle dyhArticle;
        private final boolean isBlock;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BlockAction(DyhArticleAction dyhArticleAction, boolean z, DyhArticle dyhArticle2) {
            super(z ? "取消屏蔽" : "屏蔽/禁止访问", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.isBlock = z;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            Observable.just(Boolean.valueOf(this.isBlock)).flatMap(new DyhArticleAction$BlockAction$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new DyhArticleAction$BlockAction$takeAction$2());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$DeleteAction;", "Lcom/coolapk/market/view/base/ActionItem;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;Lcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class DeleteAction extends ActionItem {
        private final DyhArticle dyhArticle;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteAction(DyhArticleAction dyhArticleAction, DyhArticle dyhArticle2) {
            super("从看看号移除", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            this.this$0.mPresenter.onArticleRemove(this.dyhArticle).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new DyhArticleAction$DeleteAction$takeAction$1(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$SoftRemoveAction;", "Lcom/coolapk/market/view/base/ActionItem;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;Lcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class SoftRemoveAction extends ActionItem {
        private final DyhArticle dyhArticle;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SoftRemoveAction(DyhArticleAction dyhArticleAction, DyhArticle dyhArticle2) {
            super("去精/不在精选区显示", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager.getInstance().articleSoftRemove(this.dyhArticle.getId(), this.dyhArticle.getEntityTemplate()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new DyhArticleAction$SoftRemoveAction$takeAction$1());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$StatusActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;Lcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class StatusActionItem extends ActionItem {
        private final DyhArticle dyhArticle;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StatusActionItem(DyhArticleAction dyhArticleAction, DyhArticle dyhArticle2) {
            super("查看状态", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            InfoDialogFragment newInstance = InfoDialogFragment.Companion.newInstance(this.dyhArticle);
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$TopCollectionAction;", "Lcom/coolapk/market/view/base/ActionItem;", "isTop", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;ZLcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class TopCollectionAction extends ActionItem {
        private final DyhArticle dyhArticle;
        private final boolean isTop;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TopCollectionAction(DyhArticleAction dyhArticleAction, boolean z, DyhArticle dyhArticle2) {
            super(z ? "取消置顶" : "置顶", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.isTop = z;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager instance = DataManager.getInstance();
            CollectionItem collectionItem = this.dyhArticle.getCollectionItem();
            Intrinsics.checkNotNull(collectionItem);
            Intrinsics.checkNotNullExpressionValue(collectionItem, "dyhArticle.collectionItem!!");
            instance.topCollectionItem(collectionItem.getId(), !this.isTop ? 1 : 0).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new DyhArticleAction$TopCollectionAction$takeAction$1(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$RemoveFromCollectionAction;", "Lcom/coolapk/market/view/base/ActionItem;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "(Lcom/coolapk/market/view/dyhv8/DyhArticleAction;Lcom/coolapk/market/model/DyhArticle;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public final class RemoveFromCollectionAction extends ActionItem {
        private final DyhArticle dyhArticle;
        final /* synthetic */ DyhArticleAction this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RemoveFromCollectionAction(DyhArticleAction dyhArticleAction, DyhArticle dyhArticle2) {
            super("从收藏单移除", null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            this.this$0 = dyhArticleAction;
            this.dyhArticle = dyhArticle2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            DataManager instance = DataManager.getInstance();
            CollectionItem collectionItem = this.dyhArticle.getCollectionItem();
            Intrinsics.checkNotNull(collectionItem);
            Intrinsics.checkNotNullExpressionValue(collectionItem, "dyhArticle.collectionItem!!");
            instance.removeCollectionItem(collectionItem.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new DyhArticleAction$RemoveFromCollectionAction$takeAction$1(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$InfoDialogFragment;", "Lcom/coolapk/market/widget/MinimumWidthDialog;", "()V", "blockStatus", "", "blockStatusText", "", "entity", "Lcom/coolapk/market/model/Entity;", "isHeadline", "isHeadlineV8", "messageStatus", "messageStatusText", "modelInfo", "recommend", "status", "statusText", "uid", "url", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
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

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            Entity entity2 = (Entity) requireArguments().getParcelable("entity");
            this.entity = entity2;
            if (entity2 != null) {
                Intrinsics.checkNotNull(entity2);
                if (EntityUtils.isDyhArticleType(entity2.getEntityType())) {
                    Entity entity3 = this.entity;
                    Objects.requireNonNull(entity3, "null cannot be cast to non-null type com.coolapk.market.model.DyhArticle");
                    DyhArticle dyhArticle = (DyhArticle) entity3;
                    this.modelInfo = dyhArticle.toString();
                    this.url = "https://www.coolapk.com" + dyhArticle.getUrl();
                    this.status = dyhArticle.getStatus();
                    this.recommend = dyhArticle.getRecommend();
                    this.statusText = dyhArticle.getStatusText();
                    this.messageStatus = dyhArticle.getMessageStatus();
                    this.messageStatusText = dyhArticle.getMessageStatusText();
                    this.blockStatus = dyhArticle.getBlockStatus();
                    this.blockStatusText = dyhArticle.getBlockStatusText();
                    String str = "否";
                    this.isHeadline = dyhArticle.getIsHeadline() == 0 ? str : "是";
                    if (dyhArticle.getIsHeadlineV8() != 0) {
                        str = "是";
                    }
                    this.isHeadlineV8 = str;
                    this.uid = dyhArticle.getUid();
                }
            }
            AlertDialog.Builder title = new AlertDialog.Builder(getActivity()).setTitle("状态值");
            AlertDialog create = title.setMessage(this.url + "\nuid:" + this.uid + "\nrecommend:" + this.recommend + "\nstatus:" + this.statusText + "(" + this.status + ")\nmessageStatus:" + this.messageStatusText + "(" + this.messageStatus + ")\nblockStatus:" + this.blockStatusText + "(" + this.blockStatus + ")\nisHeadline:" + this.isHeadline + "\nisHeadlineV8:" + this.isHeadlineV8).setPositiveButton("确定", (DialogInterface.OnClickListener) null).setNegativeButton("详细信息", new DyhArticleAction$InfoDialogFragment$onCreateDialog$1(this)).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
            return create;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$InfoDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/dyhv8/DyhArticleAction$InfoDialogFragment;", "entity", "Lcom/coolapk/market/model/Entity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: DyhArticleAction.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleAction$Companion;", "", "()V", "EXTRA_KEY", "", "EXTRA_KEY_ACTION", "newInstance", "Lcom/coolapk/market/view/dyhv8/DyhArticleAction;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DyhArticleAction newInstance(DyhArticle dyhArticle) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DYH_ARTICLE", dyhArticle);
            DyhArticleAction dyhArticleAction = new DyhArticleAction();
            dyhArticleAction.setArguments(bundle);
            return dyhArticleAction;
        }
    }
}
