package com.coolapk.market.view.album;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogAlbumCreateBinding;
import com.coolapk.market.event.AlbumEditEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

public class AlbumCreateDialog extends BaseDialogFragment {
    private static final String KEY_ALBUMID = "ALBUMID";
    private static final String KEY_INTRO = "ALBUMINTRO";
    private static final String KEY_ITEM = "ALBUMITEM";
    private static final String KEY_TITLE = "ALBUMTITLE";
    private String albumId;
    private String albumIntro;
    private AlbumItem albumItem;
    private String albumTitle;
    private Subscription createSubscription;
    private Subscription editSubscription;
    private String id;
    private EditText intro;
    private boolean isEdit;
    private AlbumDetailViewModel mAlbumDetailViewModel;
    private EditText titleView;

    public static AlbumCreateDialog newInstance() {
        AlbumCreateDialog albumCreateDialog = new AlbumCreateDialog();
        albumCreateDialog.setArguments(new Bundle());
        return albumCreateDialog;
    }

    public static AlbumCreateDialog newInstance(AlbumItem albumItem2) {
        AlbumCreateDialog albumCreateDialog = new AlbumCreateDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ALBUMITEM", albumItem2);
        albumCreateDialog.setArguments(bundle);
        return albumCreateDialog;
    }

    public static AlbumCreateDialog newInstance(String str, String str2, String str3) {
        AlbumCreateDialog albumCreateDialog = new AlbumCreateDialog();
        Bundle bundle = new Bundle();
        bundle.putString("ALBUMID", str);
        bundle.putString("ALBUMTITLE", str2);
        bundle.putString("ALBUMINTRO", str3);
        albumCreateDialog.setArguments(bundle);
        return albumCreateDialog;
    }

