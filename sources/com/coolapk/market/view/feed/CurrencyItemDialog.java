package com.coolapk.market.view.feed;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

/* compiled from: CurrencyItemDialog.kt */
public final class CurrencyItemDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private FeedActionPresenter mPresenter = FeedActionPresenter.getInstance();

    public static final CurrencyItemDialog newInstance(Entity entity) {
        return Companion.newInstance(entity);
    }

    public final FeedActionPresenter getMPresenter$presentation_coolapkAppRelease() {
        return this.mPresenter;
    }

    public final void setMPresenter$presentation_coolapkAppRelease(FeedActionPresenter feedActionPresenter) {
        this.mPresenter = feedActionPresenter;
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Entity entity = (Entity) requireArguments().getParcelable("entity");
        if (entity != null) {
            Intrinsics.checkNotNullExpressionValue(entity, "requireArguments().getPa…tity>(\"entity\") ?: return");
            updateDataList(new CurrencyItemDialog$onActivityCreated$1(this, entity));
        }
    }

    /* compiled from: CurrencyItemDialog.kt */
    public final class CancelReportSpamActionItem extends ActionItem {
        private final Entity entity;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CancelReportSpamActionItem(Entity entity2) {
            super("取消举报屏蔽", null, 2, null);
            CurrencyItemDialog.this = r3;
            this.entity = entity2;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            if (this.entity != null) {
                DataManager.getInstance().cancelReportSpam(this.entity.getEntityId(), "user").compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new CurrencyItemDialog$CancelReportSpamActionItem$takeAction$1(this));
            }
        }
    }

    /* compiled from: CurrencyItemDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CurrencyItemDialog newInstance(Entity entity) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("entity", entity);
            CurrencyItemDialog currencyItemDialog = new CurrencyItemDialog();
            currencyItemDialog.setArguments(bundle);
            return currencyItemDialog;
        }
    }
}
