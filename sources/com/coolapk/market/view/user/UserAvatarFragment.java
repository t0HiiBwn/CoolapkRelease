package com.coolapk.market.view.user;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.UserAvatarBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ClearCacheHelper;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010$\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/view/user/UserAvatarFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/coolapk/market/view/base/BaseActivity$OnBackPressListener;", "()V", "mBinding", "Lcom/coolapk/market/databinding/UserAvatarBinding;", "mCropOutFile", "Ljava/io/File;", "mPostRequest", "", "checkAndUpload", "", "checkPermissionAndPick", "compressAndCrop", "sourcePath", "", "hasImage", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackKeyPressed", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onUploadSucceed", "avatar", "AlertDialogFragment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserAvatarFragment.kt */
public final class UserAvatarFragment extends BaseFragment implements View.OnClickListener, BaseActivity.OnBackPressListener {
    private UserAvatarBinding mBinding;
    private File mCropOutFile;
    private boolean mPostRequest;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559290, viewGroup, false, new FragmentBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ntBindingComponent(this))");
        UserAvatarBinding userAvatarBinding = (UserAvatarBinding) inflate;
        this.mBinding = userAvatarBinding;
        if (userAvatarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        ViewUtil.clickListener(userAvatarBinding.pickButton, this);
        UserAvatarBinding userAvatarBinding2 = this.mBinding;
        if (userAvatarBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        userAvatarBinding2.setAvatar(loginSession.getUserAvatar());
        UserAvatarBinding userAvatarBinding3 = this.mBinding;
        if (userAvatarBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        userAvatarBinding3.executePendingBindings();
        UserAvatarBinding userAvatarBinding4 = this.mBinding;
        if (userAvatarBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return userAvatarBinding4.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.base.BaseActivity");
        ((BaseActivity) activity).setOnBackPressListener(this);
        super.onActivityCreated(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (view.getId() == 2131363117) {
            checkPermissionAndPick();
        }
    }

    private final void checkAndUpload() {
        if (!hasImage()) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Toast.show(requireActivity, 2131886705);
        } else if (!this.mPostRequest) {
            this.mPostRequest = true;
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(0);
            progressDialog.setCancelable(false);
            progressDialog.setMessage(getString(2131886709));
            progressDialog.show();
            DataManager.getInstance().changeAvatar(this.mCropOutFile).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new UserAvatarFragment$checkAndUpload$1(this, progressDialog));
        }
    }

    private final boolean hasImage() {
        return this.mCropOutFile != null;
    }

    private final void checkPermissionAndPick() {
        ActionManager.startPhotoPickerActivity(this, 1, (List<String>) null);
    }

    /* access modifiers changed from: private */
    public final void onUploadSucceed(String str) {
        File file = this.mCropOutFile;
        Intrinsics.checkNotNull(file);
        file.delete();
        this.mCropOutFile = null;
        ClearCacheHelper.newClearCacheTask("clear_all").observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super Object>) new UserAvatarFragment$onUploadSucceed$1(this, str));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            if (i == 3925) {
                String path = BitmapUtil.getPath(getActivity(), intent.getData());
                if (TextUtils.isEmpty(path)) {
                    Toast.show$default(getActivity(), "无法读取图片", 0, false, 12, null);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(path, "path");
                compressAndCrop(path);
            } else if (i == 69) {
                try {
                    File file = this.mCropOutFile;
                    Intrinsics.checkNotNull(file);
                    if (file.exists()) {
                        File file2 = this.mCropOutFile;
                        Intrinsics.checkNotNull(file2);
                        if (file2.length() > 0) {
                            UserAvatarBinding userAvatarBinding = this.mBinding;
                            if (userAvatarBinding == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                            }
                            Intrinsics.checkNotNull(userAvatarBinding);
                            userAvatarBinding.setAvatar(Uri.fromFile(this.mCropOutFile).toString());
                            checkAndUpload();
                            return;
                        }
                    }
                    FragmentActivity requireActivity = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    Toast.show(requireActivity, 2131886707);
                } catch (Exception e) {
                    e.printStackTrace();
                    FragmentActivity requireActivity2 = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                    Toast.show(requireActivity2, 2131886707);
                }
            }
        }
    }

    private final void compressAndCrop(String str) {
        DialogUtil dialogUtil = DialogUtil.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Dialog showProgressDialog = dialogUtil.showProgressDialog(requireActivity, "正在处理...", false);
        BitmapUtil.compressImage(getActivity(), CoolFileUtils.wrap(str), 0).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new UserAvatarFragment$compressAndCrop$1(showProgressDialog)).subscribe((Subscriber<? super R>) new UserAvatarFragment$compressAndCrop$2(this, BitmapUtil.generateFileOutputPath(getActivity(), str + ".bak")));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        File file = this.mCropOutFile;
        if (file != null) {
            Intrinsics.checkNotNull(file);
            if (file.exists()) {
                File file2 = this.mCropOutFile;
                Intrinsics.checkNotNull(file2);
                file2.delete();
            }
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.base.BaseActivity");
        ((BaseActivity) activity).setOnBackPressListener(null);
    }

    @Override // com.coolapk.market.view.base.BaseActivity.OnBackPressListener
    public boolean onBackKeyPressed() {
        if (!hasImage()) {
            return false;
        }
        AlertDialogFragment newInstance = AlertDialogFragment.Companion.newInstance();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        newInstance.show(childFragmentManager, (String) null);
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/user/UserAvatarFragment$AlertDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserAvatarFragment.kt */
    public static final class AlertDialogFragment extends BaseDialogFragment {
        public static final Companion Companion = new Companion(null);

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog create = new AlertDialog.Builder(requireActivity()).setMessage(requireActivity().getString(2131886704)).setPositiveButton(requireActivity().getString(2131886703), new UserAvatarFragment$AlertDialogFragment$onCreateDialog$1(this)).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
            return create;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/user/UserAvatarFragment$AlertDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/user/UserAvatarFragment$AlertDialogFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: UserAvatarFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final AlertDialogFragment newInstance() {
                Bundle bundle = new Bundle();
                AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
                alertDialogFragment.setArguments(bundle);
                return alertDialogFragment;
            }
        }
    }
}