    public void setViewModel(AlbumDetailViewModel albumDetailViewModel) {
        this.mAlbumDetailViewModel = albumDetailViewModel;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        RxUtils.unsubscribe(this.createSubscription);
        RxUtils.unsubscribe(this.editSubscription);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        DialogAlbumCreateBinding dialogAlbumCreateBinding = (DialogAlbumCreateBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558515, null, false);
        this.titleView = dialogAlbumCreateBinding.titleEditText;
        TextView textView = dialogAlbumCreateBinding.dialogTitleView;
        this.intro = dialogAlbumCreateBinding.introEditText;
        dialogAlbumCreateBinding.titleInputLayout.setHintTextColor(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        dialogAlbumCreateBinding.introInputLayout.setHintTextColor(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        TextView textView2 = dialogAlbumCreateBinding.dialogConfirm;
        TextView textView3 = dialogAlbumCreateBinding.dialogCancel;
        this.id = getArguments().getString("ALBUMID");
        this.albumItem = (AlbumItem) getArguments().getParcelable("ALBUMITEM");
        if (!TextUtils.isEmpty(this.id)) {
            this.isEdit = true;
            this.albumTitle = this.mAlbumDetailViewModel.getAlbumTitle();
            this.albumIntro = this.mAlbumDetailViewModel.getAlbumIntro();
            textView.setText(getString(2131886636));
            this.titleView.setText(this.albumTitle);
            this.intro.setText(this.albumIntro);
            if (!TextUtils.isEmpty(this.albumTitle) && !TextUtils.isEmpty(this.albumIntro)) {
                this.titleView.setSelection(this.albumTitle.length());
                this.intro.setSelection(this.albumIntro.length());
            }
        }
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        textView2.setTextColor(colorAccent);
        textView3.setTextColor(colorAccent);
        EditText editText = dialogAlbumCreateBinding.introInputLayout.getEditText();
        EditText editText2 = dialogAlbumCreateBinding.titleInputLayout.getEditText();
        TintHelper.setCursorTint(editText, colorAccent);
        TintHelper.setCursorTint(editText2, colorAccent);
        ViewUtil.clickListener(textView2, new View.OnClickListener() {
            /* class com.coolapk.market.view.album.$$Lambda$AlbumCreateDialog$QA39eOI5IkZLeEE_kDudRBvND0 */

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlbumCreateDialog.this.lambda$onCreateDialog$2$AlbumCreateDialog(view);
            }
        });
        ViewUtil.clickListener(textView3, new View.OnClickListener() {
            /* class com.coolapk.market.view.album.AlbumCreateDialog.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlbumCreateDialog.this.getDialog().dismiss();
            }
        });
        builder.setView(dialogAlbumCreateBinding.getRoot());
        builder.setCancelable(true);
        return builder.create();
    }

    public /* synthetic */ void lambda$onCreateDialog$2$AlbumCreateDialog(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(true);
        if (!this.isEdit) {
            progressDialog.setMessage(getString(2131886777));
        } else {
            progressDialog.setMessage(getString(2131886641));
        }
        progressDialog.show();
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.coolapk.market.view.album.$$Lambda$AlbumCreateDialog$mPsA71LFCqqK98Ht82MG1prcsU */

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                AlbumCreateDialog.this.lambda$null$0$AlbumCreateDialog(dialogInterface);
            }
        });
        this.albumTitle = this.titleView.getText().toString();
        this.albumIntro = this.intro.getText().toString();
        if (TextUtils.isEmpty(this.albumTitle) || TextUtils.isEmpty(this.albumIntro)) {
            Toast.show(getActivity(), getString(2131886638));
            progressDialog.dismiss();
        } else if (!this.isEdit) {
            this.createSubscription = DataManager.getInstance().createAlbum(this.albumTitle, this.albumIntro).map(RxUtils.checkResult()).flatMap(new Func1() {
                /* class com.coolapk.market.view.album.$$Lambda$AlbumCreateDialog$duEtJglImJiXquEs64VbYAPwdZc */

                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return AlbumCreateDialog.this.lambda$null$1$AlbumCreateDialog((Result) obj);
                }
            }).compose(RxUtils.apiCommon()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
                /* class com.coolapk.market.view.album.AlbumCreateDialog.AnonymousClass1 */

                @Override // rx.Observer
                public void onCompleted() {
                    progressDialog.dismiss();
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    progressDialog.dismiss();
                    Toast.error(AlbumCreateDialog.this.getActivity(), th);
                }

                public void onNext(Result<String> result) {
                    AlbumCreateDialog.this.dismiss();
                    ActionManager.startV8AlbumDetailActivity(AlbumCreateDialog.this.getActivity(), AlbumCreateDialog.this.albumId);
                }
            });
        } else {
            this.editSubscription = DataManager.getInstance().editAlbum(this.id, this.albumTitle, this.albumIntro).compose(RxUtils.apiCommon()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
                /* class com.coolapk.market.view.album.AlbumCreateDialog.AnonymousClass2 */

                @Override // rx.Observer
                public void onCompleted() {
                    progressDialog.dismiss();
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    progressDialog.dismiss();
                    Toast.error(AlbumCreateDialog.this.getActivity(), th);
                }

                public void onNext(Result<String> result) {
                    AlbumCreateDialog.this.mAlbumDetailViewModel.setAlbumTitle(AlbumCreateDialog.this.albumTitle);
                    AlbumCreateDialog.this.mAlbumDetailViewModel.setAlbumIntro(AlbumCreateDialog.this.albumIntro);
                    EventBus.getDefault().post(new AlbumEditEvent(AlbumCreateDialog.this.id, AlbumCreateDialog.this.albumTitle, AlbumCreateDialog.this.albumIntro));
                    AlbumCreateDialog.this.dismiss();
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$0$AlbumCreateDialog(DialogInterface dialogInterface) {
        if (this.isEdit) {
            RxUtils.unsubscribe(this.editSubscription);
        } else {
            RxUtils.unsubscribe(this.createSubscription);
        }
    }

    public /* synthetic */ Observable lambda$null$1$AlbumCreateDialog(Result result) {
        this.albumId = (String) result.getData();
        if (this.albumItem != null) {
            return DataManager.getInstance().addApkToAlbum(this.albumId, this.albumItem.getPackageName(), this.albumItem.getTitle(), this.albumItem.getUrl(), this.albumItem.getNote(), -1, this.albumItem.getLogoUrl());
        }
        return DataManager.getInstance().editAlbum(this.albumId, this.albumTitle, this.albumIntro);
    }
}
