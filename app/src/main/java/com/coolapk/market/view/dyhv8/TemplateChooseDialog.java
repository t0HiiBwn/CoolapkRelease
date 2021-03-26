package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/dyhv8/TemplateChooseDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "action", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "TemplateAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TemplateChooseDialog.kt */
public final class TemplateChooseDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private String action;
    private DyhArticle dyhArticle;

    public static final /* synthetic */ String access$getAction$p(TemplateChooseDialog templateChooseDialog) {
        String str = templateChooseDialog.action;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        }
        return str;
    }

    public static final /* synthetic */ DyhArticle access$getDyhArticle$p(TemplateChooseDialog templateChooseDialog) {
        DyhArticle dyhArticle2 = templateChooseDialog.dyhArticle;
        if (dyhArticle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        return dyhArticle2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/TemplateChooseDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/dyhv8/TemplateChooseDialog;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "action", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TemplateChooseDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TemplateChooseDialog newInstance(DyhArticle dyhArticle, String str) {
            Intrinsics.checkNotNullParameter(dyhArticle, "dyhArticle");
            Intrinsics.checkNotNullParameter(str, "action");
            Bundle bundle = new Bundle();
            bundle.putParcelable("DYH_ARTICLE", dyhArticle);
            bundle.putString("DYH_ARTICLE_ACTION", str);
            TemplateChooseDialog templateChooseDialog = new TemplateChooseDialog();
            templateChooseDialog.setArguments(bundle);
            return templateChooseDialog;
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Parcelable parcelable = requireArguments().getParcelable("DYH_ARTICLE");
        Intrinsics.checkNotNull(parcelable);
        this.dyhArticle = (DyhArticle) parcelable;
        String string = requireArguments().getString("DYH_ARTICLE_ACTION");
        Intrinsics.checkNotNull(string);
        this.action = string;
        updateDataList(new TemplateChooseDialog$onActivityCreated$1(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/dyhv8/TemplateChooseDialog$TemplateAction;", "Lcom/coolapk/market/view/base/ActionItem;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "title", "", "actionString", "(Lcom/coolapk/market/view/dyhv8/TemplateChooseDialog;Lcom/coolapk/market/model/DyhArticle;Ljava/lang/String;Ljava/lang/String;)V", "getDyhArticle", "()Lcom/coolapk/market/model/DyhArticle;", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TemplateChooseDialog.kt */
    public final class TemplateAction extends ActionItem {
        private final String actionString;
        private final DyhArticle dyhArticle;
        final /* synthetic */ TemplateChooseDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TemplateAction(TemplateChooseDialog templateChooseDialog, DyhArticle dyhArticle2, String str, String str2) {
            super(str, null, 2, null);
            Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "actionString");
            this.this$0 = templateChooseDialog;
            this.dyhArticle = dyhArticle2;
            this.actionString = str2;
        }

        public final DyhArticle getDyhArticle() {
            return this.dyhArticle;
        }

        @Override // com.coolapk.market.view.base.ActionItem
        public void takeAction() {
            String str = this.actionString;
            int hashCode = str.hashCode();
            if (hashCode != -1362871922) {
                if (hashCode == -421681106 && str.equals("HomePage")) {
                    DataManager.getInstance().articleAddToHeadlineV8(this.dyhArticle.getId(), getTitle()).map(RxUtils.checkResult()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe(new TemplateChooseDialog$TemplateAction$takeAction$1(this), new TemplateChooseDialog$TemplateAction$takeAction$2(this));
                }
            } else if (str.equals("EditorChoice")) {
                DataManager.getInstance().articleAddToEditorChoice(this.dyhArticle.getId(), getTitle()).map(RxUtils.checkResult()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe(new TemplateChooseDialog$TemplateAction$takeAction$3(this), new TemplateChooseDialog$TemplateAction$takeAction$4(this));
            }
        }
    }
}
