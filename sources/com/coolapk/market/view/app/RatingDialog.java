package com.coolapk.market.view.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RatingBar;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.ItemAppViewRatingBinding;
import com.coolapk.market.util.RxLogin;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.app.AppViewContract;
import com.coolapk.market.widget.MinimumWidthDialog;
import rx.Subscriber;

public class RatingDialog extends MinimumWidthDialog {
    private AppViewContract.Presenter presenter;
    private AppViewViewModel viewModel;

    public static RatingDialog newInstance() {
        Bundle bundle = new Bundle();
        RatingDialog ratingDialog = new RatingDialog();
        ratingDialog.setArguments(bundle);
        return ratingDialog;
    }

    public void setViewModel(AppViewViewModel appViewViewModel) {
        this.viewModel = appViewViewModel;
    }

    public void setPresenter(AppViewContract.Presenter presenter2) {
        this.presenter = presenter2;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ItemAppViewRatingBinding itemAppViewRatingBinding = (ItemAppViewRatingBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558611, null, false);
        itemAppViewRatingBinding.setViewModel(this.viewModel);
        ThemeUtils.setRatingBarColor(itemAppViewRatingBinding.ratingBar);
        itemAppViewRatingBinding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            /* class com.coolapk.market.view.app.RatingDialog.AnonymousClass1 */

            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar, final float f, boolean z) {
                if (z) {
                    RxLogin.getInstance(RatingDialog.this.getActivity()).requestLogin().subscribe((Subscriber<? super Boolean>) new Subscriber<Boolean>() {
                        /* class com.coolapk.market.view.app.RatingDialog.AnonymousClass1.AnonymousClass1 */

                        @Override // rx.Observer
                        public void onCompleted() {
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th) {
                        }

                        public void onNext(Boolean bool) {
                            if (bool.booleanValue() && RatingDialog.this.viewModel.getServiceApp() != null) {
                                int i = (int) f;
                                int myScore = RatingDialog.this.viewModel.getMyScore();
                                RatingDialog.this.viewModel.setMyScore(i);
                                if (i > 0) {
                                    RatingDialog.this.presenter.ratingApp(RatingDialog.this.viewModel.getServiceApp().getApkId(), i, myScore);
                                } else {
                                    RatingDialog.this.presenter.unratingApp(RatingDialog.this.viewModel.getServiceApp().getApkId(), myScore);
                                }
                            }
                        }
                    });
                }
            }
        });
        return new AlertDialog.Builder(getActivity()).setView(itemAppViewRatingBinding.getRoot()).create();
    }
}
