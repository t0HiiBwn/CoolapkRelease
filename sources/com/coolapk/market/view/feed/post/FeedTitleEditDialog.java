package com.coolapk.market.view.feed.post;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.DialogEditSubmitBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0015H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0011\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/feed/post/FeedTitleEditDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "abstract", "", "getAbstract", "()Ljava/lang/String;", "abstract$delegate", "Lkotlin/Lazy;", "binding", "Lcom/coolapk/market/databinding/DialogEditSubmitBinding;", "callback", "Lkotlin/Function1;", "", "content", "getContent", "content$delegate", "feedId", "getFeedId", "feedId$delegate", "isPosting", "", "dismiss", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "pasteAbstract", "post", "setErrorText", "message", "setLoadingState", "loading", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedTitleEditDialog.kt */
public final class FeedTitleEditDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy abstract$delegate = LazyKt.lazy(new FeedTitleEditDialog$abstract$2(this));
    private DialogEditSubmitBinding binding;
    private Function1<? super String, Unit> callback;
    private final Lazy content$delegate = LazyKt.lazy(new FeedTitleEditDialog$content$2(this));
    private final Lazy feedId$delegate = LazyKt.lazy(new FeedTitleEditDialog$feedId$2(this));
    private boolean isPosting;

    private final String getAbstract() {
        return (String) this.abstract$delegate.getValue();
    }

    private final String getContent() {
        return (String) this.content$delegate.getValue();
    }

    private final String getFeedId() {
        return (String) this.feedId$delegate.getValue();
    }

    public static final /* synthetic */ DialogEditSubmitBinding access$getBinding$p(FeedTitleEditDialog feedTitleEditDialog) {
        DialogEditSubmitBinding dialogEditSubmitBinding = feedTitleEditDialog.binding;
        if (dialogEditSubmitBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return dialogEditSubmitBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/post/FeedTitleEditDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/post/FeedTitleEditDialog;", "feedId", "", "title", "content", "abstract", "postCallback", "Lkotlin/Function1;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedTitleEditDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedTitleEditDialog newInstance(String str, String str2, String str3, String str4, Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(str, "feedId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "content");
            Intrinsics.checkNotNullParameter(str4, "abstract");
            FeedTitleEditDialog feedTitleEditDialog = new FeedTitleEditDialog();
            Bundle bundle = new Bundle();
            bundle.putString("feedId", str);
            bundle.putString("title", str2);
            bundle.putString("content", str3);
            bundle.putString("abstract", str4);
            Unit unit = Unit.INSTANCE;
            feedTitleEditDialog.setArguments(bundle);
            feedTitleEditDialog.callback = function1;
            return feedTitleEditDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558524, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…edit_submit, null, false)");
        this.binding = (DialogEditSubmitBinding) inflate;
        AlertDialog.Builder title = new AlertDialog.Builder(requireActivity()).setTitle("");
        DialogEditSubmitBinding dialogEditSubmitBinding = this.binding;
        if (dialogEditSubmitBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = title.setView(dialogEditSubmitBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String string = requireArguments().getString("title");
        if (string == null) {
            string = "";
        }
        DialogEditSubmitBinding dialogEditSubmitBinding = this.binding;
        if (dialogEditSubmitBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogEditSubmitBinding.editText.append(getContent());
        DialogEditSubmitBinding dialogEditSubmitBinding2 = this.binding;
        if (dialogEditSubmitBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = dialogEditSubmitBinding2.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(string);
        DialogEditSubmitBinding dialogEditSubmitBinding3 = this.binding;
        if (dialogEditSubmitBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = dialogEditSubmitBinding3.cancelButton;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.cancelButton");
        ViewExtendsKt.setUtilClickListener(textView2, new FeedTitleEditDialog$onActivityCreated$1(this));
        DialogEditSubmitBinding dialogEditSubmitBinding4 = this.binding;
        if (dialogEditSubmitBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = dialogEditSubmitBinding4.okButton;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.okButton");
        ViewExtendsKt.setUtilClickListener(textView3, new FeedTitleEditDialog$onActivityCreated$2(this));
        DialogEditSubmitBinding dialogEditSubmitBinding5 = this.binding;
        if (dialogEditSubmitBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView4 = dialogEditSubmitBinding5.pasteButton;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.pasteButton");
        ViewExtendsKt.setUtilClickListener(textView4, new FeedTitleEditDialog$onActivityCreated$3(this));
        DialogEditSubmitBinding dialogEditSubmitBinding6 = this.binding;
        if (dialogEditSubmitBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogEditSubmitBinding6.editText.postDelayed(new FeedTitleEditDialog$onActivityCreated$4(this), 100);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (!this.isPosting) {
            super.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void pasteAbstract() {
        if (getAbstract().length() == 0) {
            Toast.show$default(getActivity(), "没有摘要", 0, false, 12, null);
            return;
        }
        DialogEditSubmitBinding dialogEditSubmitBinding = this.binding;
        if (dialogEditSubmitBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogEditSubmitBinding.editText.append(getAbstract());
    }

    /* access modifiers changed from: private */
    public final void post() {
        if (!this.isPosting) {
            setLoadingState(true);
            this.isPosting = true;
            DialogEditSubmitBinding dialogEditSubmitBinding = this.binding;
            if (dialogEditSubmitBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = dialogEditSubmitBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            String obj = editText.getText().toString();
            DataManager.getInstance().updateEditorTitle(getFeedId(), obj).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedTitleEditDialog$post$1(this, obj));
        }
    }

    /* access modifiers changed from: private */
    public final void setErrorText(String str) {
        String str2 = str;
        if (str2.length() > 0) {
            DialogEditSubmitBinding dialogEditSubmitBinding = this.binding;
            if (dialogEditSubmitBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = dialogEditSubmitBinding.errorView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.errorView");
            textView.setText(str2);
            DialogEditSubmitBinding dialogEditSubmitBinding2 = this.binding;
            if (dialogEditSubmitBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = dialogEditSubmitBinding2.errorView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.errorView");
            textView2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void setLoadingState(boolean z) {
        if (z) {
            DialogEditSubmitBinding dialogEditSubmitBinding = this.binding;
            if (dialogEditSubmitBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar = dialogEditSubmitBinding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
            progressBar.setVisibility(0);
            DialogEditSubmitBinding dialogEditSubmitBinding2 = this.binding;
            if (dialogEditSubmitBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = dialogEditSubmitBinding2.okButton;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
            textView.setVisibility(4);
            DialogEditSubmitBinding dialogEditSubmitBinding3 = this.binding;
            if (dialogEditSubmitBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = dialogEditSubmitBinding3.errorView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.errorView");
            textView2.setVisibility(8);
            return;
        }
        DialogEditSubmitBinding dialogEditSubmitBinding4 = this.binding;
        if (dialogEditSubmitBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar2 = dialogEditSubmitBinding4.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.progressBar");
        progressBar2.setVisibility(8);
        DialogEditSubmitBinding dialogEditSubmitBinding5 = this.binding;
        if (dialogEditSubmitBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = dialogEditSubmitBinding5.okButton;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.okButton");
        textView3.setVisibility(0);
    }
}
