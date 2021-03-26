package com.coolapk.market.view.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.FetchGiftBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.MinimumWidthDialog;
import com.coolapk.market.widget.Toast;
import rx.Subscriber;
import rx.Subscription;

public class FetchGiftDialog extends MinimumWidthDialog implements View.OnClickListener {
    private static final String KEY_APP = "APP";
    private static final String KEY_GIFT = "GIFT_ID";
    private FetchGiftBinding binding;
    private Gift gift;
    private ServiceApp serviceApp;
    private Subscription subscription;

    public static FetchGiftDialog newInstance(Gift gift2, ServiceApp serviceApp2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("GIFT_ID", gift2);
        bundle.putParcelable("APP", serviceApp2);
        FetchGiftDialog fetchGiftDialog = new FetchGiftDialog();
        fetchGiftDialog.setArguments(bundle);
        return fetchGiftDialog;
    }

    public static FetchGiftDialog newInstance(Gift gift2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("GIFT_ID", gift2);
        FetchGiftDialog fetchGiftDialog = new FetchGiftDialog();
        fetchGiftDialog.setArguments(bundle);
        return fetchGiftDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gift = (Gift) getArguments().getParcelable("GIFT_ID");
        this.serviceApp = (ServiceApp) getArguments().getParcelable("APP");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        FetchGiftBinding fetchGiftBinding = (FetchGiftBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558567, null, false);
        this.binding = fetchGiftBinding;
        ViewUtil.clickListener(fetchGiftBinding.copyView, this);
        ViewUtil.clickListener(this.binding.myGiftView, this);
        ViewUtil.clickListener(this.binding.downloadGameView, this);
        if (PackageUtils.isInstalled(getActivity(), this.gift.getApkName())) {
            this.binding.downloadGameView.setText(getString(2131886142));
        } else if (this.serviceApp != null) {
            this.binding.downloadGameView.setText(getString(2131886128));
        } else {
            this.binding.downloadGameView.setText(getString(2131886159));
        }
        return new AlertDialog.Builder(getActivity()).setView(this.binding.getRoot()).create();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.subscription = DataManager.getInstance().getGift(this.gift.getId()).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
            /* class com.coolapk.market.view.app.FetchGiftDialog.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(FetchGiftDialog.this.getActivity(), th);
                FetchGiftDialog.this.dismissAllowingStateLoss();
            }

            public void onNext(Result<String> result) {
                FetchGiftDialog.this.binding.setKey(result.getData());
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null && !subscription2.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
        super.onDestroyView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131362335) {
            StringUtils.copyText(getActivity(), this.binding.getKey());
            Toast.show(getActivity(), 2131887252);
        } else if (id != 2131362425) {
            if (id == 2131363010) {
                ActionManager.startUserGiftCenterActivity(getActivity(), DataManager.getInstance().getLoginSession().getUid());
            }
        } else if (this.serviceApp != null) {
            if (!PackageUtils.isInstalled(getActivity(), this.serviceApp.getPackageName())) {
                ActionManager.startDownload(getActivity(), this.serviceApp, 0);
                Toast.show(getActivity(), getString(2131886505));
                return;
            }
            ActionManager.openApp(getActivity(), this.serviceApp.getPackageName());
        } else if (PackageUtils.isInstalled(getActivity(), this.gift.getApkName())) {
            ActionManager.openApp(getActivity(), this.gift.getApkName());
        } else {
            ActionManager.startAppViewActivity(getActivity(), this.gift.getApkName());
        }
    }
}
