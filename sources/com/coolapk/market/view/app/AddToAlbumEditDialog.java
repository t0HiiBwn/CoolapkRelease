package com.coolapk.market.view.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.AddToAlbumEditBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.AddToAlbumEditContract;
import com.coolapk.market.widget.MinimumWidthDialog;
import com.coolapk.market.widget.Toast;
import rx.Subscriber;

public class AddToAlbumEditDialog extends MinimumWidthDialog implements AddToAlbumEditContract.View {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private AddToAlbumEditBinding binding;
    private int displayOrder;
    private String note;
    private AddToAlbumEditContract.Presenter presenter;

    public static AddToAlbumEditDialog newInstance(Album album, ServiceApp serviceApp, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("album", album);
        bundle.putParcelable("serviceApp", serviceApp);
        bundle.putInt("displayOrder", i);
        AddToAlbumEditDialog addToAlbumEditDialog = new AddToAlbumEditDialog();
        addToAlbumEditDialog.setArguments(bundle);
        return addToAlbumEditDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new AddToAlbumEditPresenter(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.presenter.cancelAddToAlbum();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final Album album = (Album) getArguments().getParcelable("album");
        final ServiceApp serviceApp = (ServiceApp) getArguments().getParcelable("serviceApp");
        this.displayOrder = getArguments().getInt("displayOrder");
        View inflate = LayoutInflater.from(getActivity()).inflate(2131558437, (ViewGroup) null, false);
        AddToAlbumEditBinding addToAlbumEditBinding = (AddToAlbumEditBinding) DataBindingUtil.bind(inflate);
        this.binding = addToAlbumEditBinding;
        addToAlbumEditBinding.setLoading(this.presenter.isInSubmit());
        final EditText editText = this.binding.editText;
        DataManager.getInstance().checkApkIsInAlbum(album.getAlbumId(), serviceApp.getPackageName()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<AlbumItem>>() {
            /* class com.coolapk.market.view.app.AddToAlbumEditDialog.AnonymousClass1 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(AddToAlbumEditDialog.this.getActivity(), th);
            }

            public void onNext(Result<AlbumItem> result) {
                super.onNext((AnonymousClass1) result);
                if (result != null && result.getData() != null) {
                    editText.getText().append((CharSequence) result.getData().getNote());
                    UiUtils.openKeyboard(editText);
                    EditText editText = editText;
                    editText.setSelection(editText.getText().toString().length());
                }
            }
        });
        this.binding.submitView.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.app.AddToAlbumEditDialog.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddToAlbumEditDialog.this.presenter.addToAlbum(album.getAlbumId(), serviceApp.getPackageName(), serviceApp.getAppName(), serviceApp.getApkUrl(), editText.getText().toString(), AddToAlbumEditDialog.this.displayOrder, serviceApp.getLogo());
            }
        });
        this.binding.cacelView.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.app.AddToAlbumEditDialog.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddToAlbumEditDialog.this.dismiss();
            }
        });
        return new AlertDialog.Builder(getActivity()).setTitle(album.getTitle()).setView(inflate).create();
    }

    @Override // com.coolapk.market.view.app.AddToAlbumEditContract.View
    public void onAddToAlbumComplete(Throwable th) {
        this.binding.setLoading(this.presenter.isInSubmit());
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        Toast.show(getActivity(), 2131887212);
        dismiss();
    }
}
