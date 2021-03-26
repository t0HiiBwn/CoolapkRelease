package com.coolapk.market.view.video;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.UserKeyInputBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/video/UserKeyInputFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/UserKeyInputBinding;", "checkInputKeyAndType", "", "key", "", "type", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserKeyInputFragment.kt */
public final class UserKeyInputFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_CODE = "EXTRA_CODE";
    public static final String EXTRA_TYPE = "EXTRA_URL";
    private UserKeyInputBinding binding;

    public static final /* synthetic */ UserKeyInputBinding access$getBinding$p(UserKeyInputFragment userKeyInputFragment) {
        UserKeyInputBinding userKeyInputBinding = userKeyInputFragment.binding;
        if (userKeyInputBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return userKeyInputBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/video/UserKeyInputFragment$Companion;", "", "()V", "EXTRA_CODE", "", "EXTRA_TYPE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserKeyInputFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559292, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…_input, container, false)");
        UserKeyInputBinding userKeyInputBinding = (UserKeyInputBinding) inflate;
        this.binding = userKeyInputBinding;
        if (userKeyInputBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = userKeyInputBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("EXTRA_URL") : null;
        String str2 = "";
        if (string == null) {
            string = str2;
        }
        UserKeyInputBinding userKeyInputBinding = this.binding;
        if (userKeyInputBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userKeyInputBinding.getRoot().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        UserKeyInputBinding userKeyInputBinding2 = this.binding;
        if (userKeyInputBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userKeyInputBinding2.actionConfirm.setOnClickListener(new UserKeyInputFragment$onActivityCreated$1(this, string));
        if (string.hashCode() == -1796610084 && string.equals("shareVideo")) {
            UserKeyInputBinding userKeyInputBinding3 = this.binding;
            if (userKeyInputBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = userKeyInputBinding3.hintView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
            textView.setText("·抱歉，分享视频功能暂处于内测阶段，需要邀请码才可开启\n·此功能很快就将开放给所有用户，没有邀请码的用户请静等功能开放");
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("EXTRA_CODE");
        }
        if (str != null) {
            str2 = str;
        }
        String str3 = str2;
        if (str3.length() > 0) {
            UserKeyInputBinding userKeyInputBinding4 = this.binding;
            if (userKeyInputBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userKeyInputBinding4.editText.setText(str3);
            UserKeyInputBinding userKeyInputBinding5 = this.binding;
            if (userKeyInputBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userKeyInputBinding5.actionConfirm.performClick();
        }
    }

    /* access modifiers changed from: private */
    public final void checkInputKeyAndType(String str, String str2) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在验证...");
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
        DataManager.getInstance().pingRequest().compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new UserKeyInputFragment$checkInputKeyAndType$1(this, progressDialog, str2, str));
    }
}
