package com.coolapk.market.view.album;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.DialogAlbumitemNoteBinding;
import com.coolapk.market.event.AlbumItemEditEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

public class EditDialog extends BaseDialogFragment implements View.OnClickListener {
    private static final String KEY_ALBUM_ITEM = "ALBUMITEM";
    private AlbumItem albumItem;
    private DialogAlbumitemNoteBinding binding;
    private AlbumItemViewModel mAlbumItemViewModel;
    private String mNote;

    public static EditDialog newInstance(AlbumItem albumItem2) {
        EditDialog editDialog = new EditDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ALBUMITEM", albumItem2);
        editDialog.setArguments(bundle);
        return editDialog;
    }

    public void setViewModel(AlbumItemViewModel albumItemViewModel) {
        this.mAlbumItemViewModel = albumItemViewModel;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.albumItem = (AlbumItem) getArguments().getParcelable("ALBUMITEM");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        DialogAlbumitemNoteBinding dialogAlbumitemNoteBinding = (DialogAlbumitemNoteBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558517, null, false);
        this.binding = dialogAlbumitemNoteBinding;
        dialogAlbumitemNoteBinding.dialogTitleView.setText(this.albumItem.getTitle());
        this.binding.apkNoteEditView.setText(this.mAlbumItemViewModel.getNote());
        this.binding.apkNoteEditView.setSelection(this.binding.apkNoteEditView.getText().toString().length());
        this.binding.ok.setTextColor(AppHolder.getAppTheme().getColorAccent());
        AppHolder.getFragmentImageLoader().displayImage(this, this.albumItem.getLogoUrl(), this.binding.albumItemLogo, 2131689481);
        ViewUtil.clickListener(this.binding.ok, this);
        ViewUtil.clickListener(this.binding.cacel, this);
        return builder.setView(this.binding.getRoot()).create();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131362195) {
            dismiss();
        } else if (id == 2131363050) {
            this.mNote = this.binding.apkNoteEditView.getText().toString();
            final AlbumItem build = AlbumItem.newBuilder(this.albumItem).setNote(this.mNote).build();
            this.binding.progressBar.setVisibility(0);
            this.binding.ok.setVisibility(4);
            DataManager.getInstance().addApkToAlbum(build).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
                /* class com.coolapk.market.view.album.EditDialog.AnonymousClass1 */

                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                public void onError(Throwable th) {
                    Toast.error(EditDialog.this.getActivity(), th);
                    EditDialog.this.binding.progressBar.setVisibility(8);
                    EditDialog.this.binding.ok.setVisibility(0);
                }

                public void onNext(Result<String> result) {
                    if (result.getData() != null) {
                        EditDialog.this.mAlbumItemViewModel.setNote(EditDialog.this.mNote);
                        EventBus.getDefault().post(new AlbumItemEditEvent(build, "note"));
                        EditDialog.this.dismiss();
                    } else if (!TextUtils.isEmpty(result.getMessage())) {
                        EditDialog.this.binding.progressBar.setVisibility(8);
                        EditDialog.this.binding.ok.setVisibility(0);
                        Toast.show(EditDialog.this.getActivity(), result.getMessage());
                    }
                }
            });
        }
    }
}
