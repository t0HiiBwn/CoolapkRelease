package com.coolapk.market.view.feed;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feed/CancelFollowItemDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "entity", "Lcom/coolapk/market/model/Entity;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "CancelFollowActionItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CancelFollowItemDialog.kt */
public final class CancelFollowItemDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private Entity entity;

    @JvmStatic
    public static final CancelFollowItemDialog newInstance(Entity entity2) {
        return Companion.newInstance(entity2);
    }

    public static final /* synthetic */ Entity access$getEntity$p(CancelFollowItemDialog cancelFollowItemDialog) {
        Entity entity2 = cancelFollowItemDialog.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        return entity2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feed/CancelFollowItemDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/CancelFollowItemDialog;", "entity", "Lcom/coolapk/market/model/Entity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CancelFollowItemDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CancelFollowItemDialog newInstance(Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Bundle bundle = new Bundle();
            bundle.putParcelable("entity", entity);
            CancelFollowItemDialog cancelFollowItemDialog = new CancelFollowItemDialog();
            cancelFollowItemDialog.setArguments(bundle);
            return cancelFollowItemDialog;
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Entity entity2 = (Entity) requireArguments().getParcelable("entity");
        if (entity2 != null) {
            this.entity = entity2;
            updateDataList(new CancelFollowItemDialog$onActivityCreated$1(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feed/CancelFollowItemDialog$CancelFollowActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "id", "", "type", "(Lcom/coolapk/market/view/feed/CancelFollowItemDialog;Ljava/lang/String;Ljava/lang/String;)V", "getId$presentation_coolapkAppRelease", "()Ljava/lang/String;", "setId$presentation_coolapkAppRelease", "(Ljava/lang/String;)V", "getType$presentation_coolapkAppRelease", "setType$presentation_coolapkAppRelease", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CancelFollowItemDialog.kt */
    private final class CancelFollowActionItem extends ActionItem {
        private String id;
        final /* synthetic */ CancelFollowItemDialog this$0;
        private String type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CancelFollowActionItem(CancelFollowItemDialog cancelFollowItemDialog, String str, String str2) {
            super("取消关注", null, 2, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "type");
            this.this$0 = cancelFollowItemDialog;
            this.id = str;
            this.type = str2;
        }

        public final String getId$presentation_coolapkAppRelease() {
            return this.id;
        }

        public final String getType$presentation_coolapkAppRelease() {
            return this.type;
        }

        public final void setId$presentation_coolapkAppRelease(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final void setType$presentation_coolapkAppRelease(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要取消关注吗？", "确定", "取消");
            newInstance.setOnOkRunnable(new CancelFollowItemDialog$CancelFollowActionItem$takeAction$1(this));
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
    }
}
